package com.prism.genesis.item.custom;

import com.prism.genesis.tags.ModBlockTags;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Prospector extends Item {

    public Prospector(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        if (!world.isClient()) {
            boolean foundBlock = false;
            if (player != null && !player.isSneaking()) {
                for (int i = 0; i <= pos.getY() + 64; i++) {
                    for (int j = 0; j < 5; j++) {
                        for (int k = 0; k < 5; k++) {
                            if (foundBlock) {
                                break;
                            }
                            BlockPos pos1 = pos.down(i).north(j - 2).east(k - 2);
                            BlockState blockState = world.getBlockState(pos1);
                            String name = blockState.getBlock().getName().getString();
                            //world.breakBlock(pos1, false);
                            if (isRightBlock(blockState)) {
                                player.sendMessage(Text.of("[粗略搜索] 找到" + name + "!"));
                                foundBlock = true;
                            }
                            //world.breakBlock(pos1, false);
                            //player.sendMessage(Text.literal("Block at " + pos1.getX() + ", " + pos1.getY() + ", " + pos1.getZ() + ": " + name), false);
                        }
                    }
                }
                if (!foundBlock) {
                    player.sendMessage(Text.of("[粗略搜索] 未找到矿物"));
                }
            }
            context.getStack().damage(1, player, (playerEntity) -> playerEntity.sendToolBreakStatus(context.getHand()));
            return ActionResult.SUCCESS;
        }
        return super.useOnBlock(context);
    }

    private boolean isRightBlock(BlockState blockState) {
        if (blockState.isIn(ModBlockTags.ORE_LIST)) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if (true) {
            tooltip.add(Text.translatable("item.tutorialmod.prospector.shift_tooltip"));
        } else {
            tooltip.add(Text.translatable("item.tutorialmod.prospector.tooltip"));
        }
    }
}
