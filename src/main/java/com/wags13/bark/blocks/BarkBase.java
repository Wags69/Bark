package com.wags13.bark.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BarkBase extends BlockBase {

  public BarkBase(String name) {
    super(name, Material.WOOD);
    setHardness(2.0F);
    setSoundType(SoundType.WOOD);
  }
}
