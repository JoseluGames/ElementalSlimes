package com.jlgm.elemslimes.item;

import com.jlgm.elemslimes.lib.ElemSlimesConstants;
import com.jlgm.elemslimes.lib.EnumElemSlimesTypes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class ElemSlimesItem {
	
	public static Item elemSlimesEgg_Item;
	public static Item plort_Item;
	
	public static void registerItems(RegistryEvent.Register<Item> event){
		elemSlimesEgg_Item = new ItemElemSlimesEgg().setUnlocalizedName("elemslimesegg");
		event.getRegistry().register(elemSlimesEgg_Item.setRegistryName("elemslimesegg"));
		
		plort_Item = new ItemPlort().setUnlocalizedName("plort").setCreativeTab(CreativeTabs.MISC);
		event.getRegistry().register(plort_Item.setRegistryName("plort"));
	}
	
	public static void renderItem() {
		for(int i = 0; i < EnumElemSlimesTypes.getSize(); i++) {
			ModelLoader.setCustomModelResourceLocation(elemSlimesEgg_Item, i,
					new ModelResourceLocation(ElemSlimesConstants.MODID + ":" + "elemslimesegg"/*EnumElemSlimesTypes.byID(i).getPlortName()*/, "inventory"));
			
			ModelLoader.setCustomModelResourceLocation(plort_Item, i,
					new ModelResourceLocation(ElemSlimesConstants.MODID + ":" + EnumElemSlimesTypes.byID(i).getPlortName(), "inventory"));
		}
	}
}
