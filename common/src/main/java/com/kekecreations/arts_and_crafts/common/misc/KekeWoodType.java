package com.kekecreations.arts_and_crafts.common.misc;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.mixin.WoodTypeMixin;
import net.minecraft.world.level.block.state.properties.WoodType;


public class KekeWoodType {

    public static final WoodType CORK = WoodTypeMixin.invokeRegister(new WoodType(ArtsAndCrafts.id("cork").toString(), KekeBlockSetType.CORK));



}
