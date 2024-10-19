package com.kekecreations.arts_and_crafts.forge.core.platform;

import com.kekecreations.arts_and_crafts.forge.core.config.ForgeConfig;
import com.kekecreations.arts_and_crafts.core.platform.services.ConfigHelper;

public class ForgeConfigHelper implements ConfigHelper {

    @Override
    public boolean areDyedFlowerPotsEnabled() {
        return ForgeConfig.ENABLE_DYED_FLOWER_POTS.get();
    }

    @Override
    public boolean areChalkSticksEnabled() {
        return ForgeConfig.ENABLE_CHALK_STICKS.get();
    }
}
