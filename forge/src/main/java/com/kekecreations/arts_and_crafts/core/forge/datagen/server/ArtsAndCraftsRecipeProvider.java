package com.kekecreations.arts_and_crafts.core.forge.datagen.server;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
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

        }
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
