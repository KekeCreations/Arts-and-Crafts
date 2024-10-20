package com.kekecreations.arts_and_crafts.core.mixin;

import com.mojang.serialization.Codec;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.renderer.texture.atlas.SpriteSourceType;
import net.minecraft.client.renderer.texture.atlas.SpriteSources;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SpriteSources.class)
public interface SpriteSourcesMixin {


    @Invoker
    static SpriteSourceType invokeRegister(String $$0, Codec<? extends SpriteSource> $$1) {
        throw new AssertionError();
    }
}
