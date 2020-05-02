package com.trepicoder.adventurecraft;

import com.trepicoder.adventurecraft.events.BlockEvents;
import com.trepicoder.adventurecraft.registries.ACBlockColors;
import net.minecraft.advancements.Advancement;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

@Mod("adventurecraft")
public class Adventurecraft {
    public static final String MODID = "adventurecraft";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public Adventurecraft() {
        // Register the mod class to handle event subscription
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new BlockEvents(LOGGER));
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
//        ACBlockColors.registerBlockColors();
    }

    @SubscribeEvent
    /**
     * Handle server startup events (includes single player "server")
     */
    public void onServerStarting(FMLServerStartingEvent event) {
        MinecraftServer server = event.getServer();

        LOGGER.info("Adventurecraft is deregistering its own datapack so that it overrides every other datapack");
        server.getCommandManager().handleCommand(server.getCommandSource().withPermissionLevel(2), "datapack disable \"mod:adventurecraft\"");


        LOGGER.info("Clearing default advancements");
        server.getAdvancementManager().getAllAdvancements().removeIf(advancement -> advancement.getId().getNamespace().contains("minecraft"));
    }

    @SubscribeEvent
    /**
     * Handle server stopping events (includes single player "server")
     */
    public void onServerStopping(FMLServerStoppingEvent event) {

    }
}
