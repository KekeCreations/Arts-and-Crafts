package com.kekecreations.arts_and_crafts.fabric.core.datagen.client;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;

public class ArtsAndCraftsModelProvider extends FabricModelProvider {
    public ArtsAndCraftsModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.BLUE_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/blue_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.BLACK_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/black_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.BROWN_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/brown_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.WHITE_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/white_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.CREAM_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/cream_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.LIGHT_BLUE_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/light_blue_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.CRIMSON_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/crimson_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.CYAN_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/cyan_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.GRAY_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/gray_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.LIGHT_GRAY_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/light_gray_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.GREEN_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/green_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.LIME_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/lime_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.MAGENTA_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/magenta_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.OLIVE_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/olive_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.ORANGE_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/orange_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.PINE_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/pine_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.PINK_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/pink_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.PURPLE_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/purple_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.RED_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/red_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.TAN_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/tan_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.TURQUOISE_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/turquoise_chalk")), ModelTemplates.CUBE_ALL);
        blockStateModelGenerator.createTrivialBlock(KekeBlocks.YELLOW_CHALK.get(), TextureMapping.cube(new ResourceLocation(ArtsAndCrafts.MOD_ID, "block/chalk/yellow_chalk")), ModelTemplates.CUBE_ALL);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

    }
}
