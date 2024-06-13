package com.kekecreations.arts_and_crafts.common.item;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.block.ChalkDustBlock;
import com.kekecreations.arts_and_crafts.common.misc.KekeBlockStateProperties;
import com.kekecreations.arts_and_crafts.common.util.ChalkUtils;
import com.kekecreations.arts_and_crafts.core.registry.ArtsAndCraftsDataComponents;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChalkStickItem extends Item {
    private final Integer dyeColor;

    public ChalkStickItem(Integer dyeColor, Properties properties) {
        super(properties.component(ArtsAndCraftsDataComponents.CHALK_PATTERN.get(), 0));
        this.dyeColor = dyeColor;
    }

    public int getDyeColor() {
        return this.dyeColor;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, TooltipContext tooltipContext, @NotNull List<Component> toolTipComponents, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemStack, tooltipContext, toolTipComponents, flag);
        if (!itemStack.has(ArtsAndCraftsDataComponents.CHALK_PATTERN.get())) return;

        toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_" + itemStack.get(ArtsAndCraftsDataComponents.CHALK_PATTERN.get())).withStyle(ChatFormatting.GRAY));
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Player player = useOnContext.getPlayer();
        BlockPos blockPos = useOnContext.getClickedPos();
        Level level = useOnContext.getLevel();
        BlockState blockState = level.getBlockState(blockPos);
        Block block = blockState.getBlock();
        RandomSource random = level.getRandom();
        Vec3 clickLocation = useOnContext.getClickLocation();
        ItemStack itemStack = useOnContext.getItemInHand();

        if (level.isClientSide()) {
            if (block instanceof ChalkDustBlock chalkDustBlock) {
                if (player != null) {
                    if (player.getItemInHand(InteractionHand.OFF_HAND).getItem() instanceof ChalkStickItem && !(player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof ChalkStickItem)) {
                        if (chalkDustBlock.getDyeColor() == this.getDyeColor()) {
                            ChalkUtils.spawnChalkParticle(level, clickLocation.x(), clickLocation.y() + 0.2D, clickLocation.z(), getDyeColor());
                        }
                    } else if (!player.isCrouching() && chalkDustBlock.getDyeColor() == this.getDyeColor()) {
                        ChalkUtils.spawnChalkParticle(level, clickLocation.x(), clickLocation.y() + 0.2D, clickLocation.z(), getDyeColor());
                    }
                }
            }
        }
        if (!level.isClientSide()) {
            InteractionResult interactionResult = this.place(new BlockPlaceContext(useOnContext));

            if (block instanceof ChalkDustBlock chalkDustBlock) {
                if (player != null) {
                    if (player.getItemInHand(InteractionHand.OFF_HAND).getItem() instanceof ChalkStickItem && !(player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof ChalkStickItem)) {
                        if (chalkDustBlock.getDyeColor() == this.getDyeColor()) {
                            ChalkUtils.spawnChalkParticle(level, clickLocation.x(), clickLocation.y() + 0.2D, clickLocation.z(), getDyeColor());
                            level.setBlockAndUpdate(blockPos, ChalkUtils.changeChalkDustState(blockState, player, 1));
                            level.playSound(null, blockPos, SoundEvents.CALCITE_HIT, SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.2F + 0.9F);
                            return InteractionResult.SUCCESS;
                        }
                    } else {
                        if (player.isCrouching()) {
                            itemStack.set(ArtsAndCraftsDataComponents.CHALK_PATTERN.get(), ChalkUtils.getChalkPatternFromChalkDust(blockState));
                            return InteractionResult.SUCCESS;
                        } else if (chalkDustBlock.getDyeColor() == this.getDyeColor()) {
                            ChalkUtils.spawnChalkParticle(level, clickLocation.x(), clickLocation.y() + 0.2D, clickLocation.z(), getDyeColor());
                            level.setBlockAndUpdate(blockPos, ChalkUtils.changeChalkDustState(blockState, player, 1));
                            level.playSound(null, blockPos, SoundEvents.CALCITE_HIT, SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.2F + 0.9F);
                            return InteractionResult.SUCCESS;
                        }
                    }
                }
            }
            return interactionResult;
        }
        return InteractionResult.FAIL;
    }

    public InteractionResult place(BlockPlaceContext blockPlaceContext) {
        if (!blockPlaceContext.canPlace() || blockPlaceContext.getClickedPos().getY() > 319) return InteractionResult.FAIL;
        Level level = blockPlaceContext.getLevel();
        BlockPos pos = blockPlaceContext.getClickedPos();
        Player player = blockPlaceContext.getPlayer();
        ItemStack itemStack = blockPlaceContext.getItemInHand();
        if (player != null) {
            InteractionHand hand = player.getUsedItemHand();
            BlockState state = KekeBlocks.getChalkDust(this.getDyeColor()).getStateForPlacement(blockPlaceContext);
            BlockState clickedState = level.getBlockState(pos);

            if (state != null && !(clickedState.getBlock() instanceof ChalkDustBlock)) {
                RandomSource randomSource = level.getRandom();

                int chalkPattern = itemStack.getOrDefault(ArtsAndCraftsDataComponents.CHALK_PATTERN.get(), 0);
                ArtsAndCrafts.LOG.info("Pattern: {}", chalkPattern);
                level.setBlockAndUpdate(pos, state.setValue(KekeBlockStateProperties.CHALK_PATTERN, chalkPattern));
                level.playSound(null, pos, SoundEvents.CALCITE_HIT, SoundSource.BLOCKS, 0.5F, randomSource.nextFloat() * 0.2F + 0.9F);
                level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(player, clickedState));

                if (player instanceof ServerPlayer serverPlayer)
                    CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, pos, itemStack);
                clickedState.getBlock().setPlacedBy(level, pos, clickedState, player, itemStack);

                if ((!player.getAbilities().instabuild) && !(clickedState.getBlock() instanceof ChalkDustBlock)) {
                    if (hand == InteractionHand.MAIN_HAND) {
                        itemStack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
                    } else {
                        itemStack.hurtAndBreak(1, player, EquipmentSlot.OFFHAND);
                    }
                }
                if (!level.isClientSide()) {
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.FAIL;
    }
}
