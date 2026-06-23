package xyz.jamesbcyber.delightful_compatibility.data.recipe;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;
import net.satisfy.brewery.core.block.property.BrewMaterial;
import xyz.jamesbcyber.delightful_compatibility.data.builder.LetsDoBreweryRecipeBuilder;

import java.util.function.Consumer;

/**
 * Let's Do Brewery
 * */
public class DCBreweryRecipes {

    public static void register(Consumer<FinishedRecipe> consumer) {
        breweryRecipes(consumer);
    }

    private static void breweryRecipes(Consumer<FinishedRecipe> consumer) {
//        LetsDoBreweryRecipeBuilder.breweryRecipe(BrewMaterial.WOOD, Items.ACACIA_BUTTON)
//                .addIngredient(Items.ACACIA_DOOR)
//                .build(consumer);
    }

}
