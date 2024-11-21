package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.client.renderer.atlas.ACPalettedPermutations;
import com.kekecreations.arts_and_crafts.core.mixin.SpriteSourcesMixin;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.renderer.texture.atlas.SpriteSourceType;

public class ACSpriteSources {
    public static SpriteSourceType PALETTED_PERMUTATIONS = registerSpriteSources("arts_and_crafts_paletted_permutations", ACPalettedPermutations.CODEC);


    public static SpriteSourceType registerSpriteSources(String id, MapCodec<? extends SpriteSource> codec) {
        return SpriteSourcesMixin.invokeRegister(id, codec);
    }

    public static void register() {
    }
}
