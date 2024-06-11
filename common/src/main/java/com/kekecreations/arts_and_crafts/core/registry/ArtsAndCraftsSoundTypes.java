package com.kekecreations.arts_and_crafts.core.registry;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

public class ArtsAndCraftsSoundTypes {

    public static final SoundType SOAPSTONE = new SoundType(
            1.0F,
            1.0F,
            ArtsAndCraftsSounds.SOAPSTONE_BREAK.get(),
            ArtsAndCraftsSounds.SOAPSTONE_STEP.get(),
            ArtsAndCraftsSounds.SOAPSTONE_PLACE.get(),
            ArtsAndCraftsSounds.SOAPSTONE_HIT.get(),
            ArtsAndCraftsSounds.SOAPSTONE_FALL.get()
    );

    public static final SoundType CORK = new SoundType(
            1.0F,
            1.0F,
            ArtsAndCraftsSounds.CORK_BREAK.get(),
            SoundEvents.CHERRY_WOOD_STEP,
            ArtsAndCraftsSounds.CORK_PLACE.get(),
            SoundEvents.CHERRY_WOOD_HIT,
            SoundEvents.CHERRY_WOOD_FALL
    );
}
