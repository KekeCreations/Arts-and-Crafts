package com.kekecreations.arts_and_crafts.forge.mixin;

import com.kekecreations.arts_and_crafts.client.renderer.ArtsAndCraftsBlockEntityWithoutLevelRenderer;
import com.kekecreations.arts_and_crafts.common.item.DyedDecoratedPotBlockItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.spongepowered.asm.mixin.Mixin;

import java.util.function.Consumer;

@Mixin(DyedDecoratedPotBlockItem.class)
public class DyedDecoratedPotBlockItemMixin extends Item {

    public DyedDecoratedPotBlockItemMixin(Properties arg) {
        super(arg);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new ArtsAndCraftsBlockEntityWithoutLevelRenderer();
            }
        });
    }

}
