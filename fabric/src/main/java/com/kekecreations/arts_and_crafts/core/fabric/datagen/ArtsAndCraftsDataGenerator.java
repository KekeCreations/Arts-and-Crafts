package com.kekecreations.arts_and_crafts.core.fabric.datagen;

import com.kekecreations.arts_and_crafts.core.fabric.datagen.client.ArtsAndCraftsLangProvider;
import com.kekecreations.arts_and_crafts.core.fabric.datagen.server.*;
import com.kekecreations.arts_and_crafts.core.fabric.datagen.client.ArtsAndCraftsModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ArtsAndCraftsDataGenerator implements DataGeneratorEntrypoint {

    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ArtsAndCraftsModelProvider::new);
        pack.addProvider(ArtsAndCraftsBlockTagGenerator::new);
        pack.addProvider(ArtsAndCraftsItemTagGenerator::new);
        pack.addProvider(ArtsAndCraftsLootTableGenerator::new);
        pack.addProvider(ArtsAndCraftsLangProvider::new);
        pack.addProvider(ArtsAndCraftsBiomeTagGenerator::new);
        pack.addProvider(ArtsAndCraftsRecipeProvider::new);
    }
}
