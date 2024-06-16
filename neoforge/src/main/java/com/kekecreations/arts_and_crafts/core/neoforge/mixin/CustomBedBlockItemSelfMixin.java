package com.kekecreations.arts_and_crafts.core.neoforge.mixin;

import com.kekecreations.arts_and_crafts.client.renderer.bewlr.ArtsAndCraftsBEWLR;
import com.kekecreations.arts_and_crafts.common.item.ACBedBlockItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.spongepowered.asm.mixin.Mixin;

import java.util.function.Consumer;

@Mixin(ACBedBlockItem.class)
public class CustomBedBlockItemSelfMixin extends Item {

    public CustomBedBlockItemSelfMixin(Properties arg) {
        super(arg);
    }


    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new ArtsAndCraftsBEWLR();
            }
        });
    }
}
