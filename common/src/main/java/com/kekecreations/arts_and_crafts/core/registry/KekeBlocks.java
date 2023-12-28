package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.common.block.ChalkDustBlock;
import com.kekecreations.arts_and_crafts.common.block.CustomFlowerPotBlock;
import com.kekecreations.arts_and_crafts.common.block.CustomStairBlock;
import com.kekecreations.arts_and_crafts.core.platform.RegistryHelper;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

import java.util.HashMap;
import java.util.function.Supplier;

public class KekeBlocks {

    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLES = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLE_SLAB = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLE_WALL = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLE_STAIRS = new HashMap<>();

    public static final HashMap<DyeColor, Supplier<Block>> CHALK = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> CHALK_SLAB = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> CHALK_WALL = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> CHALK_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> CHALK_DUST = new HashMap<>();

    //public static final Supplier<ChalkDustBlock> WHITE_CHALK_DUST = RegistryHelper.registerBlock("white_chalk_dust", () -> new ChalkDustBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).sound(SoundType.CALCITE).noCollission().instabreak()));

    public static final HashMap<DyeColor, Supplier<Block>> DYED_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_CRIMSON_FUNGUS_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_CRIMSON_ROOTS_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_WARPED_FUNGUS_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_WARPED_ROOTS_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_OAK_SAPLING_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_SPRUCE_SAPLING_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_BIRCH_SAPLING_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_JUNGLE_SAPLING_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ACACIA_SAPLING_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_CHERRY_SAPLING_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_DARK_OAK_SAPLING_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_MANGROVE_PROPAGULE_FLOWER_POTS = new HashMap<>();

    //NORMAL TERRACOTTA SHINGLES
    public static final Supplier<Block> TERRACOTTA_SHINGLES = RegistryHelper.registerBlockWithItem("terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.1f, 4.2f)));
    public static final Supplier<SlabBlock> TERRACOTTA_SHINGLE_SLAB = RegistryHelper.registerBlockWithItem("terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.1f, 4.2f)));
    public static final Supplier<WallBlock> TERRACOTTA_SHINGLE_WALL = RegistryHelper.registerBlockWithItem("terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.1f, 4.2f)));
    public static final Supplier<CustomStairBlock> TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.registerBlockWithItem("terracotta_shingle_stairs", () -> new CustomStairBlock(TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.1f, 4.2f)));


    static {
        for (DyeColor colours : DyeColor.values()) {
            //DYED TERRACOTTA SHINGLES
            DYED_TERRACOTTA_SHINGLES.put(colours, RegistryHelper.registerBlockWithItem(colours + "_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.1f, 4.2f))));

            DYED_TERRACOTTA_SHINGLE_SLAB.put(colours, RegistryHelper.registerBlockWithItem(colours + "_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.1f, 4.2f))));

            DYED_TERRACOTTA_SHINGLE_WALL.put(colours, RegistryHelper.registerBlockWithItem(colours + "_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.1f, 4.2f))));

            DYED_TERRACOTTA_SHINGLE_STAIRS.put(colours, RegistryHelper.registerBlockWithItem(colours + "_terracotta_shingle_stairs", () -> new CustomStairBlock(getDyedTerracottaShingles(colours).defaultBlockState(), BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.1f, 4.2f))));

            //CHALK
            CHALK.put(colours, RegistryHelper.registerBlockWithItem(colours + "_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(0.9f))));

            CHALK_SLAB.put(colours, RegistryHelper.registerBlockWithItem(colours + "_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(0.9f))));

            CHALK_WALL.put(colours, RegistryHelper.registerBlockWithItem(colours + "_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(0.9f))));

            CHALK_STAIRS.put(colours, RegistryHelper.registerBlockWithItem(colours + "_chalk_stairs", () -> new CustomStairBlock(getChalk(colours).defaultBlockState(), BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(0.9f))));

            CHALK_DUST.put(colours, RegistryHelper.registerBlock(colours + "_chalk_dust", () -> new ChalkDustBlock(colours, BlockBehaviour.Properties.of().mapColor(colours).sound(SoundType.CALCITE).noCollission().instabreak())));


            DYED_FLOWER_POTS.put(colours, RegistryHelper.registerBlockWithItem(colours + "_flower_pot", () -> KekeBlocks.flowerPot(Blocks.AIR, colours)));

            //DYED SAPLING POTS
            DYED_OAK_SAPLING_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_oak_sapling", () -> KekeBlocks.flowerPot(Blocks.OAK_SAPLING, colours)));
            DYED_SPRUCE_SAPLING_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_spruce_sapling", () -> KekeBlocks.flowerPot(Blocks.SPRUCE_SAPLING, colours)));
            DYED_BIRCH_SAPLING_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_birch_sapling", () -> KekeBlocks.flowerPot(Blocks.BIRCH_SAPLING, colours)));
            DYED_JUNGLE_SAPLING_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_jungle_sapling", () -> KekeBlocks.flowerPot(Blocks.JUNGLE_SAPLING, colours)));
            DYED_ACACIA_SAPLING_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_acacia_sapling", () -> KekeBlocks.flowerPot(Blocks.ACACIA_SAPLING, colours)));
            DYED_CHERRY_SAPLING_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_cherry_sapling", () -> KekeBlocks.flowerPot(Blocks.CHERRY_SAPLING, colours)));
            DYED_DARK_OAK_SAPLING_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_dark_oak_sapling", () -> KekeBlocks.flowerPot(Blocks.DARK_OAK_SAPLING, colours)));
            DYED_MANGROVE_PROPAGULE_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_mangrove_propagule", () -> KekeBlocks.flowerPot(Blocks.MANGROVE_PROPAGULE, colours)));

            //DYED FUNGUS POTS
            DYED_CRIMSON_FUNGUS_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_crimson_fungus", () -> KekeBlocks.flowerPot(Blocks.CRIMSON_FUNGUS, colours)));
            DYED_WARPED_FUNGUS_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_warped_fungus", () -> KekeBlocks.flowerPot(Blocks.WARPED_FUNGUS, colours)));

            //DYED ROOTS POTS
            DYED_CRIMSON_ROOTS_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_crimson_roots", () -> KekeBlocks.flowerPot(Blocks.CRIMSON_ROOTS, colours)));
            DYED_WARPED_ROOTS_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_warped_roots", () -> KekeBlocks.flowerPot(Blocks.WARPED_ROOTS, colours)));
        }
    }

    //GET METHODS
    //GET TERRACOTTA SHINGLES
    public static Block getDyedTerracottaShingles(DyeColor colours){
        return DYED_TERRACOTTA_SHINGLES.get(colours).get();
    }
    public static Block getDyedTerracottaShingleSlab(DyeColor colours){
        return DYED_TERRACOTTA_SHINGLE_SLAB.get(colours).get();
    }
    public static Block getDyedTerracottaShingleWall(DyeColor colours){
        return DYED_TERRACOTTA_SHINGLE_WALL.get(colours).get();
    }
    public static Block getDyedTerracottaShingleStairs(DyeColor colours){
        return DYED_TERRACOTTA_SHINGLE_STAIRS.get(colours).get();
    }

    //GET CHALK
    public static Block getChalk(DyeColor colours){
        return CHALK.get(colours).get();
    }
    public static Block getChalkSlab(DyeColor colours){
        return CHALK_SLAB.get(colours).get();
    }
    public static Block getChalkWall(DyeColor colours){
        return CHALK_WALL.get(colours).get();
    }
    public static Block getChalkStairs(DyeColor colours){
        return CHALK_STAIRS.get(colours).get();
    }
    public static Block getChalkDust(DyeColor colours){
        return CHALK_DUST.get(colours).get();
    }

    //GET DYED FLOWER POTS
    public static Block getDyedFlowerPot(DyeColor colours){
        return DYED_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedCrimsonFungus(DyeColor colours){
        return DYED_CRIMSON_FUNGUS_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedCrimsonRoots(DyeColor colours){
        return DYED_CRIMSON_ROOTS_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedWarpedFungus(DyeColor colours){
        return DYED_WARPED_FUNGUS_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedWarpedRoots(DyeColor colours){
        return DYED_WARPED_ROOTS_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedOakSapling(DyeColor colours){
        return DYED_OAK_SAPLING_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedSpruceSapling(DyeColor colours){
        return DYED_SPRUCE_SAPLING_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedBirchSapling(DyeColor colours){
        return DYED_BIRCH_SAPLING_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedJungleSapling(DyeColor colours){
        return DYED_JUNGLE_SAPLING_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedAcaciaSapling(DyeColor colours){
        return DYED_ACACIA_SAPLING_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedCherrySapling(DyeColor colours){
        return DYED_CHERRY_SAPLING_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedDarkOakSapling(DyeColor colours){
        return DYED_DARK_OAK_SAPLING_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedMangrovePropagule(DyeColor colours){
        return DYED_MANGROVE_PROPAGULE_FLOWER_POTS.get(colours).get();
    }


    private static CustomFlowerPotBlock flowerPot(Block block, DyeColor dyeColor) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        return new CustomFlowerPotBlock(block, dyeColor, properties);
    }

    public static void register() {
    }

}
