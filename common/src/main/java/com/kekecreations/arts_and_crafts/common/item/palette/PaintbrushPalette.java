package com.kekecreations.arts_and_crafts.common.item.palette;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryFixedCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Map;

public record PaintbrushPalette(HolderSet<Block> blocks, Map<Holder<Item>, Holder<Block>> mappings) {
    public static final Codec<PaintbrushPalette> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            RegistryCodecs.homogeneousList(Registries.BLOCK).fieldOf("blocks").forGetter(PaintbrushPalette::blocks),
            Codec.unboundedMap(RegistryFixedCodec.create(Registries.ITEM), RegistryFixedCodec.create(Registries.BLOCK)).fieldOf("mappings").forGetter(PaintbrushPalette::mappings)
    ).apply(instance, PaintbrushPalette::new));

    public PaintbrushPalette(HolderSet<Block> blocks, Map<Holder<Item>, Holder<Block>> mappings) {
        this.blocks = blocks;
        this.mappings = mappings;
    }
}
