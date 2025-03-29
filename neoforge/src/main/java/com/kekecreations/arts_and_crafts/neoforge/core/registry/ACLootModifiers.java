package com.kekecreations.arts_and_crafts.neoforge.core.registry;

import com.kekecreations.arts_and_crafts.neoforge.common.modifier.ConfigModifyItemModifier;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ACLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS;
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<ConfigModifyItemModifier>> CONFIG_MODIFIER;

    public ACLootModifiers() {
    }

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }

    static {
        LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, "arts_and_crafts");
        CONFIG_MODIFIER = LOOT_MODIFIER_SERIALIZERS.register("config_modify_item", ConfigModifyItemModifier.CODEC);
    }
}
