package com.babcsany.minecraft.nimrod_mod_1.client.entity.model;

import com.babcsany.minecraft.nimrod_mod_1.entity.monster.Ruuuururezrzwr;
import net.minecraft.client.renderer.entity.model.AbstractZombieModel;

public class RuuuururezrzwrModel<T extends Ruuuururezrzwr> extends AbstractZombieModel<T> {
    public RuuuururezrzwrModel(float modelSize, boolean p_i1168_2_) {
        this(modelSize, 0.0F, 64, p_i1168_2_ ? 32 : 64);
    }

    protected RuuuururezrzwrModel(float p_i48914_1_, float p_i48914_2_, int p_i48914_3_, int p_i48914_4_) {
        super(p_i48914_1_, p_i48914_2_, p_i48914_3_, p_i48914_4_);
    }

    public boolean isAggressive(T entityIn) {
        return entityIn.isAggressive();
    }
}
