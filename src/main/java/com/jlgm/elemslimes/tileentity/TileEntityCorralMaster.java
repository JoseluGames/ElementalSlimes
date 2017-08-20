package com.jlgm.elemslimes.tileentity;

import java.awt.List;
import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class TileEntityCorralMaster extends TileEntity{
	public void checkForCorral(EnumFacing facing) {
		//Check for poles
		if(facing.getAxis() == EnumFacing.Axis.X) {
			if(facing.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) {
				ArrayList<BlockPos> listOfPoles = new ArrayList<BlockPos>();
				for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() - 3, this.getPos().getX(), this.getPos().getY() + 3, this.getPos().getZ() - 3)) {
					listOfPoles.add(pos);
				}
				for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + 3, this.getPos().getX(), this.getPos().getY() + 3, this.getPos().getZ() + 3)) {
					listOfPoles.add(pos);
				}
				for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() + 6, this.getPos().getY(), this.getPos().getZ() - 3, this.getPos().getX() + 6, this.getPos().getY() + 3, this.getPos().getZ() - 3)) {
					listOfPoles.add(pos);
				}
				for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() + 6, this.getPos().getY(), this.getPos().getZ() + 3, this.getPos().getX() + 6, this.getPos().getY() + 3, this.getPos().getZ() + 3)) {
					listOfPoles.add(pos);
				}
				
				for(BlockPos pos : listOfPoles) {
					System.out.println(this.world.getBlockState(pos).getBlock());
				}
			}else if(facing.getAxisDirection() == EnumFacing.AxisDirection.NEGATIVE) {
				ArrayList<BlockPos> listOfPoles = new ArrayList<BlockPos>();
				for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() - 3, this.getPos().getX(), this.getPos().getY() + 3, this.getPos().getZ() - 3)) {
					listOfPoles.add(pos);
				}
				for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ() + 3, this.getPos().getX(), this.getPos().getY() + 3, this.getPos().getZ() + 3)) {
					listOfPoles.add(pos);
				}
				for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() - 6, this.getPos().getY(), this.getPos().getZ() - 3, this.getPos().getX() - 6, this.getPos().getY() + 3, this.getPos().getZ() - 3)) {
					listOfPoles.add(pos);
				}
				for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() - 6, this.getPos().getY(), this.getPos().getZ() + 3, this.getPos().getX() - 6, this.getPos().getY() + 3, this.getPos().getZ() + 3)) {
					listOfPoles.add(pos);
				}
				
				for(BlockPos pos : listOfPoles) {
					System.out.println(this.world.getBlockState(pos).getBlock());
				}
			}
		} else if(facing.getAxis() == EnumFacing.Axis.Z) {
			if(facing.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) {
				ArrayList<BlockPos> listOfPoles = new ArrayList<BlockPos>();
				for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() - 3, this.getPos().getY(), this.getPos().getZ(), this.getPos().getX() - 3, this.getPos().getY() + 3, this.getPos().getZ())) {
					listOfPoles.add(pos);
				}
				for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() + 3, this.getPos().getY(), this.getPos().getZ(), this.getPos().getX() + 3, this.getPos().getY() + 3, this.getPos().getZ())) {
					listOfPoles.add(pos);
				}
				for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() - 3, this.getPos().getY(), this.getPos().getZ() + 6, this.getPos().getX() - 3, this.getPos().getY() + 3, this.getPos().getZ() + 6)) {
					listOfPoles.add(pos);
				}
				for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() + 3, this.getPos().getY(), this.getPos().getZ() + 6, this.getPos().getX() + 3, this.getPos().getY() + 3, this.getPos().getZ() + 6)) {
					listOfPoles.add(pos);
				}
				
				for(BlockPos pos : listOfPoles) {
					System.out.println(this.world.getBlockState(pos).getBlock());
				}
			}else if(facing.getAxisDirection() == EnumFacing.AxisDirection.NEGATIVE) {
				ArrayList<BlockPos> listOfPoles = new ArrayList<BlockPos>();
				for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() - 3, this.getPos().getY(), this.getPos().getZ(), this.getPos().getX() - 3, this.getPos().getY() + 3, this.getPos().getZ())) {
					listOfPoles.add(pos);
				}
				for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() + 3, this.getPos().getY(), this.getPos().getZ(), this.getPos().getX() + 3, this.getPos().getY() + 3, this.getPos().getZ())) {
					listOfPoles.add(pos);
				}
				for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() - 3, this.getPos().getY(), this.getPos().getZ() - 6, this.getPos().getX() - 3, this.getPos().getY() + 3, this.getPos().getZ() - 6)) {
					listOfPoles.add(pos);
				}
				for(BlockPos pos : BlockPos.getAllInBox(this.getPos().getX() + 3, this.getPos().getY(), this.getPos().getZ() - 6, this.getPos().getX() + 3, this.getPos().getY() + 3, this.getPos().getZ() - 6)) {
					listOfPoles.add(pos);
				}
				
				for(BlockPos pos : listOfPoles) {
					System.out.println(this.world.getBlockState(pos).getBlock());
				}
			}
		}
	}
}
