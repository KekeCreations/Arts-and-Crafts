package com.kekecreations.arts_and_crafts.forge.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.ACBuiltInLootTables;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class ArtsAndCraftsBuiltInLootTableSubProvider implements LootTableSubProvider {
    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> biConsumer) {
        biConsumer.accept(ACBuiltInLootTables.LOTUS_FLOWER_HARVEST, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 2.0F))
                        .add(LootItem.lootTableItem(ACItems.BLEACHDEW.get()))));
    }
}
