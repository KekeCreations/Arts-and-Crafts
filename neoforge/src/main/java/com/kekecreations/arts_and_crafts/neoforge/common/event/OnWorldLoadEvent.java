package com.kekecreations.arts_and_crafts.neoforge.common.event;

import com.kekecreations.arts_and_crafts.core.init.ACValidSigns;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.LevelEvent;

public class OnWorldLoadEvent {


    @SubscribeEvent
    public void onWorldLoad(LevelEvent.Load event) {
        ACValidSigns.add();
    }
}
