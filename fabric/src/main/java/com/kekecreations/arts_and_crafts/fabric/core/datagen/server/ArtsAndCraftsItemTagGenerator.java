package com.kekecreations.arts_and_crafts.fabric.core.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

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
