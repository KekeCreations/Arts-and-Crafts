package com.kekecreations.arts_and_crafts.fabric.core.platform;

import com.kekecreations.arts_and_crafts.fabric.ArtsAndCraftsFabric;
import com.kekecreations.arts_and_crafts.core.platform.services.ConfigHelper;

public class FabricConfigHelper implements ConfigHelper {


    @Override
    public boolean areDyedFlowerPotsEnabled() {
        return ArtsAndCraftsFabric.getConfig().areDyedFlowerPotsEnabled();
    }

    @Override
    public boolean areChalkSticksEnabled() {
        return ArtsAndCraftsFabric.getConfig().areChalkSticksEnabled();
    }

    @Override
    public boolean areDyedDecoratedPotsEnabled() {
        return ArtsAndCraftsFabric.getConfig().areDyedDecoratedPotsEnabled();
    }

}
