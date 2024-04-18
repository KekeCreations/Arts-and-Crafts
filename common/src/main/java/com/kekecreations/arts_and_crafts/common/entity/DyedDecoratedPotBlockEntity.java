package com.kekecreations.arts_and_crafts.common.entity;

import com.kekecreations.arts_and_crafts.core.registry.KekeEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class DyedDecoratedPotBlockEntity extends BlockEntity {
    public static final String TAG_SHERDS = "sherds";
    private DecoratedPotBlockEntity.Decorations decorations;

    private int dyeColor;


    public DyedDecoratedPotBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(KekeEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get(), blockPos, blockState);
        this.decorations = DecoratedPotBlockEntity.Decorations.EMPTY;
        this.dyeColor = DyeColor.BLACK.getId();
    }

    public DyeColor getDyeColor() {
        return DyeColor.byId(this.dyeColor);
    }

    public void setDyeColor(int value) {
        this.dyeColor = value;
    }

    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        this.decorations.save(compoundTag);
        compoundTag.putInt("colour", this.dyeColor);

    }

    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.decorations = DecoratedPotBlockEntity.Decorations.load(compoundTag);
        this.dyeColor = compoundTag.getInt("colour");
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata();
    }

    public Direction getDirection() {
        return (Direction)this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
    }

    public DecoratedPotBlockEntity.Decorations getDecorations() {
        return this.decorations;
    }

    public void setDecoration(DecoratedPotBlockEntity.Decorations decorations) {
        this.decorations = decorations;
    }



    public void setFromItem(ItemStack itemStack) {
        this.decorations = DecoratedPotBlockEntity.Decorations.load(BlockItem.getBlockEntityData(itemStack));
    }
}