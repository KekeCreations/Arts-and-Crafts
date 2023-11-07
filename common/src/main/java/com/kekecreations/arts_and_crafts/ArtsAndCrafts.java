package com.kekecreations.arts_and_crafts;

import com.kekecreations.arts_and_crafts.core.misc.RegistryHelper;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;

public class ArtsAndCrafts {
    public static final String MOD_ID = "arts_and_crafts";
    
    public static void init() {
        RegistryHelper.BLOCKS.register();
        RegistryHelper.ITEMS.register();

        KekeBlocks.register();
        KekeItems.register();
        
        System.out.println(ExampleExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
