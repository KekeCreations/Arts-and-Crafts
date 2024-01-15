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
        appendHoglinRepellents();
        appendFlowerPots();
    }

    private void appendHoglinRepellents() {
        for (DyeColor colours : DyeColor.values()) {
        this.getOrCreateTagBuilder(BlockTags.HOGLIN_REPELLENTS)
                .setReplace(false)
                .add(KekeBlocks.getDyedPottedWarpedFungus(colours));
                }
    }

    private void appendWalls() {
        this.getOrCreateTagBuilder(BlockTags.WALLS)
                .setReplace(false)
                .add(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get());
                for (DyeColor colours : DyeColor.values()) {
                    getOrCreateTagBuilder(BlockTags.WALLS)
                            .add(KekeBlocks.getDyedTerracottaShingleWall(colours))
                            .add(KekeBlocks.getDyedSoapstoneWall(colours));
                }
    }

    private void appendSlabs() {
        this.getOrCreateTagBuilder(BlockTags.SLABS)
                .setReplace(false)
                .add(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get());
                for (DyeColor colours : DyeColor.values()) {
                    getOrCreateTagBuilder(BlockTags.SLABS)
                            .add(KekeBlocks.getDyedTerracottaShingleSlab(colours))
                            .add(KekeBlocks.getDyedSoapstoneSlab(colours));
                }
    }
    private void appendStairs() {
        this.getOrCreateTagBuilder(BlockTags.STAIRS)
                .setReplace(false)
                .add(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get());
                for (DyeColor colours : DyeColor.values()) {
                    getOrCreateTagBuilder(BlockTags.STAIRS)
                            .add(KekeBlocks.getDyedTerracottaShingleStairs(colours))
                            .add(KekeBlocks.getDyedSoapstoneStairs(colours));
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

                    .add(KekeBlocks.getDyedSoapstone(colours))
                    .add(KekeBlocks.getDyedSoapstoneStairs(colours))
                    .add(KekeBlocks.getDyedSoapstoneSlab(colours))
                    .add(KekeBlocks.getDyedSoapstoneWall(colours));
        }
    }
    private void appendFlowerPots() {
        for (DyeColor colours : DyeColor.values()) {
            this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                    .add(KekeBlocks.getDyedFlowerPot(colours))
                    .add(KekeBlocks.getDyedPottedCrimsonFungus(colours))
                    .add(KekeBlocks.getDyedPottedCrimsonRoots(colours))
                    .add(KekeBlocks.getDyedPottedWarpedFungus(colours))
                    .add(KekeBlocks.getDyedPottedWarpedRoots(colours))
                    .add(KekeBlocks.getDyedPottedOakSapling(colours))
                    .add(KekeBlocks.getDyedPottedSpruceSapling(colours))
                    .add(KekeBlocks.getDyedPottedBirchSapling(colours))
                    .add(KekeBlocks.getDyedPottedJungleSapling(colours))
                    .add(KekeBlocks.getDyedPottedAcaciaSapling(colours))
                    .add(KekeBlocks.getDyedPottedCherrySapling(colours))
                    .add(KekeBlocks.getDyedPottedDarkOakSapling(colours))
                    .add(KekeBlocks.getDyedPottedMangrovePropagule(colours))
                    .add(KekeBlocks.getDyedPottedFern(colours))
                    .add(KekeBlocks.getDyedPottedDandelion(colours))
                    .add(KekeBlocks.getDyedPottedPoppy(colours))
                    .add(KekeBlocks.getDyedPottedBlueOrchid(colours))
                    .add(KekeBlocks.getDyedPottedAllium(colours))
                    .add(KekeBlocks.getDyedPottedAzureBluet(colours))
                    .add(KekeBlocks.getDyedPottedRedTulip(colours))
                    .add(KekeBlocks.getDyedPottedOrangeTulip(colours))
                    .add(KekeBlocks.getDyedPottedWhiteTulip(colours))
                    .add(KekeBlocks.getDyedPottedPinkTulip(colours))
                    .add(KekeBlocks.getDyedPottedOxeyeDaisy(colours))
                    .add(KekeBlocks.getDyedPottedCornflower(colours))
                    .add(KekeBlocks.getDyedPottedLilyOfTheValley(colours))
                    .add(KekeBlocks.getDyedPottedWitherRose(colours))
                    .add(KekeBlocks.getDyedPottedRedMushroom(colours))
                    .add(KekeBlocks.getDyedPottedBrownMushroom(colours))
                    .add(KekeBlocks.getDyedPottedDeadBush(colours))
                    .add(KekeBlocks.getDyedPottedCactus(colours))
                    .add(KekeBlocks.getDyedPottedBamboo(colours))
                    .add(KekeBlocks.getDyedPottedAzalea(colours))
                    .add(KekeBlocks.getDyedPottedFloweringAzalea(colours))
                    .add(KekeBlocks.getDyedPottedTorchFlower(colours));
        }
    }
}
