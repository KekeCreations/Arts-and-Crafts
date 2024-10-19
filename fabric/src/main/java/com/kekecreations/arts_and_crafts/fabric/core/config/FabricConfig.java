package com.kekecreations.arts_and_crafts.fabric.core.config;

import blue.endless.jankson.Comment;
import blue.endless.jankson.Jankson;
import blue.endless.jankson.api.DeserializationException;
import blue.endless.jankson.api.SyntaxError;
import com.kekecreations.arts_and_crafts.ArtsAndCrafts;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

//Original file was wrote by https://github.com/Iamnotagenius. Massive thanks to them!
public class FabricConfig {
    private static File getConfigFile() {
        return Path.of(
                FabricLoader.getInstance().getConfigDir().toString(),
                ArtsAndCrafts.MOD_ID,
                "config.json5"
        ).toFile();
    }

    private static final Jankson JANKSON = Jankson.builder()
            .registerSerializer(ResourceLocation.class, (id, marshaller) -> marshaller.serialize(id.toString()))
            .registerDeserializer(String.class, ResourceLocation.class, (str, marshaller) -> ResourceLocation.tryParse(str))
            .build();

    public static Component lastError;

    public void save() throws FileNotFoundException {
        getConfigFile().getParentFile().mkdirs();
        try (var outStream = new FileOutputStream(getConfigFile())) {
            outStream.write(JANKSON.toJson(this).toJson(true, true).getBytes());
        } catch (IOException e) {
            ArtsAndCrafts.LOG.error("IO exception while saving config: {}", e.getMessage());
        }
    }

    public static FabricConfig load() {
        var defaults = new FabricConfig();
        try {
            if (getConfigFile().exists()) {
                lastError = null;
                var json = JANKSON.load(getConfigFile());
                return JANKSON.fromJsonCarefully(json, FabricConfig.class);
            }
            defaults.save();
            lastError = null;
            return defaults;
        } catch (SyntaxError e) {
            ArtsAndCrafts.LOG.error("Config syntax error. {}.", e.getLineMessage());
            ArtsAndCrafts.LOG.error(e.getMessage());
            ArtsAndCrafts.LOG.warn("Using default configuration.");
            lastError = Component.translatable("message.arts_and_crafts.error.config.general");
        } catch (DeserializationException e) {
            ArtsAndCrafts.LOG.error("MCDE's config deserialization error.");
            ArtsAndCrafts.LOG.error("{}", e.getMessage());
            if (e.getCause() != null) {
                ArtsAndCrafts.LOG.error("Cause: {}", e.getCause().getMessage());
            }
            ArtsAndCrafts.LOG.warn("Using default configuration.");
            lastError = Component.translatable("message.arts_and_crafts.error.config.general");
        } catch (IOException e) {
            ArtsAndCrafts.LOG.error("IO exception occured while reading config. Using defaults.");
            ArtsAndCrafts.LOG.error(e.getMessage());
            ArtsAndCrafts.LOG.warn("Using default configuration.");
            lastError = Component.translatable("message.arts_and_crafts.error.config.general");
        }
        return defaults;
    }

    public static FabricConfig readFromServer(FriendlyByteBuf buf) {
        try {
            return JANKSON.fromJsonCarefully(buf.readUtf(), FabricConfig.class);
        } catch (SyntaxError | DeserializationException e) {
            ArtsAndCrafts.LOG.error("Error while retrieving config from server: {}", e);
        }
        return null;
    }

    public void writeToClient(FriendlyByteBuf buf) {
        buf.writeUtf(JANKSON.toJson(this).toJson());
    }

    public static enum ListType {
        ALLOW, DENY
    }

    @Comment("Allows flower pots to be dyed when true. Default value: true")
    private boolean ENABLE_DYED_FLOWER_POTS = true;

    public boolean areDyedFlowerPotsEnabled() {
        return ENABLE_DYED_FLOWER_POTS;
    }
}
