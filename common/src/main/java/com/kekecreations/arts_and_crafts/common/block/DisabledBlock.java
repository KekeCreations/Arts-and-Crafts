package com.kekecreations.arts_and_crafts.common.block;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;

public class DisabledBlock extends Block {
    public DisabledBlock(Properties $$0) {
        super($$0);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet $$0) {
        return false;
    }
}
