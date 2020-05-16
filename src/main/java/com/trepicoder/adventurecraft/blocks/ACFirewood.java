package com.trepicoder.adventurecraft.blocks;

import com.trepicoder.adventurecraft.utils.VoxelShapeHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class ACFirewood extends HorizontalBlock {
    public ACFirewood(Properties builder) {
        super(builder);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        VoxelShape bottomLayer = VoxelShapes.create(0, 0, 0, 1, 0.25f, 1);
        VoxelShape topLayer = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING), 4, 4, 0, 12, 8, 16);

        return VoxelShapes.or(bottomLayer, topLayer);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockstate = super.getStateForPlacement(context);

        if (blockstate != null) {
            blockstate = blockstate.with(BlockStateProperties.HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
        }
        return blockstate;
    }

    @Override
    public boolean isSolid(BlockState state) {
        return false;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }
}
