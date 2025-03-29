package com.kekecreations.arts_and_crafts.neoforge.common.modifier;

import com.google.common.base.Suppliers;
import com.kekecreations.arts_and_crafts.core.platform.Services;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ConfigModifyItemModifier extends LootModifier {
    public static final Supplier<MapCodec<ConfigModifyItemModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.mapCodec((inst) -> codecStart(inst).and(BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter((m) -> m.item)).apply(inst, ConfigModifyItemModifier::new)));
    private final Item item;

    public ConfigModifyItemModifier(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item;
    }

    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        for(LootItemCondition condition : this.conditions) {
            if (!condition.test(context)) {
                return generatedLoot;
            }
        }

        if (Services.CONFIG.aprilFools2025()) {
            if (context.getRandom().nextFloat() < 0.08F) {
                generatedLoot.clear();
                generatedLoot.add(new ItemStack(this.item));
            }
        }

        return generatedLoot;
    }

    public MapCodec<? extends IGlobalLootModifier> codec() {
        return (MapCodec)CODEC.get();
    }
}
