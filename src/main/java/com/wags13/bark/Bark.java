package com.wags13.bark;

import com.wags13.bark.init.ModBlocks;
import com.wags13.bark.init.RusticCompat;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Bark.ID, name = Bark.NAME, version = Bark.VERSION, dependencies = "after:rustic")
public class Bark {
  public static final String ID = "bark";
  public static final String NAME = "Bark";
  public static final String VERSION = "0.0.1";

  @Mod.Instance(ID)
  public static Bark instance;

  public static boolean isRusticLoaded = false;
  
  public static final CreativeTabs tabBark = new CreativeTabs("tabBark") {
    @Override
    public ItemStack getTabIconItem() {
      return new ItemStack(ModBlocks.barkOak);
    }
  };

 
  @Mod.EventHandler
  public static void preinit(FMLPreInitializationEvent event) {
    isRusticLoaded = Loader.isModLoaded("rustic");
    ModBlocks.init();
    
    if(isRusticLoaded) {
      RusticCompat.init();
    }
  }

  @Mod.EventHandler
  public static void init(FMLInitializationEvent event) {

  }

  @Mod.EventHandler
  public static void postInit(FMLPostInitializationEvent event) {

  }
}
