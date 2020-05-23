package com.trepicoder.adventurecraft.blocks;

import com.trepicoder.adventurecraft.Adventurecraft;
import com.trepicoder.adventurecraft.registries.ACTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class ACChoppingBlock extends Block {
    public ACChoppingBlock() {
        super(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f).sound(SoundType.WOOD));
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.create(0, 0, 0, 1, 0.3125f, 1);
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        player.swingArm(Hand.MAIN_HAND);

        if (!worldIn.isRemote) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof INamedContainerProvider) {
                // Open the chopping block gui!! :D
                NetworkHooks.openGui((ServerPlayerEntity)player,(INamedContainerProvider)tileEntity, tileEntity.getPos());
            }
        }

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public boolean hasTileEntity() {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        Adventurecraft.LOGGER.debug("Create " + state.getBlock().getRegistryName().getPath() +" tile entity");
        return ACTileEntities.CHOPPING_BLOCK.create();
    }
}
