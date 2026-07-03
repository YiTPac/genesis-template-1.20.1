package com.prism.genesis.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CHEESE = new FoodComponent.Builder().hunger(8).saturationModifier(0.8F)
            .alwaysEdible()
            .build();
    public static final FoodComponent STRAWBERRY = new FoodComponent.Builder().hunger(4).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600, 1), 1.0f)
            .alwaysEdible()
            .build();
}
