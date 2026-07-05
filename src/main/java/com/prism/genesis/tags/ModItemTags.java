package com.prism.genesis.tags;

import com.prism.genesis.Genesis;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> SUGAR_TAG = of("sugar_tag");
    private static TagKey<Item> of(String id){
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(Genesis.MOD_ID,id));
    }
    public static void registerModItemTags(){
        Genesis.LOGGER.info("Registering ModItemTags");
    }
}
