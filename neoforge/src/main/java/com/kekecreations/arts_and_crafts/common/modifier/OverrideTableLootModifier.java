package com.kekecreations.arts_and_crafts.common.modifier;

import com.kekecreations.arts_and_crafts.core.registry.ACLootModifiers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class OverrideTableLootModifier extends LootModifier {


    /*
    public static final MapCodec<OverrideTableLootModifier> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            IGlobalLootModifier.LOOT_CONDITIONS_CODEC.fieldOf("conditions").forGetter(m -> m.conditions),
            ResourceKey.codec(Registries.LOOT_TABLE).fieldOf("table").forGetter(OverrideTableLootModifier::getTable)).apply(instance, OverrideTableLootModifier::new));


     */

    public static final MapCodec<OverrideTableLootModifier> CODEC = RecordCodecBuilder.mapCodec(instance -> codecStart(instance)
            .and(
                    ResourceKey.codec(Registries.LOOT_TABLE).fieldOf("table").forGetter(OverrideTableLootModifier::getTable))
            .apply(instance, OverrideTableLootModifier::new));


    private final ResourceKey<LootTable> table;


    public OverrideTableLootModifier(LootItemCondition[] conditions, int priority, ResourceKey<LootTable> table) {
        super(conditions, priority);
        this.table = table;
    }

    public ResourceKey<LootTable> getTable() {
        return this.table;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() < 0.1f) {
            generatedLoot.clear();
            context.getResolver().lookupOrThrow(Registries.LOOT_TABLE).get(this.table).ifPresent(extraTable -> {
                extraTable.value().getRandomItemsRaw(context, LootTable.createStackSplitter(context.getLevel(), generatedLoot::add));
            });
        }
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return ACLootModifiers.OVERRIDE_LOOT_MODIFIER.get();
    }
}