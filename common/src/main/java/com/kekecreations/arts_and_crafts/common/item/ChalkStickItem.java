package com.kekecreations.arts_and_crafts.common.item;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kekecreations.arts_and_crafts.common.block.ChalkDustBlock;
import com.kekecreations.arts_and_crafts.common.misc.KekeBlockStateProperties;
import com.kekecreations.arts_and_crafts.common.util.ChalkUtils;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import com.kekecreations.arts_and_crafts.core.registry.KekeParticles;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
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
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public static ChalkStickItem byColour(DyeColor dyeColor) {
        return ITEM_BY_COLOR.get(dyeColor);
    }


    public int getChalkPattern(ItemStack itemStack) {
        CompoundTag compoundTag = itemStack.getTag();
        if (compoundTag != null && compoundTag.contains("ChalkPattern")) {
            return compoundTag.getInt(TAG_CHALK_PATTERN);
        } else {
            return 25;
        }
    }
    public static void setChalkPattern(ItemStack itemStack, int chalkPattern) {
        itemStack.getOrCreateTag().putInt(TAG_CHALK_PATTERN, chalkPattern);
    }

    /*
    @Override
    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int $$3, boolean $$4) {
        super.inventoryTick(itemStack, level, entity, $$3, $$4);
        if (itemStack.getTag() != null && !itemStack.getTag().contains(TAG_CHALK_PATTERN)) {
            //setChalkPattern(itemStack, 0);
            System.out.println("inventory tick success");
        }
    }

     */

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> toolTipComponents, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemStack, level, toolTipComponents, flag);
        List<Component> list = Lists.newArrayList();
        if (level != null ) {
            switch (getChalkPattern(itemStack)) {
                case 0 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_0").withStyle(ChatFormatting.GRAY));
                case 1 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_1").withStyle(ChatFormatting.GRAY));
                case 2 -> toolTipComponents.add(Component.translatable("tooltip.arts_and_crafts.chalk_pattern_2").withStyle(ChatFormatting.GRAY));
                case 25 -> {
                }
            }
        }
        if (itemStack.getTag() != null && !itemStack.getTag().contains("ChalkPattern") && toolTipComponents.size() != 0) {
            //toolTipComponents.remove(list.get(1));
        }
    }

    public void spawnParticle(Player player, double x, double y, double z, DyeColor colours) {
        player.level().addParticle(KekeParticles.getChalkDrawParticle(colours), x, y, z, 0D, 0D, 0D );
        player.level().addParticle(KekeParticles.getChalkDrawParticle(colours), x, y, z, 0D, 0D, 0D );
        player.level().addParticle(KekeParticles.getChalkDrawParticle(colours), x, y, z, 0D, 0D, 0D );
        player.level().addParticle(KekeParticles.getChalkDrawParticle(colours), x, y, z, 0D, 0D, 0D );
    }


    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Player player = useOnContext.getPlayer();
        BlockPos blockPos = useOnContext.getClickedPos();
        Level level = useOnContext.getLevel();
        BlockState blockState = level.getBlockState(blockPos);
        Block block = blockState.getBlock();
        RandomSource random = level.getRandom();
        Direction clickedFace = useOnContext.getClickedFace();
        Vec3 clickLocation = useOnContext.getClickLocation();
        ItemStack itemStack = useOnContext.getItemInHand();

        if (itemStack.getTag() != null && !itemStack.getTag().contains(TAG_CHALK_PATTERN)) {
            setChalkPattern(itemStack, 0);
        }
        InteractionResult interactionResult = this.place(new BlockPlaceContext(useOnContext));


        if (block instanceof ChalkDustBlock chalkDustBlock) {
            if (player.isCrouching()) {
                setChalkPattern(player.getItemInHand(InteractionHand.MAIN_HAND), ChalkUtils.getChalkPatternFromChalkDust(blockState));

            } else {
                for (DyeColor colours : DyeColor.values()) {
                    if (block == KekeBlocks.getChalkDust(colours) && this == KekeItems.getChalkStick(colours.getId())) {

                        spawnParticle(player, clickLocation.x(), clickLocation.y() + 0.2D, clickLocation.z(), colours);
                        level.setBlockAndUpdate(blockPos, chalkDustBlock.changeState(blockState, player, 1));
                        level.playSound(player, blockPos, SoundEvents.CALCITE_HIT, SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.2F + 0.9F);

                    }
                }
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

        if (itemStack.getItem() instanceof ChalkStickItem chalkStick) {
            BlockState state = KekeBlocks.getChalkDust(this.getDyeColor()).getStateForPlacement(blockPlaceContext);
            BlockState clickedState = level.getBlockState(pos);

            if (state != null && !(clickedState.getBlock() instanceof ChalkDustBlock)) {
                RandomSource randomSource = level.getRandom();
                if (chalkStick.getChalkPattern(itemStack) != 25) {
                    level.setBlockAndUpdate(pos, state.setValue(KekeBlockStateProperties.CHALK_DUST_23, chalkStick.getChalkPattern(itemStack)));
                } else {
                    level.setBlockAndUpdate(pos, state.setValue(KekeBlockStateProperties.CHALK_DUST_23, 0));
                }
                level.playSound(player, pos, SoundEvents.CALCITE_HIT, SoundSource.BLOCKS, 0.5F, randomSource.nextFloat() * 0.2F + 0.9F);
                level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(player, clickedState));

                if (player instanceof ServerPlayer serverPlayer)
                    CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, pos, itemStack);
                clickedState.getBlock().setPlacedBy(level, pos, clickedState, player, itemStack);

                if ((player == null || !player.getAbilities().instabuild) && !(clickedState.getBlock() instanceof ChalkDustBlock)) {
                    itemStack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(blockPlaceContext.getHand()));
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }
}
