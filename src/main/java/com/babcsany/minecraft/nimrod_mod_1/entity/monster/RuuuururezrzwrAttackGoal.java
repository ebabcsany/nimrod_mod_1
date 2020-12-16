package com.babcsany.minecraft.nimrod_mod_1.entity.monster;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class RuuuururezrzwrAttackGoal extends MeleeAttackGoal {
   private final Ruuuururezrzwr Ruuuururezrzwr;
   private int raiseArmTicks;

   public RuuuururezrzwrAttackGoal(Ruuuururezrzwr Ruuuururezrzwr, double speedIn, boolean longMemoryIn) {
      super(Ruuuururezrzwr, speedIn, longMemoryIn);
      this.Ruuuururezrzwr = Ruuuururezrzwr;
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      super.startExecuting();
      this.raiseArmTicks = 0;
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      super.resetTask();
      this.Ruuuururezrzwr.setAggroed(false);
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      super.tick();
      ++this.raiseArmTicks;
      if (this.raiseArmTicks >= 5 && this.func_234041_j_() < this.func_234042_k_() / 2) {
         this.Ruuuururezrzwr.setAggroed(true);
      } else {
         this.Ruuuururezrzwr.setAggroed(false);
      }

   }
}