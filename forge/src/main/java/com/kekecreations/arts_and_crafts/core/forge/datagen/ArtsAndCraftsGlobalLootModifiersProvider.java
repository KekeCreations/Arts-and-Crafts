package com.kekecreations.arts_and_crafts.core.forge.datagen;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.forge.loot.ModifyItemModifier;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ArtsAndCraftsGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ArtsAndCraftsGlobalLootModifiersProvider(PackOutput output) {
        super(output, ArtsAndCrafts.MOD_ID);
    }

    @Override
    protected void start() {
        add("lotus_pistils_from_sniffer", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.SNIFFER_DIGGING).build() }, KekeItems.LOTUS_PISTILS.get()));

        //COMMON ARCHAEOLOGY
        add("ruined_pottery_sherd_from_archaeology_common", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON).build() }, KekeItems.RUINED_POTTERY_SHERD.get()));

        add("pottery_sherd_from_archaeology_common", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON).build() }, KekeItems.POTTERY_SHERD.get()));

        add("bleachdew_from_archaeology_common", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON).build() }, KekeItems.BLEACHDEW.get()));

        add("cork_hanging_sign_from_archaeology_common", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON).build() }, KekeItems.CORK_HANGING_SIGN.get()));

        //RARE ARCHAEOLOGY
        add("ruined_pottery_sherd_from_archaeology_rare", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE).build() }, KekeItems.RUINED_POTTERY_SHERD.get()));

        add("roll_pottery_sherd_from_archaeology_rare", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE).build() }, KekeItems.ROLL_POTTERY_SHERD.get()));

        add("finale_pottery_sherd_from_archaeology_rare", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE).build() }, KekeItems.FINALE_POTTERY_SHERD.get()));

        add("gateway_pottery_sherd_from_archaeology_rare", new ModifyItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE).build() }, KekeItems.GATEWAY_POTTERY_SHERD.get()));
    }
}