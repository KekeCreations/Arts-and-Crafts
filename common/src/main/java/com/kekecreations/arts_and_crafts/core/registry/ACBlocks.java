package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.block.*;
import com.kekecreations.arts_and_crafts.common.util.PietraforteColour;
import com.kekecreations.arts_and_crafts.core.init.ACWoodType;
import com.kekecreations.arts_and_crafts.core.platform.Services;
import com.kekecreations.jinxedlib.common.block.*;
import com.kekecreations.jinxedlib.core.util.JinxedRegistryHelper;
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
import static com.kekecreations.arts_and_crafts.core.init.ACBlockSetType.*;

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


    //public static final Supplier<Block> CRIMSON_HANGING_FLOWER_POT = registerBlockWithItem("crimson_hanging_flower_pot", () -> new HangingFlowerPot(BlockBehaviour.Properties.of().sound(SoundType.CHAIN)));

    public static final HashMap<PietraforteColour, Supplier<Block>> COBBLED_PIETRAFORTE = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<StairBlock>> COBBLED_PIETRAFORTE_STAIRS = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<SlabBlock>> COBBLED_PIETRAFORTE_SLAB = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<WallBlock>> COBBLED_PIETRAFORTE_WALL = new HashMap<>();

    public static final HashMap<PietraforteColour, Supplier<Block>> PIETRAFORTE = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<StairBlock>> PIETRAFORTE_STAIRS = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<SlabBlock>> PIETRAFORTE_SLAB = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<WallBlock>> PIETRAFORTE_WALL = new HashMap<>();

    public static final HashMap<PietraforteColour, Supplier<Block>> CHISELED_PIETRAFORTE = new HashMap<>();

    public static final HashMap<PietraforteColour, Supplier<Block>> PIETRAFORTE_BRICKS = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<StairBlock>> PIETRAFORTE_BRICK_STAIRS = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<SlabBlock>> PIETRAFORTE_BRICK_SLAB = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<WallBlock>> PIETRAFORTE_BRICK_WALL = new HashMap<>();

    public static final HashMap<PietraforteColour, Supplier<RotatedPillarBlock>> PIETRAFORTE_PILLAR = new HashMap<>();

    public static final HashMap<PietraforteColour, Supplier<Block>> SMOOTH_PIETRAFORTE = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<StairBlock>> SMOOTH_PIETRAFORTE_STAIRS = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<SlabBlock>> SMOOTH_PIETRAFORTE_SLAB = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<WallBlock>> SMOOTH_PIETRAFORTE_WALL = new HashMap<>();

    public static final HashMap<PietraforteColour, Supplier<Block>> CUT_PIETRAFORTE = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<StairBlock>> CUT_PIETRAFORTE_STAIRS = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<SlabBlock>> CUT_PIETRAFORTE_SLAB = new HashMap<>();
    public static final HashMap<PietraforteColour, Supplier<WallBlock>> CUT_PIETRAFORTE_WALL = new HashMap<>();


    public static final Supplier<Block> LOTUS_FLOWER = registerBlock("lotus_flower", () -> new LotusFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LILY_PAD).randomTicks().lightLevel(($$0x) -> {
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

    //DISABLED BLOCKS
    public static final Supplier<Block> CRIMSON_ROOTS_PLANT = registerBlock("crimson_roots_plant", () -> new DisabledBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<Block> WARPED_ROOTS_PLANT = registerBlock("warped_roots_plant", () -> new DisabledBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<Block> CACTUS_PLANT = registerBlock("cactus_plant", () -> new DisabledBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<Block> BAMBOO_PLANT = registerBlock("bamboo_plant", () -> new DisabledBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<Block> AZALEA_PLANT = registerBlock("azalea_plant", () -> new DisabledBlock(BlockBehaviour.Properties.of()));
    public static final Supplier<Block> FLOWERING_AZALEA_PLANT = registerBlock("flowering_azalea_plant", () -> new DisabledBlock(BlockBehaviour.Properties.of()));

    //BLEACHED
    public static final Supplier<Block> GLAZED_TERRACOTTA = registerBlockWithItem("glazed_terracotta", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).pushReaction(PushReaction.PUSH_ONLY)));
    public static final Supplier<Block> BLEACHED_WOOL = registerBlockWithItem("bleached_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> BLEACHED_CONCRETE = registerBlockWithItem("bleached_concrete", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> BLEACHED_CONCRETE_POWDER = registerBlockWithItem("bleached_concrete_powder", () -> new ConcretePowderBlock(BLEACHED_CONCRETE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE_POWDER)));
    public static final Supplier<Block> BLEACHED_CARPET = registerBlockWithItem("bleached_carpet", () -> new CarpetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CARPET)));
    public static final Supplier<Block> BLEACHED_CHALK_DUST = registerBlock("bleached_chalk_dust", () -> new ChalkDustBlock(-1, BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).sound(SoundType.CALCITE).noCollission().instabreak().lightLevel((block) -> {
        if (block.getValue(ChalkDustBlock.GLOW)) {
            return 7;
        }
        return 0;
    }).emissiveRendering((blockState, blockGetter, blockPos) -> {
        return blockState.getValue(ChalkDustBlock.GLOW);
    })));
    public static final Supplier<Block> BLEACHED_CHALK = registerBlockWithItem("bleached_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(0.9f)));
    public static final Supplier<Block> BLEACHED_BED = registerBlock("bleached_bed", () -> bed(DyeColor.WHITE));


    //GYPSUM
    public static final Supplier<Block> GYPSUM = registerBlockWithItem("gypsum", () -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HARP).requiresCorrectToolForDrops().strength(1.75F, 5F)));
    public static final Supplier<SlabBlock> GYPSUM_SLAB = registerBlockWithItem("gypsum_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(GYPSUM.get())));
    public static final Supplier<WallBlock> GYPSUM_WALL = registerBlockWithItem("gypsum_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(GYPSUM.get())));
    public static final Supplier<CommonStairBlock> GYPSUM_STAIRS = registerBlockWithItem("gypsum_stairs", () -> new CommonStairBlock(GYPSUM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(GYPSUM.get())));
    public static final Supplier<Block> GYPSUM_BRICKS = registerBlockWithItem("gypsum_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(GYPSUM.get())));
    public static final Supplier<SlabBlock> GYPSUM_BRICK_SLAB = registerBlockWithItem("gypsum_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(GYPSUM_BRICKS.get())));
    public static final Supplier<WallBlock> GYPSUM_BRICK_WALL = registerBlockWithItem("gypsum_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(GYPSUM_BRICKS.get())));
    public static final Supplier<CommonStairBlock> GYPSUM_BRICK_STAIRS = registerBlockWithItem("gypsum_brick_stairs", () -> new CommonStairBlock(GYPSUM_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(GYPSUM_BRICKS.get())));
    public static final Supplier<Block> POLISHED_GYPSUM = registerBlockWithItem("polished_gypsum", () -> new Block(BlockBehaviour.Properties.ofFullCopy(GYPSUM.get())));
    public static final Supplier<SlabBlock> POLISHED_GYPSUM_SLAB = registerBlockWithItem("polished_gypsum_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_GYPSUM.get())));
    public static final Supplier<WallBlock> POLISHED_GYPSUM_WALL = registerBlockWithItem("polished_gypsum_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_GYPSUM.get())));
    public static final Supplier<CommonStairBlock> POLISHED_GYPSUM_STAIRS = registerBlockWithItem("polished_gypsum_stairs", () -> new CommonStairBlock(POLISHED_GYPSUM.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(POLISHED_GYPSUM.get())));

    //NORMAL TERRACOTTA SHINGLES
    public static final Supplier<Block> TERRACOTTA_SHINGLES = registerBlockWithItem("terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25f, 4.2f)));
    public static final Supplier<SlabBlock> TERRACOTTA_SHINGLE_SLAB = registerBlockWithItem("terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(TERRACOTTA_SHINGLES.get())));
    public static final Supplier<WallBlock> TERRACOTTA_SHINGLE_WALL = registerBlockWithItem("terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(TERRACOTTA_SHINGLES.get())));
    public static final Supplier<CommonStairBlock> TERRACOTTA_SHINGLE_STAIRS = registerBlockWithItem("terracotta_shingle_stairs", () -> new CommonStairBlock(TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(TERRACOTTA_SHINGLES.get())));


    //SOAPSTONE
    public static final Supplier<Block> SOAPSTONE = registerBlockWithItem("soapstone", () -> new Block(BlockBehaviour.Properties.of().sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F)));
    public static final Supplier<SlabBlock> SOAPSTONE_SLAB = registerBlockWithItem("soapstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SOAPSTONE.get())));
    public static final Supplier<WallBlock> SOAPSTONE_WALL = registerBlockWithItem("soapstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SOAPSTONE.get())));
    public static final Supplier<CommonStairBlock> SOAPSTONE_STAIRS = registerBlockWithItem("soapstone_stairs", () -> new CommonStairBlock(SOAPSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SOAPSTONE.get())));

    public static final Supplier<Block> SOAPSTONE_BRICKS = registerBlockWithItem("soapstone_bricks", () -> new Block(BlockBehaviour.Properties.of().sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F)));
    public static final Supplier<SlabBlock> SOAPSTONE_BRICK_SLAB = registerBlockWithItem("soapstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SOAPSTONE_BRICKS.get())));
    public static final Supplier<WallBlock> SOAPSTONE_BRICK_WALL = registerBlockWithItem("soapstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SOAPSTONE_BRICKS.get())));
    public static final Supplier<CommonStairBlock> SOAPSTONE_BRICK_STAIRS = registerBlockWithItem("soapstone_brick_stairs", () -> new CommonStairBlock(SOAPSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SOAPSTONE_BRICKS.get())));

    public static final Supplier<Block> POLISHED_SOAPSTONE = registerBlockWithItem("polished_soapstone", () -> new Block(BlockBehaviour.Properties.of().sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F)));
    public static final Supplier<SlabBlock> POLISHED_SOAPSTONE_SLAB = registerBlockWithItem("polished_soapstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_SOAPSTONE.get())));
    public static final Supplier<WallBlock> POLISHED_SOAPSTONE_WALL = registerBlockWithItem("polished_soapstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_SOAPSTONE.get())));
    public static final Supplier<CommonStairBlock> POLISHED_SOAPSTONE_STAIRS = registerBlockWithItem("polished_soapstone_stairs", () -> new CommonStairBlock(POLISHED_SOAPSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SOAPSTONE.get())));

    //CORK
    public static final Supplier<ACTrapDoorBlock> CORK_TRAPDOOR = registerBlockWithItem("cork_trapdoor", () -> new ACTrapDoorBlock(CORK_SET, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().isValidSpawn(ACBlocks::never).ignitedByLava()));
    public static final Supplier<CommonDoorBlock> CORK_DOOR = registerBlockWithItem("cork_door", () -> new CommonDoorBlock(CORK_SET, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(3.0f).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<StandingSignBlock> CORK_SIGN = registerBlock("cork_sign", () -> new StandingSignBlock(ACWoodType.CORK, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0f).ignitedByLava()));
    public static final Supplier<WallSignBlock> CORK_WALL_SIGN = registerBlock("cork_wall_sign", () -> new WallSignBlock(ACWoodType.CORK, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0f).dropsLike(CORK_SIGN.get()).ignitedByLava()));
    public static final Supplier<CeilingHangingSignBlock> CORK_HANGING_SIGN = registerBlock("cork_hanging_sign", () -> new CeilingHangingSignBlock(ACWoodType.CORK, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0f).ignitedByLava()));
    public static final Supplier<WallHangingSignBlock> CORK_WALL_HANGING_SIGN = registerBlock("cork_wall_hanging_sign", () -> new WallHangingSignBlock(ACWoodType.CORK, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0f).ignitedByLava().dropsLike(CORK_HANGING_SIGN.get())));
    public static final Supplier<CommonPressurePlateBlock> CORK_PRESSURE_PLATE = registerBlockWithItem("cork_pressure_plate", () -> new CommonPressurePlateBlock(CORK_SET, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5f).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final Supplier<CommonButtonBlock> CORK_BUTTON = registerBlockWithItem("cork_button", () -> new CommonButtonBlock(CORK_SET, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5f).pushReaction(PushReaction.DESTROY)));

    //CORK ETC

    public static final Supplier<FloatingBlock> CORK = registerBlockWithItem("cork", () -> new FloatingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(2.0F).sound(ACSoundTypes.CORK).instrument(NoteBlockInstrument.BASS)));
    public static final Supplier<FloatingBlock> SMOOTH_CORK = registerBlockWithItem("smooth_cork", () -> new FloatingBlock(BlockBehaviour.Properties.ofFullCopy(CORK.get())));
    public static final Supplier<SaplingBlock> CORK_SAPLING = registerBlockWithItem("cork_sapling", () -> new ACSaplingBlock(ACTreeGrower.CORK, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));


    public static final Supplier<FlammableRotatedPillarBlock> CORK_LOG = registerBlockWithItem("cork_log", () -> corkLog(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));

    public static final Supplier<FlammableRotatedPillarBlock> STRIPPED_CORK_LOG = registerBlockWithItem("stripped_cork_log", () -> corkLog(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));

    public static final Supplier<FlammableRotatedPillarBlock> CORK_WOOD = registerBlockWithItem("cork_wood", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(ACSoundTypes.CORK).ignitedByLava()));

    public static final Supplier<FlammableRotatedPillarBlock> STRIPPED_CORK_WOOD = registerBlockWithItem("stripped_cork_wood", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(ACSoundTypes.CORK).ignitedByLava()));

    public static final Supplier<FlammablePlankBlock> CORK_PLANKS = registerBlockWithItem("cork_planks", () -> new FlammablePlankBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));
    public static final Supplier<FlammableSlabBlock> CORK_SLAB = registerBlockWithItem("cork_slab", () -> new FlammableSlabBlock(BlockBehaviour.Properties.ofFullCopy(CORK_PLANKS.get()).sound(ACSoundTypes.CORK)));
    public static final Supplier<FlammableStairBlock> CORK_STAIRS = registerBlockWithItem("cork_stairs", () -> new FlammableStairBlock(CORK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(CORK_PLANKS.get()).sound(ACSoundTypes.CORK)));
    public static final Supplier<FlammableFenceBlock> CORK_FENCE = registerBlockWithItem("cork_fence", () -> new FlammableFenceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(ACSoundTypes.CORK).ignitedByLava()));
    public static final Supplier<FlammableFenceGateBlock> CORK_FENCE_GATE = registerBlockWithItem("cork_fence_gate", () -> new FlammableFenceGateBlock(ACWoodType.CORK, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).sound(ACSoundTypes.CORK).strength(2.0f, 3.0f).ignitedByLava()));
    public static final Supplier<FlammableLeavesBlock> CORK_LEAVES = registerBlockWithItem("cork_leaves", () -> leaves(SoundType.GRASS));

    public static final Supplier<FlowerPotBlock> POTTED_CORK_SAPLING = registerBlock("potted_cork_sapling", () -> ACBlocks.vanillaFlowerPot(CORK_SAPLING.get(), new FeatureFlag[0]));


    public static final Supplier<PlasterBlock> PLASTER = registerBlockWithItem("plaster", () -> new PlasterBlock(null, BlockBehaviour.Properties.of().strength(1.25F, 1F).sound(SoundType.PACKED_MUD).instrument(NoteBlockInstrument.BASEDRUM)));


    static {
        CHALK_DUST.put(-1, BLEACHED_CHALK_DUST);
        CHALK.put(-1, BLEACHED_CHALK);
        for (DyeColor colours : DyeColor.values()) {
            //DYED PLASTER
            DYED_PLASTER.put(colours, registerBlockWithItem(colours + "_plaster", () -> new PlasterBlock(colours, BlockBehaviour.Properties.ofFullCopy(PLASTER.get()))));

            //DYED MUD BRICKS
            DYED_MUD_BRICKS.put(colours, registerBlockWithItem(colours + "_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS).mapColor(colours))));
            DYED_MUD_BRICK_SLAB.put(colours, registerBlockWithItem(colours + "_mud_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICK_SLAB).mapColor(colours))));
            DYED_MUD_BRICK_WALL.put(colours, registerBlockWithItem(colours + "_mud_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICK_WALL).mapColor(colours))));
            DYED_MUD_BRICK_STAIRS.put(colours, registerBlockWithItem(colours + "_mud_brick_stairs", () -> new CommonStairBlock(getDyedMudBricks(colours.getId()).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICK_SLAB).mapColor(colours))));

            //DYED TERRACOTTA SHINGLES
            DYED_TERRACOTTA_SHINGLES.put(colours, registerBlockWithItem(colours + "_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25f, 4.2f))));
            DYED_TERRACOTTA_SHINGLE_SLAB.put(colours, registerBlockWithItem(colours + "_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(getDyedTerracottaShingles(colours.getId())))));
            DYED_TERRACOTTA_SHINGLE_WALL.put(colours, registerBlockWithItem(colours + "_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(getDyedTerracottaShingles(colours.getId())))));
            DYED_TERRACOTTA_SHINGLE_STAIRS.put(colours, registerBlockWithItem(colours + "_terracotta_shingle_stairs", () -> new CommonStairBlock(getDyedTerracottaShingles(colours.getId()).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(getDyedTerracottaShingles(colours.getId())))));

            //DYED SOAPSTONE
            DYED_SOAPSTONE.put(colours, registerBlockWithItem(colours + "_soapstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F))));
            DYED_SOAPSTONE_SLAB.put(colours, registerBlockWithItem(colours + "_soapstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(getDyedSoapstone(colours.getId())))));
            DYED_SOAPSTONE_WALL.put(colours, registerBlockWithItem(colours + "_soapstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(getDyedSoapstone(colours.getId())))));
            DYED_SOAPSTONE_STAIRS.put(colours, registerBlockWithItem(colours + "_soapstone_stairs", () -> new CommonStairBlock(getDyedSoapstone(colours.getId()).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(getDyedSoapstone(colours.getId())))));

            DYED_SOAPSTONE_BRICKS.put(colours, registerBlockWithItem(colours + "_soapstone_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F))));
            DYED_SOAPSTONE_BRICK_SLAB.put(colours, registerBlockWithItem(colours + "_soapstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(getDyedSoapstone(colours.getId())))));
            DYED_SOAPSTONE_BRICK_WALL.put(colours, registerBlockWithItem(colours + "_soapstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(getDyedSoapstone(colours.getId())))));
            DYED_SOAPSTONE_BRICK_STAIRS.put(colours, registerBlockWithItem(colours + "_soapstone_brick_stairs", () -> new CommonStairBlock(getDyedSoapstone(colours.getId()).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(getDyedSoapstone(colours.getId())))));

            DYED_POLISHED_SOAPSTONE.put(colours, registerBlockWithItem(colours + "_polished_soapstone", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).sound(ACSoundTypes.SOAPSTONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.2F, 1F))));
            DYED_POLISHED_SOAPSTONE_SLAB.put(colours, registerBlockWithItem(colours + "_polished_soapstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(getDyedPolishedSoapstone(colours.getId())))));
            DYED_POLISHED_SOAPSTONE_WALL.put(colours, registerBlockWithItem(colours + "_polished_soapstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(getDyedPolishedSoapstone(colours.getId())))));
            DYED_POLISHED_SOAPSTONE_STAIRS.put(colours, registerBlockWithItem(colours + "_polished_soapstone_stairs", () -> new CommonStairBlock(getDyedPolishedSoapstone(colours.getId()).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(getDyedPolishedSoapstone(colours.getId())))));

            //CHALK
            CHALK.put(colours.getId(), registerBlockWithItem(colours + "_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(0.9f))));

            CHALK_DUST.put(colours.getId(), registerBlock(colours + "_chalk_dust", () -> new ChalkDustBlock(colours.getId(), BlockBehaviour.Properties.of().mapColor(colours).sound(SoundType.CALCITE).noCollission().instabreak().lightLevel((block) -> {
                if (block.getValue(ChalkDustBlock.GLOW)) {
                    return 7;
                }
                return 0;
            }).emissiveRendering((blockState, blockGetter, blockPos) -> {
                return blockState.getValue(ChalkDustBlock.GLOW);
            }))));

            if (colours.getId() <= 15) {
                DYED_FLOWER_POTS.put(colours, registerBlock(colours + "_flower_pot", ACBlocks::flowerPot));
                DYED_DECORATED_POTS.put(colours, registerBlock(colours + "_decorated_pot", () -> new DyedDecoratedPotBlock(colours, BlockBehaviour.Properties.ofFullCopy(Blocks.DECORATED_POT))));
            }
        }
        for (PietraforteColour colour : PietraforteColour.values()) {
            COBBLED_PIETRAFORTE.put(colour, registerBlockWithItem("cobbled_" + colour + "_pietraforte", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).mapColor(colour.getMapColor()))));
            COBBLED_PIETRAFORTE_STAIRS.put(colour, registerBlockWithItem("cobbled_" + colour + "_pietraforte_stairs", () -> new CommonStairBlock(getCobbledPietraforte(colour).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).mapColor(colour.getMapColor()))));
            COBBLED_PIETRAFORTE_SLAB.put(colour, registerBlockWithItem("cobbled_" + colour + "_pietraforte_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).mapColor(colour.getMapColor()))));
            COBBLED_PIETRAFORTE_WALL.put(colour, registerBlockWithItem("cobbled_" + colour + "_pietraforte_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLED_DEEPSLATE).mapColor(colour.getMapColor()))));

            PIETRAFORTE.put(colour, registerBlockWithItem(colour + "_pietraforte", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).mapColor(colour.getMapColor()))));
            PIETRAFORTE_STAIRS.put(colour, registerBlockWithItem(colour + "_pietraforte_stairs", () -> new CommonStairBlock(getPietraforte(colour).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).mapColor(colour.getMapColor()))));
            PIETRAFORTE_SLAB.put(colour, registerBlockWithItem(colour + "_pietraforte_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).mapColor(colour.getMapColor()))));
            PIETRAFORTE_WALL.put(colour, registerBlockWithItem(colour + "_pietraforte_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).mapColor(colour.getMapColor()))));

            CHISELED_PIETRAFORTE.put(colour, registerBlockWithItem("chiseled_" + colour + "_pietraforte", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_DEEPSLATE).mapColor(colour.getMapColor()))));

            PIETRAFORTE_BRICKS.put(colour, registerBlockWithItem(colour + "_pietraforte_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).mapColor(colour.getMapColor()))));
            PIETRAFORTE_BRICK_STAIRS.put(colour, registerBlockWithItem(colour + "_pietraforte_brick_stairs", () -> new CommonStairBlock(getPietraforteBricks(colour).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).mapColor(colour.getMapColor()))));
            PIETRAFORTE_BRICK_SLAB.put(colour, registerBlockWithItem(colour + "_pietraforte_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).mapColor(colour.getMapColor()))));
            PIETRAFORTE_BRICK_WALL.put(colour, registerBlockWithItem(colour + "_pietraforte_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).mapColor(colour.getMapColor()))));

            PIETRAFORTE_PILLAR.put(colour, registerBlockWithItem(colour + "_pietraforte_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).mapColor(colour.getMapColor()))));

            SMOOTH_PIETRAFORTE.put(colour, registerBlockWithItem("smooth_" + colour + "_pietraforte", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE).mapColor(colour.getMapColor()))));
            SMOOTH_PIETRAFORTE_STAIRS.put(colour, registerBlockWithItem("smooth_" +colour + "_pietraforte_stairs", () -> new CommonStairBlock(getSmoothPietraforte(colour).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE).mapColor(colour.getMapColor()))));
            SMOOTH_PIETRAFORTE_SLAB.put(colour, registerBlockWithItem("smooth_" +colour + "_pietraforte_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE).mapColor(colour.getMapColor()))));
            SMOOTH_PIETRAFORTE_WALL.put(colour, registerBlockWithItem("smooth_" +colour + "_pietraforte_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_DEEPSLATE).mapColor(colour.getMapColor()))));

            CUT_PIETRAFORTE.put(colour, registerBlockWithItem("cut_" + colour + "_pietraforte", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).mapColor(colour.getMapColor()))));
            CUT_PIETRAFORTE_STAIRS.put(colour, registerBlockWithItem("cut_" +colour + "_pietraforte_stairs", () -> new CommonStairBlock(getCutPietraforte(colour).defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).mapColor(colour.getMapColor()))));
            CUT_PIETRAFORTE_SLAB.put(colour, registerBlockWithItem("cut_" +colour + "_pietraforte_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).mapColor(colour.getMapColor()))));
            CUT_PIETRAFORTE_WALL.put(colour, registerBlockWithItem("cut_" +colour + "_pietraforte_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS).mapColor(colour.getMapColor()))));

        }
    }

    //GET METHODS
    public static Block getCobbledPietraforte(PietraforteColour colour) {
        return COBBLED_PIETRAFORTE.get(colour).get();
    }

    public static StairBlock getCobbledPietraforteStairs(PietraforteColour colour) {
        return COBBLED_PIETRAFORTE_STAIRS.get(colour).get();
    }

    public static SlabBlock getCobbledPietraforteSlab(PietraforteColour colour) {
        return COBBLED_PIETRAFORTE_SLAB.get(colour).get();
    }

    public static WallBlock getCobbledPietraforteWall(PietraforteColour colour) {
        return COBBLED_PIETRAFORTE_WALL.get(colour).get();
    }

    public static Block getPietraforte(PietraforteColour colour) {
        return PIETRAFORTE.get(colour).get();
    }

    public static StairBlock getPietraforteStairs(PietraforteColour colour) {
        return PIETRAFORTE_STAIRS.get(colour).get();
    }

    public static SlabBlock getPietraforteSlab(PietraforteColour colour) {
        return PIETRAFORTE_SLAB.get(colour).get();
    }

    public static WallBlock getPietraforteWall(PietraforteColour colour) {
        return PIETRAFORTE_WALL.get(colour).get();
    }

    public static Block getChiseledPietraforte(PietraforteColour colour) {
        return CHISELED_PIETRAFORTE.get(colour).get();
    }

    public static Block getPietraforteBricks(PietraforteColour colour) {
        return PIETRAFORTE_BRICKS.get(colour).get();
    }

    public static StairBlock getPietraforteBrickStairs(PietraforteColour colour) {
        return PIETRAFORTE_BRICK_STAIRS.get(colour).get();
    }

    public static SlabBlock getPietraforteBrickSlab(PietraforteColour colour) {
        return PIETRAFORTE_BRICK_SLAB.get(colour).get();
    }

    public static WallBlock getPietraforteBrickWall(PietraforteColour colour) {
        return PIETRAFORTE_BRICK_WALL.get(colour).get();
    }

    public static RotatedPillarBlock getPietrafortePillar(PietraforteColour colour) {
        return PIETRAFORTE_PILLAR.get(colour).get();
    }

    public static Block getSmoothPietraforte(PietraforteColour colour) {
        return SMOOTH_PIETRAFORTE.get(colour).get();
    }

    public static StairBlock getSmoothPietraforteStairs(PietraforteColour colour) {
        return SMOOTH_PIETRAFORTE_STAIRS.get(colour).get();
    }

    public static SlabBlock getSmoothPietraforteSlab(PietraforteColour colour) {
        return SMOOTH_PIETRAFORTE_SLAB.get(colour).get();
    }

    public static WallBlock getSmoothPietraforteWall(PietraforteColour colour) {
        return SMOOTH_PIETRAFORTE_WALL.get(colour).get();
    }

    public static Block getCutPietraforte(PietraforteColour colour) {
        return CUT_PIETRAFORTE.get(colour).get();
    }

    public static StairBlock getCutPietraforteStairs(PietraforteColour colour) {
        return CUT_PIETRAFORTE_STAIRS.get(colour).get();
    }

    public static SlabBlock getCutPietraforteSlab(PietraforteColour colour) {
        return CUT_PIETRAFORTE_SLAB.get(colour).get();
    }

    public static WallBlock getCutPietraforteWall(PietraforteColour colour) {
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

    public static Block getDyedDecoratedPot(int colours) {
        return DYED_DECORATED_POTS.get(DyeColor.byId(colours)).get();
    }



    private static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        return JinxedRegistryHelper.registerBlock(ArtsAndCrafts.MOD_ID, name, false, blockSupplier);
    }

    private static <T extends Block> Supplier<T> registerBlockWithItem(String name, java.util.function.Supplier<T> blockSupplier) {
        return JinxedRegistryHelper.registerBlock(ArtsAndCrafts.MOD_ID, name, true, blockSupplier);
    }

    private static FlammableRotatedPillarBlock corkLog(MapColor mapColor, MapColor mapColor2) {
        return new FlammableRotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(blockState -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? mapColor : mapColor2).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(ACSoundTypes.CORK).ignitedByLava());
    }

    private static FlammableLeavesBlock leaves(SoundType soundType) {
        return new FlammableLeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2f).randomTicks().sound(soundType).noOcclusion().isValidSpawn(ACBlocks::ocelotOrParrot).isSuffocating(ACBlocks::never).isViewBlocking(ACBlocks::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(ACBlocks::never));
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

    private static DyedFlowerPotBlock flowerPot() {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
        return new DyedFlowerPotBlock(properties);
    }

    private static ACBedBlock bed(DyeColor $$0) {
        return new ACBedBlock($$0, BlockBehaviour.Properties.of().mapColor(($$1) -> {
            return $$1.getValue(ACBedBlock.PART) == BedPart.FOOT ? $$0.getMapColor() : MapColor.WOOL;
        }).sound(SoundType.WOOD).strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY));
    }

    public static void register() {
    }

}
