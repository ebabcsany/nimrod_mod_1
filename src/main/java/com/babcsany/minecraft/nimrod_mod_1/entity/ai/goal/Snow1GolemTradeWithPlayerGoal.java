package com.babcsany.minecraft.nimrod_mod_1.entity.ai.goal;

import com.babcsany.minecraft.nimrod_mod_1.entity.Snow1ManEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;

import java.util.EnumSet;

public class Snow1GolemTradeWithPlayerGoal extends Goal {
   private final Snow1ManEntity snow1Golem;

   public Snow1GolemTradeWithPlayerGoal(Snow1ManEntity snow1Golem) {
      this.snow1Golem = snow1Golem;
      this.setMutexFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (!this.snow1Golem.isAlive()) {
         return false;
      } else if (this.snow1Golem.isInWater()) {
         return false;
      } else if (!this.snow1Golem.isOnGround()) {
         return false;
      } else if (this.snow1Golem.velocityChanged) {
         return false;
      } else {
         PlayerEntity playerentity = this.snow1Golem.getCustomer();
         if (playerentity == null) {
            return false;
         } else if (this.snow1Golem.getDistanceSq(playerentity) > 16.0D) {
            return false;
         } else {
            return playerentity.openContainer != null;
         }
      }
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      this.snow1Golem.getNavigator().clearPath();
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.snow1Golem.setCustomer((PlayerEntity)null);
   }
}