package com.kekecreations.arts_and_crafts.common.misc;

import com.kekecreations.arts_and_crafts.core.registry.ACSoundTypes;
import com.kekecreations.arts_and_crafts.core.registry.ACSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class ACBlockSetType {

    public static final BlockSetType CORK = new BlockSetType(
            "cork",
            true,
            true,
            true,
            BlockSetType.PressurePlateSensitivity.EVERYTHING,
            ACSoundTypes.CORK,
            ACSounds.CORK_WOOD_DOOR_CLOSE.get(),
            ACSounds.CORK_WOOD_DOOR_OPEN.get(),
            ACSounds.CORK_WOOD_TRAPDOOR_CLOSE.get(),
            ACSounds.CORK_WOOD_TRAPDOOR_OPEN.get(),
            SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON,
            ACSounds.CORK_WOOD_BUTTON_CLICK_OFF.get(),
            ACSounds.CORK_WOOD_BUTTON_CLICK_ON.get()
    );
}
