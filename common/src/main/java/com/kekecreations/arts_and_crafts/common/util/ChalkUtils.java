package com.kekecreations.arts_and_crafts.common.util;

import com.kekecreations.arts_and_crafts.common.misc.KekeBlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;

public class ChalkUtils {

    public static int getChalkPatternFromChalkDust(BlockState blockState) {
        return blockState.getValue(KekeBlockStateProperties.CHALK_DUST_23);
    }
}
