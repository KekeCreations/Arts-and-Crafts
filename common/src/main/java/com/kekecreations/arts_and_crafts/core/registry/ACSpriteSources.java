package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.client.renderer.atlas.ACPalettedPermutations;
import com.mojang.serialization.Codec;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.renderer.texture.atlas.SpriteSourceType;
import net.minecraft.client.renderer.texture.atlas.SpriteSources;

public class ACSpriteSources {

    public static SpriteSourceType PALETTED_PERMUTATIONS = registerSpriteSources("paletted_permutations", ACPalettedPermutations.CODEC);


    public static SpriteSourceType registerSpriteSources(String id, Codec<? extends SpriteSource> codec) {
        return SpriteSources.register(ArtsAndCrafts.id(id).toString(), codec);
    }

    public static void register() {
    }
}
