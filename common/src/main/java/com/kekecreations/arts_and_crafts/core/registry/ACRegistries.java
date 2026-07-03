package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.item.palette.PaintbrushPalette;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class ACRegistries {
    public static final ResourceKey<Registry<PaintbrushPalette>> PAINTBRUSH_PALETTE = ResourceKey.createRegistryKey(ArtsAndCrafts.id("paintbrush_palette"));

    public static void register() {
        
    }
}
