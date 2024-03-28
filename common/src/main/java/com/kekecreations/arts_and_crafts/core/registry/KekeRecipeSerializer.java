package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.recipe.DyedDecoratedPotRecipe;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.DecoratedPotRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;

public class KekeRecipeSerializer<T extends Recipe<?>> {

    public static final RecipeSerializer<DecoratedPotRecipe> DYED_DECORATED_POT_RECIPE = registerRecipe("crafting_dyed_decorated_pot", new SimpleCraftingRecipeSerializer(DyedDecoratedPotRecipe::new));


    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> S registerRecipe(String string, S recipeSerializer) {
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, ArtsAndCrafts.id(string), recipeSerializer);
    }

    public static void register() {
    }
}
