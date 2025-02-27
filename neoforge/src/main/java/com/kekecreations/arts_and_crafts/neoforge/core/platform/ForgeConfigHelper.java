package com.kekecreations.arts_and_crafts.neoforge.core.platform;

import com.kekecreations.arts_and_crafts.neoforge.core.config.NeoForgeConfig;
import com.kekecreations.arts_and_crafts.core.platform.services.ConfigHelper;

public class ForgeConfigHelper implements ConfigHelper {

    @Override
    public boolean areDyedFlowerPotsEnabled() {
        if (!NeoForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return NeoForgeConfig.ENABLE_DYED_FLOWER_POTS.get();
    }

    @Override
    public boolean areChalkSticksEnabled() {
        if (!NeoForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return NeoForgeConfig.ENABLE_CHALK_STICKS.get();
    }

    @Override
    public boolean areDyedDecoratedPotsEnabled() {
        if (!NeoForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return NeoForgeConfig.ENABLE_DYED_DECORATED_POTS.get();
    }
}
