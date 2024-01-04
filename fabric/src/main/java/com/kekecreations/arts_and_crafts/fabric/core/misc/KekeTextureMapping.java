package com.kekecreations.arts_and_crafts.fabric.core.misc;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

public class KekeTextureMapping {

    public static TextureMapping flower_pot(Block block) {
        return (new TextureMapping()).put(KekeTextureSlots.FLOWERPOT, getFlowerPotTexture(block)).put(TextureSlot.PARTICLE, getFlowerPotTexture(block));
    }


    public static ResourceLocation getBlockTextureWithoutKey(String string) {
        return new ResourceLocation("block/" + string);
    }

    public static ResourceLocation getFlowerPotTexture(Block block) {
        ResourceLocation resourceLocation = BuiltInRegistries.BLOCK.getKey(block);
        return resourceLocation.withPrefix("block/");
    }
    public static ResourceLocation getFlowerPottedTexture(DyeColor colours) {
        ResourceLocation resourceLocation = BuiltInRegistries.BLOCK.getKey(KekeBlocks.getDyedFlowerPot(colours));
        return resourceLocation.withPrefix("block/");
    }

    public static TextureMapping customPottedPlant(DyeColor dyeColor, String string) {
        return (new TextureMapping()).put(TextureSlot.PLANT, getBlockTextureWithoutKey(string)).put(KekeTextureSlots.FLOWERPOT, getFlowerPottedTexture(dyeColor)).put(TextureSlot.PARTICLE, getFlowerPottedTexture(dyeColor));
    }

    public static TextureMapping customMangrovePropagulePottedPlant(DyeColor dyeColor, String string) {
        return (new TextureMapping()).put(KekeTextureSlots.SAPLING, getBlockTextureWithoutKey(string)).put(KekeTextureSlots.FLOWERPOT, getFlowerPottedTexture(dyeColor)).put(TextureSlot.PARTICLE, getFlowerPottedTexture(dyeColor));
    }

    public static TextureMapping customCactusPottedPlant(DyeColor dyeColor, String string) {
        return (new TextureMapping()).put(KekeTextureSlots.CACTUS,  getBlockTextureWithoutKey(string + "_side")).put(KekeTextureSlots.CACTUS_TOP, getBlockTextureWithoutKey(string + "_top")).put(KekeTextureSlots.FLOWERPOT, getFlowerPottedTexture(dyeColor)).put(TextureSlot.PARTICLE, getFlowerPottedTexture(dyeColor));
    }

    public static TextureMapping customBambooPottedPlant(DyeColor dyeColor, String string) {
        return (new TextureMapping()).put(KekeTextureSlots.BAMBOO,  getBlockTextureWithoutKey(string + "_stalk")).put(KekeTextureSlots.LEAF, getBlockTextureWithoutKey(string + "_singleleaf")).put(KekeTextureSlots.FLOWERPOT, getFlowerPottedTexture(dyeColor)).put(TextureSlot.PARTICLE, getFlowerPottedTexture(dyeColor));
    }

    public static TextureMapping customAzaleaBushPottedPlant(DyeColor dyeColor, String string) {
        return (new TextureMapping()).put(TextureSlot.PLANT, getBlockTextureWithoutKey(string + "_plant")).put(TextureSlot.TOP, getBlockTextureWithoutKey(string + "_top")).put(TextureSlot.SIDE, getBlockTextureWithoutKey(string + "_side")).put(KekeTextureSlots.FLOWERPOT, getFlowerPottedTexture(dyeColor)).put(TextureSlot.PARTICLE, getFlowerPottedTexture(dyeColor));
    }
}
