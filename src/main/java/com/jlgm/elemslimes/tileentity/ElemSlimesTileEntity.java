package com.jlgm.elemslimes.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ElemSlimesTileEntity{
	public static void registerTileEntity(){
		GameRegistry.registerTileEntity(TileEntityCorralMaster.class, "corralBlock1_tileEntity");
	}
}
