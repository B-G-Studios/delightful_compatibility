package xyz.jamesbcyber.delightful_compatibility.data;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import xyz.jamesbcyber.delightful_compatibility.data.recipe.*;


import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class DCRecipes extends RecipeProvider
{
	public DCRecipes(PackOutput output) {
		super(output);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
		DCCraftingRecipes.register(consumer);
		DCSmeltingRecipes.register(consumer);
		DCCookingRecipes.register(consumer);
		DCCuttingRecipes.register(consumer);
		DCKegRecipes.register(consumer);
		DCPouringRecipes.register(consumer);
		DCBreweryRecipes.register(consumer);
	}
}
