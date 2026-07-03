package com.kekecreations.arts_and_crafts.common.entity;

import com.kekecreations.arts_and_crafts.core.registry.ACEntityTypes;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.RandomizableContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.ticks.ContainerSingleItem;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DyedDecoratedPotBlockEntity extends BlockEntity implements RandomizableContainer, ContainerSingleItem.BlockContainerSingleItem {

    private int dyeColor;
    public static final String TAG_SHERDS = "sherds";
    public static final String TAG_ITEM = "item";
    public static final int EVENT_POT_WOBBLES = 1;
    public long wobbleStartedAtTick;
    @Nullable
    public DyedDecoratedPotBlockEntity.WobbleStyle lastWobbleStyle;
    private PotDecorations decorations;
    private ItemStack item;
    @Nullable
    protected ResourceKey<LootTable> lootTable;
    protected long lootTableSeed;


    public DyedDecoratedPotBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ACEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get(), blockPos, blockState);
        this.item = ItemStack.EMPTY;
        this.decorations = PotDecorations.EMPTY;
        this.dyeColor = DyeColor.BLACK.getId();
    }

    public DyeColor getDyeColor() {
        return DyeColor.byId(this.dyeColor);
    }

    public void setDyeColor(int value) {
        this.dyeColor = value;
    }

    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        if (!this.decorations.equals(PotDecorations.EMPTY)) {
            output.store("sherds", PotDecorations.CODEC, this.decorations);
        }

        if (!this.trySaveLootTable(output) && !this.item.isEmpty()) {
            output.store("item", ItemStack.CODEC, this.item);
        }

    }

    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.decorations = (PotDecorations)input.read("sherds", PotDecorations.CODEC).orElse(PotDecorations.EMPTY);
        if (!this.tryLoadLootTable(input)) {
            this.item = (ItemStack)input.read("item", ItemStack.CODEC).orElse(ItemStack.EMPTY);
        } else {
            this.item = ItemStack.EMPTY;
        }

    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        return this.saveCustomOnly(provider);
    }

    public Direction getDirection() {
        return (Direction)this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
    }

    public PotDecorations getDecorations() {
        return this.decorations;
    }

    public void setDecoration(PotDecorations decorations) {
        this.decorations = decorations;
    }



    public void setFromItem(ItemStack itemStack) {
        this.applyComponentsFromItemStack(itemStack);
    }

    public ItemStack getPotAsItem(DyeColor dyeColor) {
        ItemStack itemStack = ACItems.getDyedDecoratedPotBlockItem(dyeColor).getDefaultInstance();
        itemStack.applyComponents(this.collectComponents());
        return itemStack;
    }

    public static ItemStack createDecoratedPotItem(PotDecorations potDecorations) {
        ItemStack itemStack = Items.DECORATED_POT.getDefaultInstance();
        itemStack.set(DataComponents.POT_DECORATIONS, potDecorations);
        return itemStack;
    }

    @Nullable
    public ResourceKey<LootTable> getLootTable() {
        return this.lootTable;
    }

    public void setLootTable(@Nullable ResourceKey<LootTable> resourceKey) {
        this.lootTable = resourceKey;
    }

    public long getLootTableSeed() {
        return this.lootTableSeed;
    }

    public void setLootTableSeed(long l) {
        this.lootTableSeed = l;
    }

    protected void collectImplicitComponents(DataComponentMap.Builder builder) {
        super.collectImplicitComponents(builder);
        builder.set(DataComponents.POT_DECORATIONS, this.decorations);
        builder.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(List.of(this.item)));
    }

    protected void applyImplicitComponents(DataComponentGetter dataComponentInput) {
        super.applyImplicitComponents(dataComponentInput);
        this.decorations = (PotDecorations)dataComponentInput.getOrDefault(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY);
        this.item = ((ItemContainerContents)dataComponentInput.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY)).copyOne();
    }

    public void removeComponentsFromTag(ValueOutput output) {
        super.removeComponentsFromTag(output);
        output.discard("sherds");
        output.discard("item");
    }

    public ItemStack getTheItem() {
        this.unpackLootTable((Player)null);
        return this.item;
    }

    public ItemStack splitTheItem(int i) {
        this.unpackLootTable((Player)null);
        ItemStack itemStack = this.item.split(i);
        if (this.item.isEmpty()) {
            this.item = ItemStack.EMPTY;
        }

        return itemStack;
    }

    public void setTheItem(ItemStack itemStack) {
        this.unpackLootTable((Player)null);
        this.item = itemStack;
    }

    public BlockEntity getContainerBlockEntity() {
        return this;
    }

    public void wobble(WobbleStyle wobbleStyle) {
        if (this.level != null && !this.level.isClientSide()) {
            this.level.blockEvent(this.getBlockPos(), this.getBlockState().getBlock(), 1, wobbleStyle.ordinal());
        }
    }

    public boolean triggerEvent(int i, int j) {
        if (this.level != null && i == 1 && j >= 0 && j < WobbleStyle.values().length) {
            this.wobbleStartedAtTick = this.level.getGameTime();
            this.lastWobbleStyle = WobbleStyle.values()[j];
            return true;
        } else {
            return super.triggerEvent(i, j);
        }
    }

    public static enum WobbleStyle {
        POSITIVE(7),
        NEGATIVE(10);

        public final int duration;

        private WobbleStyle(final int j) {
            this.duration = j;
        }
    }
}