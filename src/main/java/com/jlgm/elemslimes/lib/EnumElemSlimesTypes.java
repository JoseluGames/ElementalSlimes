package com.jlgm.elemslimes.lib;

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
	
	public String getSlimeName() {
		return this.name + "_slime";
	}

	public String getPlortName() {
		return this.name + "_plort";
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
}
