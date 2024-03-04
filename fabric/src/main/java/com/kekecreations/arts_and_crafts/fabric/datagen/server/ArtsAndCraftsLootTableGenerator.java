package com.kekecreations.arts_and_crafts.fabric.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.fabric.registry.KekeFabricBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

public class ArtsAndCraftsLootTableGenerator extends FabricBlockLootTableProvider {

    public ArtsAndCraftsLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }


    @Override
    public void generate() {
        terracottaShingles();
        chalk();
        dyedSoapstone();
        cork();

    }

    private void terracottaShingles() {
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(KekeBlocks.getDyedTerracottaShingles(colours.getId()));
            dropSelf(KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()));
            dropSelf(KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()));
            dropSelf(KekeBlocks.getDyedTerracottaShingleWall(colours.getId()));
        }
        dropSelf(KekeBlocks.TERRACOTTA_SHINGLES.get());
        dropSelf(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get());
        dropSelf(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get());
        dropSelf(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get());
    }
    private void chalk() {
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(KekeBlocks.getChalk(colours.getId()));
        }
    }

    private void dyedSoapstone() {
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(KekeBlocks.getDyedSoapstone(colours.getId()));
            dropSelf(KekeBlocks.getDyedSoapstoneStairs(colours.getId()));
            dropSelf(KekeBlocks.getDyedSoapstoneSlab(colours.getId()));
            dropSelf(KekeBlocks.getDyedSoapstoneWall(colours.getId()));
            dropSelf(KekeBlocks.getDyedSoapstoneBricks(colours.getId()));
            dropSelf(KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()));
            dropSelf(KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()));
            dropSelf(KekeBlocks.getDyedSoapstoneBrickWall(colours.getId()));
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
        add(KekeFabricBlocks.CORK_LEAVES.get(), (Block block) -> createLeavesDrops(KekeFabricBlocks.CORK_LEAVES.get(), KekeBlocks.CORK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(KekeBlocks.CORK.get());
        dropSelf(KekeBlocks.SMOOTH_CORK.get());
        dropSelf(KekeFabricBlocks.CORK_LOG.get());
        dropSelf(KekeFabricBlocks.STRIPPED_CORK_LOG.get());
        dropSelf(KekeFabricBlocks.CORK_WOOD.get());
        dropSelf(KekeFabricBlocks.STRIPPED_CORK_WOOD.get());
        dropSelf(KekeFabricBlocks.CORK_PLANKS.get());
        dropSelf(KekeFabricBlocks.CORK_STAIRS.get());
        dropSelf(KekeFabricBlocks.CORK_SLAB.get());
        dropSelf(KekeFabricBlocks.CORK_FENCE.get());
        dropSelf(KekeFabricBlocks.CORK_FENCE_GATE.get());
        dropSelf(KekeBlocks.CORK_BUTTON.get());
        dropSelf(KekeBlocks.CORK_PRESSURE_PLATE.get());
        add(KekeBlocks.CORK_DOOR.get(), (Block block) -> createDoorTable(KekeBlocks.CORK_DOOR.get()));
        dropSelf(KekeBlocks.CORK_TRAPDOOR.get());
        dropSelf(KekeBlocks.CORK_SIGN.get());
        dropSelf(KekeBlocks.CORK_HANGING_SIGN.get());
        dropSelf(KekeBlocks.CORK_SAPLING.get());
    }
}
