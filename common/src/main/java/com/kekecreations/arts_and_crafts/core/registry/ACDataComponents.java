package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.core.platform.Services;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class ACDataComponents {

    public static final Supplier<DataComponentType<Integer>> CHALK_PATTERN = registerDataComponent("chalk_pattern", builder -> {
        builder.persistent(ExtraCodecs.intRange(0, 99));
        builder.networkSynchronized(ByteBufCodecs.VAR_INT);
        return builder;
    });


    private static <T> Supplier<DataComponentType<T>> registerDataComponent(String name, UnaryOperator<DataComponentType.Builder<T>> dataComponent) {
        return Services.REGISTRY.registerDataComponent(name, () -> dataComponent.apply(DataComponentType.builder()).build());
    }

    public static void loadComponents() {

    }
}
