package com.jlgm.elemslimes.entity.monster;

import com.jlgm.elemslimes.lib.EnumElemSlimesTypes;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.World;

public class EntityElementalSlime extends EntitySlime{
	
	private static final DataParameter<Integer> SLIME_TYPE = EntityDataManager.<Integer>createKey(EntityElementalSlime.class, DataSerializers.VARINT);
	
	public EntityElementalSlime(World worldIn) {
		super(worldIn);
	}
	
	public String getType() {
		return EnumElemSlimesTypes.byID(this.dataManager.get(SLIME_TYPE)).getSlimeName();
	}
	
	public void setType(EnumElemSlimesTypes type) {
		this.dataManager.set(SLIME_TYPE, Integer.valueOf(type.getID()));
	}

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setInteger("Type", EnumElemSlimesTypes.byID(this.dataManager.get(SLIME_TYPE)).getID());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.setType(EnumElemSlimesTypes.byID(compound.getInteger("Type")));
    }
	
	@Override
    protected void entityInit(){
        super.entityInit();
        this.dataManager.register(SLIME_TYPE, Integer.valueOf(EnumElemSlimesTypes.COAL.getID()));
    }
}