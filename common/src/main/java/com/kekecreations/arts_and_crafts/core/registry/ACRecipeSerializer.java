package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.recipe.BleachBannerPatternsRecipe;
import com.kekecreations.jinxedlib.core.util.JinxedRegistryHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Supplier;

public class ACRecipeSerializer {





    public static final Supplier<RecipeSerializer<BleachBannerPatternsRecipe>> BLEACH_BANNER_PATTERNS_RECIPE = registerRecipe("crafting_bleach_banner_patterns",   new CustomRecipe.Serializer<>(BleachBannerPatternsRecipe::new));



    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> Supplier registerRecipe(String string, RecipeSerializer<?> recipeSerializer) {
        return JinxedRegistryHelper.register(BuiltInRegistries.RECIPE_SERIALIZER, ArtsAndCrafts.MOD_ID, string, () -> recipeSerializer);
    }







    public static void register() {
    }
}
