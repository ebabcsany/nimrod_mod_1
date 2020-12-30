package com.babcsany.minecraft.nimrod_mod_1.client.entity.render;

import com.babcsany.minecraft.nimrod_mod_1.Nimrod_mod_1;
import com.babcsany.minecraft.nimrod_mod_1.client.entity.model.QwertrtttModel;
import com.babcsany.minecraft.nimrod_mod_1.entity.QwertrtttEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EnderCrystalRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class QwertrtttRender extends EntityRenderer<QwertrtttEntity> {
   public static final ResourceLocation ENDERCRYSTAL_BEAM_TEXTURES = new ResourceLocation("textures/entity/end_crystal/end_crystal_beam.png");
   private static final ResourceLocation DRAGON_EXPLODING_TEXTURES = new ResourceLocation("textures/entity/enderdragon/dragon_exploding.png");
   private static final ResourceLocation DRAGON_TEXTURES = new ResourceLocation(Nimrod_mod_1.MOD_ID,"textures/entity/qwertrttt.png");
   private static final ResourceLocation field_229052_g_ = new ResourceLocation("textures/entity/enderdragon/dragon_eyes.png");
   private static final RenderType field_229053_h_ = RenderType.getEntityCutoutNoCull(DRAGON_TEXTURES);
   private static final RenderType field_229054_i_ = RenderType.getEntityDecal(DRAGON_TEXTURES);
   private static final RenderType field_229055_j_ = RenderType.getEyes(field_229052_g_);
   private static final RenderType field_229056_k_ = RenderType.getEntitySmoothCutout(ENDERCRYSTAL_BEAM_TEXTURES);
   private static final float field_229057_l_ = (float)(Math.sqrt(3.0D) / 2.0D);
   private final QwertrtttModel model = new QwertrtttModel();

   public QwertrtttRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn);
      this.shadowSize = 0.5F;
   }

   public void render(QwertrtttEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
      matrixStackIn.push();
      float f = (float)entityIn.getMovementOffsets(7, partialTicks)[0];
      float f1 = (float)(entityIn.getMovementOffsets(5, partialTicks)[1] - entityIn.getMovementOffsets(10, partialTicks)[1]);
      matrixStackIn.rotate(Vector3f.YP.rotationDegrees(-f));
      matrixStackIn.rotate(Vector3f.XP.rotationDegrees(f1 * 10.0F));
      matrixStackIn.translate(0.0D, 0.0D, 1.0D);
      matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
      matrixStackIn.translate(0.0D, (double)-1.501F, 0.0D);
      boolean flag = entityIn.hurtTime > 0;
      this.model.setLivingAnimations(entityIn, 0.0F, 0.0F, partialTicks);
      if (entityIn.deathTicks > 0) {
         float f2 = (float)entityIn.deathTicks / 200.0F;
         IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.func_239264_a_(DRAGON_EXPLODING_TEXTURES, f2));
         this.model.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
         IVertexBuilder ivertexbuilder1 = bufferIn.getBuffer(field_229054_i_);
         this.model.render(matrixStackIn, ivertexbuilder1, packedLightIn, OverlayTexture.getPackedUV(0.0F, flag), 1.0F, 1.0F, 1.0F, 1.0F);
      } else {
         IVertexBuilder ivertexbuilder3 = bufferIn.getBuffer(field_229053_h_);
         this.model.render(matrixStackIn, ivertexbuilder3, packedLightIn, OverlayTexture.getPackedUV(0.0F, flag), 1.0F, 1.0F, 1.0F, 1.0F);
      }

      IVertexBuilder ivertexbuilder4 = bufferIn.getBuffer(field_229055_j_);
      this.model.render(matrixStackIn, ivertexbuilder4, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
      if (entityIn.deathTicks > 0) {
         float f5 = ((float)entityIn.deathTicks + partialTicks) / 200.0F;
         float f7 = Math.min(f5 > 0.8F ? (f5 - 0.8F) / 0.2F : 0.0F, 1.0F);
         Random random = new Random(432L);
         IVertexBuilder ivertexbuilder2 = bufferIn.getBuffer(RenderType.getLightning());
         matrixStackIn.push();
         matrixStackIn.translate(0.0D, -1.0D, -2.0D);

         for(int i = 0; (float)i < (f5 + f5 * f5) / 2.0F * 60.0F; ++i) {
            matrixStackIn.rotate(Vector3f.XP.rotationDegrees(random.nextFloat() * 360.0F));
            matrixStackIn.rotate(Vector3f.YP.rotationDegrees(random.nextFloat() * 360.0F));
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(random.nextFloat() * 360.0F));
            matrixStackIn.rotate(Vector3f.XP.rotationDegrees(random.nextFloat() * 360.0F));
            matrixStackIn.rotate(Vector3f.YP.rotationDegrees(random.nextFloat() * 360.0F));
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(random.nextFloat() * 360.0F + f5 * 90.0F));
            float f3 = random.nextFloat() * 20.0F + 5.0F + f7 * 10.0F;
            float f4 = random.nextFloat() * 2.0F + 1.0F + f7 * 2.0F;
            Matrix4f matrix4f = matrixStackIn.getLast().getMatrix();
            int j = (int)(255.0F * (1.0F - f7));
            func_229061_a_(ivertexbuilder2, matrix4f, j);
            func_229060_a_(ivertexbuilder2, matrix4f, f3, f4);
            func_229062_b_(ivertexbuilder2, matrix4f, f3, f4);
            func_229061_a_(ivertexbuilder2, matrix4f, j);
            func_229062_b_(ivertexbuilder2, matrix4f, f3, f4);
            func_229063_c_(ivertexbuilder2, matrix4f, f3, f4);
            func_229061_a_(ivertexbuilder2, matrix4f, j);
            func_229063_c_(ivertexbuilder2, matrix4f, f3, f4);
            func_229060_a_(ivertexbuilder2, matrix4f, f3, f4);
         }

         matrixStackIn.pop();
      }

      matrixStackIn.pop();
      if (entityIn.closestEnderCrystal != null) {
         matrixStackIn.push();
         float f6 = (float)(entityIn.closestEnderCrystal.getPosX() - MathHelper.lerp((double)partialTicks, entityIn.prevPosX, entityIn.getPosX()));
         float f8 = (float)(entityIn.closestEnderCrystal.getPosY() - MathHelper.lerp((double)partialTicks, entityIn.prevPosY, entityIn.getPosY()));
         float f9 = (float)(entityIn.closestEnderCrystal.getPosZ() - MathHelper.lerp((double)partialTicks, entityIn.prevPosZ, entityIn.getPosZ()));
         func_229059_a_(f6, f8 + EnderCrystalRenderer.func_229051_a_(entityIn.closestEnderCrystal, partialTicks), f9, partialTicks, entityIn.ticksExisted, matrixStackIn, bufferIn, packedLightIn);
         matrixStackIn.pop();
      }

      super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
   }

   private static void func_229061_a_(IVertexBuilder p_229061_0_, Matrix4f p_229061_1_, int p_229061_2_) {
      p_229061_0_.pos(p_229061_1_, 0.0F, 0.0F, 0.0F).color(255, 255, 255, p_229061_2_).endVertex();
      p_229061_0_.pos(p_229061_1_, 0.0F, 0.0F, 0.0F).color(255, 255, 255, p_229061_2_).endVertex();
   }

   private static void func_229060_a_(IVertexBuilder p_229060_0_, Matrix4f p_229060_1_, float p_229060_2_, float p_229060_3_) {
      p_229060_0_.pos(p_229060_1_, -field_229057_l_ * p_229060_3_, p_229060_2_, -0.5F * p_229060_3_).color(255, 0, 255, 0).endVertex();
   }

   private static void func_229062_b_(IVertexBuilder p_229062_0_, Matrix4f p_229062_1_, float p_229062_2_, float p_229062_3_) {
      p_229062_0_.pos(p_229062_1_, field_229057_l_ * p_229062_3_, p_229062_2_, -0.5F * p_229062_3_).color(255, 0, 255, 0).endVertex();
   }

   private static void func_229063_c_(IVertexBuilder p_229063_0_, Matrix4f p_229063_1_, float p_229063_2_, float p_229063_3_) {
      p_229063_0_.pos(p_229063_1_, 0.0F, p_229063_2_, 1.0F * p_229063_3_).color(255, 0, 255, 0).endVertex();
   }

   public static void func_229059_a_(float p_229059_0_, float p_229059_1_, float p_229059_2_, float p_229059_3_, int p_229059_4_, MatrixStack p_229059_5_, IRenderTypeBuffer p_229059_6_, int p_229059_7_) {
      float f = MathHelper.sqrt(p_229059_0_ * p_229059_0_ + p_229059_2_ * p_229059_2_);
      float f1 = MathHelper.sqrt(p_229059_0_ * p_229059_0_ + p_229059_1_ * p_229059_1_ + p_229059_2_ * p_229059_2_);
      p_229059_5_.push();
      p_229059_5_.translate(0.0D, 2.0D, 0.0D);
      p_229059_5_.rotate(Vector3f.YP.rotation((float)(-Math.atan2((double)p_229059_2_, (double)p_229059_0_)) - ((float)Math.PI / 2F)));
      p_229059_5_.rotate(Vector3f.XP.rotation((float)(-Math.atan2((double)f, (double)p_229059_1_)) - ((float)Math.PI / 2F)));
      IVertexBuilder ivertexbuilder = p_229059_6_.getBuffer(field_229056_k_);
      float f2 = 0.0F - ((float)p_229059_4_ + p_229059_3_) * 0.01F;
      float f3 = MathHelper.sqrt(p_229059_0_ * p_229059_0_ + p_229059_1_ * p_229059_1_ + p_229059_2_ * p_229059_2_) / 32.0F - ((float)p_229059_4_ + p_229059_3_) * 0.01F;
      int i = 8;
      float f4 = 0.0F;
      float f5 = 0.75F;
      float f6 = 0.0F;
      MatrixStack.Entry matrixstack$entry = p_229059_5_.getLast();
      Matrix4f matrix4f = matrixstack$entry.getMatrix();
      Matrix3f matrix3f = matrixstack$entry.getNormal();

      for(int j = 1; j <= 8; ++j) {
         float f7 = MathHelper.sin((float)j * ((float)Math.PI * 2F) / 8.0F) * 0.75F;
         float f8 = MathHelper.cos((float)j * ((float)Math.PI * 2F) / 8.0F) * 0.75F;
         float f9 = (float)j / 8.0F;
         ivertexbuilder.pos(matrix4f, f4 * 0.2F, f5 * 0.2F, 0.0F).color(0, 0, 0, 255).tex(f6, f2).overlay(OverlayTexture.NO_OVERLAY).lightmap(p_229059_7_).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
         ivertexbuilder.pos(matrix4f, f4, f5, f1).color(255, 255, 255, 255).tex(f6, f3).overlay(OverlayTexture.NO_OVERLAY).lightmap(p_229059_7_).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
         ivertexbuilder.pos(matrix4f, f7, f8, f1).color(255, 255, 255, 255).tex(f9, f3).overlay(OverlayTexture.NO_OVERLAY).lightmap(p_229059_7_).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
         ivertexbuilder.pos(matrix4f, f7 * 0.2F, f8 * 0.2F, 0.0F).color(0, 0, 0, 255).tex(f9, f2).overlay(OverlayTexture.NO_OVERLAY).lightmap(p_229059_7_).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
         f4 = f7;
         f5 = f8;
         f6 = f9;
      }

      p_229059_5_.pop();
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(QwertrtttEntity entity) {
      return DRAGON_TEXTURES;
   }

}