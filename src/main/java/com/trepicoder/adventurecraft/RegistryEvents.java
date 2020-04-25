package com.trepicoder.adventurecraft;

import com.trepicoder.adventurecraft.registries.ACItemGroup;
import com.trepicoder.adventurecraft.registries.ACItems;
import com.trepicoder.adventurecraft.registries.ACToolMaterials;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.trepicoder.adventurecraft.Adventurecraft.MODID;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        Adventurecraft.LOGGER.info("\n\n============\nRegistering Items...\n============\n\n");
        event.getRegistry().registerAll(
                //region Tools
                //region Flint

                // NB. p_i48530_3_ = Attack speed. Adds 4 to the parameter input
                // NB. p_i48530_2_ = Attack damage modifier. Adds 1 + parameter input to the tool material attack damage
                ACItems.flint_hatchet = new AxeItem(ACToolMaterials.FLINT, 2f, 1.2f, new Item.Properties().group(ACItemGroup.TOOLS))
                        .setRegistryName(location("tools/flint_hatchet")),

                ACItems.flint_knife = new SwordItem(ACToolMaterials.FLINT, -1, 2.4f, new Item.Properties().group(ACItemGroup.TOOLS))
                        .setRegistryName(location("tools/flint_knife")),
                ACItems.treetap = new
                //endregion

                //endregion

                //======================================================================

                //region Misc
                ACItems.plantfibres = new Item(new Item.Properties().group(ACItemGroup.MISC))
                        .setRegistryName(location("misc/plantfibres")),
                ACItems.twine = new Item(new Item.Properties().group(ACItemGroup.MISC))
                        .setRegistryName(location("misc/twine")),
                ACItems.treesap = new Item(new Item.Properties().group(ACItemGroup.MISC))
                        .setRegistryName(location("misc/treesap"))
                //endregion
        );
    }

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {

    }

    private static ResourceLocation location(String name) {
        return new ResourceLocation(MODID, name);
    }
}
