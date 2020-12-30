package com.babcsany.minecraft.nimrod_mod_1.client.entity.layer;

import com.babcsany.minecraft.nimrod_mod_1.client.entity.model.SnowMan1Model;
import com.babcsany.minecraft.nimrod_mod_1.entity.Snow1ManEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Snowman1HeadLayer extends LayerRenderer<Snow1ManEntity, SnowMan1Model<Snow1ManEntity>> {
   public Snowman1HeadLayer(IEntityRenderer<Snow1ManEntity, SnowMan1Model<Snow1ManEntity>> p_i50922_1_) {
      super(p_i50922_1_);
   }

   public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, Snow1ManEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
      if (!entitylivingbaseIn.isInvisible() && entitylivingbaseIn.isPumpkinEquipped()) {
         matrixStackIn.push();
         this.getEntityModel().func_205070_a().translateRotate(matrixStackIn);
         float f = 0.625F;
         matrixStackIn.translate(0.0D, -0.34375D, 0.0D);
         matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F));
         matrixStackIn.scale(0.625F, -0.625F, -0.625F);
         ItemStack itemstack = new ItemStack(Blocks.CARVED_PUMPKIN);
         Minecraft.getInstance().getItemRenderer().renderItem(entitylivingbaseIn, itemstack, ItemCameraTransforms.TransformType.HEAD, false, matrixStackIn, bufferIn, entitylivingbaseIn.world, packedLightIn, LivingRenderer.getPackedOverlay(entitylivingbaseIn, 0.0F));
         matrixStackIn.pop();
      }
   }
}