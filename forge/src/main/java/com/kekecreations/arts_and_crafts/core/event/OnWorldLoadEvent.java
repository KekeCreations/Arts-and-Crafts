package com.kekecreations.arts_and_crafts.core.event;

import com.kekecreations.arts_and_crafts.core.init.ACValidSigns;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OnWorldLoadEvent {

    @SubscribeEvent
    public void onWorldLoad(LevelEvent.Load event) {
        ACValidSigns.register();
    }
}
