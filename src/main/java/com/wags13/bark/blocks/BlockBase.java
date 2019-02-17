package com.wags13.bark.blocks;

import com.wags13.bark.Bark;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {

  public BlockBase(String name, Material material) {
    super(material);
    setUnlocalizedName(name);
    setRegistryName(name);
    setCreativeTab(Bark.tabBark);
  }
  
  public Item getItemBlock() {
    return new ItemBlock(this).setRegistryName(this.getRegistryName());
  }

}
