package xyz.jamesbcyber.delightful_compatibility.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.function.Consumer;

/**
 * Farmers Delight Cutting Board
 * CuttingBoardRecipeBuilder.cuttingRecipe()
 * */
public class DCCuttingRecipes
{
	public static void register(Consumer<FinishedRecipe> consumer) {
		// Knife
		cuttingAnimalItems(consumer);
		cuttingVegetables(consumer);
		cuttingFoods(consumer);
		cuttingFlowers(consumer);

		// Pickaxe
		salvagingMinerals(consumer);

		// Axe
		strippingWood(consumer);
		salvagingWoodenFurniture(consumer);

		// Shovel
		diggingSediments(consumer);

		// Shears
		salvagingUsingShears(consumer);
	}

	private static void cuttingAnimalItems(Consumer<FinishedRecipe> consumer) {

	}

	private static void cuttingVegetables(Consumer<FinishedRecipe> consumer) {

	}

	private static void cuttingFoods(Consumer<FinishedRecipe> consumer) {

	}

	private static void cuttingFlowers(Consumer<FinishedRecipe> consumer) {

	}

	private static void salvagingMinerals(Consumer<FinishedRecipe> consumer) {

	}

	private static void strippingWood(Consumer<FinishedRecipe> consumer) {

	}

	private static void salvagingWoodenFurniture(Consumer<FinishedRecipe> consumer) {

	}

	private static void diggingSediments(Consumer<FinishedRecipe> consumer) {

	}

	private static void salvagingUsingShears(Consumer<FinishedRecipe> consumer) {

	}


	/**
	 * Generates an axe-cutting recipe for each furniture, resulting in one plank of the given type.
	 */
	private static void salvagePlankFromFurniture(Consumer<FinishedRecipe> consumer, ItemLike plank, ItemLike door, ItemLike trapdoor, ItemLike sign, ItemLike hangingSign) {

	}

	/**
	 * Generates an axe-stripping recipe for the pair of given logs, with custom sound and a Tree Bark result attached.
	 */
	private static void stripLogForBark(Consumer<FinishedRecipe> consumer, ItemLike log, ItemLike strippedLog) {

	}
}
