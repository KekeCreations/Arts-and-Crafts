package com.kekecreations.arts_and_crafts.common.entity;

import com.kekecreations.arts_and_crafts.common.block.DyedDecoratedPotBlock;
import com.kekecreations.arts_and_crafts.core.registry.KekeEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

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