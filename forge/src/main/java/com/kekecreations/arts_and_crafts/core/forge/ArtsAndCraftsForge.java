package com.kekecreations.arts_and_crafts.core.forge;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.item.palette.PaintbrushPalette;
import com.kekecreations.arts_and_crafts.common.util.CreativeCategoryUtils;
import com.kekecreations.arts_and_crafts.core.config.ArtsAndCraftsCommonConfig;
import com.kekecreations.arts_and_crafts.core.forge.datagen.client.ArtsAndCraftsBlockStateProvider;
import com.kekecreations.arts_and_crafts.core.forge.datagen.client.ArtsAndCraftsItemModelProvider;
import com.kekecreations.arts_and_crafts.core.forge.datagen.client.ArtsAndCraftsLangProvider;
import com.kekecreations.arts_and_crafts.core.forge.datagen.server.*;
import com.kekecreations.arts_and_crafts.core.forge.platform.ForgeRegistryHelper;
import com.kekecreations.arts_and_crafts.core.registry.ArtsAndCraftsRegistries;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DataPackRegistryEvent;

import java.util.concurrent.CompletableFuture;

@Mod(ArtsAndCrafts.MOD_ID)
public class ArtsAndCraftsForge {
    public ArtsAndCraftsForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ArtsAndCraftsCommonConfig.SPEC, "arts_and_crafts-common.toml");

        ArtsAndCrafts.init();

        ForgeRegistryHelper.SOUNDS.register(modEventBus);
        ForgeRegistryHelper.PARTICLE_TYPES.register(modEventBus);
        ForgeRegistryHelper.BLOCKS.register(modEventBus);
        ForgeRegistryHelper.ITEMS.register(modEventBus);

        modEventBus.addListener(this::creativeItemGroups);
        modEventBus.addListener(this::gatherData);
        modEventBus.addListener(this::datapackRegistry);

        MinecraftForge.EVENT_BUS.register(this);
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
        generator.addProvider(event.includeServer(), new ArtsAndCraftsRecipeProvider(packOutput));
        ArtsAndCraftsBlockTagsProvider blockTagProvider = new ArtsAndCraftsBlockTagsProvider(packOutput, lookupProvider, ArtsAndCrafts.MOD_ID, fileHelper);
        generator.addProvider(event.includeServer(), blockTagProvider);
        generator.addProvider(event.includeServer(), new ArtsAndCraftsItemTagsProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), ArtsAndCrafts.MOD_ID, fileHelper));
        generator.addProvider(event.includeServer(), new ArtsAndCraftsLootTableProvider(packOutput));
        generator.addProvider(event.includeServer(), new ArtsAndCraftsBiomeTagsProvider(packOutput, lookupProvider, ArtsAndCrafts.MOD_ID, fileHelper));
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

    public void datapackRegistry(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(ArtsAndCraftsRegistries.PAINTBRUSH_PALETTE, PaintbrushPalette.CODEC, PaintbrushPalette.CODEC);
    }

    public void creativeItemGroups(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            addAfter(event, Blocks.PINK_GLAZED_TERRACOTTA, KekeBlocks.TERRACOTTA_SHINGLES.get());
            addAfter(event, KekeBlocks.TERRACOTTA_SHINGLES.get(), KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get());
            addAfter(event, KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get());
            addAfter(event, KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get(), KekeBlocks.TERRACOTTA_SHINGLE_WALL.get());

            addAfter(event, KekeBlocks.getChalk(DyeColor.PINK.getId()), KekeBlocks.SOAPSTONE.get());
            addAfter(event, KekeBlocks.SOAPSTONE.get(), KekeBlocks.SOAPSTONE_STAIRS.get());
            addAfter(event, KekeBlocks.SOAPSTONE_STAIRS.get(), KekeBlocks.SOAPSTONE_SLAB.get());
            addAfter(event, KekeBlocks.SOAPSTONE_SLAB.get(), KekeBlocks.SOAPSTONE_WALL.get());

            addAfter(event, KekeBlocks.SOAPSTONE_WALL.get(), KekeBlocks.POLISHED_SOAPSTONE.get());
            addAfter(event, KekeBlocks.POLISHED_SOAPSTONE.get(), KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get());
            addAfter(event, KekeBlocks.POLISHED_SOAPSTONE_STAIRS.get(), KekeBlocks.POLISHED_SOAPSTONE_SLAB.get());
            addAfter(event, KekeBlocks.POLISHED_SOAPSTONE_SLAB.get(), KekeBlocks.POLISHED_SOAPSTONE_WALL.get());

            addAfter(event, KekeBlocks.POLISHED_SOAPSTONE_WALL.get(), KekeBlocks.SOAPSTONE_BRICKS.get());
            addAfter(event, KekeBlocks.SOAPSTONE_BRICKS.get(), KekeBlocks.SOAPSTONE_BRICK_STAIRS.get());
            addAfter(event, KekeBlocks.SOAPSTONE_BRICK_STAIRS.get(), KekeBlocks.SOAPSTONE_BRICK_SLAB.get());
            addAfter(event, KekeBlocks.SOAPSTONE_BRICK_SLAB.get(), KekeBlocks.SOAPSTONE_BRICK_WALL.get());

            addAfter(event, Blocks.PINK_STAINED_GLASS_PANE, KekeBlocks.PLASTER.get());

            addBefore(event, Blocks.WHITE_WOOL, KekeBlocks.BLEACHED_WOOL.get());
            addBefore(event, Blocks.WHITE_CARPET, KekeBlocks.BLEACHED_CARPET.get());
            addBefore(event, Blocks.WHITE_CONCRETE, KekeBlocks.BLEACHED_CONCRETE.get());
            addBefore(event, Blocks.WHITE_CONCRETE_POWDER, KekeBlocks.BLEACHED_CONCRETE_POWDER.get());
            addBefore(event, Blocks.WHITE_GLAZED_TERRACOTTA, KekeBlocks.GLAZED_TERRACOTTA.get());

            for (DyeColor colours : CreativeCategoryUtils.colourOrder) {
                addAfter(event, Items.PINK_BANNER, KekeBlocks.getChalk(colours.getId()));
                addAfter(event, Items.PINK_CANDLE, KekeBlocks.getDyedFlowerPot(colours.getId()));
                addAfter(event, KekeBlocks.getDyedFlowerPot(DyeColor.PINK.getId()), KekeBlocks.getDyedDecoratedPot(colours.getId()));

                addAfter(event, KekeBlocks.TERRACOTTA_SHINGLE_WALL.get(), KekeBlocks.getDyedTerracottaShingles(colours.getId()));
                addAfter(event, KekeBlocks.getDyedTerracottaShingles(colours.getId()), KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()));
                addAfter(event, KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()), KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()));
                addAfter(event, KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()), KekeBlocks.getDyedTerracottaShingleWall(colours.getId()));

                addAfter(event, KekeBlocks.SOAPSTONE_BRICK_WALL.get(), KekeBlocks.getDyedSoapstone(colours.getId()));
                addAfter(event, KekeBlocks.getDyedSoapstone(colours.getId()), KekeBlocks.getDyedSoapstoneStairs(colours.getId()));
                addAfter(event, KekeBlocks.getDyedSoapstoneStairs(colours.getId()), KekeBlocks.getDyedSoapstoneSlab(colours.getId()));
                addAfter(event, KekeBlocks.getDyedSoapstoneSlab(colours.getId()), KekeBlocks.getDyedSoapstoneWall(colours.getId()));

                addAfter(event, KekeBlocks.getDyedSoapstoneWall(colours.getId()), KekeBlocks.getDyedPolishedSoapstone(colours.getId()));
                addAfter(event, KekeBlocks.getDyedPolishedSoapstone(colours.getId()), KekeBlocks.getDyedPolishedSoapstoneStairs(colours.getId()));
                addAfter(event, KekeBlocks.getDyedPolishedSoapstoneStairs(colours.getId()), KekeBlocks.getDyedPolishedSoapstoneSlab(colours.getId()));
                addAfter(event, KekeBlocks.getDyedPolishedSoapstoneSlab(colours.getId()), KekeBlocks.getDyedPolishedSoapstoneWall(colours.getId()));

                addAfter(event, KekeBlocks.getDyedPolishedSoapstoneWall(colours.getId()), KekeBlocks.getDyedSoapstoneBricks(colours.getId()));
                addAfter(event, KekeBlocks.getDyedSoapstoneBricks(colours.getId()), KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()));
                addAfter(event, KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()), KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()));
                addAfter(event, KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()), KekeBlocks.getDyedSoapstoneBrickWall(colours.getId()));

                addAfter(event, KekeBlocks.getDyedSoapstoneBrickWall(DyeColor.PINK.getId()), KekeBlocks.getDyedMudBricks(colours.getId()));
                addAfter(event, KekeBlocks.getDyedMudBricks(colours.getId()), KekeBlocks.getDyedMudBrickStairs(colours.getId()));
                addAfter(event, KekeBlocks.getDyedMudBrickStairs(colours.getId()), KekeBlocks.getDyedMudBrickSlab(colours.getId()));
                addAfter(event, KekeBlocks.getDyedMudBrickSlab(colours.getId()), KekeBlocks.getDyedMudBrickWall(colours.getId()));

                addAfter(event, KekeBlocks.PLASTER.get(), KekeBlocks.getDyedPlaster(colours.getId()));
            }
            addBefore(event, KekeBlocks.getChalk(DyeColor.WHITE.getId()), KekeBlocks.BLEACHED_CHALK.get());
        }
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(KekeBlocks.getChalk(DyeColor.WHITE.getId()));
            event.accept(KekeBlocks.SOAPSTONE.get());
            event.accept(KekeBlocks.GYPSUM.get());

            addAfter(event, Blocks.ACACIA_LOG, KekeBlocks.CORK_LOG.get());
            addAfter(event, Blocks.ACACIA_LEAVES, KekeBlocks.CORK_LEAVES.get());
            addAfter(event, Blocks.ACACIA_SAPLING, KekeBlocks.CORK_SAPLING.get());
            addAfter(event, Items.LILY_PAD, KekeItems.LOTUS_PISTILS.get());
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            for (DyeColor colours : CreativeCategoryUtils.colourOrder) {
                addAfter(event, Items.MUSIC_DISC_RELIC, KekeItems.getChalkStick(colours.getId()));
                addAfter(event, KekeItems.getChalkStick(DyeColor.PINK.getId()), KekeItems.getPaintBrush(colours.getId()));
            }
            addBefore(event, KekeItems.getChalkStick(DyeColor.WHITE.getId()), KekeItems.BLEACHED_CHALK_STICK.get());
            addBefore(event, KekeItems.getPaintBrush(DyeColor.WHITE.getId()), KekeItems.BLEACHDEW_PAINTBRUSH.get());
            addAfter(event, Items.ACACIA_CHEST_BOAT, KekeItems.CORK_BOAT.get());
            addAfter(event, KekeItems.CORK_BOAT.get(), KekeItems.CORK_CHEST_BOAT.get());
        }
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            for (DyeColor colours : CreativeCategoryUtils.colourOrder) {
                addAfter(event, Items.FLOWER_POT, KekeBlocks.getDyedFlowerPot(colours.getId()));
                addAfter(event, Items.DECORATED_POT, KekeBlocks.getDyedDecoratedPot(colours.getId()));
            }
            addAfter(event, Items.ACACIA_HANGING_SIGN, KekeItems.CORK_SIGN.get());
            addAfter(event, KekeItems.CORK_SIGN.get(), KekeItems.CORK_HANGING_SIGN.get());
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            addAfter(event, Blocks.ACACIA_BUTTON, KekeBlocks.CORK_LOG.get());
            addAfter(event, KekeBlocks.CORK_LOG.get(), KekeBlocks.CORK_WOOD.get());
            addAfter(event, KekeBlocks.CORK_WOOD.get(), KekeBlocks.STRIPPED_CORK_LOG.get());
            addAfter(event, KekeBlocks.STRIPPED_CORK_LOG.get(), KekeBlocks.STRIPPED_CORK_WOOD.get());
            addAfter(event, KekeBlocks.STRIPPED_CORK_WOOD.get(), KekeBlocks.CORK.get());
            addAfter(event, KekeBlocks.CORK.get(), KekeBlocks.SMOOTH_CORK.get());
            addAfter(event, KekeBlocks.SMOOTH_CORK.get(), KekeBlocks.CORK_PLANKS.get());
            addAfter(event, KekeBlocks.CORK_PLANKS.get(), KekeBlocks.CORK_STAIRS.get());
            addAfter(event, KekeBlocks.CORK_STAIRS.get(), KekeBlocks.CORK_SLAB.get());
            addAfter(event, KekeBlocks.CORK_SLAB.get(), KekeBlocks.CORK_FENCE.get());
            addAfter(event, KekeBlocks.CORK_FENCE.get(), KekeBlocks.CORK_FENCE_GATE.get());
            addAfter(event, KekeBlocks.CORK_FENCE_GATE.get(), KekeBlocks.CORK_DOOR.get());
            addAfter(event, KekeBlocks.CORK_DOOR.get(), KekeBlocks.CORK_TRAPDOOR.get());
            addAfter(event, KekeBlocks.CORK_TRAPDOOR.get(), KekeBlocks.CORK_PRESSURE_PLATE.get());
            addAfter(event, KekeBlocks.CORK_PRESSURE_PLATE.get(), KekeBlocks.CORK_BUTTON.get());
            addAfter(event, Blocks.MUD_BRICK_WALL, KekeBlocks.GYPSUM.get());
            addAfter(event, KekeBlocks.GYPSUM.get(), KekeBlocks.GYPSUM_STAIRS.get());
            addAfter(event, KekeBlocks.GYPSUM_STAIRS.get(), KekeBlocks.GYPSUM_SLAB.get());
            addAfter(event, KekeBlocks.GYPSUM_SLAB.get(), KekeBlocks.GYPSUM_WALL.get());
            addAfter(event, KekeBlocks.GYPSUM_WALL.get(), KekeBlocks.POLISHED_GYPSUM.get());
            addAfter(event, KekeBlocks.POLISHED_GYPSUM.get(), KekeBlocks.POLISHED_GYPSUM_STAIRS.get());
            addAfter(event, KekeBlocks.POLISHED_GYPSUM_STAIRS.get(), KekeBlocks.POLISHED_GYPSUM_SLAB.get());
            addAfter(event, KekeBlocks.POLISHED_GYPSUM_SLAB.get(), KekeBlocks.POLISHED_GYPSUM_WALL.get());
            addAfter(event, KekeBlocks.POLISHED_GYPSUM_WALL.get(), KekeBlocks.GYPSUM_BRICKS.get());
            addAfter(event, KekeBlocks.GYPSUM_BRICKS.get(), KekeBlocks.GYPSUM_BRICK_STAIRS.get());
            addAfter(event, KekeBlocks.GYPSUM_BRICK_STAIRS.get(), KekeBlocks.GYPSUM_BRICK_SLAB.get());
            addAfter(event, KekeBlocks.GYPSUM_BRICK_SLAB.get(), KekeBlocks.GYPSUM_BRICK_WALL.get());
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            addAfter(event, Items.SNORT_POTTERY_SHERD, KekeItems.ROLL_POTTERY_SHERD.get());
            addAfter(event, KekeItems.ROLL_POTTERY_SHERD.get(), KekeItems.RUINED_POTTERY_SHERD.get());
            addAfter(event, KekeItems.RUINED_POTTERY_SHERD.get(), KekeItems.FINALE_POTTERY_SHERD.get());
            addAfter(event, KekeItems.FINALE_POTTERY_SHERD.get(), KekeItems.GATEWAY_POTTERY_SHERD.get());
            addBefore(event, Items.WHITE_DYE, KekeItems.BLEACHDEW.get());
        }
    }
}