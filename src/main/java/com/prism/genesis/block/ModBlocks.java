package com.prism.genesis.block;

import com.prism.genesis.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import com.prism.genesis.Genesis;
import net.minecraft.util.Identifier;
import net.minecraft.item.Item.Settings;

public class ModBlocks {
    public static final Block ICE_ETHER_BLOCK = register("ice_ether_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(3.0f,3.0f)));
    public static final Block ICE_ETHER_ORE = register("ice_ether_ore", new Block(AbstractBlock.Settings.create().requiresTool().strength(4.5f,6.0f)));
    public static final Block RAW_ICE_ETHER_BLOCK = register("raw_ice_ether_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(3.0f,3.0f)));
    public static void registerBlockItems(String id, Block block) {
        BlockItem item = Registry.register(Registries.ITEM, new Identifier(Genesis.MOD_ID, id), new BlockItem(block, new Settings()));
        if (item instanceof BlockItem) {
            item.appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }

    public static Block register(String id, Block block) {
        registerBlockItems(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Genesis.MOD_ID, id), block);
    }

    public static void registerModBlocks(){
        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToItemGroup);
    }
}
