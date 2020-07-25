package com.babcsany.minecraft.nimrod_mod_1.init;

import com.babcsany.minecraft.nimrod_mod_1.Nimrod_mod_1;
import com.babcsany.minecraft.nimrod_mod_1.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Nimrod_mod_1.MOD_ID);

    public static final RegistryObject<Block> PLMK_BLOCK = BLOCKS.register("plmk_block", () -> new PlmkBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(-1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(100000000000000.0f)
    ));
    public static final RegistryObject<Block> WUEUZEUZEZHSZWS = BLOCKS.register("wueuzeuzezhszws", () -> new Wueuzeuzezhszws(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(76)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(6767367467757465757464686465444865686.0f)
    ));
    public static final RegistryObject<Block> ZWZHSGDGSF = BLOCKS.register("zwzhsgdgsf", () -> new Zwzhsgdgsf(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(464)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(99999999999999999999999999999999999999.0f)
    ));
    public static final RegistryObject<Block> JHUKJNJI_BLOCK = BLOCKS.register("jhukjnji_block", () -> new JhukjnjiBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(777)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(99999999999999999999999999999999999999.0f)
    ));
    public static final RegistryObject<Block> OM = BLOCKS.register("om", () -> new Om(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(33)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(900000000000000000000000000000000.0f)
    ));
}
