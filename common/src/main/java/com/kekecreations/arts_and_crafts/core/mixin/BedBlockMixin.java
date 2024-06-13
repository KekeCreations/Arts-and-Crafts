package com.kekecreations.arts_and_crafts.core.mixin;

import com.kekecreations.arts_and_crafts.common.item.PaintbrushItem;
import com.kekecreations.arts_and_crafts.common.util.PaintbrushUtils;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BedBlock.class)
public class BedBlockMixin extends HorizontalDirectionalBlock {
    private static final MapCodec<BedBlock> CODEC = RecordCodecBuilder.mapCodec(($$0) -> {
        return $$0.group(DyeColor.CODEC.fieldOf("color").forGetter(BedBlock::getColor), propertiesCodec()).apply($$0, BedBlock::new);
    });

    public BedBlockMixin(Properties $$0) {
        super($$0);
    }

    @Override
    public MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!level.isClientSide()) {
            if (itemStack.getItem() instanceof PaintbrushItem) {
                Block finalBlock = PaintbrushUtils.getFinalBlock(level.registryAccess(), blockState, itemStack);
                if (finalBlock != null && finalBlock != blockState.getBlock()) {
                    PaintbrushUtils.paintBed(level, finalBlock.defaultBlockState(), blockPos, player, itemStack, interactionHand);
                    return ItemInteractionResult.SUCCESS;
                }
            }
        }
        return ItemInteractionResult.FAIL;
    }
}
