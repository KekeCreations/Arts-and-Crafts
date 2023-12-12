package com.kekecreations.arts_and_crafts.fabric.core.misc;

import com.kekecreations.arts_and_crafts.common.block.CustomFlowerPotBlock;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

public class KekeTextureMapping {

    public static TextureMapping flower_pot(Block block) {
        return TextureMapping.singleSlot(KekeTextureSlots.FLOWERPOT, getFlowerPotTexture(block));
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

}
