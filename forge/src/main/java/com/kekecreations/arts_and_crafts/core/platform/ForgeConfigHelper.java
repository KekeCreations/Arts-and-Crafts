package com.kekecreations.arts_and_crafts.core.platform;

import com.kekecreations.arts_and_crafts.core.config.ForgeConfig;
import com.kekecreations.arts_and_crafts.core.platform.services.ConfigHelper;

public class ForgeConfigHelper implements ConfigHelper {

    @Override
    public boolean areDyedFlowerPotsEnabled() {
        if (!ForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return ForgeConfig.ENABLE_DYED_FLOWER_POTS.get();
    }

    @Override
    public boolean areChalkSticksEnabled() {
        if (!ForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return ForgeConfig.ENABLE_CHALK_STICKS.get();
    }

    @Override
    public boolean areDyedDecoratedPotsEnabled() {
        if (!ForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return ForgeConfig.ENABLE_DYED_DECORATED_POTS.get();
    }

    @Override
    public boolean bleachableSheep() {
        if (!ForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return ForgeConfig.BLEACHABLE_SHEEP.get();
    }
}
