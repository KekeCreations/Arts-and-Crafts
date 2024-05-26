package com.kekecreations.arts_and_crafts.common.item;

import com.kekecreations.arts_and_crafts.common.block.ChalkDustBlock;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class LotusPistilItem extends Item {
    public LotusPistilItem(Properties $$0) {
        super($$0);
    }


    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        if (!level.isClientSide()) {
            InteractionResult interactionResult = this.place(new BlockPlaceContext(useOnContext));
            return interactionResult;
        }
        return InteractionResult.FAIL;
    }


    public InteractionResult place(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockPos pos = blockPlaceContext.getClickedPos().below();
        Player player = blockPlaceContext.getPlayer();
        ItemStack itemStack = blockPlaceContext.getItemInHand();
        RandomSource randomSource = level.getRandom();
        BlockState clickedState = level.getBlockState(pos);

        if (clickedState.is(Blocks.LILY_PAD)) {
            BlockState state = KekeBlocks.LOTUS_FLOWER.get().getStateForPlacement(blockPlaceContext);
            if (state != null) {
                level.setBlockAndUpdate(pos, state);
                level.playSound(null, pos, SoundEvents.LILY_PAD_PLACE, SoundSource.BLOCKS, 0.5F, randomSource.nextFloat() * 0.2F + 0.9F);
                level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(player, clickedState));
                if (player instanceof ServerPlayer serverPlayer)
                    CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, pos, itemStack);
                clickedState.getBlock().setPlacedBy(level, pos, clickedState, player, itemStack);
                if (player != null && !player.getAbilities().instabuild) {
                    itemStack.setCount(itemStack.getCount() - 1);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }
}
