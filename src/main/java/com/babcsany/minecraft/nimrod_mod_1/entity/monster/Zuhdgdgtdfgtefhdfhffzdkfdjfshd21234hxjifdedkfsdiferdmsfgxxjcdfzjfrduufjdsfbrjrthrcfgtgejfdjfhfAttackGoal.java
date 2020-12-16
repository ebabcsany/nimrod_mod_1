package com.babcsany.minecraft.nimrod_mod_1.entity.monster;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhfAttackGoal extends MeleeAttackGoal {
   private final Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf;
   private int raiseArmTicks;

   public Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhfAttackGoal(Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf, double speedIn, boolean longMemoryIn) {
      super(Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf, speedIn, longMemoryIn);
      this.Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf = Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf;
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
      this.Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf.setAggroed(false);
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      super.tick();
      ++this.raiseArmTicks;
      if (this.raiseArmTicks >= 5 && this.func_234041_j_() < this.func_234042_k_() / 2) {
         this.Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf.setAggroed(true);
      } else {
         this.Zuhdgdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf.setAggroed(false);
      }

   }
}