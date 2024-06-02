package com.kekecreations.arts_and_crafts.common.item.palette;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryFixedCodec;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.Optional;

public record PaintBrushPalette(HolderSet<Block> blocks, Map<DyeColor, Holder<Block>> palette, Optional<String> requiredMod) {
    public static final Codec<PaintBrushPalette> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            RegistryCodecs.homogeneousList(Registries.BLOCK).fieldOf("blocks").forGetter(PaintBrushPalette::blocks),
                Codec.simpleMap(DyeColor.CODEC, RegistryFixedCodec.create(Registries.BLOCK), StringRepresentable.keys(DyeColor.values())).fieldOf("palette").forGetter(PaintBrushPalette::palette),
                Codec.STRING.optionalFieldOf("required_mod").forGetter(PaintBrushPalette::requiredMod)
    ).apply(instance, PaintBrushPalette::new));

    public PaintBrushPalette(HolderSet<Block> blocks, Map<DyeColor, Holder<Block>> palette, Optional<String> requiredMod) {
        this.blocks = blocks;
        this.palette = palette;
        this.requiredMod = requiredMod;
    }
}
