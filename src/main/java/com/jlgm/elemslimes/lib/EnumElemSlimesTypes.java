package com.jlgm.elemslimes.lib;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public enum EnumElemSlimesTypes {
	COAL("coal", 0),
	IRON("iron", 1),
	LAPIS("lapis", 2),
	GOLD("gold", 3),
	DIAMOND("diamond", 4),
	REDSTONE("redstone", 5),
	EMERALD("emerald", 6),
	QUARTZ("quartz", 7);
	
	private String name;
	private int id;
	
	EnumElemSlimesTypes(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSlimeName() {
		return "elementalslime_" + this.name;
	}

	public String getPlortName() {
		return "plort_" + this.name;
	}

	public String getEggName() {
		return "egg_" + this.name;
	}
	
	public ResourceLocation getLootTable() {
		return new ResourceLocation(ElemSlimesConstants.MODID, "entities/elementalslime/" + this.name);
	}
	
	public int getID() {
		return this.id;
	}
	
	public static EnumElemSlimesTypes byID(int id) {
		return EnumElemSlimesTypes.values()[id];
	}
	
	public static int getSize() {
		return EnumElemSlimesTypes.values().length;
	}
	
	public static void registerLoots() {
		for(int i = 0; i < EnumElemSlimesTypes.getSize(); i++) {
			LootTableList.register(new ResourceLocation(ElemSlimesConstants.MODID, "entities/elementalslime/" + EnumElemSlimesTypes.byID(i).getName()));
		}
	}
}
