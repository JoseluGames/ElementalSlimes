package com.jlgm.elemslimes.item;

import com.jlgm.elemslimes.lib.ElemSlimesConstants;
import com.jlgm.elemslimes.lib.EnumElemSlimesTypes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
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
	
	public static void renderItem(){
		System.out.println("asdfASDFOIMQWEOI2M3RO9ASDFM9Q834CM 98M3Y9 2384Y Q92378Y 923Y 9237R 3789 ");
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
		renderItem.getItemModelMesher().register(elemSlimesEgg_Item, 0,
				new ModelResourceLocation(ElemSlimesConstants.MODID + ":" + "elemslimesegg", "inventory"));
		
		for(int i = 0; i < EnumElemSlimesTypes.getSize(); i++) {
			renderItem.getItemModelMesher().register(plort_Item, i,
					new ModelResourceLocation(ElemSlimesConstants.MODID + ":" + EnumElemSlimesTypes.byID(i).getPlortName(), "inventory"));
		}
	}
}
