package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.common.block.*;
import com.kekecreations.arts_and_crafts.common.block.grower.CorkTreeGrower;
import com.kekecreations.arts_and_crafts.common.misc.KekeBlockSetType;
import com.kekecreations.arts_and_crafts.common.misc.KekeWoodType;
import com.kekecreations.arts_and_crafts.core.platform.Services;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.HashMap;
import java.util.function.Supplier;

public class ACBlocks {

    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLES = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLE_SLAB = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLE_WALL = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLE_STAIRS = new HashMap<>();

    public static final HashMap<Integer, Supplier<Block>> CHALK = new HashMap<>();
    public static final HashMap<Integer, Supplier<Block>> CHALK_DUST = new HashMap<>();

    public static final HashMap<DyeColor, Supplier<Block>> DYED_MUD_BRICKS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_MUD_BRICK_SLAB = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_MUD_BRICK_WALL = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_MUD_BRICK_STAIRS = new HashMap<>();


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

    public static final HashMap<DyeColor, Supplier<Block>> DYED_POLISHED_SOAPSTONE = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POLISHED_SOAPSTONE_SLAB = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POLISHED_SOAPSTONE_WALL = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POLISHED_SOAPSTONE_STAIRS = new HashMap<>();

    public static final HashMap<DyeColor, Supplier<Block>> DYED_DECORATED_POTS = new HashMap<>();

    public static final HashMap<DyeColor, Supplier<Block>> DYED_PLASTER = new HashMap<>();

    public static final Supplier<Block> LOTUS_FLOWER = registerBlock("lotus_flower", () -> new LotusFlowerBlock(BlockBehaviour.Properties.copy(Blocks.LILY_PAD).randomTicks().lightLevel(($$0x) -> {
        switch ($$0x.getValue(BlockStateProperties.AGE_3)) {
            case 0, 1 -> {
                return 5;
            }
            case 2, 3 -> {
                return 10;
            }
            default -> {
                return 0;
            }
        }
    })));

    //BLEACHED
    public static final Supplier<Block> GLAZED_TERRACOTTA = registerBlockWithItem("glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)));
    public static final Supplier<Block> BLEACHED_WOOL = registerBlockWithItem("bleached_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> BLEACHED_CONCRETE = registerBlockWithItem("bleached_concrete", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> BLEACHED_CONCRETE_POWDER = registerBlockWithItem("bleached_concrete_powder", () -> new ConcretePowderBlock(BLEACHED_CONCRETE.get(), BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE_POWDER)));
    public static final Supplier<Block> BLEACHED_CARPET = registerBlockWithItem("bleached_carpet", () -> new CarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET)));
    public static final Supplier<Block> BLEACHED_CHALK_DUST = registerBlock("bleached_chalk_dust", () -> new ChalkDustBlock(-1, BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).sound(SoundType.CALCITE).noCollission().instabreak()));
    public static final Supplier<Block> BLEACHED_CHALK = registerBlockWithItem("bleached_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(0.9f)));
    public static final Supplier<Block> BLEACHED_BED = registerBlock("bleached_bed", () -> bed(DyeColor.WHITE));


    //GYPSUM
    public static final Supplier<Block> GYPSUM = registerBlockWithItem("gypsum", () -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).requiresCorrectToolForDrops().strength(1.75F, 5F)));
    public static final Supplier<SlabBlock> GYPSUM_SLAB = registerBlockWithItem("gypsum_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(GYPSUM.get())));
    public static final Supplier<WallBlock> GYPSUM_WALL = registerBlockWithItem("gypsum_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(GYPSUM.get())));
    public static final Supplier<ACStairBlock> GYPSUM_STAIRS = registerBlockWithItem("gypsum_stairs", () -> new ACStairBlock(GYPSUM.get().defaultBlockState(), BlockBehaviour.Properties.copy(GYPSUM.get())));
    public static final Supplier<Block> GYPSUM_BRICKS = registerBlockWithItem("gypsum_bricks", () -> new Block(BlockBehaviour.Properties.copy(GYPSUM.get())));
    public static final Supplier<SlabBlock> GYPSUM_BRICK_SLAB = registerBlockWithItem("gypsum_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(GYPSUM_BRICKS.get())));
    public static final Supplier<WallBlock> GYPSUM_BRICK_WALL = registerBlockWithItem("gypsum_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(GYPSUM_BRICKS.get())));
    public static final Supplier<ACStairBlock> GYPSUM_BRICK_STAIRS = registerBlockWithItem("gypsum_brick_stairs", () -> new ACStairBlock(GYPSUM_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(GYPSUM_BRICKS.get())));
    public static final Supplier<Block> POLISHED_GYPSUM = registerBlockWithItem("polished_gypsum", () -> new Block(BlockBehaviour.Properties.copy(GYPSUM.get())));
    public static final Supplier<SlabBlock> POLISHED_GYPSUM_SLAB = registerBlockWithItem("polished_gypsum_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_GYPSUM.get())));
    public static final Supplier<WallBlock> POLISHED_GYPSUM_WALL = registerBlockWithItem("polished_gypsum_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_GYPSUM.get())));
    public static final Supplier<ACStairBlock> POLISHED_GYPSUM_STAIRS = registerBlockWithItem("polished_gypsum_stairs", () -> new ACStairBlock(POLISHED_GYPSUM.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_GYPSUM.get())));

    //NORMAL TERRACOTTA SHINGLES
    public static final Supplier<Block> TERRACOTTA_SHINGLES = registerBlockWithItem("terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25f, 4.2f)));
    public static final Supplier<SlabBlock> TERRACOTTA_SHINGLE_SLAB = registerBlockWithItem("terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(TERRACOTTA_SHINGLES.get())));
    public static final Supplier<WallBlock> TERRACOTTA_SHINGLE_WALL = registerBlockWithItem("terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(TERRACOTTA_SHINGLES.get())));
    public static final Supplier<ACStairBlock> TERRACOTTA_SHINGLE_STAIRS = registerBlockWithItem("terracotta_shingle_stairs", () -> new ACStairBlock(TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.copy(TERRACOTTA_SHINGLES.get())));


    //SOAPSTONE
    public static final Supplier<Block> SOAPSTONE = registerBlockWithItem("soapstone", () -> new Block(BlockBehaviour.Properties.of().sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F)));
    public static final Supplier<SlabBlock> SOAPSTONE_SLAB = registerBlockWithItem("soapstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SOAPSTONE.get())));
    public static final Supplier<WallBlock> SOAPSTONE_WALL = registerBlockWithItem("soapstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SOAPSTONE.get())));
    public static final Supplier<ACStairBlock> SOAPSTONE_STAIRS = registerBlockWithItem("soapstone_stairs", () -> new ACStairBlock(SOAPSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SOAPSTONE.get())));

    public static final Supplier<Block> SOAPSTONE_BRICKS = registerBlockWithItem("soapstone_bricks", () -> new Block(BlockBehaviour.Properties.of().sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F)));
    public static final Supplier<SlabBlock> SOAPSTONE_BRICK_SLAB = registerBlockWithItem("soapstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SOAPSTONE_BRICKS.get())));
    public static final Supplier<WallBlock> SOAPSTONE_BRICK_WALL = registerBlockWithItem("soapstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(SOAPSTONE_BRICKS.get())));
    public static final Supplier<ACStairBlock> SOAPSTONE_BRICK_STAIRS = registerBlockWithItem("soapstone_brick_stairs", () -> new ACStairBlock(SOAPSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(SOAPSTONE_BRICKS.get())));

    public static final Supplier<Block> POLISHED_SOAPSTONE = registerBlockWithItem("polished_soapstone", () -> new Block(BlockBehaviour.Properties.of().sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F)));
    public static final Supplier<SlabBlock> POLISHED_SOAPSTONE_SLAB = registerBlockWithItem("polished_soapstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_SOAPSTONE.get())));
    public static final Supplier<WallBlock> POLISHED_SOAPSTONE_WALL = registerBlockWithItem("polished_soapstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(POLISHED_SOAPSTONE.get())));
    public static final Supplier<ACStairBlock> POLISHED_SOAPSTONE_STAIRS = registerBlockWithItem("polished_soapstone_stairs", () -> new ACStairBlock(POLISHED_SOAPSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(SOAPSTONE.get())));

    //CORK
    public static final Supplier<ACTrapDoorBlock> CORK_TRAPDOOR = registerBlockWithItem("cork_trapdoor", () -> new ACTrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().isValidSpawn(ACBlocks::never).ignitedByLava(), KekeBlockSetType.CORK));
    public static final Supplier<ACDoorBlock> CORK_DOOR = registerBlockWithItem("cork_door", () -> new ACDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), KekeBlockSetType.CORK));
    public static final Supplier<StandingSignBlock> CORK_SIGN = registerBlock("cork_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0f).ignitedByLava(), KekeWoodType.CORK));
    public static final Supplier<WallSignBlock> CORK_WALL_SIGN = registerBlock("cork_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0f).dropsLike(CORK_SIGN.get()).ignitedByLava(), KekeWoodType.CORK));
    public static final Supplier<CeilingHangingSignBlock> CORK_HANGING_SIGN = registerBlock("cork_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0f).ignitedByLava(), KekeWoodType.CORK));
    public static final Supplier<WallHangingSignBlock> CORK_WALL_HANGING_SIGN = registerBlock("cork_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0f).ignitedByLava().dropsLike(CORK_HANGING_SIGN.get()), KekeWoodType.CORK));
    public static final Supplier<ACPressurePlateBlock> CORK_PRESSURE_PLATE = registerBlockWithItem("cork_pressure_plate", () -> new ACPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5f).ignitedByLava().pushReaction(PushReaction.DESTROY), KekeBlockSetType.CORK));
    public static final Supplier<ACButtonBlock> CORK_BUTTON = registerBlockWithItem("cork_button", () -> new ACButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5f).pushReaction(PushReaction.DESTROY), KekeBlockSetType.CORK, 30, true));

    //CORK ETC

    public static final Supplier<FloatingBlock> CORK = registerBlockWithItem("cork", () -> new FloatingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2.0F).sound(ACSoundTypes.CORK).instrument(NoteBlockInstrument.BASS)));
    public static final Supplier<FloatingBlock> SMOOTH_CORK = registerBlockWithItem("smooth_cork", () -> new FloatingBlock(BlockBehaviour.Properties.copy(CORK.get())));
    public static final Supplier<SaplingBlock> CORK_SAPLING = registerBlockWithItem("cork_sapling", () -> new CorkSapling(new CorkTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));


    public static final Supplier<ACFlammableRotatedPillarBlock> CORK_LOG = registerBlockWithItem("cork_log", () -> log(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));

    public static final Supplier<ACFlammableRotatedPillarBlock> STRIPPED_CORK_LOG = registerBlockWithItem("stripped_cork_log", () -> log(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));

    public static final Supplier<ACFlammableRotatedPillarBlock> CORK_WOOD = registerBlockWithItem("cork_wood", () -> new ACFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(ACSoundTypes.CORK).ignitedByLava()));

    public static final Supplier<ACFlammableRotatedPillarBlock> STRIPPED_CORK_WOOD = registerBlockWithItem("stripped_cork_wood", () -> new ACFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(ACSoundTypes.CORK).ignitedByLava()));

    public static final Supplier<ACFlammableBlock> CORK_PLANKS = registerBlockWithItem("cork_planks", () -> new ACFlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));
    public static final Supplier<ACFlammableSlabBlock> CORK_SLAB = registerBlockWithItem("cork_slab", () -> new ACFlammableSlabBlock(BlockBehaviour.Properties.copy(CORK_PLANKS.get()).sound(ACSoundTypes.CORK)));
    public static final Supplier<ACFlammableStairBlock> CORK_STAIRS = registerBlockWithItem("cork_stairs", () -> new ACFlammableStairBlock(CORK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CORK_PLANKS.get()).sound(ACSoundTypes.CORK)));
    public static final Supplier<ACFlammableFenceBlock> CORK_FENCE = registerBlockWithItem("cork_fence", () -> new ACFlammableFenceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));
    public static final Supplier<ACFlammableFenceGateBlock> CORK_FENCE_GATE = registerBlockWithItem("cork_fence_gate", () -> new ACFlammableFenceGateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).sound(ACSoundTypes.CORK).strength(2.0f, 3.0f).ignitedByLava(), KekeWoodType.CORK));
    public static final Supplier<ACFlammableLeavesBlock> CORK_LEAVES = registerBlockWithItem("cork_leaves", () -> leaves(SoundType.GRASS));

    public static final Supplier<FlowerPotBlock> POTTED_CORK_SAPLING = registerBlock("potted_cork_sapling", () -> ACBlocks.vanillaFlowerPot(CORK_SAPLING.get(), new FeatureFlag[0]));


    public static final Supplier<PlasterBlock> PLASTER = registerBlockWithItem("plaster", () -> new PlasterBlock(null, BlockBehaviour.Properties.of().strength(1.25F, 1F).sound(SoundType.PACKED_MUD).instrument(NoteBlockInstrument.BASEDRUM)));


    static {
        CHALK_DUST.put(-1, BLEACHED_CHALK_DUST);
        CHALK.put(-1, BLEACHED_CHALK);
        for (DyeColor colours : DyeColor.values()) {
            //DYED PLASTER
            DYED_PLASTER.put(colours, registerBlockWithItem(colours + "_plaster", () -> new PlasterBlock(colours, BlockBehaviour.Properties.copy(PLASTER.get()))));

            //DYED MUD BRICKS
            DYED_MUD_BRICKS.put(colours, registerBlockWithItem(colours + "_mud_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS).mapColor(colours))));
            DYED_MUD_BRICK_SLAB.put(colours, registerBlockWithItem(colours + "_mud_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICK_SLAB).mapColor(colours))));
            DYED_MUD_BRICK_WALL.put(colours, registerBlockWithItem(colours + "_mud_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICK_WALL).mapColor(colours))));
            DYED_MUD_BRICK_STAIRS.put(colours, registerBlockWithItem(colours + "_mud_brick_stairs", () -> new ACStairBlock(getDyedMudBricks(colours.getId()).defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.MUD_BRICK_SLAB).mapColor(colours))));

            //DYED TERRACOTTA SHINGLES
            DYED_TERRACOTTA_SHINGLES.put(colours, registerBlockWithItem(colours + "_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25f, 4.2f))));
            DYED_TERRACOTTA_SHINGLE_SLAB.put(colours, registerBlockWithItem(colours + "_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(getDyedTerracottaShingles(colours.getId())))));
            DYED_TERRACOTTA_SHINGLE_WALL.put(colours, registerBlockWithItem(colours + "_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(getDyedTerracottaShingles(colours.getId())))));
            DYED_TERRACOTTA_SHINGLE_STAIRS.put(colours, registerBlockWithItem(colours + "_terracotta_shingle_stairs", () -> new ACStairBlock(getDyedTerracottaShingles(colours.getId()).defaultBlockState(), BlockBehaviour.Properties.copy(getDyedTerracottaShingles(colours.getId())))));

            //DYED SOAPSTONE
            DYED_SOAPSTONE.put(colours, registerBlockWithItem(colours + "_soapstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F))));
            DYED_SOAPSTONE_SLAB.put(colours, registerBlockWithItem(colours + "_soapstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(getDyedSoapstone(colours.getId())))));
            DYED_SOAPSTONE_WALL.put(colours, registerBlockWithItem(colours + "_soapstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(getDyedSoapstone(colours.getId())))));
            DYED_SOAPSTONE_STAIRS.put(colours, registerBlockWithItem(colours + "_soapstone_stairs", () -> new ACStairBlock(getDyedSoapstone(colours.getId()).defaultBlockState(), BlockBehaviour.Properties.copy(getDyedSoapstone(colours.getId())))));

            DYED_SOAPSTONE_BRICKS.put(colours, registerBlockWithItem(colours + "_soapstone_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F))));
            DYED_SOAPSTONE_BRICK_SLAB.put(colours, registerBlockWithItem(colours + "_soapstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(getDyedSoapstone(colours.getId())))));
            DYED_SOAPSTONE_BRICK_WALL.put(colours, registerBlockWithItem(colours + "_soapstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(getDyedSoapstone(colours.getId())))));
            DYED_SOAPSTONE_BRICK_STAIRS.put(colours, registerBlockWithItem(colours + "_soapstone_brick_stairs", () -> new ACStairBlock(getDyedSoapstone(colours.getId()).defaultBlockState(), BlockBehaviour.Properties.copy(getDyedSoapstone(colours.getId())))));

            DYED_POLISHED_SOAPSTONE.put(colours, registerBlockWithItem(colours + "_polished_soapstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F))));
            DYED_POLISHED_SOAPSTONE_SLAB.put(colours, registerBlockWithItem(colours + "_polished_soapstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(getDyedPolishedSoapstone(colours.getId())))));
            DYED_POLISHED_SOAPSTONE_WALL.put(colours, registerBlockWithItem(colours + "_polished_soapstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(getDyedPolishedSoapstone(colours.getId())))));
            DYED_POLISHED_SOAPSTONE_STAIRS.put(colours, registerBlockWithItem(colours + "_polished_soapstone_stairs", () -> new ACStairBlock(getDyedPolishedSoapstone(colours.getId()).defaultBlockState(), BlockBehaviour.Properties.copy(getDyedPolishedSoapstone(colours.getId())))));

            //CHALK
            CHALK.put(colours.getId(), registerBlockWithItem(colours + "_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(0.9f))));

            CHALK_DUST.put(colours.getId(), registerBlock(colours + "_chalk_dust", () -> new ChalkDustBlock(colours.getId(), BlockBehaviour.Properties.of().mapColor(colours).sound(SoundType.CALCITE).noCollission().instabreak())));


            DYED_FLOWER_POTS.put(colours, registerBlockWithItem(colours + "_flower_pot", () -> ACBlocks.flowerPot(Blocks.AIR, colours)));

            //DYED SAPLING POTS
            DYED_OAK_SAPLING_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_oak_sapling", () -> ACBlocks.flowerPot(Blocks.OAK_SAPLING, colours)));
            DYED_SPRUCE_SAPLING_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_spruce_sapling", () -> ACBlocks.flowerPot(Blocks.SPRUCE_SAPLING, colours)));
            DYED_BIRCH_SAPLING_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_birch_sapling", () -> ACBlocks.flowerPot(Blocks.BIRCH_SAPLING, colours)));
            DYED_JUNGLE_SAPLING_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_jungle_sapling", () -> ACBlocks.flowerPot(Blocks.JUNGLE_SAPLING, colours)));
            DYED_ACACIA_SAPLING_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_acacia_sapling", () -> ACBlocks.flowerPot(Blocks.ACACIA_SAPLING, colours)));
            DYED_CHERRY_SAPLING_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_cherry_sapling", () -> ACBlocks.flowerPot(Blocks.CHERRY_SAPLING, colours)));
            DYED_DARK_OAK_SAPLING_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_dark_oak_sapling", () -> ACBlocks.flowerPot(Blocks.DARK_OAK_SAPLING, colours)));
            DYED_MANGROVE_PROPAGULE_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_mangrove_propagule", () -> ACBlocks.flowerPot(Blocks.MANGROVE_PROPAGULE, colours)));
            DYED_CORK_SAPLING_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_cork_sapling", () -> ACBlocks.flowerPot(ACBlocks.CORK_SAPLING.get(), colours)));

            //DYED FUNGUS POTS
            DYED_CRIMSON_FUNGUS_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_crimson_fungus", () -> ACBlocks.flowerPot(Blocks.CRIMSON_FUNGUS, colours)));
            DYED_WARPED_FUNGUS_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_warped_fungus", () -> ACBlocks.flowerPot(Blocks.WARPED_FUNGUS, colours)));

            //DYED ROOTS POTS
            DYED_CRIMSON_ROOTS_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_crimson_roots", () -> ACBlocks.flowerPot(Blocks.CRIMSON_ROOTS, colours)));
            DYED_WARPED_ROOTS_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_warped_roots", () -> ACBlocks.flowerPot(Blocks.WARPED_ROOTS, colours)));

            //DYED FLOWER POTS
            DYED_FERN_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_fern", () -> ACBlocks.flowerPot(Blocks.FERN, colours)));
            DYED_DANDELION_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_dandelion", () -> ACBlocks.flowerPot(Blocks.DANDELION, colours)));
            DYED_POPPY_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_poppy", () -> ACBlocks.flowerPot(Blocks.POPPY, colours)));
            DYED_BLUE_ORCHID_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_blue_orchid", () -> ACBlocks.flowerPot(Blocks.BLUE_ORCHID, colours)));
            DYED_ALLIUM_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_allium", () -> ACBlocks.flowerPot(Blocks.ALLIUM, colours)));
            DYED_AZURE_BLUET_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_azure_bluet", () -> ACBlocks.flowerPot(Blocks.AZURE_BLUET, colours)));
            DYED_RED_TULIP_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_red_tulip", () -> ACBlocks.flowerPot(Blocks.RED_TULIP, colours)));
            DYED_ORANGE_TULIP_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_orange_tulip", () -> ACBlocks.flowerPot(Blocks.ORANGE_TULIP, colours)));
            DYED_WHITE_TULIP_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_white_tulip", () -> ACBlocks.flowerPot(Blocks.WHITE_TULIP, colours)));
            DYED_PINK_TULIP_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_pink_tulip", () -> ACBlocks.flowerPot(Blocks.PINK_TULIP, colours)));
            DYED_OXEYE_DAISY_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_oxeye_daisy", () -> ACBlocks.flowerPot(Blocks.OXEYE_DAISY, colours)));
            DYED_CORNFLOWER_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_cornflower", () -> ACBlocks.flowerPot(Blocks.CORNFLOWER, colours)));
            DYED_LILY_OF_THE_VALLEY_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_lily_of_the_valley", () -> ACBlocks.flowerPot(Blocks.LILY_OF_THE_VALLEY, colours)));
            DYED_WITHER_ROSE_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_wither_rose", () -> ACBlocks.flowerPot(Blocks.WITHER_ROSE, colours)));
            DYED_RED_MUSHROOM_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_red_mushroom", () -> ACBlocks.flowerPot(Blocks.RED_MUSHROOM, colours)));
            DYED_BROWN_MUSHROOM_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_brown_mushroom", () -> ACBlocks.flowerPot(Blocks.BROWN_MUSHROOM, colours)));
            DYED_DEAD_BUSH_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_dead_bush", () -> ACBlocks.flowerPot(Blocks.DEAD_BUSH, colours)));
            DYED_CACTUS_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_cactus", () -> ACBlocks.flowerPot(Blocks.CACTUS, colours)));
            DYED_BAMBOO_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_bamboo", () -> ACBlocks.flowerPot(Blocks.BAMBOO, colours)));
            DYED_AZALEA_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_azalea_bush", () -> ACBlocks.flowerPot(Blocks.AZALEA, colours)));
            DYED_FLOWERING_AZALEA_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_flowering_azalea_bush", () -> ACBlocks.flowerPot(Blocks.FLOWERING_AZALEA, colours)));
            DYED_TORCHFLOWER_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_torchflower", () -> ACBlocks.flowerPot(Blocks.TORCHFLOWER, colours)));


            //DYED DECORATED POTS
            DYED_DECORATED_POTS.put(colours, registerBlock(colours + "_decorated_pot", () -> new DyedDecoratedPotBlock(colours, BlockBehaviour.Properties.copy(Blocks.DECORATED_POT))));
        }
    }

    //GET METHODS
    //DYED MUD BRICKS
    public static Block getDyedMudBricks(int colours) {
        return DYED_MUD_BRICKS.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedMudBrickSlab(int colours) {
        return DYED_MUD_BRICK_SLAB.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedMudBrickWall(int colours) {
        return DYED_MUD_BRICK_WALL.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedMudBrickStairs(int colours) {
        return DYED_MUD_BRICK_STAIRS.get(DyeColor.byId(colours)).get();
    }
    //PLASTER
    public static Block getDyedPlaster(int colours){
        return DYED_PLASTER.get(DyeColor.byId(colours)).get();
    }
    //GET TERRACOTTA SHINGLES
    public static Block getDyedTerracottaShingles(int colours){
        return DYED_TERRACOTTA_SHINGLES.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedTerracottaShingleSlab(int colours){
        return DYED_TERRACOTTA_SHINGLE_SLAB.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedTerracottaShingleWall(int colours){
        return DYED_TERRACOTTA_SHINGLE_WALL.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedTerracottaShingleStairs(int colours){
        return DYED_TERRACOTTA_SHINGLE_STAIRS.get(DyeColor.byId(colours)).get();
    }

    //GET CHALK
    public static Block getChalk(int colours){
        return CHALK.get(colours).get();
    }
    public static Block getChalkDust(int colours){
        return CHALK_DUST.get(colours).get();
    }

    //GET DYED FLOWER POTS
    public static Block getDyedFlowerPot(int colours){
        return DYED_FLOWER_POTS.get(DyeColor.byId(colours)).get();
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
    public static Block getDyedSoapstone(int colours){
        return DYED_SOAPSTONE.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedSoapstoneSlab(int colours){
        return DYED_SOAPSTONE_SLAB.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedSoapstoneWall(int colours){
        return DYED_SOAPSTONE_WALL.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedSoapstoneStairs(int colours){
        return DYED_SOAPSTONE_STAIRS.get(DyeColor.byId(colours)).get();
    }

    public static Block getDyedSoapstoneBricks(int colours){
        return DYED_SOAPSTONE_BRICKS.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedSoapstoneBrickSlab(int colours){
        return DYED_SOAPSTONE_BRICK_SLAB.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedSoapstoneBrickWall(int colours){
        return DYED_SOAPSTONE_BRICK_WALL.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedSoapstoneBrickStairs(int colours){
        return DYED_SOAPSTONE_BRICK_STAIRS.get(DyeColor.byId(colours)).get();
    }

    public static Block getDyedPolishedSoapstone(int colours){
        return DYED_POLISHED_SOAPSTONE.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedPolishedSoapstoneSlab(int colours){
        return DYED_POLISHED_SOAPSTONE_SLAB.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedPolishedSoapstoneWall(int colours){
        return DYED_POLISHED_SOAPSTONE_WALL.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedPolishedSoapstoneStairs(int colours){
        return DYED_POLISHED_SOAPSTONE_STAIRS.get(DyeColor.byId(colours)).get();
    }
    public static Block getDyedPottedCorkSapling(DyeColor colours){
        return DYED_CORK_SAPLING_FLOWER_POTS.get(colours).get();
    }

    public static Block getDyedDecoratedPot(int colours) {
        return DYED_DECORATED_POTS.get(DyeColor.byId(colours)).get();
    }



    private static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        return Services.REGISTRY.registerBlock(name, blockSupplier);
    }

    private static <T extends Block> Supplier<T> registerBlockWithItem(String name, java.util.function.Supplier<T> blockSupplier) {
        return Services.REGISTRY.registerBlockWithItem(name, blockSupplier);
    }

    private static ACFlammableRotatedPillarBlock log(MapColor mapColor, MapColor mapColor2) {
        return new ACFlammableRotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(blockState -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? mapColor : mapColor2).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(SoundType.WOOD).ignitedByLava());
    }

    private static ACFlammableLeavesBlock leaves(SoundType soundType) {
        return new ACFlammableLeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2f).randomTicks().sound(soundType).noOcclusion().isValidSpawn(ACBlocks::ocelotOrParrot).isSuffocating(ACBlocks::never).isViewBlocking(ACBlocks::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(ACBlocks::never));
    }

    private static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }
    public static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    public static Boolean ocelotOrParrot(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return entityType == EntityType.OCELOT || entityType == EntityType.PARROT;
    }

    private static FlowerPotBlock vanillaFlowerPot(Block block, FeatureFlag... featureFlags) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        if (featureFlags.length > 0) {
            properties = properties.requiredFeatures(featureFlags);
        }
        return new FlowerPotBlock(block, properties);
    }

    private static ACFlowerPotBlock flowerPot(Block block, DyeColor dyeColor) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        return new ACFlowerPotBlock(block, dyeColor, properties);
    }

    private static ACBedBlock bed(DyeColor $$0) {
        return new ACBedBlock($$0, BlockBehaviour.Properties.of().mapColor(($$1) -> {
            return $$1.getValue(ACBedBlock.PART) == BedPart.FOOT ? $$0.getMapColor() : MapColor.WOOL;
        }).sound(SoundType.WOOD).strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    }

    public static void register() {
    }

}
