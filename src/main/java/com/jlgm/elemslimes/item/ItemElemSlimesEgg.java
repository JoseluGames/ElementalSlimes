package com.jlgm.elemslimes.item;

import javax.annotation.Nullable;

import com.jlgm.elemslimes.entity.monster.EntityElementalSlime;
import com.jlgm.elemslimes.entity.monster.EntityElementalSlime.EnumSlimeTypes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemElemSlimesEgg extends ItemMonsterPlacer{
	
    /**
     * Called when a Block is right-clicked with this Item
     */
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (worldIn.isRemote)
        {
            return EnumActionResult.SUCCESS;
        }
        else if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (block == Blocks.MOB_SPAWNER)
            {
                TileEntity tileentity = worldIn.getTileEntity(pos);

                if (tileentity instanceof TileEntityMobSpawner)
                {
                    MobSpawnerBaseLogic mobspawnerbaselogic = ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic();
                    mobspawnerbaselogic.setEntityId(getNamedIdFrom(itemstack));
                    tileentity.markDirty();
                    worldIn.notifyBlockUpdate(pos, iblockstate, iblockstate, 3);

                    if (!player.capabilities.isCreativeMode)
                    {
                        itemstack.shrink(1);
                    }

                    return EnumActionResult.SUCCESS;
                }
            }

            BlockPos blockpos = pos.offset(facing);
            double d0 = this.getYOffset(worldIn, blockpos);
            Entity entity = spawnCreature(worldIn, /*getNamedIdFrom(itemstack),*/ itemstack.getMetadata(), (double)blockpos.getX() + 0.5D, (double)blockpos.getY() + d0, (double)blockpos.getZ() + 0.5D);

            if (entity != null)
            {
                if (entity instanceof EntityLivingBase && itemstack.hasDisplayName())
                {
                    entity.setCustomNameTag(itemstack.getDisplayName());
                }

                applyItemEntityDataToEntity(worldIn, player, itemstack, entity);

                if (!player.capabilities.isCreativeMode)
                {
                    itemstack.shrink(1);
                }
            }

            return EnumActionResult.SUCCESS;
        }
    }
	
    /**
     * Called when the equipped item is right clicked.
     */
	@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (worldIn.isRemote)
        {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
        }
        else
        {
            RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, true);

            if (raytraceresult != null && raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK)
            {
                BlockPos blockpos = raytraceresult.getBlockPos();

                if (!(worldIn.getBlockState(blockpos).getBlock() instanceof BlockLiquid))
                {
                    return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
                }
                else if (worldIn.isBlockModifiable(playerIn, blockpos) && playerIn.canPlayerEdit(blockpos, raytraceresult.sideHit, itemstack))
                {
                    Entity entity = spawnCreature(worldIn, /*getNamedIdFrom(itemstack),*/ itemstack.getMetadata(), (double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.5D, (double)blockpos.getZ() + 0.5D);

                    if (entity == null)
                    {
                        return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
                    }
                    else
                    {
                        if (entity instanceof EntityLivingBase && itemstack.hasDisplayName())
                        {
                            entity.setCustomNameTag(itemstack.getDisplayName());
                        }

                        applyItemEntityDataToEntity(worldIn, playerIn, itemstack, entity);

                        if (!playerIn.capabilities.isCreativeMode)
                        {
                            itemstack.shrink(1);
                        }

                        playerIn.addStat(StatList.getObjectUseStats(this));
                        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
                    }
                }
                else
                {
                    return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
                }
            }
            else
            {
                return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
            }
        }
    }
	
    /**
     * Spawns the creature specified by the egg's type in the location specified by the last three parameters.
     * Parameters: world, entityID, x, y, z.
     */
    @Nullable
    public static Entity spawnCreature(World worldIn, /*@Nullable ResourceLocation entityID,*/ int metadata, double x, double y, double z)
    {
        /*if (entityID != null && EntityList.ENTITY_EGGS.containsKey(entityID))
        {*/
            Entity entity = null;

            for (int i = 0; i < 1; ++i)
            {
            	entity = EntityList.newEntity(EntityElementalSlime.class, worldIn);
                //entity = EntityList.createEntityByIDFromName(entityID, worldIn);

                if (entity instanceof EntityLiving)
                {
                    EntityLiving entityliving = (EntityLiving)entity;
                    entity.setLocationAndAngles(x, y, z, MathHelper.wrapDegrees(worldIn.rand.nextFloat() * 360.0F), 0.0F);
                    entityliving.rotationYawHead = entityliving.rotationYaw;
                    entityliving.renderYawOffset = entityliving.rotationYaw;
                    entityliving.onInitialSpawn(worldIn.getDifficultyForLocation(new BlockPos(entityliving)), (IEntityLivingData)null);
                    EntityElementalSlime entitySlime = (EntityElementalSlime) entity;
                    entitySlime.setType(EntityElementalSlime.EnumSlimeTypes.values()[metadata]);
                    worldIn.spawnEntity(entitySlime);
                    entityliving.playLivingSound();
                }
            }

            return entity;
        /*}
        else
        {
            return null;
        }*/
    }
	
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
        if (this.isInCreativeTab(tab)){
            for (int i = 0; i < EntityElementalSlime.EnumSlimeTypes.values().length; ++i){
                items.add(new ItemStack(this, 1, i));
            }
        }
    }
}
