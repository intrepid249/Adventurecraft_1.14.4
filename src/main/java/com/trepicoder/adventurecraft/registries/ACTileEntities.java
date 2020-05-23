package com.trepicoder.adventurecraft.registries;

import com.trepicoder.adventurecraft.blocks.tileentities.ACChoppingBlockTEContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ACTileEntities {
    public static TileEntityType<?> CHOPPING_BLOCK;

    @ObjectHolder("adventurecraft:chopping_block")
    public static ContainerType<ACChoppingBlockTEContainer> CHOPPING_BLOCK_CONTAINER;

    public static TileEntityType<?> WOODPILE;
}
