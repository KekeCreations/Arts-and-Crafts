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

    public static final Supplier<SoundEvent> CORK_BREAK = registerSound("block.cork.break");
    public static final Supplier<SoundEvent> CORK_PLACE = registerSound("block.cork.place");

    public static final Supplier<SoundEvent> CORK_WOOD_DOOR_CLOSE = registerSound("block.cork_wood_door.close");
    public static final Supplier<SoundEvent> CORK_WOOD_DOOR_OPEN = registerSound("block.cork_wood_door.open");
    public static final Supplier<SoundEvent> CORK_WOOD_TRAPDOOR_CLOSE = registerSound("block.cork_wood_trapdoor.close");
    public static final Supplier<SoundEvent> CORK_WOOD_TRAPDOOR_OPEN = registerSound("block.cork_wood_trapdoor.open");

    public static final Supplier<SoundEvent> CORK_WOOD_BUTTON_CLICK_OFF = registerSound("block.cork_wood_button.click_off");
    public static final Supplier<SoundEvent> CORK_WOOD_BUTTON_CLICK_ON = registerSound("block.cork_wood_button.click_on");

    public static final Supplier<SoundEvent> CORK_WOOD_FENCE_GATE_CLOSE = registerSound("block.cork_wood_fence_gate.close");
    public static final Supplier<SoundEvent> CORK_WOOD_FENCE_GATE_OPEN = registerSound("block.cork_wood_fence_gate.open");


    private static Supplier<SoundEvent> registerSound(String name) {
        return Services.REGISTRY.registerSound(name);
    }

    public static void register() {

    }
}
