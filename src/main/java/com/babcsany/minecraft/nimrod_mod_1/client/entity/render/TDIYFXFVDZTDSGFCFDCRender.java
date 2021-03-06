package com.babcsany.minecraft.nimrod_mod_1.client.entity.render;

import com.babcsany.minecraft.nimrod_mod_1.entity.QERTZUIOPUEntity;
import com.babcsany.minecraft.nimrod_mod_1.entity.TDIYFXFVDZTDSGFCFDCEntity;
import com.babcsany.minecraft.nimrod_mod_1.init.BlockInit;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.TNTMinecartRenderer;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TDIYFXFVDZTDSGFCFDCRender extends EntityRenderer<TDIYFXFVDZTDSGFCFDCEntity> {
   public TDIYFXFVDZTDSGFCFDCRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn);
      this.shadowSize = 0.5F;
   }

   /*@Override
   public ResourceLocation getEntityTexture(QERTZUIOPUEntity entity) {
      return null;
   }*/

   public void render(TDIYFXFVDZTDSGFCFDCEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
      matrixStackIn.push();
      matrixStackIn.translate(0.0D, 0.5D, 0.0D);
      if ((float)entityIn.getFuse() - partialTicks + 1.0F < 10.0F) {
         float f = 1.0F - ((float)entityIn.getFuse() - partialTicks + 1.0F) / 10.0F;
         f = MathHelper.clamp(f, 0.0F, 1.0F);
         f = f * f;
         f = f * f;
         float f1 = 1.0F + f * 0.3F;
         matrixStackIn.scale(f1, f1, f1);
      }

      matrixStackIn.rotate(Vector3f.YP.rotationDegrees(-90.0F));
      matrixStackIn.translate(-0.5D, -0.5D, 0.5D);
      matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90.0F));
      TNTMinecartRenderer.renderTntFlash(BlockInit.TDIYFXFVDZTDSGFCFDC.get().getDefaultState(), matrixStackIn, bufferIn, packedLightIn, entityIn.getFuse() / 5 % 2 == 0);
      matrixStackIn.pop();
      super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(TDIYFXFVDZTDSGFCFDCEntity entity) {
      return AtlasTexture.LOCATION_BLOCKS_TEXTURE;
   }
}