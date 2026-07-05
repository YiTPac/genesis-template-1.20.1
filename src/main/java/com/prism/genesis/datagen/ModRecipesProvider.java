package com.prism.genesis.datagen;

import com.prism.genesis.Genesis;
import com.prism.genesis.block.ModBlocks;
import com.prism.genesis.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipesProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> ICE_ETHER_INGEDIANTS = List.of(ModItems.RAW_ICE_ETHER, Items.ICE, ModBlocks.ICE_ETHER_ORE);

    public ModRecipesProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.ICE_ETHER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ETHER_BLOCK);
        offerSmelting(exporter, ICE_ETHER_INGEDIANTS, RecipeCategory.MISC, ModItems.ICE_ETHER, 0.7f, 200, "ice_ether");
        offerBlasting(exporter, ICE_ETHER_INGEDIANTS, RecipeCategory.MISC, ModItems.ICE_ETHER, 0.7f, 100, "ice_ether");
        offerFoodCookingRecipe(exporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING,600, ModItems.RAW_ICE_ETHER, ModItems.ICE_ETHER,0.35f);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SUGAR)
                .pattern("###")
                .input('#', Ingredient.ofItems(Items.BEETROOT))
                .criterion("has_item", conditionsFromItem(Items.BEETROOT))
                .offerTo(exporter, Identifier.of(Genesis.MOD_ID, "beetroot_to_sugar"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ETHER_ORE)
                .input(ModItems.RAW_ICE_ETHER)
                .input(Items.STONE)
                .criterion("has_item", conditionsFromItem(ModItems.RAW_ICE_ETHER))
                .offerTo(exporter, Identifier.of(Genesis.MOD_ID, "ice_ether_ore"));
    }
}
