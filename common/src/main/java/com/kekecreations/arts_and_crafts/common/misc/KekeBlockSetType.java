package com.kekecreations.arts_and_crafts.common.misc;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.mixin.BlockSetTypeMixin;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class KekeBlockSetType {


    public static final BlockSetType CORK = BlockSetTypeMixin.invokeRegister(new BlockSetType(ArtsAndCrafts.id("cork").toString()));


}
