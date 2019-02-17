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
public class RusticCompat {
  public static Block barkIronwood;
  public static Block barkOlive;
  
  public static Block barkIronwoodStairs;
  public static Block barkOliveStairs;
  
  public static Block barkIronwoodChair;
  public static Block barkOliveChair;
  public static Block barkOakChair;
  public static Block barkSpruceChair;
  public static Block barkJungleChair;
  public static Block barkAcaciaChair;
  public static Block barkDarkOakChair;
  public static Block barkBirchChair;
  
  public static Block barkIronwoodTable;
  public static Block barkOliveTable;
  public static Block barkOakTable;
  public static Block barkSpruceTable;
  public static Block barkJungleTable;
  public static Block barkAcaciaTable;
  public static Block barkDarkOakTable;
  public static Block barkBirchTable;
  
  public static SlabBase barkIronwoodHalf;
  public static SlabBase barkIronwoodDouble;
  public static SlabBase barkOliveHalf;
  public static SlabBase barkOliveDouble;
  public static SlabBase logIronwoodHalf;
  public static SlabBase logIronwoodDouble;
  public static SlabBase logOliveHalf;
  public static SlabBase logOliveDouble;
  
  public static void init() {
    barkIronwood = new BarkBase("bark_ironwood");
    barkOlive = new BarkBase("bark_olive");
    
    barkIronwoodStairs = new StairBase("bark_ironwood_stairs", barkIronwood.getDefaultState());
    barkOliveStairs = new StairBase("bark_olive_stairs", barkOlive.getDefaultState());
    
    barkIronwoodChair = new ChairBase("bark_ironwood");
    barkOliveChair = new ChairBase("bark_olive");
    barkOakChair = new ChairBase("bark_oak");
    barkSpruceChair = new ChairBase("bark_spruce");
    barkJungleChair = new ChairBase("bark_jungle");
    barkAcaciaChair = new ChairBase("bark_acacia");
    barkDarkOakChair = new ChairBase("bark_dark_oak");
    barkBirchChair = new ChairBase("bark_birch");
    
    barkIronwoodTable = new TableBase("bark_ironwood");
    barkOliveTable = new TableBase("bark_olive");
    barkOakTable = new TableBase("bark_oak");
    barkSpruceTable = new TableBase("bark_spruce");
    barkJungleTable = new TableBase("bark_jungle");
    barkAcaciaTable = new TableBase("bark_acacia");
    barkDarkOakTable = new TableBase("bark_dark_oak");
    barkBirchTable = new TableBase("bark_birch");
    
    barkIronwoodHalf = new BarkHalfSlabBase("bark_ironwood");
    barkIronwoodDouble = new BarkDoubleSlabBase("bark_ironwood", barkIronwoodHalf);
    barkOliveHalf = new BarkHalfSlabBase("bark_olive");
    barkOliveDouble = new BarkDoubleSlabBase("bark_olive", barkOliveHalf);
    logIronwoodHalf = new BarkHalfSlabBase("log_ironwood");
    logIronwoodDouble = new BarkDoubleSlabBase("log_ironwood", logIronwoodHalf);
    logOliveHalf = new BarkHalfSlabBase("log_olive");
    logOliveDouble = new BarkDoubleSlabBase("log_olive", logOliveHalf);
  }
  
  @SubscribeEvent
  public static void registerBlocks(RegistryEvent.Register<Block> event) {
    if(Bark.isRusticLoaded)
      event.getRegistry().registerAll(
          barkIronwood, barkOlive, 
          barkIronwoodStairs, barkOliveStairs,
          barkIronwoodHalf, barkOliveHalf,
          barkIronwoodDouble, barkOliveDouble,
          logIronwoodHalf, logOliveHalf,
          logIronwoodDouble, logOliveDouble,
          barkIronwoodChair, barkOliveChair, barkOakChair, barkAcaciaChair, barkBirchChair, barkDarkOakChair, barkJungleChair, barkSpruceChair,
          barkIronwoodTable, barkOliveTable, barkOakTable, barkAcaciaTable, barkBirchTable, barkDarkOakTable, barkJungleTable, barkSpruceTable
      );
  }
  
  @SubscribeEvent
  public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
    if(Bark.isRusticLoaded)
      event.getRegistry().registerAll(
          ((BlockBase)barkIronwood).getItemBlock(),
          ((BlockBase)barkOlive).getItemBlock(),
          
          ((StairBase)barkIronwoodStairs).getItemBlock(),
          ((StairBase)barkOliveStairs).getItemBlock(),
          
          ((ChairBase)barkIronwoodChair).getItemBlock(),
          ((ChairBase)barkOliveChair).getItemBlock(),
          ((ChairBase)barkOakChair).getItemBlock(),
          ((ChairBase)barkAcaciaChair).getItemBlock(),
          ((ChairBase)barkBirchChair).getItemBlock(),
          ((ChairBase)barkDarkOakChair).getItemBlock(),
          ((ChairBase)barkJungleChair).getItemBlock(),
          ((ChairBase)barkSpruceChair).getItemBlock(),
          
          ((TableBase)barkIronwoodTable).getItemBlock(),
          ((TableBase)barkOliveTable).getItemBlock(),
          ((TableBase)barkOakTable).getItemBlock(),
          ((TableBase)barkAcaciaTable).getItemBlock(),
          ((TableBase)barkBirchTable).getItemBlock(),
          ((TableBase)barkDarkOakTable).getItemBlock(),
          ((TableBase)barkJungleTable).getItemBlock(),
          ((TableBase)barkSpruceTable).getItemBlock(),
          
          ((DoubleSlabBase)barkIronwoodDouble).getItemSlab(),
          ((DoubleSlabBase)barkOliveDouble).getItemSlab(),
          ((DoubleSlabBase)logIronwoodDouble).getItemSlab(),
          ((DoubleSlabBase)logOliveDouble).getItemSlab()
      );
  }
  
  @SubscribeEvent
  public static void registerRenders(ModelRegistryEvent event) { 
    if(Bark.isRusticLoaded) {
      registerRender(Item.getItemFromBlock(barkIronwood));
      registerRender(Item.getItemFromBlock(barkOlive));
      
      registerRender(Item.getItemFromBlock(barkIronwoodStairs));
      registerRender(Item.getItemFromBlock(barkOliveStairs));
      
      registerRender(Item.getItemFromBlock(barkIronwoodHalf));
      registerRender(Item.getItemFromBlock(barkOliveHalf));
      
      registerRender(Item.getItemFromBlock(logIronwoodHalf));
      registerRender(Item.getItemFromBlock(logOliveHalf));
      
      registerRender(Item.getItemFromBlock(barkIronwoodChair));
      registerRender(Item.getItemFromBlock(barkOliveChair));
      registerRender(Item.getItemFromBlock(barkOakChair));
      registerRender(Item.getItemFromBlock(barkAcaciaChair));
      registerRender(Item.getItemFromBlock(barkBirchChair));
      registerRender(Item.getItemFromBlock(barkDarkOakChair));
      registerRender(Item.getItemFromBlock(barkJungleChair));
      registerRender(Item.getItemFromBlock(barkSpruceChair));
      
      registerRender(Item.getItemFromBlock(barkIronwoodTable));
      registerRender(Item.getItemFromBlock(barkOliveTable));
      registerRender(Item.getItemFromBlock(barkOakTable));
      registerRender(Item.getItemFromBlock(barkAcaciaTable));
      registerRender(Item.getItemFromBlock(barkBirchTable));
      registerRender(Item.getItemFromBlock(barkDarkOakTable));
      registerRender(Item.getItemFromBlock(barkJungleTable));
      registerRender(Item.getItemFromBlock(barkSpruceTable));
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
