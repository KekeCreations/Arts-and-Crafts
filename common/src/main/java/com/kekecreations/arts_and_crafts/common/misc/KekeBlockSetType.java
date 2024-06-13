package com.kekecreations.arts_and_crafts.common.misc;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.mixin.BlockSetTypeMixin;
import com.kekecreations.arts_and_crafts.core.registry.ArtsAndCraftsSoundTypes;
import com.kekecreations.arts_and_crafts.core.registry.ArtsAndCraftsSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class KekeBlockSetType {


    public static final BlockSetType CORK = BlockSetTypeMixin.invokeRegister(new BlockSetType(ArtsAndCrafts.id("cork").toString(),
            true,
            true,
            true,
            BlockSetType.PressurePlateSensitivity.EVERYTHING,
            ArtsAndCraftsSoundTypes.CORK,
            ArtsAndCraftsSounds.CORK_WOOD_DOOR_CLOSE.get(),
            ArtsAndCraftsSounds.CORK_WOOD_DOOR_OPEN.get(),
            ArtsAndCraftsSounds.CORK_WOOD_TRAPDOOR_CLOSE.get(),
            ArtsAndCraftsSounds.CORK_WOOD_TRAPDOOR_OPEN.get(),
            SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON,
            ArtsAndCraftsSounds.CORK_WOOD_BUTTON_CLICK_OFF.get(),
            ArtsAndCraftsSounds.CORK_WOOD_BUTTON_CLICK_ON.get()));


}
