package com.jlgm.elemslimes.item;

import com.jlgm.elemslimes.lib.EnumElemSlimesTypes;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemPlort extends Item{
	
	public ItemPlort() {
        this.setHasSubtypes(true);
	}
	
    public String getUnlocalizedName(ItemStack stack){
        int i = stack.getMetadata();
        return super.getUnlocalizedName() + "." + EnumElemSlimesTypes.byID(i).getPlortName();
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
        if (this.isInCreativeTab(tab)){
            for (int i = 0; i < EnumElemSlimesTypes.getSize(); ++i){
                items.add(new ItemStack(this, 1, i));
            }
        }
    }
}
