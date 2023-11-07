package com.kekecreations.arts_and_crafts.common.entity;

import com.google.common.collect.Maps;
import com.kekecreations.arts_and_crafts.common.item.CustomDyeItem;
import com.kekecreations.arts_and_crafts.core.registry.KekeDyeColours;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomDyeSheep extends Sheep {

    private static final EntityDataAccessor<Byte> DATA_WOOL_ID;
    private static final Map<DyeColor, ItemLike> ITEM_BY_DYE;
    private static final Map<KekeDyeColours, float[]> COLORARRAY_BY_COLOR;

    private static float[] createSheepColor(KekeDyeColours dyeColor) {
        if (dyeColor == KekeDyeColours.WHITE) {
            return new float[]{0.9019608F, 0.9019608F, 0.9019608F};
        } else {
            float[] fs = dyeColor.getTextureDiffuseColors();
            float f = 0.75F;
            return new float[]{fs[0] * f, fs[1] * f, fs[2] * f};
        }
    }

    @Environment(EnvType.CLIENT)
    public static float[] getColorArray(KekeDyeColours dyeColor) {
        return (float[])COLORARRAY_BY_COLOR.get(dyeColor);
    }

    public CustomDyeSheep(EntityType<? extends CustomDyeSheep> entityType, Level level) {
        super(entityType, level);
    }

    public KekeDyeColours getColour() {
        return KekeDyeColours.byId((Byte)this.entityData.get(DATA_WOOL_ID) & 15);
    }

    public void setColor(KekeDyeColours dyeColor) {
        byte b = (Byte)this.entityData.get(DATA_WOOL_ID);
        this.entityData.set(DATA_WOOL_ID, (byte)(b & 240 | dyeColor.getId() & 15));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_WOOL_ID, (byte)0);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean("Sheared", this.isSheared());
        compoundTag.putByte("Color", (byte)this.getColour().getId());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setSheared(compoundTag.getBoolean("Sheared"));
        this.setColor(KekeDyeColours.byId(compoundTag.getByte("Color")));
    }

    public InteractionResult mobInteract(Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (itemStack.is(Items.SHEARS)) {
            if (!this.level().isClientSide && this.readyForShearing()) {
                this.shear(SoundSource.PLAYERS);
                this.gameEvent(GameEvent.SHEAR, player);
                itemStack.hurtAndBreak(1, player, (playerx) -> {
                    playerx.broadcastBreakEvent(interactionHand);
                });
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.CONSUME;
            }
        }
        if (itemStack.getItem() instanceof CustomDyeItem customDyeItem) {
            this.setColor(customDyeItem.getDyeColor());
        }
        return super.mobInteract(player, interactionHand);
    }

    public ResourceLocation getDefaultLootTable() {
        if (this.isSheared()) {
            return this.getType().getDefaultLootTable();
        } else {
            ResourceLocation var10000;
            switch (this.getColour()) {
                case CREAM:
                    var10000 = BuiltInLootTables.SHEEP_YELLOW;
                    break;
                case CRIMSON:
                    var10000 = BuiltInLootTables.SHEEP_RED;
                    break;
                case WHITE:
                    var10000 = BuiltInLootTables.SHEEP_WHITE;
                    break;
                default:
                    throw new IncompatibleClassChangeError();
            }

            return var10000;
        }
    }


    static {
        DATA_WOOL_ID = SynchedEntityData.defineId(CustomDyeSheep.class, EntityDataSerializers.BYTE);
        ITEM_BY_DYE = (Map)Util.make(Maps.newEnumMap(DyeColor.class), (enumMap) -> {
            enumMap.put(DyeColor.WHITE, Blocks.WHITE_WOOL);
            enumMap.put(DyeColor.ORANGE, Blocks.ORANGE_WOOL);
            enumMap.put(DyeColor.MAGENTA, Blocks.MAGENTA_WOOL);
            enumMap.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_WOOL);
            enumMap.put(DyeColor.YELLOW, Blocks.YELLOW_WOOL);
            enumMap.put(DyeColor.LIME, Blocks.LIME_WOOL);
            enumMap.put(DyeColor.PINK, Blocks.PINK_WOOL);
            enumMap.put(DyeColor.GRAY, Blocks.GRAY_WOOL);
            enumMap.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_WOOL);
            enumMap.put(DyeColor.CYAN, Blocks.CYAN_WOOL);
            enumMap.put(DyeColor.PURPLE, Blocks.PURPLE_WOOL);
            enumMap.put(DyeColor.BLUE, Blocks.BLUE_WOOL);
            enumMap.put(DyeColor.BROWN, Blocks.BROWN_WOOL);
            enumMap.put(DyeColor.GREEN, Blocks.GREEN_WOOL);
            enumMap.put(DyeColor.RED, Blocks.RED_WOOL);
            enumMap.put(DyeColor.BLACK, Blocks.BLACK_WOOL);
        });
        COLORARRAY_BY_COLOR = Maps.newEnumMap((Map) Arrays.stream(KekeDyeColours.values()).collect(Collectors.toMap((dyeColor) -> {
            return dyeColor;
        }, CustomDyeSheep::createSheepColor)));
    }



}
