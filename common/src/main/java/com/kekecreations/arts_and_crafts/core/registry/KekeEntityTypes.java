package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.common.entity.CustomDyeSheep;
import com.kekecreations.arts_and_crafts.core.misc.RegistryHelper;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class KekeEntityTypes {


    public static final RegistrySupplier<EntityType<? extends CustomDyeSheep>> CUSTOM_DYE_SHEEP = RegistryHelper.ENTITY_TYPES.register("sheep", () -> EntityType.Builder.of(CustomDyeSheep::new, MobCategory.CREATURE).sized(0.9f, 1.3f).clientTrackingRange(10).build("sheep"));


    public static void register() {
        createMobAttributes();
    }
    public static void createMobAttributes() {
        EntityAttributeRegistry.register(CUSTOM_DYE_SHEEP, CustomDyeSheep::createAttributes);
    }
}
