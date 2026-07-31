package com.kekecreations.arts_and_crafts.datagen.client.util;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

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

    public static TextureMapping plasterMappings() {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, getPlasterTexture())
                .put(ACTextureSlots.PLASTER, getPlasterTexture());
    }

    public static Identifier getChalkPattern(DyeColor colour, String pattern) {
        return Identifier.parse("arts_and_crafts:block/" + colour.getName() + "_" + pattern);
    }

    public static TextureMapping chalkPatternDefaultMappings(Block block) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, Identifier.parse("arts_and_crafts:block/white_dot"))
                .put(ACTextureSlots.DUST, Identifier.parse("arts_and_crafts:block/white_dot"));
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

    public static Identifier getPlasterTexture() {
        return Identifier.parse("arts_and_crafts:block/plaster");
    }
}
