package com.kekecreations.arts_and_crafts.core.registry;

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
}
