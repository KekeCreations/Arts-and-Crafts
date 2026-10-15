package com.kekecreations.arts_and_crafts.common.block;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;

public class DisabledBlock extends Block {
    public DisabledBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return false;
    }
}
