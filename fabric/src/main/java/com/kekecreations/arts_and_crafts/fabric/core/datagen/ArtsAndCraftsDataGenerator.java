package com.kekecreations.arts_and_crafts.fabric.core.datagen;

import com.kekecreations.arts_and_crafts.fabric.core.datagen.client.ArtsAndCraftsModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ArtsAndCraftsDataGenerator implements DataGeneratorEntrypoint {

    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ArtsAndCraftsModelProvider::new);
    }
}
