package xyz.jamesbcyber.delightful_compatibility.data.recipe;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import umpaz.brewinandchewin.data.builder.KegPouringRecipeBuilder;

import java.util.function.Consumer;

/**
 * Brewin and Chewin Pouring
 * KegPouringRecipeBuilder.kegPouringRecipe()
 *
 * Being able to convert fluids and items
 * needed to be able to pour drinks into kegs
 * */
public class DCPouringRecipes {

    public static void register(Consumer<FinishedRecipe> consumer) {
        pouringRecipes(consumer);
    }

    private static void pouringRecipes(Consumer<FinishedRecipe> consumer) {

    }

    private static ResourceLocation saveName(Item item) {
        ResourceLocation RL = ForgeRegistries.ITEMS.getKey(item);
        return ResourceLocation.fromNamespaceAndPath(RL.getNamespace(), "pouring/" + RL.getPath());
    }
}
