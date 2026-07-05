package com.prism.genesis.item;

import com.prism.genesis.Genesis;
import com.prism.genesis.item.custom.Prospector;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    public static final Item ICE_ETHER = registerItems("ice_ether", new Item(new Item.Settings().maxCount(63)));
    public static final Item CHEESE = registerItems("cheese", new Item(new Item.Settings().food(ModFoodComponents.CHEESE)));
    public static final Item STRAWBERRY = registerItems("strawberry", new Item(new Item.Settings().food(ModFoodComponents.STRAWBERRY)));
    //public static final Item ICE_ETHER = registerItems("ice_ether", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(0).maxCount(63)));
    public static final Item RAW_ICE_ETHER = registerItems("raw_ice_ether", new Item(new Item.Settings()));
    public static final Item ANTHRACITE = registerItems("anthracite", new Item(new Item.Settings()));
    public static final Item PROSPECTOR = registerItems("prospector", new Prospector(new Item.Settings().maxCount(127)));

    private static Item registerItems(String id, Item item){
        //return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(Genesis.MOD_ID, id)), item);
        return Registry.register(Registries.ITEM, Identifier.of(Genesis.MOD_ID, id), item);
    }
    public static void registerModItems(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToItemGroup);
        Genesis.LOGGER.info("Registering Items");
    }

    private static void addItemToItemGroup(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(ICE_ETHER);
    }
}
