package com.kekecreations.arts_and_crafts.core.neoforge.core.platform;

import com.kekecreations.arts_and_crafts.core.neoforge.core.config.NeoForgeConfig;
import com.kekecreations.arts_and_crafts.core.platform.services.ConfigHelper;

public class ForgeConfigHelper implements ConfigHelper {

    @Override
    public boolean areDyedFlowerPotsEnabled() {
        return NeoForgeConfig.ENABLE_DYED_FLOWER_POTS.get();
    }

    @Override
    public boolean areChalkSticksEnabled() {
        return NeoForgeConfig.ENABLE_CHALK_STICKS.get();
    }

    @Override
    public boolean areDyedDecoratedPotsEnabled() {
        return NeoForgeConfig.ENABLE_DYED_DECORATED_POTS.get();
    }
}
