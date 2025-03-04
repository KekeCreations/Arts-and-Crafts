package com.kekecreations.arts_and_crafts.core.platform;

import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import com.kekecreations.arts_and_crafts.core.platform.services.ConfigHelper;
import com.kekecreations.arts_and_crafts.core.platform.services.PlatformHelper;

import java.util.ServiceLoader;

public class Services {

    public static final PlatformHelper PLATFORM = load(PlatformHelper.class);
    public static final ConfigHelper CONFIG = load(ConfigHelper.class);

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        ArtsAndCrafts.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}
