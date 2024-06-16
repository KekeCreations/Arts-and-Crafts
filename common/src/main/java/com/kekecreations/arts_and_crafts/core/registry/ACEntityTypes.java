package com.kekecreations.arts_and_crafts.core.registry;


import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.common.entity.*;
import com.kekecreations.arts_and_crafts.core.platform.Services;
import com.kekecreations.arts_and_crafts.core.platform.services.IPlatformHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ACEntityTypes {

    public static final Supplier<EntityType<FloatingBlockEntity>> FLOATING_BLOCK = registerEntityType("floating_block", () ->
            EntityType.Builder.of(FloatingBlockEntity::new, MobCategory.MISC)
                    .sized(0.98f, 0.98f)
                    .clientTrackingRange(10)
                    //.updateInterval(20)
                    .build(dataFixer("floating_block")));



    public static final Supplier<EntityType<ACBoat>> BOAT = registerEntityType("boat", () ->
            EntityType.Builder.of((EntityType.EntityFactory<ACBoat>) ACBoat::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f)
                    .clientTrackingRange(10)
                    .build(dataFixer("boat")));


    public static final Supplier<EntityType<ACChestBoat>> CHEST_BOAT = registerEntityType("chest_boat", () ->
            EntityType.Builder.of((EntityType.EntityFactory<ACChestBoat>) ACChestBoat::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f)
                    .clientTrackingRange(10)
                    .build(dataFixer("chest_boat")));


    public static final Supplier<BlockEntityType<DyedDecoratedPotBlockEntity>> CUSTOM_DECORATED_POT_BLOCK_ENTITY = registerBlockEntityType("custom_decorated_pot_block_entity", () ->
                    createBlockEntity(DyedDecoratedPotBlockEntity::new,
                    ACBlocks.getDyedDecoratedPot(DyeColor.WHITE.getId()),
                    ACBlocks.getDyedDecoratedPot(DyeColor.ORANGE.getId()),
                    ACBlocks.getDyedDecoratedPot(DyeColor.MAGENTA.getId()),
                    ACBlocks.getDyedDecoratedPot(DyeColor.LIGHT_BLUE.getId()),
                    ACBlocks.getDyedDecoratedPot(DyeColor.YELLOW.getId()),
                    ACBlocks.getDyedDecoratedPot(DyeColor.LIME.getId()),
                    ACBlocks.getDyedDecoratedPot(DyeColor.PINK.getId()),
                    ACBlocks.getDyedDecoratedPot(DyeColor.GRAY.getId()),
                    ACBlocks.getDyedDecoratedPot(DyeColor.LIGHT_GRAY.getId()),
                    ACBlocks.getDyedDecoratedPot(DyeColor.CYAN.getId()),
                    ACBlocks.getDyedDecoratedPot(DyeColor.PURPLE.getId()),
                    ACBlocks.getDyedDecoratedPot(DyeColor.BLUE.getId()),
                    ACBlocks.getDyedDecoratedPot(DyeColor.BROWN.getId()),
                    ACBlocks.getDyedDecoratedPot(DyeColor.GREEN.getId()),
                    ACBlocks.getDyedDecoratedPot(DyeColor.RED.getId()),
                    ACBlocks.getDyedDecoratedPot(DyeColor.BLACK.getId())
            )
    );

    public static final Supplier<BlockEntityType<ACBedBlockEntity>> CUSTOM_BED_BLOCK_ENTITY = registerBlockEntityType("custom_bed_block_entity", () ->
            createBlockEntity(ACBedBlockEntity::new,
                    ACBlocks.BLEACHED_BED.get()
            )
    );


    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntityType(String name, Supplier<BlockEntityType<T>> type) {
        return Services.REGISTRY.registerBlockEntityType(name, type);
    }
    private static <T extends BlockEntity> BlockEntityType<T> createBlockEntity(IPlatformHelper.BlockEntitySupplier<T> blockEntitySupplier, Block... blocks) {
        return Services.PLATFORM.createBlockEntity(blockEntitySupplier, blocks);
    }

    private static <T extends EntityType<?>> Supplier<T> registerEntityType(String name, Supplier<T> entityTypeSupplier) {
        return Services.REGISTRY.registerEntityType(name, entityTypeSupplier);
    }

    public static void register() {
        createMobAttributes();
    }

    public static void createMobAttributes() {
    }

    private static String dataFixer(String mobName) {
        return ArtsAndCrafts.MOD_ID + ":" + mobName;
    }
}
