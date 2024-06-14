package com.kekecreations.arts_and_crafts.core.fabric.util;

import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ACFabricLootModifiers {

    public static void modifyVanillaLootTables() {
        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (BuiltInLootTables.SNIFFER_DIGGING.equals(id)) {
                builder.modifyPools(itemEntry -> {
                    itemEntry.with((LootItem.lootTableItem(ACItems.LOTUS_PISTILS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).build()));
                });
            }
            if (BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON.equals(id)) {
                builder.modifyPools(itemEntry -> {
                        itemEntry.with((LootItem.lootTableItem(ACItems.RUINED_POTTERY_SHERD.get()).setWeight(10)).build());
                        itemEntry.with((LootItem.lootTableItem(ACItems.POTTERY_SHERD.get()).setWeight(10)).build());
                        itemEntry.with((LootItem.lootTableItem(ACItems.BLEACHDEW.get()).setWeight(5)).build());
                        itemEntry.with((LootItem.lootTableItem(ACItems.CORK_HANGING_SIGN.get()).setWeight(25)).build());
                });
            }
            if (BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE.equals(id)) {
                builder.modifyPools(itemEntry -> {
                    itemEntry.with((LootItem.lootTableItem(ACItems.RUINED_POTTERY_SHERD.get())).build());
                    itemEntry.with((LootItem.lootTableItem(ACItems.ROLL_POTTERY_SHERD.get())).build());
                    itemEntry.with((LootItem.lootTableItem(ACItems.FINALE_POTTERY_SHERD.get())).build());
                    itemEntry.with((LootItem.lootTableItem(ACItems.GATEWAY_POTTERY_SHERD.get())).build());
                });
            }
        });
    }
}
