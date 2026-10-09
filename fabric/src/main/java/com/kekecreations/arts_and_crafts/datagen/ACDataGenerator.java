package com.kekecreations.arts_and_crafts.datagen;

import com.kekecreations.arts_and_crafts.datagen.client.ACLanguageProvider;
import com.kekecreations.arts_and_crafts.datagen.client.ACModelProvider;
import com.kekecreations.arts_and_crafts.datagen.server.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ACDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        // Server Data
        pack.addProvider(ACBlockTagsProvider::new);
        pack.addProvider(ACItemTagsProvider::new);
        pack.addProvider(ACRecipeProvider::new);
        pack.addProvider(ACBlockLootTableProvider::new);
        pack.addProvider(ACLootTableProvider::new);

        // Client Data
        pack.addProvider(ACModelProvider::new);
        pack.addProvider(ACLanguageProvider::new);
    }
}
