package com.kekecreations.arts_and_crafts.forge;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.platform.forge.RegistryHelperImpl;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.forge.registry.KekeForgeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.world.item.*;
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
            event.accept(KekeBlocks.TERRACOTTA_SHINGLES);
            event.accept(KekeBlocks.TERRACOTTA_SHINGLE_SLAB);
            event.accept(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS);
            event.accept(KekeBlocks.TERRACOTTA_SHINGLE_WALL);
            for (DyeColor colours : DyeColor.values()) {
                event.accept(KekeBlocks.getDyedTerracottaShingles(colours));
                event.accept(KekeBlocks.getDyedTerracottaShingleSlab(colours));
                event.accept(KekeBlocks.getDyedTerracottaShingleStairs(colours));
                event.accept(KekeBlocks.getDyedTerracottaShingleWall(colours));

                event.accept(KekeBlocks.getChalk(colours));

                event.accept(KekeBlocks.getDyedSoapstone(colours));
                event.accept(KekeBlocks.getDyedSoapstoneSlab(colours));
                event.accept(KekeBlocks.getDyedSoapstoneStairs(colours));
                event.accept(KekeBlocks.getDyedSoapstoneWall(colours));

                event.accept(KekeBlocks.getDyedSoapstoneBricks(colours));
                event.accept(KekeBlocks.getDyedSoapstoneBrickSlab(colours));
                event.accept(KekeBlocks.getDyedSoapstoneBrickStairs(colours));
                event.accept(KekeBlocks.getDyedSoapstoneBrickWall(colours));

                event.accept(KekeBlocks.getDyedFlowerPot(colours));
            }
        }
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(KekeBlocks.getChalk(DyeColor.WHITE));
            event.accept(KekeBlocks.SOAPSTONE.get());
            event.accept(KekeBlocks.SOAPSTONE_SLAB.get());
            event.accept(KekeBlocks.SOAPSTONE_STAIRS.get());
            event.accept(KekeBlocks.SOAPSTONE_WALL.get());

            event.getEntries().putAfter(Blocks.ACACIA_LOG.asItem().getDefaultInstance(), KekeForgeBlocks.CORK_LOG.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Blocks.ACACIA_LEAVES.asItem().getDefaultInstance(), KekeForgeBlocks.CORK_LEAVES.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Blocks.ACACIA_SAPLING.asItem().getDefaultInstance(), KekeBlocks.CORK_SAPLING.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            for (DyeColor colours : DyeColor.values()) {
                event.accept(KekeItems.getChalkStick(colours));
            }
            event.getEntries().putAfter(Items.ACACIA_CHEST_BOAT.getDefaultInstance(), KekeItems.CORK_BOAT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeItems.CORK_BOAT.get().getDefaultInstance(), KekeItems.CORK_CHEST_BOAT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            for (DyeColor colours : DyeColor.values()) {
                event.accept(KekeBlocks.getDyedFlowerPot(colours));
            }
            event.getEntries().putAfter(Items.ACACIA_HANGING_SIGN.getDefaultInstance(), KekeItems.CORK_SIGN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(KekeItems.CORK_SIGN.get().getDefaultInstance(), KekeItems.CORK_HANGING_SIGN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(KekeBlocks.SOAPSTONE_BRICKS.get());
            event.accept(KekeBlocks.SOAPSTONE_BRICK_SLAB.get());
            event.accept(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get());
            event.accept(KekeBlocks.SOAPSTONE_BRICK_WALL.get());


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
    }
}
