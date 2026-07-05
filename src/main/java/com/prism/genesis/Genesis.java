package com.prism.genesis;

import com.prism.genesis.block.ModBlocks;
import com.prism.genesis.item.ModItemGroups;
import com.prism.genesis.item.ModItems;
import com.prism.genesis.mixin.GrassColorsMixin;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class Genesis implements ModInitializer {
	public static final String MOD_ID = "genesis";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.registerModItems();
		ModItemGroups.registerModItemGroups();
		ModBlocks.registerModBlocks();

		int[] colorMap = GrassColorsMixin.getColorMap();
		LOGGER.info("Retrieved color map with {} entries", colorMap.length);

		LOGGER.info("Hello Fabric world!");
	}
}