package com.kekecreations.arts_and_crafts.core.registry;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

public class ACSoundTypes {

    public static final SoundType SOAPSTONE = new SoundType(
            1.0F,
            1.0F,
            ACSounds.SOAPSTONE_BREAK.get(),
            ACSounds.SOAPSTONE_STEP.get(),
            ACSounds.SOAPSTONE_PLACE.get(),
            ACSounds.SOAPSTONE_HIT.get(),
            ACSounds.SOAPSTONE_FALL.get()
    );

    public static final SoundType CORK = new SoundType(
            1.0F,
            1.0F,
            ACSounds.CORK_BREAK.get(),
            SoundEvents.CHERRY_WOOD_STEP,
            ACSounds.CORK_PLACE.get(),
            SoundEvents.CHERRY_WOOD_HIT,
            SoundEvents.CHERRY_WOOD_FALL
    );
}
