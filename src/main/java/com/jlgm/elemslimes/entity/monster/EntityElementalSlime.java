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
		return SlimeTypes.values()[SLIME_TYPE.getId()].getID();
	}
	
	public enum SlimeTypes{
		IRON("iron_slime"),
		GOLD("gold_slime"),
		DIAMOND("diamond_slime");
		
		private String id;
		
		SlimeTypes(String id) {
			this.id = id;
		}
		
		public String getID() {
			return this.id;
		}
	}
}