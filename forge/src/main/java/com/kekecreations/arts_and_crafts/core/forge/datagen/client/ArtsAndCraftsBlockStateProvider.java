package com.kekecreations.arts_and_crafts.core.forge.datagen.client;

import com.kekecreations.arts_and_crafts.common.misc.KekeBlockStateProperties;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ArtsAndCraftsBlockStateProvider extends BlockStateProvider {
    public ArtsAndCraftsBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //GYPSUM
        cubeAllWithItem(KekeBlocks.GYPSUM.get());
        cubeAllWithItem(KekeBlocks.GYPSUM_BRICKS.get());
        cubeAllWithItem(KekeBlocks.POLISHED_GYPSUM.get());
        stairsWithItem(KekeBlocks.GYPSUM_STAIRS.get(), KekeBlocks.GYPSUM.get());
        stairsWithItem(KekeBlocks.GYPSUM_BRICK_STAIRS.get(), KekeBlocks.GYPSUM_BRICKS.get());
        stairsWithItem(KekeBlocks.POLISHED_GYPSUM_STAIRS.get(), KekeBlocks.POLISHED_GYPSUM.get());
        slabWithItem(KekeBlocks.GYPSUM_SLAB.get(), KekeBlocks.GYPSUM.get());
        slabWithItem(KekeBlocks.GYPSUM_BRICK_SLAB.get(), KekeBlocks.GYPSUM_BRICKS.get());
        slabWithItem(KekeBlocks.POLISHED_GYPSUM_SLAB.get(), KekeBlocks.POLISHED_GYPSUM.get());
        wallWithItem(KekeBlocks.GYPSUM_WALL.get(), KekeBlocks.GYPSUM.get());
        wallWithItem(KekeBlocks.GYPSUM_BRICK_WALL.get(), KekeBlocks.GYPSUM_BRICKS.get());
        wallWithItem(KekeBlocks.POLISHED_GYPSUM_WALL.get(), KekeBlocks.POLISHED_GYPSUM.get());

        //Bleached
        cubeAllWithItem(KekeBlocks.BLEACHED_WOOL.get());


        chalkDustBlock(KekeBlocks.getChalkDust(DyeColor.BLACK), DyeColor.BLACK);

        //DYED STUFF
        for (DyeColor colours : DyeColor.values()) {
            cubeAllWithItem(KekeBlocks.getChalk(colours.getId()));
        }
    }
    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private void cubeAllWithItem(Block block) {
        simpleBlockWithItem(block, cubeAll(block));
    }

    private void stairsWithItem(StairBlock block, Block blockTexture) {
        ResourceLocation resLoc = blockTexture(blockTexture);
        stairsBlock(block, resLoc);
        simpleBlockItem(block, models().stairs(name(block), resLoc, resLoc, resLoc));
    }
    private void slabWithItem(SlabBlock block, Block blockTexture) {
        ResourceLocation resLoc = blockTexture(blockTexture);
        slabBlock(block, resLoc, resLoc);
        simpleBlockItem(block, models().slab(name(block), resLoc, resLoc, resLoc));
    }
    private void wallWithItem(WallBlock block, Block blockTexture) {
        ResourceLocation resLoc = blockTexture(blockTexture);
        wallBlock(block, resLoc);
        simpleBlockItem(block, models().wallInventory(name(block), resLoc));
    }


    public void chalkDustBlock(Block block, DyeColor dyeColor) {
        String dot = "block/" + dyeColor.getName() + "_dot";
        String verticalLine = "block/" + dyeColor.getName() + "_vertical_line_middle";
        String rotatedLine = "block/" + dyeColor.getName() + "_rotated_line_middle";
        String corner0 = "block/" + dyeColor.getName() + "_corner_0";
        String corner1 = "block/" + dyeColor.getName() + "_corner_1";
        String corner2 = "block/" + dyeColor.getName() + "_corner_2";
        String corner3 = "block/" + dyeColor.getName() + "_corner_3";
        String tCross0 = "block/" + dyeColor.getName() + "_t_cross_0";
        String tCross1 = "block/" + dyeColor.getName() + "_t_cross_1";
        String tCross2 = "block/" + dyeColor.getName() + "_t_cross_2";
        String tCross3 = "block/" + dyeColor.getName() + "_t_cross_3";
        String plus = "block/" + dyeColor.getName() + "_plus";
        String diagonalLineRight = "block/" + dyeColor.getName() + "_diagonal_line_right";
        String diagonalLineLeft = "block/" + dyeColor.getName() + "_diagonal_line_left";
        String x = "block/" + dyeColor.getName() + "_x";
        String lineEdge0 = "block/" + dyeColor.getName() + "_line_edge_0";
        String lineEdge1 = "block/" + dyeColor.getName() + "_line_edge_1";
        String lineEdge2 = "block/" + dyeColor.getName() + "_line_edge_2";
        String lineEdge3 = "block/" + dyeColor.getName() + "_line_edge_3";
        String triangle0 = "block/" + dyeColor.getName() + "_triangle_0";
        String triangle1 = "block/" + dyeColor.getName() + "_triangle_1";
        String triangle2 = "block/" + dyeColor.getName() + "_triangle_2";
        String triangle3 = "block/" + dyeColor.getName() + "_triangle_3";
        String circle = "block/" + dyeColor.getName() + "_circle";
        String square = "block/" + dyeColor.getName() + "_square";
        String blockCorner0 = "block/" + dyeColor.getName() + "_block_corner_0";
        String blockCorner1 = "block/" + dyeColor.getName() + "_block_corner_1";
        String blockCorner2 = "block/" + dyeColor.getName() + "_block_corner_2";
        String blockCorner3 = "block/" + dyeColor.getName() + "_block_corner_3";
        String arch0 = "block/" + dyeColor.getName() + "_arch_0";
        String arch1 = "block/" + dyeColor.getName() + "_arch_1";
        String arch2 = "block/" + dyeColor.getName() + "_arch_2";
        String arch3 = "block/" + dyeColor.getName() + "_arch_3";
        getVariantBuilder(block)
                //Chalk Pattern 0
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 0).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + dot).texture("dust", dot).texture("particle", dot)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 0).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + dot).texture("dust", dot).texture("particle", dot)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 0).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + dot).texture("dust", dot).texture("particle", dot)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 0).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + dot).texture("dust", dot).texture("particle", dot)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 0).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + dot).texture("dust", dot).texture("particle", dot)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 0).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + dot).texture("dust", dot).texture("particle", dot)).rotationX(270).build())
                //Chalk Pattern 1
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 1).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + verticalLine).texture("dust", verticalLine).texture("particle", verticalLine)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 1).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + verticalLine).texture("dust", verticalLine).texture("particle", verticalLine)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 1).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + verticalLine).texture("dust", verticalLine).texture("particle", verticalLine)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 1).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + verticalLine).texture("dust", verticalLine).texture("particle", verticalLine)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 1).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + verticalLine).texture("dust", verticalLine).texture("particle", verticalLine)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 1).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + verticalLine).texture("dust", verticalLine).texture("particle", verticalLine)).rotationX(270).build())
                //Chalk Pattern 2
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 2).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + rotatedLine).texture("dust", rotatedLine).texture("particle", rotatedLine)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 2).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + rotatedLine).texture("dust", rotatedLine).texture("particle", rotatedLine)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 2).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + rotatedLine).texture("dust", rotatedLine).texture("particle", rotatedLine)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 2).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + rotatedLine).texture("dust", rotatedLine).texture("particle", rotatedLine)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 2).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + rotatedLine).texture("dust", rotatedLine).texture("particle", rotatedLine)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 2).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + rotatedLine).texture("dust", rotatedLine).texture("particle", rotatedLine)).rotationX(270).build())
                //Chalk Pattern 3
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 3).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner0).texture("dust", corner0).texture("particle", corner0)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 3).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner0).texture("dust", corner0).texture("particle", corner0)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 3).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner0).texture("dust", corner0).texture("particle", corner0)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 3).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner0).texture("dust", corner0).texture("particle", corner0)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 3).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner0).texture("dust", corner0).texture("particle", corner0)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 3).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner0).texture("dust", corner0).texture("particle", corner0)).rotationX(270).build())
                //Chalk Pattern 4
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 4).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner1).texture("dust", corner1).texture("particle", corner1)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 4).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner1).texture("dust", corner1).texture("particle", corner1)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 4).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner1).texture("dust", corner1).texture("particle", corner1)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 4).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner1).texture("dust", corner1).texture("particle", corner1)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 4).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner1).texture("dust", corner1).texture("particle", corner1)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 4).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner1).texture("dust", corner1).texture("particle", corner1)).rotationX(270).build())
                //Chalk Pattern 5
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 5).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner2).texture("dust", corner2).texture("particle", corner2)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 5).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner2).texture("dust", corner2).texture("particle", corner2)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 5).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner2).texture("dust", corner2).texture("particle", corner2)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 5).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner2).texture("dust", corner2).texture("particle", corner2)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 5).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner2).texture("dust", corner2).texture("particle", corner2)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 5).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner2).texture("dust", corner2).texture("particle", corner2)).rotationX(270).build())
                //Chalk Pattern 6
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 6).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner3).texture("dust", corner3).texture("particle", corner3)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 6).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner3).texture("dust", corner3).texture("particle", corner3)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 6).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner3).texture("dust", corner3).texture("particle", corner3)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 6).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner3).texture("dust", corner3).texture("particle", corner3)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 6).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner3).texture("dust", corner3).texture("particle", corner3)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 6).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + corner3).texture("dust", corner3).texture("particle", corner3)).rotationX(270).build())
                //Chalk Pattern 7
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 7).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross0).texture("dust", tCross0).texture("particle", tCross0)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 7).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross0).texture("dust", tCross0).texture("particle", tCross0)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 7).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross0).texture("dust", tCross0).texture("particle", tCross0)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 7).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross0).texture("dust", tCross0).texture("particle", tCross0)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 7).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross0).texture("dust", tCross0).texture("particle", tCross0)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 7).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross0).texture("dust", tCross0).texture("particle", tCross0)).rotationX(270).build())
                //Chalk Pattern 8
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 8).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross1).texture("dust", tCross1).texture("particle", tCross1)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 8).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross1).texture("dust", tCross1).texture("particle", tCross1)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 8).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross1).texture("dust", tCross1).texture("particle", tCross1)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 8).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross1).texture("dust", tCross1).texture("particle", tCross1)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 8).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross1).texture("dust", tCross1).texture("particle", tCross1)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 8).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross1).texture("dust", tCross1).texture("particle", tCross1)).rotationX(270).build())
                //Chalk Pattern 9
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 9).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross2).texture("dust", tCross2).texture("particle", tCross2)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 9).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross2).texture("dust", tCross2).texture("particle", tCross2)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 9).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross2).texture("dust", tCross2).texture("particle", tCross2)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 9).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross2).texture("dust", tCross2).texture("particle", tCross2)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 9).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross2).texture("dust", tCross2).texture("particle", tCross2)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 9).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross2).texture("dust", tCross2).texture("particle", tCross2)).rotationX(270).build())
                //Chalk Pattern 10
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 10).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross3).texture("dust", tCross3).texture("particle", tCross3)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 10).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross3).texture("dust", tCross3).texture("particle", tCross3)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 10).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross3).texture("dust", tCross3).texture("particle", tCross3)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 10).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross3).texture("dust", tCross3).texture("particle", tCross3)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 10).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross3).texture("dust", tCross3).texture("particle", tCross3)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 10).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + tCross3).texture("dust", tCross3).texture("particle", tCross3)).rotationX(270).build())
                //Chalk Pattern 11
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 11).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + plus).texture("dust", plus).texture("particle", plus)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 11).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + plus).texture("dust", plus).texture("particle", plus)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 11).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + plus).texture("dust", plus).texture("particle", plus)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 11).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + plus).texture("dust", plus).texture("particle", plus)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 11).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + plus).texture("dust", plus).texture("particle", plus)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 11).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + plus).texture("dust", plus).texture("particle", plus)).rotationX(270).build())
                //Chalk Pattern 12
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 12).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + diagonalLineRight).texture("dust", diagonalLineRight).texture("particle", diagonalLineRight)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 12).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + diagonalLineRight).texture("dust", diagonalLineRight).texture("particle", diagonalLineRight)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 12).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + diagonalLineRight).texture("dust", diagonalLineRight).texture("particle", diagonalLineRight)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 12).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + diagonalLineRight).texture("dust", diagonalLineRight).texture("particle", diagonalLineRight)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 12).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + diagonalLineRight).texture("dust", diagonalLineRight).texture("particle", diagonalLineRight)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 12).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + diagonalLineRight).texture("dust", diagonalLineRight).texture("particle", diagonalLineRight)).rotationX(270).build())
                //Chalk Pattern 13
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 13).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + diagonalLineLeft).texture("dust", diagonalLineLeft).texture("particle", diagonalLineLeft)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 13).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + diagonalLineLeft).texture("dust", diagonalLineLeft).texture("particle", diagonalLineLeft)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 13).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + diagonalLineLeft).texture("dust", diagonalLineLeft).texture("particle", diagonalLineLeft)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 13).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + diagonalLineLeft).texture("dust", diagonalLineLeft).texture("particle", diagonalLineLeft)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 13).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + diagonalLineLeft).texture("dust", diagonalLineLeft).texture("particle", diagonalLineLeft)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 13).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + diagonalLineLeft).texture("dust", diagonalLineLeft).texture("particle", diagonalLineLeft)).rotationX(270).build())
                //Chalk Pattern 14
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 14).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + x).texture("dust", x).texture("particle", x)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 14).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + x).texture("dust", x).texture("particle", x)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 14).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + x).texture("dust", x).texture("particle", x)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 14).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + x).texture("dust", x).texture("particle", x)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 14).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + x).texture("dust", x).texture("particle", x)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 14).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + x).texture("dust", x).texture("particle", x)).rotationX(270).build())
                //Chalk Pattern 15
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 15).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge0).texture("dust", lineEdge0).texture("particle", lineEdge0)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 15).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge0).texture("dust", lineEdge0).texture("particle", lineEdge0)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 15).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge0).texture("dust", lineEdge0).texture("particle", lineEdge0)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 15).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge0).texture("dust", lineEdge0).texture("particle", lineEdge0)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 15).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge0).texture("dust", lineEdge0).texture("particle", lineEdge0)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 15).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge0).texture("dust", lineEdge0).texture("particle", lineEdge0)).rotationX(270).build())
                //Chalk Pattern 16
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 16).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge1).texture("dust", lineEdge1).texture("particle", lineEdge1)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 16).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge1).texture("dust", lineEdge1).texture("particle", lineEdge1)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 16).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge1).texture("dust", lineEdge1).texture("particle", lineEdge1)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 16).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge1).texture("dust", lineEdge1).texture("particle", lineEdge1)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 16).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge1).texture("dust", lineEdge1).texture("particle", lineEdge1)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 16).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge1).texture("dust", lineEdge1).texture("particle", lineEdge1)).rotationX(270).build())
                //Chalk Pattern 17
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 17).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge2).texture("dust", lineEdge2).texture("particle", lineEdge2)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 17).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge2).texture("dust", lineEdge2).texture("particle", lineEdge2)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 17).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge2).texture("dust", lineEdge2).texture("particle", lineEdge2)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 17).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge2).texture("dust", lineEdge2).texture("particle", lineEdge2)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 17).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge2).texture("dust", lineEdge2).texture("particle", lineEdge2)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 17).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge2).texture("dust", lineEdge2).texture("particle", lineEdge2)).rotationX(270).build())
                //Chalk Pattern 18
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 18).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge3).texture("dust", lineEdge3).texture("particle", lineEdge3)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 18).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge3).texture("dust", lineEdge3).texture("particle", lineEdge3)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 18).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge3).texture("dust", lineEdge3).texture("particle", lineEdge3)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 18).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge3).texture("dust", lineEdge3).texture("particle", lineEdge3)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 18).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge3).texture("dust", lineEdge3).texture("particle", lineEdge3)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 18).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + lineEdge3).texture("dust", lineEdge3).texture("particle", lineEdge3)).rotationX(270).build())
                //Chalk Pattern 19
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 19).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle0).texture("dust", triangle0).texture("particle", triangle0)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 19).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle0).texture("dust", triangle0).texture("particle", triangle0)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 19).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle0).texture("dust", triangle0).texture("particle", triangle0)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 19).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle0).texture("dust", triangle0).texture("particle", triangle0)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 19).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle0).texture("dust", triangle0).texture("particle", triangle0)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 19).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle0).texture("dust", triangle0).texture("particle", triangle0)).rotationX(270).build())
                //Chalk Pattern 20
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 20).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle1).texture("dust", triangle1).texture("particle", triangle1)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 20).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle1).texture("dust", triangle1).texture("particle", triangle1)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 20).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle1).texture("dust", triangle1).texture("particle", triangle1)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 20).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle1).texture("dust", triangle1).texture("particle", triangle1)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 20).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle1).texture("dust", triangle1).texture("particle", triangle1)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 20).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle1).texture("dust", triangle1).texture("particle", triangle1)).rotationX(270).build())
                //Chalk Pattern 21
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 21).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle2).texture("dust", triangle2).texture("particle", triangle2)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 21).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle2).texture("dust", triangle2).texture("particle", triangle2)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 21).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle2).texture("dust", triangle2).texture("particle", triangle2)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 21).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle2).texture("dust", triangle2).texture("particle", triangle2)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 21).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle2).texture("dust", triangle2).texture("particle", triangle2)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 21).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle2).texture("dust", triangle2).texture("particle", triangle2)).rotationX(270).build())
                //Chalk Pattern 22
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 22).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle3).texture("dust", triangle3).texture("particle", triangle3)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 22).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle3).texture("dust", triangle3).texture("particle", triangle3)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 22).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle3).texture("dust", triangle3).texture("particle", triangle3)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 22).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle3).texture("dust", triangle3).texture("particle", triangle3)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 22).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle3).texture("dust", triangle3).texture("particle", triangle3)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 22).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + triangle3).texture("dust", triangle3).texture("particle", triangle3)).rotationX(270).build())
                //Chalk Pattern 23
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 23).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + circle).texture("dust", circle).texture("particle", circle)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 23).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + circle).texture("dust", circle).texture("particle", circle)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 23).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + circle).texture("dust", circle).texture("particle", circle)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 23).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + circle).texture("dust", circle).texture("particle", circle)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 23).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + circle).texture("dust", circle).texture("particle", circle)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 23).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + circle).texture("dust", circle).texture("particle", circle)).rotationX(270).build())
                //Chalk Pattern 24
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 24).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + square).texture("dust", square).texture("particle", square)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 24).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + square).texture("dust", square).texture("particle", square)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 24).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + square).texture("dust", square).texture("particle", square)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 24).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + square).texture("dust", square).texture("particle", square)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 24).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + square).texture("dust", square).texture("particle", square)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 24).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + square).texture("dust", square).texture("particle", square)).rotationX(270).build())
                //Chalk Pattern 25
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 25).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner0).texture("dust", blockCorner0).texture("particle", blockCorner0)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 25).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner0).texture("dust", blockCorner0).texture("particle", blockCorner0)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 25).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner0).texture("dust", blockCorner0).texture("particle", blockCorner0)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 25).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner0).texture("dust", blockCorner0).texture("particle", blockCorner0)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 25).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner0).texture("dust", blockCorner0).texture("particle", blockCorner0)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 25).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner0).texture("dust", blockCorner0).texture("particle", blockCorner0)).rotationX(270).build())
                //Chalk Pattern 26
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 26).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner1).texture("dust", blockCorner1).texture("particle", blockCorner1)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 26).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner1).texture("dust", blockCorner1).texture("particle", blockCorner1)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 26).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner1).texture("dust", blockCorner1).texture("particle", blockCorner1)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 26).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner1).texture("dust", blockCorner1).texture("particle", blockCorner1)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 26).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner1).texture("dust", blockCorner1).texture("particle", blockCorner1)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 26).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner1).texture("dust", blockCorner1).texture("particle", blockCorner1)).rotationX(270).build())
                //Chalk Pattern 27
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 27).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner2).texture("dust", blockCorner2).texture("particle", blockCorner2)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 27).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner2).texture("dust", blockCorner2).texture("particle", blockCorner2)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 27).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner2).texture("dust", blockCorner2).texture("particle", blockCorner2)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 27).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner2).texture("dust", blockCorner2).texture("particle", blockCorner2)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 27).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner2).texture("dust", blockCorner2).texture("particle", blockCorner2)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 27).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner2).texture("dust", blockCorner2).texture("particle", blockCorner2)).rotationX(270).build())
                //Chalk Pattern 28
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 28).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner3).texture("dust", blockCorner3).texture("particle", blockCorner3)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 28).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner3).texture("dust", blockCorner3).texture("particle", blockCorner3)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 28).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner3).texture("dust", blockCorner3).texture("particle", blockCorner3)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 28).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner3).texture("dust", blockCorner3).texture("particle", blockCorner3)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 28).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner3).texture("dust", blockCorner3).texture("particle", blockCorner3)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 28).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + blockCorner3).texture("dust", blockCorner3).texture("particle", blockCorner3)).rotationX(270).build())
                //Chalk Pattern 29
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 29).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch0).texture("dust", arch0).texture("particle", arch0)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 29).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch0).texture("dust", arch0).texture("particle", arch0)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 29).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch0).texture("dust", arch0).texture("particle", arch0)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 29).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch0).texture("dust", arch0).texture("particle", arch0)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 29).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch0).texture("dust", arch0).texture("particle", arch0)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 29).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch0).texture("dust", arch0).texture("particle", arch0)).rotationX(270).build())
                //Chalk Pattern 30
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 30).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch1).texture("dust", arch1).texture("particle", arch1)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 30).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch1).texture("dust", arch1).texture("particle", arch1)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 30).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch1).texture("dust", arch1).texture("particle", arch1)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 30).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch1).texture("dust", arch1).texture("particle", arch1)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 30).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch1).texture("dust", arch1).texture("particle", arch1)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 30).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch1).texture("dust", arch1).texture("particle", arch1)).rotationX(270).build())
                //Chalk Pattern 31
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 31).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch2).texture("dust", arch2).texture("particle", arch2)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 31).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch2).texture("dust", arch2).texture("particle", arch2)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 31).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch2).texture("dust", arch2).texture("particle", arch2)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 31).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch2).texture("dust", arch2).texture("particle", arch2)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 31).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch2).texture("dust", arch2).texture("particle", arch2)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 31).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch2).texture("dust", arch2).texture("particle", arch2)).rotationX(270).build())
                //Chalk Pattern 32
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 32).with(BlockStateProperties.FACING, Direction.NORTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch3).texture("dust", arch3).texture("particle", arch3)).rotationY(180).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 32).with(BlockStateProperties.FACING, Direction.EAST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch3).texture("dust", arch3).texture("particle", arch3)).rotationY(270).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 32).with(BlockStateProperties.FACING, Direction.SOUTH)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch3).texture("dust", arch3).texture("particle", arch3)).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 32).with(BlockStateProperties.FACING, Direction.WEST)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch3).texture("dust", arch3).texture("particle", arch3)).rotationY(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 32).with(BlockStateProperties.FACING, Direction.UP)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch3).texture("dust", arch3).texture("particle", arch3)).rotationX(90).build())
                .partialState().with(KekeBlockStateProperties.CHALK_PATTERN, 32).with(BlockStateProperties.FACING, Direction.DOWN)
                .addModels(ConfiguredModel.builder().modelFile(dotPatternModel(dyeColor.getName() + arch3).texture("dust", arch3).texture("particle", arch3)).rotationX(270).build());
    }

    public ModelBuilder<?> dotPatternModel(String name) {
        return models().withExistingParent(name, "arts_and_crafts:block/chalk_dust");
    }
}
