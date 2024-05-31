package com.kekecreations.arts_and_crafts.core.forge.event;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.registry.KekeItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ArtsAndCrafts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LootTableLoadEvent extends net.minecraftforge.event.LootTableLoadEvent {
    public LootTableLoadEvent(ResourceLocation name, LootTable table) {
        super(name, table);
    }

    private static final ResourceLocation SNIFFER_DIGGING = new ResourceLocation("gameplay/sniffer_digging");

    @SubscribeEvent
    public void lootLoad(LootTableLoadEvent evt) {
        if (evt.getName().equals(SNIFFER_DIGGING)) {
            evt.getTable().addPool(LootPool.lootPool().when(LootItemRandomChanceCondition.randomChance(0.3F)).add(LootItem.lootTableItem(KekeItems.LOTUS_PISTILS.get()))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2))).build());
        }
    }
}
