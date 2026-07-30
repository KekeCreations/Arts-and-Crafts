package com.kekecreations.arts_and_crafts.datagen.client;

import com.kekecreations.arts_and_crafts.common.block.ChalkDustBlock;
import com.kekecreations.arts_and_crafts.common.util.PietraforteColour;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import com.kekecreations.arts_and_crafts.datagen.client.util.ACModelTemplates;
import com.kekecreations.arts_and_crafts.datagen.client.util.ACTextureMapping;
import com.kekecreations.arts_and_crafts.datagen.client.util.ACTextureSlots;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.Objects;

public class ACModelProvider extends FabricModelProvider {

    public ACModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators modelGen) {

        modelGen.family(ACBlocks.GYPSUM.get())
                .stairs(ACBlocks.GYPSUM_STAIRS.get())
                .slab(ACBlocks.GYPSUM_SLAB.get())
                .wall(ACBlocks.GYPSUM_WALL.get());

        modelGen.family(ACBlocks.GYPSUM_BRICKS.get())
                .stairs(ACBlocks.GYPSUM_BRICK_STAIRS.get())
                .slab(ACBlocks.GYPSUM_BRICK_SLAB.get())
                .wall(ACBlocks.GYPSUM_BRICK_WALL.get());

        modelGen.family(ACBlocks.POLISHED_GYPSUM.get())
                .stairs(ACBlocks.POLISHED_GYPSUM_STAIRS.get())
                .slab(ACBlocks.POLISHED_GYPSUM_SLAB.get())
                .wall(ACBlocks.POLISHED_GYPSUM_WALL.get());

        modelGen.woodProvider(ACBlocks.CORK_LOG.get()).log(ACBlocks.CORK_LOG.get()).wood(ACBlocks.CORK_WOOD.get());
        modelGen.woodProvider(ACBlocks.STRIPPED_CORK_LOG.get()).log(ACBlocks.STRIPPED_CORK_LOG.get()).wood(ACBlocks.STRIPPED_CORK_WOOD.get());
        modelGen.createTrivialCube(ACBlocks.CORK.get());
        modelGen.createTrivialCube(ACBlocks.SMOOTH_CORK.get());

        modelGen.family(ACBlocks.CORK_PLANKS.get())
                .stairs(ACBlocks.CORK_STAIRS.get())
                .slab(ACBlocks.CORK_SLAB.get())
                .fence(ACBlocks.CORK_FENCE.get())
                .fenceGate(ACBlocks.CORK_FENCE_GATE.get())
                .button(ACBlocks.CORK_BUTTON.get())
                .pressurePlate(ACBlocks.CORK_PRESSURE_PLATE.get());

        //BLEACHED
        modelGen.createTrivialCube(ACBlocks.BLEACHED_CONCRETE.get());
        modelGen.createTrivialCube(ACBlocks.BLEACHED_WOOL.get());
        modelGen.createTrivialCube(ACBlocks.BLEACHED_CHALK.get());

        //SHINGLES
        modelGen.family(ACBlocks.TERRACOTTA_SHINGLES.get())
                .stairs(ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get())
                .slab(ACBlocks.TERRACOTTA_SHINGLE_SLAB.get())
                .wall(ACBlocks.TERRACOTTA_SHINGLE_WALL.get());

        //SOAPSTONE
        modelGen.family(ACBlocks.SOAPSTONE.get())
                .stairs(ACBlocks.SOAPSTONE_STAIRS.get())
                .slab(ACBlocks.SOAPSTONE_SLAB.get())
                .wall(ACBlocks.SOAPSTONE_WALL.get());

        modelGen.family(ACBlocks.SOAPSTONE_BRICKS.get())
                .stairs(ACBlocks.SOAPSTONE_BRICK_STAIRS.get())
                .slab(ACBlocks.SOAPSTONE_BRICK_SLAB.get())
                .wall(ACBlocks.SOAPSTONE_BRICK_WALL.get());

        modelGen.family(ACBlocks.POLISHED_SOAPSTONE.get())
                .stairs(ACBlocks.POLISHED_SOAPSTONE_STAIRS.get())
                .slab(ACBlocks.POLISHED_SOAPSTONE_SLAB.get())
                .wall(ACBlocks.POLISHED_SOAPSTONE_WALL.get());

        for (PietraforteColour colour : PietraforteColour.values()) {
            modelGen.createAxisAlignedPillarBlock(ACBlocks.getPietrafortePillar(colour), TexturedModel.COLUMN);
            modelGen.createTrivialCube(ACBlocks.getChiseledPietraforte(colour));
            modelGen.family(ACBlocks.getCobbledPietraforte(colour))
                    .stairs(ACBlocks.getCobbledPietraforteStairs(colour))
                    .slab(ACBlocks.getCobbledPietraforteSlab(colour))
                    .wall(ACBlocks.getCobbledPietraforteWall(colour));

            modelGen.family(ACBlocks.getPietraforte(colour))
                    .stairs(ACBlocks.getPietraforteStairs(colour))
                    .slab(ACBlocks.getPietraforteSlab(colour))
                    .wall(ACBlocks.getPietraforteWall(colour));

            modelGen.family(ACBlocks.getPietraforteBricks(colour))
                    .stairs(ACBlocks.getPietraforteBrickStairs(colour))
                    .slab(ACBlocks.getPietraforteBrickSlab(colour))
                    .wall(ACBlocks.getPietraforteBrickWall(colour));

            modelGen.family(ACBlocks.getCutPietraforte(colour))
                    .stairs(ACBlocks.getCutPietraforteStairs(colour))
                    .slab(ACBlocks.getCutPietraforteSlab(colour))
                    .wall(ACBlocks.getCutPietraforteWall(colour));

            modelGen.family(ACBlocks.getSmoothPietraforte(colour))
                    .stairs(ACBlocks.getSmoothPietraforteStairs(colour))
                    .slab(ACBlocks.getSmoothPietraforteSlab(colour))
                    .wall(ACBlocks.getSmoothPietraforteWall(colour));
        }

        for (DyeColor colour : DyeColor.values()) {

            modelGen.createTrivialCube(ACBlocks.getChalk(colour.getId()));
            plasterBlock(ACBlocks.getDyedPlaster(colour.getId()), colour, modelGen);
            chalkDustBlock(ACBlocks.getChalkDust(colour.getId()), colour, modelGen);

            modelGen.family(ACBlocks.getDyedTerracottaShingles(colour.getId()))
                    .stairs(ACBlocks.getDyedTerracottaShingleStairs(colour.getId()))
                    .slab(ACBlocks.getDyedTerracottaShingleSlab(colour.getId()))
                    .wall(ACBlocks.getDyedTerracottaShingleWall(colour.getId()));

            modelGen.family(ACBlocks.getDyedSoapstone(colour.getId()))
                    .stairs(ACBlocks.getDyedSoapstoneStairs(colour.getId()))
                    .slab(ACBlocks.getDyedSoapstoneSlab(colour.getId()))
                    .wall(ACBlocks.getDyedSoapstoneWall(colour.getId()));

            modelGen.family(ACBlocks.getDyedSoapstoneBricks(colour.getId()))
                    .stairs(ACBlocks.getDyedSoapstoneBrickStairs(colour.getId()))
                    .slab(ACBlocks.getDyedSoapstoneBrickSlab(colour.getId()))
                    .wall(ACBlocks.getDyedSoapstoneBrickWall(colour.getId()));

            modelGen.family(ACBlocks.getDyedPolishedSoapstone(colour.getId()))
                    .stairs(ACBlocks.getDyedPolishedSoapstoneStairs(colour.getId()))
                    .slab(ACBlocks.getDyedPolishedSoapstoneSlab(colour.getId()))
                    .wall(ACBlocks.getDyedPolishedSoapstoneWall(colour.getId()));

            modelGen.family(ACBlocks.getDyedMudBricks(colour.getId()))
                    .stairs(ACBlocks.getDyedMudBrickStairs(colour.getId()))
                    .slab(ACBlocks.getDyedMudBrickSlab(colour.getId()))
                    .wall(ACBlocks.getDyedMudBrickWall(colour.getId()));

            createEmptyFlowerPot(ACBlocks.getDyedFlowerPot(colour.getId()), colour, modelGen);

            flowerPotBlock(ACBlocks.getDyedPottedCorkSapling(colour), colour, "cork_sapling", "arts_and_crafts", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedOakSapling(colour), colour, "oak_sapling", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedSpruceSapling(colour), colour, "spruce_sapling", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedBirchSapling(colour), colour, "birch_sapling", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedJungleSapling(colour), colour, "jungle_sapling", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedAcaciaSapling(colour), colour, "acacia_sapling", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedCherrySapling(colour), colour, "cherry_sapling", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedDarkOakSapling(colour), colour, "dark_oak_sapling", "minecraft", modelGen);
            mangrovePropaguleFlowerPotBlock(ACBlocks.getDyedPottedMangrovePropagule(colour), colour,  modelGen);

            flowerPotBlock(ACBlocks.getDyedPottedCrimsonFungus(colour), colour, "crimson_fungus", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedCrimsonRoots(colour), colour, "crimson_roots_pot", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedWarpedFungus(colour), colour, "warped_fungus", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedWarpedRoots(colour), colour, "warped_roots_pot", "minecraft", modelGen);

            tintedFlowerPotBlock(ACBlocks.getDyedPottedFern(colour), colour, "fern", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedDandelion(colour), colour, "dandelion", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedPoppy(colour), colour, "poppy", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedBlueOrchid(colour), colour, "blue_orchid", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedAllium(colour), colour, "allium", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedAzureBluet(colour), colour, "azure_bluet", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedRedTulip(colour), colour, "red_tulip", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedOrangeTulip(colour), colour, "orange_tulip", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedWhiteTulip(colour), colour, "white_tulip", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedPinkTulip(colour), colour, "pink_tulip", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedOxeyeDaisy(colour), colour, "oxeye_daisy", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedCornflower(colour), colour, "cornflower", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedLilyOfTheValley(colour), colour, "lily_of_the_valley", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedWitherRose(colour), colour, "wither_rose", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedRedMushroom(colour), colour, "red_mushroom", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedBrownMushroom(colour), colour, "brown_mushroom", "minecraft", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedDeadBush(colour), colour, "dead_bush", "minecraft", modelGen);
            cactusFlowerPotBlock(ACBlocks.getDyedPottedCactus(colour), colour, modelGen);
            bambooFlowerPotBlock(ACBlocks.getDyedPottedBamboo(colour), colour, modelGen);
            azaleaFlowerPotBlock(ACBlocks.getDyedPottedAzalea(colour), colour, "potted_azalea_bush", modelGen);
            azaleaFlowerPotBlock(ACBlocks.getDyedPottedFloweringAzalea(colour), colour, "potted_flowering_azalea_bush", modelGen);
            flowerPotBlock(ACBlocks.getDyedPottedTorchFlower(colour), colour, "torchflower", "minecraft", modelGen);
        }

    }

    @Override
    public void generateItemModels(ItemModelGenerators modelGen) {

        for (DyeColor colour : DyeColor.values()) {
            modelGen.generateFlatItem(ACItems.getChalkStick(colour.getId()).asItem(), ModelTemplates.FLAT_HANDHELD_ITEM);
            modelGen.generateFlatItem(ACBlocks.getDyedFlowerPot(colour.getId()).asItem(), ModelTemplates.FLAT_ITEM);
            //decoratedPotItem(ACItems.getDyedDecoratedPotBlockItem(colours));
            modelGen.generateFlatItem(ACItems.getPaintBrush(colour.getId()).asItem(), ModelTemplates.FLAT_HANDHELD_ITEM);
        }
        modelGen.generateFlatItem(ACItems.BLEACHED_CHALK_STICK.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        modelGen.generateFlatItem(ACItems.CORK_BOAT.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.CORK_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.ROLL_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.RUINED_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.FINALE_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.GATEWAY_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.SUS_POTTERY_SHERD.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.BLEACHDEW_PAINTBRUSH.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        modelGen.generateFlatItem(ACItems.BLEACHDEW.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACBlocks.CORK_DOOR.get().asItem(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACBlocks.CORK_SAPLING.get().asItem(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.CORK_SIGN.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.CORK_HANGING_SIGN.get(), ModelTemplates.FLAT_ITEM);
        modelGen.generateFlatItem(ACItems.LOTUS_PISTILS.get(), ModelTemplates.FLAT_ITEM);

        //bedBlockItem(ACItems.BLEACHED_BED.get());
    }


    public final void plasterBlock(Block plaster, DyeColor colour,  BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACTextureMapping.plasterMappings(colour);
        Identifier resourceLocation = ACModelTemplates.PLASTER.create(plaster, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(createPlasterVariants(plaster, resourceLocation));
    }


    private static BlockModelDefinitionGenerator createPlasterVariants(Block plaster, Identifier identifier) {
        MultiVariant model = BlockModelGenerators.plainVariant(identifier);
        return MultiVariantGenerator.dispatch(plaster)
                .with(PropertyDispatch.initial(BlockStateProperties.FACING)
                        .select(Direction.NORTH, model.with(BlockModelGenerators.Y_ROT_180))
                        .select(Direction.EAST, model.with(BlockModelGenerators.Y_ROT_270))
                        .select(Direction.SOUTH, model)
                        .select(Direction.WEST, model.with(BlockModelGenerators.Y_ROT_90))
                        .select(Direction.UP, model.with(BlockModelGenerators.X_ROT_90))
                        .select(Direction.DOWN, model.with(BlockModelGenerators.X_ROT_270))
                );
    }

    public static ConditionBuilder condition() {
        return BlockModelGenerators.condition();
    }

    public final void chalkDustBlock(Block chalkDust, DyeColor colour,  BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.blockStateOutput.accept(createChalkDustVariants(chalkDust, colour, blockModelGenerators));
    }

    private static BlockModelDefinitionGenerator createChalkDustVariants(Block chalkDust, DyeColor colour, BlockModelGenerators modelGen) {
        TexturedModel.Provider texturedModel = TexturedModel.createDefault(ACTextureMapping::chalkPatternDefaultMappings, ACModelTemplates.CHALK_DUST);

        MultiVariant chalkPattern0 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "dot"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "dot"))
                        ).createWithSuffix(chalkDust, "_dot", modelGen.modelOutput));

        MultiVariant chalkPattern1 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "vertical_line_middle"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "vertical_line_middle"))
                ).createWithSuffix(chalkDust, "_vertical_line_middle", modelGen.modelOutput));

        MultiVariant chalkPattern2 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "rotated_line_middle"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "rotated_line_middle"))
                ).createWithSuffix(chalkDust, "_rotated_line_middle", modelGen.modelOutput));

        MultiVariant chalkPattern3 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "corner_0"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "corner_0"))
                ).createWithSuffix(chalkDust, "_corner_0", modelGen.modelOutput));

        MultiVariant chalkPattern4 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "corner_1"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "corner_1"))
                ).createWithSuffix(chalkDust, "_corner_1", modelGen.modelOutput));

        MultiVariant chalkPattern5 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "corner_2"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "corner_2"))
                ).createWithSuffix(chalkDust, "_corner_2", modelGen.modelOutput));

        MultiVariant chalkPattern6 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "corner_3"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "corner_3"))
                ).createWithSuffix(chalkDust, "_corner_3", modelGen.modelOutput));

        MultiVariant chalkPattern7 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "t_cross_0"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "t_cross_0"))
                ).createWithSuffix(chalkDust, "_t_cross_0", modelGen.modelOutput));

        MultiVariant chalkPattern8 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "t_cross_1"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "t_cross_1"))
                ).createWithSuffix(chalkDust, "_t_cross_1", modelGen.modelOutput));

        MultiVariant chalkPattern9 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "t_cross_2"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "t_cross_2"))
                ).createWithSuffix(chalkDust, "_t_cross_2", modelGen.modelOutput));

        MultiVariant chalkPattern10 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "t_cross_3"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "t_cross_3"))
                ).createWithSuffix(chalkDust, "_t_cross_3", modelGen.modelOutput));

        MultiVariant chalkPattern11 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "plus"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "plus"))
                ).createWithSuffix(chalkDust, "_plus", modelGen.modelOutput));

        MultiVariant chalkPattern12 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "diagonal_line_right"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "diagonal_line_right"))
                ).createWithSuffix(chalkDust, "_diagonal_line_right", modelGen.modelOutput));

        MultiVariant chalkPattern13 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "diagonal_line_left"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "diagonal_line_left"))
                ).createWithSuffix(chalkDust, "_diagonal_line_left", modelGen.modelOutput));

        MultiVariant chalkPattern14 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "x"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "x"))
                ).createWithSuffix(chalkDust, "_x", modelGen.modelOutput));

        MultiVariant chalkPattern15 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "line_edge_0"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "line_edge_0"))
                ).createWithSuffix(chalkDust, "_line_edge_0", modelGen.modelOutput));

        MultiVariant chalkPattern16 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "line_edge_1"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "line_edge_1"))
                ).createWithSuffix(chalkDust, "_line_edge_1", modelGen.modelOutput));

        MultiVariant chalkPattern17 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "line_edge_2"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "line_edge_2"))
                ).createWithSuffix(chalkDust, "_line_edge_2", modelGen.modelOutput));

        MultiVariant chalkPattern18 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "line_edge_3"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "line_edge_3"))
                ).createWithSuffix(chalkDust, "_line_edge_3", modelGen.modelOutput));

        MultiVariant chalkPattern19 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "triangle_0"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "triangle_0"))
                ).createWithSuffix(chalkDust, "_triangle_0", modelGen.modelOutput));

        MultiVariant chalkPattern20 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "triangle_1"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "triangle_1"))
                ).createWithSuffix(chalkDust, "_triangle_1", modelGen.modelOutput));

        MultiVariant chalkPattern21 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "triangle_2"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "triangle_2"))
                ).createWithSuffix(chalkDust, "_triangle_2", modelGen.modelOutput));

        MultiVariant chalkPattern22 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "triangle_3"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "triangle_3"))
                ).createWithSuffix(chalkDust, "_triangle_3", modelGen.modelOutput));

        MultiVariant chalkPattern23 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "circle"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "circle"))
                ).createWithSuffix(chalkDust, "_circle", modelGen.modelOutput));

        MultiVariant chalkPattern24 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "square"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "square"))
                ).createWithSuffix(chalkDust, "_square", modelGen.modelOutput));

        MultiVariant chalkPattern25 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "block_corner_0"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "block_corner_0"))
                ).createWithSuffix(chalkDust, "_block_corner_0", modelGen.modelOutput));

        MultiVariant chalkPattern26 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "block_corner_1"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "block_corner_1"))
                ).createWithSuffix(chalkDust, "_block_corner_1", modelGen.modelOutput));

        MultiVariant chalkPattern27 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "block_corner_2"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "block_corner_2"))
                ).createWithSuffix(chalkDust, "_block_corner_2", modelGen.modelOutput));

        MultiVariant chalkPattern28 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "block_corner_3"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "block_corner_3"))
                ).createWithSuffix(chalkDust, "_block_corner_3", modelGen.modelOutput));

        MultiVariant chalkPattern29 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "arch_0"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "arch_0"))
                ).createWithSuffix(chalkDust, "_arch_0", modelGen.modelOutput));

        MultiVariant chalkPattern30 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "arch_1"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "arch_1"))
                ).createWithSuffix(chalkDust, "_arch_1", modelGen.modelOutput));

        MultiVariant chalkPattern31 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "arch_2"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "arch_2"))
                ).createWithSuffix(chalkDust, "_arch_2", modelGen.modelOutput));

        MultiVariant chalkPattern32 = BlockModelGenerators.plainVariant(texturedModel.get(chalkDust)
                .updateTextures((textureMapping) ->
                        textureMapping.put(TextureSlot.PARTICLE, ACTextureMapping.getChalkPattern(colour, "arch_3"))
                                .put(ACTextureSlots.DUST, ACTextureMapping.getChalkPattern(colour, "arch_3"))
                ).createWithSuffix(chalkDust, "_arch_3", modelGen.modelOutput));


        return MultiVariantGenerator.dispatch(chalkDust)
                .with(PropertyDispatch.initial(ChalkDustBlock.CHALK_DUST_STATES, BlockStateProperties.FACING)
                        //0
                        .select(0, Direction.NORTH, chalkPattern0.with(BlockModelGenerators.Y_ROT_180))
                        .select(0, Direction.EAST, chalkPattern0.with(BlockModelGenerators.Y_ROT_270))
                        .select(0, Direction.SOUTH, chalkPattern0)
                        .select(0, Direction.WEST, chalkPattern0.with(BlockModelGenerators.Y_ROT_90))
                        .select(0, Direction.UP, chalkPattern0.with(BlockModelGenerators.X_ROT_90))
                        .select(0, Direction.DOWN, chalkPattern0.with(BlockModelGenerators.X_ROT_270))
                        //1
                        .select(1, Direction.NORTH, chalkPattern1.with(BlockModelGenerators.Y_ROT_180))
                        .select(1, Direction.EAST, chalkPattern1.with(BlockModelGenerators.Y_ROT_270))
                        .select(1, Direction.SOUTH, chalkPattern1)
                        .select(1, Direction.WEST, chalkPattern1.with(BlockModelGenerators.Y_ROT_90))
                        .select(1, Direction.UP, chalkPattern1.with(BlockModelGenerators.X_ROT_90))
                        .select(1, Direction.DOWN, chalkPattern1.with(BlockModelGenerators.X_ROT_270))
                        //2
                        .select(2, Direction.NORTH, chalkPattern2.with(BlockModelGenerators.Y_ROT_180))
                        .select(2, Direction.EAST, chalkPattern2.with(BlockModelGenerators.Y_ROT_270))
                        .select(2, Direction.SOUTH, chalkPattern2)
                        .select(2, Direction.WEST, chalkPattern2.with(BlockModelGenerators.Y_ROT_90))
                        .select(2, Direction.UP, chalkPattern2.with(BlockModelGenerators.X_ROT_90))
                        .select(2, Direction.DOWN, chalkPattern2.with(BlockModelGenerators.X_ROT_270))
                        //3
                        .select(3, Direction.NORTH, chalkPattern3.with(BlockModelGenerators.Y_ROT_180))
                        .select(3, Direction.EAST, chalkPattern3.with(BlockModelGenerators.Y_ROT_270))
                        .select(3, Direction.SOUTH, chalkPattern3)
                        .select(3, Direction.WEST, chalkPattern3.with(BlockModelGenerators.Y_ROT_90))
                        .select(3, Direction.UP, chalkPattern3.with(BlockModelGenerators.X_ROT_90))
                        .select(3, Direction.DOWN, chalkPattern3.with(BlockModelGenerators.X_ROT_270))
                        //4
                        .select(4, Direction.NORTH, chalkPattern4.with(BlockModelGenerators.Y_ROT_180))
                        .select(4, Direction.EAST, chalkPattern4.with(BlockModelGenerators.Y_ROT_270))
                        .select(4, Direction.SOUTH, chalkPattern4)
                        .select(4, Direction.WEST, chalkPattern4.with(BlockModelGenerators.Y_ROT_90))
                        .select(4, Direction.UP, chalkPattern4.with(BlockModelGenerators.X_ROT_90))
                        .select(4, Direction.DOWN, chalkPattern4.with(BlockModelGenerators.X_ROT_270))
                        //5
                        .select(5, Direction.NORTH, chalkPattern5.with(BlockModelGenerators.Y_ROT_180))
                        .select(5, Direction.EAST, chalkPattern5.with(BlockModelGenerators.Y_ROT_270))
                        .select(5, Direction.SOUTH, chalkPattern5)
                        .select(5, Direction.WEST, chalkPattern5.with(BlockModelGenerators.Y_ROT_90))
                        .select(5, Direction.UP, chalkPattern5.with(BlockModelGenerators.X_ROT_90))
                        .select(5, Direction.DOWN, chalkPattern5.with(BlockModelGenerators.X_ROT_270))
                        //6
                        .select(6, Direction.NORTH, chalkPattern6.with(BlockModelGenerators.Y_ROT_180))
                        .select(6, Direction.EAST, chalkPattern6.with(BlockModelGenerators.Y_ROT_270))
                        .select(6, Direction.SOUTH, chalkPattern6)
                        .select(6, Direction.WEST, chalkPattern6.with(BlockModelGenerators.Y_ROT_90))
                        .select(6, Direction.UP, chalkPattern6.with(BlockModelGenerators.X_ROT_90))
                        .select(6, Direction.DOWN, chalkPattern6.with(BlockModelGenerators.X_ROT_270))
                        //7
                        .select(7, Direction.NORTH, chalkPattern7.with(BlockModelGenerators.Y_ROT_180))
                        .select(7, Direction.EAST, chalkPattern7.with(BlockModelGenerators.Y_ROT_270))
                        .select(7, Direction.SOUTH, chalkPattern7)
                        .select(7, Direction.WEST, chalkPattern7.with(BlockModelGenerators.Y_ROT_90))
                        .select(7, Direction.UP, chalkPattern7.with(BlockModelGenerators.X_ROT_90))
                        .select(7, Direction.DOWN, chalkPattern7.with(BlockModelGenerators.X_ROT_270))
                        //8
                        .select(8, Direction.NORTH, chalkPattern8.with(BlockModelGenerators.Y_ROT_180))
                        .select(8, Direction.EAST, chalkPattern8.with(BlockModelGenerators.Y_ROT_270))
                        .select(8, Direction.SOUTH, chalkPattern8)
                        .select(8, Direction.WEST, chalkPattern8.with(BlockModelGenerators.Y_ROT_90))
                        .select(8, Direction.UP, chalkPattern8.with(BlockModelGenerators.X_ROT_90))
                        .select(8, Direction.DOWN, chalkPattern8.with(BlockModelGenerators.X_ROT_270))
                        //9
                        .select(9, Direction.NORTH, chalkPattern9.with(BlockModelGenerators.Y_ROT_180))
                        .select(9, Direction.EAST, chalkPattern9.with(BlockModelGenerators.Y_ROT_270))
                        .select(9, Direction.SOUTH, chalkPattern9)
                        .select(9, Direction.WEST, chalkPattern9.with(BlockModelGenerators.Y_ROT_90))
                        .select(9, Direction.UP, chalkPattern9.with(BlockModelGenerators.X_ROT_90))
                        .select(9, Direction.DOWN, chalkPattern9.with(BlockModelGenerators.X_ROT_270))
                        //10
                        .select(10, Direction.NORTH, chalkPattern10.with(BlockModelGenerators.Y_ROT_180))
                        .select(10, Direction.EAST, chalkPattern10.with(BlockModelGenerators.Y_ROT_270))
                        .select(10, Direction.SOUTH, chalkPattern10)
                        .select(10, Direction.WEST, chalkPattern10.with(BlockModelGenerators.Y_ROT_90))
                        .select(10, Direction.UP, chalkPattern10.with(BlockModelGenerators.X_ROT_90))
                        .select(10, Direction.DOWN, chalkPattern10.with(BlockModelGenerators.X_ROT_270))
                        //11
                        .select(11, Direction.NORTH, chalkPattern11.with(BlockModelGenerators.Y_ROT_180))
                        .select(11, Direction.EAST, chalkPattern11.with(BlockModelGenerators.Y_ROT_270))
                        .select(11, Direction.SOUTH, chalkPattern11)
                        .select(11, Direction.WEST, chalkPattern11.with(BlockModelGenerators.Y_ROT_90))
                        .select(11, Direction.UP, chalkPattern11.with(BlockModelGenerators.X_ROT_90))
                        .select(11, Direction.DOWN, chalkPattern11.with(BlockModelGenerators.X_ROT_270))
                        //12
                        .select(12, Direction.NORTH, chalkPattern12.with(BlockModelGenerators.Y_ROT_180))
                        .select(12, Direction.EAST, chalkPattern12.with(BlockModelGenerators.Y_ROT_270))
                        .select(12, Direction.SOUTH, chalkPattern12)
                        .select(12, Direction.WEST, chalkPattern12.with(BlockModelGenerators.Y_ROT_90))
                        .select(12, Direction.UP, chalkPattern12.with(BlockModelGenerators.X_ROT_90))
                        .select(12, Direction.DOWN, chalkPattern12.with(BlockModelGenerators.X_ROT_270))
                        //13
                        .select(13, Direction.NORTH, chalkPattern13.with(BlockModelGenerators.Y_ROT_180))
                        .select(13, Direction.EAST, chalkPattern13.with(BlockModelGenerators.Y_ROT_270))
                        .select(13, Direction.SOUTH, chalkPattern13)
                        .select(13, Direction.WEST, chalkPattern13.with(BlockModelGenerators.Y_ROT_90))
                        .select(13, Direction.UP, chalkPattern13.with(BlockModelGenerators.X_ROT_90))
                        .select(13, Direction.DOWN, chalkPattern13.with(BlockModelGenerators.X_ROT_270))
                        //14
                        .select(14, Direction.NORTH, chalkPattern14.with(BlockModelGenerators.Y_ROT_180))
                        .select(14, Direction.EAST, chalkPattern14.with(BlockModelGenerators.Y_ROT_270))
                        .select(14, Direction.SOUTH, chalkPattern14)
                        .select(14, Direction.WEST, chalkPattern14.with(BlockModelGenerators.Y_ROT_90))
                        .select(14, Direction.UP, chalkPattern14.with(BlockModelGenerators.X_ROT_90))
                        .select(14, Direction.DOWN, chalkPattern14.with(BlockModelGenerators.X_ROT_270))
                        //15
                        .select(15, Direction.NORTH, chalkPattern15.with(BlockModelGenerators.Y_ROT_180))
                        .select(15, Direction.EAST, chalkPattern15.with(BlockModelGenerators.Y_ROT_270))
                        .select(15, Direction.SOUTH, chalkPattern15)
                        .select(15, Direction.WEST, chalkPattern15.with(BlockModelGenerators.Y_ROT_90))
                        .select(15, Direction.UP, chalkPattern15.with(BlockModelGenerators.X_ROT_90))
                        .select(15, Direction.DOWN, chalkPattern15.with(BlockModelGenerators.X_ROT_270))
                        //16
                        .select(16, Direction.NORTH, chalkPattern16.with(BlockModelGenerators.Y_ROT_180))
                        .select(16, Direction.EAST, chalkPattern16.with(BlockModelGenerators.Y_ROT_270))
                        .select(16, Direction.SOUTH, chalkPattern16)
                        .select(16, Direction.WEST, chalkPattern16.with(BlockModelGenerators.Y_ROT_90))
                        .select(16, Direction.UP, chalkPattern16.with(BlockModelGenerators.X_ROT_90))
                        .select(16, Direction.DOWN, chalkPattern16.with(BlockModelGenerators.X_ROT_270))
                        //17
                        .select(17, Direction.NORTH, chalkPattern17.with(BlockModelGenerators.Y_ROT_180))
                        .select(17, Direction.EAST, chalkPattern17.with(BlockModelGenerators.Y_ROT_270))
                        .select(17, Direction.SOUTH, chalkPattern17)
                        .select(17, Direction.WEST, chalkPattern17.with(BlockModelGenerators.Y_ROT_90))
                        .select(17, Direction.UP, chalkPattern17.with(BlockModelGenerators.X_ROT_90))
                        .select(17, Direction.DOWN, chalkPattern17.with(BlockModelGenerators.X_ROT_270))
                        //18
                        .select(18, Direction.NORTH, chalkPattern18.with(BlockModelGenerators.Y_ROT_180))
                        .select(18, Direction.EAST, chalkPattern18.with(BlockModelGenerators.Y_ROT_270))
                        .select(18, Direction.SOUTH, chalkPattern18)
                        .select(18, Direction.WEST, chalkPattern18.with(BlockModelGenerators.Y_ROT_90))
                        .select(18, Direction.UP, chalkPattern18.with(BlockModelGenerators.X_ROT_90))
                        .select(18, Direction.DOWN, chalkPattern18.with(BlockModelGenerators.X_ROT_270))
                        //19
                        .select(19, Direction.NORTH, chalkPattern19.with(BlockModelGenerators.Y_ROT_180))
                        .select(19, Direction.EAST, chalkPattern19.with(BlockModelGenerators.Y_ROT_270))
                        .select(19, Direction.SOUTH, chalkPattern19)
                        .select(19, Direction.WEST, chalkPattern19.with(BlockModelGenerators.Y_ROT_90))
                        .select(19, Direction.UP, chalkPattern19.with(BlockModelGenerators.X_ROT_90))
                        .select(19, Direction.DOWN, chalkPattern19.with(BlockModelGenerators.X_ROT_270))
                        //20
                        .select(20, Direction.NORTH, chalkPattern20.with(BlockModelGenerators.Y_ROT_180))
                        .select(20, Direction.EAST, chalkPattern20.with(BlockModelGenerators.Y_ROT_270))
                        .select(20, Direction.SOUTH, chalkPattern20)
                        .select(20, Direction.WEST, chalkPattern20.with(BlockModelGenerators.Y_ROT_90))
                        .select(20, Direction.UP, chalkPattern20.with(BlockModelGenerators.X_ROT_90))
                        .select(20, Direction.DOWN, chalkPattern20.with(BlockModelGenerators.X_ROT_270))
                        //21
                        .select(21, Direction.NORTH, chalkPattern21.with(BlockModelGenerators.Y_ROT_180))
                        .select(21, Direction.EAST, chalkPattern21.with(BlockModelGenerators.Y_ROT_270))
                        .select(21, Direction.SOUTH, chalkPattern21)
                        .select(21, Direction.WEST, chalkPattern21.with(BlockModelGenerators.Y_ROT_90))
                        .select(21, Direction.UP, chalkPattern21.with(BlockModelGenerators.X_ROT_90))
                        .select(21, Direction.DOWN, chalkPattern21.with(BlockModelGenerators.X_ROT_270))
                        //22
                        .select(22, Direction.NORTH, chalkPattern22.with(BlockModelGenerators.Y_ROT_180))
                        .select(22, Direction.EAST, chalkPattern22.with(BlockModelGenerators.Y_ROT_270))
                        .select(22, Direction.SOUTH, chalkPattern22)
                        .select(22, Direction.WEST, chalkPattern22.with(BlockModelGenerators.Y_ROT_90))
                        .select(22, Direction.UP, chalkPattern22.with(BlockModelGenerators.X_ROT_90))
                        .select(22, Direction.DOWN, chalkPattern22.with(BlockModelGenerators.X_ROT_270))
                        //23
                        .select(23, Direction.NORTH, chalkPattern23.with(BlockModelGenerators.Y_ROT_180))
                        .select(23, Direction.EAST, chalkPattern23.with(BlockModelGenerators.Y_ROT_270))
                        .select(23, Direction.SOUTH, chalkPattern23)
                        .select(23, Direction.WEST, chalkPattern23.with(BlockModelGenerators.Y_ROT_90))
                        .select(23, Direction.UP, chalkPattern23.with(BlockModelGenerators.X_ROT_90))
                        .select(23, Direction.DOWN, chalkPattern23.with(BlockModelGenerators.X_ROT_270))
                        //24
                        .select(24, Direction.NORTH, chalkPattern24.with(BlockModelGenerators.Y_ROT_180))
                        .select(24, Direction.EAST, chalkPattern24.with(BlockModelGenerators.Y_ROT_270))
                        .select(24, Direction.SOUTH, chalkPattern24)
                        .select(24, Direction.WEST, chalkPattern24.with(BlockModelGenerators.Y_ROT_90))
                        .select(24, Direction.UP, chalkPattern24.with(BlockModelGenerators.X_ROT_90))
                        .select(24, Direction.DOWN, chalkPattern24.with(BlockModelGenerators.X_ROT_270))
                        //25
                        .select(25, Direction.NORTH, chalkPattern25.with(BlockModelGenerators.Y_ROT_180))
                        .select(25, Direction.EAST, chalkPattern25.with(BlockModelGenerators.Y_ROT_270))
                        .select(25, Direction.SOUTH, chalkPattern25)
                        .select(25, Direction.WEST, chalkPattern25.with(BlockModelGenerators.Y_ROT_90))
                        .select(25, Direction.UP, chalkPattern25.with(BlockModelGenerators.X_ROT_90))
                        .select(25, Direction.DOWN, chalkPattern25.with(BlockModelGenerators.X_ROT_270))
                        //26
                        .select(26, Direction.NORTH, chalkPattern26.with(BlockModelGenerators.Y_ROT_180))
                        .select(26, Direction.EAST, chalkPattern26.with(BlockModelGenerators.Y_ROT_270))
                        .select(26, Direction.SOUTH, chalkPattern26)
                        .select(26, Direction.WEST, chalkPattern26.with(BlockModelGenerators.Y_ROT_90))
                        .select(26, Direction.UP, chalkPattern26.with(BlockModelGenerators.X_ROT_90))
                        .select(26, Direction.DOWN, chalkPattern26.with(BlockModelGenerators.X_ROT_270))
                        //27
                        .select(27, Direction.NORTH, chalkPattern27.with(BlockModelGenerators.Y_ROT_180))
                        .select(27, Direction.EAST, chalkPattern27.with(BlockModelGenerators.Y_ROT_270))
                        .select(27, Direction.SOUTH, chalkPattern27)
                        .select(27, Direction.WEST, chalkPattern27.with(BlockModelGenerators.Y_ROT_90))
                        .select(27, Direction.UP, chalkPattern27.with(BlockModelGenerators.X_ROT_90))
                        .select(27, Direction.DOWN, chalkPattern27.with(BlockModelGenerators.X_ROT_270))
                        //28
                        .select(28, Direction.NORTH, chalkPattern28.with(BlockModelGenerators.Y_ROT_180))
                        .select(28, Direction.EAST, chalkPattern28.with(BlockModelGenerators.Y_ROT_270))
                        .select(28, Direction.SOUTH, chalkPattern28)
                        .select(28, Direction.WEST, chalkPattern28.with(BlockModelGenerators.Y_ROT_90))
                        .select(28, Direction.UP, chalkPattern28.with(BlockModelGenerators.X_ROT_90))
                        .select(28, Direction.DOWN, chalkPattern28.with(BlockModelGenerators.X_ROT_270))
                        //29
                        .select(29, Direction.NORTH, chalkPattern29.with(BlockModelGenerators.Y_ROT_180))
                        .select(29, Direction.EAST, chalkPattern29.with(BlockModelGenerators.Y_ROT_270))
                        .select(29, Direction.SOUTH, chalkPattern29)
                        .select(29, Direction.WEST, chalkPattern29.with(BlockModelGenerators.Y_ROT_90))
                        .select(29, Direction.UP, chalkPattern29.with(BlockModelGenerators.X_ROT_90))
                        .select(29, Direction.DOWN, chalkPattern29.with(BlockModelGenerators.X_ROT_270))
                        //30
                        .select(30, Direction.NORTH, chalkPattern30.with(BlockModelGenerators.Y_ROT_180))
                        .select(30, Direction.EAST, chalkPattern30.with(BlockModelGenerators.Y_ROT_270))
                        .select(30, Direction.SOUTH, chalkPattern30)
                        .select(30, Direction.WEST, chalkPattern30.with(BlockModelGenerators.Y_ROT_90))
                        .select(30, Direction.UP, chalkPattern30.with(BlockModelGenerators.X_ROT_90))
                        .select(30, Direction.DOWN, chalkPattern30.with(BlockModelGenerators.X_ROT_270))
                        //31
                        .select(31, Direction.NORTH, chalkPattern31.with(BlockModelGenerators.Y_ROT_180))
                        .select(31, Direction.EAST, chalkPattern31.with(BlockModelGenerators.Y_ROT_270))
                        .select(31, Direction.SOUTH, chalkPattern31)
                        .select(31, Direction.WEST, chalkPattern31.with(BlockModelGenerators.Y_ROT_90))
                        .select(31, Direction.UP, chalkPattern31.with(BlockModelGenerators.X_ROT_90))
                        .select(31, Direction.DOWN, chalkPattern31.with(BlockModelGenerators.X_ROT_270))
                        //32
                        .select(32, Direction.NORTH, chalkPattern32.with(BlockModelGenerators.Y_ROT_180))
                        .select(32, Direction.EAST, chalkPattern32.with(BlockModelGenerators.Y_ROT_270))
                        .select(32, Direction.SOUTH, chalkPattern32)
                        .select(32, Direction.WEST, chalkPattern32.with(BlockModelGenerators.Y_ROT_90))
                        .select(32, Direction.UP, chalkPattern32.with(BlockModelGenerators.X_ROT_90))
                        .select(32, Direction.DOWN, chalkPattern32.with(BlockModelGenerators.X_ROT_270))
                );
    }


    public final void flowerPotBlock(Block flowerPot, DyeColor colour, String plant, String modID,  BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACTextureMapping.flowerPotTextureMappings(modID, plant, colour);
        Identifier resourceLocation = ACModelTemplates.FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        MultiVariant variant = BlockModelGenerators.plainVariant(resourceLocation);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, variant));
    }

    public final void cactusFlowerPotBlock(Block flowerPot, DyeColor colour, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACTextureMapping.emptyFlowerPotTextureMappings(colour);
        Identifier resourceLocation = ACModelTemplates.CACTUS_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        MultiVariant variant = BlockModelGenerators.plainVariant(resourceLocation);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, variant));
    }

    public final void bambooFlowerPotBlock(Block flowerPot, DyeColor colour, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACTextureMapping.emptyFlowerPotTextureMappings(colour);
        Identifier resourceLocation = ACModelTemplates.BAMBOO_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        MultiVariant variant = BlockModelGenerators.plainVariant(resourceLocation);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, variant));
    }

    public final void mangrovePropaguleFlowerPotBlock(Block flowerPot, DyeColor colour, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACTextureMapping.emptyFlowerPotTextureMappings(colour);
        Identifier resourceLocation = ACModelTemplates.MANGROVE_PROPAGULE_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        MultiVariant variant = BlockModelGenerators.plainVariant(resourceLocation);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, variant));
    }

    public final void azaleaFlowerPotBlock(Block flowerPot, DyeColor colour, String bush, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACTextureMapping.emptyFlowerPotTextureMappings(colour);
        Identifier resourceLocation = Identifier.parse("ifyouevergetthisihavezerocluewhathappened");
        if (Objects.equals(bush, "potted_azalea_bush")) {
            resourceLocation = ACModelTemplates.AZALEA_BUSH_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        } else if (Objects.equals(bush, "potted_flowering_azalea_bush")) {
            resourceLocation = ACModelTemplates.FLOWERING_AZALEA_BUSH_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        }
        MultiVariant variant = BlockModelGenerators.plainVariant(resourceLocation);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, variant));
    }

    public final void tintedFlowerPotBlock(Block flowerPot, DyeColor colour, String plant, String modID,  BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACTextureMapping.flowerPotTextureMappings(modID, plant, colour);
        Identifier resourceLocation = ACModelTemplates.TINTED_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        MultiVariant variant = BlockModelGenerators.plainVariant(resourceLocation);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, variant));
    }

    public final void createEmptyFlowerPot(Block flowerPot, DyeColor colour, BlockModelGenerators blockModelGenerators) {
        TextureMapping textureMapping = ACTextureMapping.emptyFlowerPotTextureMappings(colour);
        Identifier resourceLocation = ACModelTemplates.EMPTY_FLOWER_POT.create(flowerPot, textureMapping, blockModelGenerators.modelOutput);
        MultiVariant variant = BlockModelGenerators.plainVariant(resourceLocation);
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(flowerPot, variant));
    }
}
