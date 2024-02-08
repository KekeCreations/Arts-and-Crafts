package com.kekecreations.arts_and_crafts.fabric.registry;

import com.kekecreations.arts_and_crafts.common.block.CustomStairBlock;
import com.kekecreations.arts_and_crafts.core.misc.KekeWoodType;
import com.kekecreations.arts_and_crafts.core.platform.RegistryHelper;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class KekeFabricBlocks {



    public static final Supplier<RotatedPillarBlock> CORK_LOG = RegistryHelper.registerBlockWithItem("cork_log", () -> KekeFabricBlocks.log(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
    public static final Supplier<RotatedPillarBlock> STRIPPED_CORK_LOG = RegistryHelper.registerBlockWithItem("stripped_cork_log", () -> KekeFabricBlocks.log(MapColor.COLOR_BROWN, MapColor.COLOR_BROWN));
    public static final Supplier<RotatedPillarBlock> CORK_WOOD = RegistryHelper.registerBlockWithItem("cork_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(SoundType.WOOD).ignitedByLava()));
    public static final Supplier<RotatedPillarBlock> STRIPPED_CORK_WOOD = RegistryHelper.registerBlockWithItem("stripped_cork_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(SoundType.WOOD).ignitedByLava()));
    public static final Supplier<Block> CORK_PLANKS = RegistryHelper.registerBlockWithItem("cork_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(SoundType.WOOD).ignitedByLava()));
    public static final Supplier<SlabBlock> CORK_SLAB = RegistryHelper.registerBlockWithItem("cork_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CORK_PLANKS.get())));
    public static final Supplier<CustomStairBlock> CORK_STAIRS = RegistryHelper.registerBlockWithItem("cork_stairs", () -> new CustomStairBlock(CORK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CORK_PLANKS.get())));
    public static final Supplier<FenceBlock> CORK_FENCE = RegistryHelper.registerBlockWithItem("cork_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(SoundType.WOOD).ignitedByLava()));
    public static final Supplier<FenceGateBlock> CORK_FENCE_GATE = RegistryHelper.registerBlockWithItem("cork_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).ignitedByLava(), KekeWoodType.CORK));
    public static final Supplier<LeavesBlock> CORK_LEAVES = RegistryHelper.registerBlockWithItem("cork_leaves", () -> KekeFabricBlocks.leaves(SoundType.GRASS));

    private static RotatedPillarBlock log(MapColor mapColor, MapColor mapColor2) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(blockState -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? mapColor : mapColor2).instrument(NoteBlockInstrument.BASS).strength(2.0f).sound(SoundType.WOOD).ignitedByLava());
    }

    private static LeavesBlock leaves(SoundType soundType) {
        return new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2f).randomTicks().sound(soundType).noOcclusion().isValidSpawn(KekeBlocks::ocelotOrParrot).isSuffocating(KekeBlocks::never).isViewBlocking(KekeBlocks::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(KekeBlocks::never));
    }

    public static void register() {
        FlammableBlockRegistry.getDefaultInstance().add(CORK_LOG.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(CORK_WOOD.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_CORK_LOG.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_CORK_WOOD.get(), 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(CORK_PLANKS.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CORK_STAIRS.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CORK_SLAB.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CORK_FENCE.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CORK_FENCE_GATE.get(), 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(CORK_LEAVES.get(), 30, 60);
        StrippableBlockRegistry.register(CORK_LOG.get(), STRIPPED_CORK_LOG.get());
        StrippableBlockRegistry.register(CORK_WOOD.get(), STRIPPED_CORK_WOOD.get());
    }
}
