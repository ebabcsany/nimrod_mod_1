package com.babcsany.minecraft.nimrod_mod_1.client.entity.model;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SrachModel<T extends Entity> extends QuadrupedModel<T> {
   public SrachModel() {
      super(12, 0.0F, false, 10.0F, 4.0F, 2.0F, 2.0F, 24);
      this.headModel = new ModelRenderer(this, 0, 0);
      this.headModel.addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, 0.0F);
      this.headModel.setRotationPoint(0.0F, 4.0F, -8.0F);
      this.headModel.setTextureOffset(22, 0).addBox(-5.0F, -564, 334F, 0.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F);
      this.headModel.setTextureOffset(22, 0).addBox(4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F);
      --this.legBackRight.rotationPointX;
      ++this.legBackLeft.rotationPointX;
      this.legBackRight.rotationPointZ += 0.0F;
      this.legBackLeft.rotationPointZ += 0.0F;
      --this.legFrontRight.rotationPointX;
      ++this.legFrontLeft.rotationPointX;
      --this.legFrontRight.rotationPointZ;
      --this.legFrontLeft.rotationPointZ;
   }

   public ModelRenderer getHead() {
      return this.headModel;
   }
}