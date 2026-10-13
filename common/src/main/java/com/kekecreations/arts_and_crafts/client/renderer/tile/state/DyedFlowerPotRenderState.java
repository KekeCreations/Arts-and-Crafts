package com.kekecreations.arts_and_crafts.client.renderer.tile.state;

import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class DyedFlowerPotRenderState extends BlockEntityRenderState {
    public Item storedPlant;
    public BlockModelRenderState displayBlock = new BlockModelRenderState();


    public DyedFlowerPotRenderState() {
        this.storedPlant = Items.AIR;
    }
}
