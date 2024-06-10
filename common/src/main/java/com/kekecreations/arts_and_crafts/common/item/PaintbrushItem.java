package com.kekecreations.arts_and_crafts.common.item;

import com.kekecreations.arts_and_crafts.common.block.DyedDecoratedPotBlock;
import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.common.item.palette.PaintbrushPalette;
import com.kekecreations.arts_and_crafts.common.util.PaintbrushUtils;
import com.kekecreations.arts_and_crafts.core.registry.ArtsAndCraftsRegistries;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PaintbrushItem extends Item {

    private final DyeColor dyeColor;

    public PaintbrushItem(DyeColor dyeColor, Properties properties) {
        super(properties);
        this.dyeColor = dyeColor;
    }

    public DyeColor getDyeColor() {
        return this.dyeColor;
    }

    public boolean isValidRepairItem(@NotNull ItemStack stack, ItemStack repairCandidate) {
        return repairCandidate.is(DyeItem.byColor(this.getDyeColor()));
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
                }

                PaintbrushUtils.paintBlock(level, finalBlock.defaultBlockState(), pos, player, itemStack, hand);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }
}
