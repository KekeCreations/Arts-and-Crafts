package com.kekecreations.arts_and_crafts.core.forge.datagen.server;

import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ArtsAndCraftsBiomeTagsProvider extends BiomeTagsProvider {
    public ArtsAndCraftsBiomeTagsProvider(PackOutput p_255800_, CompletableFuture<HolderLookup.Provider> p_256205_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_255800_, p_256205_, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider arg) {
        appendSoapstoneCanGenerateIn();
        appendGypsumCanGenerateIn();
    }

    private void appendGypsumCanGenerateIn() {
        this.tag(ArtsAndCraftsTags.BiomeTags.GYPSUM_CAN_GENERATE_IN)
                .add(Biomes.DESERT);
    }
    private void appendSoapstoneCanGenerateIn() {
        this.tag(ArtsAndCraftsTags.BiomeTags.SOAPSTONE_CAN_GENERATE_IN)
                .add(Biomes.BADLANDS)
                .add(Biomes.BAMBOO_JUNGLE)
                .add(Biomes.BEACH)
                .add(Biomes.BIRCH_FOREST)
                .add(Biomes.CHERRY_GROVE)
                .add(Biomes.DARK_FOREST)
                .add(Biomes.LUSH_CAVES)
                .add(Biomes.DESERT)
                .add(Biomes.ERODED_BADLANDS)
                .add(Biomes.FLOWER_FOREST)
                .add(Biomes.FOREST)
                .add(Biomes.JUNGLE)
                .add(Biomes.MANGROVE_SWAMP)
                .add(Biomes.MEADOW)
                .add(Biomes.MUSHROOM_FIELDS)
                .add(Biomes.OLD_GROWTH_BIRCH_FOREST)
                .add(Biomes.OLD_GROWTH_PINE_TAIGA)
                .add(Biomes.OLD_GROWTH_SPRUCE_TAIGA)
                .add(Biomes.PLAINS)
                .add(Biomes.SAVANNA)
                .add(Biomes.SAVANNA_PLATEAU)
                .add(Biomes.SPARSE_JUNGLE)
                .add(Biomes.SUNFLOWER_PLAINS)
                .add(Biomes.WINDSWEPT_SAVANNA)
                .add(Biomes.WOODED_BADLANDS);
    }
}
