package com.kekecreations.arts_and_crafts.client.renderer.bewlr;

import com.kekecreations.arts_and_crafts.common.block.ACBedBlock;
import com.kekecreations.arts_and_crafts.common.entity.ACBedBlockEntity;
import com.kekecreations.arts_and_crafts.common.entity.DyedDecoratedPotBlockEntity;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
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

public class ArtsAndCraftsBEWLR extends BlockEntityWithoutLevelRenderer implements ResourceManagerReloadListener {

    private final ACBedBlockEntity bed;
    private DyedDecoratedPotBlockEntity dyedDecoratedPot;
    public ArtsAndCraftsBEWLR() {
        super(null, null);
        for (DyeColor colours : DyeColor.values()) {
            this.dyedDecoratedPot = new DyedDecoratedPotBlockEntity(BlockPos.ZERO, ACBlocks.getDyedDecoratedPot(colours.getId()).defaultBlockState());
        }
        this.bed = new ACBedBlockEntity(BlockPos.ZERO, ACBlocks.BLEACHED_BED.get().defaultBlockState());
    }

    public void renderByItem(ItemStack itemStack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        BlockEntityRenderDispatcher blockEntityRenderDispatcher = Minecraft.getInstance().getBlockEntityRenderDispatcher();
        Item item = itemStack.getItem();
        if (item instanceof BlockItem) {
            Block block = ((BlockItem) item).getBlock();
            BlockState blockState = block.defaultBlockState();
            Object blockEntity = null;
            for (DyeColor colours : DyeColor.values()) {
                if (blockState.is(ACBlocks.getDyedDecoratedPot(colours.getId()))) {
                    this.dyedDecoratedPot.setFromItem(itemStack);
                    this.dyedDecoratedPot.setDyeColor(colours.getId());
                    blockEntity = this.dyedDecoratedPot;
                }
            }
            if (blockState.is(ACBlocks.BLEACHED_BED.get())) {
                this.bed.setColor(((ACBedBlock)blockState.getBlock()).getColor());
                this.bed.setColor(DyeColor.WHITE);
                blockEntity = this.bed;
            }
            blockEntityRenderDispatcher.renderItem((BlockEntity)blockEntity, poseStack, multiBufferSource, i, j);
        }
    }
}
