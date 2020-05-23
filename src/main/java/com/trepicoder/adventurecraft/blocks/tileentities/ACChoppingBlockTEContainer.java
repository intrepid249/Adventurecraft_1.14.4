package com.trepicoder.adventurecraft.blocks.tileentities;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;

import static com.trepicoder.adventurecraft.registries.ACTileEntities.CHOPPING_BLOCK_CONTAINER;

public class ACChoppingBlockTEContainer extends Container {
    private TileEntity tileEntity;
    private PlayerEntity player;

    public ACChoppingBlockTEContainer(int id, World world, BlockPos pos, PlayerInventory playerInventory) {
        super(CHOPPING_BLOCK_CONTAINER, id);
        tileEntity = world.getTileEntity(pos);
        tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos()), playerIn, tileEntity.getBlockState().getBlock());
    }
}
