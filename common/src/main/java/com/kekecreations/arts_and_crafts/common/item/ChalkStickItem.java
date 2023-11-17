package com.kekecreations.arts_and_crafts.common.item;

import com.kekecreations.arts_and_crafts.common.block.ChalkDustBlock;
import com.kekecreations.arts_and_crafts.core.misc.KekeBlockStateProperties;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class ChalkStickItem extends Item {
    public ChalkStickItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Player player = useOnContext.getPlayer();
        BlockPos blockPos = useOnContext.getClickedPos();
        Level level = useOnContext.getLevel();
        BlockState blockState = level.getBlockState(blockPos);
        Block block = blockState.getBlock();
        RandomSource random = level.getRandom();

        InteractionResult interactionResult = this.place(new BlockPlaceContext(useOnContext));


        if (block instanceof ChalkDustBlock chalkDustBlock) {
            int state;
            if (player.isCrouching()) {
                state = -1;
            } else {
                state = 1;
            }
            level.playSound(player, blockPos, SoundEvents.CALCITE_HIT, SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.2F + 0.9F);
            if (block == KekeBlocks.WHITE_CHALK_DUST.get() && this == KekeItems.WHITE_CHALK_STICK.get()) {
                level.setBlockAndUpdate(blockPos, chalkDustBlock.changeState(blockState, player, state));
            }
            return InteractionResult.SUCCESS;
        }


        return interactionResult;
    }

    public InteractionResult place(BlockPlaceContext blockPlaceContext) {
        if (!blockPlaceContext.canPlace()) return InteractionResult.FAIL;

        Level level = blockPlaceContext.getLevel();
        BlockPos pos = blockPlaceContext.getClickedPos();
        Player player = blockPlaceContext.getPlayer();
        ItemStack itemStack = blockPlaceContext.getItemInHand();

        BlockState state = KekeBlocks.WHITE_CHALK_DUST.get().getStateForPlacement(blockPlaceContext);
        BlockState clickedState = level.getBlockState(pos);

        if (state != null) {
            RandomSource randomSource = level.getRandom();
            level.setBlockAndUpdate(pos, state);
            level.playSound(player, pos, SoundEvents.CALCITE_HIT, SoundSource.BLOCKS, 0.5F, randomSource.nextFloat() * 0.2F + 0.9F);
            level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(player, clickedState));

            if (player instanceof ServerPlayer serverPlayer) CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, pos, itemStack);
            clickedState.getBlock().setPlacedBy(level, pos, clickedState, player, itemStack);

            if ((player == null || !player.getAbilities().instabuild) && !(clickedState.getBlock() instanceof ChalkDustBlock)) {
                itemStack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(blockPlaceContext.getHand()));
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
}
