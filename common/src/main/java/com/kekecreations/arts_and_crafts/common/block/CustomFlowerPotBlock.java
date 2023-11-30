package com.kekecreations.arts_and_crafts.common.block;

import com.google.common.collect.Maps;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Map;

public class CustomFlowerPotBlock extends FlowerPotBlock {
    private static final Map<Block, Block> POTTED_BY_CONTENT = Maps.newHashMap();

    private final Block content;

    private static final Map<DyeColor, CustomFlowerPotBlock> ITEM_BY_COLOR = Maps.newEnumMap(DyeColor.class);
    private final DyeColor dyeColor;

    public CustomFlowerPotBlock(DyeColor dyeColor, Block block, Properties properties) {
        super(block, properties);
        this.dyeColor = dyeColor;
        this.content = block;
        ITEM_BY_COLOR.put(dyeColor, this);
        POTTED_BY_CONTENT.put(block, this);

    }

    public DyeColor getDyeColor() {
        return this.dyeColor;
    }

    public static CustomFlowerPotBlock byColour(DyeColor dyeColor) {
        return ITEM_BY_COLOR.get(dyeColor);
    }

    private boolean isEmpty() {
        return this.content == Blocks.AIR;
    }



    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        boolean bl2;
        ItemStack itemStack = player.getItemInHand(interactionHand);
        Item item = itemStack.getItem();
        BlockState blockState2 = (item instanceof BlockItem ? POTTED_BY_CONTENT.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).defaultBlockState();
        boolean bl = blockState2.is(Blocks.AIR);
        if (bl != (bl2 = this.isEmpty())) {
            if (bl2) {
                level.setBlock(blockPos, blockState2, 3);
                //level.setBlock(blockPos, KekeBlocks.getDyedFlowerPot(DyeColor.BLUE).defaultBlockState(), 3);
                player.awardStat(Stats.POT_FLOWER);
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
            } else {
                ItemStack itemStack2 = new ItemStack(this.content);
                if (itemStack.isEmpty()) {
                    player.setItemInHand(interactionHand, itemStack2);
                } else if (!player.addItem(itemStack2)) {
                    player.drop(itemStack2, false);
                }
                level.setBlock(blockPos, KekeBlocks.getDyedFlowerPot(this.getDyeColor()).defaultBlockState(), 3);
            }
            level.gameEvent((Entity)player, GameEvent.BLOCK_CHANGE, blockPos);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.CONSUME;
    }

}
