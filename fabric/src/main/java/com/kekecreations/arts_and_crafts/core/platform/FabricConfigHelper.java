package com.kekecreations.arts_and_crafts.core.platform;

import com.kekecreations.arts_and_crafts.ArtsAndCraftsFabric;
import com.kekecreations.arts_and_crafts.core.platform.services.ConfigHelper;

public class FabricConfigHelper implements ConfigHelper {


    @Override
    public boolean areDyedFlowerPotsEnabled() {
        if (ArtsAndCraftsFabric.getConfig() != null) {
            return ArtsAndCraftsFabric.getConfig().areDyedFlowerPotsEnabled();
        }
        return false;
    }

    @Override
    public boolean areChalkSticksEnabled() {
        if (ArtsAndCraftsFabric.getConfig() != null) {
            return ArtsAndCraftsFabric.getConfig().areChalkSticksEnabled();
        }
        return false;
    }

    @Override
    public boolean areDyedDecoratedPotsEnabled() {
        if (ArtsAndCraftsFabric.getConfig() != null) {
            return ArtsAndCraftsFabric.getConfig().areDyedDecoratedPotsEnabled();
        }
        return false;
    }

    @Override
    public boolean bleachableSheep() {
        if (ArtsAndCraftsFabric.getConfig() != null) {
            return ArtsAndCraftsFabric.getConfig().bleachableSheep();
        }
        return false;
    }

}
