package xyz.jamesbcyber.delightful_compatibility.data.recipe;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import umpaz.brewinandchewin.data.builder.KegFermentingRecipeBuilder;

import java.util.function.Consumer;

/**
 * Brewin and Chewin Keg
 * KegFermentingRecipeBuilder.kegFermentingRecipe()
 * */
public class DCKegRecipes {
    public static final int FAST_FERMENTING = 4800;      // 4 minutes
    public static final int NORMAL_FERMENTING = 9600;    // 8 minutes
    public static final int SLOW_FERMENTING = 12000;    // 10 minutes

    public static final float SMALL_EXP = 0.5F;
    public static final float MEDIUM_EXP = 1.0F;
    public static final float LARGE_EXP = 2.0F;

    public static void register(Consumer<FinishedRecipe> consumer) {
        kegRecipes(consumer);
    }

    private static void kegRecipes(Consumer<FinishedRecipe> consumer) {

    }

    private static ResourceLocation saveName(Item item) {
        ResourceLocation RL = ForgeRegistries.ITEMS.getKey(item);
        return ResourceLocation.fromNamespaceAndPath(RL.getNamespace(), "fermenting/" + RL.getPath());
    }
}
