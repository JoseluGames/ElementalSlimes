package com.jlgm.elemslimes.entity.monster;

import javax.annotation.Nullable;

import com.jlgm.elemslimes.lib.ElemSlimesConstants;
import com.jlgm.elemslimes.lib.EnumElemSlimesTypes;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class EntityElementalSlime extends EntitySlime{
	
	private static final DataParameter<Integer> SLIME_TYPE = EntityDataManager.<Integer>createKey(EntityElementalSlime.class, DataSerializers.VARINT);
	
	public EntityElementalSlime(World worldIn) {
		super(worldIn);
	}
	
	public String getType() {
		return EnumElemSlimesTypes.byID(this.dataManager.get(SLIME_TYPE)).getSlimeName();
	}
	
	@Nullable
	protected ResourceLocation getLootTable(){
		return EnumElemSlimesTypes.byID(this.dataManager.get(SLIME_TYPE)).getLootTable();
    }
	
	public void setType(EnumElemSlimesTypes type) {
		this.dataManager.set(SLIME_TYPE, Integer.valueOf(type.getID()));
	}
	
	@Override
    protected EntityElementalSlime createInstance()
    {
        return new EntityElementalSlime(this.world);
    }
	
    /**
     * Will get destroyed next tick.
     */
	@Override
    public void setDead()
    {
        int i = this.getSlimeSize();

        if (!this.world.isRemote && i > 1 && this.getHealth() <= 0.0F)
        {
            int j = 2 + this.rand.nextInt(3);

            for (int k = 0; k < j; ++k)
            {
                float f = ((float)(k % 2) - 0.5F) * (float)i / 4.0F;
                float f1 = ((float)(k / 2) - 0.5F) * (float)i / 4.0F;
                EntityElementalSlime entityslime = this.createInstance();

                if (this.hasCustomName())
                {
                    entityslime.setCustomNameTag(this.getCustomNameTag());
                }

                if (this.isNoDespawnRequired())
                {
                    entityslime.enablePersistence();
                }

                entityslime.setSlimeSize(i / 2, true);
                entityslime.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5D, this.posZ + (double)f1, this.rand.nextFloat() * 360.0F, 0.0F);
                this.world.spawnEntity(entityslime);
            }
        }
        this.isDead = true;
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