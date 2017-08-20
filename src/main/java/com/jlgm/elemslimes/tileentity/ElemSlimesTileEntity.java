package com.jlgm.elemslimes.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ElemSlimesTileEntity{
	public static void registerTileEntity(){
		GameRegistry.registerTileEntity(TileEntityCorralBlock1.class, "corralBlock1_tileEntity");
	}
}
