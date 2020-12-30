package com.babcsany.minecraft.nimrod_mod_1.entity.villager;

import com.babcsany.minecraft.nimrod_mod_1.init.BlockInit;
import com.babcsany.minecraft.nimrod_mod_1.init.ItemInit;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.villager.IVillagerDataHolder;
import net.minecraft.entity.villager.IVillagerType;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionBrewing;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.storage.MapDecoration;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades {
   public static final Int2ObjectMap<Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade[]> field_221240_b = gatAsIntMap(ImmutableMap.of(1, new Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade[]{
           new Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ItemsForDirtsTrade(Items.EMERALD, 25, 1, 22, 2),
           new Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ItemsForDirtsTrade(ItemInit.durgugugtuzrzuzgufgegfrhujgiugtrzhgzr.get(), 2, 1, 5, 1),
           new Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ItemsForDirtsTrade(Items.NAUTILUS_SHELL, 5, 1, 20, 3),
           new Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ItemsForDirtsTrade(ItemInit.TETETRTTWFGEDRETETREDREDTERRFERRT.get(), 4, 1, 10, 2),
           new Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ItemsForDirtsTrade(Items.GRASS_BLOCK, 4, 1, 9, 1),
           new Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ItemsForKirtsTrade(ItemInit.DIAMOND_STICK.get(), 64, 1, 20, 1),
           new Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ItemsForEmeraldBlocksTrade(BlockInit.L971237GZGDUGHDGJGHRHDDHDDHCVJGE.get(), 1, 1, 20, 1),
           new Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ItemsForTetetrttwfgedretetredredterrferrtsTrade(ItemInit.SAJT.get(), 4, 1, 10, 1),
           new Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ItemsForTetetrttwfgedretetredredterrferrtsTrade(BlockInit.BLACK_BEDROCK.get(), 3, 2, 10, 1),
           new Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ItemsForTetetrttwfgedretetredredterrferrtsTrade(BlockInit.ZWZHSGDGSF.get(), 2, 5, 10, 1),
           new Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ItemsForTetetrttwfgedretetredredterrferrtsTrade(BlockInit.WUEUZEUZEZHSZWS.get(), 5, 3, 10, 1),
           new Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ItemsForTetetrttwfgedretetredredterrferrtsTrade(BlockInit.JHUKJNJI_BLOCK.get(), 2, 1, 10, 1),
           new Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ItemsForEmeraldOresTrade(ItemInit.OBJECT.get(), 1, 5, 50, 18),
   }));

   private static Int2ObjectMap<Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade[]> gatAsIntMap(ImmutableMap<Integer, Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade[]> p_221238_0_) {
      return new Int2ObjectOpenHashMap<>(p_221238_0_);
   }

   static class DyedArmorForEmeraldsTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final Item tradeItem;
      private final int price;
      private final int maxUses;
      private final int xpValue;

      public DyedArmorForEmeraldsTrade(Item itemIn, int priceIn) {
         this(itemIn, priceIn, 12, 1);
      }

      public DyedArmorForEmeraldsTrade(Item tradeItemIn, int priceIn, int maxUsesIn, int xpValueIn) {
         this.tradeItem = tradeItemIn;
         this.price = priceIn;
         this.maxUses = maxUsesIn;
         this.xpValue = xpValueIn;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         ItemStack itemstack = new ItemStack(Items.EMERALD, this.price);
         ItemStack itemstack1 = new ItemStack(this.tradeItem);
         if (this.tradeItem instanceof DyeableArmorItem) {
            List<DyeItem> list = Lists.newArrayList();
            list.add(getRandomDyeItem(rand));
            if (rand.nextFloat() > 0.7F) {
               list.add(getRandomDyeItem(rand));
            }

            if (rand.nextFloat() > 0.8F) {
               list.add(getRandomDyeItem(rand));
            }

            itemstack1 = IDyeableArmorItem.dyeItem(itemstack1, list);
         }

         return new MerchantOffer(itemstack, itemstack1, this.maxUses, this.xpValue, 0.2F);
      }

      private static DyeItem getRandomDyeItem(Random p_221232_0_) {
         return DyeItem.getItem(DyeColor.byId(p_221232_0_.nextInt(16)));
      }
   }

   static class DyedArmorForRubiesTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final Item tradeItem;
      private final int price;
      private final int maxUses;
      private final int xpValue;

      public DyedArmorForRubiesTrade(Item itemIn, int priceIn) {
         this(itemIn, priceIn, 12, 1);
      }

      public DyedArmorForRubiesTrade(Item tradeItemIn, int priceIn, int maxUsesIn, int xpValueIn) {
         this.tradeItem = tradeItemIn;
         this.price = priceIn;
         this.maxUses = maxUsesIn;
         this.xpValue = xpValueIn;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         ItemStack itemstack = new ItemStack(ItemInit.PLMK.get(), this.price);
         ItemStack itemstack1 = new ItemStack(this.tradeItem);
         if (this.tradeItem instanceof DyeableArmorItem) {
            List<DyeItem> list = Lists.newArrayList();
            list.add(getRandomDyeItem(rand));
            if (rand.nextFloat() > 0.7F) {
               list.add(getRandomDyeItem(rand));
            }

            if (rand.nextFloat() > 0.8F) {
               list.add(getRandomDyeItem(rand));
            }

            itemstack1 = IDyeableArmorItem.dyeItem(itemstack1, list);
         }

         return new MerchantOffer(itemstack, itemstack1, this.maxUses, this.xpValue, 0.2F);
      }

      private static DyeItem getRandomDyeItem(Random p_221232_0_) {
         return DyeItem.getItem(DyeColor.byId(p_221232_0_.nextInt(16)));
      }
   }

   static class EmeraldForItemsTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final Item tradeItem;
      private final int count;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public EmeraldForItemsTrade(IItemProvider tradeItemIn, int countIn, int maxUsesIn, int xpValueIn) {
         this.tradeItem = tradeItemIn.asItem();
         this.count = countIn;
         this.maxUses = maxUsesIn;
         this.xpValue = xpValueIn;
         this.priceMultiplier = 0.05F;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         ItemStack itemstack = new ItemStack(this.tradeItem, this.count);
         return new MerchantOffer(itemstack, new ItemStack(Items.EMERALD), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class RubyForItemsTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final Item tradeItem;
      private final int count;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public RubyForItemsTrade(IItemProvider tradeItemIn, int countIn, int maxUsesIn, int xpValueIn) {
         this.tradeItem = tradeItemIn.asItem();
         this.count = countIn;
         this.maxUses = maxUsesIn;
         this.xpValue = xpValueIn;
         this.priceMultiplier = 0.05F;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         ItemStack itemstack = new ItemStack(this.tradeItem, this.count);
         return new MerchantOffer(itemstack, new ItemStack(ItemInit.EMERALD_STICK.get()), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class EmeraldForMapTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final int count;
      private final Structure<?> structureName;
      private final MapDecoration.Type mapDecorationType;
      private final int maxUses;
      private final int xpValue;

      public EmeraldForMapTrade(int count, Structure<?> structureName, MapDecoration.Type mapDecorationType, int maxUses, int xpValue) {
         this.count = count;
         this.structureName = structureName;
         this.mapDecorationType = mapDecorationType;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         if (!(trader.world instanceof ServerWorld)) {
            return null;
         } else {
            ServerWorld serverworld = (ServerWorld)trader.world;
            BlockPos blockpos = serverworld.func_241117_a_(this.structureName, trader.getPosition(), 100, true);
            if (blockpos != null) {
               ItemStack itemstack = FilledMapItem.setupNewMap(serverworld, blockpos.getX(), blockpos.getZ(), (byte)2, true, true);
               FilledMapItem.func_226642_a_(serverworld, itemstack);
               MapData.addTargetDecoration(itemstack, blockpos, "+", this.mapDecorationType);
               itemstack.setDisplayName(new TranslationTextComponent("filled_map." + this.structureName.getStructureName().toLowerCase(Locale.ROOT)));
               return new MerchantOffer(new ItemStack(Items.EMERALD, this.count), new ItemStack(Items.COMPASS), itemstack, this.maxUses, this.xpValue, 0.2F);
            } else {
               return null;
            }
         }
      }
   }

   static class RubyForMapTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final int count;
      private final Structure<?> structureName;
      private final MapDecoration.Type mapDecorationType;
      private final int maxUses;
      private final int xpValue;

      public RubyForMapTrade(int count, Structure<?> structureName, MapDecoration.Type mapDecorationType, int maxUses, int xpValue) {
         this.count = count;
         this.structureName = structureName;
         this.mapDecorationType = mapDecorationType;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         if (!(trader.world instanceof ServerWorld)) {
            return null;
         } else {
            ServerWorld serverworld = (ServerWorld)trader.world;
            BlockPos blockpos = serverworld.func_241117_a_(this.structureName, trader.getPosition(), 100, true);
            if (blockpos != null) {
               ItemStack itemstack = FilledMapItem.setupNewMap(serverworld, blockpos.getX(), blockpos.getZ(), (byte)2, true, true);
               FilledMapItem.func_226642_a_(serverworld, itemstack);
               MapData.addTargetDecoration(itemstack, blockpos, "+", this.mapDecorationType);
               itemstack.setDisplayName(new TranslationTextComponent("filled_map." + this.structureName.getStructureName().toLowerCase(Locale.ROOT)));
               return new MerchantOffer(new ItemStack(ItemInit.TETETRTTWFGEDRETETREDREDTERRFERRT.get(), this.count), new ItemStack(Items.COMPASS), itemstack, this.maxUses, this.xpValue, 0.2F);
            } else {
               return null;
            }
         }
      }
   }

   static class EmeraldForVillageTypeItemTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final Map<IVillagerType, Item> villagerTypeItems;
      private final int count;
      private final int maxUses;
      private final int xpValue;

      public EmeraldForVillageTypeItemTrade(int count, int maxUsesIn, int xpValueIn, Map<IVillagerType, Item> villagerTypeItemsIn) {
         Registry.VILLAGER_TYPE.stream().filter((villagerType) -> {
            return !villagerTypeItemsIn.containsKey(villagerType);
         }).findAny().ifPresent((villagerType) -> {
            throw new IllegalStateException("Missing trade for villager type: " + Registry.VILLAGER_TYPE.getKey(villagerType));
         });
         this.villagerTypeItems = villagerTypeItemsIn;
         this.count = count;
         this.maxUses = maxUsesIn;
         this.xpValue = xpValueIn;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         if (trader instanceof IVillagerDataHolder) {
            ItemStack itemstack = new ItemStack(this.villagerTypeItems.get(((IVillagerDataHolder)trader).getVillagerData().getType()), this.count);
            return new MerchantOffer(itemstack, new ItemStack(Items.EMERALD), this.maxUses, this.xpValue, 0.05F);
         } else {
            return null;
         }
      }
   }

   static class EnchantedBookForEmeraldsTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final int xpValue;

      public EnchantedBookForEmeraldsTrade(int xpValueIn) {
         this.xpValue = xpValueIn;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         List<Enchantment> list = Registry.ENCHANTMENT.stream().filter(Enchantment::canVillagerTrade).collect(Collectors.toList());
         Enchantment enchantment = list.get(rand.nextInt(list.size()));
         int i = MathHelper.nextInt(rand, enchantment.getMinLevel(), enchantment.getMaxLevel());
         ItemStack itemstack = EnchantedBookItem.getEnchantedItemStack(new EnchantmentData(enchantment, i));
         int j = 2 + rand.nextInt(5 + i * 10) + 3 * i;
         if (enchantment.isTreasureEnchantment()) {
            j *= 2;
         }

         if (j > 64) {
            j = 64;
         }

         return new MerchantOffer(new ItemStack(Items.EMERALD, j), new ItemStack(Items.BOOK), itemstack, 12, this.xpValue, 0.2F);
      }
      public MerchantOffer getOffer1(Entity trader, Random rand) {
         List<Enchantment> list = Registry.ENCHANTMENT.stream().filter(Enchantment::canVillagerTrade).collect(Collectors.toList());
         Enchantment enchantment = list.get(rand.nextInt(list.size()));
         int i = MathHelper.nextInt(rand, enchantment.getMinLevel(), enchantment.getMaxLevel());
         ItemStack itemstack = EnchantedBookItem.getEnchantedItemStack(new EnchantmentData(enchantment, i));
         int j = 2 + rand.nextInt(5 + i * 10) + 3 * i;
         if (enchantment.isTreasureEnchantment()) {
            j *= 2;
         }

         if (j > 64) {
            j = 64;
         }

         return new MerchantOffer(new ItemStack(Items.EMERALD, j), new ItemStack(Items.BOOK), itemstack, 12, this.xpValue, 0.2F);
      }
   }

   static class EnchantedBookForRubiesTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final int xpValue;

      public EnchantedBookForRubiesTrade(int xpValueIn) {
         this.xpValue = xpValueIn;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         List<Enchantment> list = Registry.ENCHANTMENT.stream().filter(Enchantment::canVillagerTrade).collect(Collectors.toList());
         Enchantment enchantment = list.get(rand.nextInt(list.size()));
         int i = MathHelper.nextInt(rand, enchantment.getMinLevel(), enchantment.getMaxLevel());
         ItemStack itemstack = EnchantedBookItem.getEnchantedItemStack(new EnchantmentData(enchantment, i));
         int j = 2 + rand.nextInt(5 + i * 10) + 3 * i;
         if (enchantment.isTreasureEnchantment()) {
            j *= 2;
         }

         if (j > 64) {
            j = 64;
         }

         return new MerchantOffer(new ItemStack(ItemInit.EREWEEEREWEEDEWEER.get(), j), new ItemStack(Items.BOOK), itemstack, 12, this.xpValue, 0.2F);
      }
      public MerchantOffer getOffer1(Entity trader, Random rand) {
         List<Enchantment> list = Registry.ENCHANTMENT.stream().filter(Enchantment::canVillagerTrade).collect(Collectors.toList());
         Enchantment enchantment = list.get(rand.nextInt(list.size()));
         int i = MathHelper.nextInt(rand, enchantment.getMinLevel(), enchantment.getMaxLevel());
         ItemStack itemstack = EnchantedBookItem.getEnchantedItemStack(new EnchantmentData(enchantment, i));
         int j = 2 + rand.nextInt(5 + i * 10) + 3 * i;
         if (enchantment.isTreasureEnchantment()) {
            j *= 2;
         }

         if (j > 64) {
            j = 64;
         }

         return new MerchantOffer(new ItemStack(ItemInit.EREWEEEREWEEDEWEER.get(), j), new ItemStack(Items.BOOK), itemstack, 12, this.xpValue, 0.2F);
      }
   }

   static class EnchantedItemForEmeraldsTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final ItemStack sellingStack;
      private final int emeraldCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public EnchantedItemForEmeraldsTrade(Item p_i50535_1_, int emeraldCount, int maxUses, int xpValue) {
         this(p_i50535_1_, emeraldCount, maxUses, xpValue, 0.05F);
      }

      public EnchantedItemForEmeraldsTrade(Item sellItem, int emeraldCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingStack = new ItemStack(sellItem);
         this.emeraldCount = emeraldCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         int i = 5 + rand.nextInt(15);
         ItemStack itemstack = EnchantmentHelper.addRandomEnchantment(rand, new ItemStack(this.sellingStack.getItem()), i, false);
         int j = Math.min(this.emeraldCount + i, 64);
         ItemStack itemstack1 = new ItemStack(Items.EMERALD, j);
         ItemStack itemstack2 = new ItemStack(Items.EMERALD, j);
         return new MerchantOffer(itemstack1, itemstack, this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class EnchantedItemForRubiesTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final ItemStack sellingStack;
      private final int rubyCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public EnchantedItemForRubiesTrade(Item p_i50535_1_, int rubyCount, int maxUses, int xpValue) {
         this(p_i50535_1_, rubyCount, maxUses, xpValue, 0.05F);
      }

      public EnchantedItemForRubiesTrade(Item sellItem, int rubyCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingStack = new ItemStack(sellItem);
         this.rubyCount = rubyCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         int i = 5 + rand.nextInt(15);
         ItemStack itemstack = EnchantmentHelper.addRandomEnchantment(rand, new ItemStack(this.sellingStack.getItem()), i, false);
         int j = Math.min(this.rubyCount + i, 64);
         ItemStack itemstack1 = new ItemStack(BlockInit.QERTZUIOPR.get(), j);
         ItemStack itemstack2 = new ItemStack(BlockInit.QERTZUIOPR.get(), j);
         return new MerchantOffer(itemstack1, itemstack, this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   public interface ITrade {
      @Nullable
      MerchantOffer getOffer(Entity trader, Random rand);
   }

   static class ItemWithPotionForEmeraldsAndItemsTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      /** An ItemStack that can have potion effects written to it. */
      private final ItemStack potionStack;
      private final int potionCount;
      private final int emeraldCount;
      private final int rubyCount;
      private final int maxUses;
      private final int xpValue;
      private final Item buyingItem;
      private final int buyingItemCount;
      private final float priceMultiplier;

      public ItemWithPotionForEmeraldsAndItemsTrade(Item buyingItem, int buyingItemCount, Item p_i50526_3_, int p_i50526_4_, int emeralds, int rubies, int maxUses, int xpValue) {
         this.potionStack = new ItemStack(p_i50526_3_);
         this.emeraldCount = emeralds;
         this.rubyCount = rubies;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.buyingItem = buyingItem;
         this.buyingItemCount = buyingItemCount;
         this.potionCount = p_i50526_4_;
         this.priceMultiplier = 0.05F;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         ItemStack itemstack = new ItemStack(Items.EMERALD, this.emeraldCount);
         ItemStack itemstack_1 = new ItemStack(BlockInit.JHUKJNJI_BLOCK.get(), this.rubyCount);
         List<Potion> list = Registry.POTION.stream().filter((potion) -> {
            return !potion.getEffects().isEmpty() && PotionBrewing.isBrewablePotion(potion);
         }).collect(Collectors.toList());
         Potion potion = list.get(rand.nextInt(list.size()));
         ItemStack itemstack1 = PotionUtils.addPotionToItemStack(new ItemStack(this.potionStack.getItem(), this.potionCount), potion);
         return new MerchantOffer(itemstack, new ItemStack(this.buyingItem, this.buyingItemCount), itemstack1, this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForEmeraldsAndItemsTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int emeraldCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForEmeraldsAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 1, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForEmeraldsAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, int emeraldCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.emeraldCount = emeraldCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(Items.PUMPKIN, this.emeraldCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForDirtsTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final ItemStack sellingItem;
      private final int dirtCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForDirtsTrade(Block sellingItem, int dirtCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), dirtCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForDirtsTrade(Item sellingItem, int dirtCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), dirtCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForDirtsTrade(Item sellingItem, int dirtCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), dirtCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForDirtsTrade(ItemStack sellingItem, int dirtCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, dirtCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForDirtsTrade(ItemStack sellingItem, int dirtCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.dirtCount = dirtCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(Items.DIRT, this.dirtCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForKirtsTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final ItemStack sellingItem;
      private final int grassBlockCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForKirtsTrade(Block sellingItem, int grassBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), grassBlockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForKirtsTrade(Item sellingItem, int grassBlockCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), grassBlockCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForKirtsTrade(Item sellingItem, int grassBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), grassBlockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForKirtsTrade(ItemStack sellingItem, int grassBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, grassBlockCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForKirtsTrade(ItemStack sellingItem, int grassBlockCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.grassBlockCount = grassBlockCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(Items.GRASS_BLOCK, this.grassBlockCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForEmeraldBlocksTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final ItemStack sellingItem;
      private final int emeraldBlockCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForEmeraldBlocksTrade(Block sellingItem, int emeraldBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), emeraldBlockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForEmeraldBlocksTrade(Item sellingItem, int emeraldBlockCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), emeraldBlockCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForEmeraldBlocksTrade(Item sellingItem, int emeraldBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), emeraldBlockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForEmeraldBlocksTrade(ItemStack sellingItem, int emeraldBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, emeraldBlockCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForEmeraldBlocksTrade(ItemStack sellingItem, int emeraldBlockCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.emeraldBlockCount = emeraldBlockCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(Items.EMERALD_BLOCK, this.emeraldBlockCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForEmeraldOresTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final ItemStack sellingItem;
      private final int emeraldOreCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForEmeraldOresTrade(Block sellingItem, int emeraldOreCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), emeraldOreCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForEmeraldOresTrade(Item sellingItem, int emeraldOreCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), emeraldOreCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForEmeraldOresTrade(Item sellingItem, int emeraldOreCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), emeraldOreCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForEmeraldOresTrade(ItemStack sellingItem, int emeraldOreCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, emeraldOreCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForEmeraldOresTrade(ItemStack sellingItem, int emeraldOreCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.emeraldOreCount = emeraldOreCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(Items.EMERALD_ORE, this.emeraldOreCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForTetetrttwfgedretetredredterrferrtsTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      private final ItemStack sellingItem;
      private final int tetetrttwfgedretetredredterrferrtCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForTetetrttwfgedretetredredterrferrtsTrade(Block sellingItem, int tetetrttwfgedretetredredterrferrtCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), tetetrttwfgedretetredredterrferrtCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForTetetrttwfgedretetredredterrferrtsTrade(Item sellingItem, int tetetrttwfgedretetredredterrferrtCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), tetetrttwfgedretetredredterrferrtCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForTetetrttwfgedretetredredterrferrtsTrade(Item sellingItem, int tetetrttwfgedretetredredterrferrtCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), tetetrttwfgedretetredredterrferrtCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForTetetrttwfgedretetredredterrferrtsTrade(ItemStack sellingItem, int tetetrttwfgedretetredredterrferrtCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, tetetrttwfgedretetredredterrferrtCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForTetetrttwfgedretetredredterrferrtsTrade(ItemStack sellingItem, int tetetrttwfgedretetredredterrferrtCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.tetetrttwfgedretetredredterrferrtCount = tetetrttwfgedretetredredterrferrtCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(ItemInit.TETETRTTWFGEDRETETREDREDTERRFERRT.get(), this.tetetrttwfgedretetredredterrferrtCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class SuspiciousStewForEmeraldTrade implements Ieurjjfjuijjfuhujrijfuhfjzufhzuhuhzdjhjuhugugzfgzzzrhdgugugzrz7rzzzezdhzgeugfdjhguezzrghdTrades.ITrade {
      final Effect effect;
      final int duration;
      final int xpValue;
      private final float priceMultiplier;

      public SuspiciousStewForEmeraldTrade(Effect effectIn, int durationIn, int xpValue) {
         this.effect = effectIn;
         this.duration = durationIn;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         ItemStack itemstack = new ItemStack(Items.SUSPICIOUS_STEW, 1);
         SuspiciousStewItem.addEffect(itemstack, this.effect, this.duration);
         return new MerchantOffer(new ItemStack(Items.EMERALD, 1), itemstack, 12, this.xpValue, this.priceMultiplier);
      }
   }
}