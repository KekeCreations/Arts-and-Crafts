package com.kekecreations.arts_and_crafts.client.renderer;

import com.kekecreations.arts_and_crafts.common.entity.CustomDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ArtsAndCraftsBlockEntityWithoutLevelRenderer extends BlockEntityWithoutLevelRenderer implements ResourceManagerReloadListener {

    private CustomDecoratedPotBlockEntity dyedDecoratedPot;
    public ArtsAndCraftsBlockEntityWithoutLevelRenderer() {
        super(null, null);
        for (DyeColor colours : DyeColor.values()) {
            this.dyedDecoratedPot = new CustomDecoratedPotBlockEntity(BlockPos.ZERO, KekeBlocks.getDyedDecoratedPot(colours.getId()).defaultBlockState());
        }
    }

    public void renderByItem(ItemStack itemStack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        BlockEntityRenderDispatcher blockEntityRenderDispatcher = Minecraft.getInstance().getBlockEntityRenderDispatcher();
        Item item = itemStack.getItem();
        if (item instanceof BlockItem) {
            Block block = ((BlockItem) item).getBlock();
            BlockState blockState = block.defaultBlockState();
            Object blockEntity = null;
            for (DyeColor colours : DyeColor.values()) {
                if (blockState.is(KekeBlocks.getDyedDecoratedPot(colours.getId()))) {
                    this.dyedDecoratedPot.setFromItem(itemStack);
                    this.dyedDecoratedPot.setDyeColor(colours.getId());
                    blockEntity = this.dyedDecoratedPot;
                }
            }
            blockEntityRenderDispatcher.renderItem((BlockEntity)blockEntity, poseStack, multiBufferSource, i, j);
        }
    }
}
