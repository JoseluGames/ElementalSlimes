package com.jlgm.elemslimes.tileentity;

import java.awt.List;
import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class TileEntityCorralMaster extends TileEntity{
	public void checkForCorral(EnumFacing facing) {
		//Check for poles
		int longDistance = 6;
		int shortDistance = 3;
		
		if(facing.getAxisDirection() == EnumFacing.AxisDirection.NEGATIVE) {
			longDistance *= -1;
		}
		
		if(facing.getAxis() == EnumFacing.Axis.X) {
			ArrayList<BlockPos> listOfPoles = new ArrayList<BlockPos>();
			for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() - shortDistance, this.getPos().getX(), this.getPos().getY() + 3, this.getPos().getZ() - shortDistance)) {
				listOfPoles.add(pos);
			}
			for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + shortDistance, this.getPos().getX(), this.getPos().getY() + 3, this.getPos().getZ() + shortDistance)) {
				listOfPoles.add(pos);
			}
			for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() + longDistance, this.getPos().getY(), this.getPos().getZ() - shortDistance, this.getPos().getX() + longDistance, this.getPos().getY() + 3, this.getPos().getZ() - shortDistance)) {
				listOfPoles.add(pos);
			}
			for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() + longDistance, this.getPos().getY(), this.getPos().getZ() + shortDistance, this.getPos().getX() + longDistance, this.getPos().getY() + 3, this.getPos().getZ() + shortDistance)) {
				listOfPoles.add(pos);
			}
			
			for(BlockPos pos : listOfPoles) {
				System.out.println(this.world.getBlockState(pos).getBlock());
			}
			
		} else if(facing.getAxis() == EnumFacing.Axis.Z) {
			ArrayList<BlockPos> listOfPoles = new ArrayList<BlockPos>();
			for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() - shortDistance, this.getPos().getY(), this.getPos().getZ(), this.getPos().getX() - shortDistance, this.getPos().getY() + 3, this.getPos().getZ())) {
				listOfPoles.add(pos);
			}
			for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() + shortDistance, this.getPos().getY(), this.getPos().getZ(), this.getPos().getX() + shortDistance, this.getPos().getY() + 3, this.getPos().getZ())) {
				listOfPoles.add(pos);
			}
			for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() - shortDistance, this.getPos().getY(), this.getPos().getZ() + longDistance, this.getPos().getX() - shortDistance, this.getPos().getY() + 3, this.getPos().getZ() + longDistance)) {
				listOfPoles.add(pos);
			}
			for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() + shortDistance, this.getPos().getY(), this.getPos().getZ() + longDistance, this.getPos().getX() + shortDistance, this.getPos().getY() + 3, this.getPos().getZ() + longDistance)) {
				listOfPoles.add(pos);
			}
			
			for(BlockPos pos : listOfPoles) {
				System.out.println(this.world.getBlockState(pos).getBlock());
			}
		}
	}
}
