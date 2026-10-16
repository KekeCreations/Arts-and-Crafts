package com.kekecreations.arts_and_crafts.datagen.client.util;

import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

public class ACTextureMapping {


    public static TextureMapping flowerPotPlantTextureMappings(String modID, String plant) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, getPlantTexture(plant, modID))
                .put(TextureSlot.PLANT, getPlantTexture(plant, modID));
    }

    public static TextureMapping flowerPotCactusTextureMappings(String modID, String plant) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, getPlantTexture(plant, modID))
                .put(TextureSlot.PLANT, getPlantTexture(plant + "_side", modID))
                .put(TextureSlot.TOP, getPlantTexture(plant + "_top", modID));
    }

    public static TextureMapping flowerPotBambooTextureMappings(String modID, String plant) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, getPlantTexture(plant, modID))
                .put(TextureSlot.PLANT, getPlantTexture(plant + "_stalk", modID))
                .put(TextureSlot.TOP, getPlantTexture(plant + "_singleleaf", modID));
    }

    public static TextureMapping flowerPotAzaleaTextureMappings(String modID, String plant) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, getPlantTexture(plant + "_plant", modID))
                .put(TextureSlot.PLANT, getPlantTexture(plant + "_plant", modID))
                .put(TextureSlot.SIDE, getPlantTexture(plant + "_side", modID))
                .put(TextureSlot.TOP, getPlantTexture(plant + "_top", modID));
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

    public static Material getChalkPattern(DyeColor colour, String pattern) {
        if (colour == null) {
            return new Material(Identifier.parse("arts_and_crafts:block/bleached_" + pattern));
        }
        return new Material(Identifier.parse("arts_and_crafts:block/" + colour.getName() + "_" + pattern));
    }

    public static TextureMapping chalkPatternDefaultMappings(Block block) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, new Material(Identifier.parse("arts_and_crafts:block/white_dot")))
                .put(ACTextureSlots.DUST, new Material(Identifier.parse("arts_and_crafts:block/white_dot")));
    }

    public static TextureMapping lotusFlowerDefaultMappings(Block block) {
        return (new TextureMapping())
                .put(TextureSlot.PARTICLE, new Material(Identifier.parse("arts_and_crafts:block/lotus_0")))
                .put(ACTextureSlots.DUST, new Material(Identifier.parse("arts_and_crafts:block/lotus_0")));
    }

    public static Material getLotusFlower(int age) {
        return new Material(Identifier.parse("arts_and_crafts:block/lotus_" + age));
    }

    public static Material getPlantTexture(String plant, String modID) {
        return new Material(Identifier.fromNamespaceAndPath(modID, "block/" + plant));
    }

    public static Material getFlowerPotTexture(DyeColor colour) {
        return new Material(Identifier.parse("arts_and_crafts:block/" + colour.getName() + "_flower_pot"));
    }

    public static Material getPlasterTexture(DyeColor colour) {
        return new Material(Identifier.parse("arts_and_crafts:block/" + colour.getName() + "_plaster"));
    }

    public static Material getPlasterTexture() {
        return new Material(Identifier.parse("arts_and_crafts:block/plaster"));
    }
}
