package com.kekecreations.arts_and_crafts.datagen.client.util;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.Identifier;

import java.util.Optional;

public class ACModelTemplates {

    public static final ModelTemplate PLASTER = createPlaster(TextureSlot.PARTICLE, ACTextureSlots.PLASTER);
    public static final ModelTemplate CHALK_DUST = createChalkDust(TextureSlot.PARTICLE, ACTextureSlots.DUST);


    public static final ModelTemplate FLOWER_POT = createFlowerPot(TextureSlot.PARTICLE, ACTextureSlots.FLOWER_POT, TextureSlot.PLANT);
    public static final ModelTemplate TINTED_FLOWER_POT = createTintedFlowerPot(TextureSlot.PARTICLE, ACTextureSlots.FLOWER_POT, TextureSlot.PLANT);
    public static final ModelTemplate EMPTY_FLOWER_POT = createEmptyFlowerPot(TextureSlot.PARTICLE, ACTextureSlots.FLOWER_POT);
    public static final ModelTemplate CACTUS_FLOWER_POT = createCactusFlowerPot(TextureSlot.PARTICLE, ACTextureSlots.FLOWER_POT);
    public static final ModelTemplate BAMBOO_FLOWER_POT = createBambooFlowerPot(TextureSlot.PARTICLE, ACTextureSlots.FLOWER_POT);
    public static final ModelTemplate AZALEA_BUSH_FLOWER_POT = createAzaleaBushFlowerPot(TextureSlot.PARTICLE, ACTextureSlots.FLOWER_POT);
    public static final ModelTemplate FLOWERING_AZALEA_BUSH_FLOWER_POT = createFloweringAzaleaBushFlowerPot(TextureSlot.PARTICLE, ACTextureSlots.FLOWER_POT);
    public static final ModelTemplate MANGROVE_PROPAGULE_FLOWER_POT = createMangrovePropaguleFlowerPot(TextureSlot.PARTICLE, ACTextureSlots.FLOWER_POT);


    public static ModelTemplate createEmptyFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath("minecraft", "block/flower_pot"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath("minecraft", "block/flower_pot_cross"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createCactusFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath("minecraft", "block/potted_cactus"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createMangrovePropaguleFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath("minecraft", "block/potted_mangrove_propagule"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createBambooFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath("minecraft", "block/potted_bamboo"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createAzaleaBushFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath("minecraft", "block/potted_azalea_bush"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createFloweringAzaleaBushFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath("minecraft", "block/potted_flowering_azalea_bush"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createTintedFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath("minecraft", "block/tinted_flower_pot_cross"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createPlaster(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath(ArtsAndCrafts.MOD_ID, "block/plaster_model"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createChalkDust(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath(ArtsAndCrafts.MOD_ID, "block/chalk_dust"))), Optional.empty(), textureSlots);
    }

}
