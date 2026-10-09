package com.kekecreations.arts_and_crafts.datagen;

import com.kekecreations.arts_and_crafts.datagen.client.ACLanguageProvider;
import com.kekecreations.arts_and_crafts.datagen.client.ACModelProvider;
import com.kekecreations.arts_and_crafts.datagen.server.ACBlockTagsProvider;
import com.kekecreations.arts_and_crafts.datagen.server.ACItemTagsProvider;
import com.kekecreations.arts_and_crafts.datagen.server.ACRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ACDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        // Server Data
        pack.addProvider(ACBlockTagsProvider::new);
        //pack.addProvider(ACCLanguageProvider::new);
        pack.addProvider(ACItemTagsProvider::new);
        pack.addProvider(ACRecipeProvider::new);
        //pack.addProvider(ACCBlockLootTableProvider::new);

        // Client Data
        pack.addProvider(ACModelProvider::new);
        pack.addProvider(ACLanguageProvider::new);
    }
}
