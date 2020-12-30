package com.babcsany.minecraft.nimrod_mod_1.world.dimension;

import com.babcsany.minecraft.nimrod_mod_1.init.BlockInit;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class BrbrvirirBiomeSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public BrbrvirirBiomeSurfaceBuilder(Codec<SurfaceBuilderConfig> function) {
		super(function);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		Random rd = new Random();
		int i = rd.nextInt(3);
		if (i == 0) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(BlockInit.BLACK_BEDROCK.get().getDefaultState(),
							BlockInit.JHUKJNJI_BLOCK.get().getDefaultState(), BlockInit.ZWZHSGDGSF.get().getDefaultState()));
		} else {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(
							i == 1 ? Blocks.GRASS_BLOCK.getDefaultState()
									: BlockInit.QERTZUIOPR.get().getDefaultState(),
							BlockInit.TDIYFXFVDZTDSGFCFDC.get().getDefaultState(), BlockInit.WUEUZEUZEZHSZWS.get().getDefaultState()));
		}
	}
}
