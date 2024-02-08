package com.kekecreations.arts_and_crafts.fabric.datagen.client;

import com.kekecreations.arts_and_crafts.core.misc.NaturalDyeColor;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import com.kekecreations.arts_and_crafts.fabric.registry.KekeFabricBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.DyeColor;
import org.apache.commons.lang3.StringUtils;

public class ArtsAndCraftsLangProvider extends FabricLanguageProvider {
    public ArtsAndCraftsLangProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        for (DyeColor colours : DyeColor.values()) {
            String stringColour = StringUtils.capitalize(StringUtils.replace(StringUtils.replace(StringUtils.replace(colours.getName(), "blue", "Blue"), "gray" ,"Gray"), "_", " "));
            String stringNaturalColour = StringUtils.capitalize(NaturalDyeColor.byId(colours.getId()).getName());

            //ITEMS
            translationBuilder.add(KekeItems.getChalkStick(colours), stringColour + " Chalk Stick");


            //BLOCKS
            translationBuilder.add(KekeBlocks.getDyedFlowerPot(colours), stringColour + " Flower Pot");
            translationBuilder.add(KekeBlocks.getChalkDust(colours), stringColour + " Chalk Dust");
            translationBuilder.add(KekeBlocks.getChalk(colours), stringColour + " Chalk");

            translationBuilder.add(KekeBlocks.getDyedTerracottaShingles(colours), stringColour + " Terracotta Shingles");
            translationBuilder.add(KekeBlocks.getDyedTerracottaShingleSlab(colours), stringColour + " Terracotta Shingle Slab");
            translationBuilder.add(KekeBlocks.getDyedTerracottaShingleWall(colours), stringColour + " Terracotta Shingle Wall");
            translationBuilder.add(KekeBlocks.getDyedTerracottaShingleStairs(colours), stringColour + " Terracotta Shingle Stairs");

            translationBuilder.add(KekeBlocks.getDyedSoapstone(colours), stringNaturalColour + " Soapstone");
            translationBuilder.add(KekeBlocks.getDyedSoapstoneSlab(colours), stringNaturalColour + " Soapstone Slab");
            translationBuilder.add(KekeBlocks.getDyedSoapstoneWall(colours), stringNaturalColour + " Soapstone Wall");
            translationBuilder.add(KekeBlocks.getDyedSoapstoneStairs(colours), stringNaturalColour + " Soapstone Stairs");

            translationBuilder.add(KekeBlocks.getDyedSoapstoneBricks(colours), stringNaturalColour + " Soapstone Bricks");
            translationBuilder.add(KekeBlocks.getDyedSoapstoneBrickSlab(colours), stringNaturalColour + " Soapstone Brick Slab");
            translationBuilder.add(KekeBlocks.getDyedSoapstoneBrickWall(colours), stringNaturalColour + " Soapstone Brick Wall");
            translationBuilder.add(KekeBlocks.getDyedSoapstoneBrickStairs(colours), stringNaturalColour + " Soapstone Brick Stairs");
        }
        translationBuilder.add(KekeBlocks.TERRACOTTA_SHINGLES.get(), "Terracotta Shingles");
        translationBuilder.add(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get(), "Terracotta Shingle Slab");
        translationBuilder.add(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get(), "Terracotta Shingle Wall");
        translationBuilder.add(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), "Terracotta Shingle Stairs");
        translationBuilder.add(KekeBlocks.SOAPSTONE.get(), "Soapstone");
        translationBuilder.add(KekeBlocks.SOAPSTONE_SLAB.get(), "Soapstone Slab");
        translationBuilder.add(KekeBlocks.SOAPSTONE_WALL.get(), "Soapstone Wall");
        translationBuilder.add(KekeBlocks.SOAPSTONE_STAIRS.get(), "Soapstone Stairs");
        translationBuilder.add(KekeBlocks.SOAPSTONE_BRICKS.get(), "Soapstone Bricks");
        translationBuilder.add(KekeBlocks.SOAPSTONE_BRICK_SLAB.get(), "Soapstone Brick Slab");
        translationBuilder.add(KekeBlocks.SOAPSTONE_BRICK_WALL.get(), "Soapstone Brick Wall");
        translationBuilder.add(KekeBlocks.SOAPSTONE_BRICK_STAIRS.get(), "Soapstone Brick Stairs");


        translationBuilder.add(KekeFabricBlocks.CORK_PLANKS.get(), "Cork Planks");
        translationBuilder.add(KekeFabricBlocks.CORK_LOG.get(), "Cork Log");
        translationBuilder.add(KekeFabricBlocks.STRIPPED_CORK_LOG.get(), "Stripped Cork Log");
        translationBuilder.add(KekeBlocks.CORK_DOOR.get(), "Cork Door");
        translationBuilder.add(KekeBlocks.CORK_TRAPDOOR.get(), "Cork Trapdoor");
        translationBuilder.add(KekeBlocks.CORK_BUTTON.get(), "Cork Button");
        translationBuilder.add(KekeFabricBlocks.CORK_FENCE.get(), "Cork Fence");
        translationBuilder.add(KekeFabricBlocks.CORK_FENCE_GATE.get(), "Cork Fence Gate");
        translationBuilder.add(KekeBlocks.CORK_PRESSURE_PLATE.get(), "Cork Pressure Plate");
        translationBuilder.add(KekeFabricBlocks.CORK_SLAB.get(), "Cork Slab");
        translationBuilder.add(KekeFabricBlocks.CORK_STAIRS.get(), "Cork Stairs");
        translationBuilder.add(KekeBlocks.CORK_SIGN.get(), "Cork Sign");
        translationBuilder.add(KekeBlocks.CORK_HANGING_SIGN.get(), "Cork Hanging Sign");
        translationBuilder.add(KekeFabricBlocks.CORK_WOOD.get(), "Cork Wood");
        translationBuilder.add(KekeFabricBlocks.STRIPPED_CORK_WOOD.get(), "Stripped Cork Wood");
        translationBuilder.add(KekeBlocks.CORK.get(), "Cork");
        translationBuilder.add(KekeBlocks.SMOOTH_CORK.get(), "Smooth Cork");
        translationBuilder.add(KekeFabricBlocks.CORK_LEAVES.get(), "Cork Leaves");
        translationBuilder.add(KekeBlocks.CORK_SAPLING.get(), "Cork Sapling");
    }
}

