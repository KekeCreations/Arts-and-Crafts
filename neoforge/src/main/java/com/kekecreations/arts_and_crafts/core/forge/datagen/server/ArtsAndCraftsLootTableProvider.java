package com.kekecreations.arts_and_crafts.core.forge.datagen.server;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ArtsAndCraftsLootTableProvider extends LootTableProvider {


    public ArtsAndCraftsLootTableProvider(PackOutput packOutput,  CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(ArtsAndCraftsBlockLootSubProvider::new, LootContextParamSets.BLOCK),
                new SubProviderEntry(ArtsAndCraftsBuiltInLootTableSubProvider::new, LootContextParamSets.BLOCK)
        ), lookupProvider);
    }
}
