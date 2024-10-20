package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.client.renderer.atlas.ACPalettedPermutations;
import com.kekecreations.arts_and_crafts.core.mixin.SpriteSourcesMixin;
import com.mojang.serialization.Codec;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.renderer.texture.atlas.SpriteSourceType;

public class ACSpriteSources {

    public static SpriteSourceType PALETTED_PERMUTATIONS = registerSpriteSources("paletted_permutations", ACPalettedPermutations.CODEC);


    public static SpriteSourceType registerSpriteSources(String id, Codec<? extends SpriteSource> codec) {
        return SpriteSourcesMixin.invokeRegister(ArtsAndCrafts.id(id).toString(), codec);
    }

    public static void register() {
    }
}
