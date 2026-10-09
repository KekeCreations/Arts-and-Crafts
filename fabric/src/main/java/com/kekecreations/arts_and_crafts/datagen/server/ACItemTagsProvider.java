package com.kekecreations.arts_and_crafts.datagen.server;

import com.kekecreations.arts_and_crafts.core.init.ACTags;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ACItemTagsProvider extends FabricTagProvider.ItemTagProvider {


    public ACItemTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        appendDecoratedPots();
        appendDecoratedPotSherds();

    }

    private void appendDecoratedPots() {
        for (DyeColor colours : DyeColor.values()) {
            this.valueLookupBuilder(ACTags.ItemTags.DECORATED_POTS)
                    .add(Items.DECORATED_POT)
                    .add(ACItems.getDyedDecoratedPotBlockItem(colours));
        }
    }
    private void appendDecoratedPotSherds() {
        this.valueLookupBuilder(ItemTags.DECORATED_POT_SHERDS)
                .add(ACItems.ROLL_POTTERY_SHERD.get())
                .add(ACItems.RUINED_POTTERY_SHERD.get())
                .add(ACItems.FINALE_POTTERY_SHERD.get())
                .add(ACItems.GATEWAY_POTTERY_SHERD.get())
                .add(ACItems.POTTERY_SHERD.get())
                .add(ACItems.SUS_POTTERY_SHERD.get());
    }
}
