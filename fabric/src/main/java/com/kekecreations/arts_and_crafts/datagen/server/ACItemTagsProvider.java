package com.kekecreations.arts_and_crafts.datagen.server;

import com.kekecreations.arts_and_crafts.core.init.ACTags;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ACItemTagsProvider extends FabricTagProvider.ItemTagProvider {


    public ACItemTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
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
        appendBeds();
        appendWools();

    }

    private void appendDecoratedPots() {
        for (DyeColor colours : DyeColor.values()) {
            this.valueLookupBuilder(ACTags.ItemTags.DECORATED_POTS)
                    .add(Items.DECORATED_POT)
                    .add(ACItems.getDyedDecoratedPotBlockItem(colours));
        }
    }
    private void appendDecoratedPotSherds() {
        this.valueLookupBuilder(ItemTags.DECORATED_POT_SHERDS)
                .add(ACItems.ROLL_POTTERY_SHERD.get())
                .add(ACItems.RUINED_POTTERY_SHERD.get())
                .add(ACItems.FINALE_POTTERY_SHERD.get())
                .add(ACItems.GATEWAY_POTTERY_SHERD.get())
                .add(ACItems.POTTERY_SHERD.get())
                .add(ACItems.SUS_POTTERY_SHERD.get());
    }

    private void appendBeds() {
        this.valueLookupBuilder(ItemTags.BEDS)
                .add(ACBlocks.BLEACHED_BED.get().asItem());
    }

    private void appendWools() {
        this.valueLookupBuilder(ItemTags.WOOL)
                .add(ACBlocks.BLEACHED_WOOL.get().asItem());
    }


    private void appendFenceGates() {
        this.valueLookupBuilder(ItemTags.FENCE_GATES)
                .add(ACBlocks.CORK_FENCE_GATE.get().asItem());
    }
    private void appendWoodenSlabs() {
        this.valueLookupBuilder(ItemTags.WOODEN_SLABS)
                .add(ACBlocks.CORK_SLAB.get().asItem());
    }
    private void appendWoodenDoors() {
        this.valueLookupBuilder(ItemTags.WOODEN_DOORS)
                .add(ACBlocks.CORK_DOOR.get().asItem());
    }
    private void appendWoodenFences() {
        this.valueLookupBuilder(ItemTags.WOODEN_FENCES)
                .add(ACBlocks.CORK_FENCE.get().asItem());
    }
    private void appendWoodenStairs() {
        this.valueLookupBuilder(ItemTags.WOODEN_STAIRS)
                .add(ACBlocks.CORK_STAIRS.get().asItem());
    }
    private void appendWoodenPressurePlates() {
        this.valueLookupBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ACBlocks.CORK_PRESSURE_PLATE.get().asItem());
    }
    private void appendWoodenTrapdoors() {
        this.valueLookupBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(ACBlocks.CORK_TRAPDOOR.get().asItem());
    }
    private void appendSigns() {
        this.valueLookupBuilder(ItemTags.SIGNS)
                .add(ACItems.CORK_SIGN.get());
    }
    private void appendHangingSigns() {
        this.valueLookupBuilder(ItemTags.HANGING_SIGNS)
                .add(ACItems.CORK_HANGING_SIGN.get());
    }
    private void appendSaplings() {
        this.valueLookupBuilder(ItemTags.SAPLINGS)
                .add(ACBlocks.CORK_SAPLING.get().asItem());
    }
    private void appendPaintbrushes() {
        for (DyeColor colours : DyeColor.values()) {
            this.valueLookupBuilder(ACTags.ItemTags.PAINTBRUSHES)
                    .add(ACItems.getPaintBrush(colours.getId()));
        }
        this.valueLookupBuilder(ACTags.ItemTags.PAINTBRUSHES)
                .add(ACItems.BLEACHDEW_PAINTBRUSH.get());
    }

    private void appendWoolCarpets() {
        this.valueLookupBuilder(ItemTags.WOOL_CARPETS)
                .add(ACBlocks.BLEACHED_CARPET.get().asItem());
    }
    private void appendBoats() {
        this.valueLookupBuilder(ItemTags.BOATS)
                .add(ACItems.CORK_BOAT.get());
    }
    private void appendChestBoats() {
        this.valueLookupBuilder(ItemTags.CHEST_BOATS)
                .add(ACItems.CORK_CHEST_BOAT.get());
    }

    private void appendDyes() {
        for (DyeColor colours : DyeColor.values()) {
            this.valueLookupBuilder(ACTags.ItemTags.DYES)
                    .add(DyeItem.byColor(colours));
        }
    }
    private void appendChalkSticks() {
        for (DyeColor colours : DyeColor.values()) {
            this.valueLookupBuilder(ACTags.ItemTags.CHALK_STICKS)
                    .add(ACItems.getChalkStick(colours.getId()));
        }
        this.valueLookupBuilder(ACTags.ItemTags.CHALK_STICKS)
                .add(ACItems.BLEACHED_CHALK_STICK.get());
    }

    private void appendPlanks() {
        this.valueLookupBuilder(ItemTags.PLANKS)
                .add(ACBlocks.CORK_PLANKS.get().asItem());
    }
    private void appendWoodenButtons() {
        this.valueLookupBuilder(ItemTags.WOODEN_BUTTONS)
                .add(ACBlocks.CORK_BUTTON.get().asItem());
    }
    private void appendLogsThatBurn() {
        this.valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ACBlocks.CORK_LOG.get().asItem())
                .add(ACBlocks.STRIPPED_CORK_LOG.get().asItem())
                .add(ACBlocks.CORK_WOOD.get().asItem())
                .add(ACBlocks.STRIPPED_CORK_WOOD.get().asItem());
    }
}
