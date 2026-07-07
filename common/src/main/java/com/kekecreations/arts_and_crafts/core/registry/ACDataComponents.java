package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.jinxedlib.core.util.JinxedRegistryHelper;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;

import java.util.function.Supplier;

public class ACDataComponents {



    public static final Supplier<DataComponentType<?>> CHALK_PATTERN = JinxedRegistryHelper.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            ArtsAndCrafts.MOD_ID,
            "chalk_pattern",
            () -> DataComponentType.<Integer>builder().persistent(ExtraCodecs.intRange(0, 99)).networkSynchronized(ByteBufCodecs.VAR_INT).build()
    );

    public static void register() {

    }
}
