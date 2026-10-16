package com.kekecreations.arts_and_crafts.datagen.client.util;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.Identifier;

import java.util.Optional;

public class ACModelTemplates {

    public static final ModelTemplate DECORATED_POT = createDecoratedPotItem();
    public static final ModelTemplate PLASTER = createPlaster(TextureSlot.PARTICLE, ACTextureSlots.PLASTER);
    public static final ModelTemplate CHALK_DUST = createChalkDust(TextureSlot.PARTICLE, ACTextureSlots.DUST);
    public static final ModelTemplate LOTUS_FLOWER = createLotusFlower(TextureSlot.PARTICLE, ACTextureSlots.LOTUS);


    public static final ModelTemplate FLOWER_POT_PLANT_AZALEA = createFlowerPotAzalea(TextureSlot.PARTICLE, TextureSlot.PLANT, TextureSlot.SIDE, TextureSlot.TOP);
    public static final ModelTemplate FLOWER_POT_PLANT_BAMBOO = createFlowerPotBamboo(TextureSlot.PARTICLE, TextureSlot.PLANT, TextureSlot.TOP);
    public static final ModelTemplate FLOWER_POT_PLANT_CACTUS = createFlowerPotCactus(TextureSlot.PARTICLE, TextureSlot.PLANT, TextureSlot.TOP);
    public static final ModelTemplate FLOWER_POT_PLANT = createFlowerPotPlant(TextureSlot.PARTICLE, TextureSlot.PLANT);
    public static final ModelTemplate EMPTY_FLOWER_POT = createEmptyFlowerPot(TextureSlot.PARTICLE, ACTextureSlots.FLOWER_POT);


    public static ModelTemplate createEmptyFlowerPot(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath("minecraft", "block/flower_pot"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createPlaster(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath(ArtsAndCrafts.MOD_ID, "block/plaster_model"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createChalkDust(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath(ArtsAndCrafts.MOD_ID, "block/chalk_dust"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createLotusFlower(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath(ArtsAndCrafts.MOD_ID, "block/lotus_flower_model"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createDecoratedPotItem(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath("minecraft", "item/decorated_pot"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createFlowerPotPlant(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath(ArtsAndCrafts.MOD_ID, "block/flower_pot_plant"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createFlowerPotCactus(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath(ArtsAndCrafts.MOD_ID, "block/flower_pot_cactus"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createFlowerPotBamboo(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath(ArtsAndCrafts.MOD_ID, "block/flower_pot_bamboo"))), Optional.empty(), textureSlots);
    }

    public static ModelTemplate createFlowerPotAzalea(TextureSlot... textureSlots) {
        return new ModelTemplate((Optional.of(Identifier.fromNamespaceAndPath(ArtsAndCrafts.MOD_ID, "block/flower_pot_azalea"))), Optional.empty(), textureSlots);
    }

}
