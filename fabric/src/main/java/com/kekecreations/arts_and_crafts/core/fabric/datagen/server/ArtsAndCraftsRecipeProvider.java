package com.kekecreations.arts_and_crafts.core.fabric.datagen.server;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class ArtsAndCraftsRecipeProvider extends FabricRecipeProvider {
    public ArtsAndCraftsRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {

    }
}
