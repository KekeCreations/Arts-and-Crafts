package com.kekecreations.arts_and_crafts.core.init;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.jinxedlib.core.util.JinxedSignHelper;

public class ACValidSigns {

    public static void add() {
        JinxedSignHelper.makeSignValid(ACBlocks.CORK_SIGN.get());
        JinxedSignHelper.makeSignValid(ACBlocks.CORK_WALL_SIGN.get());
        JinxedSignHelper.makeHangingSignValid(ACBlocks.CORK_HANGING_SIGN.get());
        JinxedSignHelper.makeHangingSignValid(ACBlocks.CORK_WALL_HANGING_SIGN.get());
    }
}
