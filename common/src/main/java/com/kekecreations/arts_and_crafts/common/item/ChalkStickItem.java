package com.kekecreations.arts_and_crafts.common.item;

import com.google.common.collect.Maps;
import com.kekecreations.arts_and_crafts.common.block.ChalkDustBlock;
import com.kekecreations.arts_and_crafts.common.misc.KekeBlockStateProperties;
import com.kekecreations.arts_and_crafts.common.util.ChalkUtils;
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
import java.util.Map;

public class ChalkStickItem extends Item {

    private static final Map<DyeColor, ChalkStickItem> ITEM_BY_COLOR = Maps.newEnumMap(DyeColor.class);
    private final DyeColor dyeColor;
    public static final String TAG_CHALK_PATTERN = "ChalkPattern";

    public ChalkStickItem(DyeColor dyeColor, Properties properties) {
        super(properties);
        this.dyeColor = dyeColor;
        ITEM_BY_COLOR.put(dyeColor, this);
    }

    public DyeColor getDyeColor() {
        return this.dyeColor;
    }


    public int getChalkPattern(ItemStack itemStack) {
        CompoundTag compoundTag = itemStack.getTag();
        if (compoundTag != null && compoundTag.contains("ChalkPattern")) {
            return compoundTag.getInt(TAG_CHALK_PATTERN);
        } else {
            return 100;
        }
    }
    public void setChalkPattern(ItemStack itemStack, int chalkPattern) {
        itemStack.getOrCreateTag().putInt(TAG_CHALK_PATTERN, chalkPattern);
    }


    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> toolTipComponents, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemStack, level, toolTipComponents, flag);
        if (level != null ) {
            switch (getChalkPattern(itemStack)) {
                case 0 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_0").withStyle(ChatFormatting.GRAY));
                case 1 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_1").withStyle(ChatFormatting.GRAY));
                case 2 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_2").withStyle(ChatFormatting.GRAY));
                case 3 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_3").withStyle(ChatFormatting.GRAY));
                case 4 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_4").withStyle(ChatFormatting.GRAY));
                case 5 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_5").withStyle(ChatFormatting.GRAY));
                case 6 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_6").withStyle(ChatFormatting.GRAY));
                case 7 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_7").withStyle(ChatFormatting.GRAY));
                case 8 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_8").withStyle(ChatFormatting.GRAY));
                case 9 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_9").withStyle(ChatFormatting.GRAY));
                case 10 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_10").withStyle(ChatFormatting.GRAY));
                case 11 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_11").withStyle(ChatFormatting.GRAY));
                case 12 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_12").withStyle(ChatFormatting.GRAY));
                case 13 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_13").withStyle(ChatFormatting.GRAY));
                case 14 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_14").withStyle(ChatFormatting.GRAY));
                case 15 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_15").withStyle(ChatFormatting.GRAY));
                case 16 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_16").withStyle(ChatFormatting.GRAY));
                case 17 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_17").withStyle(ChatFormatting.GRAY));
                case 18 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_18").withStyle(ChatFormatting.GRAY));
                case 19 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_19").withStyle(ChatFormatting.GRAY));
                case 20 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_20").withStyle(ChatFormatting.GRAY));
                case 21 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_21").withStyle(ChatFormatting.GRAY));
                case 22 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_22").withStyle(ChatFormatting.GRAY));
                case 23 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_23").withStyle(ChatFormatting.GRAY));
            }
        }
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

        if (itemStack.getTag() != null && !itemStack.getTag().contains(TAG_CHALK_PATTERN)) {
            setChalkPattern(itemStack, 0);
        }
        InteractionResult interactionResult = this.place(new BlockPlaceContext(useOnContext));

        if (block instanceof ChalkDustBlock chalkDustBlock) {
            if (player != null && player.isCrouching()) {
                setChalkPattern(player.getItemInHand(InteractionHand.MAIN_HAND), ChalkUtils.getChalkPatternFromChalkDust(blockState));
                return InteractionResult.SUCCESS;
            } else if (chalkDustBlock.getDyeColor() == this.getDyeColor()) {
                ChalkUtils.spawnChalkParticle(level, clickLocation.x(), clickLocation.y() + 0.2D, clickLocation.z(), getDyeColor());
                level.setBlockAndUpdate(blockPos, ChalkUtils.changeChalkDustState(blockState, player, 1));
                level.playSound(player, blockPos, SoundEvents.CALCITE_HIT, SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.2F + 0.9F);
                return InteractionResult.SUCCESS;
            }
        }


        return interactionResult;
    }

    public InteractionResult place(BlockPlaceContext blockPlaceContext) {
        if (!blockPlaceContext.canPlace() || blockPlaceContext.getClickedPos().getY() > 319) return InteractionResult.FAIL;
        Level level = blockPlaceContext.getLevel();
        BlockPos pos = blockPlaceContext.getClickedPos();
        Player player = blockPlaceContext.getPlayer();
        ItemStack itemStack = blockPlaceContext.getItemInHand();
        if (itemStack.getItem() instanceof ChalkStickItem chalkStick) {
            BlockState state = KekeBlocks.getChalkDust(this.getDyeColor()).getStateForPlacement(blockPlaceContext);
            BlockState clickedState = level.getBlockState(pos);

            if (state != null && !(clickedState.getBlock() instanceof ChalkDustBlock)) {
                RandomSource randomSource = level.getRandom();
                if (chalkStick.getChalkPattern(itemStack) != 100) {
                    level.setBlockAndUpdate(pos, state.setValue(KekeBlockStateProperties.CHALK_PATTERN, chalkStick.getChalkPattern(itemStack)));
                } else {
                    level.setBlockAndUpdate(pos, state.setValue(KekeBlockStateProperties.CHALK_PATTERN, 0));
                }
                level.playSound(player, pos, SoundEvents.CALCITE_HIT, SoundSource.BLOCKS, 0.5F, randomSource.nextFloat() * 0.2F + 0.9F);
                level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(player, clickedState));

                if (player instanceof ServerPlayer serverPlayer)
                    CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, pos, itemStack);
                clickedState.getBlock().setPlacedBy(level, pos, clickedState, player, itemStack);

                if ((player != null && !player.getAbilities().instabuild) && !(clickedState.getBlock() instanceof ChalkDustBlock)) {
                    itemStack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(blockPlaceContext.getHand()));
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }
}
