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
	
	public static Block corralBlockMaster_Block;
	public static ItemBlock corralBlockMaster_ItemBlock;
	
	public static Block corralBlockScreen_Block;
	public static ItemBlock corralBlockScreen_ItemBlock;
	
	public static Block corralBlockIO_Block;
	public static ItemBlock corralBlockIO_ItemBlock;
	
	public static void registerBlocks(RegistryEvent.Register<Block> event){
		corralBlockMaster_Block = new BlockCorralMaster(Material.ROCK).setUnlocalizedName("corralmaster").setHardness(0.7F).setResistance(0.5F).setCreativeTab(CreativeTabs.REDSTONE);
		event.getRegistry().register(corralBlockMaster_Block.setRegistryName("corralmaster"));

		corralBlockScreen_Block = new BlockCorralScreen(Material.ROCK).setUnlocalizedName("corralscreen").setHardness(0.7F).setResistance(0.5F).setCreativeTab(CreativeTabs.REDSTONE);
		event.getRegistry().register(corralBlockScreen_Block.setRegistryName("corralscreen"));

		corralBlockIO_Block = new BlockCorralIO(Material.ROCK).setUnlocalizedName("corralio").setHardness(0.7F).setResistance(0.5F).setCreativeTab(CreativeTabs.REDSTONE);
		event.getRegistry().register(corralBlockIO_Block.setRegistryName("corralio"));
	}

	public static void registerItemBlocks(RegistryEvent.Register<Item> event){
		corralBlockMaster_ItemBlock = new ItemBlock(corralBlockMaster_Block);
		event.getRegistry().register(corralBlockMaster_ItemBlock.setRegistryName(corralBlockMaster_Block.getRegistryName()));
		
		corralBlockScreen_ItemBlock = new ItemBlock(corralBlockScreen_Block);
		event.getRegistry().register(corralBlockScreen_ItemBlock.setRegistryName(corralBlockScreen_Block.getRegistryName()));
		
		corralBlockIO_ItemBlock = new ItemBlock(corralBlockIO_Block);
		event.getRegistry().register(corralBlockIO_ItemBlock.setRegistryName(corralBlockIO_Block.getRegistryName()));
	}
	
	public static void renderBlock(){
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
		renderItem.getItemModelMesher().register(corralBlockMaster_ItemBlock, 0,
				new ModelResourceLocation(ElemSlimesConstants.MODID + ":" + "corralmaster", "inventory"));
		
		renderItem.getItemModelMesher().register(corralBlockScreen_ItemBlock, 0,
				new ModelResourceLocation(ElemSlimesConstants.MODID + ":" + "corralscreen", "inventory"));
		
		renderItem.getItemModelMesher().register(corralBlockIO_ItemBlock, 0,
				new ModelResourceLocation(ElemSlimesConstants.MODID + ":" + "corralio", "inventory"));
	}
}
