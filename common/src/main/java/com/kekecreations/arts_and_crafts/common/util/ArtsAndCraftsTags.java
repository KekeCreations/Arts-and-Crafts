package com.kekecreations.arts_and_crafts.common.util;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ArtsAndCraftsTags {

    public class ItemTags {
        public static final TagKey<Item> DECORATED_POTS
                = tag("decorated_pots");

        public static final TagKey<Item> DYES
                = tag("dyes");


        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, new ResourceLocation(ArtsAndCrafts.MOD_ID, name));
        }
    }
}
