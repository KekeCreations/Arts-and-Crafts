package com.kekecreations.arts_and_crafts.core.forge.datagen.server;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.item.PaintBrushItem;
import com.kekecreations.arts_and_crafts.common.util.ArtsAndCraftsDyedBlockLists;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ArtsAndCraftsRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ArtsAndCraftsRecipeProvider(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> recipeConsumer) {
        //GYPSUM
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.GYPSUM_BRICKS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.POLISHED_GYPSUM, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.GYPSUM_STAIRS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.GYPSUM_SLAB, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.GYPSUM_WALL, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.GYPSUM_BRICK_STAIRS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.GYPSUM_BRICK_SLAB, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.GYPSUM_BRICK_WALL, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.POLISHED_GYPSUM_STAIRS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.POLISHED_GYPSUM_SLAB, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM, KekeBlocks.POLISHED_GYPSUM_WALL, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM_BRICKS, KekeBlocks.GYPSUM_BRICK_STAIRS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM_BRICKS, KekeBlocks.GYPSUM_BRICK_SLAB, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.GYPSUM_BRICKS, KekeBlocks.GYPSUM_BRICK_WALL, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.POLISHED_GYPSUM, KekeBlocks.POLISHED_GYPSUM_STAIRS, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.POLISHED_GYPSUM, KekeBlocks.POLISHED_GYPSUM_SLAB, 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.POLISHED_GYPSUM, KekeBlocks.POLISHED_GYPSUM_WALL, 1, recipeConsumer);
        stairRecipe(KekeBlocks.GYPSUM.get(), KekeBlocks.GYPSUM_STAIRS.get(), recipeConsumer);
        slabRecipe(KekeBlocks.GYPSUM.get(), KekeBlocks.GYPSUM_SLAB.get(), recipeConsumer);
        wallRecipe(KekeBlocks.GYPSUM.get(), KekeBlocks.GYPSUM_WALL.get(), recipeConsumer);
        stairRecipe(KekeBlocks.POLISHED_GYPSUM.get(), KekeBlocks.POLISHED_GYPSUM_STAIRS.get(), recipeConsumer);
        slabRecipe(KekeBlocks.POLISHED_GYPSUM.get(), KekeBlocks.POLISHED_GYPSUM_SLAB.get(), recipeConsumer);
        wallRecipe(KekeBlocks.POLISHED_GYPSUM.get(), KekeBlocks.POLISHED_GYPSUM_WALL.get(), recipeConsumer);
        stairRecipe(KekeBlocks.GYPSUM_BRICKS.get(), KekeBlocks.GYPSUM_BRICK_STAIRS.get(), recipeConsumer);
        slabRecipe(KekeBlocks.GYPSUM_BRICKS.get(), KekeBlocks.GYPSUM_BRICK_SLAB.get(), recipeConsumer);
        wallRecipe(KekeBlocks.GYPSUM_BRICKS.get(), KekeBlocks.GYPSUM_BRICK_WALL.get(), recipeConsumer);

        //GYPSUM TO BRICK OR POLISHED RECIPES
        typeRecipe(KekeBlocks.GYPSUM.get(), KekeBlocks.POLISHED_GYPSUM.get(), recipeConsumer);
        typeRecipe(KekeBlocks.POLISHED_GYPSUM.get(), KekeBlocks.GYPSUM_BRICKS.get(), recipeConsumer);

        //SOAPSTONE
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.SOAPSTONE_STAIRS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.SOAPSTONE_SLAB.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.SOAPSTONE_WALL.get().asItem(), 1, recipeConsumer);
        stairRecipe(KekeBlocks.SOAPSTONE.get(), KekeBlocks.SOAPSTONE_STAIRS.get(), recipeConsumer);
        slabRecipe(KekeBlocks.SOAPSTONE.get(), KekeBlocks.SOAPSTONE_SLAB.get(), recipeConsumer);
        wallRecipe(KekeBlocks.SOAPSTONE.get(), KekeBlocks.SOAPSTONE_WALL.get(), recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.POLISHED_SOAPSTONE.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.POLISHED_SOAPSTONE_SLAB.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.POLISHED_SOAPSTONE_WALL.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.SOAPSTONE_BRICKS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.SOAPSTONE_BRICK_STAIRS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.SOAPSTONE_BRICK_SLAB.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE.get().asItem(), KekeBlocks.SOAPSTONE_BRICK_WALL.get().asItem(), 1, recipeConsumer);

        //SOAPSTONE TO BRICK OR POLISHED RECIPES
        typeRecipe(KekeBlocks.SOAPSTONE.get(), KekeBlocks.POLISHED_SOAPSTONE.get(), recipeConsumer);
        typeRecipe(KekeBlocks.POLISHED_SOAPSTONE.get(), KekeBlocks.SOAPSTONE_BRICKS.get(), recipeConsumer);

        //POLISHED SOAPSTONE
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.POLISHED_SOAPSTONE.get().asItem(), KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.POLISHED_SOAPSTONE.get().asItem(), KekeBlocks.POLISHED_SOAPSTONE_SLAB.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.POLISHED_SOAPSTONE.get().asItem(), KekeBlocks.POLISHED_SOAPSTONE_WALL.get().asItem(), 1, recipeConsumer);
        stairRecipe(KekeBlocks.POLISHED_SOAPSTONE.get(), KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get(), recipeConsumer);
        slabRecipe(KekeBlocks.POLISHED_SOAPSTONE.get(), KekeBlocks.POLISHED_SOAPSTONE_SLAB.get(), recipeConsumer);
        wallRecipe(KekeBlocks.POLISHED_SOAPSTONE.get(), KekeBlocks.POLISHED_SOAPSTONE_WALL.get(), recipeConsumer);

        //SOAPSTONE BRICKS
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE_BRICKS.get().asItem(), KekeBlocks.SOAPSTONE_BRICK_STAIRS.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE_BRICKS.get().asItem(), KekeBlocks.SOAPSTONE_BRICK_SLAB.get().asItem(), 1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.SOAPSTONE_BRICKS.get().asItem(), KekeBlocks.SOAPSTONE_BRICK_WALL.get().asItem(), 1, recipeConsumer);
        stairRecipe(KekeBlocks.SOAPSTONE_BRICKS.get(), KekeBlocks.SOAPSTONE_BRICK_STAIRS.get(), recipeConsumer);
        slabRecipe(KekeBlocks.SOAPSTONE_BRICKS.get(), KekeBlocks.SOAPSTONE_BRICK_SLAB.get(), recipeConsumer);
        wallRecipe(KekeBlocks.SOAPSTONE_BRICKS.get(), KekeBlocks.SOAPSTONE_BRICK_WALL.get(), recipeConsumer);

        //TERRACOTTA SHINGLES
        typeRecipe(Blocks.TERRACOTTA, KekeBlocks.TERRACOTTA_SHINGLES.get(), recipeConsumer);
        stairRecipe(KekeBlocks.TERRACOTTA_SHINGLES.get(), KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), recipeConsumer);
        slabRecipe(KekeBlocks.TERRACOTTA_SHINGLES.get(), KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get(), recipeConsumer);
        wallRecipe(KekeBlocks.TERRACOTTA_SHINGLES.get(), KekeBlocks.TERRACOTTA_SHINGLE_WALL.get(), recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.TERRACOTTA_SHINGLES.get().asItem(), KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get().asItem(),1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.TERRACOTTA_SHINGLES.get().asItem(), KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get().asItem(),1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.TERRACOTTA_SHINGLES.get().asItem(), KekeBlocks.TERRACOTTA_SHINGLE_WALL.get().asItem(),1, recipeConsumer);
        stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, Blocks.TERRACOTTA.asItem(), KekeBlocks.TERRACOTTA_SHINGLES.get().asItem(), 1, recipeConsumer);

        //PLASTER
        smeltingRecipe(KekeBlocks.GYPSUM.get(), KekeBlocks.PLASTER.get(), RecipeCategory.BUILDING_BLOCKS, 0F, recipeConsumer);

        //CHALK
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getChalk(DyeColor.WHITE.getId()),2)
                .pattern("QK")
                .pattern("KQ")
                .define('K', Blocks.CALCITE)
                .define('Q', KekeBlocks.GYPSUM.get())
                .unlockedBy(getItemName(Blocks.CALCITE), has(Blocks.CALCITE))
                .unlockedBy(getItemName(KekeBlocks.GYPSUM.get()), has(KekeBlocks.GYPSUM.get()))
                .save(recipeConsumer);

        for (DyeColor colours : DyeColor.values()) {
            //CHALK
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getChalk(colours.getId()).asItem(), KekeItems.getChalkStick(colours.getId()), 1, recipeConsumer);
            //SOAPSTONE
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneWall(colours.getId()).asItem(), 1, recipeConsumer);
            stairRecipe(KekeBlocks.getDyedSoapstone(colours.getId()), KekeBlocks.getDyedSoapstoneStairs(colours.getId()), recipeConsumer);
            slabRecipe(KekeBlocks.getDyedSoapstone(colours.getId()), KekeBlocks.getDyedSoapstoneSlab(colours.getId()), recipeConsumer);
            wallRecipe(KekeBlocks.getDyedSoapstone(colours.getId()), KekeBlocks.getDyedSoapstoneWall(colours.getId()), recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedPolishedSoapstone(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedPolishedSoapstoneStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedPolishedSoapstoneSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedPolishedSoapstoneWall(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneBricks(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneBrickWall(colours.getId()).asItem(), 1, recipeConsumer);
            //SOAPSTONE TO BRICK OR POLISHED RECIPES
            typeRecipe(KekeBlocks.getDyedSoapstone(colours.getId()), KekeBlocks.getDyedPolishedSoapstone(colours.getId()), recipeConsumer);
            typeRecipe(KekeBlocks.getDyedPolishedSoapstone(colours.getId()), KekeBlocks.getDyedSoapstoneBricks(colours.getId()), recipeConsumer);
            //POLISHED SOAPSTONE
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedPolishedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedPolishedSoapstoneStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedPolishedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedPolishedSoapstoneSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedPolishedSoapstone(colours.getId()).asItem(), KekeBlocks.getDyedPolishedSoapstoneWall(colours.getId()).asItem(), 1, recipeConsumer);
            stairRecipe(KekeBlocks.getDyedPolishedSoapstone(colours.getId()), KekeBlocks.getDyedPolishedSoapstoneStairs(colours.getId()), recipeConsumer);
            slabRecipe(KekeBlocks.getDyedPolishedSoapstone(colours.getId()), KekeBlocks.getDyedPolishedSoapstoneSlab(colours.getId()), recipeConsumer);
            wallRecipe(KekeBlocks.getDyedPolishedSoapstone(colours.getId()), KekeBlocks.getDyedPolishedSoapstoneWall(colours.getId()), recipeConsumer);
            //SOAPSTONE BRICKS
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstoneBricks(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstoneBricks(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()).asItem(), 1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedSoapstoneBricks(colours.getId()).asItem(), KekeBlocks.getDyedSoapstoneBrickWall(colours.getId()).asItem(), 1, recipeConsumer);
            stairRecipe(KekeBlocks.getDyedSoapstoneBricks(colours.getId()), KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()), recipeConsumer);
            slabRecipe(KekeBlocks.getDyedSoapstoneBricks(colours.getId()), KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()), recipeConsumer);
            wallRecipe(KekeBlocks.getDyedSoapstoneBricks(colours.getId()), KekeBlocks.getDyedSoapstoneBrickWall(colours.getId()), recipeConsumer);

            //DYE SOAPSTONE RECIPES
            dyeBlockRecipe(KekeBlocks.SOAPSTONE.get(), colours, KekeBlocks.getDyedSoapstone(colours.getId()), "soapstone", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.SOAPSTONE_STAIRS.get(), colours, KekeBlocks.getDyedSoapstoneStairs(colours.getId()), "soapstone_stairs", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.SOAPSTONE_SLAB.get(), colours, KekeBlocks.getDyedSoapstoneSlab(colours.getId()), "soapstone_slab", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.SOAPSTONE_WALL.get(), colours, KekeBlocks.getDyedSoapstoneWall(colours.getId()), "soapstone_wall", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.POLISHED_SOAPSTONE.get(), colours, KekeBlocks.getDyedPolishedSoapstone(colours.getId()), "polished_soapstone", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get(), colours, KekeBlocks.getDyedPolishedSoapstoneStairs(colours.getId()), "polished_soapstone_stairs", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.POLISHED_SOAPSTONE_SLAB.get(), colours, KekeBlocks.getDyedPolishedSoapstoneSlab(colours.getId()), "polished_soapstone_slab", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.POLISHED_SOAPSTONE_WALL.get(), colours, KekeBlocks.getDyedPolishedSoapstoneWall(colours.getId()), "polished_soapstone_wall", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.SOAPSTONE_BRICKS.get(), colours, KekeBlocks.getDyedSoapstoneBricks(colours.getId()), "soapstone_brick", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get(), colours, KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()), "soapstone_brick_stairs", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.SOAPSTONE_BRICK_SLAB.get(), colours, KekeBlocks.getDyedSoapstoneSlab(colours.getId()), "soapstone_brick_slab", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.SOAPSTONE_BRICK_WALL.get(), colours, KekeBlocks.getDyedSoapstoneWall(colours.getId()), "soapstone_brick_wall", recipeConsumer);

            //PAINTBRUSH
            paintbrushRecipe(colours, KekeItems.getPaintBrush(colours.getId()), recipeConsumer);

            //TERRACOTTA SHINGLES
            typeRecipe(ArtsAndCraftsDyedBlockLists.getDyedTerracotta(colours.getId()), KekeBlocks.getDyedTerracottaShingles(colours.getId()), recipeConsumer);
            dyeBlockRecipe(KekeBlocks.TERRACOTTA_SHINGLES.get(), colours, KekeBlocks.getDyedTerracottaShingles(colours.getId()), "terracotta_shingle", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), colours, KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()), "terracotta_shingle_stairs", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get(), colours, KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()), "terracotta_shingle_slab", recipeConsumer);
            dyeBlockRecipe(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get(), colours, KekeBlocks.getDyedTerracottaShingleWall(colours.getId()), "terracotta_shingle_wall", recipeConsumer);
            stairRecipe(KekeBlocks.getDyedTerracottaShingles(colours.getId()), KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()), recipeConsumer);
            slabRecipe(KekeBlocks.getDyedTerracottaShingles(colours.getId()), KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()), recipeConsumer);
            wallRecipe(KekeBlocks.getDyedTerracottaShingles(colours.getId()), KekeBlocks.getDyedTerracottaShingleWall(colours.getId()), recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedTerracottaShingles(colours.getId()).asItem(), KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()).asItem(),1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedTerracottaShingles(colours.getId()).asItem(), KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()).asItem(),1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedTerracottaShingles(colours.getId()).asItem(), KekeBlocks.getDyedTerracottaShingleWall(colours.getId()).asItem(),1, recipeConsumer);

            //PLASTER
            dyeBlockRecipe(KekeBlocks.PLASTER.get(), colours, KekeBlocks.getDyedPlaster(colours.getId()), "plaster", recipeConsumer);

            //CHALK
            altDyeBlockRecipe(KekeBlocks.getChalk(colours.getId()).asItem(), colours, DyeColor.WHITE, KekeBlocks.getChalk(DyeColor.WHITE.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "chalk", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getChalk(colours.getId()).asItem(), colours, DyeColor.ORANGE, KekeBlocks.getChalk(DyeColor.ORANGE.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "chalk", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getChalk(colours.getId()).asItem(), colours, DyeColor.MAGENTA, KekeBlocks.getChalk(DyeColor.MAGENTA.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "chalk", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getChalk(colours.getId()).asItem(), colours, DyeColor.LIGHT_BLUE, KekeBlocks.getChalk(DyeColor.LIGHT_BLUE.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "chalk", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getChalk(colours.getId()).asItem(), colours, DyeColor.YELLOW, KekeBlocks.getChalk(DyeColor.YELLOW.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "chalk", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getChalk(colours.getId()).asItem(), colours, DyeColor.LIME, KekeBlocks.getChalk(DyeColor.LIME.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "chalk", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getChalk(colours.getId()).asItem(), colours, DyeColor.PINK, KekeBlocks.getChalk(DyeColor.PINK.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "chalk", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getChalk(colours.getId()).asItem(), colours, DyeColor.GRAY, KekeBlocks.getChalk(DyeColor.GRAY.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "chalk", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getChalk(colours.getId()).asItem(), colours, DyeColor.LIGHT_GRAY, KekeBlocks.getChalk(DyeColor.LIGHT_GRAY.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "chalk", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getChalk(colours.getId()).asItem(), colours, DyeColor.CYAN, KekeBlocks.getChalk(DyeColor.CYAN.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "chalk", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getChalk(colours.getId()).asItem(), colours, DyeColor.PURPLE, KekeBlocks.getChalk(DyeColor.PURPLE.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "chalk", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getChalk(colours.getId()).asItem(), colours, DyeColor.BLUE, KekeBlocks.getChalk(DyeColor.BLUE.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "chalk", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getChalk(colours.getId()).asItem(), colours, DyeColor.BROWN, KekeBlocks.getChalk(DyeColor.BROWN.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "chalk", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getChalk(colours.getId()).asItem(), colours, DyeColor.GREEN, KekeBlocks.getChalk(DyeColor.GREEN.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "chalk", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getChalk(colours.getId()).asItem(), colours, DyeColor.RED, KekeBlocks.getChalk(DyeColor.RED.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "chalk", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getChalk(colours.getId()).asItem(), colours, DyeColor.BLACK, KekeBlocks.getChalk(DyeColor.BLACK.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "chalk", recipeConsumer);

            //CHALK STICKS
            altDyeBlockRecipe(KekeItems.getChalkStick(colours.getId()), colours, DyeColor.WHITE, KekeItems.getChalkStick(DyeColor.WHITE.getId()), RecipeCategory.TOOLS, "chalk_stick", recipeConsumer);
            altDyeBlockRecipe(KekeItems.getChalkStick(colours.getId()), colours, DyeColor.ORANGE, KekeItems.getChalkStick(DyeColor.ORANGE.getId()), RecipeCategory.TOOLS, "chalk_stick", recipeConsumer);
            altDyeBlockRecipe(KekeItems.getChalkStick(colours.getId()), colours, DyeColor.MAGENTA, KekeItems.getChalkStick(DyeColor.MAGENTA.getId()), RecipeCategory.TOOLS, "chalk_stick", recipeConsumer);
            altDyeBlockRecipe(KekeItems.getChalkStick(colours.getId()), colours, DyeColor.LIGHT_BLUE, KekeItems.getChalkStick(DyeColor.LIGHT_BLUE.getId()), RecipeCategory.TOOLS, "chalk_stick", recipeConsumer);
            altDyeBlockRecipe(KekeItems.getChalkStick(colours.getId()), colours, DyeColor.YELLOW, KekeItems.getChalkStick(DyeColor.YELLOW.getId()), RecipeCategory.TOOLS, "chalk_stick", recipeConsumer);
            altDyeBlockRecipe(KekeItems.getChalkStick(colours.getId()), colours, DyeColor.LIME, KekeItems.getChalkStick(DyeColor.LIME.getId()), RecipeCategory.TOOLS, "chalk_stick", recipeConsumer);
            altDyeBlockRecipe(KekeItems.getChalkStick(colours.getId()), colours, DyeColor.PINK, KekeItems.getChalkStick(DyeColor.PINK.getId()), RecipeCategory.TOOLS, "chalk_stick", recipeConsumer);
            altDyeBlockRecipe(KekeItems.getChalkStick(colours.getId()), colours, DyeColor.GRAY, KekeItems.getChalkStick(DyeColor.GRAY.getId()), RecipeCategory.TOOLS, "chalk_stick", recipeConsumer);
            altDyeBlockRecipe(KekeItems.getChalkStick(colours.getId()), colours, DyeColor.LIGHT_GRAY, KekeItems.getChalkStick(DyeColor.LIGHT_GRAY.getId()), RecipeCategory.TOOLS, "chalk_stick", recipeConsumer);
            altDyeBlockRecipe(KekeItems.getChalkStick(colours.getId()), colours, DyeColor.CYAN, KekeItems.getChalkStick(DyeColor.CYAN.getId()), RecipeCategory.TOOLS, "chalk_stick", recipeConsumer);
            altDyeBlockRecipe(KekeItems.getChalkStick(colours.getId()), colours, DyeColor.PURPLE, KekeItems.getChalkStick(DyeColor.PURPLE.getId()), RecipeCategory.TOOLS, "chalk_stick", recipeConsumer);
            altDyeBlockRecipe(KekeItems.getChalkStick(colours.getId()), colours, DyeColor.BLUE, KekeItems.getChalkStick(DyeColor.BLUE.getId()), RecipeCategory.TOOLS, "chalk_stick", recipeConsumer);
            altDyeBlockRecipe(KekeItems.getChalkStick(colours.getId()), colours, DyeColor.BROWN, KekeItems.getChalkStick(DyeColor.BROWN.getId()), RecipeCategory.TOOLS, "chalk_stick", recipeConsumer);
            altDyeBlockRecipe(KekeItems.getChalkStick(colours.getId()), colours, DyeColor.GREEN, KekeItems.getChalkStick(DyeColor.GREEN.getId()), RecipeCategory.TOOLS, "chalk_stick", recipeConsumer);
            altDyeBlockRecipe(KekeItems.getChalkStick(colours.getId()), colours, DyeColor.RED, KekeItems.getChalkStick(DyeColor.RED.getId()), RecipeCategory.TOOLS, "chalk_stick", recipeConsumer);
            altDyeBlockRecipe(KekeItems.getChalkStick(colours.getId()), colours, DyeColor.BLACK, KekeItems.getChalkStick(DyeColor.BLACK.getId()), RecipeCategory.TOOLS, "chalk_stick", recipeConsumer);

            //FLOWER POT
            altDyeBlockRecipe(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), colours, DyeColor.WHITE, KekeBlocks.getDyedFlowerPot(DyeColor.WHITE.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "dyed_flower_pot", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), colours, DyeColor.ORANGE, KekeBlocks.getDyedFlowerPot(DyeColor.ORANGE.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "dyed_flower_pot", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), colours, DyeColor.MAGENTA, KekeBlocks.getDyedFlowerPot(DyeColor.MAGENTA.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "dyed_flower_pot", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), colours, DyeColor.LIGHT_BLUE, KekeBlocks.getDyedFlowerPot(DyeColor.LIGHT_BLUE.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "dyed_flower_pot", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), colours, DyeColor.YELLOW, KekeBlocks.getDyedFlowerPot(DyeColor.YELLOW.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "dyed_flower_pot", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), colours, DyeColor.LIME, KekeBlocks.getDyedFlowerPot(DyeColor.LIME.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "dyed_flower_pot", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), colours, DyeColor.PINK, KekeBlocks.getDyedFlowerPot(DyeColor.PINK.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "dyed_flower_pot", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), colours, DyeColor.GRAY, KekeBlocks.getDyedFlowerPot(DyeColor.GRAY.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "dyed_flower_pot", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), colours, DyeColor.LIGHT_GRAY, KekeBlocks.getDyedFlowerPot(DyeColor.LIGHT_GRAY.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "dyed_flower_pot", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), colours, DyeColor.CYAN, KekeBlocks.getDyedFlowerPot(DyeColor.CYAN.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "dyed_flower_pot", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), colours, DyeColor.PURPLE, KekeBlocks.getDyedFlowerPot(DyeColor.PURPLE.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "dyed_flower_pot", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), colours, DyeColor.BLUE, KekeBlocks.getDyedFlowerPot(DyeColor.BLUE.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "dyed_flower_pot", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), colours, DyeColor.BROWN, KekeBlocks.getDyedFlowerPot(DyeColor.BROWN.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "dyed_flower_pot", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), colours, DyeColor.GREEN, KekeBlocks.getDyedFlowerPot(DyeColor.GREEN.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "dyed_flower_pot", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), colours, DyeColor.RED, KekeBlocks.getDyedFlowerPot(DyeColor.RED.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "dyed_flower_pot", recipeConsumer);
            altDyeBlockRecipe(KekeBlocks.getDyedFlowerPot(colours.getId()).asItem(), colours, DyeColor.BLACK, KekeBlocks.getDyedFlowerPot(DyeColor.BLACK.getId()).asItem(), RecipeCategory.BUILDING_BLOCKS, "dyed_flower_pot", recipeConsumer);
        }
    }
    protected static void smeltingRecipe(Block craftingBlock, Block resultBlock, RecipeCategory recipeCategory, float experience, Consumer<FinishedRecipe> recipeConsumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(craftingBlock), recipeCategory, resultBlock , experience, 200)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }
    protected static void altDyeBlockRecipe(Item craftingBlock, DyeColor forLoopColour, DyeColor dyeColour, Item resultBlock, RecipeCategory recipeCategory, String group, Consumer<FinishedRecipe> recipeConsumer) {
        if (forLoopColour != dyeColour) {
            ShapelessRecipeBuilder.shapeless(recipeCategory, resultBlock, 1)
                    .requires(craftingBlock)
                    .requires(DyeItem.byColor(dyeColour))
                    .group(group)
                    .unlockedBy(getItemName(DyeItem.byColor(dyeColour)), has(DyeItem.byColor(dyeColour)))
                    .save(recipeConsumer, "arts_and_crafts:" + getItemName(craftingBlock) + "_to_" + getItemName(resultBlock));
        }
    }
    protected static void dyeBlockRecipe(Block craftingBlock, DyeColor dyeColour, Block resultBlock, String group, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,8)
                .pattern("KKK")
                .pattern("KQK")
                .pattern("KKK")
                .define('K', craftingBlock)
                .define('Q', DyeItem.byColor(dyeColour))
                .group(group)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer, "arts_and_crafts:" + dyeColour.getName() + "_" + getItemName(craftingBlock) + "_dye_recipe");
    }
    protected static void stairRecipe(Block craftingBlock, Block resultBlock, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,4)
                .pattern("K  ")
                .pattern("KK ")
                .pattern("KKK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }

    protected static void slabRecipe(Block craftingBlock, Block resultBlock, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,6)
                .pattern("KKK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }

    protected static void wallRecipe(Block craftingBlock, Block resultBlock, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,6)
                .pattern("KKK")
                .pattern("KKK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }

    protected static void typeRecipe(Block craftingBlock, Block resultBlock, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,4)
                .pattern("KK")
                .pattern("KK")
                .define('K', craftingBlock)
                .unlockedBy(getItemName(craftingBlock), has(craftingBlock))
                .save(recipeConsumer);
    }
    protected static void paintbrushRecipe(DyeColor dyeColour, PaintBrushItem paintbrushItem, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, paintbrushItem,1)
                .pattern(" K ")
                .pattern("KQK")
                .define('K', DyeItem.byColor(dyeColour))
                .define('Q', Items.BRUSH)
                .group("paintbrush")
                .unlockedBy(getItemName(Items.BRUSH), has(Items.BRUSH))
                .save(recipeConsumer);
    }

    //Thank you to Uraneptus for allowing me to use their datagen methods from Sully's Mod
    protected static void stonecutterRecipes(RecipeCategory category, Item ingredient, Item result, int resultCount, Consumer<FinishedRecipe> consumer) {
        String prefix = getItemName(result) + "_from_" + getItemName(ingredient);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), category, result, resultCount)
                .unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, ArtsAndCrafts.id("stonecutting/"+ prefix + "_stonecutting"));
    }
    protected static void stonecutterRecipes(RecipeCategory category, Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, int resultCount, Consumer<FinishedRecipe> consumer) {
        String prefix = getItemName(result.get()) + "_from_" + getItemName(ingredient.get());
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient.get()), category, result.get(), resultCount)
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, ArtsAndCrafts.id("stonecutting/"+ prefix + "_stonecutting"));
    }
}
