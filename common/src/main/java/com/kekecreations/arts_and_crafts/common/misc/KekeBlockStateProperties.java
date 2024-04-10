package com.kekecreations.arts_and_crafts.common.misc;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class KekeBlockStateProperties {

    public static final IntegerProperty CHALK_PATTERN = IntegerProperty.create("chalk_pattern", 0, 32);



    public static final BooleanProperty HAS_PLANT = BooleanProperty.create("has_plant");
}
