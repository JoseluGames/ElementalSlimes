package com.jlgm.elemslimes.entity;

import com.jlgm.elemslimes.client.renderer.entity.RenderElementalSlime;
import com.jlgm.elemslimes.entity.monster.EntityElementalSlime;
import com.jlgm.elemslimes.lib.ElemSlimesConstants;
import com.jlgm.elemslimes.main.ElemSlimesMain;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ElemSlimesEntities {
	public static void init() {
		int id = 1;
		EntityRegistry.registerModEntity(new ResourceLocation(ElemSlimesConstants.MODID, "elementalslime"), EntityElementalSlime.class, "ElementalSlime", id++, ElemSlimesMain.instance, 64, 3, true);
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		RenderingRegistry.registerEntityRenderingHandler(EntityElementalSlime.class, RenderElementalSlime.FACTORY);
	}
}
