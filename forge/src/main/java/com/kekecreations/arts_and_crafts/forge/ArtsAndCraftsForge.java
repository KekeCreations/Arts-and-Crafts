package com.kekecreations.arts_and_crafts.forge;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.platform.forge.RegistryHelperImpl;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
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
        RegistryHelperImpl.BLOCK_ENTITY_TYPES.register(modEventBus);
        RegistryHelperImpl.ITEMS.register(modEventBus);
        RegistryHelperImpl.BLOCKS.register(modEventBus);

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
                event.accept(KekeBlocks.getChalkSlab(colours));
                event.accept(KekeBlocks.getChalkStairs(colours));
                event.accept(KekeBlocks.getChalkWall(colours));

                event.accept(KekeBlocks.getDyedSoapstone(colours));
                event.accept(KekeBlocks.getDyedSoapstoneSlab(colours));
                event.accept(KekeBlocks.getDyedSoapstoneStairs(colours));
                event.accept(KekeBlocks.getDyedSoapstoneWall(colours));

                event.accept(KekeBlocks.getDyedFlowerPot(colours));
            }
        }
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(KekeBlocks.getChalk(DyeColor.WHITE));
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            for (DyeColor colours : DyeColor.values()) {
                event.accept(KekeItems.getChalkStick(colours));
            }
        }
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            for (DyeColor colours : DyeColor.values()) {
                event.accept(KekeBlocks.getDyedFlowerPot(colours));
            }
        }
    }
}
