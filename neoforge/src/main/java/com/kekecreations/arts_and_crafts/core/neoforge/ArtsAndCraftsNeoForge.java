package com.kekecreations.arts_and_crafts.core.neoforge;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.item.palette.PaintbrushPalette;
import com.kekecreations.arts_and_crafts.common.util.CreativeCategoryUtils;
import com.kekecreations.arts_and_crafts.core.neoforge.datagen.ArtsAndCraftsGlobalLootModifiersProvider;
import com.kekecreations.arts_and_crafts.core.neoforge.datagen.client.ArtsAndCraftsBlockStateProvider;
import com.kekecreations.arts_and_crafts.core.neoforge.datagen.client.ArtsAndCraftsItemModelProvider;
import com.kekecreations.arts_and_crafts.core.neoforge.datagen.client.ArtsAndCraftsLangProvider;
import com.kekecreations.arts_and_crafts.core.neoforge.datagen.server.*;
import com.kekecreations.arts_and_crafts.core.neoforge.platform.ForgeRegistryHelper;
import com.kekecreations.arts_and_crafts.core.neoforge.registry.ArtsAndCraftsLootModifiers;
import com.kekecreations.arts_and_crafts.core.registry.ACRegistries;
import com.kekecreations.arts_and_crafts.core.registry.ACBlocks;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

import java.util.concurrent.CompletableFuture;

@Mod(ArtsAndCrafts.MOD_ID)
public class ArtsAndCraftsNeoForge {
    public ArtsAndCraftsNeoForge(IEventBus modEventBus) {
        ArtsAndCrafts.init();

        ForgeRegistryHelper.SOUNDS.register(modEventBus);
        ForgeRegistryHelper.PARTICLE_TYPES.register(modEventBus);
        ForgeRegistryHelper.BLOCKS.register(modEventBus);
        ForgeRegistryHelper.ITEMS.register(modEventBus);
        ForgeRegistryHelper.ENTITY_TYPES.register(modEventBus);
        ForgeRegistryHelper.BLOCK_ENTITY_TYPES.register(modEventBus);
        ForgeRegistryHelper.RECIPE_SERIALIZER.register(modEventBus);
        ForgeRegistryHelper.DATA_COMPONENT_TYPES.register(modEventBus);
        ArtsAndCraftsLootModifiers.register(modEventBus);

        modEventBus.addListener(this::creativeItemGroups);
        modEventBus.addListener(this::gatherData);
        modEventBus.addListener(this::datapackRegistry);
    }
    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        //Client
        generator.addProvider(event.includeClient(), new ArtsAndCraftsLangProvider(packOutput, ArtsAndCrafts.MOD_ID));
        generator.addProvider(event.includeClient(), new ArtsAndCraftsItemModelProvider(packOutput, ArtsAndCrafts.MOD_ID, fileHelper));
        generator.addProvider(event.includeClient(), new ArtsAndCraftsBlockStateProvider(packOutput, ArtsAndCrafts.MOD_ID, fileHelper));

        //Server
        generator.addProvider(event.includeServer(), new ArtsAndCraftsRecipeProvider(packOutput, lookupProvider));
        ArtsAndCraftsBlockTagsProvider blockTagProvider = new ArtsAndCraftsBlockTagsProvider(packOutput, lookupProvider, ArtsAndCrafts.MOD_ID, fileHelper);
        generator.addProvider(event.includeServer(), blockTagProvider);
        generator.addProvider(event.includeServer(), new ArtsAndCraftsItemTagsProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), ArtsAndCrafts.MOD_ID, fileHelper));
        generator.addProvider(event.includeServer(), new ArtsAndCraftsLootTableProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ArtsAndCraftsBiomeTagsProvider(packOutput, lookupProvider, ArtsAndCrafts.MOD_ID, fileHelper));
        generator.addProvider(event.includeServer(), new ArtsAndCraftsGlobalLootModifiersProvider(packOutput, lookupProvider, ArtsAndCrafts.MOD_ID));
    }

    public void datapackRegistry(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(ACRegistries.PAINTBRUSH_PALETTE, PaintbrushPalette.CODEC);
    }

    private void addAfter(BuildCreativeModeTabContentsEvent event, Item beforeItem, Item item) {
        event.getEntries().putAfter(beforeItem.getDefaultInstance(), item.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
    private void addAfter(BuildCreativeModeTabContentsEvent event, Block beforeItem, Item item) {
        event.getEntries().putAfter(beforeItem.asItem().getDefaultInstance(), item.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
    private void addAfter(BuildCreativeModeTabContentsEvent event, Item beforeItem, Block item) {
        event.getEntries().putAfter(beforeItem.getDefaultInstance(), item.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
    private void addAfter(BuildCreativeModeTabContentsEvent event, Block beforeItem, Block item) {
        event.getEntries().putAfter(beforeItem.asItem().getDefaultInstance(), item.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    private void addBefore(BuildCreativeModeTabContentsEvent event, Block beforeItem, Block item) {
        event.getEntries().putBefore(beforeItem.asItem().getDefaultInstance(), item.asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
    private void addBefore(BuildCreativeModeTabContentsEvent event, Item beforeItem, Item item) {
        event.getEntries().putBefore(beforeItem.getDefaultInstance(), item.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    public void creativeItemGroups(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            addAfter(event, Blocks.PINK_GLAZED_TERRACOTTA, ACBlocks.TERRACOTTA_SHINGLES.get());
            addAfter(event, ACBlocks.TERRACOTTA_SHINGLES.get(), ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get());
            addAfter(event, ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), ACBlocks.TERRACOTTA_SHINGLE_SLAB.get());
            addAfter(event, ACBlocks.TERRACOTTA_SHINGLE_SLAB.get(), ACBlocks.TERRACOTTA_SHINGLE_WALL.get());

            addAfter(event, ACBlocks.getChalk(DyeColor.PINK.getId()), ACBlocks.SOAPSTONE.get());
            addAfter(event, ACBlocks.SOAPSTONE.get(), ACBlocks.SOAPSTONE_STAIRS.get());
            addAfter(event, ACBlocks.SOAPSTONE_STAIRS.get(), ACBlocks.SOAPSTONE_SLAB.get());
            addAfter(event, ACBlocks.SOAPSTONE_SLAB.get(), ACBlocks.SOAPSTONE_WALL.get());

            addAfter(event, ACBlocks.SOAPSTONE_WALL.get(), ACBlocks.POLISHED_SOAPSTONE.get());
            addAfter(event, ACBlocks.POLISHED_SOAPSTONE.get(), ACBlocks.POLISHED_SOAPSTONE_STAIRS.get());
            addAfter(event, ACBlocks.POLISHED_SOAPSTONE_STAIRS.get(), ACBlocks.POLISHED_SOAPSTONE_SLAB.get());
            addAfter(event, ACBlocks.POLISHED_SOAPSTONE_SLAB.get(), ACBlocks.POLISHED_SOAPSTONE_WALL.get());

            addAfter(event, ACBlocks.POLISHED_SOAPSTONE_WALL.get(), ACBlocks.SOAPSTONE_BRICKS.get());
            addAfter(event, ACBlocks.SOAPSTONE_BRICKS.get(), ACBlocks.SOAPSTONE_BRICK_STAIRS.get());
            addAfter(event, ACBlocks.SOAPSTONE_BRICK_STAIRS.get(), ACBlocks.SOAPSTONE_BRICK_SLAB.get());
            addAfter(event, ACBlocks.SOAPSTONE_BRICK_SLAB.get(), ACBlocks.SOAPSTONE_BRICK_WALL.get());

            addAfter(event, Blocks.PINK_STAINED_GLASS_PANE, ACBlocks.PLASTER.get());

            addBefore(event, Blocks.WHITE_WOOL, ACBlocks.BLEACHED_WOOL.get());
            addBefore(event, Blocks.WHITE_CARPET, ACBlocks.BLEACHED_CARPET.get());
            addBefore(event, Blocks.WHITE_CONCRETE, ACBlocks.BLEACHED_CONCRETE.get());
            addBefore(event, Blocks.WHITE_CONCRETE_POWDER, ACBlocks.BLEACHED_CONCRETE_POWDER.get());
            addBefore(event, Blocks.WHITE_GLAZED_TERRACOTTA, ACBlocks.GLAZED_TERRACOTTA.get());
            addBefore(event, Blocks.WHITE_BED, ACBlocks.BLEACHED_BED.get());

            for (DyeColor colours : CreativeCategoryUtils.colourOrder) {
                addAfter(event, Items.PINK_BANNER, ACBlocks.getChalk(colours.getId()));
                addAfter(event, Items.PINK_CANDLE, ACBlocks.getDyedFlowerPot(colours.getId()));
                addAfter(event, ACBlocks.getDyedFlowerPot(DyeColor.PINK.getId()), ACBlocks.getDyedDecoratedPot(colours.getId()));

                addAfter(event, ACBlocks.TERRACOTTA_SHINGLE_WALL.get(), ACBlocks.getDyedTerracottaShingles(colours.getId()));
                addAfter(event, ACBlocks.getDyedTerracottaShingles(colours.getId()), ACBlocks.getDyedTerracottaShingleStairs(colours.getId()));
                addAfter(event, ACBlocks.getDyedTerracottaShingleStairs(colours.getId()), ACBlocks.getDyedTerracottaShingleSlab(colours.getId()));
                addAfter(event, ACBlocks.getDyedTerracottaShingleSlab(colours.getId()), ACBlocks.getDyedTerracottaShingleWall(colours.getId()));

                addAfter(event, ACBlocks.SOAPSTONE_BRICK_WALL.get(), ACBlocks.getDyedSoapstone(colours.getId()));
                addAfter(event, ACBlocks.getDyedSoapstone(colours.getId()), ACBlocks.getDyedSoapstoneStairs(colours.getId()));
                addAfter(event, ACBlocks.getDyedSoapstoneStairs(colours.getId()), ACBlocks.getDyedSoapstoneSlab(colours.getId()));
                addAfter(event, ACBlocks.getDyedSoapstoneSlab(colours.getId()), ACBlocks.getDyedSoapstoneWall(colours.getId()));

                addAfter(event, ACBlocks.getDyedSoapstoneWall(colours.getId()), ACBlocks.getDyedPolishedSoapstone(colours.getId()));
                addAfter(event, ACBlocks.getDyedPolishedSoapstone(colours.getId()), ACBlocks.getDyedPolishedSoapstoneStairs(colours.getId()));
                addAfter(event, ACBlocks.getDyedPolishedSoapstoneStairs(colours.getId()), ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId()));
                addAfter(event, ACBlocks.getDyedPolishedSoapstoneSlab(colours.getId()), ACBlocks.getDyedPolishedSoapstoneWall(colours.getId()));

                addAfter(event, ACBlocks.getDyedPolishedSoapstoneWall(colours.getId()), ACBlocks.getDyedSoapstoneBricks(colours.getId()));
                addAfter(event, ACBlocks.getDyedSoapstoneBricks(colours.getId()), ACBlocks.getDyedSoapstoneBrickStairs(colours.getId()));
                addAfter(event, ACBlocks.getDyedSoapstoneBrickStairs(colours.getId()), ACBlocks.getDyedSoapstoneBrickSlab(colours.getId()));
                addAfter(event, ACBlocks.getDyedSoapstoneBrickSlab(colours.getId()), ACBlocks.getDyedSoapstoneBrickWall(colours.getId()));

                addAfter(event, ACBlocks.getDyedSoapstoneBrickWall(DyeColor.PINK.getId()), ACBlocks.getDyedMudBricks(colours.getId()));
                addAfter(event, ACBlocks.getDyedMudBricks(colours.getId()), ACBlocks.getDyedMudBrickStairs(colours.getId()));
                addAfter(event, ACBlocks.getDyedMudBrickStairs(colours.getId()), ACBlocks.getDyedMudBrickSlab(colours.getId()));
                addAfter(event, ACBlocks.getDyedMudBrickSlab(colours.getId()), ACBlocks.getDyedMudBrickWall(colours.getId()));

                addAfter(event, ACBlocks.PLASTER.get(), ACBlocks.getDyedPlaster(colours.getId()));
            }
            addBefore(event, ACBlocks.getChalk(DyeColor.WHITE.getId()), ACBlocks.BLEACHED_CHALK.get());
        }
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ACBlocks.getChalk(DyeColor.WHITE.getId()));
            event.accept(ACBlocks.SOAPSTONE.get());
            event.accept(ACBlocks.GYPSUM.get());

            addAfter(event, Blocks.ACACIA_LOG, ACBlocks.CORK_LOG.get());
            addAfter(event, Blocks.ACACIA_LEAVES, ACBlocks.CORK_LEAVES.get());
            addAfter(event, Blocks.ACACIA_SAPLING, ACBlocks.CORK_SAPLING.get());
            addAfter(event, Items.LILY_PAD, ACItems.LOTUS_PISTILS.get());
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            for (DyeColor colours : CreativeCategoryUtils.colourOrder) {
                addAfter(event, Items.MUSIC_DISC_RELIC, ACItems.getChalkStick(colours.getId()));
                addAfter(event, ACItems.getChalkStick(DyeColor.PINK.getId()), ACItems.getPaintBrush(colours.getId()));
            }
            addBefore(event, ACItems.getChalkStick(DyeColor.WHITE.getId()), ACItems.BLEACHED_CHALK_STICK.get());
            addBefore(event, ACItems.getPaintBrush(DyeColor.WHITE.getId()), ACItems.BLEACHDEW_PAINTBRUSH.get());
            addAfter(event, Items.ACACIA_CHEST_BOAT, ACItems.CORK_BOAT.get());
            addAfter(event, ACItems.CORK_BOAT.get(), ACItems.CORK_CHEST_BOAT.get());
        }
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            for (DyeColor colours : CreativeCategoryUtils.colourOrder) {
                addAfter(event, Items.FLOWER_POT, ACBlocks.getDyedFlowerPot(colours.getId()));
                addAfter(event, Items.DECORATED_POT, ACBlocks.getDyedDecoratedPot(colours.getId()));
            }
            addAfter(event, Items.ACACIA_HANGING_SIGN, ACItems.CORK_SIGN.get());
            addAfter(event, ACItems.CORK_SIGN.get(), ACItems.CORK_HANGING_SIGN.get());
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            addAfter(event, Blocks.ACACIA_BUTTON, ACBlocks.CORK_LOG.get());
            addAfter(event, ACBlocks.CORK_LOG.get(), ACBlocks.CORK_WOOD.get());
            addAfter(event, ACBlocks.CORK_WOOD.get(), ACBlocks.STRIPPED_CORK_LOG.get());
            addAfter(event, ACBlocks.STRIPPED_CORK_LOG.get(), ACBlocks.STRIPPED_CORK_WOOD.get());
            addAfter(event, ACBlocks.STRIPPED_CORK_WOOD.get(), ACBlocks.CORK.get());
            addAfter(event, ACBlocks.CORK.get(), ACBlocks.SMOOTH_CORK.get());
            addAfter(event, ACBlocks.SMOOTH_CORK.get(), ACBlocks.CORK_PLANKS.get());
            addAfter(event, ACBlocks.CORK_PLANKS.get(), ACBlocks.CORK_STAIRS.get());
            addAfter(event, ACBlocks.CORK_STAIRS.get(), ACBlocks.CORK_SLAB.get());
            addAfter(event, ACBlocks.CORK_SLAB.get(), ACBlocks.CORK_FENCE.get());
            addAfter(event, ACBlocks.CORK_FENCE.get(), ACBlocks.CORK_FENCE_GATE.get());
            addAfter(event, ACBlocks.CORK_FENCE_GATE.get(), ACBlocks.CORK_DOOR.get());
            addAfter(event, ACBlocks.CORK_DOOR.get(), ACBlocks.CORK_TRAPDOOR.get());
            addAfter(event, ACBlocks.CORK_TRAPDOOR.get(), ACBlocks.CORK_PRESSURE_PLATE.get());
            addAfter(event, ACBlocks.CORK_PRESSURE_PLATE.get(), ACBlocks.CORK_BUTTON.get());
            addAfter(event, Blocks.MUD_BRICK_WALL, ACBlocks.GYPSUM.get());
            addAfter(event, ACBlocks.GYPSUM.get(), ACBlocks.GYPSUM_STAIRS.get());
            addAfter(event, ACBlocks.GYPSUM_STAIRS.get(), ACBlocks.GYPSUM_SLAB.get());
            addAfter(event, ACBlocks.GYPSUM_SLAB.get(), ACBlocks.GYPSUM_WALL.get());
            addAfter(event, ACBlocks.GYPSUM_WALL.get(), ACBlocks.POLISHED_GYPSUM.get());
            addAfter(event, ACBlocks.POLISHED_GYPSUM.get(), ACBlocks.POLISHED_GYPSUM_STAIRS.get());
            addAfter(event, ACBlocks.POLISHED_GYPSUM_STAIRS.get(), ACBlocks.POLISHED_GYPSUM_SLAB.get());
            addAfter(event, ACBlocks.POLISHED_GYPSUM_SLAB.get(), ACBlocks.POLISHED_GYPSUM_WALL.get());
            addAfter(event, ACBlocks.POLISHED_GYPSUM_WALL.get(), ACBlocks.GYPSUM_BRICKS.get());
            addAfter(event, ACBlocks.GYPSUM_BRICKS.get(), ACBlocks.GYPSUM_BRICK_STAIRS.get());
            addAfter(event, ACBlocks.GYPSUM_BRICK_STAIRS.get(), ACBlocks.GYPSUM_BRICK_SLAB.get());
            addAfter(event, ACBlocks.GYPSUM_BRICK_SLAB.get(), ACBlocks.GYPSUM_BRICK_WALL.get());
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            addAfter(event, Items.PRIZE_POTTERY_SHERD, ACItems.ROLL_POTTERY_SHERD.get());
            addBefore(event, Items.FRIEND_POTTERY_SHERD, ACItems.FINALE_POTTERY_SHERD.get());
            addAfter(event, Items.FRIEND_POTTERY_SHERD, ACItems.GATEWAY_POTTERY_SHERD.get());
            addBefore(event, Items.ANGLER_POTTERY_SHERD, ACItems.RUINED_POTTERY_SHERD.get());
            addBefore(event, ACItems.RUINED_POTTERY_SHERD.get(), ACItems.POTTERY_SHERD.get());
            addBefore(event, Items.WHITE_DYE, ACItems.BLEACHDEW.get());
        }
    }
}