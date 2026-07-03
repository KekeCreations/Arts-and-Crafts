package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.jinxedlib.core.util.JinxedRegistryHelper;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class ACDataComponents {

    /*
    public static final Supplier<DataComponentType<Integer>> CHALK_PATTERN = registerDataComponent("chalk_pattern", builder -> {
        builder.persistent(ExtraCodecs.intRange(0, 99));
        builder.networkSynchronized(ByteBufCodecs.VAR_INT);
        return builder;
    });


    private static <T> Supplier<DataComponentType<T>> registerDataComponent(String name, UnaryOperator<DataComponentType.Builder<T>> dataComponent) {
        return JinxedRegistryHelper.register(BuiltInRegistries.DATA_COMPONENT_TYPE, ArtsAndCrafts.MOD_ID, name, () -> dataComponent.apply(DataComponentType.builder()).build());
    }

     */

    public static void loadComponents() {

    }
}
