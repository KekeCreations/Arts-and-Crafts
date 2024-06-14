package com.kekecreations.arts_and_crafts.common.misc;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.registry.ArtsAndCraftsSoundTypes;
import com.kekecreations.arts_and_crafts.core.registry.ArtsAndCraftsSounds;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.WoodType;


public class KekeWoodType {

    public static final WoodType CORK = new WoodType(ArtsAndCrafts.id("cork").toString(), KekeBlockSetType.CORK, ArtsAndCraftsSoundTypes.CORK, SoundType.CHERRY_WOOD_HANGING_SIGN, ArtsAndCraftsSounds.CORK_WOOD_FENCE_GATE_CLOSE.get(), ArtsAndCraftsSounds.CORK_WOOD_FENCE_GATE_OPEN.get());
}
