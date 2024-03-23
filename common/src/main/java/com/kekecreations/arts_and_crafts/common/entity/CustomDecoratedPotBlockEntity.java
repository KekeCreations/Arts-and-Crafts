package com.kekecreations.arts_and_crafts.common.entity;

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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class CustomDecoratedPotBlockEntity extends BlockEntity {
    public static final String TAG_SHERDS = "sherds";
    private CustomDecoratedPotBlockEntity.Decorations decorations;

    private int dyeColor;


    public CustomDecoratedPotBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(KekeEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get(), blockPos, blockState);
        this.decorations = CustomDecoratedPotBlockEntity.Decorations.EMPTY;
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
        this.decorations = CustomDecoratedPotBlockEntity.Decorations.load(compoundTag);
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

    public CustomDecoratedPotBlockEntity.Decorations getDecorations() {
        return this.decorations;
    }

    public void setFromItem(ItemStack itemStack) {
        this.decorations = CustomDecoratedPotBlockEntity.Decorations.load(BlockItem.getBlockEntityData(itemStack));
    }

    public static record Decorations(Item back, Item left, Item right, Item front) {
        public static final CustomDecoratedPotBlockEntity.Decorations EMPTY;

        public Decorations(Item back, Item left, Item right, Item front) {
            this.back = back;
            this.left = left;
            this.right = right;
            this.front = front;
        }

        public CompoundTag save(CompoundTag compoundTag) {
            ListTag listTag = new ListTag();
            this.sorted().forEach((item) -> {
                listTag.add(StringTag.valueOf(BuiltInRegistries.ITEM.getKey(item).toString()));
            });
            compoundTag.put("sherds", listTag);
            return compoundTag;
        }

        public Stream<Item> sorted() {
            return Stream.of(this.back, this.left, this.right, this.front);
        }

        public static CustomDecoratedPotBlockEntity.Decorations load(@Nullable CompoundTag compoundTag) {
            if (compoundTag != null && compoundTag.contains("sherds", 9)) {
                ListTag listTag = compoundTag.getList("sherds", 8);
                return new CustomDecoratedPotBlockEntity.Decorations(itemFromTag(listTag, 0), itemFromTag(listTag, 1), itemFromTag(listTag, 2), itemFromTag(listTag, 3));
            } else {
                return EMPTY;
            }
        }

        private static Item itemFromTag(ListTag listTag, int i) {
            if (i >= listTag.size()) {
                return Items.BRICK;
            } else {
                Tag tag = listTag.get(i);
                return (Item)BuiltInRegistries.ITEM.get(new ResourceLocation(tag.getAsString()));
            }
        }

        public Item back() {
            return this.back;
        }

        public Item left() {
            return this.left;
        }

        public Item right() {
            return this.right;
        }

        public Item front() {
            return this.front;
        }

        static {
            EMPTY = new CustomDecoratedPotBlockEntity.Decorations(Items.BRICK, Items.BRICK, Items.BRICK, Items.BRICK);
        }
    }
}