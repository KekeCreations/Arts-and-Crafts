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
            dyeBlockRecipe(KekeBlocks.SOAPSTONE.get(), colours, KekeBlocks.getDyedSoapstone(colours.getId()), recipeConsumer);
            dyeBlockRecipe(KekeBlocks.POLISHED_SOAPSTONE.get(), colours, KekeBlocks.getDyedPolishedSoapstone(colours.getId()), recipeConsumer);
            dyeBlockRecipe(KekeBlocks.SOAPSTONE_BRICKS.get(), colours, KekeBlocks.getDyedSoapstoneBricks(colours.getId()), recipeConsumer);

            //PAINTBRUSH
            paintbrushRecipe(colours, KekeItems.getPaintBrush(colours.getId()), recipeConsumer);

            //TERRACOTTA SHINGLES
            typeRecipe(ArtsAndCraftsDyedBlockLists.getDyedTerracotta(colours.getId()), KekeBlocks.getDyedTerracottaShingles(colours.getId()), recipeConsumer);
            dyeBlockRecipe(KekeBlocks.TERRACOTTA_SHINGLES.get(), colours, KekeBlocks.getDyedTerracottaShingles(colours.getId()), recipeConsumer);
            stairRecipe(KekeBlocks.getDyedTerracottaShingles(colours.getId()), KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()), recipeConsumer);
            slabRecipe(KekeBlocks.getDyedTerracottaShingles(colours.getId()), KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()), recipeConsumer);
            wallRecipe(KekeBlocks.getDyedTerracottaShingles(colours.getId()), KekeBlocks.getDyedTerracottaShingleWall(colours.getId()), recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedTerracottaShingles(colours.getId()).asItem(), KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()).asItem(),1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedTerracottaShingles(colours.getId()).asItem(), KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()).asItem(),1, recipeConsumer);
            stonecutterRecipes(RecipeCategory.BUILDING_BLOCKS, KekeBlocks.getDyedTerracottaShingles(colours.getId()).asItem(), KekeBlocks.getDyedTerracottaShingleWall(colours.getId()).asItem(),1, recipeConsumer);
        }
    }
    protected static void dyeBlockRecipe(Block craftingBlock, DyeColor dyeColour, Block resultBlock, Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultBlock ,8)
                .pattern("KKK")
                .pattern("KQK")
                .pattern("KKK")
                .define('K', craftingBlock)
                .define('Q', DyeItem.byColor(dyeColour))
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
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, paintbrushItem,1)
                .pattern(" K ")
                .pattern("KQK")
                .define('K', DyeItem.byColor(dyeColour))
                .define('Q', Items.BRUSH)
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
