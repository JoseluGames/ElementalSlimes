package com.jlgm.elemslimes.main;

import com.jlgm.elemslimes.block.ElemSlimesBlock;
import com.jlgm.elemslimes.entity.ElemSlimesEntities;
import com.jlgm.elemslimes.item.ElemSlimesItem;
import com.jlgm.elemslimes.lib.ElemSlimesConstants;
import com.jlgm.elemslimes.lib.EnumElemSlimesTypes;
import com.jlgm.elemslimes.tileentity.ElemSlimesTileEntity;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ElemSlimesCommonProxy{

	public void preInit(FMLPreInitializationEvent preInitEvent){
		EnumElemSlimesTypes.registerLoots();
		ElemSlimesEntities.init();
		ElemSlimesTileEntity.registerTileEntity();
	}
	
	public void init(FMLInitializationEvent initEvent){
		
	}

	public void postInit(FMLPostInitializationEvent postInitEvent){

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
}
