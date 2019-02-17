package com.wags13.bark.blocks.slab.barkslabs;

import com.wags13.bark.blocks.slab.DoubleSlabBase;
import com.wags13.bark.blocks.slab.HalfSlabBase;
import com.wags13.bark.blocks.slab.SlabBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BarkDoubleSlabBase extends DoubleSlabBase {

  public BarkDoubleSlabBase(String name, SlabBase barkOakHalf) {
    super(name, Material.WOOD, barkOakHalf);
    setHardness(2.0F);
    setSoundType(SoundType.WOOD);
  }

}
