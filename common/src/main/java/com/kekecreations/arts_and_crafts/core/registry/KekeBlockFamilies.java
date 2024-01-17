package com.kekecreations.arts_and_crafts.core.registry;

import com.google.common.collect.Maps;
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
            KekeBlockFamilies.register(KekeBlocks.getDyedTerracottaShingles(colours)).slab(KekeBlocks.getDyedTerracottaShingleSlab(colours)).stairs(KekeBlocks.getDyedTerracottaShingleStairs(colours)).wall(KekeBlocks.getDyedTerracottaShingleWall(colours)).getFamily();

            KekeBlockFamilies.register(KekeBlocks.getDyedSoapstone(colours)).slab(KekeBlocks.getDyedSoapstoneSlab(colours)).stairs(KekeBlocks.getDyedSoapstoneStairs(colours)).wall(KekeBlocks.getDyedSoapstoneWall(colours)).getFamily();
        }
    }


    public static final BlockFamily TERRACOTTA_SHINGLES = KekeBlockFamilies.register(KekeBlocks.TERRACOTTA_SHINGLES.get()).slab(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get()).wall(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get()).stairs(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get()).getFamily();

    public static final BlockFamily SOAPSTONE = KekeBlockFamilies.register(KekeBlocks.SOAPSTONE.get()).slab(KekeBlocks.SOAPSTONE_SLAB.get()).wall(KekeBlocks.SOAPSTONE_WALL.get()).stairs(KekeBlocks.SOAPSTONE_STAIRS.get()).getFamily();



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
