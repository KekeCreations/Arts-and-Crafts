package com.kekecreations.arts_and_crafts.core.forge.core.platform;

import com.kekecreations.arts_and_crafts.core.forge.core.config.ForgeConfig;
import com.kekecreations.arts_and_crafts.core.platform.services.ConfigHelper;

public class ForgeConfigHelper implements ConfigHelper {

    @Override
    public boolean areDyedFlowerPotsEnabled() {
        return ForgeConfig.ENABLE_DYED_FLOWER_POTS.get();
    }
}
