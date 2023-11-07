package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.common.item.CustomDyeItem;
import com.kekecreations.arts_and_crafts.core.misc.RegistryHelper;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.Item;

public class KekeItems {

    public static final RegistrySupplier<CustomDyeItem> CRIMSON_DYE = RegistryHelper.ITEMS.register("crimson_dye", () -> new CustomDyeItem(KekeDyeColours.CRIMSON, new Item.Properties()));

    public static final RegistrySupplier<CustomDyeItem> CREAM_DYE = RegistryHelper.ITEMS.register("cream_dye", () -> new CustomDyeItem(KekeDyeColours.CREAM, new Item.Properties()));


    public static void register() {
    }
}
