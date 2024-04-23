package com.kekecreations.arts_and_crafts.common.item;

import com.kekecreations.arts_and_crafts.common.util.PaintbrushUtils;
import com.kekecreations.arts_and_crafts.core.config.ArtsAndCraftsCommonConfig;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

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
        Level level = useOnContext.getLevel();
        BlockPos pos = useOnContext.getClickedPos();
        Player player = useOnContext.getPlayer();
        ItemStack itemStack = useOnContext.getItemInHand();
        DyeColor paintbrushDyeColour = this.getDyeColor();
        BlockState blockState = level.getBlockState(pos);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        InteractionHand hand = useOnContext.getHand();


        if (!level.isClientSide()) {
            for (DyeColor colour : DyeColor.values()) {
                if (colour != paintbrushDyeColour) {
                    if (ArtsAndCraftsCommonConfig.CAN_PAINT_TERRACOTTA.get() && (blockState.is(PaintbrushUtils.getDyedTerracotta(colour)) || blockState.is(Blocks.TERRACOTTA))) {
                        PaintbrushUtils.paintBlock(level, PaintbrushUtils.getDyedTerracotta(paintbrushDyeColour).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_GLAZED_TERRACOTTA.get() && (blockState.is(PaintbrushUtils.getDyedGlazedTerracotta(colour)))) {
                        BlockState paintedBlockState = PaintbrushUtils.getDyedGlazedTerracotta(paintbrushDyeColour).defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, blockState.getValue(BlockStateProperties.HORIZONTAL_FACING));
                        PaintbrushUtils.paintBlock(level, paintedBlockState, pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_WOOL.get() && blockState.is(PaintbrushUtils.getDyedWool(colour))) {
                        PaintbrushUtils.paintBlock(level, PaintbrushUtils.getDyedWool(paintbrushDyeColour).defaultBlockState(), pos, player, itemStack, hand);
                        return InteractionResult.SUCCESS;
                    } else if (ArtsAndCraftsCommonConfig.CAN_PAINT_DECORATED_POTS.get() && (blockState.is(KekeBlocks.getDyedDecoratedPot(colour.getId())) || blockState.is(Blocks.DECORATED_POT))) {
                        PaintbrushUtils.paintDecoratedPot(level, blockEntity, pos, player, itemStack, hand, paintbrushDyeColour);
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }
        return InteractionResult.FAIL;
    }
}
