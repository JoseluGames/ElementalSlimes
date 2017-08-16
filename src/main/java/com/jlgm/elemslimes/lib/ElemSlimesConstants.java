package com.jlgm.elemslimes.lib;

public class ElemSlimesConstants{
	//The name "behind the scenes"
	public static final String MODID = "jlgm_elemslimes";
	//The public name
	public static final String NAME = "Elemental Slimes";
	
	//Version parts ( https://mcforge.readthedocs.io/en/latest/conventions/versioning/ )
	public static final String MAJOR = "0";
	public static final String MINOR = "0";
	public static final String PATCH = "1";
	public static final String RELEASETYPE = "";
	
	//The version of the mod
	public static final String VERSION = MAJOR + "." + MINOR + "." + PATCH + RELEASETYPE;
	//The Minecraft verstion this mod is focused to work with
	public static final String ACCEPTEDMINECRAFTVERSIONS = "[1.12, 1.12.1]";
	
	//The package route of the proxys
	public static final String CLIENT_PROXY = "com.jlgm.elemslimes.main.ElemSlimesClientProxy";
	public static final String SERVER_PROXY = "com.jlgm.elemslimes.main.ElemSlimesServerProxy";
	
	//The URL to the update file
	public static final String UPDATEJSON = "https://raw.githubusercontent.com/JoseluGames/JoseluGamesUpdateCheckers/master/" + MODID + ".json";
}
