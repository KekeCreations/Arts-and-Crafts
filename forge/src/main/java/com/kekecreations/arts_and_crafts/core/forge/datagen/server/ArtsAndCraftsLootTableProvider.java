package com.kekecreations.arts_and_crafts.core.forge.datagen.server;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ArtsAndCraftsLootTableProvider extends LootTableProvider {
    public ArtsAndCraftsLootTableProvider(PackOutput p_254123_, Set<ResourceLocation> p_254481_, List<SubProviderEntry> p_253798_) {
        super(p_254123_, p_254481_, p_253798_);
    }

    public ArtsAndCraftsLootTableProvider(PackOutput packOutput) {
        super(packOutput, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(ArtsAndCraftsBlockLootSubProvider::new, LootContextParamSets.BLOCK),
                new SubProviderEntry(ArtsAndCraftsBuiltInLootTableSubProvider::new, LootContextParamSets.BLOCK)
        ));
    }
}
