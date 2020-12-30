package com.babcsany.minecraft.nimrod_mod_1.init;

import com.babcsany.minecraft.nimrod_mod_1.Nimrod_mod_1;
import com.babcsany.minecraft.nimrod_mod_1.item.ModArmorMaterial;
import com.babcsany.minecraft.nimrod_mod_1.item.ModItemTier;
import com.babcsany.minecraft.nimrod_mod_1.item.ModSpawnEggItem;
import com.babcsany.minecraft.nimrod_mod_1.item.ZdgxhshBucketItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Nimrod_mod_1.MOD_ID);

    public static final RegistryObject<Item> PLMK = ITEMS.register("plmk", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS).isBurnable()
    ));
    public static final RegistryObject<Item> TETETRTTWFGEDRETETREDREDTERRFERRT = ITEMS.register("tetetrttwfgedretetredredterrferrt", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> OBJECT = ITEMS.register("object", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> GBXVSGXVBGS = ITEMS.register("gbxvsgxvbgs", () -> new SwordItem(
            ModItemTier.GBXVSGXVBGS, 99999999, 5555555555555555555555.0F, (new Item.Properties()).group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> EREWEEEREWEEDEWEER = ITEMS.register("ereweeereweedeweer", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<ModSpawnEggItem> RUUUURUREZRZWR_SPAWN_EGG = ITEMS.register("ruuuururezrzwr_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.RUUUURUREZRZWR, 0x6ea587, 0x446648, new Item.Properties().group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> JHUKJNJI = ITEMS.register("jhukjnji", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> DIAMOND_PICKAXE = ITEMS.register("diamond_pickaxe", () -> new PickaxeItem(
            ModItemTier.GBXVSGXVBGS, 1, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS)
    ));
    public static final RegistryObject<Item> ERT = ITEMS.register("ert", () -> new PickaxeItem(
            ModItemTier.ERT, 1, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS)
    ));
    public static final RegistryObject<Item> ZZZZZTTTTTTTRUG97978776676 = ITEMS.register("zzzzztttttttrug97978776676", () -> new ArmorItem(
            ModArmorMaterial.OBJECT, EquipmentSlotType.FEET, (new Item.Properties()).isBurnable().group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> DIAMOND_CHESTPLATE = ITEMS.register("diamond_chestplate", () -> new ArmorItem(
            ModArmorMaterial.OBJECT, EquipmentSlotType.CHEST, (new Item.Properties()).isBurnable().group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> DIRT_HELMET = ITEMS.register("dirt_helmet", () -> new ArmorItem(
            ModArmorMaterial.DIRTL, EquipmentSlotType.HEAD, (new Item.Properties()).isBurnable().group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> DIRT_CHESTPLATE = ITEMS.register("dirt_chestplate", () -> new ArmorItem(
            ModArmorMaterial.DIRTL, EquipmentSlotType.CHEST, (new Item.Properties()).isBurnable().group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> DIRT_LEGGINGS = ITEMS.register("dirt_leggings", () -> new ArmorItem(
            ModArmorMaterial.DIRTL, EquipmentSlotType.LEGS, (new Item.Properties()).isBurnable().group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> DIRT_BOOTS = ITEMS.register("dirt_boots", () -> new ArmorItem(
            ModArmorMaterial.DIRTL, EquipmentSlotType.FEET, (new Item.Properties()).isBurnable().group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> DIAMOND_LEGGINGS = ITEMS.register("diamond_leggings", () -> new ArmorItem(
            ModArmorMaterial.OBJECT, EquipmentSlotType.LEGS, (new Item.Properties()).isBurnable().group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> DIAMOND_HELMET = ITEMS.register("diamond_helmet", () -> new ArmorItem(
            ModArmorMaterial.OBJECT, EquipmentSlotType.HEAD, (new Item.Properties()).isBurnable().group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> ZRFJDOLEDFJH = ITEMS.register("zrfjdoledfjh", () -> new AxeItem(
            ModItemTier.ZRFJDOLEDFJH, -12, -2.8F, (new Item.Properties()).isBurnable().group(ItemGroup.TOOLS)
    ));
    public static final RegistryObject<Item> durgugugtuzrzuzgufgegfrhujgiugtrzhgzr = ITEMS.register("durgugugtuzrzuzgufgegfrhujgiugtrzhgzr", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    /*public static final RegistryObject<Item> MINECART = ITEMS.register("minecart", () -> new MinecartItem(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));*/
    public static final RegistryObject<Item> JAM = ITEMS.register("jam", () -> new Item(
            (new Item.Properties()).food(FoodInit.JAM).group(ItemGroup.FOOD)
    ));
    public static final RegistryObject<ModSpawnEggItem> ZEDGFCVXYGDGXVCGFDGCHGJVNBBFHDZRTHD_ENTITY_SPAWN_EGG = ITEMS.register("spawn_eggs/zedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.ZEDGFCVXYGDGXVCGFDGCHGJVNBBFHDZRTHD_ENTITY, 0x44ff00, 0x0010ff, new Item.Properties().group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> EMERALD_STICK = ITEMS.register("emerald_stick", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> EMERALD_STICK_ORE = ITEMS.register("emerald_stick_ore", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> ZERT = ITEMS.register("zert", () -> new SwordItem(
            ModItemTier.ZERT, 999999999, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS)
    ));
    public static final RegistryObject<Item> T1 = ITEMS.register("t1", () -> new ArrowItem(
            (new Item.Properties()).group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> DIAMOND_STICK = ITEMS.register("diamond_stick", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> SIVXGCZFHF_HELMET = ITEMS.register("sivxgczfhf_helmet", () -> new ArmorItem(
            ModArmorMaterial.OBJECTL, EquipmentSlotType.HEAD, (new Item.Properties()).group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> ERXCDS = ITEMS.register("erxcds", () -> new ArmorItem(
            ModArmorMaterial.OBJECTL, EquipmentSlotType.CHEST, (new Item.Properties()).group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> ZGUGZG_LEGGINGS = ITEMS.register("zgugzg_leggings", () -> new ArmorItem(
            ModArmorMaterial.OBJECTL, EquipmentSlotType.LEGS, (new Item.Properties()).group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> QTFATQGTS_BOOTS = ITEMS.register("qtfatqgts_boots", () -> new ArmorItem(
            ModArmorMaterial.OBJECTL, EquipmentSlotType.FEET, (new Item.Properties()).group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> SLICE_OF_BREAD = ITEMS.register("slice_of_bread", () -> new Item(
            (new Item.Properties()).food(FoodInit.SICLE_OF_BREAD).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<ModSpawnEggItem> TEGFDFSTZRFGDFDGFGDGFDG = ITEMS.register("tegfdfstzrfgdfdgfgdgfdg", () -> new ModSpawnEggItem(
            EntityInit.ZUHDGdgtdfgtefhdfhffzdkfdjfshd21234hxjifdedkfsdiferdmsfgxxjcdfzjfrduufjdsfbrjrthrcfgtgejfdjfhf, 0x44ff00, 0x0010ff, new Item.Properties().group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<ModSpawnEggItem> IEURJJFJUIJJFUHUJRIJFUHFJZUFHZUHUHZDJHJUHUGUGZFGZZZRHDGUGUGZRZ7RZZZEZDHZGEUGFDJHGUEZZRGHD = ITEMS.register("spawn_eggs/ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghd_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.IEURJJFJUIJJFUHUJRIJFUHFJZUFHZUHUHZDJHJUHUGUGZFGZZZRHDGUGUGZRZ7RZZZEZDHZGEUGFDJHGUEZZRGHD_ENTITY, 0x44ff00, 0x0010ff, new Item.Properties().group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> xnbcbnfbnfncbbmcncjgfnvdchfuguhgjfdjgjgfjzu = ITEMS.register("xnbcbnfbnfncbbmcncjgfnvdchfuguhgjfdjgjgfjzu", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<ModSpawnEggItem> SNOW1_MAN_SPAWN_EGG = ITEMS.register("snow1_man_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.SNOW_MAN_ENTITY, 0x5edfe0, 0x0310bf, new Item.Properties().group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> SAJT = ITEMS.register("sajt", () -> new Item(
            (new Item.Properties()).food(FoodInit.SAJT).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> L123456789 = ITEMS.register("123456789", () -> new Item(
            (new Item.Properties()).food(FoodInit.L123456789).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> L12345678910 = ITEMS.register("12345678910", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> T534REESWR4WSAEWWERTGHAGFVYVIGVAGT = ITEMS.register("t534reeswr4wsaewwertghagfvyvigvagt", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> TEAGVSGYVYIGGVYGFA = ITEMS.register("teagvsgyvyiggvygfa", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> BONE1 = ITEMS.register("bone1", () -> new Item(
            (new Item.Properties()).food(FoodInit.BONE1).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> DIAMOND_BOW = ITEMS.register("diamond_bow", () -> new BowItem(
            (new Item.Properties()).group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<Item> GBXVSGXVBGS_BOW = ITEMS.register("gbxvsgxvbgs_bow", () -> new BowItem(
            (new Item.Properties()).group(ItemGroup.COMBAT)
    ));
    public static final RegistryObject<ModSpawnEggItem> QWERTRTTT_SPAWN_EGG = ITEMS.register("qwertrttt_spawn_egg", () -> new ModSpawnEggItem(
            EntityInit.QWERTRTTT, 0x269615, 0x3e46c7, new Item.Properties().group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> ZDGXHSH_BUCKET = ITEMS.register("zdgxhsh_bucket", () -> new ZdgxhshBucketItem(
            (new Item.Properties()).food(FoodInit.BONE1).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> URFJ = ITEMS.register("urfj", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
    public static final RegistryObject<Item> URFJ1 = ITEMS.register("urfj1", () -> new Item(
            (new Item.Properties()).group(ItemGroup.MATERIALS)
    ));
}
