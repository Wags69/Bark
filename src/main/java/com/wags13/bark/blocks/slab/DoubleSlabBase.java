package com.wags13.bark.blocks.slab;

import java.util.Random;

import com.wags13.bark.Bark;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DoubleSlabBase extends SlabBase {
  
  private SlabBase halfSlab;

  public DoubleSlabBase(String name, Material materialIn, SlabBase barkOakHalf) {
    super(name, materialIn);
    setCreativeTab(Bark.tabBark);
    
    this.halfSlab = barkOakHalf;
  }

  @Override
  public boolean isDouble() {
    return true;
  }
  
  @Override
  public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    return Item.getItemFromBlock(this.halfSlab);
  }

  @Override
  public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
    return new ItemStack(this.halfSlab);
  }

  public Item getItemSlab() {
    return new ItemSlab(this.halfSlab, this.halfSlab, this).setRegistryName(this.halfSlab.getRegistryName());
  }
}
