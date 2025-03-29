package com.kekecreations.arts_and_crafts.common.item.april_fools;

import com.kekecreations.arts_and_crafts.core.platform.Services;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;

public class ACFoolItem extends Item {

    public ACFoolItem(Properties properties) {
        super(properties);
    }


    @Override
    public boolean isEnabled(FeatureFlagSet $$0) {
        return Services.CONFIG.aprilFools2025();
    }
}
