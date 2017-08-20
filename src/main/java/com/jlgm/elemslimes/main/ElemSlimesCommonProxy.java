package com.jlgm.elemslimes.main;

import com.jlgm.elemslimes.block.ElemSlimesBlock;
import com.jlgm.elemslimes.entity.ElemSlimesEntities;
import com.jlgm.elemslimes.item.ElemSlimesItem;
import com.jlgm.elemslimes.tileentity.ElemSlimesTileEntity;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod.EventBusSubscriber
public class ElemSlimesCommonProxy{

	public void preInit(FMLPreInitializationEvent preInitEvent){
		ElemSlimesEntities.init();
		ElemSlimesTileEntity.registerTileEntity();
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event){
		ElemSlimesBlock.registerBlocks(event);
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event){
		ElemSlimesBlock.registerItemBlocks(event);
		ElemSlimesItem.registerItems(event);
	}
	

	public void init(FMLInitializationEvent initEvent){
		
	}

	public void postInit(FMLPostInitializationEvent postInitEvent){

	}
}
