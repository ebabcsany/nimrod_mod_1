package com.babcsany.minecraft.nimrod_mod_1.client.entity.render;

import com.babcsany.minecraft.nimrod_mod_1.Nimrod_mod_1;
import com.babcsany.minecraft.nimrod_mod_1.client.entity.layer.ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdChargeLayer;
import com.babcsany.minecraft.nimrod_mod_1.entity.monster.ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CreeperChargeLayer;
import net.minecraft.client.renderer.entity.model.CreeperModel;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdRender extends MobRenderer<ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdEntity, CreeperModel<ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdEntity>> {
   private static final ResourceLocation CREEPER_TEXTURES = new ResourceLocation(Nimrod_mod_1.MOD_ID,"textures/entity/zedgfcvxygdgxvcgfdgchgjvnbbfhdzrthd.png");

   public ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new CreeperModel<>(), 0.5F);
      this.addLayer(new ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdChargeLayer(this));
   }

   protected void preRenderCallback(ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
      float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);
      float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
      f = MathHelper.clamp(f, 0.0F, 1.0F);
      f = f * f;
      f = f * f;
      float f2 = (1.0F + f * 0.4F) * f1;
      float f3 = (1.0F + f * 0.1F) / f1;
      matrixStackIn.scale(f2, f3, f2);
   }

   protected float getOverlayProgress(ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdEntity livingEntityIn, float partialTicks) {
      float f = livingEntityIn.getCreeperFlashIntensity(partialTicks);
      return (int)(f * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(f, 0.5F, 1.0F);
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(ZedgfcvxygdgxvcgfdgchgjvnbbfhdzrthdEntity entity) {
      return CREEPER_TEXTURES;
   }
}