package com.kekecreations.arts_and_crafts.core.fabric.util;

import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ArtsAndCraftsFabricLootModifiers {

    private static final ResourceLocation SNIFFER_DIGGING = new ResourceLocation("gameplay/sniffer_digging");

    public static void modifyVanillaLootTables() {
        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (SNIFFER_DIGGING.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(KekeItems.LOTUS_PISTILS.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)).build());
                builder.pool(poolBuilder.build());
            }
        });
    }
}
