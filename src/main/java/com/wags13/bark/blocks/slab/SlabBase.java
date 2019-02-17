package com.wags13.bark.blocks.slab;

import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class SlabBase extends BlockSlab {
  
  public static final PropertyEnum<Variant> VARIANT = PropertyEnum.<Variant>create("variant", Variant.class);
  

  public SlabBase(String name, Material materialIn) {
    super(materialIn);
    this.setRegistryName(name);
    this.setUnlocalizedName(name);
    
    IBlockState blockstate = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
    
    if(!this.isDouble()) {
      blockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
    }
    
    this.setDefaultState(blockstate);
    this.useNeighborBrightness = !this.isDouble();
  }

  @Override
  public String getUnlocalizedName(int meta) {
    return super.getUnlocalizedName();
  }
/*
  @Override
  public boolean isDouble() {
    // TODO Auto-generated method stub
    return false;
  }
  
  @Override
  public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    // TODO Auto-generated method stub
    return super.getItemDropped(state, rand, fortune);
  }

  @Override
  public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
    // TODO Auto-generated method stub
    return super.getItem(worldIn, pos, state);
  }*/

  @Override
  public IProperty<?> getVariantProperty() {
    return VARIANT;
  }

  @Override
  public Comparable<?> getTypeForItem(ItemStack stack) {
    return Variant.DEFAULT;
  }

  @Override
  public IBlockState getStateFromMeta(int meta) {
    IBlockState state = this.blockState.getBaseState().withProperty(VARIANT, Variant.DEFAULT);
    if(!this.isDouble()) {
      state = state.withProperty(
          HALF,
          ((meta & 8) != 0) ? 
              EnumBlockHalf.TOP : EnumBlockHalf.BOTTOM
      );
    }
    
    return state;
  }

  @Override
  public int getMetaFromState(IBlockState state) {
    int meta = 0;
    if(!this.isDouble() && state.getValue(HALF) == EnumBlockHalf.TOP) {
      meta |= 8;
    }
    
    return meta;
  }



  @Override
  protected BlockStateContainer createBlockState() {
    if(!this.isDouble()) {
      return new BlockStateContainer(
          this,
          new IProperty[] { VARIANT, HALF }
      );
    }
    
    return new BlockStateContainer(this, new IProperty[] { VARIANT });
  }
  
  public static enum Variant implements IStringSerializable {
    DEFAULT;
    
;

    @Override
    public String getName() {
      return "default";
    }
    
  }
}

















