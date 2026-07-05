package com.prism.genesis.tags;

import com.prism.genesis.Genesis;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> ORE_LIST = of("ore_list");
    private static TagKey<Block> of(String id){
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Genesis.MOD_ID,id));
    }
    public static void registerModBlockTags(){
        Genesis.LOGGER.info("Registering ModBlockTags");
    }
}