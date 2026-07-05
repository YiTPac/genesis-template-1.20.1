package com.prism.genesis.mixin;

import net.minecraft.client.color.world.GrassColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(GrassColors.class)
public interface GrassColorsMixin {
    @Accessor("colorMap")
    static int[] getColorMap() {
        return new int[] {};
    }

    @Accessor("colorMap")
    static void setColorMap(int[] colorMap) {
        // Implementation for setting the color map
    }
}
