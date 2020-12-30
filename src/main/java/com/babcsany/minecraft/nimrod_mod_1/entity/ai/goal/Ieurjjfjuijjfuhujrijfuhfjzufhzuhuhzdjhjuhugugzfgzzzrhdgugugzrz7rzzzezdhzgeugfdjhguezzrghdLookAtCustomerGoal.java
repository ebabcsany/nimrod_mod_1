package com.babcsany.minecraft.nimrod_mod_1.entity.ai.goal;

import com.babcsany.minecraft.nimrod_mod_1.entity.villager.AbstractIeurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdEntity;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;

public class Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdLookAtCustomerGoal extends LookAtGoal {
   private final AbstractIeurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdEntity $_trader;

   public Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdLookAtCustomerGoal(AbstractIeurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdEntity abstract$TraderEntityIn) {
      super(abstract$TraderEntityIn, PlayerEntity.class, 80.0F);
      this.$_trader = abstract$TraderEntityIn;
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (this.$_trader.hasCustomer()) {
         this.closestEntity = this.$_trader.getCustomer();
         return true;
      } else {
         return false;
      }
   }
}