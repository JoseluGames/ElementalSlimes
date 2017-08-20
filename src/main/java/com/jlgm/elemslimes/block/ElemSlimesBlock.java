package com.jlgm.elemslimes.block;

import com.jlgm.elemslimes.lib.ElemSlimesConstants;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;

public class ElemSlimesBlock{
	
	public static Block corralBlock1_Block;
	public static ItemBlock corralBlock1_ItemBlock;
	
	public static void registerBlocks(RegistryEvent.Register<Block> event){
		corralBlock1_Block = new BlockCorralBlock1(Material.ROCK).setUnlocalizedName("corralblock1").setHardness(0.7F).setResistance(0.5F).setCreativeTab(CreativeTabs.REDSTONE);
		event.getRegistry().register(corralBlock1_Block.setRegistryName("corralblock1"));
	}

	public static void registerItemBlocks(RegistryEvent.Register<Item> event){
		corralBlock1_ItemBlock = new ItemBlock(corralBlock1_Block);
		event.getRegistry().register(corralBlock1_ItemBlock.setRegistryName(corralBlock1_Block.getRegistryName()));
	}
	
	public static void renderBlock(){
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
		renderItem.getItemModelMesher().register(corralBlock1_ItemBlock, 0,
				new ModelResourceLocation(ElemSlimesConstants.MODID + ":" + "corralblock1", "inventory"));
		
	}
}
