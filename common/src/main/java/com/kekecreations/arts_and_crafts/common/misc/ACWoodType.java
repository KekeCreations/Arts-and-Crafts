package com.kekecreations.arts_and_crafts.common.misc;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.mixin.WoodTypeMixin;
import com.kekecreations.arts_and_crafts.core.registry.ACSoundTypes;
import com.kekecreations.arts_and_crafts.core.registry.ACSounds;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.WoodType;


public class ACWoodType {

    public static final WoodType CORK = WoodTypeMixin.invokeRegister(new WoodType(ArtsAndCrafts.id("cork").toString(), ACBlockSetType.CORK, ACSoundTypes.CORK, SoundType.CHERRY_WOOD_HANGING_SIGN, ACSounds.CORK_WOOD_FENCE_GATE_CLOSE.get(), ACSounds.CORK_WOOD_FENCE_GATE_OPEN.get()));
}
