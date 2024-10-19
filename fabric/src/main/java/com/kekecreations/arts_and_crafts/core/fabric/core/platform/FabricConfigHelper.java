package com.kekecreations.arts_and_crafts.core.fabric.core.platform;

import com.kekecreations.arts_and_crafts.core.fabric.ArtsAndCraftsFabric;
import com.kekecreations.arts_and_crafts.core.platform.services.ConfigHelper;

public class FabricConfigHelper implements ConfigHelper {


    @Override
    public boolean areDyedFlowerPotsEnabled() {
        return ArtsAndCraftsFabric.getConfig().areDyedFlowerPotsEnabled();
    }
}
