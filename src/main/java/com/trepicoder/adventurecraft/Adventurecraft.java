package com.trepicoder.adventurecraft;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("adventurecraft")
public class Adventurecraft {
    public static final String MODID = "adventurecraft";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public Adventurecraft() {
        // Register the mod class to handle event subscription
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    /**
     * Handle server-side forge setup
     */
    public void serverSetup(FMLCommonSetupEvent event) {
        LOGGER.info("\n\n============\nPre-init Server Setup...\n============\n\n");
    }

    @SubscribeEvent
    /**
     * Handle client-side forge setup
     */
    public void clientSetup(FMLClientSetupEvent event) {
        LOGGER.info("\n\n============\nClient setup...\n============\n\n");
    }

    @SubscribeEvent
    /**
     * Handle server startup events (includes single player "server")
     */
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    @SubscribeEvent
    /**
     * Handle server stopping events (includes single player "server")
     */
    public void onServerStopping(FMLServerStoppingEvent event) {

    }
}
