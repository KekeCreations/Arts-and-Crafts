package com.kekecreations.arts_and_crafts.core.init;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.jinxedlib.core.util.JinxedSignUtils;

public class ACValidSigns {

    public static void add() {
        if (!JinxedSignUtils.SIGN_IS_VALID.contains(ACBlocks.CORK_SIGN.get())) { JinxedSignUtils.makeSignValid(ACBlocks.CORK_SIGN.get()); }
        if (!JinxedSignUtils.SIGN_IS_VALID.contains(ACBlocks.CORK_WALL_SIGN.get())) { JinxedSignUtils.makeSignValid(ACBlocks.CORK_WALL_SIGN.get()); }
        if (!JinxedSignUtils.HANGING_SIGN_IS_VALID.contains(ACBlocks.CORK_HANGING_SIGN.get())) { JinxedSignUtils.makeHangingSignValid(ACBlocks.CORK_HANGING_SIGN.get()); }
        if (!JinxedSignUtils.HANGING_SIGN_IS_VALID.contains(ACBlocks.CORK_WALL_HANGING_SIGN.get())) { JinxedSignUtils.makeHangingSignValid(ACBlocks.CORK_WALL_HANGING_SIGN.get()); }
    }
}
