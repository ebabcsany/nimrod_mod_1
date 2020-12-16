package com.babcsany.minecraft.nimrod_mod_1.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.IntegrityProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.function.Function;

public class ExampleFeature extends Feature<NoFeatureConfig> {

    private static final ResourceLocation STRUCTURE_SPINE_01 = new ResourceLocation("fossil/spine_1");
    private static final ResourceLocation STRUCTURE_SPINE_02 = new ResourceLocation("fossil/spine_2");
    private static final ResourceLocation STRUCTURE_SPINE_03 = new ResourceLocation("fossil/spine_3");
    private static final ResourceLocation STRUCTURE_SPINE_04 = new ResourceLocation("fossil/spine_4");
    private static final ResourceLocation[] FOSSILS = new ResourceLocation[] { STRUCTURE_SPINE_01, STRUCTURE_SPINE_02,
            STRUCTURE_SPINE_03, STRUCTURE_SPINE_04 };

    public ExampleFeature(Codec<NoFeatureConfig> config) {
        super(config);
    }

    @Override
    public boolean func_230362_a_(ISeedReader p_230362_1_, StructureManager p_230362_2_, ChunkGenerator p_230362_3_, Random p_230362_4_, BlockPos p_230362_5_, NoFeatureConfig p_230362_6_) {
        return false;
    }

    public boolean place(IWorld worldIn, ChunkGenerator generator, Random rand,
                         BlockPos pos, NoFeatureConfig config) {
        Random random = worldIn.getRandom();
        Rotation rotation = Rotation.values()[random.nextInt(Rotation.values().length)];
        Template template = ((ServerWorld) worldIn.getWorld()).getStructureTemplateManager()
                .getTemplateDefaulted(FOSSILS[random.nextInt(FOSSILS.length)]);
        ChunkPos chunkpos = new ChunkPos(pos);
        PlacementSettings placementsettings = (new PlacementSettings()).setRotation(rotation)
                .setBoundingBox(new MutableBoundingBox(chunkpos.getXStart(), 0, chunkpos.getZStart(),
                        chunkpos.getXEnd(), 256, chunkpos.getZEnd()))
                .setRandom(random).addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK);
        BlockPos blockpos = template.transformedSize(rotation);
        int j = random.nextInt(16 - blockpos.getX());
        int k = random.nextInt(16 - blockpos.getZ());
        int l = 256;
        for (int i1 = 0; i1 < blockpos.getX(); ++i1) {
            for (int j1 = 0; j1 < blockpos.getZ(); ++j1) {
                l = Math.min(l,
                        worldIn.getHeight(Heightmap.Type.WORLD_SURFACE, pos.getX() + i1 + j, pos.getZ() + j1 + k));
            }
        }
        BlockPos blockpos1 = template.getZeroPositionWithTransform(
                new BlockPos(pos.add(j, 0, 0).getX(), l, pos.add(0, 0, k).getZ()), Mirror.NONE, rotation);
        IntegrityProcessor integrityprocessor = new IntegrityProcessor(0.9F);
        placementsettings.clearProcessors().addProcessor(integrityprocessor);
        template.func_237150_a_(blockpos1, rotation, blockpos, Mirror.NONE);
        placementsettings.removeProcessor(integrityprocessor);
        return true;
    }
}