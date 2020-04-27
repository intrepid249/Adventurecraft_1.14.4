package com.trepicoder.adventurecraft.events;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.Logger;


public class BlockEvents {
    private final Logger LOGGER;

    public BlockEvents(Logger logger) {
        LOGGER = logger;
    }

    @SubscribeEvent
    public void handleBreakSpeed(PlayerEvent.BreakSpeed event) {
        PlayerEntity player = event.getPlayer();

        if (!player.isCreative()) {
            ItemStack holding = player.getItemStackFromSlot(EquipmentSlotType.MAINHAND);

            if (event.getState().getHarvestTool() != null && !holding.getToolTypes().contains(event.getState().getHarvestTool())) {
                event.setCanceled(true);
            }
        }
    }
}
