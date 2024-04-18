package com.kekecreations.arts_and_crafts.common.item;

import com.kekecreations.arts_and_crafts.common.block.DyedDecoratedPotBlock;
import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.common.util.PaintbrushUtils;
import com.kekecreations.arts_and_crafts.core.config.ArtsAndCraftsCommonConfig;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class PaintBrushItem extends Item {

    private final DyeColor dyeColor;

    public PaintBrushItem(DyeColor dyeColor, Properties properties) {
        super(properties);
        this.dyeColor = dyeColor;
    }

    public DyeColor getDyeColor() {
        return this.dyeColor;
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        InteractionResult interactionResult = InteractionResult.FAIL;
        Level level = useOnContext.getLevel();
        BlockPos pos = useOnContext.getClickedPos();
        Player player = useOnContext.getPlayer();
        ItemStack itemStack = useOnContext.getItemInHand();
        DyeColor paintbrushDyeColour = this.getDyeColor();
        BlockState blockState = level.getBlockState(pos);
        BlockEntity blockEntity = level.getBlockEntity(pos);



        for (DyeColor colour : DyeColor.values()) {
            if (colour != paintbrushDyeColour && !level.isClientSide()) {
                if (ArtsAndCraftsCommonConfig.CAN_PAINT_TERRACOTTA.get() && (blockState.is(PaintbrushUtils.getDyedTerracotta(colour)) || blockState.is(Blocks.TERRACOTTA))) {
                    PaintbrushUtils.paintBlock(level, pos, player, PaintbrushUtils.getDyedTerracotta(paintbrushDyeColour).defaultBlockState(), paintbrushDyeColour);
                    interactionResult = InteractionResult.SUCCESS;
                }
                else if (ArtsAndCraftsCommonConfig.CAN_PAINT_WOOL.get() && blockState.is(PaintbrushUtils.getDyedWool(colour))) {
                    PaintbrushUtils.paintBlock(level, pos, player, PaintbrushUtils.getDyedWool(paintbrushDyeColour).defaultBlockState(), paintbrushDyeColour);
                    interactionResult = InteractionResult.SUCCESS;
                }
                else if (ArtsAndCraftsCommonConfig.CAN_PAINT_DECORATED_POTS.get() && (blockState.is(KekeBlocks.getDyedDecoratedPot(colour.getId())) || blockState.is(Blocks.DECORATED_POT))) {
                    PaintbrushUtils.paintDecoratedPot(level, blockEntity, pos, player, paintbrushDyeColour);
                    interactionResult = InteractionResult.SUCCESS;
                }


                if (interactionResult == InteractionResult.SUCCESS) {
                    if ((player != null && !player.getAbilities().instabuild)) {
                        if (player instanceof ServerPlayer serverPlayer)
                            CriteriaTriggers.PLACED_BLOCK.trigger(serverPlayer, pos, itemStack);
                        blockState.getBlock().setPlacedBy(level, pos, blockState, player, itemStack);
                        itemStack.hurtAndBreak(1, player, (entity) -> entity.broadcastBreakEvent(useOnContext.getHand()));
                    }
                }
            }
        }
        return interactionResult;
    }
}
