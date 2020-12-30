package com.babcsany.minecraft.nimrod_mod_1.entity;

import com.babcsany.minecraft.nimrod_mod_1.entity.villager.AbstractGhzjtvzhzvEntity;
import com.google.gson.JsonObject;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.loot.ConditionArraySerializer;
import net.minecraft.loot.LootContext;
import net.minecraft.util.ResourceLocation;

public class GhzjtvzhzvTradeTrigger extends AbstractCriterionTrigger<GhzjtvzhzvTradeTrigger.Instance> {
   private static final ResourceLocation ID = new ResourceLocation("ghzjtvzhzv_trade");

   public ResourceLocation getId() {
      return ID;
   }

   public Instance deserializeTrigger(JsonObject json, EntityPredicate.AndPredicate entityPredicate, ConditionArrayParser conditionsParser) {
      EntityPredicate.AndPredicate entitypredicate$andpredicate = EntityPredicate.AndPredicate.deserializeJSONObject(json, "ghzjtvzhzv_trader", conditionsParser);
      ItemPredicate itempredicate = ItemPredicate.deserialize(json.get("item"));
      return new Instance(entityPredicate, entitypredicate$andpredicate, itempredicate);
   }

   public void test(ServerPlayerEntity player, AbstractGhzjtvzhzvEntity ghzjtvzhzv_trader, ItemStack stack) {
      LootContext lootcontext = EntityPredicate.getLootContext(player, ghzjtvzhzv_trader);
      this.triggerListeners(player, (p_227267_2_) -> {
         return p_227267_2_.test(lootcontext, stack);
      });
   }

   public static class Instance extends CriterionInstance {
      private final EntityPredicate.AndPredicate ghzjtvzhzv_trader;
      private final ItemPredicate item;

      public Instance(EntityPredicate.AndPredicate player, EntityPredicate.AndPredicate ghzjtvzhzv_trader, ItemPredicate stack) {
         super(GhzjtvzhzvTradeTrigger.ID, player);
         this.ghzjtvzhzv_trader = ghzjtvzhzv_trader;
         this.item = stack;
      }

      public static Instance any() {
         return new Instance(EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.ANY_AND, ItemPredicate.ANY);
      }

      public boolean test(LootContext context, ItemStack stack) {
         if (!this.ghzjtvzhzv_trader.testContext(context)) {
            return false;
         } else {
            return this.item.test(stack);
         }
      }

      public JsonObject serialize(ConditionArraySerializer conditions) {
         JsonObject jsonobject = super.serialize(conditions);
         jsonobject.add("item", this.item.serialize());
         jsonobject.add("ghzjtvzhzv_trader", this.ghzjtvzhzv_trader.serializeConditions(conditions));
         return jsonobject;
      }
   }
}