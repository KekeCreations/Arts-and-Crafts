package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.core.platform.Services;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class ArtsAndCraftsSounds {

    public static final Supplier<SoundEvent> PAINT_WITH_PAINTBRUSH = registerSound("item.paintbrush.paint");

    public static final Supplier<SoundEvent> SOAPSTONE_STEP = registerSound("block.soapstone.step");
    public static final Supplier<SoundEvent> SOAPSTONE_BREAK = registerSound("block.soapstone.break");
    public static final Supplier<SoundEvent> SOAPSTONE_PLACE = registerSound("block.soapstone.place");
    public static final Supplier<SoundEvent> SOAPSTONE_HIT = registerSound("block.soapstone.hit");
    public static final Supplier<SoundEvent> SOAPSTONE_FALL = registerSound("block.soapstone.fall");


    private static Supplier<SoundEvent> registerSound(String name) {
        return Services.REGISTRY.registerSound(name);
    }

    public static void register() {

    }
}
