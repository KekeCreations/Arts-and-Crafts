package com.kekecreations.arts_and_crafts.fabric.misc;

import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class KekeModelTemplates {


    public static final ModelTemplate FLOWER_POT = createFlowerPot("flower_pot", KekeTextureSlots.FLOWERPOT, TextureSlot.PARTICLE);

    public static final ModelTemplate FLOWER_POT_CROSS = createFlowerPot("flower_pot_cross", TextureSlot.PLANT, KekeTextureSlots.FLOWERPOT, TextureSlot.PARTICLE);

    public static final ModelTemplate TINTED_FLOWER_POT_CROSS = createFlowerPot("tinted_flower_pot_cross", TextureSlot.PLANT, KekeTextureSlots.FLOWERPOT, TextureSlot.PARTICLE);

    public static final ModelTemplate POTTED_MANGROVE_PROPAGULE = createFlowerPot("potted_mangrove_propagule", KekeTextureSlots.SAPLING, KekeTextureSlots.FLOWERPOT, TextureSlot.PARTICLE);

    public static final ModelTemplate POTTED_CACTUS = createFlowerPot("potted_cactus", KekeTextureSlots.CACTUS, KekeTextureSlots.CACTUS_TOP, KekeTextureSlots.FLOWERPOT, TextureSlot.PARTICLE);

    public static final ModelTemplate POTTED_BAMBOO = createFlowerPot("potted_bamboo", KekeTextureSlots.BAMBOO, KekeTextureSlots.LEAF, KekeTextureSlots.FLOWERPOT, TextureSlot.PARTICLE);

    public static final ModelTemplate POTTED_AZALEA = createFlowerPot("template_potted_azalea_bush", TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.PLANT, KekeTextureSlots.FLOWERPOT, TextureSlot.PARTICLE);


    public static ModelTemplate createFlowerPot(String string, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(new ResourceLocation("minecraft", "block/" + string)), Optional.empty(), textureSlots);
    }

    public ModelTemplate getPottedMangrovePropagule() {
        return KekeModelTemplates.POTTED_MANGROVE_PROPAGULE;
    }
    public ModelTemplate getPottedCactus() {
        return KekeModelTemplates.POTTED_CACTUS;
    }

    public ModelTemplate getPottedBamboo() {
        return KekeModelTemplates.POTTED_BAMBOO;
    }
    public ModelTemplate getPottedAzalea() {
        return KekeModelTemplates.POTTED_AZALEA;
    }

    public static enum TintState {
    TINTED,
    NOT_TINTED;

    public ModelTemplate getCrossPot() {
        return this == TINTED ? KekeModelTemplates.TINTED_FLOWER_POT_CROSS : KekeModelTemplates.FLOWER_POT_CROSS;
    }
    }
}
