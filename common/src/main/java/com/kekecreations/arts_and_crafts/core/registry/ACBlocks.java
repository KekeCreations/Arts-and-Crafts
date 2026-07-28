package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.block.*;
import com.kekecreations.arts_and_crafts.common.util.PietraforteColour;
import com.kekecreations.arts_and_crafts.core.init.ACWoodType;
import com.kekecreations.jinxedlib.common.block.*;
import com.kekecreations.jinxedlib.core.util.JinxedRegistryHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
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
import static com.kekecreations.arts_and_crafts.core.init.ACBlockSetType.*;

import java.util.HashMap;
import java.util.function.Function;
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


    //public static final Supplier<Block> CRIMSON_HANGING_FLOWER_POT = registerBlockWithItem("crimson_hanging_flower_pot", registryName -> new HangingFlowerPot(BlockBehaviour.Properties.of().sound(SoundType.CHAIN)));

    public static final HashMap<PietraforteColour, Supplier<Block>> COBBLED_PIETRAFORTE = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<Block>> COBBLED_PIETRAFORTE_STAIRS = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<Block>> COBBLED_PIETRAFORTE_SLAB = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<Block>> COBBLED_PIETRAFORTE_WALL = new HashMap<>();

    public static final HashMap<PietraforteColour, Supplier<Block>> PIETRAFORTE = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<Block>> PIETRAFORTE_STAIRS = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<Block>> PIETRAFORTE_SLAB = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<Block>> PIETRAFORTE_WALL = new HashMap<>();

    public static final HashMap<PietraforteColour, Supplier<Block>> CHISELED_PIETRAFORTE = new HashMap<>();

    public static final HashMap<PietraforteColour, Supplier<Block>> PIETRAFORTE_BRICKS = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<Block>> PIETRAFORTE_BRICK_STAIRS = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<Block>> PIETRAFORTE_BRICK_SLAB = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<Block>> PIETRAFORTE_BRICK_WALL = new HashMap<>();

    public static final HashMap<PietraforteColour, Supplier<Block>> PIETRAFORTE_PILLAR = new HashMap<>();

    public static final HashMap<PietraforteColour, Supplier<Block>> SMOOTH_PIETRAFORTE = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<Block>> SMOOTH_PIETRAFORTE_STAIRS = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<Block>> SMOOTH_PIETRAFORTE_SLAB = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<Block>> SMOOTH_PIETRAFORTE_WALL = new HashMap<>();

    public static final HashMap<PietraforteColour, Supplier<Block>> CUT_PIETRAFORTE = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<Block>> CUT_PIETRAFORTE_STAIRS = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<Block>> CUT_PIETRAFORTE_SLAB = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<Block>> CUT_PIETRAFORTE_WALL = new HashMap<>();


    public static final Supplier<Block> LOTUS_FLOWER = registerBlock("lotus_flower", registryName -> new LotusFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LILY_PAD).randomTicks().setId(JinxedRegistryHelper.blockKey(registryName)).lightLevel(($$0x) -> {
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
    public static final Supplier<Block> GLAZED_TERRACOTTA = registerBlockWithItem("glazed_terracotta", registryName -> new GlazedTerracottaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> BLEACHED_WOOL = registerBlockWithItem("bleached_wool", registryName -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> BLEACHED_CONCRETE = registerBlockWithItem("bleached_concrete", registryName -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> BLEACHED_CONCRETE_POWDER = registerBlockWithItem("bleached_concrete_powder", registryName -> new ConcretePowderBlock(BLEACHED_CONCRETE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE_POWDER).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> BLEACHED_CARPET = registerBlockWithItem("bleached_carpet", registryName -> new CarpetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CARPET).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> BLEACHED_CHALK_DUST = registerBlock("bleached_chalk_dust", registryName -> new ChalkDustBlock(-1, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(DyeColor.WHITE).sound(SoundType.CALCITE).noCollision().instabreak().lightLevel((block) -> {
        if (block.getValue(ChalkDustBlock.GLOW)) {
            return 7;
        }
        return 0;
    }).emissiveRendering((blockState, blockGetter, blockPos) -> {
        return blockState.getValue(ChalkDustBlock.GLOW);
    })));
    public static final Supplier<Block> BLEACHED_CHALK = registerBlockWithItem("bleached_chalk", registryName -> new Block(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(0.9f)));
    public static final Supplier<Block> BLEACHED_BED = registerBlock("bleached_bed", registryName -> bed(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), DyeColor.WHITE));


    //GYPSUM
    public static final Supplier<Block> GYPSUM = registerBlockWithItem("gypsum", registryName -> new Block(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).instrument(NoteBlockInstrument.HARP).requiresCorrectToolForDrops().strength(1.75F, 5F)));
    public static final Supplier<Block> GYPSUM_SLAB = registerBlockWithItem("gypsum_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(GYPSUM.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> GYPSUM_WALL = registerBlockWithItem("gypsum_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(GYPSUM.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> GYPSUM_STAIRS = registerBlockWithItem("gypsum_stairs", registryName -> new CommonStairBlock(GYPSUM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(GYPSUM.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> GYPSUM_BRICKS = registerBlockWithItem("gypsum_bricks", registryName -> new Block(BlockBehaviour.Properties.ofFullCopy(GYPSUM.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> GYPSUM_BRICK_SLAB = registerBlockWithItem("gypsum_brick_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(GYPSUM_BRICKS.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> GYPSUM_BRICK_WALL = registerBlockWithItem("gypsum_brick_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(GYPSUM_BRICKS.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> GYPSUM_BRICK_STAIRS = registerBlockWithItem("gypsum_brick_stairs", registryName -> new CommonStairBlock(GYPSUM_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(GYPSUM_BRICKS.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> POLISHED_GYPSUM = registerBlockWithItem("polished_gypsum", registryName -> new Block(BlockBehaviour.Properties.ofFullCopy(GYPSUM.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> POLISHED_GYPSUM_SLAB = registerBlockWithItem("polished_gypsum_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_GYPSUM.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> POLISHED_GYPSUM_WALL = registerBlockWithItem("polished_gypsum_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_GYPSUM.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> POLISHED_GYPSUM_STAIRS = registerBlockWithItem("polished_gypsum_stairs", registryName -> new CommonStairBlock(POLISHED_GYPSUM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(POLISHED_GYPSUM.get()).setId(JinxedRegistryHelper.blockKey(registryName))));

    //NORMAL TERRACOTTA SHINGLES
    public static final Supplier<Block> TERRACOTTA_SHINGLES = registerBlockWithItem("terracotta_shingles", registryName -> new Block(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25f, 4.2f)));
    public static final Supplier<Block> TERRACOTTA_SHINGLE_SLAB = registerBlockWithItem("terracotta_shingle_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(TERRACOTTA_SHINGLES.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> TERRACOTTA_SHINGLE_WALL = registerBlockWithItem("terracotta_shingle_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(TERRACOTTA_SHINGLES.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> TERRACOTTA_SHINGLE_STAIRS = registerBlockWithItem("terracotta_shingle_stairs", registryName -> new CommonStairBlock(TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(TERRACOTTA_SHINGLES.get()).setId(JinxedRegistryHelper.blockKey(registryName))));


    //SOAPSTONE
    public static final Supplier<Block> SOAPSTONE = registerBlockWithItem("soapstone", registryName -> new Block(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F)));
    public static final Supplier<Block> SOAPSTONE_SLAB = registerBlockWithItem("soapstone_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SOAPSTONE.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> SOAPSTONE_WALL = registerBlockWithItem("soapstone_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SOAPSTONE.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> SOAPSTONE_STAIRS = registerBlockWithItem("soapstone_stairs", registryName -> new CommonStairBlock(SOAPSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SOAPSTONE.get()).setId(JinxedRegistryHelper.blockKey(registryName))));

    public static final Supplier<Block> SOAPSTONE_BRICKS = registerBlockWithItem("soapstone_bricks", registryName -> new Block(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F)));
    public static final Supplier<Block> SOAPSTONE_BRICK_SLAB = registerBlockWithItem("soapstone_brick_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SOAPSTONE_BRICKS.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> SOAPSTONE_BRICK_WALL = registerBlockWithItem("soapstone_brick_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SOAPSTONE_BRICKS.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> SOAPSTONE_BRICK_STAIRS = registerBlockWithItem("soapstone_brick_stairs", registryName -> new CommonStairBlock(SOAPSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SOAPSTONE_BRICKS.get()).setId(JinxedRegistryHelper.blockKey(registryName))));

    public static final Supplier<Block> POLISHED_SOAPSTONE = registerBlockWithItem("polished_soapstone", registryName -> new Block(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F)));
    public static final Supplier<Block> POLISHED_SOAPSTONE_SLAB = registerBlockWithItem("polished_soapstone_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_SOAPSTONE.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> POLISHED_SOAPSTONE_WALL = registerBlockWithItem("polished_soapstone_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_SOAPSTONE.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> POLISHED_SOAPSTONE_STAIRS = registerBlockWithItem("polished_soapstone_stairs", registryName -> new CommonStairBlock(POLISHED_SOAPSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SOAPSTONE.get()).setId(JinxedRegistryHelper.blockKey(registryName))));

    //CORK
    public static final Supplier<Block> CORK_TRAPDOOR = registerBlockWithItem("cork_trapdoor", registryName -> new ACTrapDoorBlock(CORK_SET, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().isValidSpawn(ACBlocks::never).ignitedByLava()));
    public static final Supplier<Block> CORK_DOOR = registerBlockWithItem("cork_door", registryName -> new CommonDoorBlock(CORK_SET, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> CORK_SIGN = registerBlock("cork_sign", registryName -> new StandingSignBlock(ACWoodType.CORK, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0f).ignitedByLava()));
    public static final Supplier<Block> CORK_WALL_SIGN = registerBlock("cork_wall_sign", registryName -> new WallSignBlock(ACWoodType.CORK, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0f).ignitedByLava()));
    public static final Supplier<Block> CORK_HANGING_SIGN = registerBlock("cork_hanging_sign", registryName -> new CeilingHangingSignBlock(ACWoodType.CORK, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.TERRACOTTA_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0f).ignitedByLava()));
    public static final Supplier<Block> CORK_WALL_HANGING_SIGN = registerBlock("cork_wall_hanging_sign", registryName -> new WallHangingSignBlock(ACWoodType.CORK, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.TERRACOTTA_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0f).ignitedByLava()));
    public static final Supplier<Block> CORK_PRESSURE_PLATE = registerBlockWithItem("cork_pressure_plate", registryName -> new CommonPressurePlateBlock(CORK_SET, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollision().strength(0.5f).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> CORK_BUTTON = registerBlockWithItem("cork_button", registryName -> new CommonButtonBlock(CORK_SET, 30, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).noCollision().strength(0.5f).pushReaction(PushReaction.DESTROY)));

    //CORK ETC
    public static final Supplier<Block> CORK = registerBlockWithItem("cork", registryName -> new FloatingBlock(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.COLOR_BROWN).strength(2.0F).sound(ACSoundTypes.CORK).instrument(NoteBlockInstrument.BASS)));
    public static final Supplier<Block> SMOOTH_CORK = registerBlockWithItem("smooth_cork", registryName -> new FloatingBlock(BlockBehaviour.Properties.ofFullCopy(CORK.get()).setId(JinxedRegistryHelper.blockKey(registryName))));
    public static final Supplier<Block> CORK_SAPLING = registerBlockWithItem("cork_sapling", registryName -> new ACSaplingBlock(ACTreeGrower.CORK, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.PLANT).noCollision().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));


    public static final Supplier<Block> CORK_LOG = registerBlockWithItem("cork_log", registryName -> corkLog(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));

    public static final Supplier<Block> STRIPPED_CORK_LOG = registerBlockWithItem("stripped_cork_log", registryName -> corkLog(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));

    public static final Supplier<Block> CORK_WOOD = registerBlockWithItem("cork_wood", registryName -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(ACSoundTypes.CORK).ignitedByLava()));

    public static final Supplier<Block> STRIPPED_CORK_WOOD = registerBlockWithItem("stripped_cork_wood", registryName -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(ACSoundTypes.CORK).ignitedByLava()));

    public static final Supplier<Block> CORK_PLANKS = registerBlockWithItem("cork_planks", registryName -> new FlammablePlankBlock(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));
    public static final Supplier<Block> CORK_SLAB = registerBlockWithItem("cork_slab", registryName -> new FlammableSlabBlock(BlockBehaviour.Properties.ofFullCopy(CORK_PLANKS.get()).setId(JinxedRegistryHelper.blockKey(registryName)).sound(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_STAIRS = registerBlockWithItem("cork_stairs", registryName -> new FlammableStairBlock(CORK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(CORK_PLANKS.get()).setId(JinxedRegistryHelper.blockKey(registryName)).sound(ACSoundTypes.CORK)));
    public static final Supplier<Block> CORK_FENCE = registerBlockWithItem("cork_fence", registryName -> new FlammableFenceBlock(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));
    public static final Supplier<Block> CORK_FENCE_GATE = registerBlockWithItem("cork_fence_gate", registryName -> new FlammableFenceGateBlock(ACWoodType.CORK, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).sound(ACSoundTypes.CORK).strength(2.0f, 3.0f).ignitedByLava()));
    public static final Supplier<Block> CORK_LEAVES = registerBlockWithItem("cork_leaves", registryName -> leaves(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), SoundType.GRASS));

    public static final Supplier<Block> POTTED_CORK_SAPLING = registerBlock("potted_cork_sapling", registryName -> ACBlocks.vanillaFlowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), CORK_SAPLING.get(), new FeatureFlag[0]));


    public static final Supplier<Block> PLASTER = registerBlockWithItem("plaster", registryName -> new PlasterBlock(null, BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).strength(1.25F, 1F).sound(SoundType.PACKED_MUD).instrument(NoteBlockInstrument.BASEDRUM)));


    static {
        CHALK_DUST.put(-1, BLEACHED_CHALK_DUST);
        CHALK.put(-1, BLEACHED_CHALK);
        for (DyeColor colours : DyeColor.values()) {
            //DYED PLASTER
            DYED_PLASTER.put(colours, registerBlockWithItem(colours + "_plaster", registryName -> new PlasterBlock(colours, BlockBehaviour.Properties.ofFullCopy(PLASTER.get()).setId(JinxedRegistryHelper.blockKey(registryName)))));

            //DYED MUD BRICKS
            DYED_MUD_BRICKS.put(colours, registerBlockWithItem(colours + "_mud_bricks", registryName -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colours))));
            DYED_MUD_BRICK_SLAB.put(colours, registerBlockWithItem(colours + "_mud_brick_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICK_SLAB).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colours))));
            DYED_MUD_BRICK_WALL.put(colours, registerBlockWithItem(colours + "_mud_brick_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICK_WALL).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colours))));
            DYED_MUD_BRICK_STAIRS.put(colours, registerBlockWithItem(colours + "_mud_brick_stairs", registryName -> new CommonStairBlock(getDyedMudBricks(colours.getId()).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICK_SLAB).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colours))));

            //DYED TERRACOTTA SHINGLES
            DYED_TERRACOTTA_SHINGLES.put(colours, registerBlockWithItem(colours + "_terracotta_shingles", registryName -> new Block(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25f, 4.2f))));
            DYED_TERRACOTTA_SHINGLE_SLAB.put(colours, registerBlockWithItem(colours + "_terracotta_shingle_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(getDyedTerracottaShingles(colours.getId())).setId(JinxedRegistryHelper.blockKey(registryName)))));
            DYED_TERRACOTTA_SHINGLE_WALL.put(colours, registerBlockWithItem(colours + "_terracotta_shingle_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(getDyedTerracottaShingles(colours.getId())).setId(JinxedRegistryHelper.blockKey(registryName)))));
            DYED_TERRACOTTA_SHINGLE_STAIRS.put(colours, registerBlockWithItem(colours + "_terracotta_shingle_stairs", registryName -> new CommonStairBlock(getDyedTerracottaShingles(colours.getId()).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(getDyedTerracottaShingles(colours.getId())).setId(JinxedRegistryHelper.blockKey(registryName)))));

            //DYED SOAPSTONE
            DYED_SOAPSTONE.put(colours, registerBlockWithItem(colours + "_soapstone", registryName -> new Block(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colours).sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F))));
            DYED_SOAPSTONE_SLAB.put(colours, registerBlockWithItem(colours + "_soapstone_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(getDyedSoapstone(colours.getId())).setId(JinxedRegistryHelper.blockKey(registryName)))));
            DYED_SOAPSTONE_WALL.put(colours, registerBlockWithItem(colours + "_soapstone_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(getDyedSoapstone(colours.getId())).setId(JinxedRegistryHelper.blockKey(registryName)))));
            DYED_SOAPSTONE_STAIRS.put(colours, registerBlockWithItem(colours + "_soapstone_stairs", registryName -> new CommonStairBlock(getDyedSoapstone(colours.getId()).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(getDyedSoapstone(colours.getId())).setId(JinxedRegistryHelper.blockKey(registryName)))));

            DYED_SOAPSTONE_BRICKS.put(colours, registerBlockWithItem(colours + "_soapstone_bricks", registryName -> new Block(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colours).sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F))));
            DYED_SOAPSTONE_BRICK_SLAB.put(colours, registerBlockWithItem(colours + "_soapstone_brick_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(getDyedSoapstone(colours.getId())).setId(JinxedRegistryHelper.blockKey(registryName)))));
            DYED_SOAPSTONE_BRICK_WALL.put(colours, registerBlockWithItem(colours + "_soapstone_brick_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(getDyedSoapstone(colours.getId())).setId(JinxedRegistryHelper.blockKey(registryName)))));
            DYED_SOAPSTONE_BRICK_STAIRS.put(colours, registerBlockWithItem(colours + "_soapstone_brick_stairs", registryName -> new CommonStairBlock(getDyedSoapstone(colours.getId()).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(getDyedSoapstone(colours.getId())).setId(JinxedRegistryHelper.blockKey(registryName)))));

            DYED_POLISHED_SOAPSTONE.put(colours, registerBlockWithItem(colours + "_polished_soapstone", registryName -> new Block(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colours).sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F))));
            DYED_POLISHED_SOAPSTONE_SLAB.put(colours, registerBlockWithItem(colours + "_polished_soapstone_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(getDyedPolishedSoapstone(colours.getId())).setId(JinxedRegistryHelper.blockKey(registryName)))));
            DYED_POLISHED_SOAPSTONE_WALL.put(colours, registerBlockWithItem(colours + "_polished_soapstone_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(getDyedPolishedSoapstone(colours.getId())).setId(JinxedRegistryHelper.blockKey(registryName)))));
            DYED_POLISHED_SOAPSTONE_STAIRS.put(colours, registerBlockWithItem(colours + "_polished_soapstone_stairs", registryName -> new CommonStairBlock(getDyedPolishedSoapstone(colours.getId()).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(getDyedPolishedSoapstone(colours.getId())).setId(JinxedRegistryHelper.blockKey(registryName)))));

            //CHALK
            CHALK.put(colours.getId(), registerBlockWithItem(colours + "_chalk", registryName -> new Block(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(0.9f))));

            CHALK_DUST.put(colours.getId(), registerBlock(colours + "_chalk_dust", registryName -> new ChalkDustBlock(colours.getId(), BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colours).sound(SoundType.CALCITE).noCollision().instabreak().lightLevel((block) -> {
                if (block.getValue(ChalkDustBlock.GLOW)) {
                    return 7;
                }
                return 0;
            }).emissiveRendering((blockState, blockGetter, blockPos) -> {
                return blockState.getValue(ChalkDustBlock.GLOW);
            }))));


            DYED_FLOWER_POTS.put(colours, registerBlock(colours + "_flower_pot", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.AIR, colours)));

            //DYED SAPLING POTS
            DYED_OAK_SAPLING_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_oak_sapling", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.OAK_SAPLING, colours)));
            DYED_SPRUCE_SAPLING_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_spruce_sapling", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.SPRUCE_SAPLING, colours)));
            DYED_BIRCH_SAPLING_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_birch_sapling", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.BIRCH_SAPLING, colours)));
            DYED_JUNGLE_SAPLING_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_jungle_sapling", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.JUNGLE_SAPLING, colours)));
            DYED_ACACIA_SAPLING_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_acacia_sapling", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.ACACIA_SAPLING, colours)));
            DYED_CHERRY_SAPLING_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_cherry_sapling", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.CHERRY_SAPLING, colours)));
            DYED_DARK_OAK_SAPLING_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_dark_oak_sapling", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.DARK_OAK_SAPLING, colours)));
            DYED_MANGROVE_PROPAGULE_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_mangrove_propagule", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.MANGROVE_PROPAGULE, colours)));
            DYED_CORK_SAPLING_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_cork_sapling", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), ACBlocks.CORK_SAPLING.get(), colours)));

            //DYED FUNGUS POTS
            DYED_CRIMSON_FUNGUS_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_crimson_fungus", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.CRIMSON_FUNGUS, colours)));
            DYED_WARPED_FUNGUS_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_warped_fungus", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.WARPED_FUNGUS, colours)));

            //DYED ROOTS POTS
            DYED_CRIMSON_ROOTS_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_crimson_roots", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.CRIMSON_ROOTS, colours)));
            DYED_WARPED_ROOTS_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_warped_roots", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.WARPED_ROOTS, colours)));

            //DYED FLOWER POTS
            DYED_FERN_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_fern", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.FERN, colours)));
            DYED_DANDELION_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_dandelion", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.DANDELION, colours)));
            DYED_POPPY_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_poppy", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.POPPY, colours)));
            DYED_BLUE_ORCHID_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_blue_orchid", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.BLUE_ORCHID, colours)));
            DYED_ALLIUM_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_allium", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.ALLIUM, colours)));
            DYED_AZURE_BLUET_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_azure_bluet", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.AZURE_BLUET, colours)));
            DYED_RED_TULIP_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_red_tulip", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.RED_TULIP, colours)));
            DYED_ORANGE_TULIP_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_orange_tulip", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.ORANGE_TULIP, colours)));
            DYED_WHITE_TULIP_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_white_tulip", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.WHITE_TULIP, colours)));
            DYED_PINK_TULIP_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_pink_tulip", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.PINK_TULIP, colours)));
            DYED_OXEYE_DAISY_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_oxeye_daisy", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.OXEYE_DAISY, colours)));
            DYED_CORNFLOWER_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_cornflower", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.CORNFLOWER, colours)));
            DYED_LILY_OF_THE_VALLEY_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_lily_of_the_valley", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.LILY_OF_THE_VALLEY, colours)));
            DYED_WITHER_ROSE_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_wither_rose", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.WITHER_ROSE, colours)));
            DYED_RED_MUSHROOM_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_red_mushroom", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.RED_MUSHROOM, colours)));
            DYED_BROWN_MUSHROOM_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_brown_mushroom", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.BROWN_MUSHROOM, colours)));
            DYED_DEAD_BUSH_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_dead_bush", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.DEAD_BUSH, colours)));
            DYED_CACTUS_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_cactus", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.CACTUS, colours)));
            DYED_BAMBOO_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_bamboo", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.BAMBOO, colours)));
            DYED_AZALEA_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_azalea_bush", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.AZALEA, colours)));
            DYED_FLOWERING_AZALEA_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_flowering_azalea_bush", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.FLOWERING_AZALEA, colours)));
            DYED_TORCHFLOWER_FLOWER_POTS.put(colours, registerBlock(colours + "_potted_torchflower", registryName -> ACBlocks.flowerPot(BlockBehaviour.Properties.of().setId(JinxedRegistryHelper.blockKey(registryName)), Blocks.TORCHFLOWER, colours)));

            if (colours.getId() <= 15) {
                DYED_DECORATED_POTS.put(colours, registerBlock(colours + "_decorated_pot", registryName -> new DyedDecoratedPotBlock(colours, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT).setId(JinxedRegistryHelper.blockKey(registryName)))));
            }
        }
        for (PietraforteColour colour : PietraforteColour.values()) {
            COBBLED_PIETRAFORTE.put(colour, registerBlockWithItem("cobbled_" + colour + "_pietraforte", registryName -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));
            COBBLED_PIETRAFORTE_STAIRS.put(colour, registerBlockWithItem("cobbled_" + colour + "_pietraforte_stairs", registryName -> new CommonStairBlock(getCobbledPietraforte(colour).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));
            COBBLED_PIETRAFORTE_SLAB.put(colour, registerBlockWithItem("cobbled_" + colour + "_pietraforte_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));
            COBBLED_PIETRAFORTE_WALL.put(colour, registerBlockWithItem("cobbled_" + colour + "_pietraforte_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));

            PIETRAFORTE.put(colour, registerBlockWithItem(colour + "_pietraforte", registryName -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));
            PIETRAFORTE_STAIRS.put(colour, registerBlockWithItem(colour + "_pietraforte_stairs", registryName -> new CommonStairBlock(getPietraforte(colour).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));
            PIETRAFORTE_SLAB.put(colour, registerBlockWithItem(colour + "_pietraforte_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));
            PIETRAFORTE_WALL.put(colour, registerBlockWithItem(colour + "_pietraforte_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));

            CHISELED_PIETRAFORTE.put(colour, registerBlockWithItem("chiseled_" + colour + "_pietraforte", registryName -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_DEEPSLATE).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));

            PIETRAFORTE_BRICKS.put(colour, registerBlockWithItem(colour + "_pietraforte_bricks", registryName -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));
            PIETRAFORTE_BRICK_STAIRS.put(colour, registerBlockWithItem(colour + "_pietraforte_brick_stairs", registryName -> new CommonStairBlock(getPietraforteBricks(colour).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));
            PIETRAFORTE_BRICK_SLAB.put(colour, registerBlockWithItem(colour + "_pietraforte_brick_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));
            PIETRAFORTE_BRICK_WALL.put(colour, registerBlockWithItem(colour + "_pietraforte_brick_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));

            PIETRAFORTE_PILLAR.put(colour, registerBlockWithItem(colour + "_pietraforte_pillar", registryName -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));

            SMOOTH_PIETRAFORTE.put(colour, registerBlockWithItem("smooth_" + colour + "_pietraforte", registryName -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));
            SMOOTH_PIETRAFORTE_STAIRS.put(colour, registerBlockWithItem("smooth_" +colour + "_pietraforte_stairs", registryName -> new CommonStairBlock(getSmoothPietraforte(colour).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));
            SMOOTH_PIETRAFORTE_SLAB.put(colour, registerBlockWithItem("smooth_" +colour + "_pietraforte_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));
            SMOOTH_PIETRAFORTE_WALL.put(colour, registerBlockWithItem("smooth_" +colour + "_pietraforte_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));

            CUT_PIETRAFORTE.put(colour, registerBlockWithItem("cut_" + colour + "_pietraforte", registryName -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));
            CUT_PIETRAFORTE_STAIRS.put(colour, registerBlockWithItem("cut_" +colour + "_pietraforte_stairs", registryName -> new CommonStairBlock(getCutPietraforte(colour).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));
            CUT_PIETRAFORTE_SLAB.put(colour, registerBlockWithItem("cut_" +colour + "_pietraforte_slab", registryName -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));
            CUT_PIETRAFORTE_WALL.put(colour, registerBlockWithItem("cut_" +colour + "_pietraforte_wall", registryName -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).setId(JinxedRegistryHelper.blockKey(registryName)).mapColor(colour.getMapColor()))));

        }
    }

    //GET METHODS
    public static Block getCobbledPietraforte(PietraforteColour colour) {
        return COBBLED_PIETRAFORTE.get(colour).get();
    }

    public static Block getCobbledPietraforteStairs(PietraforteColour colour) {
        return COBBLED_PIETRAFORTE_STAIRS.get(colour).get();
    }

    public static Block getCobbledPietraforteSlab(PietraforteColour colour) {
        return COBBLED_PIETRAFORTE_SLAB.get(colour).get();
    }

    public static Block getCobbledPietraforteWall(PietraforteColour colour) {
        return COBBLED_PIETRAFORTE_WALL.get(colour).get();
    }

    public static Block getPietraforte(PietraforteColour colour) {
        return PIETRAFORTE.get(colour).get();
    }

    public static Block getPietraforteStairs(PietraforteColour colour) {
        return PIETRAFORTE_STAIRS.get(colour).get();
    }

    public static Block getPietraforteSlab(PietraforteColour colour) {
        return PIETRAFORTE_SLAB.get(colour).get();
    }

    public static Block getPietraforteWall(PietraforteColour colour) {
        return PIETRAFORTE_WALL.get(colour).get();
    }

    public static Block getChiseledPietraforte(PietraforteColour colour) {
        return CHISELED_PIETRAFORTE.get(colour).get();
    }

    public static Block getPietraforteBricks(PietraforteColour colour) {
        return PIETRAFORTE_BRICKS.get(colour).get();
    }

    public static Block getPietraforteBrickStairs(PietraforteColour colour) {
        return PIETRAFORTE_BRICK_STAIRS.get(colour).get();
    }

    public static Block getPietraforteBrickSlab(PietraforteColour colour) {
        return PIETRAFORTE_BRICK_SLAB.get(colour).get();
    }

    public static Block getPietraforteBrickWall(PietraforteColour colour) {
        return PIETRAFORTE_BRICK_WALL.get(colour).get();
    }

    public static Block getPietrafortePillar(PietraforteColour colour) {
        return PIETRAFORTE_PILLAR.get(colour).get();
    }

    public static Block getSmoothPietraforte(PietraforteColour colour) {
        return SMOOTH_PIETRAFORTE.get(colour).get();
    }

    public static Block getSmoothPietraforteStairs(PietraforteColour colour) {
        return SMOOTH_PIETRAFORTE_STAIRS.get(colour).get();
    }

    public static Block getSmoothPietraforteSlab(PietraforteColour colour) {
        return SMOOTH_PIETRAFORTE_SLAB.get(colour).get();
    }

    public static Block getSmoothPietraforteWall(PietraforteColour colour) {
        return SMOOTH_PIETRAFORTE_WALL.get(colour).get();
    }

    public static Block getCutPietraforte(PietraforteColour colour) {
        return CUT_PIETRAFORTE.get(colour).get();
    }

    public static Block getCutPietraforteStairs(PietraforteColour colour) {
        return CUT_PIETRAFORTE_STAIRS.get(colour).get();
    }

    public static Block getCutPietraforteSlab(PietraforteColour colour) {
        return CUT_PIETRAFORTE_SLAB.get(colour).get();
    }

    public static Block getCutPietraforteWall(PietraforteColour colour) {
        return CUT_PIETRAFORTE_WALL.get(colour).get();
    }

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



    private static Supplier<Block> registerBlock(String name, Function<Identifier, ? extends Block> function) {
        return JinxedRegistryHelper.registerBlock(ArtsAndCrafts.MOD_ID, name, false, function);
    }

    private static Supplier<Block> registerBlockWithItem(String name, Function<Identifier, ? extends Block> function) {
        return JinxedRegistryHelper.registerBlock(ArtsAndCrafts.MOD_ID, name, true, function);
    }

    private static FlammableRotatedPillarBlock corkLog(BlockBehaviour.Properties properties, MapColor mapColor, MapColor mapColor2) {
        return new FlammableRotatedPillarBlock(properties.mapColor(blockState -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? mapColor : mapColor2).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(ACSoundTypes.CORK).ignitedByLava());
    }

    private static ACLeavesBlock leaves(BlockBehaviour.Properties properties, SoundType soundType) {
        return new ACLeavesBlock(0.2F, properties.mapColor(MapColor.PLANT).strength(0.2f).randomTicks().sound(soundType).noOcclusion().isValidSpawn(ACBlocks::ocelotOrParrot).isSuffocating(ACBlocks::never).isViewBlocking(ACBlocks::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(ACBlocks::never));
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

    private static FlowerPotBlock vanillaFlowerPot(BlockBehaviour.Properties properties, Block block, FeatureFlag... featureFlags) {
        BlockBehaviour.Properties properties1 = properties.instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        if (featureFlags.length > 0) {
            properties1 = properties1.requiredFeatures(featureFlags);
        }
        return new FlowerPotBlock(block, properties1);
    }

    private static ACFlowerPotBlock flowerPot(BlockBehaviour.Properties properties, Block block, DyeColor dyeColor) {
        BlockBehaviour.Properties properties1 = properties.instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        return new ACFlowerPotBlock(block, dyeColor, properties1);
    }

    private static ACBedBlock bed(BlockBehaviour.Properties properties, DyeColor $$0) {
        return new ACBedBlock($$0, properties.mapColor(($$1) -> {
            return $$1.getValue(ACBedBlock.PART) == BedPart.FOOT ? $$0.getMapColor() : MapColor.WOOL;
        }).sound(SoundType.WOOD).strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    }

    public static void register() {
    }

}
