package com.kekecreations.arts_and_crafts.datagen.server;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ACLootTableProvider extends LootTableProvider {


    public ACLootTableProvider(PackOutput packOutput,  CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, Collections.emptySet(), List.of(
                new SubProviderEntry(ACBuiltInLootTableProvider::new, LootContextParamSets.BLOCK)
        ), lookupProvider);
    }


}
