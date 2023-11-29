package com.kekecreations.arts_and_crafts;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import com.kekecreations.arts_and_crafts.core.registry.KekeParticles;

public class ArtsAndCrafts {
    public static final String MOD_ID = "arts_and_crafts";
    
    public static void init() {
        KekeParticles.register();
        KekeBlocks.register();
        KekeItems.register();
        KekeEntityTypes.register();
        
        System.out.println(ExampleExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
