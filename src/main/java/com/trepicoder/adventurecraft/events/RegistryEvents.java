package com.trepicoder.adventurecraft.events;

import com.trepicoder.adventurecraft.Adventurecraft;
import com.trepicoder.adventurecraft.blocks.ACWoodLogBlock;
import com.trepicoder.adventurecraft.registries.ACBlocks;
import com.trepicoder.adventurecraft.registries.ACItemGroup;
import com.trepicoder.adventurecraft.registries.ACItems;
import com.trepicoder.adventurecraft.registries.ACToolMaterials;
import com.trepicoder.adventurecraft.tools.ACWoodenTreetap;
import net.minecraft.advancements.Advancement;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

import static com.trepicoder.adventurecraft.Adventurecraft.MODID;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        Block block = event.getState().getBlock();
        PlayerEntity player = event.getPlayer();

        Adventurecraft.LOGGER.debug(block.getRegistryName());

        if (block == ACBlocks.sugarmaple_log && (player.getHeldItemMainhand().isEmpty() || !(player.getHeldItemMainhand().getItem() instanceof ToolItem))) {
            event.setNewSpeed(0);
        }
    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        Adventurecraft.LOGGER.info("\n\n============\nRegistering Items...\n============\n\n");
        event.getRegistry().registerAll(
                //region Tools
                //region Flint

                // NB. p_i48530_3_ = Attack speed. Adds 4 to the parameter input
                // NB. p_i48530_2_ = Attack damage modifier. Adds 1 + parameter input to the tool material attack damage
                ACItems.flint_hatchet = new AxeItem(ACToolMaterials.FLINT, 2f, 1.2f, new Item.Properties().group(ACItemGroup.TOOLS))
                        .setRegistryName(location("flint_hatchet")),

                ACItems.flint_knife = new SwordItem(ACToolMaterials.FLINT, -1, 2.4f, new Item.Properties().group(ACItemGroup.TOOLS))
                        .setRegistryName(location("flint_knife")),
                ACItems.wooden_treetap = new ACWoodenTreetap(ACToolMaterials.WOOD, -1, 2.5f, new Item.Properties().group(ACItemGroup.TOOLS)
                        .setNoRepair())
                        .setRegistryName(location("wooden_treetap")),
                //endregion

                //endregion

                //======================================================================

                //region Misc
                ACItems.plantfibres = new Item(new Item.Properties().group(ACItemGroup.MISC))
                        .setRegistryName(location("plantfibres")),
                ACItems.twine = new Item(new Item.Properties().group(ACItemGroup.MISC))
                        .setRegistryName(location("twine")),
                ACItems.treesap = new Item(new Item.Properties().group(ACItemGroup.MISC))
                        .setRegistryName(location("treesap")),
                //endregion

                //region Item Blocks
                //region Wood
                ACItems.sugarmaple_log = new BlockItem(ACBlocks.sugarmaple_log, new Item.Properties().group(ACItemGroup.BUILDINGBLOCKS))
                        .setRegistryName(location("sugarmaple_log")),

                ACItems.sugarmaple_planks = new BlockItem(ACBlocks.sugarmaple_planks, new Item.Properties().group(ACItemGroup.BUILDINGBLOCKS))
                        .setRegistryName(location("sugarmaple_planks"))
                //endregion
                //endregion
        );
    }

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                //region Wood
                ACBlocks.sugarmaple_log = new ACWoodLogBlock(Block.Properties.create(Material.WOOD)
                        .hardnessAndResistance(2.0f).sound(SoundType.WOOD).harvestTool(ToolType.AXE)).setRegistryName(location("sugarmaple_log")),

                ACBlocks.sugarmaple_planks = new Block(Block.Properties.create(Material.WOOD)
                        .hardnessAndResistance(2.0f).sound(SoundType.WOOD).harvestTool(ToolType.AXE)).setRegistryName(location("sugarmaple_planks"))
                //endregion
                //endregion
        );
    }

    private static ResourceLocation location(String name) {
        return new ResourceLocation(MODID, name);
    }
}
