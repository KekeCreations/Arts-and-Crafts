package com.kekecreations.arts_and_crafts.core.forge.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.ArtsAndCraftsBuiltInLootTables;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class ArtsAndCraftsBuiltInLootTableSubProvider implements LootTableSubProvider {
    private final HolderLookup.Provider provider;

    public ArtsAndCraftsBuiltInLootTableSubProvider(HolderLookup.Provider provider) {
        this.provider = provider;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        biConsumer.accept(
                ArtsAndCraftsBuiltInLootTables.LOTUS_FLOWER_HARVEST,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1.0f, 2.0f))
                        .add(LootItem.lootTableItem(KekeItems.BLEACHDEW.get()))
                )
        );
    }
}
