package com.babcsany.minecraft.nimrod_mod_1.init;

import com.babcsany.minecraft.nimrod_mod_1.Nimrod_mod_1;
import com.babcsany.minecraft.nimrod_mod_1.item.ModArmorMaterial;
import com.babcsany.minecraft.nimrod_mod_1.item.ModItemTier;
import com.babcsany.minecraft.nimrod_mod_1.item.ModSpawnEggItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Nimrod_mod_1.MOD_ID);

    public static final RegistryObject<Item> PLMK = ITEMS.register("plmk", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> TETETRTTWFGEDRETETREDREDTERRFERRT = ITEMS.register("tetetrttwfgedretetredredterrferrt", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> OBJECT = ITEMS.register("object", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> GBXVSGXVBGS = ITEMS.register("gbxvsgxvbgs", () -> new SwordItem(
            ModItemTier.GBXVSGXVBGS, 99999999, -5555555555555555555555.0F, (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> ereweeereweedeweer = ITEMS.register("ereweeereweedeweer", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<ModSpawnEggItem> RUUUURUREZRZWR_SPAWN_EGG = ITEMS.register("ruuuururezrzwr_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.RUUUURUREZRZWR, 0x6ea587, 0x446648, new Item.Properties().group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> JHUKJNJI = ITEMS.register("jhukjnji", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> DIAMOND_PICKAXE = ITEMS.register("diamond_pickaxe", () -> new PickaxeItem(
            ModItemTier.GBXVSGXVBGS, 1, -2.8F, (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> ZZZZZTTTTTTTRUG97978776676 = ITEMS.register("zzzzztttttttrug97978776676", () -> new ArmorItem(
            ModArmorMaterial.OBJECT, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> DIAMOND_CHESTPLATE = ITEMS.register("diamond_chestplate", () -> new ArmorItem(
            ModArmorMaterial.OBJECT, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> DIAMOND_LEGGINGS = ITEMS.register("diamond_leggings", () -> new ArmorItem(
            ModArmorMaterial.OBJECT, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> DIAMOND_BOOTS = ITEMS.register("diamond_boots", () -> new ArmorItem(
            ModArmorMaterial.OBJECT, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> ZRFJDOLEDFJH = ITEMS.register("zrfjdoledfjh", () -> new AxeItem(
            ModItemTier.ZRFJDOLEDFJH, 1, -2.8F, (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> durgugugtuzrzuzgufgegfrhujgiugtrzhgzr = ITEMS.register("durgugugtuzrzuzgufgegfrhujgiugtrzhgzr", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
}
