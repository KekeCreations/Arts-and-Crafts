package com.kekecreations.arts_and_crafts.fabric.core.datagen.client;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlockFamilies;
import com.kekecreations.arts_and_crafts.core.registry.KekeBlocks;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;

public class ArtsAndCraftsModelProvider extends FabricModelProvider {
    public ArtsAndCraftsModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {


        KekeBlockFamilies.getFamilies().filter(BlockFamily::shouldGenerateModel).forEach(family -> blockStateModelGenerator.family(family.getBaseBlock()).generateFor((BlockFamily)family));

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
    }
}
