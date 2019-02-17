package com.wags13.bark.init;

import com.wags13.bark.Bark;
import com.wags13.bark.blocks.BarkBase;
import com.wags13.bark.blocks.BlockBase;
import com.wags13.bark.blocks.StairBase;
import com.wags13.bark.blocks.slab.DoubleSlabBase;
import com.wags13.bark.blocks.slab.SlabBase;
import com.wags13.bark.blocks.slab.barkslabs.BarkDoubleSlabBase;
import com.wags13.bark.blocks.slab.barkslabs.BarkHalfSlabBase;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Bark.ID)
public class ModBlocks {
  public static Block barkOak;
  public static Block barkSpruce;
  public static Block barkJungle;
  public static Block barkAcacia;
  public static Block barkDarkOak;
  public static Block barkBirch;
  
  public static Block barkOakStairs;
  public static Block barkSpruceStairs;
  public static Block barkJungleStairs;
  public static Block barkAcaciaStairs;
  public static Block barkDarkOakStairs;
  public static Block barkBirchStairs;
  
  public static Block logOakStairs;
  public static Block logSpruceStairs;
  public static Block logJungleStairs;
  public static Block logAcaciaStairs;
  public static Block logDarkOakStairs;
  public static Block logBirchStairs;
  
  public static SlabBase barkOakHalf;
  public static SlabBase barkOakDouble;
  public static SlabBase barkAcaciaHalf;
  public static SlabBase barkAcaciaDouble;
  public static SlabBase barkDarkOakHalf;
  public static SlabBase barkDarkOakDouble;
  public static SlabBase barkSpruceHalf;
  public static SlabBase barkSpruceDouble;
  public static SlabBase barkBirchHalf;
  public static SlabBase barkBirchDouble;
  public static SlabBase barkJungleHalf;
  public static SlabBase barkJungleDouble;
  
  public static SlabBase logOakHalf;
  public static SlabBase logOakDouble;
  public static SlabBase logAcaciaHalf;
  public static SlabBase logAcaciaDouble;
  public static SlabBase logDarkOakHalf;
  public static SlabBase logDarkOakDouble;
  public static SlabBase logSpruceHalf;
  public static SlabBase logSpruceDouble;
  public static SlabBase logBirchHalf;
  public static SlabBase logBirchDouble;
  public static SlabBase logJungleHalf;
  public static SlabBase logJungleDouble;

  
  
  public static void init() {
    barkOak = new BarkBase("bark_oak");
    barkSpruce = new BarkBase("bark_spruce");
    barkJungle = new BarkBase("bark_jungle");
    barkAcacia = new BarkBase("bark_acacia");
    barkDarkOak = new BarkBase("bark_dark_oak");
    barkBirch = new BarkBase("bark_birch");
    
    barkOakStairs = new StairBase("bark_oak", barkOak.getDefaultState());
    barkSpruceStairs = new StairBase("bark_spruce", barkSpruce.getDefaultState());
    barkJungleStairs = new StairBase("bark_jungle", barkJungle.getDefaultState());
    barkAcaciaStairs = new StairBase("bark_acacia", barkAcacia.getDefaultState());
    barkDarkOakStairs = new StairBase("bark_dark_oak", barkDarkOak.getDefaultState());
    barkBirchStairs = new StairBase("bark_birch", barkBirch.getDefaultState());
    
    barkOakHalf = new BarkHalfSlabBase("bark_oak");
    barkOakDouble = new BarkDoubleSlabBase("bark_oak", barkOakHalf);
    barkAcaciaHalf = new BarkHalfSlabBase("bark_acacia");
    barkAcaciaDouble = new BarkDoubleSlabBase("bark_acacia", barkAcaciaHalf);
    barkDarkOakHalf = new BarkHalfSlabBase("bark_dark_oak");
    barkDarkOakDouble = new BarkDoubleSlabBase("bark_dark_oak", barkDarkOakHalf);
    barkSpruceHalf = new BarkHalfSlabBase("bark_spruce");
    barkSpruceDouble = new BarkDoubleSlabBase("bark_spruce", barkSpruceHalf);
    barkBirchHalf = new BarkHalfSlabBase("bark_birch");
    barkBirchDouble = new BarkDoubleSlabBase("bark_birch", barkBirchHalf);
    barkJungleHalf = new BarkHalfSlabBase("bark_jungle");
    barkJungleDouble = new BarkDoubleSlabBase("bark_jungle", barkJungleHalf);
    
    logOakHalf = new BarkHalfSlabBase("log_oak");
    logOakDouble = new BarkDoubleSlabBase("log_oak", logOakHalf);
    logAcaciaHalf = new BarkHalfSlabBase("log_acacia");
    logAcaciaDouble = new BarkDoubleSlabBase("log_acacia", logAcaciaHalf);
    logDarkOakHalf = new BarkHalfSlabBase("log_dark_oak");
    logDarkOakDouble = new BarkDoubleSlabBase("log_dark_oak", logDarkOakHalf);
    logSpruceHalf = new BarkHalfSlabBase("log_spruce");
    logSpruceDouble = new BarkDoubleSlabBase("log_spruce", logSpruceHalf);
    logBirchHalf = new BarkHalfSlabBase("log_birch");
    logBirchDouble = new BarkDoubleSlabBase("log_birch", logBirchHalf);
    logJungleHalf = new BarkHalfSlabBase("log_jungle");
    logJungleDouble = new BarkDoubleSlabBase("log_jungle", logJungleHalf);
  }
  
  @SubscribeEvent
  public static void registerBlocks(RegistryEvent.Register<Block> event) {
    event.getRegistry().registerAll(
        barkOak, barkAcacia, barkBirch, barkDarkOak, barkJungle, barkSpruce,
        barkOakStairs, barkAcaciaStairs, barkBirchStairs, barkDarkOakStairs, barkJungleStairs, barkSpruceStairs,
        barkOakHalf, barkOakDouble, 
        barkAcaciaHalf, barkAcaciaDouble, 
        barkDarkOakHalf, barkDarkOakDouble, 
        barkSpruceHalf, barkSpruceDouble, 
        barkBirchHalf, barkBirchDouble, 
        barkJungleHalf, barkJungleDouble,
        
        logOakHalf, logOakDouble, 
        logAcaciaHalf, logAcaciaDouble, 
        logDarkOakHalf, logDarkOakDouble, 
        logSpruceHalf, logSpruceDouble, 
        logBirchHalf, logBirchDouble, 
        logJungleHalf, logJungleDouble
    );
  }
  
  @SubscribeEvent
  public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
    event.getRegistry().registerAll(
        ((BlockBase)barkOak).getItemBlock(),
        ((BlockBase)barkAcacia).getItemBlock(),
        ((BlockBase)barkBirch).getItemBlock(),
        ((BlockBase)barkDarkOak).getItemBlock(),
        ((BlockBase)barkJungle).getItemBlock(),
        ((BlockBase)barkSpruce).getItemBlock(),
        
        ((StairBase)barkOakStairs).getItemBlock(),
        ((StairBase)barkAcaciaStairs).getItemBlock(),
        ((StairBase)barkBirchStairs).getItemBlock(),
        ((StairBase)barkDarkOakStairs).getItemBlock(),
        ((StairBase)barkJungleStairs).getItemBlock(),
        ((StairBase)barkSpruceStairs).getItemBlock(),
        
        ((DoubleSlabBase)barkOakDouble).getItemSlab(),
        ((DoubleSlabBase)barkAcaciaDouble).getItemSlab(),
        ((DoubleSlabBase)barkBirchDouble).getItemSlab(),
        ((DoubleSlabBase)barkDarkOakDouble).getItemSlab(),
        ((DoubleSlabBase)barkJungleDouble).getItemSlab(),
        ((DoubleSlabBase)barkSpruceDouble).getItemSlab(),
        
        ((DoubleSlabBase)logOakDouble).getItemSlab(),
        ((DoubleSlabBase)logAcaciaDouble).getItemSlab(),
        ((DoubleSlabBase)logBirchDouble).getItemSlab(),
        ((DoubleSlabBase)logDarkOakDouble).getItemSlab(),
        ((DoubleSlabBase)logJungleDouble).getItemSlab(),
        ((DoubleSlabBase)logSpruceDouble).getItemSlab()
    );
  }
  
  @SubscribeEvent
  public static void registerRenders(ModelRegistryEvent event) {
    registerRender(Item.getItemFromBlock(barkOak));
    registerRender(Item.getItemFromBlock(barkAcacia));
    registerRender(Item.getItemFromBlock(barkBirch));
    registerRender(Item.getItemFromBlock(barkDarkOak));
    registerRender(Item.getItemFromBlock(barkJungle));
    registerRender(Item.getItemFromBlock(barkSpruce));
    
    registerRender(Item.getItemFromBlock(barkOakStairs));
    registerRender(Item.getItemFromBlock(barkAcaciaStairs));
    registerRender(Item.getItemFromBlock(barkBirchStairs));
    registerRender(Item.getItemFromBlock(barkDarkOakStairs));
    registerRender(Item.getItemFromBlock(barkJungleStairs));
    registerRender(Item.getItemFromBlock(barkSpruceStairs));
    
    registerRender(Item.getItemFromBlock(barkOakHalf));
    registerRender(Item.getItemFromBlock(barkAcaciaHalf));
    registerRender(Item.getItemFromBlock(barkBirchHalf));
    registerRender(Item.getItemFromBlock(barkDarkOakHalf));
    registerRender(Item.getItemFromBlock(barkJungleHalf));
    registerRender(Item.getItemFromBlock(barkSpruceHalf));
    
    registerRender(Item.getItemFromBlock(logOakHalf));
    registerRender(Item.getItemFromBlock(logAcaciaHalf));
    registerRender(Item.getItemFromBlock(logBirchHalf));
    registerRender(Item.getItemFromBlock(logDarkOakHalf));
    registerRender(Item.getItemFromBlock(logJungleHalf));
    registerRender(Item.getItemFromBlock(logSpruceHalf));
  }
  
  public static void registerRender(Item item) {
    ModelLoader.setCustomModelResourceLocation(
        item, 
        0, 
        new ModelResourceLocation(item.getRegistryName(), "inventory")
    );
  }
}
