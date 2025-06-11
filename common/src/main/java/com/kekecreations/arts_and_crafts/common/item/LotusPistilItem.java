package com.kekecreations.arts_and_crafts.common.item;

import com.kekecreations.arts_and_crafts.common.block.LotusFlowerBlock;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;

public class LotusPistilItem extends Item {
    public LotusPistilItem(Properties $$0) {
        super($$0);
    }


    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        return InteractionResult.PASS;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        BlockHitResult blockHitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
        BlockHitResult blockHitResult2 = blockHitResult.withPosition(blockHitResult.getBlockPos().above());
        InteractionResult interactionResult = this.place(level, player, blockHitResult, blockHitResult2, player.getItemInHand(interactionHand));
        return new InteractionResultHolder<>(interactionResult, player.getItemInHand(interactionHand));
    }

    public InteractionResult place(Level level, Player player, BlockHitResult fluidResult, BlockHitResult hitResult, ItemStack itemStack) {
        BlockPos pos = hitResult.getBlockPos();
        BlockPos fluidPos = fluidResult.getBlockPos();
        RandomSource randomSource = level.getRandom();
        BlockState clickedState = level.getBlockState(pos);

        if (level.getFluidState(fluidPos).is(Fluids.WATER)) {
            BlockState state = getStateForPlacement(player);
            if (state != null) {
                level.setBlockAndUpdate(pos, state);
                level.playSound(null, pos, SoundEvents.LILY_PAD_PLACE, SoundSource.BLOCKS, 0.5F, randomSource.nextFloat() * 0.2F + 0.9F);
                level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(player, clickedState));
                if (player instanceof ServerPlayer serverPlayer) {
                    CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, pos, itemStack);
                }
                clickedState.getBlock().setPlacedBy(level, pos, clickedState, player, itemStack);
                if (!player.getAbilities().instabuild) {
                    itemStack.setCount(itemStack.getCount() - 1);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }

    public BlockState getStateForPlacement(Player player) {
        return ACBlocks.LOTUS_FLOWER.get().getStateDefinition().any()
                .setValue(LotusFlowerBlock.SHEARED, false)
                .setValue(LotusFlowerBlock.AGE, 0)
                .setValue(LotusFlowerBlock.FACING, player.getDirection().getOpposite());
    }
}
