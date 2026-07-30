package com.kekecreations.arts_and_crafts.datagen.client.util;

import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;

public class ACTextureMapping {

    public static TextureMapping flowerPotTextureMappings(String modID, String plant, DyeColor colour) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, getFlowerPotTexture(colour))
                .put(ACTextureSlots.FLOWER_POT, getFlowerPotTexture(colour))
                .put(TextureSlot.PLANT, getPlantTexture(plant, modID));
    }

    public static TextureMapping emptyFlowerPotTextureMappings(DyeColor colour) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, getFlowerPotTexture(colour))
                .put(ACTextureSlots.FLOWER_POT, getFlowerPotTexture(colour));
    }

    public static TextureMapping plasterMappings(DyeColor colour) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, getPlasterTexture(colour))
                .put(ACTextureSlots.PLASTER, getPlasterTexture(colour));
    }

    public static Identifier getPlantTexture(String plant, String modID) {
        return Identifier.fromNamespaceAndPath(modID, "block/" + plant);
    }

    public static Identifier getFlowerPotTexture(DyeColor colour) {
        return Identifier.parse("arts_and_crafts:block/" + colour.getName() + "_flower_pot");
    }

    public static Identifier getPlasterTexture(DyeColor colour) {
        return Identifier.parse("arts_and_crafts:block/" + colour.getName() + "_plaster");
    }
}
