package com.kekecreations.arts_and_crafts.fabric.core.misc;

import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class KekeModelTemplates {


    public static final ModelTemplate FLOWER_POT = createFlowerPot("flower_pot", KekeTextureSlots.FLOWERPOT, TextureSlot.PARTICLE);

    public static final ModelTemplate FLOWER_POT_CROSS = createFlowerPot("flower_pot_cross", TextureSlot.PLANT, KekeTextureSlots.FLOWERPOT, TextureSlot.PARTICLE);

    public static final ModelTemplate POTTED_MANGROVE_PROPAGULE = createFlowerPot("potted_mangrove_propagule", KekeTextureSlots.SAPLING, KekeTextureSlots.FLOWERPOT, TextureSlot.PARTICLE);


    public static ModelTemplate createFlowerPot(String string, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(new ResourceLocation("minecraft", "block/" + string)), Optional.empty(), textureSlots);
    }

    public ModelTemplate getPottedMangrovePropagule() {
        return KekeModelTemplates.POTTED_MANGROVE_PROPAGULE;
    }

    public static enum TintState {
    TINTED,
    NOT_TINTED;

    public ModelTemplate getCrossPot() {
        return this == TINTED ? ModelTemplates.TINTED_FLOWER_POT_CROSS : KekeModelTemplates.FLOWER_POT_CROSS;
    }
    }
}
