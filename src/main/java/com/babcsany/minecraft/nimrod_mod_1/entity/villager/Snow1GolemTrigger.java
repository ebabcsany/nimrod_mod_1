package com.babcsany.minecraft.nimrod_mod_1.entity.villager;

import com.babcsany.minecraft.nimrod_mod_1.entity.AbstractSnow1GolemEntity;
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

public class Snow1GolemTrigger extends AbstractCriterionTrigger<Snow1GolemTrigger.Instance> {
   private static final ResourceLocation ID = new ResourceLocation("snow1_golem_trade");

   public ResourceLocation getId() {
      return ID;
   }

   public Instance deserializeTrigger(JsonObject json, EntityPredicate.AndPredicate entityPredicate, ConditionArrayParser conditionsParser) {
      EntityPredicate.AndPredicate entitypredicate$andpredicate = EntityPredicate.AndPredicate.deserializeJSONObject(json, "snow1_golem", conditionsParser);
      ItemPredicate itempredicate = ItemPredicate.deserialize(json.get("item"));
      return new Instance(entityPredicate, entitypredicate$andpredicate, itempredicate);
   }

   public void test(ServerPlayerEntity player, AbstractSnow1GolemEntity snow1_golem, ItemStack stack) {
      LootContext lootcontext = EntityPredicate.getLootContext(player, snow1_golem);
      this.triggerListeners(player, (p_227267_2_) -> {
         return p_227267_2_.test(lootcontext, stack);
      });
   }

   public static class Instance extends CriterionInstance {
      private final EntityPredicate.AndPredicate snow1_golem;
      private final ItemPredicate item;

      public Instance(EntityPredicate.AndPredicate player, EntityPredicate.AndPredicate snow1_golem, ItemPredicate stack) {
         super(Snow1GolemTrigger.ID, player);
         this.snow1_golem = snow1_golem;
         this.item = stack;
      }

      public static Instance any() {
         return new Instance(EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.ANY_AND, ItemPredicate.ANY);
      }

      public boolean test(LootContext context, ItemStack stack) {
         if (!this.snow1_golem.testContext(context)) {
            return false;
         } else {
            return this.item.test(stack);
         }
      }

      public JsonObject serialize(ConditionArraySerializer conditions) {
         JsonObject jsonobject = super.serialize(conditions);
         jsonobject.add("item", this.item.serialize());
         jsonobject.add("snow1_golem", this.snow1_golem.serializeConditions(conditions));
         return jsonobject;
      }
   }
}