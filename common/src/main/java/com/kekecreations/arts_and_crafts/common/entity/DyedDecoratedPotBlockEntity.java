package com.kekecreations.arts_and_crafts.common.entity;

import com.kekecreations.arts_and_crafts.core.registry.KekeEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.RandomizableContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
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
    public DecoratedPotBlockEntity.WobbleStyle lastWobbleStyle;
    private PotDecorations decorations;
    private ItemStack item;
    @Nullable
    protected ResourceKey<LootTable> lootTable;
    protected long lootTableSeed;


    public DyedDecoratedPotBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(KekeEntityTypes.CUSTOM_DECORATED_POT_BLOCK_ENTITY.get(), blockPos, blockState);
        this.decorations = PotDecorations.EMPTY;
        this.dyeColor = DyeColor.BLACK.getId();
    }

    public DyeColor getDyeColor() {
        return DyeColor.byId(this.dyeColor);
    }

    public void setDyeColor(int value) {
        this.dyeColor = value;
    }

    protected void saveAdditional(CompoundTag $$0, HolderLookup.Provider $$1) {
        super.saveAdditional($$0, $$1);
        this.decorations.save($$0);
        if (!this.trySaveLootTable($$0) && !this.item.isEmpty()) {
            $$0.put("item", this.item.save($$1));
        }

    }

    protected void loadAdditional(CompoundTag $$0, HolderLookup.Provider $$1) {
        super.loadAdditional($$0, $$1);
        this.decorations = PotDecorations.load($$0);
        if (!this.tryLoadLootTable($$0)) {
            if ($$0.contains("item", 10)) {
                this.item = (ItemStack)ItemStack.parse($$1, $$0.getCompound("item")).orElse(ItemStack.EMPTY);
            } else {
                this.item = ItemStack.EMPTY;
            }
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

    public ItemStack getPotAsItem() {
        ItemStack itemStack = Items.DECORATED_POT.getDefaultInstance();
        itemStack.applyComponents(this.collectComponents());
        return itemStack;
    }

    public static ItemStack createDecoratedPotItem(PotDecorations potDecorations) {
        ItemStack itemStack = Items.DECORATED_POT.getDefaultInstance();
        itemStack.set(DataComponents.POT_DECORATIONS, potDecorations);
        return itemStack;
    }

    @org.jetbrains.annotations.Nullable
    public ResourceKey<LootTable> getLootTable() {
        return this.lootTable;
    }

    public void setLootTable(@org.jetbrains.annotations.Nullable ResourceKey<LootTable> resourceKey) {
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

    protected void applyImplicitComponents(BlockEntity.DataComponentInput dataComponentInput) {
        super.applyImplicitComponents(dataComponentInput);
        this.decorations = (PotDecorations)dataComponentInput.getOrDefault(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY);
        this.item = ((ItemContainerContents)dataComponentInput.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY)).copyOne();
    }

    public void removeComponentsFromTag(CompoundTag compoundTag) {
        super.removeComponentsFromTag(compoundTag);
        compoundTag.remove("sherds");
        compoundTag.remove("item");
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

    public void wobble(DecoratedPotBlockEntity.WobbleStyle wobbleStyle) {
        if (this.level != null && !this.level.isClientSide()) {
            this.level.blockEvent(this.getBlockPos(), this.getBlockState().getBlock(), 1, wobbleStyle.ordinal());
        }
    }

    public boolean triggerEvent(int i, int j) {
        if (this.level != null && i == 1 && j >= 0 && j < DecoratedPotBlockEntity.WobbleStyle.values().length) {
            this.wobbleStartedAtTick = this.level.getGameTime();
            this.lastWobbleStyle = DecoratedPotBlockEntity.WobbleStyle.values()[j];
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