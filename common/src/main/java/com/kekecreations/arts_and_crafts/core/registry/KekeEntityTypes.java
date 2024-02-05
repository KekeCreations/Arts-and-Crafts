package com.kekecreations.arts_and_crafts.core.registry;


import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.entity.FloatingBlockEntity;
import com.kekecreations.arts_and_crafts.core.platform.RegistryHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class KekeEntityTypes {

    public static final Supplier<EntityType<FloatingBlockEntity>> FLOATING_BLOCK = RegistryHelper.registerEntityType("floating_block", () ->
            EntityType.Builder.of(FloatingBlockEntity::new, MobCategory.MISC)
                    .sized(0.98f, 0.98f)
                    .clientTrackingRange(10)
                    //.updateInterval(20)
                    .build(dataFixer("floating_block")));






    public static void register() {
        createMobAttributes();
    }
    public static void createMobAttributes() {
    }

    private static String dataFixer(String mobName) {
        return ArtsAndCrafts.MOD_ID + ":" + mobName;
    }
}
