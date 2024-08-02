package com.kekecreations.arts_and_crafts.core.neoforge.datagen.server;

import com.kekecreations.arts_and_crafts.common.block.ACBedBlock;
import com.kekecreations.arts_and_crafts.core.neoforge.core.platform.ForgeRegistryHelper;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.DynamicLoot;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Set;
import java.util.stream.Collectors;

public class ArtsAndCraftsBlockLootSubProvider extends BlockLootSubProvider {
    private static final Set<Item> EXPLOSION_RESISTANT = Set.of();

    public ArtsAndCraftsBlockLootSubProvider(HolderLookup.Provider provider) {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistryHelper.BLOCKS.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toUnmodifiableList());
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
        hangingFlowerPots();
        chalkDust();
        decoratedPots();
        mudBricks();
        add(ACBlocks.LOTUS_FLOWER.get(), createTwoItemTable(ACItems.LOTUS_PISTILS.get(), Items.LILY_PAD));
    }

    private void hangingFlowerPots() {
        dropSelf(ACBlocks.CRIMSON_HANGING_FLOWER_POT.get());
    }

    private void bleached() {
        dropSelf(ACBlocks.BLEACHED_WOOL.get());
        dropSelf(ACBlocks.BLEACHED_CARPET.get());
        dropSelf(ACBlocks.GLAZED_TERRACOTTA.get());
        dropSelf(ACBlocks.BLEACHED_CONCRETE_POWDER.get());
        dropSelf(ACBlocks.BLEACHED_CONCRETE.get());
        add(ACBlocks.BLEACHED_BED.get(), createSinglePropConditionTable(ACBlocks.BLEACHED_BED.get(), ACBedBlock.PART, BedPart.HEAD));
    }
    private void decoratedPots() {
        for (DyeColor colours : DyeColor.values()) {
            add(ACBlocks.getDyedDecoratedPot(colours.getId()), createDecoratedPotTable(ACBlocks.getDyedDecoratedPot(colours.getId())));
        }
    }

    private void mudBricks() {
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(ACBlocks.getDyedMudBricks(colours.getId()));
            dropSelf(ACBlocks.getDyedMudBrickStairs(colours.getId()));
            add(ACBlocks.getDyedMudBrickSlab(colours.getId()), createSlabItemTable(ACBlocks.getDyedMudBrickSlab(colours.getId())));
            dropSelf(ACBlocks.getDyedMudBrickWall(colours.getId()));
        }
    }

    private void terracottaShingles() {
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(ACBlocks.getDyedTerracottaShingles(colours.getId()));
            dropSelf(ACBlocks.getDyedTerracottaShingleStairs(colours.getId()));
            add(ACBlocks.getDyedTerracottaShingleSlab(colours.getId()), createSlabItemTable(ACBlocks.getDyedTerracottaShingleSlab(colours.getId())));
            dropSelf(ACBlocks.getDyedTerracottaShingleWall(colours.getId()));
        }
        dropSelf(ACBlocks.TERRACOTTA_SHINGLES.get());
        add(ACBlocks.TERRACOTTA_SHINGLE_SLAB.get(), createSlabItemTable(ACBlocks.TERRACOTTA_SHINGLE_SLAB.get()));
        dropSelf(ACBlocks.TERRACOTTA_SHINGLE_WALL.get());
        dropSelf(ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get());
    }
    private void chalk() {
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(ACBlocks.getChalk(colours.getId()));
        }
        dropSelf(ACBlocks.BLEACHED_CHALK.get());
    }

    private void soapstone() {
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(ACBlocks.getDyedSoapstone(colours.getId()));
            dropSelf(ACBlocks.getDyedSoapstoneStairs(colours.getId()));
            add(ACBlocks.getDyedSoapstoneSlab(colours.getId()), createSlabItemTable(ACBlocks.getDyedSoapstoneSlab(colours.getId())));
            dropSelf(ACBlocks.getDyedSoapstoneWall(colours.getId()));
            dropSelf(ACBlocks.getDyedSoapstoneBricks(colours.getId()));
            dropSelf(ACBlocks.getDyedSoapstoneBrickStairs(colours.getId()));
            add(ACBlocks.getDyedSoapstoneBrickSlab(colours.getId()), createSlabItemTable(ACBlocks.getDyedSoapstoneBrickSlab(colours.getId())));
            dropSelf(ACBlocks.getDyedSoapstoneBrickWall(colours.getId()));
            dropSelf(ACBlocks.getDyedPolishedSoapstone(colours.getId()));
            dropSelf(ACBlocks.getDyedPolishedSoapstoneStairs(colours.getId()));
            add(ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId()), createSlabItemTable(ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId())));
            dropSelf(ACBlocks.getDyedPolishedSoapstoneWall(colours.getId()));
        }
        dropSelf(ACBlocks.SOAPSTONE.get());
        add(ACBlocks.SOAPSTONE_SLAB.get(), createSlabItemTable(ACBlocks.SOAPSTONE_SLAB.get()));
        dropSelf(ACBlocks.SOAPSTONE_WALL.get());
        dropSelf(ACBlocks.SOAPSTONE_STAIRS.get());
        dropSelf(ACBlocks.SOAPSTONE_BRICKS.get());
        add(ACBlocks.SOAPSTONE_BRICK_SLAB.get(), createSlabItemTable(ACBlocks.SOAPSTONE_BRICK_SLAB.get()));
        dropSelf(ACBlocks.SOAPSTONE_BRICK_WALL.get());
        dropSelf(ACBlocks.SOAPSTONE_BRICK_STAIRS.get());
        dropSelf(ACBlocks.POLISHED_SOAPSTONE.get());
        add(ACBlocks.POLISHED_SOAPSTONE_SLAB.get(), createSlabItemTable(ACBlocks.POLISHED_SOAPSTONE_SLAB.get()));
        dropSelf(ACBlocks.POLISHED_SOAPSTONE_WALL.get());
        dropSelf(ACBlocks.POLISHED_SOAPSTONE_STAIRS.get());
    }

    private void gypsum() {
        dropSelf(ACBlocks.GYPSUM.get());
        add(ACBlocks.GYPSUM_SLAB.get(), createSlabItemTable(ACBlocks.GYPSUM_SLAB.get()));
        dropSelf(ACBlocks.GYPSUM_WALL.get());
        dropSelf(ACBlocks.GYPSUM_STAIRS.get());
        dropSelf(ACBlocks.GYPSUM_BRICKS.get());
        add(ACBlocks.GYPSUM_BRICK_SLAB.get(), createSlabItemTable(ACBlocks.GYPSUM_BRICK_SLAB.get()));
        dropSelf(ACBlocks.GYPSUM_BRICK_WALL.get());
        dropSelf(ACBlocks.GYPSUM_BRICK_STAIRS.get());
        dropSelf(ACBlocks.POLISHED_GYPSUM.get());
        add(ACBlocks.POLISHED_GYPSUM_SLAB.get(), createSlabItemTable(ACBlocks.POLISHED_GYPSUM_SLAB.get()));
        dropSelf(ACBlocks.POLISHED_GYPSUM_WALL.get());
        dropSelf(ACBlocks.POLISHED_GYPSUM_STAIRS.get());
    }


    private void cork() {
        add(ACBlocks.CORK_LEAVES.get(), (Block block) -> createLeavesDrops(ACBlocks.CORK_LEAVES.get(), ACBlocks.CORK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(ACBlocks.CORK.get());
        dropSelf(ACBlocks.SMOOTH_CORK.get());
        dropSelf(ACBlocks.CORK_LOG.get());
        dropSelf(ACBlocks.STRIPPED_CORK_LOG.get());
        dropSelf(ACBlocks.CORK_WOOD.get());
        dropSelf(ACBlocks.STRIPPED_CORK_WOOD.get());
        dropSelf(ACBlocks.CORK_PLANKS.get());
        dropSelf(ACBlocks.CORK_STAIRS.get());
        add(ACBlocks.CORK_SLAB.get(), createSlabItemTable(ACBlocks.CORK_SLAB.get()));
        dropSelf(ACBlocks.CORK_FENCE.get());
        dropSelf(ACBlocks.CORK_FENCE_GATE.get());
        dropSelf(ACBlocks.CORK_BUTTON.get());
        dropSelf(ACBlocks.CORK_PRESSURE_PLATE.get());
        add(ACBlocks.CORK_DOOR.get(), (Block block) -> createDoorTable(ACBlocks.CORK_DOOR.get()));
        dropSelf(ACBlocks.CORK_TRAPDOOR.get());
        dropSelf(ACBlocks.CORK_SIGN.get());
        dropSelf(ACBlocks.CORK_HANGING_SIGN.get());
        dropSelf(ACBlocks.CORK_SAPLING.get());
    }

    private void plaster() {
        dropSelf(ACBlocks.PLASTER.get());
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(ACBlocks.getDyedPlaster(colours.getId()));
        }
    }
    private void chalkDust() {
        for (DyeColor colours : DyeColor.values()) {
            add(ACBlocks.getChalkDust(colours.getId()), noDrop());
        }
        add(ACBlocks.BLEACHED_CHALK_DUST.get(), noDrop());
    }

    private void flowerPots() {
        add(ACBlocks.POTTED_CORK_SAPLING.get(), (Block block) -> createPotFlowerItemTable(ACBlocks.CORK_SAPLING.get()));
        for (DyeColor colours : DyeColor.values()) {
            dropSelf(ACBlocks.getDyedFlowerPot(colours.getId()));
            add(ACBlocks.getDyedPottedCorkSapling(colours), (Block block) -> createDyedPotFlowerItemTable(colours, ACBlocks.CORK_SAPLING.get()));
            add(ACBlocks.getDyedPottedOakSapling(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.OAK_SAPLING));

            add(ACBlocks.getDyedPottedCrimsonFungus(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.CRIMSON_FUNGUS));
            add(ACBlocks.getDyedPottedCrimsonRoots(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.CRIMSON_ROOTS));
            add(ACBlocks.getDyedPottedWarpedFungus(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.WARPED_FUNGUS));
            add(ACBlocks.getDyedPottedWarpedRoots(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.WARPED_ROOTS));
            add(ACBlocks.getDyedPottedSpruceSapling(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.SPRUCE_SAPLING));
            add(ACBlocks.getDyedPottedBirchSapling(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.BIRCH_SAPLING));
            add(ACBlocks.getDyedPottedJungleSapling(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.JUNGLE_SAPLING));
            add(ACBlocks.getDyedPottedAcaciaSapling(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.ACACIA_SAPLING));
            add(ACBlocks.getDyedPottedCherrySapling(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.CHERRY_SAPLING));
            add(ACBlocks.getDyedPottedDarkOakSapling(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.DARK_OAK_SAPLING));
            add(ACBlocks.getDyedPottedMangrovePropagule(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.MANGROVE_PROPAGULE));
            add(ACBlocks.getDyedPottedFern(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.FERN));
            add(ACBlocks.getDyedPottedDandelion(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.DANDELION));
            add(ACBlocks.getDyedPottedPoppy(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.POPPY));
            add(ACBlocks.getDyedPottedBlueOrchid(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.BLUE_ORCHID));
            add(ACBlocks.getDyedPottedAllium(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.ALLIUM));
            add(ACBlocks.getDyedPottedAzureBluet(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.AZURE_BLUET));
            add(ACBlocks.getDyedPottedRedTulip(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.RED_TULIP));
            add(ACBlocks.getDyedPottedOrangeTulip(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.ORANGE_TULIP));
            add(ACBlocks.getDyedPottedWhiteTulip(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.WHITE_TULIP));
            add(ACBlocks.getDyedPottedPinkTulip(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.PINK_TULIP));
            add(ACBlocks.getDyedPottedOxeyeDaisy(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.OXEYE_DAISY));
            add(ACBlocks.getDyedPottedCornflower(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.CORNFLOWER));
            add(ACBlocks.getDyedPottedLilyOfTheValley(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.LILY_OF_THE_VALLEY));
            add(ACBlocks.getDyedPottedWitherRose(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.WITHER_ROSE));
            add(ACBlocks.getDyedPottedRedMushroom(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.RED_MUSHROOM));
            add(ACBlocks.getDyedPottedBrownMushroom(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.BROWN_MUSHROOM));
            add(ACBlocks.getDyedPottedDeadBush(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.DEAD_BUSH));
            add(ACBlocks.getDyedPottedCactus(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.CACTUS));
            add(ACBlocks.getDyedPottedBamboo(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.BAMBOO));
            add(ACBlocks.getDyedPottedAzalea(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.AZALEA));
            add(ACBlocks.getDyedPottedFloweringAzalea(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.FLOWERING_AZALEA));
            add(ACBlocks.getDyedPottedTorchFlower(colours), (Block block) -> createDyedPotFlowerItemTable(colours, Blocks.TORCHFLOWER));
        }
    }

    protected LootTable.Builder createDyedPotFlowerItemTable(DyeColor dyeColor, ItemLike p_249395_) {
        return LootTable.lootTable().withPool(this.applyExplosionCondition(ACBlocks.getDyedFlowerPot(dyeColor.getId()), LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(ACBlocks.getDyedFlowerPot(dyeColor.getId()))))).withPool(this.applyExplosionCondition(p_249395_, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(p_249395_))));
    }

    private LootTable.Builder createDecoratedPotTable(Block $$0x) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(((LootPoolSingletonContainer.Builder)DynamicLoot.dynamicEntry(DecoratedPotBlock.SHERDS_DYNAMIC_DROP_ID).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties($$0x).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DecoratedPotBlock.CRACKED, true)))).otherwise(LootItem.lootTableItem($$0x).apply(CopyComponentsFunction.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY).include(DataComponents.POT_DECORATIONS)))));
    }

    public LootTable.Builder createTwoItemTable(ItemLike p_251912_, ItemLike itemLike2) {
        return LootTable.lootTable().withPool(this.applyExplosionCondition(p_251912_, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(p_251912_)))).withPool(this.applyExplosionCondition(p_251912_, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(itemLike2))));
    }
}
