package com.trepicoder.adventurecraft.blocks.tileentities;

import com.trepicoder.adventurecraft.registries.ACTileEntities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ACChoppingBlockTE extends TileEntity implements INamedContainerProvider {
    public ACChoppingBlockTE() {
        super(ACTileEntities.CHOPPING_BLOCK);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return super.getCapability(cap, side);
    }

    @Override
    public ITextComponent getDisplayName() {
        String name = getType().getRegistryName().getPath().replaceAll("_", " ");
        return new StringTextComponent(name);
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity player) {
        return new ACChoppingBlockTEContainer(i, world, pos, playerInventory);
    }
}
