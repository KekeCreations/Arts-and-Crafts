package com.kekecreations.arts_and_crafts.forge;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.misc.DyeColorByGradient;
import com.kekecreations.arts_and_crafts.core.platform.forge.RegistryHelperImpl;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import com.kekecreations.arts_and_crafts.forge.registry.KekeForgeBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ArtsAndCrafts.MOD_ID)
public class ArtsAndCraftsForge {
    public ArtsAndCraftsForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ArtsAndCrafts.init();

        RegistryHelperImpl.PARTICLE_TYPES.register(modEventBus);
        RegistryHelperImpl.ENTITY_TYPES.register(modEventBus);
        RegistryHelperImpl.BLOCK_ENTITY_TYPES.register(modEventBus);
        RegistryHelperImpl.ITEMS.register(modEventBus);
        RegistryHelperImpl.BLOCKS.register(modEventBus);
        KekeForgeBlocks.register();

        modEventBus.addListener(this::creativeItemGroups);

        MinecraftForge.EVENT_BUS.register(this);
    }




    public void creativeItemGroups(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            event.getEntries().putAfter(Blocks.PINK_GLAZED_TERRACOTTA.asItem().getDefaultInstance(), KekeBlocks.TERRACOTTA_SHINGLES.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeBlocks.TERRACOTTA_SHINGLES.get().asItem().getDefaultInstance(), KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get().asItem().getDefaultInstance(), KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get().asItem().getDefaultInstance(), KekeBlocks.TERRACOTTA_SHINGLE_WALL.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.getEntries().putAfter(KekeBlocks.getChalk(DyeColor.PINK.getId()).asItem().getDefaultInstance(), KekeBlocks.SOAPSTONE.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeBlocks.SOAPSTONE.get().asItem().getDefaultInstance(), KekeBlocks.SOAPSTONE_STAIRS.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeBlocks.SOAPSTONE_STAIRS.get().asItem().getDefaultInstance(), KekeBlocks.SOAPSTONE_SLAB.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeBlocks.SOAPSTONE_SLAB.get().asItem().getDefaultInstance(), KekeBlocks.SOAPSTONE_WALL.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            for (DyeColorByGradient colours : DyeColorByGradient.values()) {
                event.getEntries().putAfter(Items.PINK_BANNER.asItem().getDefaultInstance(), KekeBlocks.getChalk(colours.getId()).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(Items.PINK_CANDLE.asItem().getDefaultInstance(), KekeBlocks.getDyedFlowerPot(colours.getId()).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                event.getEntries().putAfter(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get().asItem().getDefaultInstance(), KekeBlocks.getDyedTerracottaShingles(colours.getId()).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(KekeBlocks.getDyedTerracottaShingles(colours.getId()).asItem().getDefaultInstance(), KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(KekeBlocks.getDyedTerracottaShingleStairs(colours.getId()).asItem().getDefaultInstance(), KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(KekeBlocks.getDyedTerracottaShingleSlab(colours.getId()).asItem().getDefaultInstance(), KekeBlocks.getDyedTerracottaShingleWall(colours.getId()).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                event.getEntries().putAfter(KekeBlocks.SOAPSTONE_WALL.get().asItem().getDefaultInstance(), KekeBlocks.getDyedSoapstone(colours.getId()).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(KekeBlocks.getDyedSoapstone(colours.getId()).asItem().getDefaultInstance(), KekeBlocks.getDyedSoapstoneStairs(colours.getId()).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(KekeBlocks.getDyedSoapstoneStairs(colours.getId()).asItem().getDefaultInstance(), KekeBlocks.getDyedSoapstoneSlab(colours.getId()).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(KekeBlocks.getDyedSoapstoneSlab(colours.getId()).asItem().getDefaultInstance(), KekeBlocks.getDyedSoapstoneWall(colours.getId()).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

                event.getEntries().putAfter(KekeBlocks.getDyedSoapstoneWall(DyeColor.PINK.getId()).asItem().getDefaultInstance(), KekeBlocks.SOAPSTONE_BRICKS.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(KekeBlocks.SOAPSTONE_BRICKS.get().asItem().getDefaultInstance(), KekeBlocks.SOAPSTONE_BRICK_STAIRS.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get().asItem().getDefaultInstance(), KekeBlocks.SOAPSTONE_BRICK_SLAB.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(KekeBlocks.SOAPSTONE_BRICK_SLAB.get().asItem().getDefaultInstance(), KekeBlocks.SOAPSTONE_BRICK_WALL.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);


                event.getEntries().putAfter(KekeBlocks.SOAPSTONE_BRICK_WALL.get().asItem().getDefaultInstance(), KekeBlocks.getDyedSoapstoneBricks(colours.getId()).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(KekeBlocks.getDyedSoapstoneBricks(colours.getId()).asItem().getDefaultInstance(), KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(KekeBlocks.getDyedSoapstoneBrickStairs(colours.getId()).asItem().getDefaultInstance(), KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                event.getEntries().putAfter(KekeBlocks.getDyedSoapstoneBrickSlab(colours.getId()).asItem().getDefaultInstance(), KekeBlocks.getDyedSoapstoneBrickWall(colours.getId()).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(KekeBlocks.getChalk(DyeColor.WHITE.getId()));
            event.accept(KekeBlocks.SOAPSTONE.get());
            event.accept(KekeBlocks.SOAPSTONE_SLAB.get());
            event.accept(KekeBlocks.SOAPSTONE_STAIRS.get());
            event.accept(KekeBlocks.SOAPSTONE_WALL.get());

            event.getEntries().putAfter(Blocks.ACACIA_LOG.asItem().getDefaultInstance(), KekeForgeBlocks.CORK_LOG.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Blocks.ACACIA_LEAVES.asItem().getDefaultInstance(), KekeForgeBlocks.CORK_LEAVES.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Blocks.ACACIA_SAPLING.asItem().getDefaultInstance(), KekeBlocks.CORK_SAPLING.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            for (DyeColorByGradient colours : DyeColorByGradient.values()) {
                event.getEntries().putAfter(Items.MUSIC_DISC_RELIC.getDefaultInstance(), KekeItems.getChalkStick(colours.getId()).getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
            event.getEntries().putAfter(Items.ACACIA_CHEST_BOAT.getDefaultInstance(), KekeItems.CORK_BOAT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeItems.CORK_BOAT.get().getDefaultInstance(), KekeItems.CORK_CHEST_BOAT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            for (DyeColorByGradient colours : DyeColorByGradient.values()) {
                event.getEntries().putAfter(Items.FLOWER_POT.getDefaultInstance(), KekeBlocks.getDyedFlowerPot(colours.getId()).asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
            event.getEntries().putAfter(Items.ACACIA_HANGING_SIGN.getDefaultInstance(), KekeItems.CORK_SIGN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeItems.CORK_SIGN.get().getDefaultInstance(), KekeItems.CORK_HANGING_SIGN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {

            event.getEntries().putAfter(Blocks.ACACIA_BUTTON.asItem().getDefaultInstance(), KekeForgeBlocks.CORK_LOG.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeForgeBlocks.CORK_LOG.get().asItem().getDefaultInstance(), KekeForgeBlocks.CORK_WOOD.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeForgeBlocks.CORK_WOOD.get().asItem().getDefaultInstance(), KekeForgeBlocks.STRIPPED_CORK_LOG.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeForgeBlocks.STRIPPED_CORK_LOG.get().asItem().getDefaultInstance(), KekeForgeBlocks.STRIPPED_CORK_WOOD.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeForgeBlocks.STRIPPED_CORK_WOOD.get().asItem().getDefaultInstance(), KekeBlocks.CORK.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeBlocks.CORK.get().asItem().getDefaultInstance(), KekeBlocks.SMOOTH_CORK.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeBlocks.SMOOTH_CORK.get().asItem().getDefaultInstance(), KekeForgeBlocks.CORK_PLANKS.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeForgeBlocks.CORK_PLANKS.get().asItem().getDefaultInstance(), KekeForgeBlocks.CORK_STAIRS.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeForgeBlocks.CORK_STAIRS.get().asItem().getDefaultInstance(), KekeForgeBlocks.CORK_SLAB.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeForgeBlocks.CORK_SLAB.get().asItem().getDefaultInstance(), KekeForgeBlocks.CORK_FENCE.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeForgeBlocks.CORK_FENCE.get().asItem().getDefaultInstance(), KekeForgeBlocks.CORK_FENCE_GATE.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeForgeBlocks.CORK_FENCE_GATE.get().asItem().getDefaultInstance(), KekeBlocks.CORK_DOOR.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeBlocks.CORK_DOOR.get().asItem().getDefaultInstance(), KekeBlocks.CORK_TRAPDOOR.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeBlocks.CORK_TRAPDOOR.get().asItem().getDefaultInstance(), KekeBlocks.CORK_PRESSURE_PLATE.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeBlocks.CORK_PRESSURE_PLATE.get().asItem().getDefaultInstance(), KekeBlocks.CORK_BUTTON.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.getEntries().putAfter(Items.SNORT_POTTERY_SHERD.asItem().getDefaultInstance(), KekeItems.ROLL_POTTERY_SHERD.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}
