package com.kekecreations.arts_and_crafts.core.registry;


import com.kekecreations.arts_and_crafts.common.item.ChalkStickItem;
import com.kekecreations.arts_and_crafts.core.misc.RegistryHelper;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.Item;

public class KekeItems {


    public static final RegistrySupplier<ChalkStickItem> WHITE_CHALK_STICK = RegistryHelper.ITEMS.register("white_chalk_stick", () -> new ChalkStickItem(new Item.Properties().stacksTo(1).durability(32)));




    public static void register() {
    }
}
