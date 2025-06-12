package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.util.PietraforteColour;
import com.kekecreations.jinxedlib.core.util.JinxedCreativeCategoryHelper;
import com.kekecreations.jinxedlib.core.util.JinxedRegistryHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;

import java.util.function.Supplier;

public class ACTabs {

    public static final Supplier<CreativeModeTab> TAB = registerTab("configurable_tab", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 5)
            .title(Component.translatable("tab." + ArtsAndCrafts.MOD_ID + ".configurable_tab"))
            .icon(() -> ACItems.getPaintBrush(DyeColor.RED.getId()).getDefaultInstance())
            .displayItems((params, pOutput) -> {
                pOutput.accept(ACBlocks.CORK_SAPLING.get());
                pOutput.accept(ACBlocks.CORK_LEAVES.get());
                pOutput.accept(ACBlocks.CORK_LOG.get());
                pOutput.accept(ACBlocks.CORK_WOOD.get());
                pOutput.accept(ACBlocks.STRIPPED_CORK_LOG.get());
                pOutput.accept(ACBlocks.STRIPPED_CORK_WOOD.get());
                pOutput.accept(ACBlocks.CORK.get());
                pOutput.accept(ACBlocks.SMOOTH_CORK.get());
                pOutput.accept(ACBlocks.CORK_PLANKS.get());
                pOutput.accept(ACBlocks.CORK_STAIRS.get());
                pOutput.accept(ACBlocks.CORK_SLAB.get());
                pOutput.accept(ACBlocks.CORK_FENCE.get());
                pOutput.accept(ACBlocks.CORK_FENCE_GATE.get());
                pOutput.accept(ACBlocks.CORK_DOOR.get());
                pOutput.accept(ACBlocks.CORK_TRAPDOOR.get());
                pOutput.accept(ACBlocks.CORK_PRESSURE_PLATE.get());
                pOutput.accept(ACBlocks.CORK_BUTTON.get());
                pOutput.accept(ACBlocks.CORK_SIGN.get());
                pOutput.accept(ACBlocks.CORK_HANGING_SIGN.get());
                pOutput.accept(ACItems.CORK_BOAT.get());
                pOutput.accept(ACItems.CORK_CHEST_BOAT.get());

                pOutput.accept(ACItems.LOTUS_PISTILS.get());
                pOutput.accept(ACItems.BLEACHDEW.get());
                pOutput.accept(ACBlocks.BLEACHED_WOOL.get());
                pOutput.accept(ACBlocks.BLEACHED_CARPET.get());
                pOutput.accept(ACBlocks.BLEACHED_CONCRETE.get());
                pOutput.accept(ACBlocks.BLEACHED_CONCRETE_POWDER.get());
                pOutput.accept(ACBlocks.BLEACHED_BED.get());

                pOutput.accept(ACItems.POTTERY_SHERD.get());
                pOutput.accept(ACItems.RUINED_POTTERY_SHERD.get());
                pOutput.accept(ACItems.ROLL_POTTERY_SHERD.get());
                pOutput.accept(ACItems.FINALE_POTTERY_SHERD.get());
                pOutput.accept(ACItems.GATEWAY_POTTERY_SHERD.get());
                //pOutput.accept(ACItems.SUS_POTTERY_SHERD.get());
                //pOutput.accept(ACItems.VICTORY_POTTERY_SHERD.get());

                pOutput.accept(ACBlocks.GLAZED_TERRACOTTA.get());
                pOutput.accept(ACBlocks.TERRACOTTA_SHINGLES.get());
                pOutput.accept(ACBlocks.TERRACOTTA_SHINGLE_STAIRS.get());
                pOutput.accept(ACBlocks.TERRACOTTA_SHINGLE_SLAB.get());
                pOutput.accept(ACBlocks.TERRACOTTA_SHINGLE_WALL.get());
                for (DyeColor colour : JinxedCreativeCategoryHelper.colourOrderBackToFront) {
                    pOutput.accept(ACBlocks.getDyedTerracottaShingles(colour.getId()));
                    pOutput.accept(ACBlocks.getDyedTerracottaShingleStairs(colour.getId()));
                    pOutput.accept(ACBlocks.getDyedTerracottaShingleSlab(colour.getId()));
                    pOutput.accept(ACBlocks.getDyedTerracottaShingleWall(colour.getId()));
                }
                pOutput.accept(ACItems.BLEACHED_CHALK_STICK.get());
                for (DyeColor colour : JinxedCreativeCategoryHelper.colourOrderBackToFront) {
                    pOutput.accept(ACItems.getChalkStick(colour.getId()));
                }
                pOutput.accept(ACBlocks.BLEACHED_CHALK.get());
                for (DyeColor colour : JinxedCreativeCategoryHelper.colourOrderBackToFront) {
                    pOutput.accept(ACBlocks.getChalk(colour.getId()));
                }
                pOutput.accept(ACItems.BLEACHDEW_PAINTBRUSH.get());
                for (DyeColor colour : JinxedCreativeCategoryHelper.colourOrderBackToFront) {
                    pOutput.accept(ACItems.getPaintBrush(colour.getId()));
                }
                for (DyeColor colour : JinxedCreativeCategoryHelper.colourOrderBackToFront) {
                    pOutput.accept(ACBlocks.getDyedFlowerPot(colour.getId()));
                }
                for (DyeColor colour : JinxedCreativeCategoryHelper.colourOrderBackToFront) {
                    pOutput.accept(ACItems.getDyedDecoratedPotBlockItem(colour));
                }
                pOutput.accept(ACBlocks.GYPSUM.get());
                pOutput.accept(ACBlocks.GYPSUM_STAIRS.get());
                pOutput.accept(ACBlocks.GYPSUM_SLAB.get());
                pOutput.accept(ACBlocks.GYPSUM_WALL.get());
                pOutput.accept(ACBlocks.POLISHED_GYPSUM.get());
                pOutput.accept(ACBlocks.POLISHED_GYPSUM_STAIRS.get());
                pOutput.accept(ACBlocks.POLISHED_GYPSUM_SLAB.get());
                pOutput.accept(ACBlocks.POLISHED_GYPSUM_WALL.get());
                pOutput.accept(ACBlocks.GYPSUM_BRICKS.get());
                pOutput.accept(ACBlocks.GYPSUM_BRICK_STAIRS.get());
                pOutput.accept(ACBlocks.GYPSUM_BRICK_SLAB.get());
                pOutput.accept(ACBlocks.GYPSUM_BRICK_WALL.get());

                pOutput.accept(ACBlocks.PLASTER.get());
                for (DyeColor colour : JinxedCreativeCategoryHelper.colourOrderBackToFront) {
                    pOutput.accept(ACBlocks.getDyedPlaster(colour.getId()));
                }

                pOutput.accept(ACBlocks.SOAPSTONE.get());
                pOutput.accept(ACBlocks.SOAPSTONE_STAIRS.get());
                pOutput.accept(ACBlocks.SOAPSTONE_SLAB.get());
                pOutput.accept(ACBlocks.SOAPSTONE_WALL.get());
                for (DyeColor colour : JinxedCreativeCategoryHelper.colourOrderBackToFront) {
                    pOutput.accept(ACBlocks.getDyedSoapstone(colour.getId()));
                    pOutput.accept(ACBlocks.getDyedSoapstoneStairs(colour.getId()));
                    pOutput.accept(ACBlocks.getDyedSoapstoneSlab(colour.getId()));
                    pOutput.accept(ACBlocks.getDyedSoapstoneWall(colour.getId()));
                }
                pOutput.accept(ACBlocks.POLISHED_SOAPSTONE.get());
                pOutput.accept(ACBlocks.POLISHED_SOAPSTONE_STAIRS.get());
                pOutput.accept(ACBlocks.POLISHED_SOAPSTONE_SLAB.get());
                pOutput.accept(ACBlocks.POLISHED_SOAPSTONE_WALL.get());
                for (DyeColor colour : JinxedCreativeCategoryHelper.colourOrderBackToFront) {
                    pOutput.accept(ACBlocks.getDyedPolishedSoapstone(colour.getId()));
                    pOutput.accept(ACBlocks.getDyedPolishedSoapstoneStairs(colour.getId()));
                    pOutput.accept(ACBlocks.getDyedPolishedSoapstoneSlab(colour.getId()));
                    pOutput.accept(ACBlocks.getDyedPolishedSoapstoneWall(colour.getId()));
                }
                pOutput.accept(ACBlocks.SOAPSTONE_BRICKS.get());
                pOutput.accept(ACBlocks.SOAPSTONE_BRICK_STAIRS.get());
                pOutput.accept(ACBlocks.SOAPSTONE_BRICK_SLAB.get());
                pOutput.accept(ACBlocks.SOAPSTONE_BRICK_WALL.get());
                for (DyeColor colour : JinxedCreativeCategoryHelper.colourOrderBackToFront) {
                    pOutput.accept(ACBlocks.getDyedSoapstoneBricks(colour.getId()));
                    pOutput.accept(ACBlocks.getDyedSoapstoneBrickStairs(colour.getId()));
                    pOutput.accept(ACBlocks.getDyedSoapstoneBrickSlab(colour.getId()));
                    pOutput.accept(ACBlocks.getDyedSoapstoneBrickWall(colour.getId()));
                }
                for (DyeColor colour : JinxedCreativeCategoryHelper.colourOrderBackToFront) {
                    pOutput.accept(ACBlocks.getDyedMudBricks(colour.getId()));
                    pOutput.accept(ACBlocks.getDyedMudBrickStairs(colour.getId()));
                    pOutput.accept(ACBlocks.getDyedMudBrickSlab(colour.getId()));
                    pOutput.accept(ACBlocks.getDyedMudBrickWall(colour.getId()));
                }
                for (PietraforteColour colour : PietraforteColour.values()) {
                    pOutput.accept(ACBlocks.getPietraforte(colour));
                    pOutput.accept(ACBlocks.getPietraforteStairs(colour));
                    pOutput.accept(ACBlocks.getPietraforteSlab(colour));
                    pOutput.accept(ACBlocks.getPietraforteWall(colour));

                    pOutput.accept(ACBlocks.getCobbledPietraforte(colour));
                    pOutput.accept(ACBlocks.getCobbledPietraforteStairs(colour));
                    pOutput.accept(ACBlocks.getCobbledPietraforteSlab(colour));
                    pOutput.accept(ACBlocks.getCobbledPietraforteWall(colour));

                    pOutput.accept(ACBlocks.getChiseledPietraforte(colour));

                    pOutput.accept(ACBlocks.getPietraforteBricks(colour));
                    pOutput.accept(ACBlocks.getPietraforteBrickStairs(colour));
                    pOutput.accept(ACBlocks.getPietraforteBrickSlab(colour));
                    pOutput.accept(ACBlocks.getPietraforteBrickWall(colour));

                    pOutput.accept(ACBlocks.getPietrafortePillar(colour));

                    pOutput.accept(ACBlocks.getSmoothPietraforte(colour));
                    pOutput.accept(ACBlocks.getSmoothPietraforteStairs(colour));
                    pOutput.accept(ACBlocks.getSmoothPietraforteSlab(colour));
                    pOutput.accept(ACBlocks.getSmoothPietraforteWall(colour));

                    pOutput.accept(ACBlocks.getCutPietraforte(colour));
                    pOutput.accept(ACBlocks.getCutPietraforteStairs(colour));
                    pOutput.accept(ACBlocks.getCutPietraforteSlab(colour));
                    pOutput.accept(ACBlocks.getCutPietraforteWall(colour));
                }
            })
            .build()
    );

    public static Supplier<CreativeModeTab> registerTab(String name, Supplier<CreativeModeTab> supplier) {
        return JinxedRegistryHelper.registerCreativeModeTab(ArtsAndCrafts.MOD_ID, name, supplier);
    }

    public static void register() {}
}
