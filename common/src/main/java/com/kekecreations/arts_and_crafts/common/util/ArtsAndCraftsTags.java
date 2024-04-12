package com.kekecreations.arts_and_crafts.common.util;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;

public class ArtsAndCraftsTags {

    public static class ItemTags {
        public static final TagKey<Item> DECORATED_POTS
                = tag("decorated_pots");

        public static final TagKey<Item> DYES
                = tag("dyes");


        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(ArtsAndCrafts.MOD_ID, name));
        }
    }

    public static class BiomeTags {
        public static final TagKey<Biome> SOAPSTONE_CAN_GENERATE_IN
                = tag("soapstone_can_generate_in");

        private static TagKey<Biome> tag(String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(ArtsAndCrafts.MOD_ID, name));
        }

    }
}
