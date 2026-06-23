package xyz.jamesbcyber.delightful_compatibility.data.builder;

import com.google.gson.*;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import net.satisfy.brewery.core.block.property.BrewMaterial;
import net.satisfy.brewery.core.registry.RecipeTypeRegistry;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Consumer;

public class LetsDoBreweryRecipeBuilder {
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final BrewMaterial brewMaterial;
    private final Item result;

    private LetsDoBreweryRecipeBuilder(BrewMaterial brewMaterial, Item result) {
        this.brewMaterial = brewMaterial;
        this.result = result;
    }

    public static LetsDoBreweryRecipeBuilder breweryRecipe(BrewMaterial brewMaterial, Item result){
        return new LetsDoBreweryRecipeBuilder(brewMaterial, result);
    }

    public LetsDoBreweryRecipeBuilder addIngredient(TagKey<Item> tagIn) {
        return addIngredient(Ingredient.of(tagIn));
    }

    public LetsDoBreweryRecipeBuilder addIngredient(ItemLike itemIn) {
        return addIngredient(itemIn, 1);
    }

    public LetsDoBreweryRecipeBuilder addIngredient(ItemLike itemIn, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            addIngredient(Ingredient.of(itemIn));
        }
        return this;
    }

    public LetsDoBreweryRecipeBuilder addIngredient(Ingredient ingredientIn) {
        return addIngredient(ingredientIn, 1);
    }

    public LetsDoBreweryRecipeBuilder addIngredient(Ingredient ingredientIn, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            ingredients.add(ingredientIn);
        }
        return this;
    }

    public void build(Consumer<FinishedRecipe> consumerIn) {
        if (ingredients.size() == 0) {
            throw new IllegalStateException("Ingredients can not be empty");
        } else if (ingredients.size() > 3) {
            throw new IllegalStateException("Ingredients can not have more than 3 items");
        }
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(result);
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("brewery", "brewing/" + location.getPath());

        consumerIn.accept(new LetsDoBreweryRecipeBuilder.Result(id, this.ingredients, this.brewMaterial, this.result));
    }


    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final List<Ingredient>  ingredients;
        private final BrewMaterial brewMaterial;
        private final Item result;

        public Result(ResourceLocation id, List<Ingredient> ingredients, BrewMaterial brewMaterial, Item result) {
            this.id = id;
            this.ingredients = ingredients;
            this.brewMaterial = brewMaterial;
            this.result = result;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonArray arrayIngredients = new JsonArray();
            for (Ingredient ingredient : this.ingredients) {
                arrayIngredients.add(ingredient.toJson());
            }
            json.add("ingredients", arrayIngredients);

            json.addProperty("material", brewMaterial.getSerializedName().toUpperCase());

            JsonObject jsonResult = new JsonObject();
            jsonResult.addProperty("item", ForgeRegistries.ITEMS.getKey(result).toString());
            json.add("result", jsonResult);

        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return RecipeTypeRegistry.BREWING_RECIPE_SERIALIZER.get();
        }

        @Override
        public @Nullable JsonObject serializeAdvancement() {
            return null;
        }

        @Override
        public @Nullable ResourceLocation getAdvancementId() {
            return null;
        }
    }

}
