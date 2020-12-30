package com.babcsany.minecraft.nimrod_mod_1.entity.ai.goal;

import com.babcsany.minecraft.nimrod_mod_1.entity.AbstractSnow1GolemEntity;
import com.babcsany.minecraft.nimrod_mod_1.entity.villager.AbstractIeurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdEntity;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;

public class Snow1GolemLookAtCustomerGoal extends LookAtGoal {
   private final AbstractSnow1GolemEntity snow1_golem;

   public Snow1GolemLookAtCustomerGoal(AbstractSnow1GolemEntity abstractSnow1GolemEntityIn) {
      super(abstractSnow1GolemEntityIn, PlayerEntity.class, 80.0F);
      this.snow1_golem = abstractSnow1GolemEntityIn;
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (this.snow1_golem.hasCustomer()) {
         this.closestEntity = this.snow1_golem.getCustomer();
         return true;
      } else {
         return false;
      }
   }
}