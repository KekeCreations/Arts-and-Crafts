package com.kekecreations.arts_and_crafts.core.forge.datagen.server;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ArtsAndCraftsLootTableProvider extends LootTableProvider {
    public ArtsAndCraftsLootTableProvider(PackOutput p_254123_, Set<ResourceKey<LootTable>> p_254481_, List<SubProviderEntry> p_253798_, CompletableFuture<HolderLookup.Provider> p_323798_) {
        super(p_254123_, p_254481_, p_253798_, p_323798_);
    }


    public ArtsAndCraftsLootTableProvider(PackOutput packOutput,  CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(ArtsAndCraftsBlockLootSubProvider::new, LootContextParamSets.BLOCK),
                new SubProviderEntry(ArtsAndCraftsBuiltInLootTableSubProvider::new, LootContextParamSets.BLOCK)
        ), lookupProvider);
    }
}
