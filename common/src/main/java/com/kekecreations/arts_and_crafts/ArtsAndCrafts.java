package com.kekecreations.arts_and_crafts;

import com.kekecreations.arts_and_crafts.core.registry.*;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ArtsAndCrafts {

    public static final String MOD_ID = "arts_and_crafts";
    public static final String MOD_NAME = "Arts & Crafts";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        ACBlocks.register();
        ACItems.register();
        ACEntityTypes.register();
        ACTabs.register();
        ACSounds.register();
    }

    public static Identifier id(String name) {
        return Identifier.fromNamespaceAndPath(MOD_ID, name);
    }
}