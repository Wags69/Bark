package com.wags13.bark.blocks.slab;

import java.util.Random;

import com.wags13.bark.Bark;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HalfSlabBase extends SlabBase {

  public HalfSlabBase(String name, Material materialIn) {
    super(name + "_slab", materialIn);
    setCreativeTab(Bark.tabBark);
  }

  @Override
  public boolean isDouble() {
    return false;
  }
  
  @Override
  public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    return Item.getItemFromBlock(this);
  }

  @Override
  public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
    return new ItemStack(this);
  }
}
