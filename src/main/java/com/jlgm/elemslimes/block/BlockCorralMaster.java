package com.jlgm.elemslimes.block;

import com.jlgm.elemslimes.tileentity.TileEntityCorralMaster;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCorralMaster extends BlockContainer{
	
	protected BlockCorralMaster(Material materialIn) {
		super(materialIn);
	}
	
    /**
     * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
     * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
     */
	@Override
    public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityCorralMaster();
	}
	
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(worldIn.getTileEntity(pos) != null) {
	        TileEntityCorralMaster tileEntity = (TileEntityCorralMaster) worldIn.getTileEntity(pos);
	        tileEntity.checkForCorral(facing.getOpposite());
			return true;
		}else {
			return false;
		}
    }
}
