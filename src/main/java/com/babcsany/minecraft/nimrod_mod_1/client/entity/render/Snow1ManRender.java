package com.babcsany.minecraft.nimrod_mod_1.client.entity.render;

import com.babcsany.minecraft.nimrod_mod_1.Nimrod_mod_1;
import com.babcsany.minecraft.nimrod_mod_1.client.entity.layer.Snowman1HeadLayer;
import com.babcsany.minecraft.nimrod_mod_1.client.entity.model.SnowMan1Model;
import com.babcsany.minecraft.nimrod_mod_1.entity.Snow1ManEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Snow1ManRender extends MobRenderer<Snow1ManEntity, SnowMan1Model<Snow1ManEntity>> {
   private static final ResourceLocation SNOW_MAN_TEXTURES = new ResourceLocation(Nimrod_mod_1.MOD_ID,"textures/entity/snow_golem.png");

   public Snow1ManRender(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new SnowMan1Model<>(), 0.5F);
      this.addLayer(new Snowman1HeadLayer(this));
   }

   /**
    * Returns the location of an entity's texture.
    */
   public ResourceLocation getEntityTexture(Snow1ManEntity entity) {
      return SNOW_MAN_TEXTURES;
   }
}