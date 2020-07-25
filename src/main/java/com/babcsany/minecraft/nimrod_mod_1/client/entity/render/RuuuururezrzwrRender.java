package com.babcsany.minecraft.nimrod_mod_1.client.entity.render;

import com.babcsany.minecraft.nimrod_mod_1.client.entity.model.RuuuururezrzwrModel;
import com.babcsany.minecraft.nimrod_mod_1.entity.monster.Ruuuururezrzwr;
import net.minecraft.client.renderer.entity.EntityRendererManager;

public class RuuuururezrzwrRender extends AbstractRuuuururezrzwrRender<Ruuuururezrzwr, RuuuururezrzwrModel<Ruuuururezrzwr>> {

    public RuuuururezrzwrRender(EntityRendererManager rendererManager) {
        super(rendererManager, new RuuuururezrzwrModel<>(0.0F, false), new RuuuururezrzwrModel<>(0.5F, true), new RuuuururezrzwrModel<>(1.0F, true));
    }
}
