package com.kekecreations.arts_and_crafts.core.fabric.datagen.server;

import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsTags;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import com.kekecreations.arts_and_crafts.core.fabric.registry.KekeFabricFlammableAndStrippableBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ArtsAndCraftsItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ArtsAndCraftsItemTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        appendPlanks();
        appendLogsThatBurn();
        appendWoodenButtons();
        appendDecoratedPotSherds();
        appendDecoratedPots();
        appendDyes();
    }
    private void appendDyes() {
        for (DyeColor colours : DyeColor.values()) {
            this.getOrCreateTagBuilder(ArtsAndCraftsTags.ItemTags.DYES)
                    .setReplace(false)
                    .add(DyeItem.byColor(colours));
        }
    }
    private void appendDecoratedPots() {
        for (DyeColor colours : DyeColor.values()) {
            this.getOrCreateTagBuilder(ArtsAndCraftsTags.ItemTags.DECORATED_POTS)
                    .setReplace(false)
                    .add(Items.DECORATED_POT)
                    .add(KekeItems.getDyedDecoratedPotBlockItem(colours));
        }
    }
    private void appendDecoratedPotSherds() {
        this.getOrCreateTagBuilder(ItemTags.DECORATED_POT_SHERDS)
                .setReplace(false)
                .add(KekeItems.ROLL_POTTERY_SHERD.get())
                .add(KekeItems.RUINED_POTTERY_SHERD.get())
                .add(KekeItems.FINALE_POTTERY_SHERD.get())
                .add(KekeItems.GATEWAY_POTTERY_SHERD.get());
    }

    private void appendPlanks() {
        this.getOrCreateTagBuilder(ItemTags.PLANKS)
                .setReplace(false)
                .add(KekeBlocks.CORK_PLANKS.get().asItem());
    }
    private void appendWoodenButtons() {
        this.getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                .setReplace(false)
                .add(KekeBlocks.CORK_BUTTON.get().asItem());
    }
    private void appendLogsThatBurn() {
        this.getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .setReplace(false)
                .add(KekeBlocks.CORK_LOG.get().asItem())
                .add(KekeBlocks.STRIPPED_CORK_LOG.get().asItem())
                .add(KekeBlocks.CORK_WOOD.get().asItem())
                .add(KekeBlocks.STRIPPED_CORK_WOOD.get().asItem());
    }
}
