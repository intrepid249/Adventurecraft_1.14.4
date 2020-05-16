package com.trepicoder.adventurecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.OakTree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Random;

//public class ACSugarmapleSapling extends SaplingBlock {
//    public ACSugarmapleSapling() {
//        super(new OakTree(), Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.2f).sound(SoundType.PLANT));
//    }
//
//    @Override
//    public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
//        super.grow(worldIn, rand, pos, state);
//    }
//
//    @Override
//    public void grow(IWorld worldIn, BlockPos pos, BlockState state, Random rand) {
//        super.grow(worldIn, pos, state, rand);
//    }
//
//    @Override
//    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
//        return super.getShape(state, worldIn, pos, context);
//    }
//}
