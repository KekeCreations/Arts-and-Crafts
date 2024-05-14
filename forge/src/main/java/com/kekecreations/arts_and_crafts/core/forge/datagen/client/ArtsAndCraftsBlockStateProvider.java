package com.kekecreations.arts_and_crafts.core.forge.datagen.client;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
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
}
