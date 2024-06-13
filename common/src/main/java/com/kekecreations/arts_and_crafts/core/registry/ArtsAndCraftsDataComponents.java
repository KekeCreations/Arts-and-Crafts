package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.core.platform.Services;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;

import java.util.function.Supplier;

public class ArtsAndCraftsDataComponents {

    public static final Supplier<DataComponentType<Integer>> CHALK_PATTERN = registerDataComponent("chalk_pattern", () -> DataComponentType.builder().persistent(ExtraCodecs.intRange(0, 99)).networkSynchronized(ByteBufCodecs.VAR_INT));


    private static <T extends DataComponentType<?>> Supplier registerDataComponent(String name, Supplier<T> itemSupplier) {
        return Services.REGISTRY.registerDataComponent(name, itemSupplier);
    }

    public static void loadComponents() {

    }
}
