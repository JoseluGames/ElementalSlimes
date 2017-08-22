package com.jlgm.elemslimes.main;

import com.jlgm.elemslimes.block.ElemSlimesBlock;
import com.jlgm.elemslimes.entity.ElemSlimesEntities;
import com.jlgm.elemslimes.item.ElemSlimesItem;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
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
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event){
		ElemSlimesBlock.renderBlock();
		ElemSlimesItem.renderItem();
	}
}
