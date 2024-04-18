package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
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
                case WHITE -> KekeBlocks.getDyedDecoratedPot(DyeColor.WHITE.getId());
                case ORANGE -> KekeBlocks.getDyedDecoratedPot(DyeColor.ORANGE.getId());
                case MAGENTA -> KekeBlocks.getDyedDecoratedPot(DyeColor.MAGENTA.getId());
                case LIGHT_BLUE -> KekeBlocks.getDyedDecoratedPot(DyeColor.LIGHT_BLUE.getId());
                case YELLOW -> KekeBlocks.getDyedDecoratedPot(DyeColor.YELLOW.getId());
                case LIME -> KekeBlocks.getDyedDecoratedPot(DyeColor.LIME.getId());
                case PINK -> KekeBlocks.getDyedDecoratedPot(DyeColor.PINK.getId());
                case GRAY -> KekeBlocks.getDyedDecoratedPot(DyeColor.GRAY.getId());
                case LIGHT_GRAY -> KekeBlocks.getDyedDecoratedPot(DyeColor.LIGHT_GRAY.getId());
                case CYAN -> KekeBlocks.getDyedDecoratedPot(DyeColor.CYAN.getId());
                case PURPLE -> KekeBlocks.getDyedDecoratedPot(DyeColor.PURPLE.getId());
                case BLUE -> KekeBlocks.getDyedDecoratedPot(DyeColor.BLUE.getId());
                case BROWN -> KekeBlocks.getDyedDecoratedPot(DyeColor.BROWN.getId());
                case GREEN -> KekeBlocks.getDyedDecoratedPot(DyeColor.GREEN.getId());
                case RED -> KekeBlocks.getDyedDecoratedPot(DyeColor.RED.getId());
                case BLACK -> KekeBlocks.getDyedDecoratedPot(DyeColor.BLACK.getId());
            };
        }
    }

    public static ItemStack getColoredItemStack(@Nullable DyeColor arg) {
        return new ItemStack(getBlockByColor(arg));
    }
}
