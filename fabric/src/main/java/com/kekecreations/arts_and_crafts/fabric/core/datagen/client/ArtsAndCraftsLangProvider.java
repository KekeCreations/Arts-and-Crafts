package com.kekecreations.arts_and_crafts.fabric.core.datagen.client;

import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
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

            //ITEMS
            translationBuilder.add(KekeItems.getChalkStick(colours), stringColour + " Chalk Stick");

            //BLOCKS
            translationBuilder.add(KekeBlocks.getChalkDust(colours), stringColour + " Chalk Dust");
            translationBuilder.add(KekeBlocks.getChalk(colours), stringColour + " Chalk");
            translationBuilder.add(KekeBlocks.getChalkSlab(colours), stringColour + " Chalk Slab");
            translationBuilder.add(KekeBlocks.getChalkWall(colours), stringColour + " Chalk Wall");
            translationBuilder.add(KekeBlocks.getChalkStairs(colours), stringColour + " Chalk Stairs");

            translationBuilder.add(KekeBlocks.getDyedTerracottaShingles(colours), stringColour + " Terracotta Shingles");
            translationBuilder.add(KekeBlocks.getDyedTerracottaShingleSlab(colours), stringColour + " Terracotta Shingle Slab");
            translationBuilder.add(KekeBlocks.getDyedTerracottaShingleWall(colours), stringColour + " Terracotta Shingle Wall");
            translationBuilder.add(KekeBlocks.getDyedTerracottaShingleStairs(colours), stringColour + " Terracotta Shingle Stairs");
        }
        translationBuilder.add(KekeBlocks.TERRACOTTA_SHINGLES.get(), "Terracotta Shingles");
        translationBuilder.add(KekeBlocks.TERRACOTTA_SHINGLE_SLAB.get(), "Terracotta Shingle Slab");
        translationBuilder.add(KekeBlocks.TERRACOTTA_SHINGLE_WALL.get(), "Terracotta Shingle Wall");
        translationBuilder.add(KekeBlocks.TERRACOTTA_SHINGLE_STAIRS.get(), "Terracotta Shingle Stairs");

    }
}

