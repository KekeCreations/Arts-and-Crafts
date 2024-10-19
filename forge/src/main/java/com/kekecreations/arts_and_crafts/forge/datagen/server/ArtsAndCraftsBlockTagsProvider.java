package com.kekecreations.arts_and_crafts.forge.datagen.server;

import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsTags;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ArtsAndCraftsBlockTagsProvider extends BlockTagsProvider {
    public ArtsAndCraftsBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
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
        appendChalkDust();
        appendLilyPads();
        appendWoolCarpets();
        appendWool();
    }

    private void appendWool() {
        this.tag(BlockTags.WOOL)
                .add(ACBlocks.BLEACHED_WOOL.get());
    }
    private void appendWoolCarpets() {
        this.tag(BlockTags.WOOL_CARPETS)
                .add(ACBlocks.BLEACHED_CARPET.get());
    }

    private void appendLilyPads() {
        this.tag(ArtsAndCraftsTags.BlockTags.LILY_PADS)
                .add(Blocks.LILY_PAD);
    }


    private void appendChalkDust() {
        for (DyeColor colours : DyeColor.values()) {
            this.tag(ArtsAndCraftsTags.BlockTags.CHALK_DUST)
                    .add(ACBlocks.getChalkDust(colours.getId()));
        }
        this.tag(ArtsAndCraftsTags.BlockTags.CHALK_DUST)
                .add(ACBlocks.BLEACHED_CHALK_DUST.get());
    }

    private void appendHoglinRepellents() {
        for (DyeColor colours : DyeColor.values()) {
            this.tag(BlockTags.HOGLIN_REPELLENTS)
                    .add(ACBlocks.getDyedPottedWarpedFungus(colours));
        }
    }
    private void appendPlanks() {
        this.tag(BlockTags.PLANKS)
                .add(ACBlocks.CORK_PLANKS.get());
    }
    private void appendWoodenButtons() {
        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ACBlocks.CORK_BUTTON.get());
    }
    private void appendWoodenFences() {
        this.tag(BlockTags.WOODEN_FENCES)
                .add(ACBlocks.CORK_FENCE.get());
    }
    private void appendWoodenPressurePlates() {
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ACBlocks.CORK_PRESSURE_PLATE.get());
    }
    private void appendWoodenTrapdoors() {
        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ACBlocks.CORK_TRAPDOOR.get());
    }
    private void appendFenceGates() {
        this.tag(BlockTags.FENCE_GATES)
                .add(ACBlocks.CORK_FENCE_GATE.get());
    }
    private void appendWoodenDoors() {
        this.tag(BlockTags.WOODEN_DOORS)
                .add(ACBlocks.CORK_DOOR.get());
    }
    private void appendWoodenSlabs() {
        this.tag(BlockTags.WOODEN_SLABS)
                .add(ACBlocks.CORK_SLAB.get());
    }
    private void appendWoodenStairs() {
        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ACBlocks.CORK_STAIRS.get());
    }
    private void appendAxes() {
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ACBlocks.CORK.get())
                .add(ACBlocks.SMOOTH_CORK.get());
    }
    private void appendHoes() {
        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ACBlocks.CORK_LEAVES.get());
    }
    private void appendLeaves() {
        this.tag(BlockTags.LEAVES)
                .add(ACBlocks.CORK_LEAVES.get());
    }
    private void appendLogsThatBurn() {
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ACBlocks.CORK_LOG.get())
                .add(ACBlocks.STRIPPED_CORK_LOG.get())
                .add(ACBlocks.CORK_WOOD.get())
                .add(ACBlocks.STRIPPED_CORK_WOOD.get());
    }
    private void appendSaplings() {
        this.tag(BlockTags.SAPLINGS)
                .add(ACBlocks.CORK_SAPLING.get());
    }

    private void appendWalls() {
        this.tag(BlockTags.WALLS)
                .add(ACBlocks.TERRACOTTA_SHINGLE_WALL.get())
                .add(ACBlocks.SOAPSTONE_WALL.get())
                .add(ACBlocks.SOAPSTONE_BRICK_WALL.get())
                .add(ACBlocks.POLISHED_SOAPSTONE_WALL.get())
                .add(ACBlocks.GYPSUM_WALL.get())
                .add(ACBlocks.GYPSUM_BRICK_WALL.get())
                .add(ACBlocks.POLISHED_GYPSUM_WALL.get());
        for (DyeColor colours : DyeColor.values()) {
            tag(BlockTags.WALLS)
                    .add(ACBlocks.getDyedTerracottaShingleWall(colours.getId()))
                    .add(ACBlocks.getDyedSoapstoneWall(colours.getId()))
                    .add(ACBlocks.getDyedSoapstoneBrickWall(colours.getId()))
                    .add(ACBlocks.getDyedPolishedSoapstoneWall(colours.getId()))
                    .add(ACBlocks.getDyedMudBrickWall(colours.getId()));
        }
    }

    private void appendSlabs() {
        this.tag(BlockTags.SLABS)
                .add(ACBlocks.TERRACOTTA_SHINGLE_SLAB.get())
                .add(ACBlocks.SOAPSTONE_SLAB.get())
                .add(ACBlocks.SOAPSTONE_BRICK_SLAB.get())
                .add(ACBlocks.POLISHED_SOAPSTONE_SLAB.get())
                .add(ACBlocks.GYPSUM_SLAB.get())
                .add(ACBlocks.GYPSUM_BRICK_SLAB.get())
                .add(ACBlocks.POLISHED_GYPSUM_SLAB.get());
        for (DyeColor colours : DyeColor.values()) {
            tag(BlockTags.SLABS)
                    .add(ACBlocks.getDyedTerracottaShingleSlab(colours.getId()))
                    .add(ACBlocks.getDyedSoapstoneSlab(colours.getId()))
                    .add(ACBlocks.getDyedSoapstoneBrickSlab(colours.getId()))
                    .add(ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId()))
                    .add(ACBlocks.getDyedMudBrickSlab(colours.getId()));
        }
    }
    private void appendStairs() {
        this.tag(BlockTags.STAIRS)
                .add(ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get())
                .add(ACBlocks.SOAPSTONE_STAIRS.get())
                .add(ACBlocks.SOAPSTONE_BRICK_STAIRS.get())
                .add(ACBlocks.POLISHED_SOAPSTONE_STAIRS.get())
                .add(ACBlocks.GYPSUM_STAIRS.get())
                .add(ACBlocks.GYPSUM_BRICK_STAIRS.get())
                .add(ACBlocks.POLISHED_GYPSUM_STAIRS.get());
        for (DyeColor colours : DyeColor.values()) {
            tag(BlockTags.STAIRS)
                    .add(ACBlocks.getDyedTerracottaShingleStairs(colours.getId()))
                    .add(ACBlocks.getDyedSoapstoneStairs(colours.getId()))
                    .add(ACBlocks.getDyedSoapstoneBrickStairs(colours.getId()))
                    .add(ACBlocks.getDyedPolishedSoapstoneStairs(colours.getId()))
                    .add(ACBlocks.getDyedMudBrickStairs(colours.getId()));
        }
    }


    private void appendPickaxes() {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ACBlocks.GLAZED_TERRACOTTA.get())
                .add(ACBlocks.TERRACOTTA_SHINGLES.get())
                .add(ACBlocks.TERRACOTTA_SHINGLE_SLAB.get())
                .add(ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get())
                .add(ACBlocks.TERRACOTTA_SHINGLE_WALL.get())
                .add(ACBlocks.SOAPSTONE.get())
                .add(ACBlocks.SOAPSTONE_SLAB.get())
                .add(ACBlocks.SOAPSTONE_STAIRS.get())
                .add(ACBlocks.SOAPSTONE_WALL.get())
                .add(ACBlocks.SOAPSTONE_BRICKS.get())
                .add(ACBlocks.SOAPSTONE_BRICK_SLAB.get())
                .add(ACBlocks.SOAPSTONE_BRICK_STAIRS.get())
                .add(ACBlocks.SOAPSTONE_BRICK_WALL.get())
                .add(ACBlocks.POLISHED_SOAPSTONE.get())
                .add(ACBlocks.POLISHED_SOAPSTONE_SLAB.get())
                .add(ACBlocks.POLISHED_SOAPSTONE_STAIRS.get())
                .add(ACBlocks.POLISHED_SOAPSTONE_WALL.get())
                .add(ACBlocks.PLASTER.get())
                .add(ACBlocks.GYPSUM.get())
                .add(ACBlocks.GYPSUM_SLAB.get())
                .add(ACBlocks.GYPSUM_STAIRS.get())
                .add(ACBlocks.GYPSUM_WALL.get())
                .add(ACBlocks.GYPSUM_BRICKS.get())
                .add(ACBlocks.GYPSUM_BRICK_SLAB.get())
                .add(ACBlocks.GYPSUM_BRICK_STAIRS.get())
                .add(ACBlocks.GYPSUM_BRICK_WALL.get())
                .add(ACBlocks.POLISHED_GYPSUM.get())
                .add(ACBlocks.POLISHED_GYPSUM_SLAB.get())
                .add(ACBlocks.POLISHED_GYPSUM_STAIRS.get())
                .add(ACBlocks.POLISHED_GYPSUM_WALL.get());
        for (DyeColor colours : DyeColor.values()) {
            this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(ACBlocks.getDyedTerracottaShingles(colours.getId()))
                    .add(ACBlocks.getDyedTerracottaShingleStairs(colours.getId()))
                    .add(ACBlocks.getDyedTerracottaShingleSlab(colours.getId()))
                    .add(ACBlocks.getDyedTerracottaShingleWall(colours.getId()))

                    .add(ACBlocks.getDyedSoapstone(colours.getId()))
                    .add(ACBlocks.getDyedSoapstoneStairs(colours.getId()))
                    .add(ACBlocks.getDyedSoapstoneSlab(colours.getId()))
                    .add(ACBlocks.getDyedSoapstoneWall(colours.getId()))

                    .add(ACBlocks.getDyedSoapstoneBricks(colours.getId()))
                    .add(ACBlocks.getDyedSoapstoneBrickStairs(colours.getId()))
                    .add(ACBlocks.getDyedSoapstoneBrickSlab(colours.getId()))
                    .add(ACBlocks.getDyedSoapstoneBrickWall(colours.getId()))

                    .add(ACBlocks.getDyedPolishedSoapstone(colours.getId()))
                    .add(ACBlocks.getDyedPolishedSoapstoneStairs(colours.getId()))
                    .add(ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId()))
                    .add(ACBlocks.getDyedPolishedSoapstoneWall(colours.getId()))

                    .add(ACBlocks.getDyedMudBricks(colours.getId()))
                    .add(ACBlocks.getDyedMudBrickStairs(colours.getId()))
                    .add(ACBlocks.getDyedMudBrickSlab(colours.getId()))
                    .add(ACBlocks.getDyedMudBrickWall(colours.getId()))

                    .add(ACBlocks.getChalk(colours.getId()))

                    .add(ACBlocks.getDyedPlaster(colours.getId()));
        }
    }
    private void appendFlowerPots() {
        for (DyeColor colours : DyeColor.values()) {
            this.tag(BlockTags.FLOWER_POTS)
                    .add(ACBlocks.getDyedFlowerPot(colours.getId()))
                    .add(ACBlocks.getDyedPottedCrimsonFungus(colours))
                    .add(ACBlocks.getDyedPottedCrimsonRoots(colours))
                    .add(ACBlocks.getDyedPottedWarpedFungus(colours))
                    .add(ACBlocks.getDyedPottedWarpedRoots(colours))
                    .add(ACBlocks.getDyedPottedOakSapling(colours))
                    .add(ACBlocks.getDyedPottedSpruceSapling(colours))
                    .add(ACBlocks.getDyedPottedBirchSapling(colours))
                    .add(ACBlocks.getDyedPottedJungleSapling(colours))
                    .add(ACBlocks.getDyedPottedAcaciaSapling(colours))
                    .add(ACBlocks.getDyedPottedCherrySapling(colours))
                    .add(ACBlocks.getDyedPottedDarkOakSapling(colours))
                    .add(ACBlocks.getDyedPottedMangrovePropagule(colours))
                    .add(ACBlocks.getDyedPottedFern(colours))
                    .add(ACBlocks.getDyedPottedDandelion(colours))
                    .add(ACBlocks.getDyedPottedPoppy(colours))
                    .add(ACBlocks.getDyedPottedBlueOrchid(colours))
                    .add(ACBlocks.getDyedPottedAllium(colours))
                    .add(ACBlocks.getDyedPottedAzureBluet(colours))
                    .add(ACBlocks.getDyedPottedRedTulip(colours))
                    .add(ACBlocks.getDyedPottedOrangeTulip(colours))
                    .add(ACBlocks.getDyedPottedWhiteTulip(colours))
                    .add(ACBlocks.getDyedPottedPinkTulip(colours))
                    .add(ACBlocks.getDyedPottedOxeyeDaisy(colours))
                    .add(ACBlocks.getDyedPottedCornflower(colours))
                    .add(ACBlocks.getDyedPottedLilyOfTheValley(colours))
                    .add(ACBlocks.getDyedPottedWitherRose(colours))
                    .add(ACBlocks.getDyedPottedRedMushroom(colours))
                    .add(ACBlocks.getDyedPottedBrownMushroom(colours))
                    .add(ACBlocks.getDyedPottedDeadBush(colours))
                    .add(ACBlocks.getDyedPottedCactus(colours))
                    .add(ACBlocks.getDyedPottedBamboo(colours))
                    .add(ACBlocks.getDyedPottedAzalea(colours))
                    .add(ACBlocks.getDyedPottedFloweringAzalea(colours))
                    .add(ACBlocks.getDyedPottedTorchFlower(colours))
                    .add(ACBlocks.getDyedPottedCorkSapling(colours));
        }
    }
}