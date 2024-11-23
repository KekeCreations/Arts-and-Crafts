package com.kekecreations.arts_and_crafts;

import com.kekecreations.arts_and_crafts.common.util.ACDyedBlockLists;
import com.kekecreations.arts_and_crafts.common.util.CreativeCategoryUtils;
import com.kekecreations.arts_and_crafts.core.registry.*;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArtsAndCrafts {
    public static final String MOD_ID = "arts_and_crafts";

    public static final String MOD_NAME = "Arts And Crafts";

    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    
    public static void init() {
        ACDataComponents.loadComponents();
        ACParticles.register();
        ACSounds.register();
        ACEntityTypes.register();
        ACBlocks.register();
        ACDyedBlockLists.registerLists();
        ACItems.register();
        ACRegistries.register();
        ACDecoratedPotPatterns.registerPotPatterns();
        ACRecipeSerializer.register();
        CreativeCategoryUtils.addVanillaDyesToColourOrder();
    }

    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}
