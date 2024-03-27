package com.kekecreations.arts_and_crafts.core.forge.registry;

import com.kekecreations.arts_and_crafts.common.block.CustomStairBlock;
import com.kekecreations.arts_and_crafts.common.misc.KekeWoodType;
import com.kekecreations.arts_and_crafts.core.platform.RegistryHelper;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.forge.block.ForgeLogBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class KekeForgeBlocks {


    public static final Supplier<ForgeLogBlock> CORK_LOG = RegistryHelper.registerBlockWithItem("cork_log", () -> KekeForgeBlocks.log(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
    public static final Supplier<ForgeLogBlock> STRIPPED_CORK_LOG = RegistryHelper.registerBlockWithItem("stripped_cork_log", () -> KekeForgeBlocks.log(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
    public static final Supplier<ForgeLogBlock> CORK_WOOD = RegistryHelper.registerBlockWithItem("cork_wood", () -> new ForgeLogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(SoundType.WOOD).ignitedByLava()));
    public static final Supplier<ForgeLogBlock> STRIPPED_CORK_WOOD = RegistryHelper.registerBlockWithItem("stripped_cork_wood", () -> new ForgeLogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(SoundType.WOOD).ignitedByLava()));


    public static final Supplier<Block> CORK_PLANKS = RegistryHelper.registerBlockWithItem("cork_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(SoundType.WOOD).ignitedByLava()) {
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 5;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 20;
        }
    });
    public static final Supplier<SlabBlock> CORK_SLAB = RegistryHelper.registerBlockWithItem("cork_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CORK_PLANKS.get())) {
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 5;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 20;
        }
    });
    public static final Supplier<CustomStairBlock> CORK_STAIRS = RegistryHelper.registerBlockWithItem("cork_stairs", () -> new CustomStairBlock(CORK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CORK_PLANKS.get())) {
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 5;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 20;
        }
    });
    public static final Supplier<FenceBlock> CORK_FENCE = RegistryHelper.registerBlockWithItem("cork_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(SoundType.WOOD).ignitedByLava()) {
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 5;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 20;
        }
    });
    public static final Supplier<FenceGateBlock> CORK_FENCE_GATE = RegistryHelper.registerBlockWithItem("cork_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).ignitedByLava(), KekeWoodType.CORK) {
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }
        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 5;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 20;
        }
    });
    public static final Supplier<LeavesBlock> CORK_LEAVES = RegistryHelper.registerBlockWithItem("cork_leaves", () ->
            KekeForgeBlocks.leaves(SoundType.GRASS));


    private static ForgeLogBlock log(MapColor mapColor, MapColor mapColor2) {
        return new ForgeLogBlock(BlockBehaviour.Properties.of().mapColor(blockState -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? mapColor : mapColor2).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(SoundType.WOOD).ignitedByLava());
    }
    private static LeavesBlock leaves(SoundType soundType) {
        return new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2f).randomTicks().sound(soundType).noOcclusion().isValidSpawn(KekeBlocks::ocelotOrParrot).isSuffocating(KekeBlocks::never).isViewBlocking(KekeBlocks::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(KekeBlocks::never)) {
            @Override
            public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return true;
            }
            @Override
            public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return 30;
            }
            @Override
            public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                return 60;
            }
        };
    }

    public static void register() {

    }
}
