package com.kekecreations.arts_and_crafts.core.fabric.util;

import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ArtsAndCraftsFabricLootModifiers {


    public static void modifyVanillaLootTables() {
        /*
        LootTableEvents.MODIFY.register((resource, loot, id, builder, source) -> {
            if (BuiltInLootTables.SNIFFER_DIGGING.equals(id)) {
                builder.modifyPools(itemEntry -> {
                    itemEntry.with((LootItem.lootTableItem(KekeItems.LOTUS_PISTILS.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).build()));
                });
            }
            if (BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON.equals(id)) {
                builder.modifyPools(itemEntry -> {
                        itemEntry.with((LootItem.lootTableItem(KekeItems.RUINED_POTTERY_SHERD.get()).setWeight(10)).build());
                        itemEntry.with((LootItem.lootTableItem(KekeItems.POTTERY_SHERD.get()).setWeight(10)).build());
                        itemEntry.with((LootItem.lootTableItem(KekeItems.BLEACHDEW.get()).setWeight(5)).build());
                        itemEntry.with((LootItem.lootTableItem(KekeItems.CORK_HANGING_SIGN.get()).setWeight(25)).build());
                });
            }
            if (BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE.equals(id)) {
                builder.modifyPools(itemEntry -> {
                    itemEntry.with((LootItem.lootTableItem(KekeItems.RUINED_POTTERY_SHERD.get())).build());
                    itemEntry.with((LootItem.lootTableItem(KekeItems.ROLL_POTTERY_SHERD.get())).build());
                    itemEntry.with((LootItem.lootTableItem(KekeItems.FINALE_POTTERY_SHERD.get())).build());
                    itemEntry.with((LootItem.lootTableItem(KekeItems.GATEWAY_POTTERY_SHERD.get())).build());
                });
            }
        });

         */
    }
}
