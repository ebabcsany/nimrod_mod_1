package com.babcsany.minecraft.nimrod_mod_1.item;

import com.babcsany.minecraft.nimrod_mod_1.Nimrod_mod_1;
import com.babcsany.minecraft.nimrod_mod_1.init.ItemInit;
import com.babcsany.minecraft.nimrod_mod_1.Nimrod_mod_1;
import com.babcsany.minecraft.nimrod_mod_1.init.ItemInit;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {
    OBJECT(Nimrod_mod_1.MOD_ID + ":object", 20, new int[]{28, 36, 44, 28}, 1680, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 20.7F, () -> { return Ingredient.fromItems(ItemInit.OBJECT.get()); }),
    OBJECTL(Nimrod_mod_1.MOD_ID + ":objectl", 999999999, new int[]{90000000, 999999999, 5019215, 637281717}, 900000000, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 999999999999999999999.7F, () -> { return Ingredient.fromItems(ItemInit.OBJECT.get()); }),
    DIRTL(Nimrod_mod_1.MOD_ID + ":dirtl", 999999999, new int[]{90000000, 999999999, 5019215, 637281717}, 900000000, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 999999999999999999999.7F, () -> { return Ingredient.fromItems(Items.DIRT); });

    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 400, 400, 400, 400 };
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyValue<Ingredient> repairMaterial;


    ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
                     int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn,
                     Supplier<Ingredient> repairMaterialIn) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = soundEventIn;
        this.toughness = toughnessIn;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }


    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }


    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }


    @Override
    public int getEnchantability() {
        return this.enchantability;
    }


    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }


    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }


    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
