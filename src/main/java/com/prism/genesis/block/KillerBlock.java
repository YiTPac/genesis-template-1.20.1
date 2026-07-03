package com.prism.genesis.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.awt.*;

public class KillerBlock extends Block {
    public KillerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        entity.sendMessage(Text.literal("Haha"));
        entity.kill();
        world.removeBlock(pos, false);
        super.onSteppedOn(world, pos, state, entity);
    }
}
