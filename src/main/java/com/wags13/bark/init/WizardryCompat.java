package com.wags13.bark.init;

import com.wags13.bark.Bark;
import com.wags13.bark.blocks.BarkBase;
import com.wags13.bark.blocks.ChairBase;
import com.wags13.bark.blocks.StairBase;
import com.wags13.bark.blocks.TableBase;
import com.wags13.bark.blocks.slab.DoubleSlabBase;
import com.wags13.bark.blocks.slab.SlabBase;
import com.wags13.bark.blocks.slab.barkslabs.BarkDoubleSlabBase;
import com.wags13.bark.blocks.slab.barkslabs.BarkHalfSlabBase;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Bark.ID)
public class WizardryCompat {
  
  public static BarkBase barkWisdomwood;
  public static StairBase barkWisdomwoodStairs;
  public static SlabBase barkWisdomwoodHalf;
  public static SlabBase barkWisdomwoodDouble;
  public static SlabBase logWisdomwoodHalf;
  public static SlabBase logWisdomwoodDouble;
  
  public static ChairBase barkWisdomwoodChair;
  public static TableBase barkWisdomwoodTable;
  public static ChairBase wisdomwoodChair;
  public static TableBase wisdomwoodTable;
  
  public static void init() {
    barkWisdomwood = new BarkBase("bark_wisdomwood");
    barkWisdomwoodStairs = new StairBase("bark_wisdomwood", barkWisdomwood.getDefaultState());
    barkWisdomwoodHalf = new BarkHalfSlabBase("bark_wisdomwood");
    barkWisdomwoodDouble = new BarkDoubleSlabBase("bark_wisdomwood", barkWisdomwoodHalf);
    logWisdomwoodHalf = new BarkHalfSlabBase("log_wisdomwood");
    logWisdomwoodDouble = new BarkDoubleSlabBase("log_wisdomwood", logWisdomwoodHalf);
    barkWisdomwoodChair = new ChairBase("bark_wisdomwood");
    barkWisdomwoodTable = new TableBase("bark_wisdomwood");
    wisdomwoodChair = new ChairBase("wisdomwood");
    wisdomwoodTable = new TableBase("wisdomwood");
  }

  @SubscribeEvent
  public static void registerBlocks(RegistryEvent.Register<Block> event) {
    if(Bark.isWizardryLoaded) {
      event.getRegistry().registerAll(
          barkWisdomwood,
          barkWisdomwoodStairs,
          barkWisdomwoodHalf,
          barkWisdomwoodDouble,
          logWisdomwoodHalf,
          logWisdomwoodDouble
      );
      
      if(Bark.isRusticLoaded) {
        event.getRegistry().registerAll(          
            barkWisdomwoodChair,
            barkWisdomwoodTable,
            wisdomwoodChair,
            wisdomwoodTable
        );
      }
    }
  }

  @SubscribeEvent
  public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
    if(Bark.isWizardryLoaded) {
      event.getRegistry().registerAll(
          barkWisdomwood.getItemBlock(),
          ((DoubleSlabBase)barkWisdomwoodDouble).getItemSlab(),
          barkWisdomwoodStairs.getItemBlock(),
          ((DoubleSlabBase)logWisdomwoodDouble).getItemSlab()
      );
      
      if(Bark.isRusticLoaded) {
        event.getRegistry().registerAll(
            barkWisdomwoodChair.getItemBlock(),
            barkWisdomwoodTable.getItemBlock(),
            wisdomwoodChair.getItemBlock(),
            wisdomwoodTable.getItemBlock()
        );
      }
    }
  }

  @SubscribeEvent
  public static void registerRenders(ModelRegistryEvent event) { 
    if(Bark.isWizardryLoaded) {
      registerRender(Item.getItemFromBlock(barkWisdomwood));
      registerRender(Item.getItemFromBlock(barkWisdomwoodStairs));
      registerRender(Item.getItemFromBlock(barkWisdomwoodHalf));
      registerRender(Item.getItemFromBlock(logWisdomwoodHalf));
      
      if(Bark.isRusticLoaded) {
        registerRender(Item.getItemFromBlock(barkWisdomwoodChair));
        registerRender(Item.getItemFromBlock(barkWisdomwoodTable));
        registerRender(Item.getItemFromBlock(wisdomwoodChair));
        registerRender(Item.getItemFromBlock(wisdomwoodTable));
      }
    }
  }

  public static void registerRender(Item item) {
    ModelLoader.setCustomModelResourceLocation(
        item, 
        0, 
        new ModelResourceLocation(item.getRegistryName(), "inventory")
    );
  }
}
