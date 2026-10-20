package com.kekecreations.arts_and_crafts.common.entity;

import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class DyedFlowerPotBlockEntity extends BlockEntity {

    private ItemStack storedPlant = Items.AIR.getDefaultInstance();

    public static final Codec<Item> CODEC = BuiltInRegistries.ITEM
            .byNameCodec();


    public DyedFlowerPotBlockEntity(BlockPos $$1, BlockState $$2) {
        super(ACEntityTypes.CUSTOM_FLOWER_POT_BLOCK_ENTITY.get(), $$1, $$2);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.saveAdditional(tag, provider);
        if (!this.storedPlant.isEmpty()) {
            tag.put("plant", this.storedPlant.save(provider));
        }
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag tag, HolderLookup.@NotNull Provider provider) {
        super.loadAdditional(tag, provider);
        if (tag.contains("plant", 10)) {
            storedPlant = ItemStack.parse(provider, tag.getCompound("plant")).orElse(ItemStack.EMPTY);
        }

    }

    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return this.saveCustomOnly(pRegistries);
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }


    public void setStoredPlant(ItemStack storedPlant) {
        this.storedPlant = storedPlant;
        this.setChanged();
    }

    public void resetStoredPlant() {
        this.storedPlant = Items.AIR.getDefaultInstance();
        this.setChanged();
    }

    public ItemStack getStoredPlant() {
        return storedPlant;
    }
}
