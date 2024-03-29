package com.kekecreations.arts_and_crafts.core.fabric.misc;

import com.google.common.collect.Maps;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.fabric.registry.KekeFabricFlammableAndStrippableBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.stream.Stream;

public class KekeBlockFamilies {

    private static final Map<Block, BlockFamily> BASE_BLOCKS_TO_FAMILIES = Maps.newHashMap();

    static {
        for (DyeColor colours : DyeColor.values()) {
            KekeBlockFamilies.register(KekeBlocks.getDyedTerracottaShingles(colours.getId())).slab(KekeBlocks.getDyedTerracottaShingleSlab(colours.getId())).stairs(KekeBlocks.getDyedTerracottaShingleStairs(colours.getId())).wall(KekeBlocks.getDyedTerracottaShingleWall(colours.getId())).getFamily();

            KekeBlockFamilies.register(KekeBlocks.getDyedSoapstone(colours.getId())).slab(KekeBlocks.getDyedSoapstoneSlab(colours.getId())).stairs(KekeBlocks.getDyedSoapstoneStairs(colours.getId())).wall(KekeBlocks.getDyedSoapstoneWall(colours.getId())).getFamily();

            KekeBlockFamilies.register(KekeBlocks.getDyedSoapstoneBricks(colours.getId())).slab(KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId())).stairs(KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId())).wall(KekeBlocks.getDyedSoapstoneBrickWall(colours.getId())).getFamily();
        }
    }


    public static final BlockFamily TERRACOTTA_SHINGLES = KekeBlockFamilies.register(KekeBlocks.TERRACOTTA_SHINGLES.get()).slab(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get()).wall(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get()).stairs(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get()).getFamily();

    public static final BlockFamily SOAPSTONE = KekeBlockFamilies.register(KekeBlocks.SOAPSTONE.get()).slab(KekeBlocks.SOAPSTONE_SLAB.get()).wall(KekeBlocks.SOAPSTONE_WALL.get()).stairs(KekeBlocks.SOAPSTONE_STAIRS.get()).getFamily();

    public static final BlockFamily SOAPSTONE_BRICKS = KekeBlockFamilies.register(KekeBlocks.SOAPSTONE_BRICKS.get()).slab(KekeBlocks.SOAPSTONE_BRICK_SLAB.get()).wall(KekeBlocks.SOAPSTONE_BRICK_WALL.get()).stairs(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get()).getFamily();

    public static final BlockFamily CORK = KekeBlockFamilies.register(KekeBlocks.CORK_PLANKS.get())
            .sign(KekeBlocks.CORK_SIGN.get(), KekeBlocks.CORK_WALL_SIGN.get())
            .pressurePlate(KekeBlocks.CORK_PRESSURE_PLATE.get())
            .button(KekeBlocks.CORK_BUTTON.get())
            .door(KekeBlocks.CORK_DOOR.get())
            .trapdoor(KekeBlocks.CORK_TRAPDOOR.get())
            .fence(KekeBlocks.CORK_FENCE.get())
            .fenceGate(KekeBlocks.CORK_FENCE_GATE.get())
            .slab(KekeBlocks.CORK_SLAB.get())
            .stairs(KekeBlocks.CORK_STAIRS.get()).getFamily();



    public static BlockFamily.Builder register(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = BASE_BLOCKS_TO_FAMILIES.put(baseBlock, builder.getFamily());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + BuiltInRegistries.BLOCK.getKey(baseBlock));
        }
        return builder;
    }

    public static Stream<BlockFamily> getFamilies() {
        return BASE_BLOCKS_TO_FAMILIES.values().stream();
    }
}
