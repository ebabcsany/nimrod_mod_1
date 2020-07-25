package com.babcsany.minecraft.nimrod_mod_1.item;

import com.babcsany.minecraft.nimrod_mod_1.init.ItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

    GBXVSGXVBGS( 5, 299999999, 51324424224424424244242424242.0F, 77898978783874783874783774387834.0F, 199999, () -> Ingredient.fromItems(ItemInit.GBXVSGXVBGS.get())),
    ZRFJDOLEDFJH( 6574738, 999999999, 99999999999999999999999999999999999999.0F, 99999999999999999999999999999999999999.0F, 999999999, () -> Ingredient.fromItems(ItemInit.OBJECT.get()));


    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.getValue();
    }
}
