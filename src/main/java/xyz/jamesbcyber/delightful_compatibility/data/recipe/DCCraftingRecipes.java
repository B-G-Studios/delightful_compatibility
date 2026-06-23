package xyz.jamesbcyber.delightful_compatibility.data.recipe;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;

import java.util.function.Consumer;

/**
 * Minecraft Crafting
 * ShapedRecipeBuilder.shaped()
 * ShapelessRecipeBuilder.shapeless()
 * */
public class DCCraftingRecipes
{
	public static void register(Consumer<FinishedRecipe> consumer) {
		recipesVanillaAlternatives(consumer);
		recipesBlocks(consumer);
		recipesCanvasSigns(consumer);
		recipesTools(consumer);
		recipesMaterials(consumer);
		recipesFoodstuffs(consumer);
		recipesFoodBlocks(consumer);
		recipesCraftedMeals(consumer);
	}

	public static void canvasSignDyeing(Consumer<FinishedRecipe> consumer, ItemLike canvasSign, ItemLike hangingCanvasSign, TagKey<Item> dyeTag) {

	}

	private static void recipesVanillaAlternatives(Consumer<FinishedRecipe> consumer) {

	}

	private static void recipesCanvasSigns(Consumer<FinishedRecipe> consumer) {

	}

	private static void recipesBlocks(Consumer<FinishedRecipe> consumer) {

	}

	private static void recipesTools(Consumer<FinishedRecipe> consumer) {

	}

	private static void recipesMaterials(Consumer<FinishedRecipe> consumer) {

	}

	private static void recipesFoodstuffs(Consumer<FinishedRecipe> consumer) {

	}

	private static void recipesFoodBlocks(Consumer<FinishedRecipe> consumer) {

	}

	private static void recipesCraftedMeals(Consumer<FinishedRecipe> consumer) {

	}
}
