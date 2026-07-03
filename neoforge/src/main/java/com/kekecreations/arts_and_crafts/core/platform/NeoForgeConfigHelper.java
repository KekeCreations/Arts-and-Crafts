package com.kekecreations.arts_and_crafts.core.platform;
import com.kekecreations.arts_and_crafts.core.config.NeoForgeConfig;
import com.kekecreations.arts_and_crafts.core.platform.services.ConfigHelper;

public class NeoForgeConfigHelper implements ConfigHelper {

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

    @Override
    public boolean isCreativeModeTabEnabled() {
        if (!NeoForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return NeoForgeConfig.ENABLE_CREATIVE_MODE_TAB.get();
    }

    @Override
    public boolean bleachableSheep() {
        if (!NeoForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return NeoForgeConfig.BLEACHABLE_SHEEP.get();
    }

    @Override
    public boolean aprilFools2025() {
        if (!NeoForgeConfig.SPEC.isLoaded()) {
            return true;
        }
        return NeoForgeConfig.APRIL_FOOLS_2025.get();
    }
}
