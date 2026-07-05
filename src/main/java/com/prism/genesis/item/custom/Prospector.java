package com.prism.genesis.item.custom;

import com.sun.jna.platform.unix.X11;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
            if (!player.isSneaking()) {
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
                            if (isRightBlock(blockState)){
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
            }else {
                for (int i = 0; i <= pos.getY() + 64; i++) {
                    if (foundBlock) {
                        break;
                    }
                    BlockPos pos1 = pos.down(i);
                    BlockState blockState = world.getBlockState(pos1);
                    String name = blockState.getBlock().getName().getString();
                    if (isRightBlock(blockState)){
                        player.sendMessage(Text.of("[精确搜索] 找到" + name + "!"));
                        foundBlock = true;
                    }
                }
                if (!foundBlock) {
                    player.sendMessage(Text.of("[精确搜索] 未找到矿物"));
                }
            }
            context.getStack().damage(1, player, (playerEntity) -> playerEntity.sendToolBreakStatus(context.getHand()));
            return ActionResult.SUCCESS;
        }
        return super.useOnBlock(context);
    }

    private boolean isRightBlock(BlockState blockState) {
        if (blockState.isOf(Blocks.DIAMOND_ORE)) {
            return true;
        }else{
            return false;
        }
    }
}
