package com.trepicoder.adventurecraft.blocks;

import com.trepicoder.adventurecraft.blockstateproperties.WoodpileFullness;
import com.trepicoder.adventurecraft.registries.ACBlockStateProperties;
import com.trepicoder.adventurecraft.utils.VoxelShapeHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class ACWoodpile extends HorizontalBlock {
    public ACWoodpile() {
        super(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f).sound(SoundType.WOOD));
        setDefaultState(getDefaultState().with(ACBlockStateProperties.WOODPILE_FULLNESS, WoodpileFullness.EMPTY));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

        VoxelShape floor = VoxelShapes.create(0, 0, 0, 1, 0.1875d, 1);
        VoxelShape leftWall = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING), 0, 0, 0, 1, 16, 16);
        VoxelShape rightWall = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING), 15, 0, 0, 16, 16, 16);
        VoxelShape backWall = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING), 0, 0, 15, 16, 16, 16);
        VoxelShape frontWall = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING), 1, 4, 0, 15, 11, 1);

        VoxelShape contents = VoxelShapes.create(0, 0, 0, 0, 0, 0);

        switch (state.get(ACBlockStateProperties.WOODPILE_FULLNESS)) {
            default:
            case EMPTY:
                break;
            case SHALLOW:
                contents = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING), 1, 4, 1, 14, 7, 14);
                break;
            case HALF:
                contents = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING), 1, 4, 1, 14, 10, 14);
                break;
            case FULL:
                contents = VoxelShapeHelper.createRotatedShape(state.get(BlockStateProperties.HORIZONTAL_FACING), 1, 4, 1, 14, 13, 14);
                break;
        }

        return VoxelShapes.or(floor, leftWall, rightWall, backWall, frontWall, contents);
    }

    @Override
    public boolean isSolid(BlockState state) {
        return false;
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {

    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockstate = super.getStateForPlacement(context);

        if (blockstate != null) {
            blockstate = blockstate
                    .with(BlockStateProperties.HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite())
                    .with(ACBlockStateProperties.WOODPILE_FULLNESS, WoodpileFullness.EMPTY);
        }
        return blockstate;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> container) {
        container.add(BlockStateProperties.HORIZONTAL_FACING);
        container.add(ACBlockStateProperties.WOODPILE_FULLNESS);
    }
}
