package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.jinxedlib.core.util.JinxedRegistryHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class ACBuiltInLootTables {
    public static final ResourceKey<LootTable> LOTUS_FLOWER_HARVEST = ACBuiltInLootTables.register("gameplay/lotus_flower_harvest");


    private static ResourceKey<LootTable> register(String name) {
        return JinxedRegistryHelper.registerBuiltInLootTable(ArtsAndCrafts.MOD_ID, name);
    }
}
