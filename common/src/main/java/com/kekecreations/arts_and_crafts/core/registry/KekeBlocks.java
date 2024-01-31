package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.common.block.*;
import com.kekecreations.arts_and_crafts.core.misc.KekeBlockSetType;
import com.kekecreations.arts_and_crafts.core.misc.KekeWoodType;
import com.kekecreations.arts_and_crafts.core.misc.NaturalDyeColor;
import com.kekecreations.arts_and_crafts.core.platform.RegistryHelper;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.HashMap;
import java.util.function.Supplier;

public class KekeBlocks {

    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLES = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLE_SLAB = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLE_WALL = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLE_STAIRS = new HashMap<>();

    public static final HashMap<DyeColor, Supplier<Block>> CHALK = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> CHALK_DUST = new HashMap<>();


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
    public static final HashMap<DyeColor, Supplier<Block>> DYED_FERN_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_DANDELION_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POPPY_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_BLUE_ORCHID_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ALLIUM_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_AZURE_BLUET_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_RED_TULIP_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_ORANGE_TULIP_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_WHITE_TULIP_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_PINK_TULIP_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_OXEYE_DAISY_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_CORNFLOWER_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_LILY_OF_THE_VALLEY_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_WITHER_ROSE_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_RED_MUSHROOM_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_BROWN_MUSHROOM_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_DEAD_BUSH_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_CACTUS_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_BAMBOO_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_AZALEA_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_FLOWERING_AZALEA_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TORCHFLOWER_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_CORK_SAPLING_FLOWER_POTS = new HashMap<>();

    public static final HashMap<DyeColor, Supplier<Block>> DYED_SOAPSTONE = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_SOAPSTONE_SLAB = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_SOAPSTONE_WALL = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_SOAPSTONE_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_SOAPSTONE_BRICKS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_SOAPSTONE_BRICK_SLAB = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_SOAPSTONE_BRICK_WALL = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_SOAPSTONE_BRICK_STAIRS = new HashMap<>();

    //NORMAL TERRACOTTA SHINGLES
    public static final Supplier<Block> TERRACOTTA_SHINGLES = RegistryHelper.registerBlockWithItem("terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25f, 4.2f)));
    public static final Supplier<SlabBlock> TERRACOTTA_SHINGLE_SLAB = RegistryHelper.registerBlockWithItem("terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(TERRACOTTA_SHINGLES.get())));
    public static final Supplier<WallBlock> TERRACOTTA_SHINGLE_WALL = RegistryHelper.registerBlockWithItem("terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(TERRACOTTA_SHINGLES.get())));
    public static final Supplier<CustomStairBlock> TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.registerBlockWithItem("terracotta_shingle_stairs", () -> new CustomStairBlock(TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.copy(TERRACOTTA_SHINGLES.get())));


    //SOAPSTONE
    public static final Supplier<Block> SOAPSTONE = RegistryHelper.registerBlockWithItem("soapstone", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.BASALT).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F)));
    public static final Supplier<SlabBlock> SOAPSTONE_SLAB = RegistryHelper.registerBlockWithItem("soapstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SOAPSTONE.get())));
    public static final Supplier<WallBlock> SOAPSTONE_WALL = RegistryHelper.registerBlockWithItem("soapstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SOAPSTONE.get())));
    public static final Supplier<CustomStairBlock> SOAPSTONE_STAIRS = RegistryHelper.registerBlockWithItem("soapstone_stairs", () -> new CustomStairBlock(SOAPSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SOAPSTONE.get())));

    public static final Supplier<Block> SOAPSTONE_BRICKS = RegistryHelper.registerBlockWithItem("soapstone_bricks", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.BASALT).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F)));
    public static final Supplier<SlabBlock> SOAPSTONE_BRICK_SLAB = RegistryHelper.registerBlockWithItem("soapstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SOAPSTONE_BRICKS.get())));
    public static final Supplier<WallBlock> SOAPSTONE_BRICK_WALL = RegistryHelper.registerBlockWithItem("soapstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SOAPSTONE_BRICKS.get())));
    public static final Supplier<CustomStairBlock> SOAPSTONE_BRICK_STAIRS = RegistryHelper.registerBlockWithItem("soapstone_brick_stairs", () -> new CustomStairBlock(SOAPSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SOAPSTONE_BRICKS.get())));


    //CORK
    public static final Supplier<Block> CORK_PLANKS = RegistryHelper.registerBlockWithItem("cork_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(SoundType.WOOD).ignitedByLava()));
    public static final Supplier<SlabBlock> CORK_SLAB = RegistryHelper.registerBlockWithItem("cork_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CORK_PLANKS.get())));
    public static final Supplier<CustomStairBlock> CORK_STAIRS = RegistryHelper.registerBlockWithItem("cork_stairs", () -> new CustomStairBlock(CORK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CORK_PLANKS.get())));
    public static final Supplier<FenceBlock> CORK_FENCE = RegistryHelper.registerBlockWithItem("cork_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(SoundType.WOOD).ignitedByLava()));
    public static final Supplier<FenceGateBlock> CORK_FENCE_GATE = RegistryHelper.registerBlockWithItem("cork_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).ignitedByLava(), KekeWoodType.CORK));
    public static final Supplier<CustomTrapDoorBlock> CORK_TRAPDOOR = RegistryHelper.registerBlockWithItem("cork_trapdoor", () -> new CustomTrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().isValidSpawn(KekeBlocks::never).ignitedByLava(), KekeBlockSetType.CORK));
    public static final Supplier<CustomDoorBlock> CORK_DOOR = RegistryHelper.registerBlockWithItem("cork_door", () -> new CustomDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), KekeBlockSetType.CORK));
    public static final Supplier<StandingSignBlock> CORK_SIGN = RegistryHelper.registerBlock("cork_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0f).ignitedByLava(), KekeWoodType.CORK));
    public static final Supplier<WallSignBlock> CORK_WALL_SIGN = RegistryHelper.registerBlock("cork_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0f).dropsLike(CORK_SIGN.get()).ignitedByLava(), KekeWoodType.CORK));
    public static final Supplier<CeilingHangingSignBlock> CORK_HANGING_SIGN = RegistryHelper.registerBlock("cork_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0f).ignitedByLava(), KekeWoodType.CORK));
    public static final Supplier<WallHangingSignBlock> CORK_WALL_HANGING_SIGN = RegistryHelper.registerBlock("cork_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0f).ignitedByLava().dropsLike(CORK_HANGING_SIGN.get()), KekeWoodType.CORK));
    public static final Supplier<CustomPressurePlateBlock> CORK_PRESSURE_PLATE = RegistryHelper.registerBlockWithItem("cork_pressure_plate", () -> new CustomPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5f).ignitedByLava().pushReaction(PushReaction.DESTROY), KekeBlockSetType.CORK));
    public static final Supplier<CustomButtonBlock> CORK_BUTTON = RegistryHelper.registerBlockWithItem("cork_button", () -> new CustomButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5f).pushReaction(PushReaction.DESTROY), KekeBlockSetType.CORK, 30, true));

    //CORK ETC
    public static final Supplier<RotatedPillarBlock> CORK_LOG = RegistryHelper.registerBlockWithItem("cork_log", () -> KekeBlocks.log(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
    public static final Supplier<RotatedPillarBlock> STRIPPED_CORK_LOG = RegistryHelper.registerBlockWithItem("stripped_cork_log", () -> KekeBlocks.log(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
    public static final Supplier<RotatedPillarBlock> CORK_WOOD = RegistryHelper.registerBlockWithItem("cork_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(SoundType.WOOD).ignitedByLava()));
    public static final Supplier<RotatedPillarBlock> STRIPPED_CORK_WOOD = RegistryHelper.registerBlockWithItem("stripped_cork_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(SoundType.WOOD).ignitedByLava()));

    public static final Supplier<CorkBlock> CORK = RegistryHelper.registerBlockWithItem("cork", () -> new CorkBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2.0F).sound(SoundType.WOOD).instrument(NoteBlockInstrument.BASS)));
    public static final Supplier<CorkBlock> SMOOTH_CORK = RegistryHelper.registerBlockWithItem("smooth_cork", () -> new CorkBlock(BlockBehaviour.Properties.copy(CORK.get())));
    public static final Supplier<LeavesBlock> CORK_LEAVES = RegistryHelper.registerBlockWithItem("cork_leaves", () -> KekeBlocks.leaves(SoundType.GRASS));
    public static final Supplier<SaplingBlock> CORK_SAPLING = RegistryHelper.registerBlockWithItem("cork_sapling", () -> new CorkSapling(new OakTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));

    public static final Supplier<FlowerPotBlock> POTTED_CORK_SAPLING = RegistryHelper.registerBlock("potted_cork_sapling", () -> KekeBlocks.vanillaFlowerPot(CORK_SAPLING.get(), new FeatureFlag[0]));



    static {
        for (DyeColor colours : DyeColor.values()) {
            //DYED TERRACOTTA SHINGLES
            DYED_TERRACOTTA_SHINGLES.put(colours, RegistryHelper.registerBlockWithItem(colours + "_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25f, 4.2f))));
            DYED_TERRACOTTA_SHINGLE_SLAB.put(colours, RegistryHelper.registerBlockWithItem(colours + "_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(getDyedTerracottaShingles(colours)))));
            DYED_TERRACOTTA_SHINGLE_WALL.put(colours, RegistryHelper.registerBlockWithItem(colours + "_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(getDyedTerracottaShingles(colours)))));
            DYED_TERRACOTTA_SHINGLE_STAIRS.put(colours, RegistryHelper.registerBlockWithItem(colours + "_terracotta_shingle_stairs", () -> new CustomStairBlock(getDyedTerracottaShingles(colours).defaultBlockState(), BlockBehaviour.Properties.copy(getDyedTerracottaShingles(colours)))));

            //DYED SOAPSTONE
            DYED_SOAPSTONE.put(colours, RegistryHelper.registerBlockWithItem(NaturalDyeColor.byId(colours.getId()) + "_soapstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).sound(SoundType.BASALT).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F))));
            DYED_SOAPSTONE_SLAB.put(colours, RegistryHelper.registerBlockWithItem(NaturalDyeColor.byId(colours.getId()) + "_soapstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(getDyedSoapstone(colours)))));
            DYED_SOAPSTONE_WALL.put(colours, RegistryHelper.registerBlockWithItem(NaturalDyeColor.byId(colours.getId()) + "_soapstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(getDyedSoapstone(colours)))));
            DYED_SOAPSTONE_STAIRS.put(colours, RegistryHelper.registerBlockWithItem(NaturalDyeColor.byId(colours.getId()) + "_soapstone_stairs", () -> new CustomStairBlock(getDyedSoapstone(colours).defaultBlockState(), BlockBehaviour.Properties.copy(getDyedSoapstone(colours)))));

            DYED_SOAPSTONE_BRICKS.put(colours, RegistryHelper.registerBlockWithItem(NaturalDyeColor.byId(colours.getId()) + "_soapstone_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).sound(SoundType.BASALT).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F))));
            DYED_SOAPSTONE_BRICK_SLAB.put(colours, RegistryHelper.registerBlockWithItem(NaturalDyeColor.byId(colours.getId()) + "_soapstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(getDyedSoapstone(colours)))));
            DYED_SOAPSTONE_BRICK_WALL.put(colours, RegistryHelper.registerBlockWithItem(NaturalDyeColor.byId(colours.getId()) + "_soapstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(getDyedSoapstone(colours)))));
            DYED_SOAPSTONE_BRICK_STAIRS.put(colours, RegistryHelper.registerBlockWithItem(NaturalDyeColor.byId(colours.getId()) + "_soapstone_brick_stairs", () -> new CustomStairBlock(getDyedSoapstone(colours).defaultBlockState(), BlockBehaviour.Properties.copy(getDyedSoapstone(colours)))));

            //CHALK
            CHALK.put(colours, RegistryHelper.registerBlockWithItem(colours + "_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(0.9f))));

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
            DYED_CORK_SAPLING_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_cork_sapling", () -> KekeBlocks.flowerPot(KekeBlocks.CORK_SAPLING.get(), colours)));

            //DYED FUNGUS POTS
            DYED_CRIMSON_FUNGUS_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_crimson_fungus", () -> KekeBlocks.flowerPot(Blocks.CRIMSON_FUNGUS, colours)));
            DYED_WARPED_FUNGUS_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_warped_fungus", () -> KekeBlocks.flowerPot(Blocks.WARPED_FUNGUS, colours)));

            //DYED ROOTS POTS
            DYED_CRIMSON_ROOTS_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_crimson_roots", () -> KekeBlocks.flowerPot(Blocks.CRIMSON_ROOTS, colours)));
            DYED_WARPED_ROOTS_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_warped_roots", () -> KekeBlocks.flowerPot(Blocks.WARPED_ROOTS, colours)));

            //DYED FLOWER POTS
            DYED_FERN_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_fern", () -> KekeBlocks.flowerPot(Blocks.FERN, colours)));
            DYED_DANDELION_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_dandelion", () -> KekeBlocks.flowerPot(Blocks.DANDELION, colours)));
            DYED_POPPY_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_poppy", () -> KekeBlocks.flowerPot(Blocks.POPPY, colours)));
            DYED_BLUE_ORCHID_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_blue_orchid", () -> KekeBlocks.flowerPot(Blocks.BLUE_ORCHID, colours)));
            DYED_ALLIUM_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_allium", () -> KekeBlocks.flowerPot(Blocks.ALLIUM, colours)));
            DYED_AZURE_BLUET_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_azure_bluet", () -> KekeBlocks.flowerPot(Blocks.AZURE_BLUET, colours)));
            DYED_RED_TULIP_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_red_tulip", () -> KekeBlocks.flowerPot(Blocks.RED_TULIP, colours)));
            DYED_ORANGE_TULIP_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_orange_tulip", () -> KekeBlocks.flowerPot(Blocks.ORANGE_TULIP, colours)));
            DYED_WHITE_TULIP_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_white_tulip", () -> KekeBlocks.flowerPot(Blocks.WHITE_TULIP, colours)));
            DYED_PINK_TULIP_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_pink_tulip", () -> KekeBlocks.flowerPot(Blocks.PINK_TULIP, colours)));
            DYED_OXEYE_DAISY_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_oxeye_daisy", () -> KekeBlocks.flowerPot(Blocks.OXEYE_DAISY, colours)));
            DYED_CORNFLOWER_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_cornflower", () -> KekeBlocks.flowerPot(Blocks.CORNFLOWER, colours)));
            DYED_LILY_OF_THE_VALLEY_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_lily_of_the_valley", () -> KekeBlocks.flowerPot(Blocks.LILY_OF_THE_VALLEY, colours)));
            DYED_WITHER_ROSE_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_wither_rose", () -> KekeBlocks.flowerPot(Blocks.WITHER_ROSE, colours)));
            DYED_RED_MUSHROOM_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_red_mushroom", () -> KekeBlocks.flowerPot(Blocks.RED_MUSHROOM, colours)));
            DYED_BROWN_MUSHROOM_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_brown_mushroom", () -> KekeBlocks.flowerPot(Blocks.BROWN_MUSHROOM, colours)));
            DYED_DEAD_BUSH_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_dead_bush", () -> KekeBlocks.flowerPot(Blocks.DEAD_BUSH, colours)));
            DYED_CACTUS_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_cactus", () -> KekeBlocks.flowerPot(Blocks.CACTUS, colours)));
            DYED_BAMBOO_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_bamboo", () -> KekeBlocks.flowerPot(Blocks.BAMBOO, colours)));
            DYED_AZALEA_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_azalea_bush", () -> KekeBlocks.flowerPot(Blocks.AZALEA, colours)));
            DYED_FLOWERING_AZALEA_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_flowering_azalea_bush", () -> KekeBlocks.flowerPot(Blocks.FLOWERING_AZALEA, colours)));
            DYED_TORCHFLOWER_FLOWER_POTS.put(colours, RegistryHelper.registerBlock(colours + "_potted_torchflower", () -> KekeBlocks.flowerPot(Blocks.TORCHFLOWER, colours)));
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
    public static Block getDyedPottedFern(DyeColor colours){
        return DYED_FERN_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedDandelion(DyeColor colours){
        return DYED_DANDELION_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedPoppy(DyeColor colours){
        return DYED_POPPY_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedBlueOrchid(DyeColor colours){
        return DYED_BLUE_ORCHID_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedAllium(DyeColor colours){
        return DYED_ALLIUM_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedAzureBluet(DyeColor colours){
        return DYED_AZURE_BLUET_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedRedTulip(DyeColor colours){
        return DYED_RED_TULIP_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedOrangeTulip(DyeColor colours){
        return DYED_ORANGE_TULIP_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedWhiteTulip(DyeColor colours){
        return DYED_WHITE_TULIP_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedPinkTulip(DyeColor colours){
        return DYED_PINK_TULIP_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedOxeyeDaisy(DyeColor colours){
        return DYED_OXEYE_DAISY_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedCornflower(DyeColor colours){
        return DYED_CORNFLOWER_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedLilyOfTheValley(DyeColor colours){
        return DYED_LILY_OF_THE_VALLEY_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedWitherRose(DyeColor colours){
        return DYED_WITHER_ROSE_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedRedMushroom(DyeColor colours){
        return DYED_RED_MUSHROOM_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedBrownMushroom(DyeColor colours){
        return DYED_BROWN_MUSHROOM_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedDeadBush(DyeColor colours){
        return DYED_DEAD_BUSH_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedCactus(DyeColor colours){
        return DYED_CACTUS_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedBamboo(DyeColor colours){
        return DYED_BAMBOO_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedAzalea(DyeColor colours){
        return DYED_AZALEA_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedFloweringAzalea(DyeColor colours){
        return DYED_FLOWERING_AZALEA_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedTorchFlower(DyeColor colours){
        return DYED_TORCHFLOWER_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedSoapstone(DyeColor colours){
        return DYED_SOAPSTONE.get(colours).get();
    }
    public static Block getDyedSoapstoneSlab(DyeColor colours){
        return DYED_SOAPSTONE_SLAB.get(colours).get();
    }
    public static Block getDyedSoapstoneWall(DyeColor colours){
        return DYED_SOAPSTONE_WALL.get(colours).get();
    }
    public static Block getDyedSoapstoneStairs(DyeColor colours){
        return DYED_SOAPSTONE_STAIRS.get(colours).get();
    }

    public static Block getDyedSoapstoneBricks(DyeColor colours){
        return DYED_SOAPSTONE_BRICKS.get(colours).get();
    }
    public static Block getDyedSoapstoneBrickSlab(DyeColor colours){
        return DYED_SOAPSTONE_BRICK_SLAB.get(colours).get();
    }
    public static Block getDyedSoapstoneBrickWall(DyeColor colours){
        return DYED_SOAPSTONE_BRICK_WALL.get(colours).get();
    }
    public static Block getDyedSoapstoneBrickStairs(DyeColor colours){
        return DYED_SOAPSTONE_BRICK_STAIRS.get(colours).get();
    }
    public static Block getDyedPottedCorkSapling(DyeColor colours){
        return DYED_CORK_SAPLING_FLOWER_POTS.get(colours).get();
    }



    private static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }
    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }
    private static RotatedPillarBlock log(MapColor mapColor, MapColor mapColor2) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(blockState -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? mapColor : mapColor2).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(SoundType.WOOD).ignitedByLava());
    }
    private static LeavesBlock leaves(SoundType soundType) {
        return new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2f).randomTicks().sound(soundType).noOcclusion().isValidSpawn(KekeBlocks::ocelotOrParrot).isSuffocating(KekeBlocks::never).isViewBlocking(KekeBlocks::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(KekeBlocks::never));
    }


    private static Boolean ocelotOrParrot(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return entityType == EntityType.OCELOT || entityType == EntityType.PARROT;
    }

    private static FlowerPotBlock vanillaFlowerPot(Block block, FeatureFlag... featureFlags) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        if (featureFlags.length > 0) {
            properties = properties.requiredFeatures(featureFlags);
        }
        return new FlowerPotBlock(block, properties);
    }

    private static CustomFlowerPotBlock flowerPot(Block block, DyeColor dyeColor) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        return new CustomFlowerPotBlock(block, dyeColor, properties);
    }

    public static void register() {
    }

}
