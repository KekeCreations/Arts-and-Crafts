package com.kekecreations.arts_and_crafts.fabric.core.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ArtsAndCraftsBlockTagGenerator extends FabricTagProvider.BlockTagProvider {


    public ArtsAndCraftsBlockTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        appendPickaxes();
        appendWalls();
        appendSlabs();
        appendStairs();
    }


    private void appendWalls() {
        this.getOrCreateTagBuilder(BlockTags.WALLS)
                .setReplace(false)
                .add(KekeBlocks.BLACK_CHALK_WALL.get())
                .add(KekeBlocks.BLUE_CHALK_WALL.get())
                .add(KekeBlocks.BROWN_CHALK_WALL.get())
                .add(KekeBlocks.WHITE_CHALK_WALL.get())
                .add(KekeBlocks.LIGHT_BLUE_CHALK_WALL.get())
                .add(KekeBlocks.GRAY_CHALK_WALL.get())
                .add(KekeBlocks.CYAN_CHALK_WALL.get())
                .add(KekeBlocks.LIGHT_GRAY_CHALK_WALL.get())
                .add(KekeBlocks.GREEN_CHALK_WALL.get())
                .add(KekeBlocks.LIME_CHALK_WALL.get())
                .add(KekeBlocks.MAGENTA_CHALK_WALL.get())
                .add(KekeBlocks.ORANGE_CHALK_WALL.get())
                .add(KekeBlocks.PINK_CHALK_WALL.get())
                .add(KekeBlocks.PURPLE_CHALK_WALL.get())
                .add(KekeBlocks.RED_CHALK_WALL.get())
                .add(KekeBlocks.YELLOW_CHALK_WALL.get());
    }
    private void appendSlabs() {
        this.getOrCreateTagBuilder(BlockTags.SLABS)
                .setReplace(false)
                .add(KekeBlocks.BLACK_CHALK_SLAB.get())
                .add(KekeBlocks.BLUE_CHALK_SLAB.get())
                .add(KekeBlocks.BROWN_CHALK_SLAB.get())
                .add(KekeBlocks.WHITE_CHALK_SLAB.get())
                .add(KekeBlocks.LIGHT_BLUE_CHALK_SLAB.get())
                .add(KekeBlocks.GRAY_CHALK_SLAB.get())
                .add(KekeBlocks.CYAN_CHALK_SLAB.get())
                .add(KekeBlocks.LIGHT_GRAY_CHALK_SLAB.get())
                .add(KekeBlocks.GREEN_CHALK_SLAB.get())
                .add(KekeBlocks.LIME_CHALK_SLAB.get())
                .add(KekeBlocks.MAGENTA_CHALK_SLAB.get())
                .add(KekeBlocks.ORANGE_CHALK_SLAB.get())
                .add(KekeBlocks.PINK_CHALK_SLAB.get())
                .add(KekeBlocks.PURPLE_CHALK_SLAB.get())
                .add(KekeBlocks.RED_CHALK_SLAB.get())
                .add(KekeBlocks.YELLOW_CHALK_SLAB.get());
    }
    private void appendStairs() {
        this.getOrCreateTagBuilder(BlockTags.STAIRS)
                .setReplace(false)
                .add(KekeBlocks.BLACK_CHALK_STAIRS.get())
                .add(KekeBlocks.BLUE_CHALK_STAIRS.get())
                .add(KekeBlocks.BROWN_CHALK_STAIRS.get())
                .add(KekeBlocks.WHITE_CHALK_STAIRS.get())
                .add(KekeBlocks.LIGHT_BLUE_CHALK_STAIRS.get())
                .add(KekeBlocks.GRAY_CHALK_STAIRS.get())
                .add(KekeBlocks.CYAN_CHALK_STAIRS.get())
                .add(KekeBlocks.LIGHT_GRAY_CHALK_STAIRS.get())
                .add(KekeBlocks.GREEN_CHALK_STAIRS.get())
                .add(KekeBlocks.LIME_CHALK_STAIRS.get())
                .add(KekeBlocks.MAGENTA_CHALK_STAIRS.get())
                .add(KekeBlocks.ORANGE_CHALK_STAIRS.get())
                .add(KekeBlocks.PINK_CHALK_STAIRS.get())
                .add(KekeBlocks.PURPLE_CHALK_STAIRS.get())
                .add(KekeBlocks.RED_CHALK_STAIRS.get())
                .add(KekeBlocks.YELLOW_CHALK_STAIRS.get());
    }


    private void appendPickaxes() {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .setReplace(false)
                .add(KekeBlocks.BLACK_CHALK.get())
                .add(KekeBlocks.BLUE_CHALK.get())
                .add(KekeBlocks.BROWN_CHALK.get())
                .add(KekeBlocks.WHITE_CHALK.get())
                .add(KekeBlocks.LIGHT_BLUE_CHALK.get())
                .add(KekeBlocks.GRAY_CHALK.get())
                .add(KekeBlocks.CYAN_CHALK.get())
                .add(KekeBlocks.LIGHT_GRAY_CHALK.get())
                .add(KekeBlocks.GREEN_CHALK.get())
                .add(KekeBlocks.LIME_CHALK.get())
                .add(KekeBlocks.MAGENTA_CHALK.get())
                .add(KekeBlocks.ORANGE_CHALK.get())
                .add(KekeBlocks.PINK_CHALK.get())
                .add(KekeBlocks.PURPLE_CHALK.get())
                .add(KekeBlocks.RED_CHALK.get())
                .add(KekeBlocks.YELLOW_CHALK.get())
                .add(KekeBlocks.BLACK_CHALK_WALL.get())
                .add(KekeBlocks.BLUE_CHALK_WALL.get())
                .add(KekeBlocks.BROWN_CHALK_WALL.get())
                .add(KekeBlocks.WHITE_CHALK_WALL.get())
                .add(KekeBlocks.LIGHT_BLUE_CHALK_WALL.get())
                .add(KekeBlocks.GRAY_CHALK_WALL.get())
                .add(KekeBlocks.CYAN_CHALK_WALL.get())
                .add(KekeBlocks.LIGHT_GRAY_CHALK_WALL.get())
                .add(KekeBlocks.GREEN_CHALK_WALL.get())
                .add(KekeBlocks.LIME_CHALK_WALL.get())
                .add(KekeBlocks.MAGENTA_CHALK_WALL.get())
                .add(KekeBlocks.ORANGE_CHALK_WALL.get())
                .add(KekeBlocks.PINK_CHALK_WALL.get())
                .add(KekeBlocks.PURPLE_CHALK_WALL.get())
                .add(KekeBlocks.RED_CHALK_WALL.get())
                .add(KekeBlocks.YELLOW_CHALK_WALL.get())
                .add(KekeBlocks.BLACK_CHALK_SLAB.get())
                .add(KekeBlocks.BLUE_CHALK_SLAB.get())
                .add(KekeBlocks.BROWN_CHALK_SLAB.get())
                .add(KekeBlocks.WHITE_CHALK_SLAB.get())
                .add(KekeBlocks.LIGHT_BLUE_CHALK_SLAB.get())
                .add(KekeBlocks.GRAY_CHALK_SLAB.get())
                .add(KekeBlocks.CYAN_CHALK_SLAB.get())
                .add(KekeBlocks.LIGHT_GRAY_CHALK_SLAB.get())
                .add(KekeBlocks.GREEN_CHALK_SLAB.get())
                .add(KekeBlocks.LIME_CHALK_SLAB.get())
                .add(KekeBlocks.MAGENTA_CHALK_SLAB.get())
                .add(KekeBlocks.ORANGE_CHALK_SLAB.get())
                .add(KekeBlocks.PINK_CHALK_SLAB.get())
                .add(KekeBlocks.PURPLE_CHALK_SLAB.get())
                .add(KekeBlocks.RED_CHALK_SLAB.get())
                .add(KekeBlocks.YELLOW_CHALK_SLAB.get())
                .add(KekeBlocks.BLACK_CHALK_STAIRS.get())
                .add(KekeBlocks.BLUE_CHALK_STAIRS.get())
                .add(KekeBlocks.BROWN_CHALK_STAIRS.get())
                .add(KekeBlocks.WHITE_CHALK_STAIRS.get())
                .add(KekeBlocks.LIGHT_BLUE_CHALK_STAIRS.get())
                .add(KekeBlocks.GRAY_CHALK_STAIRS.get())
                .add(KekeBlocks.CYAN_CHALK_STAIRS.get())
                .add(KekeBlocks.LIGHT_GRAY_CHALK_STAIRS.get())
                .add(KekeBlocks.GREEN_CHALK_STAIRS.get())
                .add(KekeBlocks.LIME_CHALK_STAIRS.get())
                .add(KekeBlocks.MAGENTA_CHALK_STAIRS.get())
                .add(KekeBlocks.ORANGE_CHALK_STAIRS.get())
                .add(KekeBlocks.PINK_CHALK_STAIRS.get())
                .add(KekeBlocks.PURPLE_CHALK_STAIRS.get())
                .add(KekeBlocks.RED_CHALK_STAIRS.get())
                .add(KekeBlocks.YELLOW_CHALK_STAIRS.get());
    }
}
