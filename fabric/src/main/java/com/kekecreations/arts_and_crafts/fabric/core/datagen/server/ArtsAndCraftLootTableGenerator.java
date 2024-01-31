package com.kekecreations.arts_and_crafts.fabric.core.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.world.item.DyeColor;

public class ArtsAndCraftLootTableGenerator extends FabricBlockLootTableProvider {

    public ArtsAndCraftLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }


    @Override
    public void generate() {
        terracottaShingles();
        chalk();
        dyedSoapstone();

    }

    private void terracottaShingles() {
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(KekeBlocks.getDyedTerracottaShingles(colours));
            dropSelf(KekeBlocks.getDyedTerracottaShingleStairs(colours));
            dropSelf(KekeBlocks.getDyedTerracottaShingleSlab(colours));
            dropSelf(KekeBlocks.getDyedTerracottaShingleWall(colours));
        }
        dropSelf(KekeBlocks.TERRACOTTA_SHINGLES.get());
        dropSelf(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get());
        dropSelf(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get());
        dropSelf(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get());
    }
    private void chalk() {
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(KekeBlocks.getChalk(colours));
        }
    }

    private void dyedSoapstone() {
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(KekeBlocks.getDyedSoapstone(colours));
            dropSelf(KekeBlocks.getDyedSoapstoneStairs(colours));
            dropSelf(KekeBlocks.getDyedSoapstoneSlab(colours));
            dropSelf(KekeBlocks.getDyedSoapstoneWall(colours));
            dropSelf(KekeBlocks.getDyedSoapstoneBricks(colours));
            dropSelf(KekeBlocks.getDyedSoapstoneBrickStairs(colours));
            dropSelf(KekeBlocks.getDyedSoapstoneBrickSlab(colours));
            dropSelf(KekeBlocks.getDyedSoapstoneBrickWall(colours));
        }
        dropSelf(KekeBlocks.SOAPSTONE.get());
        dropSelf(KekeBlocks.SOAPSTONE_SLAB.get());
        dropSelf(KekeBlocks.SOAPSTONE_WALL.get());
        dropSelf(KekeBlocks.SOAPSTONE_STAIRS.get());
        dropSelf(KekeBlocks.SOAPSTONE_BRICKS.get());
        dropSelf(KekeBlocks.SOAPSTONE_BRICK_SLAB.get());
        dropSelf(KekeBlocks.SOAPSTONE_BRICK_WALL.get());
        dropSelf(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get());
    }


    private void cork() {
        createLeavesDrops(KekeBlocks.CORK_LEAVES.get(), KekeBlocks.CORK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES);
    }
}
