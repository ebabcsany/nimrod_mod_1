package com.babcsany.minecraft.nimrod_mod_1.entity;

import com.babcsany.minecraft.nimrod_mod_1.init.EntityInit;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.boss.dragon.EnderDragonPartEntity;
import net.minecraft.entity.boss.dragon.phase.IPhase;
import net.minecraft.entity.boss.dragon.phase.PhaseManager;
import net.minecraft.entity.boss.dragon.phase.PhaseType;
import net.minecraft.entity.item.EnderCrystalEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathHeap;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.potion.EffectInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.end.DragonFightManager;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.EndPodiumFeature;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.List;

public class QwertrtttEntity extends MobEntity implements IMob {
   private static final Logger LOGGER = LogManager.getLogger();
   public static final DataParameter<Integer> PHASE = EntityDataManager.createKey(QwertrtttEntity.class, DataSerializers.VARINT);
   private static final EntityPredicate PLAYER_INVADER_CONDITION = (new EntityPredicate()).setDistance(64.0D);
   public final double[][] ringBuffer = new double[64][3];
   public int ringBufferIndex = -1;
   private final QwertrtttPartEntity[] dragonParts;
   public final QwertrtttPartEntity dragonPartHead;
   private final QwertrtttPartEntity dragonPartNeck;
   private final QwertrtttPartEntity dragonPartBody;
   private final QwertrtttPartEntity dragonPartTail1;
   private final QwertrtttPartEntity dragonPartTail2;
   private final QwertrtttPartEntity dragonPartTail3;
   private final QwertrtttPartEntity dragonPartRightWing;
   private final QwertrtttPartEntity dragonPartLeftWing;
   public float prevAnimTime;
   public float animTime;
   public boolean slowed;
   public int deathTicks;
   public float field_226525_bB_;
   @Nullable
   public EnderCrystalEntity closestEnderCrystal;
   private int growlTime = 100;
   private int sittingDamageReceived;
   private final PathPoint[] pathPoints = new PathPoint[24];
   private final int[] neighbors = new int[24];
   private final PathHeap pathFindQueue = new PathHeap();

   public QwertrtttEntity(EntityType<? extends QwertrtttEntity> type, World worldIn) {
      super(EntityInit.QWERTRTTT.get(), worldIn);
      this.dragonPartHead = new QwertrtttPartEntity(this, "head", 1.0F, 1.0F);
      this.dragonPartNeck = new QwertrtttPartEntity(this, "neck", 3.0F, 3.0F);
      this.dragonPartBody = new QwertrtttPartEntity(this, "body", 5.0F, 3.0F);
      this.dragonPartTail1 = new QwertrtttPartEntity(this, "tail", 2.0F, 2.0F);
      this.dragonPartTail2 = new QwertrtttPartEntity(this, "tail", 2.0F, 2.0F);
      this.dragonPartTail3 = new QwertrtttPartEntity(this, "tail", 2.0F, 2.0F);
      this.dragonPartRightWing = new QwertrtttPartEntity(this, "wing", 4.0F, 2.0F);
      this.dragonPartLeftWing = new QwertrtttPartEntity(this, "wing", 4.0F, 2.0F);
      this.dragonParts = new QwertrtttPartEntity[]{this.dragonPartHead, this.dragonPartNeck, this.dragonPartBody, this.dragonPartTail1, this.dragonPartTail2, this.dragonPartTail3, this.dragonPartRightWing, this.dragonPartLeftWing};
      this.setHealth(this.getMaxHealth());
      this.noClip = true;
      this.ignoreFrustumCheck = true;
   }

   public static AttributeModifierMap.MutableAttribute registerAttributes() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 900000000000000000000000000000000000000000000000000000000000000000000000000000000.0D);
   }

   protected void registerData() {
      super.registerData();
      this.getDataManager().register(PHASE, PhaseType.HOVER.getId());
   }

   /**
    * Returns a double[3] array with movement offsets, used to calculate trailing tail/neck positions. [0] = yaw offset,
    * [1] = y offset, [2] = unused, always 0. Parameters: buffer index offset, partial ticks.
    */
   public double[] getMovementOffsets(int p_70974_1_, float partialTicks) {
      if (this.getShouldBeDead()) {
         partialTicks = 0.0F;
      }

      partialTicks = 1.0F - partialTicks;
      int i = this.ringBufferIndex - p_70974_1_ & 63;
      int j = this.ringBufferIndex - p_70974_1_ - 1 & 63;
      double[] adouble = new double[3];
      double d0 = this.ringBuffer[i][0];
      double d1 = MathHelper.wrapDegrees(this.ringBuffer[j][0] - d0);
      adouble[0] = d0 + d1 * (double)partialTicks;
      d0 = this.ringBuffer[i][1];
      d1 = this.ringBuffer[j][1] - d0;
      adouble[1] = d0 + d1 * (double)partialTicks;
      adouble[2] = MathHelper.lerp((double)partialTicks, this.ringBuffer[i][2], this.ringBuffer[j][2]);
      return adouble;
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
    * use this to react to sunlight and start to burn.
    */

   private void setPartPosition(QwertrtttPartEntity part, double offsetX, double offsetY, double offsetZ) {
      part.setPosition(this.getPosX() + offsetX, this.getPosY() + offsetY, this.getPosZ() + offsetZ);
   }

   /**
    * Updates the state of the enderdragon's current endercrystal.
    */
   private void updateDragonEnderCrystal() {
      if (this.closestEnderCrystal != null) {
         if (this.closestEnderCrystal.removed) {
            this.closestEnderCrystal = null;
         } else if (this.ticksExisted % 10 == 0 && this.getHealth() < this.getMaxHealth()) {
            this.setHealth(this.getHealth() + 1.0F);
         }
      }

      if (this.rand.nextInt(10) == 0) {
         List<EnderCrystalEntity> list = this.world.getEntitiesWithinAABB(EnderCrystalEntity.class, this.getBoundingBox().grow(32.0D));
         EnderCrystalEntity endercrystalentity = null;
         double d0 = Double.MAX_VALUE;

         for(EnderCrystalEntity endercrystalentity1 : list) {
            double d1 = endercrystalentity1.getDistanceSq(this);
            if (d1 < d0) {
               d0 = d1;
               endercrystalentity = endercrystalentity1;
            }
         }

         this.closestEnderCrystal = endercrystalentity;
      }

   }

   /**
    * Attacks all entities inside this list, dealing 5 hearts of damage.
    */
   private void attackEntitiesInList(List<Entity> entities) {
      for(Entity entity : entities) {
         if (entity instanceof LivingEntity) {
            entity.attackEntityFrom(DamageSource.causeMobDamage(this), 10.0F);
            this.applyEnchantments(this, entity);
         }
      }

   }

   /**
    * Simplifies the value of a number by adding/subtracting 180 to the point that the number is between -180 and 180.
    */
   private float simplifyAngle(double angle) {
      return (float)MathHelper.wrapDegrees(angle);
   }

   /**
    * Destroys all blocks that aren't associated with 'The End' inside the given bounding box.
    */
   private boolean destroyBlocksInAABB(AxisAlignedBB area) {
      int i = MathHelper.floor(area.minX);
      int j = MathHelper.floor(area.minY);
      int k = MathHelper.floor(area.minZ);
      int l = MathHelper.floor(area.maxX);
      int i1 = MathHelper.floor(area.maxY);
      int j1 = MathHelper.floor(area.maxZ);
      boolean flag = false;
      boolean flag1 = false;

      for(int k1 = i; k1 <= l; ++k1) {
         for(int l1 = j; l1 <= i1; ++l1) {
            for(int i2 = k; i2 <= j1; ++i2) {
               BlockPos blockpos = new BlockPos(k1, l1, i2);
               BlockState blockstate = this.world.getBlockState(blockpos);
               Block block = blockstate.getBlock();
               if (!blockstate.isAir(this.world, blockpos) && blockstate.getMaterial() != Material.FIRE) {
                  if (net.minecraftforge.common.ForgeHooks.canEntityDestroy(this.world, blockpos, this) && !BlockTags.DRAGON_IMMUNE.contains(block)) {
                     flag1 = this.world.removeBlock(blockpos, false) || flag1;
                  } else {
                     flag = true;
                  }
               }
            }
         }
      }

      if (flag1) {
         BlockPos blockpos1 = new BlockPos(i + this.rand.nextInt(l - i + 1), j + this.rand.nextInt(i1 - j + 1), k + this.rand.nextInt(j1 - k + 1));
         this.world.playEvent(2008, blockpos1, 0);
      }

      return flag;
   }

   /**
    * Provides a way to cause damage to an ender dragon.
    */
   protected boolean attackDragonFrom(DamageSource source, float amount) {
      return super.attackEntityFrom(source, amount);
   }

   /**
    * Called by the /kill command.
    */
   public void onKillCommand() {
      this.remove();
   }

   /**
    * handles entity death timer, experience orb and particle creation
    */
   protected void onDeathUpdate() {

      ++this.deathTicks;
      if (this.deathTicks >= 180 && this.deathTicks <= 200) {
         float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
         float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
         float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
         this.world.addParticle(ParticleTypes.EXPLOSION_EMITTER, this.getPosX() + (double)f, this.getPosY() + 2.0D + (double)f1, this.getPosZ() + (double)f2, 0.0D, 0.0D, 0.0D);
      }

      boolean flag = this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT);
      int i = 500;

      if (!this.world.isRemote) {
         if (this.deathTicks > 150 && this.deathTicks % 5 == 0 && flag) {
            this.dropExperience(MathHelper.floor((float)i * 0.08F));
         }

         if (this.deathTicks == 1 && !this.isSilent()) {
            this.world.playBroadcastSound(1028, this.getPosition(), 0);
         }
      }

      this.move(MoverType.SELF, new Vector3d(0.0D, (double)0.1F, 0.0D));
      this.rotationYaw += 20.0F;
      this.renderYawOffset = this.rotationYaw;
      if (this.deathTicks == 200 && !this.world.isRemote) {
         if (flag) {
            this.dropExperience(MathHelper.floor((float)i * 0.2F));
         }

         this.remove();
      }

   }

   private void dropExperience(int xp) {
      while(xp > 0) {
         int i = ExperienceOrbEntity.getXPSplit(xp);
         xp -= i;
         this.world.addEntity(new ExperienceOrbEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), i));
      }

   }

   /**
    * Generates values for the fields pathPoints, and neighbors, and then returns the nearest pathPoint to the specified
    * position.
    */
   public int initPathPoints() {
      if (this.pathPoints[0] == null) {
         for(int i = 0; i < 24; ++i) {
            int j = 5;
            int l;
            int i1;
            if (i < 12) {
               l = MathHelper.floor(60.0F * MathHelper.cos(2.0F * (-(float)Math.PI + 0.2617994F * (float)i)));
               i1 = MathHelper.floor(60.0F * MathHelper.sin(2.0F * (-(float)Math.PI + 0.2617994F * (float)i)));
            } else if (i < 20) {
               int lvt_3_1_ = i - 12;
               l = MathHelper.floor(40.0F * MathHelper.cos(2.0F * (-(float)Math.PI + ((float)Math.PI / 8F) * (float)lvt_3_1_)));
               i1 = MathHelper.floor(40.0F * MathHelper.sin(2.0F * (-(float)Math.PI + ((float)Math.PI / 8F) * (float)lvt_3_1_)));
               j += 10;
            } else {
               int k1 = i - 20;
               l = MathHelper.floor(20.0F * MathHelper.cos(2.0F * (-(float)Math.PI + ((float)Math.PI / 4F) * (float)k1)));
               i1 = MathHelper.floor(20.0F * MathHelper.sin(2.0F * (-(float)Math.PI + ((float)Math.PI / 4F) * (float)k1)));
            }

            int j1 = Math.max(this.world.getSeaLevel() + 10, this.world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, new BlockPos(l, 0, i1)).getY() + j);
            this.pathPoints[i] = new PathPoint(l, j1, i1);
         }

         this.neighbors[0] = 6146;
         this.neighbors[1] = 8197;
         this.neighbors[2] = 8202;
         this.neighbors[3] = 16404;
         this.neighbors[4] = 32808;
         this.neighbors[5] = 32848;
         this.neighbors[6] = 65696;
         this.neighbors[7] = 131392;
         this.neighbors[8] = 131712;
         this.neighbors[9] = 263424;
         this.neighbors[10] = 526848;
         this.neighbors[11] = 525313;
         this.neighbors[12] = 1581057;
         this.neighbors[13] = 3166214;
         this.neighbors[14] = 2138120;
         this.neighbors[15] = 6373424;
         this.neighbors[16] = 4358208;
         this.neighbors[17] = 12910976;
         this.neighbors[18] = 9044480;
         this.neighbors[19] = 9706496;
         this.neighbors[20] = 15216640;
         this.neighbors[21] = 13688832;
         this.neighbors[22] = 11763712;
         this.neighbors[23] = 8257536;
      }

      return this.getNearestPpIdx(this.getPosX(), this.getPosY(), this.getPosZ());
   }

   /**
    * Returns the index into pathPoints of the nearest PathPoint.
    */
   public int getNearestPpIdx(double x, double y, double z) {
      float f = 10000.0F;
      int i = 0;
      PathPoint pathpoint = new PathPoint(MathHelper.floor(x), MathHelper.floor(y), MathHelper.floor(z));
      int j = 0;

      for(int k = j; k < 24; ++k) {
         if (this.pathPoints[k] != null) {
            float f1 = this.pathPoints[k].distanceToSquared(pathpoint);
            if (f1 < f) {
               f = f1;
               i = k;
            }
         }
      }

      return i;
   }

   /**
    * Find and return a path among the circles described by pathPoints, or null if the shortest path would just be
    * directly between the start and finish with no intermediate points.
    *  
    * Starting with pathPoint[startIdx], it searches the neighboring points (and their neighboring points, and so on)
    * until it reaches pathPoint[finishIdx], at which point it calls makePath to seal the deal.
    */
   @Nullable
   public Path findPath(int startIdx, int finishIdx, @Nullable PathPoint andThen) {
      for(int i = 0; i < 24; ++i) {
         PathPoint pathpoint = this.pathPoints[i];
         pathpoint.visited = false;
         pathpoint.distanceToTarget = 0.0F;
         pathpoint.totalPathDistance = 0.0F;
         pathpoint.distanceToNext = 0.0F;
         pathpoint.previous = null;
         pathpoint.index = -1;
      }

      PathPoint pathpoint4 = this.pathPoints[startIdx];
      PathPoint pathpoint5 = this.pathPoints[finishIdx];
      pathpoint4.totalPathDistance = 0.0F;
      pathpoint4.distanceToNext = pathpoint4.distanceTo(pathpoint5);
      pathpoint4.distanceToTarget = pathpoint4.distanceToNext;
      this.pathFindQueue.clearPath();
      this.pathFindQueue.addPoint(pathpoint4);
      PathPoint pathpoint1 = pathpoint4;
      int j = 0;

      while(!this.pathFindQueue.isPathEmpty()) {
         PathPoint pathpoint2 = this.pathFindQueue.dequeue();
         if (pathpoint2.equals(pathpoint5)) {
            if (andThen != null) {
               andThen.previous = pathpoint5;
               pathpoint5 = andThen;
            }

            return this.makePath(pathpoint4, pathpoint5);
         }

         if (pathpoint2.distanceTo(pathpoint5) < pathpoint1.distanceTo(pathpoint5)) {
            pathpoint1 = pathpoint2;
         }

         pathpoint2.visited = true;
         int k = 0;

         for(int l = 0; l < 24; ++l) {
            if (this.pathPoints[l] == pathpoint2) {
               k = l;
               break;
            }
         }

         for(int i1 = j; i1 < 24; ++i1) {
            if ((this.neighbors[k] & 1 << i1) > 0) {
               PathPoint pathpoint3 = this.pathPoints[i1];
               if (!pathpoint3.visited) {
                  float f = pathpoint2.totalPathDistance + pathpoint2.distanceTo(pathpoint3);
                  if (!pathpoint3.isAssigned() || f < pathpoint3.totalPathDistance) {
                     pathpoint3.previous = pathpoint2;
                     pathpoint3.totalPathDistance = f;
                     pathpoint3.distanceToNext = pathpoint3.distanceTo(pathpoint5);
                     if (pathpoint3.isAssigned()) {
                        this.pathFindQueue.changeDistance(pathpoint3, pathpoint3.totalPathDistance + pathpoint3.distanceToNext);
                     } else {
                        pathpoint3.distanceToTarget = pathpoint3.totalPathDistance + pathpoint3.distanceToNext;
                        this.pathFindQueue.addPoint(pathpoint3);
                     }
                  }
               }
            }
         }
      }

      if (pathpoint1 == pathpoint4) {
         return null;
      } else {
         LOGGER.debug("Failed to find path from {} to {}", startIdx, finishIdx);
         if (andThen != null) {
            andThen.previous = pathpoint1;
            pathpoint1 = andThen;
         }

         return this.makePath(pathpoint4, pathpoint1);
      }
   }

   /**
    * Create and return a new PathEntity defining a path from the start to the finish, using the connections already
    * made by the caller, findPath.
    */
   private Path makePath(PathPoint start, PathPoint finish) {
      List<PathPoint> list = Lists.newArrayList();
      PathPoint pathpoint = finish;
      list.add(0, finish);

      while(pathpoint.previous != null) {
         pathpoint = pathpoint.previous;
         list.add(0, pathpoint);
      }

      return new Path(list, new BlockPos(finish.x, finish.y, finish.z), true);
   }

   /**
    * Makes the entity despawn if requirements are reached
    */
   public void checkDespawn() {
   }

   public QwertrtttPartEntity[] getQwertrtttParts() {
      return this.dragonParts;
   }

   /**
    * Returns true if other Entities should be prevented from moving through this Entity.
    */
   public boolean canBeCollidedWith() {
      return false;
   }

   public SoundCategory getSoundCategory() {
      return SoundCategory.HOSTILE;
   }

   protected SoundEvent getAmbientSound() {
      return SoundEvents.ENTITY_ENDER_DRAGON_AMBIENT;
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_ENDER_DRAGON_HURT;
   }

   /**
    * Returns the volume for the sounds this mob makes.
    */
   protected float getSoundVolume() {
      return 5.0F;
   }

   public boolean addPotionEffect(EffectInstance effectInstanceIn) {
      return false;
   }

   protected boolean canBeRidden(Entity entityIn) {
      return false;
   }

   /**
    * Returns false if this Entity is a boss, true otherwise.
    */
   public boolean isNonBoss() {
      return false;
   }
}