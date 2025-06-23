package com.kekecreations.arts_and_crafts.core.mixin;

import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.jinxedlib.common.block.FlammableRotatedPillarBlock;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.spongepowered.asm.mixin.Mixin;

import javax.annotation.Nullable;

@Mixin(FlammableRotatedPillarBlock.class)
public class FlammableRotatedPillarBlockMixin extends RotatedPillarBlock {

    public FlammableRotatedPillarBlockMixin(Properties p_55926_) {
        super(p_55926_);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(ACBlocks.CORK_LOG.get())) {
                return ACBlocks.STRIPPED_CORK_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(ACBlocks.CORK_WOOD.get())) {
                return ACBlocks.STRIPPED_CORK_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
