package com.wags13.bark.init;

import com.wags13.bark.Bark;
import com.wags13.bark.blocks.BarkBase;
import com.wags13.bark.blocks.BlockBase;
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
public class ThaumcraftCompat {
  
  public static Block barkGreatwood;
  public static Block barkSilverwood;
  
  public static Block barkGreatwoodStairs;
  public static Block barkSilverwoodStairs;
  
  public static SlabBase barkGreatwoodHalf;
  public static SlabBase barkSilverwoodHalf;
  public static SlabBase barkGreatwoodDouble;
  public static SlabBase barkSilverwoodDouble;
  
  public static SlabBase logGreatwoodHalf;
  public static SlabBase logSilverwoodHalf;
  public static SlabBase logGreatwoodDouble;
  public static SlabBase logSilverwoodDouble;
  
  public static Block barkGreatwoodChair;
  public static Block barkSilverwoodChair;
  
  public static Block barkGreatwoodTable;
  public static Block barkSilverwoodTable;
  
  public static void init() {
    barkGreatwood = new BarkBase("bark_greatwood");
    barkSilverwood = new BarkBase("bark_silverwood");
    
    barkGreatwoodStairs = new StairBase("bark_greatwood", barkGreatwood.getDefaultState());
    barkSilverwoodStairs = new StairBase("bark_silverwood", barkSilverwood.getDefaultState());
    
    barkGreatwoodChair = new ChairBase("bark_greatwood");
    barkSilverwoodChair = new ChairBase("bark_silverwood");
    
    barkGreatwoodTable = new TableBase("bark_greatwood");
    barkSilverwoodTable = new TableBase("bark_silverwood");
    
    barkGreatwoodHalf = new BarkHalfSlabBase("bark_greatwood");
    barkGreatwoodDouble = new BarkDoubleSlabBase("bark_greatwood", barkGreatwoodHalf);
    barkSilverwoodHalf = new BarkHalfSlabBase("bark_silverwood");
    barkSilverwoodDouble = new BarkDoubleSlabBase("bark_silverwood", barkSilverwoodHalf);
    logGreatwoodHalf = new BarkHalfSlabBase("log_greatwood");
    logGreatwoodDouble = new BarkDoubleSlabBase("log_greatwood", logGreatwoodHalf);
    logSilverwoodHalf = new BarkHalfSlabBase("log_silverwood");
    logSilverwoodDouble = new BarkDoubleSlabBase("log_silverwood", logSilverwoodHalf);
  }

  @SubscribeEvent
  public static void registerBlocks(RegistryEvent.Register<Block> event) {
    if(Bark.isThaumcraftLoaded) {
      event.getRegistry().registerAll(
          barkGreatwood, barkSilverwood,
          barkGreatwoodStairs, barkSilverwoodStairs,
          barkGreatwoodHalf, barkSilverwoodHalf,
          barkGreatwoodDouble, barkSilverwoodDouble,
          logGreatwoodHalf, logSilverwoodHalf,
          logGreatwoodDouble, logSilverwoodDouble
      );
      if(Bark.isRusticLoaded) {
        event.getRegistry().registerAll(
            barkGreatwoodTable, barkSilverwoodTable,
            barkGreatwoodChair, barkSilverwoodChair    
        );
      }
    }
  }

  @SubscribeEvent
  public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
    if(Bark.isThaumcraftLoaded) {
      event.getRegistry().registerAll(
          ((BlockBase)barkGreatwood).getItemBlock(),
          ((BlockBase)barkSilverwood).getItemBlock(),
          
          ((StairBase)barkGreatwoodStairs).getItemBlock(),
          ((StairBase)barkSilverwoodStairs).getItemBlock(),
          
          ((DoubleSlabBase)barkGreatwoodDouble).getItemSlab(),
          ((DoubleSlabBase)barkSilverwoodDouble).getItemSlab(),
          ((DoubleSlabBase)logGreatwoodDouble).getItemSlab(),
          ((DoubleSlabBase)logSilverwoodDouble).getItemSlab()
      );
      if(Bark.isRusticLoaded) {
        event.getRegistry().registerAll(
            ((ChairBase)barkGreatwoodChair).getItemBlock(),
            ((ChairBase)barkSilverwoodChair).getItemBlock(),
            
            ((TableBase)barkGreatwoodTable).getItemBlock(),
            ((TableBase)barkSilverwoodTable).getItemBlock()
        );
      }
    } 
  }

  @SubscribeEvent
  public static void registerRenders(ModelRegistryEvent event) { 
    if(Bark.isThaumcraftLoaded) {
      registerRender(Item.getItemFromBlock(barkGreatwood));
      registerRender(Item.getItemFromBlock(barkSilverwood));
      
      registerRender(Item.getItemFromBlock(barkGreatwoodStairs));
      registerRender(Item.getItemFromBlock(barkSilverwoodStairs));
      
      registerRender(Item.getItemFromBlock(barkGreatwoodHalf));
      registerRender(Item.getItemFromBlock(barkSilverwoodHalf));
      
      registerRender(Item.getItemFromBlock(logGreatwoodHalf));
      registerRender(Item.getItemFromBlock(logSilverwoodHalf));
      
      if(Bark.isRusticLoaded) {
        registerRender(Item.getItemFromBlock(barkGreatwoodChair));
        registerRender(Item.getItemFromBlock(barkSilverwoodChair));
        
        registerRender(Item.getItemFromBlock(barkGreatwoodTable));
        registerRender(Item.getItemFromBlock(barkSilverwoodTable));
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
