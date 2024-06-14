package com.kekecreations.arts_and_crafts.core.forge.datagen.server;

import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsTags;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ArtsAndCraftsItemTagsProvider extends ItemTagsProvider {


    public ArtsAndCraftsItemTagsProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        appendPlanks();
        appendLogsThatBurn();
        appendWoodenButtons();
        appendWoodenSlabs();
        appendWoodenDoors();
        appendWoodenFences();
        appendWoodenStairs();
        appendWoodenPressurePlates();
        appendWoodenTrapdoors();
        appendDecoratedPotSherds();
        appendDecoratedPots();
        appendDyes();
        appendChalkSticks();
        appendBoats();
        appendChestBoats();
        appendWoolCarpets();
        appendPaintbrushes();
        appendSigns();
        appendHangingSigns();
        appendSaplings();
        appendFenceGates();
    }
    private void appendFenceGates() {
        this.tag(ItemTags.FENCE_GATES)
                .add(ACBlocks.CORK_FENCE_GATE.get().asItem());
    }
    private void appendWoodenSlabs() {
        this.tag(ItemTags.WOODEN_SLABS)
                .add(ACBlocks.CORK_SLAB.get().asItem());
    }
    private void appendWoodenDoors() {
        this.tag(ItemTags.WOODEN_DOORS)
                .add(ACBlocks.CORK_DOOR.get().asItem());
    }
    private void appendWoodenFences() {
        this.tag(ItemTags.WOODEN_FENCES)
                .add(ACBlocks.CORK_FENCE.get().asItem());
    }
    private void appendWoodenStairs() {
        this.tag(ItemTags.WOODEN_STAIRS)
                .add(ACBlocks.CORK_STAIRS.get().asItem());
    }
    private void appendWoodenPressurePlates() {
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ACBlocks.CORK_PRESSURE_PLATE.get().asItem());
    }
    private void appendWoodenTrapdoors() {
        this.tag(ItemTags.WOODEN_TRAPDOORS)
                .add(ACBlocks.CORK_TRAPDOOR.get().asItem());
    }
    private void appendSigns() {
        this.tag(ItemTags.SIGNS)
                .add(ACItems.CORK_SIGN.get());
    }
    private void appendHangingSigns() {
        this.tag(ItemTags.HANGING_SIGNS)
                .add(ACItems.CORK_HANGING_SIGN.get());
    }
    private void appendSaplings() {
        this.tag(ItemTags.SAPLINGS)
                .add(ACBlocks.CORK_SAPLING.get().asItem());
    }
    private void appendPaintbrushes() {
        for (DyeColor colours : DyeColor.values()) {
            this.tag(ArtsAndCraftsTags.ItemTags.PAINTBRUSHES)
                    .add(ACItems.getPaintBrush(colours.getId()));
        }
        this.tag(ArtsAndCraftsTags.ItemTags.PAINTBRUSHES)
                .add(ACItems.BLEACHDEW_PAINTBRUSH.get());
    }

    private void appendWoolCarpets() {
        this.tag(ItemTags.WOOL_CARPETS)
                .add(ACBlocks.BLEACHED_CARPET.get().asItem());
    }
    private void appendBoats() {
        this.tag(ItemTags.BOATS)
                .add(ACItems.CORK_BOAT.get());
    }
    private void appendChestBoats() {
        this.tag(ItemTags.CHEST_BOATS)
                .add(ACItems.CORK_CHEST_BOAT.get());
    }

    private void appendDyes() {
        for (DyeColor colours : DyeColor.values()) {
            this.tag(ArtsAndCraftsTags.ItemTags.DYES)
                    .add(DyeItem.byColor(colours));
        }
    }
    private void appendChalkSticks() {
        for (DyeColor colours : DyeColor.values()) {
            this.tag(ArtsAndCraftsTags.ItemTags.CHALK_STICKS)
                    .add(ACItems.getChalkStick(colours.getId()));
        }
        this.tag(ArtsAndCraftsTags.ItemTags.CHALK_STICKS)
                .add(ACItems.BLEACHED_CHALK_STICK.get());
    }
    private void appendDecoratedPots() {
        for (DyeColor colours : DyeColor.values()) {
            this.tag(ArtsAndCraftsTags.ItemTags.DECORATED_POTS)
                    .add(Items.DECORATED_POT)
                    .add(ACItems.getDyedDecoratedPotBlockItem(colours));
        }
    }
    private void appendDecoratedPotSherds() {
        this.tag(ItemTags.DECORATED_POT_SHERDS)
                .add(ACItems.ROLL_POTTERY_SHERD.get())
                .add(ACItems.RUINED_POTTERY_SHERD.get())
                .add(ACItems.FINALE_POTTERY_SHERD.get())
                .add(ACItems.GATEWAY_POTTERY_SHERD.get())
                .add(ACItems.POTTERY_SHERD.get());
    }

    private void appendPlanks() {
        this.tag(ItemTags.PLANKS)
                .add(ACBlocks.CORK_PLANKS.get().asItem());
    }
    private void appendWoodenButtons() {
        this.tag(ItemTags.WOODEN_BUTTONS)
                .add(ACBlocks.CORK_BUTTON.get().asItem());
    }
    private void appendLogsThatBurn() {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ACBlocks.CORK_LOG.get().asItem())
                .add(ACBlocks.STRIPPED_CORK_LOG.get().asItem())
                .add(ACBlocks.CORK_WOOD.get().asItem())
                .add(ACBlocks.STRIPPED_CORK_WOOD.get().asItem());
    }
}
