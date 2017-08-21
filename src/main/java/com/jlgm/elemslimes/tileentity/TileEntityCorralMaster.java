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
			
			/*for(BlockPos pos : listOfPoles) {
				System.out.println(this.world.getBlockState(pos).getBlock());
			}*/
			
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
			
			/*for(BlockPos pos : listOfPoles) {
				System.out.println(this.world.getBlockState(pos).getBlock());
			}*/
		}
		
		//Check for screens
		ArrayList<BlockPos> listOfScreens = new ArrayList<BlockPos>();
		listOfScreens.add(pos.up());
		listOfScreens.add(pos.offset(facing.rotateY()));
		listOfScreens.add(pos.offset(facing.rotateYCCW()));
		listOfScreens.add(pos.offset(facing.rotateY()).up());
		listOfScreens.add(pos.offset(facing.rotateYCCW()).up());
		/*for(BlockPos pos : listOfScreens) {
			System.out.println(this.world.getBlockState(pos).getBlock());
		}*/
		
		//Check for panels
		//FRONT
		ArrayList<BlockPos> listOfPanels = new ArrayList<BlockPos>();
		for(BlockPos pos : BlockPos.getAllInBox(pos.up(2).offset(facing.rotateY(), 2), pos.up(3).offset(facing.rotateYCCW(), 2))) {
			listOfPanels.add(pos);
		}
		listOfPanels.add(pos.offset(facing.rotateY(), 2));
		listOfPanels.add(pos.offset(facing.rotateY(), 2).up());
		listOfPanels.add(pos.offset(facing.rotateYCCW(), 2));
		listOfPanels.add(pos.offset(facing.rotateYCCW(), 2).up());
		
		//BACK
		for(BlockPos pos : BlockPos.getAllInBox(pos.offset(facing, 6).offset(facing.rotateY(), 2).up(3), pos.offset(facing, 6).offset(facing.rotateYCCW(), 2).up())) {
			listOfPanels.add(pos);
		}
		listOfPanels.add(pos.offset(facing, 6).offset(facing.rotateY(), 2));
		listOfPanels.add(pos.offset(facing, 6).offset(facing.rotateY(), 1));
		listOfPanels.add(pos.offset(facing, 6).offset(facing.rotateYCCW(), 2));
		listOfPanels.add(pos.offset(facing, 6).offset(facing.rotateYCCW(), 1));
		
		//RIGHT
		for(BlockPos pos : BlockPos.getAllInBox(pos.offset(facing, 3).offset(facing.rotateY(), 3).offset(facing, 2).up(3), pos.offset(facing, 3).offset(facing.rotateY(), 3).offset(facing.getOpposite(), 2).up(1))) {
			listOfPanels.add(pos);
		}
		listOfPanels.add(pos.offset(facing, 3).offset(facing.rotateY(), 3).offset(facing, 2));
		listOfPanels.add(pos.offset(facing, 3).offset(facing.rotateY(), 3).offset(facing, 1));
		listOfPanels.add(pos.offset(facing, 3).offset(facing.rotateY(), 3).offset(facing.getOpposite(), 2));
		listOfPanels.add(pos.offset(facing, 3).offset(facing.rotateY(), 3).offset(facing.getOpposite(), 1));
		
		//LEFT
		for(BlockPos pos : BlockPos.getAllInBox(pos.offset(facing, 3).offset(facing.rotateYCCW(), 3).offset(facing, 2).up(3), pos.offset(facing, 3).offset(facing.rotateYCCW(), 3).offset(facing.getOpposite(), 2).up(1))) {
			listOfPanels.add(pos);
		}
		listOfPanels.add(pos.offset(facing, 3).offset(facing.rotateYCCW(), 3).offset(facing, 2));
		listOfPanels.add(pos.offset(facing, 3).offset(facing.rotateYCCW(), 3).offset(facing, 1));
		listOfPanels.add(pos.offset(facing, 3).offset(facing.rotateYCCW(), 3).offset(facing.getOpposite(), 2));
		listOfPanels.add(pos.offset(facing, 3).offset(facing.rotateYCCW(), 3).offset(facing.getOpposite(), 1));
		
		/*for(BlockPos pos : listOfPanels) {
			System.out.println(this.world.getBlockState(pos).getBlock());
		}*/
		
		ArrayList<BlockPos> listOfInputs = new ArrayList<BlockPos>();
		listOfInputs.add(pos.offset(facing, 6));
		listOfInputs.add(pos.offset(facing, 3).offset(facing.rotateY(), 3));
		listOfInputs.add(pos.offset(facing, 3).offset(facing.rotateYCCW(), 3));
		
		/*for(BlockPos pos : listOfInputs) {
			System.out.println(this.world.getBlockState(pos).getBlock());
		}*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
