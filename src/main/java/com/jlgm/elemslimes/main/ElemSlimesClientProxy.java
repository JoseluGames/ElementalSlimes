package com.jlgm.elemslimes.main;

import com.jlgm.elemslimes.entity.ElemSlimesEntities;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ElemSlimesClientProxy extends ElemSlimesCommonProxy{

	@Override
	public void preInit(FMLPreInitializationEvent preInitEvent){
		super.preInit(preInitEvent);
		ElemSlimesEntities.initModels();
	}

	@Override
	public void init(FMLInitializationEvent initEvent){
		super.init(initEvent);
	}

	@Override
	public void postInit(FMLPostInitializationEvent postInitEvent){
		super.postInit(postInitEvent);
	}
}
