package com.jlgm.elemslimes.entity.monster;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class EntityElementalSlime extends EntitySlime{
	
	private static final DataParameter<Integer> SLIME_TYPE = EntityDataManager.<Integer>createKey(EntityElementalSlime.class, DataSerializers.VARINT);
	
	public EntityElementalSlime(World worldIn) {
		super(worldIn);
	}
	
	public String getType() {
		return EnumSlimeTypes.values()[this.dataManager.get(SLIME_TYPE)].getStringID();
	}
	
	@Override
    protected void entityInit(){
        super.entityInit();
        this.dataManager.register(SLIME_TYPE, Integer.valueOf(EnumSlimeTypes.COAL.getID()));
    }
	
	public void setType(EnumSlimeTypes type) {
		this.dataManager.set(SLIME_TYPE, Integer.valueOf(type.getID()));
	}
	
	public enum EnumSlimeTypes{
		COAL("coal_slime", 0),
		IRON("iron_slime", 1),
		LAPIS("lapis_slime", 2),
		GOLD("gold_slime", 3),
		DIAMOND("diamond_slime", 4),
		REDSTONE("redstone_slime", 5),
		EMERALD("emerald_slime", 6),
		QUARTZ("quartz_slime", 7);
		
		private String stringID;
		private int id;
		
		EnumSlimeTypes(String stringID, int id) {
			this.stringID = stringID;
			this.id = id;
		}
		
		public String getStringID() {
			return this.stringID;
		}
		
		public int getID() {
			return this.id;
		}
	}
}