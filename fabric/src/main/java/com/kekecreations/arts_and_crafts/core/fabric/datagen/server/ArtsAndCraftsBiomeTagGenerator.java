package com.kekecreations.arts_and_crafts.core.fabric.datagen.server;

import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ArtsAndCraftsBiomeTagGenerator extends BiomeTagsProvider {


    public ArtsAndCraftsBiomeTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(packOutput, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider arg) {
        appendSoapstoneCanGenerateIn();
    }

    private void appendSoapstoneCanGenerateIn() {
        this.tag(ArtsAndCraftsTags.BiomeTags.SOAPSTONE_CAN_GENERATE_IN)
                .add(Biomes.BADLANDS)
                .add(Biomes.BAMBOO_JUNGLE)
                .add(Biomes.BEACH)
                .add(Biomes.BIRCH_FOREST)
                .add(Biomes.CHERRY_GROVE)
                .add(Biomes.DARK_FOREST)
                .add(Biomes.DEEP_DARK)
                .add(Biomes.LUSH_CAVES)
                .add(Biomes.DRIPSTONE_CAVES)
                .add(Biomes.DESERT)
                .add(Biomes.ERODED_BADLANDS)
                .add(Biomes.FLOWER_FOREST)
                .add(Biomes.FOREST)
                .add(Biomes.GROVE)
                .add(Biomes.JAGGED_PEAKS)
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
                .add(Biomes.SNOWY_BEACH)
                .add(Biomes.SNOWY_PLAINS)
                .add(Biomes.SNOWY_SLOPES)
                .add(Biomes.SNOWY_TAIGA)
                .add(Biomes.SPARSE_JUNGLE)
                .add(Biomes.STONY_PEAKS)
                .add(Biomes.STONY_SHORE)
                .add(Biomes.SUNFLOWER_PLAINS)
                .add(Biomes.SWAMP)
                .add(Biomes.TAIGA)
                .add(Biomes.WINDSWEPT_FOREST)
                .add(Biomes.WINDSWEPT_HILLS)
                .add(Biomes.WINDSWEPT_GRAVELLY_HILLS)
                .add(Biomes.WINDSWEPT_SAVANNA)
                .add(Biomes.WOODED_BADLANDS);
    }
}
