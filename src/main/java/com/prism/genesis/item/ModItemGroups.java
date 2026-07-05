package com.prism.genesis.item;

import com.prism.genesis.Genesis;
import com.prism.genesis.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
//    public static final RegistryKey<ItemGroup> GENESIS_GROUP = register("genesis_group");
//    private static RegistryKey<ItemGroup> register(String id) {
//        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(id));
//    }
//
//    public static void registerItemGroup(){
//        Registry.register(Registries.ITEM_GROUP, GENESIS_GROUP,
//                ItemGroup.create(ItemGroup.Row.TOP, 7)
//                        .displayName(Text.translatable("itemGroup.genesis_group"))
//                        .icon(() -> new ItemStack(ModItems.ICE_ETHER))
//                        .entries((displayContext, entries) -> {
//                            entries.add(ModItems.ICE_ETHER);
//                        }).build());
//
//    }
    public static final ItemGroup GENESIS_GROUP = Registry.register(Registries.ITEM_GROUP,
        Identifier.of(Genesis.MOD_ID,"genesis_group"),
        ItemGroup.create(null, -1)
                .displayName(Text.translatable("itemGroup.genesis_group"))
                .icon(() -> new ItemStack(ModItems.ICE_ETHER))
                .entries((displayContext, entries) -> {
                    entries.add(ModItems.ICE_ETHER);
                    entries.add(ModItems.RAW_ICE_ETHER);
                    entries.add(ModItems.ANTHRACITE);
                    entries.add(ModBlocks.ICE_ETHER_ORE);
                    entries.add(ModBlocks.RAW_ICE_ETHER_BLOCK);
                    entries.add(ModBlocks.ICE_ETHER_BLOCK);
                    entries.add(ModItems.CHEESE);
                    entries.add(ModItems.STRAWBERRY);
                    entries.add(ModItems.ANTHRACITE);
                    entries.add(ModItems.PROSPECTOR);
                }).build());
    public static void registerModItemGroups(){
        Genesis.LOGGER.info("Registering Item Groups");
    }
}
