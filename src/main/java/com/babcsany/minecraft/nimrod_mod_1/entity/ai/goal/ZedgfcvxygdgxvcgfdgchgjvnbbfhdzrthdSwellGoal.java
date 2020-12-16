package com.babcsany.minecraft.nimrod_mod_1.entity.ai.goal;

import com.babcsany.minecraft.nimrod_mod_1.entity.monster.ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.monster.CreeperEntity;

import java.util.EnumSet;

public class ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdSwellGoal extends Goal {
   private final ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdEntity swellingZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd;
   private LivingEntity zedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdAttackTarget;

   public ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdSwellGoal(ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdEntity entityzedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdIn) {
      this.swellingZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd = entityzedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdIn;
      this.setMutexFlags(EnumSet.of(Flag.MOVE));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      LivingEntity livingentity = this.swellingZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd.getAttackTarget();
      return this.swellingZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd.getZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdState() > 0 || livingentity != null && this.swellingZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd.getDistanceSq(livingentity) < 9.0D;
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      this.swellingZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd.getNavigator().clearPath();
      this.zedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdAttackTarget = this.swellingZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd.getAttackTarget();
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.zedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdAttackTarget = null;
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      if (this.zedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdAttackTarget == null) {
         this.swellingZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd.setZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdState(-1);
      } else if (this.swellingZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd.getDistanceSq(this.zedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdAttackTarget) > 49.0D) {
         this.swellingZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd.setZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdState(-1);
      } else if (!this.swellingZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd.getEntitySenses().canSee(this.zedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdAttackTarget)) {
         this.swellingZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd.setZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdState(-1);
      } else {
         this.swellingZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd.setZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdState(1);
      }
   }
}