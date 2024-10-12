package com.kekecreations.arts_and_crafts.common.item;

import com.kekecreations.arts_and_crafts.common.entity.ACBedBlockEntity;
import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.common.util.PaintbrushUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

public class PaintbrushItem extends Item {


    public PaintbrushItem(Item.Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack itemStack = context.getItemInHand();
        BlockState blockState = level.getBlockState(pos);
        InteractionHand hand = context.getHand();
        BlockEntity blockEntity = context.getLevel().getBlockEntity(pos);


        if (!level.isClientSide()) {
            Block finalBlock = PaintbrushUtils.getFinalBlock(level.registryAccess(), blockState, itemStack);
            if (finalBlock != null && finalBlock != blockState.getBlock()) {
                if (blockEntity instanceof DyedDecoratedPotBlockEntity dyedDecoratedPotBlockEntity) {
                    DecoratedPotBlockEntity.Decorations oldDecorations = dyedDecoratedPotBlockEntity.getDecorations();
                    PaintbrushUtils.paintBlock(level, finalBlock.defaultBlockState(), pos, player, itemStack, hand);
                    PaintbrushUtils.setPotDecorations(level, pos, oldDecorations);
                    return InteractionResult.SUCCESS;
                } else if (blockEntity instanceof DecoratedPotBlockEntity decoratedPotBlockEntity) {
                    DecoratedPotBlockEntity.Decorations oldDecorations = decoratedPotBlockEntity.getDecorations();
                    PaintbrushUtils.paintBlock(level, finalBlock.defaultBlockState(), pos, player, itemStack, hand);
                    PaintbrushUtils.setPotDecorations(level, pos, oldDecorations);
                    return InteractionResult.sidedSuccess(true);
                } else if (blockEntity instanceof BedBlockEntity || blockEntity instanceof ACBedBlockEntity) {
                    PaintbrushUtils.paintBed(level, finalBlock.defaultBlockState(), pos, player, itemStack, hand);
                } else if (blockEntity instanceof BaseContainerBlockEntity container) {
                    List<ItemStack> itemList = new ArrayList<ItemStack>();
                    for (int i = 0; i < container.getContainerSize(); ++i) {
                        itemList.add(container.getItem(i));
                        container.setItem(i, ItemStack.EMPTY);
                    }
                    PaintbrushUtils.paintBlock(level, finalBlock.defaultBlockState(), pos, player, itemStack, hand);
                    BlockEntity newBlockEntity = level.getBlockEntity(pos);
                    if (newBlockEntity instanceof BaseContainerBlockEntity newContainer) {
                        for (int i = 0; i < newContainer.getContainerSize(); ++i) {
                            newContainer.setItem(i, itemList.get(i));
                        }
                    }
                    return InteractionResult.SUCCESS;
                }

                PaintbrushUtils.paintBlock(level, finalBlock.defaultBlockState(), pos, player, itemStack, hand);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }
}
