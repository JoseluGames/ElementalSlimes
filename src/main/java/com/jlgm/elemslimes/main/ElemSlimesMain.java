package com.jlgm.elemslimes.main;

import com.jlgm.elemslimes.lib.ElemSlimesConstants;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ElemSlimesConstants.MODID,
	name = ElemSlimesConstants.NAME,
	version = ElemSlimesConstants.VERSION,
	acceptedMinecraftVersions = ElemSlimesConstants.ACCEPTEDMINECRAFTVERSIONS,
	updateJSON = ElemSlimesConstants.UPDATEJSON)

public class ElemSlimesMain{

	@SidedProxy(clientSide = ElemSlimesConstants.CLIENT_PROXY, serverSide = ElemSlimesConstants.SERVER_PROXY)
	public static ElemSlimesCommonProxy proxy;
	@Mod.Instance(ElemSlimesConstants.MODID)
	public static ElemSlimesMain instance;

	@Mod.EventHandler
	public static void PreInit(FMLPreInitializationEvent preInitEvent){
		proxy.preInit(preInitEvent);
	}

	@Mod.EventHandler
	public static void Init(FMLInitializationEvent initEvent){
		proxy.init(initEvent);
	}

	@Mod.EventHandler
	public static void PostInit(FMLPostInitializationEvent postInitEvent){
		proxy.postInit(postInitEvent);
	}
}
