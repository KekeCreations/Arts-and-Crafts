package com.kekecreations.arts_and_crafts.common.block;

import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

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



    public static Block getBlockByColor(@Nullable DyeColor arg) {
        if (arg == null) {
            return Blocks.DECORATED_POT;
        } else {
            switch (arg) {
                default:
                    return Blocks.DECORATED_POT;
                case WHITE:
                    return KekeBlocks.getDyedDecoratedPot(DyeColor.WHITE.getId());
                case ORANGE:
                    return KekeBlocks.getDyedDecoratedPot(DyeColor.ORANGE.getId());
                case MAGENTA:
                    return KekeBlocks.getDyedDecoratedPot(DyeColor.MAGENTA.getId());
                case LIGHT_BLUE:
                    return KekeBlocks.getDyedDecoratedPot(DyeColor.LIGHT_BLUE.getId());
                case YELLOW:
                    return KekeBlocks.getDyedDecoratedPot(DyeColor.YELLOW.getId());
                case LIME:
                    return KekeBlocks.getDyedDecoratedPot(DyeColor.LIME.getId());
                case PINK:
                    return KekeBlocks.getDyedDecoratedPot(DyeColor.PINK.getId());
                case GRAY:
                    return KekeBlocks.getDyedDecoratedPot(DyeColor.GRAY.getId());
                case LIGHT_GRAY:
                    return KekeBlocks.getDyedDecoratedPot(DyeColor.LIGHT_GRAY.getId());
                case CYAN:
                    return KekeBlocks.getDyedDecoratedPot(DyeColor.CYAN.getId());
                case PURPLE:
                    return KekeBlocks.getDyedDecoratedPot(DyeColor.PURPLE.getId());
                case BLUE:
                    return KekeBlocks.getDyedDecoratedPot(DyeColor.BLUE.getId());
                case BROWN:
                    return KekeBlocks.getDyedDecoratedPot(DyeColor.BROWN.getId());
                case GREEN:
                    return KekeBlocks.getDyedDecoratedPot(DyeColor.GREEN.getId());
                case RED:
                    return KekeBlocks.getDyedDecoratedPot(DyeColor.RED.getId());
                case BLACK:
                    return KekeBlocks.getDyedDecoratedPot(DyeColor.BLACK.getId());
            }
        }
    }

    public static ItemStack getColoredItemStack(@Nullable DyeColor arg) {
        return new ItemStack(getBlockByColor(arg));
    }
}
