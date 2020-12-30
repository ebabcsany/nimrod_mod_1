package com.babcsany.minecraft.nimrod_mod_1.init;

import com.babcsany.minecraft.nimrod_mod_1.Nimrod_mod_1;
import com.babcsany.minecraft.nimrod_mod_1.block.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Nimrod_mod_1.MOD_ID);

    public static final RegistryObject<Block> PLMK_BLOCK = BLOCKS.register("plmk_block", () -> new PlmkBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(-1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(100000000000000.0f)
    ));
    public static final RegistryObject<Block> WUEUZEUZEZHSZWS = BLOCKS.register("wueuzeuzezhszws", () -> new Wueuzeuzezhszws(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(76)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(6767367467757465757464686465444865686.0f)
    ));
    public static final RegistryObject<Block> ZWZHSGDGSF = BLOCKS.register("zwzhsgdgsf", () -> new Zwzhsgdgsf(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(464)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(99999999999999999999999999999999999999.0f)
    ));
    public static final RegistryObject<Block> JHUKJNJI_BLOCK = BLOCKS.register("jhukjnji_block", () -> new JhukjnjiBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(777)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(99999999999999999999999999999999999999.0f)
    ));
    public static final RegistryObject<Block> OM = BLOCKS.register("om", () -> new Om(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(33)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(900000000000000000000000000000000.0f)
    ));
    public static final RegistryObject<Block> BLACK_BEDROCK = BLOCKS.register("black_bedrock", () -> new BlackBedrock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(1000)
                    .hardnessAndResistance(900000000000000000000000000000000.0f)
    ));
    public static final RegistryObject<Block> STONE1 = BLOCKS.register("stone1", () -> new Stone1(
            Block.Properties.create(Material.ROCK, MaterialColor.STONE)
                    .setRequiresTool()
                    .doesNotBlockMovement()
                    .harvestLevel(1)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> QERTZUIOPR = BLOCKS.register("qertzuiopu", () -> new QERTZUIOPUBlock(
            AbstractBlock.Properties.create(Material.ROCK)
                    .zeroHardnessAndResistance()
                    .sound(SoundType.PLANT)
    ));
    public static final RegistryObject<Block> TDIYFXFVDZTDSGFCFDC = BLOCKS.register("tdiyfxfvdztdsgfcfdc", () -> new TDIYFXFVDZTDSGFCFDCBlock(
            AbstractBlock.Properties.create(Material.ROCK)
                    .zeroHardnessAndResistance()
                    .sound(SoundType.PLANT)
    ));
    public static final RegistryObject<Block> L971237GZGDUGHDGJGHRHDDHDDHCVJGE = BLOCKS.register("971237gzgdughdgjghrhddhddhcvjge", () -> new OreBlock1(
            AbstractBlock.Properties.create(Material.ROCK)
                    .zeroHardnessAndResistance()
                    .sound(SoundType.PLANT)
    ));
    public static final RegistryObject<Block> BONE_SLAB = BLOCKS.register("bone_slab", () -> new BoneSlab(
            Block.Properties.create(Material.ROCK, MaterialColor.STONE)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> CRAFTING_BLOCK = BLOCKS.register("crafting_block", () -> new CraftingBlock(
            Block.Properties.create(Material.ROCK, MaterialColor.STONE)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
}
