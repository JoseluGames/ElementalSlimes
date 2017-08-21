package com.jlgm.elemslimes.tileentity;

import java.awt.List;
import java.util.ArrayList;

import net.minecraft.block.BlockPane;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class TileEntityCorralMaster extends TileEntity{
	public boolean checkForCorral(EnumFacing facing) {
		//Check for poles
		ArrayList<BlockPos> listOfPoles = new ArrayList<BlockPos>();
		for(BlockPos pos : BlockPos.getAllInBox(pos.offset(facing.rotateY(), 3).up(3), pos.offset(facing.rotateY(), 3))) {
			listOfPoles.add(pos);
		}
		for(BlockPos pos : BlockPos.getAllInBox(pos.offset(facing.rotateYCCW(), 3).up(3), pos.offset(facing.rotateYCCW(), 3))) {
			listOfPoles.add(pos);
		}
		for(BlockPos pos : BlockPos.getAllInBox(pos.offset(facing, 6).offset(facing.rotateY(), 3).up(3), pos.offset(facing, 6).offset(facing.rotateY(), 3))) {
			listOfPoles.add(pos);
		}
		for(BlockPos pos : BlockPos.getAllInBox(pos.offset(facing, 6).offset(facing.rotateYCCW(), 3).up(3), pos.offset(facing, 6).offset(facing.rotateYCCW(), 3))) {
			listOfPoles.add(pos);
		}
		
		for(BlockPos pos : listOfPoles) {
			if(!this.getWorld().getBlockState(pos).isNormalCube()) {
				System.out.println("POLES failed " + pos);
				return false;
			}
		}
		
		//Check for screensº
		ArrayList<BlockPos> listOfScreens = new ArrayList<BlockPos>();
		listOfScreens.add(pos.up());
		listOfScreens.add(pos.offset(facing.rotateY()));
		listOfScreens.add(pos.offset(facing.rotateYCCW()));
		listOfScreens.add(pos.offset(facing.rotateY()).up());
		listOfScreens.add(pos.offset(facing.rotateYCCW()).up());
		
		for(BlockPos pos : listOfScreens) {
			if(this.world.getBlockState(pos).getBlock() != Blocks.STONEBRICK) {
				System.out.println("SCREENS failed");
				return false;
			}
		}
		
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
		
		for(BlockPos pos : listOfPanels) {
			if(!(this.world.getBlockState(pos).getBlock() instanceof BlockPane)) {
				System.out.println("PANELS failed");
				return false;
			}
		}
		
		ArrayList<BlockPos> listOfInputs = new ArrayList<BlockPos>();
		listOfInputs.add(pos.offset(facing, 6));
		listOfInputs.add(pos.offset(facing, 3).offset(facing.rotateY(), 3));
		listOfInputs.add(pos.offset(facing, 3).offset(facing.rotateYCCW(), 3));
		
		for(BlockPos pos : listOfInputs) {
			if(this.world.getBlockState(pos).getBlock() != Blocks.STONEBRICK) {
				System.out.println("INPUTS failed");
				return false;
			}
		}
		
		ArrayList<BlockPos> listOfAirInside = new ArrayList<BlockPos>();
		for(BlockPos pos : BlockPos.getAllInBox(pos.offset(facing, 5).offset(facing.rotateY(), 2).up(4), pos.offset(facing, 1).offset(facing.rotateYCCW(), 2))) {
			listOfAirInside.add(pos);
		}
		
		for(BlockPos pos : listOfAirInside) {
			if(this.world.getBlockState(pos).getBlock() != Blocks.AIR) {
				System.out.println("INSIDE failed");
				return false;
			}
		}
		
		System.out.println("Corral succesful");
		return true;
	}
}
