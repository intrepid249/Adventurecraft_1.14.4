package com.trepicoder.adventurecraft.features.trees;

//public class ACSugarmapleTree extends AbstractTreeFeature<NoFeatureConfig> {
//    private IBlockPosCheck replace;
//
//    public ACSugarmapleTree(boolean doBlockNofityOnPlace) {
//        super(NoFeatureConfig::deserialize, doBlockNofityOnPlace);
//
//        replace = (world, pos) -> world.getBlockState(pos).canBeReplacedByLeaves(world, pos) || world.getBlockState(pos).isIn(BlockTags.SAPLINGS) || world.getBlockState(pos).getBlock() instanceof BushBlock;
//    }
//
//    @Override
//    @ParametersAreNonnullByDefault
//    protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox p_208519_5_) {
//        return false;
//    }
//
//    public boolean setLeaves(IWorld world, BlockPos pos)
//    {
//        if (this.replace.matchesBlock(world, pos))
//        {
////            this.setBlockState(world, pos, this.leaves);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean setLog(Set<BlockPos> changedBlocks, IWorld world, BlockPos pos, MutableBoundingBox boundingBox)
//    {
//        return this.setLog(changedBlocks, world, pos, null, boundingBox);
//    }
//
//    public boolean setLog(Set<BlockPos> changedBlocks, IWorld world, BlockPos pos, Direction.Axis axis, MutableBoundingBox boundingBox)
//    {
////        BlockState directedLog = (axis != null && this.logAxisProperty != null) ? this.log.with(this.logAxisProperty, axis) : this.log;
//        if (this.replace.matchesBlock(world, pos))
//        {
//            // Logs must be added to the "changedBlocks" so that the leaves have their distance property updated,
//            // preventing incorrect decay
////            this.setLogState(changedBlocks, world, pos, directedLog, boundingBox);
//            return true;
//        }
//        return false;
//    }
//}
