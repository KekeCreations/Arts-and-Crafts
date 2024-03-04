package com.kekecreations.arts_and_crafts.fabric.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.fabric.registry.KekeFabricBlocks;
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
        appendHoes();
        appendWalls();
        appendSlabs();
        appendStairs();
        appendHoglinRepellents();
        appendFlowerPots();
        appendWoodenDoors();
        appendSaplings();
        appendLogsThatBurn();
        appendLeaves();
        appendWoodenStairs();
        appendWoodenSlabs();
        appendWoodenButtons();
        appendWoodenFences();
        appendWoodenPressurePlates();
        appendWoodenTrapdoors();
        appendFenceGates();
        appendPlanks();
        appendAxes();
    }

    private void appendHoglinRepellents() {
        for (DyeColor colours : DyeColor.values()) {
        this.getOrCreateTagBuilder(BlockTags.HOGLIN_REPELLENTS)
                .setReplace(false)
                .add(KekeBlocks.getDyedPottedWarpedFungus(colours));
                }
    }
    private void appendPlanks() {
        this.getOrCreateTagBuilder(BlockTags.PLANKS)
                .setReplace(false)
                .add(KekeFabricBlocks.CORK_PLANKS.get());
    }
    private void appendWoodenButtons() {
        this.getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .setReplace(false)
                .add(KekeBlocks.CORK_BUTTON.get());
    }
    private void appendWoodenFences() {
        this.getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .setReplace(false)
                .add(KekeFabricBlocks.CORK_FENCE.get());
    }
    private void appendWoodenPressurePlates() {
        this.getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .setReplace(false)
                .add(KekeBlocks.CORK_PRESSURE_PLATE.get());
    }
    private void appendWoodenTrapdoors() {
        this.getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .setReplace(false)
                .add(KekeBlocks.CORK_TRAPDOOR.get());
    }
    private void appendFenceGates() {
        this.getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .setReplace(false)
                .add(KekeFabricBlocks.CORK_FENCE_GATE.get());
    }
    private void appendWoodenDoors() {
        this.getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .setReplace(false)
                .add(KekeBlocks.CORK_DOOR.get());
    }
    private void appendWoodenSlabs() {
        this.getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .setReplace(false)
                .add(KekeFabricBlocks.CORK_SLAB.get());
    }
    private void appendWoodenStairs() {
        this.getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .setReplace(false)
                .add(KekeFabricBlocks.CORK_STAIRS.get());
    }
    private void appendAxes() {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .setReplace(false)
                .add(KekeBlocks.CORK.get())
                .add(KekeBlocks.SMOOTH_CORK.get());
    }
    private void appendHoes() {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_HOE)
                .setReplace(false)
                .add(KekeFabricBlocks.CORK_LEAVES.get());
    }
    private void appendLeaves() {
        this.getOrCreateTagBuilder(BlockTags.LEAVES)
                .setReplace(false)
                .add(KekeFabricBlocks.CORK_LEAVES.get());
    }
    private void appendLogsThatBurn() {
        this.getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .setReplace(false)
                .add(KekeFabricBlocks.CORK_LOG.get())
                .add(KekeFabricBlocks.STRIPPED_CORK_LOG.get())
                .add(KekeFabricBlocks.CORK_WOOD.get())
                .add(KekeFabricBlocks.STRIPPED_CORK_WOOD.get());
    }
    private void appendSaplings() {
        this.getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .setReplace(false)
                .add(KekeBlocks.CORK_SAPLING.get());
    }

    private void appendWalls() {
        this.getOrCreateTagBuilder(BlockTags.WALLS)
                .setReplace(false)
                .add(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get())
                .add(KekeBlocks.SOAPSTONE_WALL.get())
                .add(KekeBlocks.SOAPSTONE_BRICK_WALL.get());
                for (DyeColor colours : DyeColor.values()) {
                    getOrCreateTagBuilder(BlockTags.WALLS)
                            .add(KekeBlocks.getDyedTerracottaShingleWall(colours.getId()))
                            .add(KekeBlocks.getDyedSoapstoneWall(colours.getId()))
                            .add(KekeBlocks.getDyedSoapstoneBrickWall(colours.getId()));
                }
    }

    private void appendSlabs() {
        this.getOrCreateTagBuilder(BlockTags.SLABS)
                .setReplace(false)
                .add(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get())
                .add(KekeBlocks.SOAPSTONE_SLAB.get())
                .add(KekeBlocks.SOAPSTONE_BRICK_SLAB.get());
                for (DyeColor colours : DyeColor.values()) {
                    getOrCreateTagBuilder(BlockTags.SLABS)
                            .add(KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()))
                            .add(KekeBlocks.getDyedSoapstoneSlab(colours.getId()))
                            .add(KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()));
                }
    }
    private void appendStairs() {
        this.getOrCreateTagBuilder(BlockTags.STAIRS)
                .setReplace(false)
                .add(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get())
                .add(KekeBlocks.SOAPSTONE_STAIRS.get())
                .add(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get());
                for (DyeColor colours : DyeColor.values()) {
                    getOrCreateTagBuilder(BlockTags.STAIRS)
                            .add(KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()))
                            .add(KekeBlocks.getDyedSoapstoneStairs(colours.getId()))
                            .add(KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()));
                }
    }


    private void appendPickaxes() {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .setReplace(false)
                .add(KekeBlocks.TERRACOTTA_SHINGLES.get())
                .add(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get())
                .add(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get())
                .add(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get())
                .add(KekeBlocks.SOAPSTONE.get())
                .add(KekeBlocks.SOAPSTONE_SLAB.get())
                .add(KekeBlocks.SOAPSTONE_STAIRS.get())
                .add(KekeBlocks.SOAPSTONE_WALL.get())
                .add(KekeBlocks.SOAPSTONE_BRICKS.get())
                .add(KekeBlocks.SOAPSTONE_BRICK_SLAB.get())
                .add(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get())
                .add(KekeBlocks.SOAPSTONE_BRICK_WALL.get());
        for (DyeColor colours : DyeColor.values()) {
            this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(KekeBlocks.getDyedTerracottaShingles(colours.getId()))
                    .add(KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()))
                    .add(KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()))
                    .add(KekeBlocks.getDyedTerracottaShingleWall(colours.getId()))

                    .add(KekeBlocks.getDyedSoapstone(colours.getId()))
                    .add(KekeBlocks.getDyedSoapstoneStairs(colours.getId()))
                    .add(KekeBlocks.getDyedSoapstoneSlab(colours.getId()))
                    .add(KekeBlocks.getDyedSoapstoneWall(colours.getId()))

                    .add(KekeBlocks.getDyedSoapstoneBricks(colours.getId()))
                    .add(KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()))
                    .add(KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()))
                    .add(KekeBlocks.getDyedSoapstoneBrickWall(colours.getId()))
                    .add(KekeBlocks.getChalk(colours.getId()));
        }
    }
    private void appendFlowerPots() {
        for (DyeColor colours : DyeColor.values()) {
            this.getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                    .add(KekeBlocks.getDyedFlowerPot(colours.getId()))
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
