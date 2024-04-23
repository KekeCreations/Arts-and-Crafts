package com.kekecreations.arts_and_crafts;

import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsDyedBlockLists;
import com.kekecreations.arts_and_crafts.core.registry.*;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArtsAndCrafts {
    public static final String MOD_ID = "arts_and_crafts";

    public static final String MOD_NAME = "Arts And Crafts";

    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    
    public static void init() {
        KekeParticles.register();
        KekeEntityTypes.register();
        KekeBlocks.register();
        ArtsAndCraftsDyedBlockLists.registerLists();
        KekeItems.register();
        KekeCustomSherdPatterns.register();
        KekeRecipeSerializer.register();
    }



    public static ResourceLocation id(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
