package com.kekecreations.arts_and_crafts.core.forge.datagen.server;

import com.kekecreations.arts_and_crafts.core.forge.platform.ForgeRegistryHelper;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.DynamicLoot;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ArtsAndCraftsBlockLootSubProvider extends BlockLootSubProvider {

    private static final Set<Item> EXPLOSION_RESISTANT = Set.of();
    public ArtsAndCraftsBlockLootSubProvider() {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistryHelper.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    @Override
    public void generate() {
        terracottaShingles();
        chalk();
        soapstone();
        cork();
        plaster();
        gypsum();
        bleached();
        flowerPots();
        chalkDust();
        decoratedPots();
        mudBricks();
        dropOther(KekeBlocks.LOTUS_FLOWER.get(), KekeItems.LOTUS_PISTILS.get());
    }

    private void bleached() {
        dropSelf(KekeBlocks.BLEACHED_WOOL.get());
        dropSelf(KekeBlocks.BLEACHED_CARPET.get());
    }
    private void decoratedPots() {
        for (DyeColor colours : DyeColor.values()) {
            add(KekeBlocks.getDyedDecoratedPot(colours.getId()), createDecoratedPotTable(KekeBlocks.getDyedDecoratedPot(colours.getId())));
        }
    }

    private void mudBricks() {
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(KekeBlocks.getDyedMudBricks(colours.getId()));
            dropSelf(KekeBlocks.getDyedMudBrickStairs(colours.getId()));
            dropSelf(KekeBlocks.getDyedMudBrickSlab(colours.getId()));
            dropSelf(KekeBlocks.getDyedMudBrickWall(colours.getId()));
        }
    }

    private void terracottaShingles() {
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(KekeBlocks.getDyedTerracottaShingles(colours.getId()));
            dropSelf(KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()));
            dropSelf(KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()));
            dropSelf(KekeBlocks.getDyedTerracottaShingleWall(colours.getId()));
        }
        dropSelf(KekeBlocks.TERRACOTTA_SHINGLES.get());
        dropSelf(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get());
        dropSelf(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get());
        dropSelf(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get());
    }
    private void chalk() {
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(KekeBlocks.getChalk(colours.getId()));
        }
        dropSelf(KekeBlocks.BLEACHED_CHALK.get());
    }

    private void soapstone() {
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(KekeBlocks.getDyedSoapstone(colours.getId()));
            dropSelf(KekeBlocks.getDyedSoapstoneStairs(colours.getId()));
            dropSelf(KekeBlocks.getDyedSoapstoneSlab(colours.getId()));
            dropSelf(KekeBlocks.getDyedSoapstoneWall(colours.getId()));
            dropSelf(KekeBlocks.getDyedSoapstoneBricks(colours.getId()));
            dropSelf(KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()));
            dropSelf(KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()));
            dropSelf(KekeBlocks.getDyedSoapstoneBrickWall(colours.getId()));
            dropSelf(KekeBlocks.getDyedPolishedSoapstone(colours.getId()));
            dropSelf(KekeBlocks.getDyedPolishedSoapstoneStairs(colours.getId()));
            dropSelf(KekeBlocks.getDyedPolishedSoapstoneSlab(colours.getId()));
            dropSelf(KekeBlocks.getDyedPolishedSoapstoneWall(colours.getId()));
        }
        dropSelf(KekeBlocks.SOAPSTONE.get());
        dropSelf(KekeBlocks.SOAPSTONE_SLAB.get());
        dropSelf(KekeBlocks.SOAPSTONE_WALL.get());
        dropSelf(KekeBlocks.SOAPSTONE_STAIRS.get());
        dropSelf(KekeBlocks.SOAPSTONE_BRICKS.get());
        dropSelf(KekeBlocks.SOAPSTONE_BRICK_SLAB.get());
        dropSelf(KekeBlocks.SOAPSTONE_BRICK_WALL.get());
        dropSelf(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get());
        dropSelf(KekeBlocks.POLISHED_SOAPSTONE.get());
        dropSelf(KekeBlocks.POLISHED_SOAPSTONE_SLAB.get());
        dropSelf(KekeBlocks.POLISHED_SOAPSTONE_WALL.get());
        dropSelf(KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get());
    }

    private void gypsum() {
        dropSelf(KekeBlocks.GYPSUM.get());
        dropSelf(KekeBlocks.GYPSUM_SLAB.get());
        dropSelf(KekeBlocks.GYPSUM_WALL.get());
        dropSelf(KekeBlocks.GYPSUM_STAIRS.get());
        dropSelf(KekeBlocks.GYPSUM_BRICKS.get());
        dropSelf(KekeBlocks.GYPSUM_BRICK_SLAB.get());
        dropSelf(KekeBlocks.GYPSUM_BRICK_WALL.get());
        dropSelf(KekeBlocks.GYPSUM_BRICK_STAIRS.get());
        dropSelf(KekeBlocks.POLISHED_GYPSUM.get());
        dropSelf(KekeBlocks.POLISHED_GYPSUM_SLAB.get());
        dropSelf(KekeBlocks.POLISHED_GYPSUM_WALL.get());
        dropSelf(KekeBlocks.POLISHED_GYPSUM_STAIRS.get());
    }


    private void cork() {
        add(KekeBlocks.CORK_LEAVES.get(), (Block block) -> createLeavesDrops(KekeBlocks.CORK_LEAVES.get(), KekeBlocks.CORK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(KekeBlocks.CORK.get());
        dropSelf(KekeBlocks.SMOOTH_CORK.get());
        dropSelf(KekeBlocks.CORK_LOG.get());
        dropSelf(KekeBlocks.STRIPPED_CORK_LOG.get());
        dropSelf(KekeBlocks.CORK_WOOD.get());
        dropSelf(KekeBlocks.STRIPPED_CORK_WOOD.get());
        dropSelf(KekeBlocks.CORK_PLANKS.get());
        dropSelf(KekeBlocks.CORK_STAIRS.get());
        dropSelf(KekeBlocks.CORK_SLAB.get());
        dropSelf(KekeBlocks.CORK_FENCE.get());
        dropSelf(KekeBlocks.CORK_FENCE_GATE.get());
        dropSelf(KekeBlocks.CORK_BUTTON.get());
        dropSelf(KekeBlocks.CORK_PRESSURE_PLATE.get());
        add(KekeBlocks.CORK_DOOR.get(), (Block block) -> createDoorTable(KekeBlocks.CORK_DOOR.get()));
        dropSelf(KekeBlocks.CORK_TRAPDOOR.get());
        dropSelf(KekeBlocks.CORK_SIGN.get());
        dropSelf(KekeBlocks.CORK_HANGING_SIGN.get());
        dropSelf(KekeBlocks.CORK_SAPLING.get());
    }

    private void plaster() {
        dropSelf(KekeBlocks.PLASTER.get());
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(KekeBlocks.getDyedPlaster(colours.getId()));
        }
    }
    private void chalkDust() {
        for (DyeColor colours : DyeColor.values()) {
            add(KekeBlocks.getChalkDust(colours), noDrop());
        }
        add(KekeBlocks.BLEACHED_CHALK_DUST.get(), noDrop());
    }

    private void flowerPots() {
        add(KekeBlocks.POTTED_CORK_SAPLING.get(), (Block block) -> createPotFlowerItemTable(KekeBlocks.CORK_SAPLING.get()));
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(KekeBlocks.getDyedFlowerPot(colours.getId()));
            add(KekeBlocks.getDyedPottedCorkSapling(colours), (Block block) -> createDyedPotFlowerItemTable(colours, KekeBlocks.CORK_SAPLING.get()));
            add(KekeBlocks.getDyedPottedOakSapling(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.OAK_SAPLING));

            add(KekeBlocks.getDyedPottedCrimsonFungus(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.CRIMSON_FUNGUS));
            add(KekeBlocks.getDyedPottedCrimsonRoots(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.CRIMSON_ROOTS));
            add(KekeBlocks.getDyedPottedWarpedFungus(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.WARPED_FUNGUS));
            add(KekeBlocks.getDyedPottedWarpedRoots(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.WARPED_ROOTS));
            add(KekeBlocks.getDyedPottedSpruceSapling(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.SPRUCE_SAPLING));
            add(KekeBlocks.getDyedPottedBirchSapling(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.BIRCH_SAPLING));
            add(KekeBlocks.getDyedPottedJungleSapling(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.JUNGLE_SAPLING));
            add(KekeBlocks.getDyedPottedAcaciaSapling(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.ACACIA_SAPLING));
            add(KekeBlocks.getDyedPottedCherrySapling(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.CHERRY_SAPLING));
            add(KekeBlocks.getDyedPottedDarkOakSapling(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.DARK_OAK_SAPLING));
            add(KekeBlocks.getDyedPottedMangrovePropagule(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.MANGROVE_PROPAGULE));
            add(KekeBlocks.getDyedPottedFern(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.FERN));
            add(KekeBlocks.getDyedPottedDandelion(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.DANDELION));
            add(KekeBlocks.getDyedPottedPoppy(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.POPPY));
            add(KekeBlocks.getDyedPottedBlueOrchid(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.BLUE_ORCHID));
            add(KekeBlocks.getDyedPottedAllium(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.ALLIUM));
            add(KekeBlocks.getDyedPottedAzureBluet(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.AZURE_BLUET));
            add(KekeBlocks.getDyedPottedRedTulip(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.RED_TULIP));
            add(KekeBlocks.getDyedPottedOrangeTulip(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.ORANGE_TULIP));
            add(KekeBlocks.getDyedPottedWhiteTulip(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.WHITE_TULIP));
            add(KekeBlocks.getDyedPottedPinkTulip(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.PINK_TULIP));
            add(KekeBlocks.getDyedPottedOxeyeDaisy(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.OXEYE_DAISY));
            add(KekeBlocks.getDyedPottedCornflower(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.CORNFLOWER));
            add(KekeBlocks.getDyedPottedLilyOfTheValley(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.LILY_OF_THE_VALLEY));
            add(KekeBlocks.getDyedPottedWitherRose(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.WITHER_ROSE));
            add(KekeBlocks.getDyedPottedRedMushroom(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.RED_MUSHROOM));
            add(KekeBlocks.getDyedPottedBrownMushroom(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.BROWN_MUSHROOM));
            add(KekeBlocks.getDyedPottedDeadBush(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.DEAD_BUSH));
            add(KekeBlocks.getDyedPottedCactus(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.CACTUS));
            add(KekeBlocks.getDyedPottedBamboo(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.BAMBOO));
            add(KekeBlocks.getDyedPottedAzalea(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.AZALEA));
            add(KekeBlocks.getDyedPottedFloweringAzalea(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.FLOWERING_AZALEA));
            add(KekeBlocks.getDyedPottedTorchFlower(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.TORCHFLOWER));
        }
    }

    protected LootTable.Builder createDyedPotFlowerItemTable(DyeColor dyeColor, ItemLike p_249395_) {
        return LootTable.lootTable().withPool(this.applyExplosionCondition(KekeBlocks.getDyedFlowerPot(dyeColor.getId()), LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(KekeBlocks.getDyedFlowerPot(dyeColor.getId()))))).withPool(this.applyExplosionCondition(p_249395_, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(p_249395_))));
    }

    private LootTable.Builder createDecoratedPotTable(Block p_277929_) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(DynamicLoot.dynamicEntry(DecoratedPotBlock.SHERDS_DYNAMIC_DROP_ID).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.BREAKS_DECORATED_POTS))).when(HAS_NO_SILK_TOUCH).otherwise(LootItem.lootTableItem(p_277929_).apply(CopyNbtFunction.copyData(ContextNbtProvider.BLOCK_ENTITY).copy("sherds", "BlockEntityTag.sherds")))));
    }
}
