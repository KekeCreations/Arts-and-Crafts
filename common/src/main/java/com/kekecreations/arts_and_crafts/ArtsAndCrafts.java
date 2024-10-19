package com.kekecreations.arts_and_crafts;

import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsDyedBlockLists;
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
        ACSpriteSources.register();
        ACParticles.register();
        ACSounds.register();
        ACEntityTypes.register();
        ACBlocks.register();
        ArtsAndCraftsDyedBlockLists.registerLists();
        ACItems.register();
        ACRegistries.register();
        ACCustomSherdPatterns.register();
        ACRecipeSerializer.register();
        CreativeCategoryUtils.addVanillaDyesToColourOrder();
    }



    public static ResourceLocation id(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
