package com.babcsany.minecraft.nimrod_mod_1.entity;

import com.babcsany.minecraft.nimrod_mod_1.entity.ai.goal.Snow1GolemLookAtCustomerGoal;
import com.babcsany.minecraft.nimrod_mod_1.entity.ai.goal.Snow1GolemTradeWithPlayerGoal;
import com.babcsany.minecraft.nimrod_mod_1.entity.monster.Ruuuururezrzwr;
import com.babcsany.minecraft.nimrod_mod_1.init.EntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class Snow1ManEntity extends AbstractSnow1GolemEntity implements IShearable, IRangedAttackMob, net.minecraftforge.common.IForgeShearable {
   private static final DataParameter<Byte> PUMPKIN_EQUIPPED = EntityDataManager.createKey(Snow1ManEntity.class, DataSerializers.BYTE);
   private PlayerEntity customer;

   public Snow1ManEntity(EntityType<? extends Snow1ManEntity> type, World worldIn) {
      super(type, worldIn);
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
      this.goalSelector.addGoal(1, new Snow1GolemTradeWithPlayerGoal(this));
      this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 1.0000001E-5F));
      this.goalSelector.addGoal(1, new Snow1GolemLookAtCustomerGoal(this));
      this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Ruuuururezrzwr.class, 10, true, false, (p_213621_0_) -> {
         return p_213621_0_ instanceof IMob;
      }));
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 400000.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.2F);
   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(PUMPKIN_EQUIPPED, (byte)16);
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putBoolean("Pumpkin", this.isPumpkinEquipped());
   }

   public void setCustomer(@Nullable PlayerEntity player) {
      this.customer = player;
   }

   @Nullable
   public PlayerEntity getCustomer() {
      return this.customer;
   }

   @Override
   protected void onVillagerTrade(MerchantOffer offer) {

   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      if (compound.contains("Pumpkin")) {
         this.setPumpkinEquipped(compound.getBoolean("Pumpkin"));
      }

   }

   @Override
   protected void populateTradeData() {

   }

   public boolean isWaterSensitive() {
      return true;
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void livingTick() {
      super.livingTick();
      if (!this.world.isRemote) {
         int i = MathHelper.floor(this.getPosX());
         int j = MathHelper.floor(this.getPosY());
         int k = MathHelper.floor(this.getPosZ());
         if (this.world.getBiome(new BlockPos(i, 0, k)).getTemperature(new BlockPos(i, j, k)) > 1.0F) {
            this.attackEntityFrom(DamageSource.ON_FIRE, 1.0F);
         }

         if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this)) {
            return;
         }

         BlockState blockstate = Blocks.SNOW.getDefaultState();

         for(int l = 0; l < 4; ++l) {
            i = MathHelper.floor(this.getPosX() + (double)((float)(l % 2 * 2 - 1) * 0.25F));
            j = MathHelper.floor(this.getPosY());
            k = MathHelper.floor(this.getPosZ() + (double)((float)(l / 2 % 2 * 2 - 1) * 0.25F));
            BlockPos blockpos = new BlockPos(i, j, k);
            if (this.world.isAirBlock(blockpos) && this.world.getBiome(blockpos).getTemperature(blockpos) < 0.8F && blockstate.isValidPosition(this.world, blockpos)) {
               this.world.setBlockState(blockpos, blockstate);
            }
         }
      }

   }

   /**
    * Attack the specified entity using a ranged attack.
    */
   public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
      SnowballEntity snowballentity = new SnowballEntity(this.world, this);
      double d0 = target.getPosYEye() - (double)1.1F;
      double d1 = target.getPosX() - this.getPosX();
      double d2 = d0 - snowballentity.getPosY();
      double d3 = target.getPosZ() - this.getPosZ();
      float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
      snowballentity.shoot(d1, d2 + (double)f, d3, 1.6F, 12.0F);
      this.playSound(SoundEvents.ENTITY_SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
      this.world.addEntity(snowballentity);
   }

   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
      return 1.7F;
   }

   protected ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
      ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
      if (false && itemstack.getItem() == Items.SHEARS && this.isShearable()) { //Forge: Moved to onSheared
         this.shear(SoundCategory.PLAYERS);
         if (!this.world.isRemote) {
            itemstack.damageItem(1, p_230254_1_, (p_213622_1_) -> {
               p_213622_1_.sendBreakAnimation(p_230254_2_);
            });
         }

         return ActionResultType.func_233537_a_(this.world.isRemote);
      } else {
         return ActionResultType.PASS;
      }
   }

   public void shear(SoundCategory category) {
      this.world.playMovingSound((PlayerEntity)null, this, SoundEvents.ENTITY_SNOW_GOLEM_SHEAR, category, 1.0F, 1.0F);
      if (!this.world.isRemote()) {
         this.setPumpkinEquipped(false);
         this.entityDropItem(new ItemStack(Items.CARVED_PUMPKIN), 1.7F);
      }

   }

   public boolean isShearable() {
      return this.isAlive() && this.isPumpkinEquipped();
   }

   public boolean isPumpkinEquipped() {
      return (this.dataManager.get(PUMPKIN_EQUIPPED) & 16) != 0;
   }

   public void setPumpkinEquipped(boolean pumpkinEquipped) {
      byte b0 = this.dataManager.get(PUMPKIN_EQUIPPED);
      if (pumpkinEquipped) {
         this.dataManager.set(PUMPKIN_EQUIPPED, (byte)(b0 | 16));
      } else {
         this.dataManager.set(PUMPKIN_EQUIPPED, (byte)(b0 & -17));
      }

   }

   @Nullable
   protected SoundEvent getAmbientSound() {
      return SoundEvents.ENTITY_SNOW_GOLEM_AMBIENT;
   }

   @Nullable
   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_SNOW_GOLEM_HURT;
   }

   @Nullable
   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_SNOW_GOLEM_DEATH;
   }

   @OnlyIn(Dist.CLIENT)
   public Vector3d func_241205_ce_() {
      return new Vector3d(0.0D, (double)(0.75F * this.getEyeHeight()), (double)(this.getWidth() * 0.4F));
   }

   @Override
   public boolean isShearable(@javax.annotation.Nonnull ItemStack item, World world, BlockPos pos) {
      return isShearable();
   }

   public Snow1ManEntity createChild(AgeableEntity ageable) {
      return EntityInit.SNOW_MAN_ENTITY.get().create(this.world);
   }

   @javax.annotation.Nonnull
   @Override
   public java.util.List<ItemStack> onSheared(@Nullable PlayerEntity player, @javax.annotation.Nonnull ItemStack item, World world, BlockPos pos, int fortune) {
      world.playMovingSound(null, this, SoundEvents.ENTITY_SNOW_GOLEM_SHEAR, player == null ? SoundCategory.BLOCKS : SoundCategory.PLAYERS, 1.0F, 1.0F);
      if (!world.isRemote()) {
         setPumpkinEquipped(false);
         return java.util.Collections.singletonList(new ItemStack(Items.CARVED_PUMPKIN));
      }
      return java.util.Collections.emptyList();
   }
}