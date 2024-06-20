package com.kekecreations.arts_and_crafts.core.neoforge.datagen;

import com.kekecreations.arts_and_crafts.core.neoforge.common.loot.ModifyItemModifier;
import com.kekecreations.arts_and_crafts.core.registry.ACItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ArtsAndCraftsGlobalLootModifiersProvider extends GlobalLootModifierProvider {

    public ArtsAndCraftsGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String modid) {
        super(output, registries, modid);
    }

    @Override
    protected void start() {
        add("lotus_pistils_from_sniffer", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.SNIFFER_DIGGING.location()).build() }, ACItems.LOTUS_PISTILS.get()));

        //COMMON ARCHAEOLOGY
        add("ruined_pottery_sherd_from_archaeology_common", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON.location()).build() }, ACItems.RUINED_POTTERY_SHERD.get()));

        add("pottery_sherd_from_archaeology_common", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON.location()).build() }, ACItems.POTTERY_SHERD.get()));

        add("bleachdew_from_archaeology_common", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON.location()).build() }, ACItems.BLEACHDEW.get()));

        add("cork_hanging_sign_from_archaeology_common", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON.location()).build() }, ACItems.CORK_HANGING_SIGN.get()));

        //RARE ARCHAEOLOGY
        add("ruined_pottery_sherd_from_archaeology_rare", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE.location()).build() }, ACItems.RUINED_POTTERY_SHERD.get()));

        add("roll_pottery_sherd_from_archaeology_rare", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE.location()).build() }, ACItems.ROLL_POTTERY_SHERD.get()));

        add("finale_pottery_sherd_from_archaeology_rare", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE.location()).build() }, ACItems.FINALE_POTTERY_SHERD.get()));

        add("gateway_pottery_sherd_from_archaeology_rare", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE.location()).build() }, ACItems.GATEWAY_POTTERY_SHERD.get()));
    }
}