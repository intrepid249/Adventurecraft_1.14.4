package com.trepicoder.adventurecraft.events;

import com.trepicoder.adventurecraft.Adventurecraft;
import com.trepicoder.adventurecraft.blocks.*;
import com.trepicoder.adventurecraft.blocks.tileentities.ACChoppingBlockTE;
import com.trepicoder.adventurecraft.blocks.tileentities.ACChoppingBlockTEContainer;
import com.trepicoder.adventurecraft.registries.*;
import com.trepicoder.adventurecraft.tools.ACWoodenTreetap;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.FoliageColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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
                ACItems.stickpile = new Item(new Item.Properties().group(ACItemGroup.MISC))
                        .setRegistryName(location("stickbundle")),
                //endregion

                //region Item Blocks
                //region Wood
                ACItems.sugarmaple_log = new BlockItem(ACBlocks.sugarmaple_log, new Item.Properties().group(ACItemGroup.BUILDINGBLOCKS))
                        .setRegistryName(location("sugarmaple_log")),

                ACItems.sugarmaple_planks = new BlockItem(ACBlocks.sugarmaple_planks, new Item.Properties().group(ACItemGroup.BUILDINGBLOCKS))
                        .setRegistryName(location("sugarmaple_planks")),
                ACItems.sugarmaple_leaves = new BlockItem(ACBlocks.sugarmaple_leaves, new Item.Properties().group(ACItemGroup.BUILDINGBLOCKS))
                        .setRegistryName(location("sugarmaple_leaves")),
//                ACItems.sugarmaple_sapling = new BlockItem(ACBlocks.sugarmaple_sapling, new Item.Properties().group(ACItemGroup.MISC))
//                        .setRegistryName(location("sugarmaple_sapling")),
                ACItems.firewood_fresh = new BlockItem(ACBlocks.firewood_fresh, new Item.Properties().group(ACItemGroup.BUILDINGBLOCKS))
                        .setRegistryName(location("firewood_fresh")),
                ACItems.firewood_seasoned = new BlockItem(ACBlocks.firewood_seasoned, new Item.Properties().group(ACItemGroup.BUILDINGBLOCKS))
                        .setRegistryName(location("firewood_seasoned")),
                //endregion

                //region Tile Entities
                ACItems.campfire = new BlockItem(ACBlocks.campfire, new Item.Properties().group(ACItemGroup.MISC))
                        .setRegistryName(location("campfire")),

                ACItems.acacia_chopping_block = new BlockItem(ACBlocks.acacia_chopping_block, new Item.Properties().group(ACItemGroup.BUILDINGBLOCKS))
                        .setRegistryName(location("acacia_chopping_block")),
                ACItems.birch_chopping_block = new BlockItem(ACBlocks.birch_chopping_block, new Item.Properties().group(ACItemGroup.BUILDINGBLOCKS))
                        .setRegistryName(location("birch_chopping_block")),
                ACItems.dark_oak_chopping_block = new BlockItem(ACBlocks.dark_oak_chopping_block, new Item.Properties().group(ACItemGroup.BUILDINGBLOCKS))
                        .setRegistryName(location("dark_oak_chopping_block")),
                ACItems.jungle_chopping_block = new BlockItem(ACBlocks.jungle_chopping_block, new Item.Properties().group(ACItemGroup.BUILDINGBLOCKS))
                        .setRegistryName(location("jungle_chopping_block")),
                ACItems.oak_chopping_block = new BlockItem(ACBlocks.oak_chopping_block, new Item.Properties().group(ACItemGroup.BUILDINGBLOCKS))
                        .setRegistryName(location("oak_chopping_block")),
                ACItems.spruce_chopping_block = new BlockItem(ACBlocks.spruce_chopping_block, new Item.Properties().group(ACItemGroup.BUILDINGBLOCKS))
                        .setRegistryName(location("spruce_chopping_block")),
                ACItems.sugarmaple_chopping_block = new BlockItem(ACBlocks.sugarmaple_chopping_block, new Item.Properties().group(ACItemGroup.BUILDINGBLOCKS))
                        .setRegistryName(location("sugarmaple_chopping_block")),

                ACItems.woodpile = new BlockItem(ACBlocks.woodpile, new Item.Properties().group(ACItemGroup.BUILDINGBLOCKS))
                        .setRegistryName(location("woodpile"))
                //endregion
                //endregion
        );
    }

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                //region Wood
                ACBlocks.sugarmaple_log = new ACWoodLogBlock(Block.Properties.create(Material.WOOD)
                        .hardnessAndResistance(2.0f).sound(SoundType.WOOD).harvestTool(ToolType.AXE)).setRegistryName(RegistryEvents.location("sugarmaple_log")),

                ACBlocks.sugarmaple_planks = new Block(Block.Properties.create(Material.WOOD)
                        .hardnessAndResistance(2.0f).sound(SoundType.WOOD).harvestTool(ToolType.AXE)).setRegistryName(RegistryEvents.location("sugarmaple_planks")),

                ACBlocks.sugarmaple_leaves = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2f).sound(SoundType.PLANT).tickRandomly())
                        .setRegistryName(RegistryEvents.location("sugarmaple_leaves")),

//                ACBlocks.sugarmaple_sapling = new ACSugarmapleSapling().setRegistryName(location("sugarmaple_sapling")),
                //endregion

                ACBlocks.firewood_fresh = new ACFirewood(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0f).sound(SoundType.WOOD))
                        .setRegistryName(RegistryEvents.location("firewood_fresh")),
                ACBlocks.firewood_seasoned = new ACFirewood(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0f).sound(SoundType.WOOD))
                        .setRegistryName(RegistryEvents.location("firewood_seasoned")),

                //region Tile Entities
                ACBlocks.campfire = new ACCampfire().setRegistryName(RegistryEvents.location("campfire")),

                ACBlocks.acacia_chopping_block = new ACChoppingBlock().setRegistryName(RegistryEvents.location("acacia_chopping_block")),
                ACBlocks.birch_chopping_block = new ACChoppingBlock().setRegistryName(RegistryEvents.location("birch_chopping_block")),
                ACBlocks.dark_oak_chopping_block = new ACChoppingBlock().setRegistryName(RegistryEvents.location("dark_oak_chopping_block")),
                ACBlocks.jungle_chopping_block = new ACChoppingBlock().setRegistryName(RegistryEvents.location("jungle_chopping_block")),
                ACBlocks.oak_chopping_block = new ACChoppingBlock().setRegistryName(RegistryEvents.location("oak_chopping_block")),
                ACBlocks.spruce_chopping_block = new ACChoppingBlock().setRegistryName(RegistryEvents.location("spruce_chopping_block")),
                ACBlocks.sugarmaple_chopping_block = new ACChoppingBlock().setRegistryName(RegistryEvents.location("sugarmaple_chopping_block")),

                ACBlocks.woodpile = new ACWoodpile().setRegistryName(RegistryEvents.location("woodpile"))
                //endregion
        );
    }

    @SubscribeEvent
    public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event) {
        event.getRegistry().registerAll(
                TileEntityType.Builder.create(ACChoppingBlockTE::new, ACBlocks.acacia_chopping_block).build(null).setRegistryName(location("acacia_chopping_block")),
                TileEntityType.Builder.create(ACChoppingBlockTE::new, ACBlocks.birch_chopping_block).build(null).setRegistryName(location("birch_chopping_block")),
                TileEntityType.Builder.create(ACChoppingBlockTE::new, ACBlocks.dark_oak_chopping_block).build(null).setRegistryName(location("dark_oak_chopping_block")),
                TileEntityType.Builder.create(ACChoppingBlockTE::new, ACBlocks.jungle_chopping_block).build(null).setRegistryName(location("jungle_chopping_block")),
                TileEntityType.Builder.create(ACChoppingBlockTE::new, ACBlocks.oak_chopping_block).build(null).setRegistryName(location("oak_chopping_block")),
                TileEntityType.Builder.create(ACChoppingBlockTE::new, ACBlocks.spruce_chopping_block).build(null).setRegistryName(location("spruce_chopping_block")),
                TileEntityType.Builder.create(ACChoppingBlockTE::new, ACBlocks.sugarmaple_chopping_block).build(null).setRegistryName(location("sugarmaple_chopping_block"))
        );
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event) {
        event.getRegistry().register(
                IForgeContainerType.create((windowId, inv, data) -> {
                    BlockPos pos = data.readBlockPos();
                    return new ACChoppingBlockTEContainer(windowId, Minecraft.getInstance().world, pos, inv);
                }).setRegistryName(location("chopping_block")));
    }

    @SubscribeEvent
    public static void registerBlockColorHandler(final ColorHandlerEvent.Block event) {
        final BlockColors blockColors = event.getBlockColors();

        // Use the foliage color of the biome or the default color
        final IBlockColor leafColorHandler = (state, blockAccess, pos, tintIndex) -> {
//            if (blockAccess != null && pos != null) {
//                return BiomeColors.getFoliageColor(blockAccess, pos);
//            }

            return FoliageColors.get(0.9598D, 0.0008D);
        };

        blockColors.register(leafColorHandler, ACBlocks.sugarmaple_leaves);
    }

    @SubscribeEvent
    public static void registerItemColorHandler(final ColorHandlerEvent.Item event) {
        final BlockColors blockColors = event.getBlockColors();
        final ItemColors itemColors = event.getItemColors();

        final IItemColor itemBlockColorHandler = (stack, tintIndex) -> {
            final BlockState state = ((BlockItem)stack.getItem()).getBlock().getDefaultState();
            return blockColors.getColor(state, null, null, tintIndex);
        };

        itemColors.register(itemBlockColorHandler, ACItems.sugarmaple_leaves);
    }

    public static ResourceLocation location(String name) {
        return new ResourceLocation(MODID, name);
    }
}
