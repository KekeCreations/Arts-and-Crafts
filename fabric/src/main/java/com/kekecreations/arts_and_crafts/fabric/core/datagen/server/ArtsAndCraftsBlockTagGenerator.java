package com.kekecreations.arts_and_crafts.fabric.core.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;

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
                .add(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get());
                for (DyeColor colours : DyeColor.values()) {
                    getOrCreateTagBuilder(BlockTags.WALLS)
                            .add(KekeBlocks.getDyedTerracottaShingleWall(colours))
                            .add(KekeBlocks.getChalkWall(colours));
                }
    }

    private void appendSlabs() {
        this.getOrCreateTagBuilder(BlockTags.SLABS)
                .setReplace(false)
                .add(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get());
                for (DyeColor colours : DyeColor.values()) {
                    getOrCreateTagBuilder(BlockTags.SLABS)
                            .add(KekeBlocks.getDyedTerracottaShingleSlab(colours))
                            .add(KekeBlocks.getChalkSlab(colours));
                }
    }
    private void appendStairs() {
        this.getOrCreateTagBuilder(BlockTags.STAIRS)
                .setReplace(false)
                .add(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get());
                for (DyeColor colours : DyeColor.values()) {
                    getOrCreateTagBuilder(BlockTags.STAIRS)
                            .add(KekeBlocks.getDyedTerracottaShingleStairs(colours))
                            .add(KekeBlocks.getChalkStairs(colours));
                }
    }


    private void appendPickaxes() {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .setReplace(false)
                .add(KekeBlocks.TERRACOTTA_SHINGLES.get())
                .add(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get())
                .add(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get())
                .add(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get());
        for (DyeColor colours : DyeColor.values()) {
            this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(KekeBlocks.getDyedTerracottaShingles(colours))
                    .add(KekeBlocks.getDyedTerracottaShingleStairs(colours))
                    .add(KekeBlocks.getDyedTerracottaShingleSlab(colours))
                    .add(KekeBlocks.getDyedTerracottaShingleWall(colours))

                    .add(KekeBlocks.getChalk(colours))
                    .add(KekeBlocks.getChalkStairs(colours))
                    .add(KekeBlocks.getChalkSlab(colours))
                    .add(KekeBlocks.getChalkWall(colours));
        }
    }
}
