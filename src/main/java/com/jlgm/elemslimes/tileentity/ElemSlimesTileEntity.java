package com.jlgm.elemslimes.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ElemSlimesTileEntity{
	public static void registerTileEntity(){
		GameRegistry.registerTileEntity(TileEntityCorralMaster.class, "corralMaster_tileEntity");
		GameRegistry.registerTileEntity(TileEntityCorralScreen.class, "corralScreen_tileEntity");
		GameRegistry.registerTileEntity(TileEntityCorralIO.class, "corralIO_tileEntity");
	}
}
