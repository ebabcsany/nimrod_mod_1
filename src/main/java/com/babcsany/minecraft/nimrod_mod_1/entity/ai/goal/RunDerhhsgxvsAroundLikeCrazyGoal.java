package com.babcsany.minecraft.nimrod_mod_1.entity.ai.goal;

import com.babcsany.minecraft.nimrod_mod_1.entity.horse.AbstractDerhhsgxvsEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.vector.Vector3d;

import java.util.EnumSet;

public class RunDerhhsgxvsAroundLikeCrazyGoal extends Goal {
   private final AbstractDerhhsgxvsEntity horseHost;
   private final double speed;
   private double targetX;
   private double targetY;
   private double targetZ;

   public RunDerhhsgxvsAroundLikeCrazyGoal(AbstractDerhhsgxvsEntity horse, double speedIn) {
      this.horseHost = horse;
      this.speed = speedIn;
      this.setMutexFlags(EnumSet.of(Flag.MOVE));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (!this.horseHost.isTame() && this.horseHost.isBeingRidden()) {
         Vector3d vector3d = RandomPositionGenerator.findRandomTarget(this.horseHost, 5, 4);
         if (vector3d == null) {
            return false;
         } else {
            this.targetX = vector3d.x;
            this.targetY = vector3d.y;
            this.targetZ = vector3d.z;
            return true;
         }
      } else {
         return false;
      }
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      this.horseHost.getNavigator().tryMoveToXYZ(this.targetX, this.targetY, this.targetZ, this.speed);
   }

   /**
    * Returns whether an in-progress EntityAIBase should continue executing
    */
   public boolean shouldContinueExecuting() {
      return !this.horseHost.isTame() && !this.horseHost.getNavigator().noPath() && this.horseHost.isBeingRidden();
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      if (!this.horseHost.isTame() && this.horseHost.getRNG().nextInt(50) == 0) {
         Entity entity = this.horseHost.getPassengers().get(0);
         if (entity == null) {
            return;
         }

         if (entity instanceof PlayerEntity) {
            int i = this.horseHost.getTemper();
            int j = this.horseHost.getMaxTemper();
            if (j > 0 && this.horseHost.getRNG().nextInt(j) < i && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(horseHost, (PlayerEntity)entity)) {
               this.horseHost.setTamedBy((PlayerEntity)entity);
               return;
            }

            this.horseHost.increaseTemper(5);
         }

         this.horseHost.removePassengers();
         this.horseHost.makeMad();
         this.horseHost.world.setEntityState(this.horseHost, (byte)6);
      }

   }
}