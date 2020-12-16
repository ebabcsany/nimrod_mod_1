package com.babcsany.minecraft.nimrod_mod_1.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FoodInit {

    public static final Food JAM = (new Food.Builder()).hunger(10).saturation(3.4F).effect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 600, 1000), 1000F).fastToEat().build();
    public static final Food JAM1 = (new Food.Builder()).hunger(10).saturation(3.4F).effect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 60000, 10000), 10000F).fastToEat().build();
    public static final Food SICLE_OF_BREAD = (new Food.Builder()).hunger(10).saturation(3.4F).effect(new EffectInstance(Effects.INSTANT_HEALTH, 10, 1000000000), 1000000000F).fastToEat().build();
}
