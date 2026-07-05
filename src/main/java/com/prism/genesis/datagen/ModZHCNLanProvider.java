package com.prism.genesis.datagen;

import com.prism.genesis.block.ModBlocks;
import com.prism.genesis.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModZHCNLanProvider extends FabricLanguageProvider {

    public ModZHCNLanProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "zh_cn");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.ICE_ETHER, "冰以太");
        translationBuilder.add(ModItems.RAW_ICE_ETHER, "粗冰以太");
        translationBuilder.add(ModItems.CHEESE, "奶酪");
        translationBuilder.add(ModItems.STRAWBERRY, "草莓");
        translationBuilder.add(ModItems.PROSPECTOR, "探矿器");
        translationBuilder.add(ModItems.ANTHRACITE, "无烟煤");

        translationBuilder.add(ModBlocks.ICE_ETHER_BLOCK, "冰以太块");
        translationBuilder.add(ModBlocks.ICE_ETHER_ORE, "冰以太矿石");
        translationBuilder.add(ModBlocks.RAW_ICE_ETHER_BLOCK, "粗冰以太块");

        translationBuilder.add("itemGroup.genesis_group", "创世");
    }
}
