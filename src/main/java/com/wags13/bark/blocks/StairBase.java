package com.wags13.bark.blocks;

import com.wags13.bark.Bark;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class StairBase extends BlockStairs {

  public StairBase(String name, IBlockState modelState) {
    super(modelState);
    setRegistryName(name);
    setUnlocalizedName(name);
    setCreativeTab(Bark.tabBark);
  }

  public Item getItemBlock() {
    return new ItemBlock(this).setRegistryName(this.getRegistryName());
  }
}
