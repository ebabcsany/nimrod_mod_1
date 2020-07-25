package com.babcsany.minecraft.nimrod_mod_1.client.entity.render;

import com.babcsany.minecraft.nimrod_mod_1.Nimrod_mod_1;
import com.babcsany.minecraft.nimrod_mod_1.client.entity.model.RuuuururezrzwrModel;
import com.babcsany.minecraft.nimrod_mod_1.entity.monster.Ruuuururezrzwr;
import com.babcsany.minecraft.nimrod_mod_1.Nimrod_mod_1;
import com.babcsany.minecraft.nimrod_mod_1.client.entity.model.RuuuururezrzwrModel;
import com.babcsany.minecraft.nimrod_mod_1.entity.monster.Ruuuururezrzwr;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.util.ResourceLocation;

public abstract class AbstractRuuuururezrzwrRender<T extends Ruuuururezrzwr, M extends RuuuururezrzwrModel<T>> extends BipedRenderer<T, M> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Nimrod_mod_1.MOD_ID,
            "textures/entity/ruuuururezrzwr.png");

    protected AbstractRuuuururezrzwrRender(EntityRendererManager p_i50974_1_, M p_i50974_2_, M p_i50974_3_, M p_i50974_4_) {
        super(p_i50974_1_, p_i50974_2_, 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, p_i50974_3_, p_i50974_4_));
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getEntityTexture(T entity) {
        return TEXTURE;
    }

    protected void applyRotations(T entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
    }
}
