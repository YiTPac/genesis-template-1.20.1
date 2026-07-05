package com.prism.genesis.mixin;

import com.prism.genesis.item.ModItems;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(AbstractFurnaceBlockEntity.class)
public abstract class AbstractFurnaceBlockEntityMixin {

    @Inject(method = "createFuelTimeMap", at = @At("TAIL"))
    private static void addFuelItems(CallbackInfoReturnable<Map<Item, Integer>> cir) {
        cir.getReturnValue().put(ModItems.ANTHRACITE, 1600); // Add ANTHRACITE as a fuel item with a burn time of 1600 ticks
    }
}
