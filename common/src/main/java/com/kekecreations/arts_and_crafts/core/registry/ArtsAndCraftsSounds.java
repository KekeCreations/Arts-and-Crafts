package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.core.platform.Services;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class ArtsAndCraftsSounds {

    public static final Supplier<SoundEvent> PAINT_WITH_PAINTBRUSH = registerSound("item.paintbrush.paint");


    private static Supplier<SoundEvent> registerSound(String name) {
        return Services.REGISTRY.registerSound(name);
    }

    public static void register() {

    }
}
