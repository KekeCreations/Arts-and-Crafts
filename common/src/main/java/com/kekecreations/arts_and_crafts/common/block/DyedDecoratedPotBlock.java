package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DyedDecoratedPotBlock extends DecoratedPotBlock {

    private final DyeColor dyeColor;

    public DyedDecoratedPotBlock(DyeColor colour, Properties properties) {
        super(properties);
        this.dyeColor = colour;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        DyedDecoratedPotBlockEntity customDecoratedPotBlockEntity = new DyedDecoratedPotBlockEntity(blockPos, blockState);
        customDecoratedPotBlockEntity.setDyeColor(this.dyeColor.getId());
        return customDecoratedPotBlockEntity;
    }


    @Override
    public @NotNull List<ItemStack> getDrops(@NotNull BlockState blockState, LootParams.Builder builder) {
        BlockEntity blockentity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (blockentity instanceof DyedDecoratedPotBlockEntity dyedDecoratedPotBlockEntity) {
            builder.withDynamicDrop(SHERDS_DYNAMIC_DROP_ID, (p_284876_) -> {
                dyedDecoratedPotBlockEntity.getDecorations().sorted().map(Item::getDefaultInstance).forEach(p_284876_);
            });
        }

        return super.getDrops(blockState, builder);
    }



    public static Block getBlockByColor(@Nullable DyeColor arg) {
        if (arg == null) {
            return Blocks.DECORATED_POT;
        } else {
            return switch (arg) {
                default -> Blocks.DECORATED_POT;
                case WHITE -> ACBlocks.getDyedDecoratedPot(DyeColor.WHITE.getId());
                case ORANGE -> ACBlocks.getDyedDecoratedPot(DyeColor.ORANGE.getId());
                case MAGENTA -> ACBlocks.getDyedDecoratedPot(DyeColor.MAGENTA.getId());
                case LIGHT_BLUE -> ACBlocks.getDyedDecoratedPot(DyeColor.LIGHT_BLUE.getId());
                case YELLOW -> ACBlocks.getDyedDecoratedPot(DyeColor.YELLOW.getId());
                case LIME -> ACBlocks.getDyedDecoratedPot(DyeColor.LIME.getId());
                case PINK -> ACBlocks.getDyedDecoratedPot(DyeColor.PINK.getId());
                case GRAY -> ACBlocks.getDyedDecoratedPot(DyeColor.GRAY.getId());
                case LIGHT_GRAY -> ACBlocks.getDyedDecoratedPot(DyeColor.LIGHT_GRAY.getId());
                case CYAN -> ACBlocks.getDyedDecoratedPot(DyeColor.CYAN.getId());
                case PURPLE -> ACBlocks.getDyedDecoratedPot(DyeColor.PURPLE.getId());
                case BLUE -> ACBlocks.getDyedDecoratedPot(DyeColor.BLUE.getId());
                case BROWN -> ACBlocks.getDyedDecoratedPot(DyeColor.BROWN.getId());
                case GREEN -> ACBlocks.getDyedDecoratedPot(DyeColor.GREEN.getId());
                case RED -> ACBlocks.getDyedDecoratedPot(DyeColor.RED.getId());
                case BLACK -> ACBlocks.getDyedDecoratedPot(DyeColor.BLACK.getId());
            };
        }
    }

    public static ItemStack getColoredItemStack(@Nullable DyeColor arg) {
        return new ItemStack(getBlockByColor(arg));
    }
}
