package com.wags13.bark.blocks.slab.barkslabs;

import com.wags13.bark.blocks.slab.HalfSlabBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BarkHalfSlabBase extends HalfSlabBase {

  public BarkHalfSlabBase(String name) {
    super(name, Material.WOOD);
    setHardness(2.0F);
    setSoundType(SoundType.WOOD);
  }

}
