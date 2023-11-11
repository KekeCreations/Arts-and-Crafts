package com.kekecreations.arts_and_crafts.fabric.core.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ArtsAndCraftsBlockTagGenerator extends FabricTagProvider.BlockTagProvider {


    public ArtsAndCraftsBlockTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        appendPickaxes();
    }
    private void appendPickaxes() {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .setReplace(false)
                .add(KekeBlocks.BLACK_CHALK.get())
                .add(KekeBlocks.BLUE_CHALK.get())
                .add(KekeBlocks.BROWN_CHALK.get())
                .add(KekeBlocks.WHITE_CHALK.get())
                .add(KekeBlocks.LIGHT_BLUE_CHALK.get())
                .add(KekeBlocks.GRAY_CHALK.get())
                .add(KekeBlocks.CYAN_CHALK.get())
                .add(KekeBlocks.LIGHT_GRAY_CHALK.get())
                .add(KekeBlocks.GREEN_CHALK.get())
                .add(KekeBlocks.LIME_CHALK.get())
                .add(KekeBlocks.MAGENTA_CHALK.get())
                .add(KekeBlocks.ORANGE_CHALK.get())
                .add(KekeBlocks.PINK_CHALK.get())
                .add(KekeBlocks.PURPLE_CHALK.get())
                .add(KekeBlocks.RED_CHALK.get())
                .add(KekeBlocks.YELLOW_CHALK.get());
    }
}
