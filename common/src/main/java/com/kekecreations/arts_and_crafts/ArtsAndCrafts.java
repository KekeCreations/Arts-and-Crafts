package com.kekecreations.arts_and_crafts;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;

public class ArtsAndCrafts {
    public static final String MOD_ID = "arts_and_crafts";
    
    public static void init() {
        KekeBlocks.register();
        
        System.out.println(ExampleExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
