package com.kekecreations.arts_and_crafts.common.util;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ArtsAndCraftsTags {

    public static class ItemTags {
        public static final TagKey<Item> DECORATED_POTS
                = tag("decorated_pots");

        public static final TagKey<Item> DYES
                = tag("dyes");

        public static final TagKey<Item> CHALK_STICKS
                = tag("chalk_sticks");

        public static final TagKey<Item> PAINTBRUSHES
                = tag("paintbrushes");


        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(ArtsAndCrafts.MOD_ID, name));
        }
    }

    public static class BlockTags {
        public static final TagKey<Block> CHALK_DUST
                = tag("chalk_dust");

        public static final TagKey<Block> LILY_PADS
                = tag("lily_pads");

        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(ArtsAndCrafts.MOD_ID, name));
        }

    }

    public static class BiomeTags {
        public static final TagKey<Biome> SOAPSTONE_CAN_GENERATE_IN
                = tag("soapstone_can_generate_in");

        public static final TagKey<Biome> GYPSUM_CAN_GENERATE_IN
                = tag("gypsum_can_generate_in");

        private static TagKey<Biome> tag(String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(ArtsAndCrafts.MOD_ID, name));
        }

    }
}
