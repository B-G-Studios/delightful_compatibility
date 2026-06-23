package xyz.jamesbcyber.delightful_compatibility.data.recipe;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

/**
 * Minecraft Smelting
 * SimpleCookingRecipeBuilder.smelting()
 * SimpleCookingRecipeBuilder.blasting()
 * SimpleCookingRecipeBuilder.smoking()
 * SimpleCookingRecipeBuilder.campfireCooking()
 * */
public class DCSmeltingRecipes
{
	public static void register(Consumer<FinishedRecipe> consumer) {

	}

	private static void foodSmeltingRecipes(String name, ItemLike ingredient, ItemLike result, float experience, Consumer<FinishedRecipe> consumer) {
		String namePrefix = ResourceLocation.fromNamespaceAndPath(ForgeRegistries.ITEMS.getKey(result.asItem()).getNamespace(), name).toString();
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 200)
				.unlockedBy(name, InventoryChangeTrigger.TriggerInstance.hasItems(ingredient))
				.save(consumer);
		SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 600)
				.unlockedBy(name, InventoryChangeTrigger.TriggerInstance.hasItems(ingredient))
				.save(consumer, namePrefix + "_from_campfire_cooking");
		SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 100)
				.unlockedBy(name, InventoryChangeTrigger.TriggerInstance.hasItems(ingredient))
				.save(consumer, namePrefix + "_from_smoking");
	}
}
