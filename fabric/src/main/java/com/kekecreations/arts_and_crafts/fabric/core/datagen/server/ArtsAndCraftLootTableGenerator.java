package com.kekecreations.arts_and_crafts.fabric.core.datagen.server;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ArtsAndCraftLootTableGenerator extends FabricBlockLootTableProvider {

    public ArtsAndCraftLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        chalk();

    }
    private void chalk() {
        dropSelf(KekeBlocks.BLACK_CHALK.get());
        dropSelf(KekeBlocks.BLUE_CHALK.get());
        dropSelf(KekeBlocks.BROWN_CHALK.get());
        dropSelf(KekeBlocks.LIGHT_BLUE_CHALK.get());
        dropSelf(KekeBlocks.GRAY_CHALK.get());
        dropSelf(KekeBlocks.WHITE_CHALK.get());
        dropSelf(KekeBlocks.CYAN_CHALK.get());
        dropSelf(KekeBlocks.GREEN_CHALK.get());
        dropSelf(KekeBlocks.LIGHT_GRAY_CHALK.get());
        dropSelf(KekeBlocks.LIME_CHALK.get());
        dropSelf(KekeBlocks.MAGENTA_CHALK.get());
        dropSelf(KekeBlocks.ORANGE_CHALK.get());
        dropSelf(KekeBlocks.PINK_CHALK.get());
        dropSelf(KekeBlocks.PURPLE_CHALK.get());
        dropSelf(KekeBlocks.RED_CHALK.get());
        dropSelf(KekeBlocks.YELLOW_CHALK.get());
    }
}
