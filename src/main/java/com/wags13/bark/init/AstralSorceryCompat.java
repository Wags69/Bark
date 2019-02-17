package com.wags13.bark.init;

import com.wags13.bark.Bark;
import com.wags13.bark.blocks.ChairBase;
import com.wags13.bark.blocks.StairBase;
import com.wags13.bark.blocks.TableBase;
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
public class AstralSorceryCompat {
  
  public static Block infusedWoodChair;
  public static Block infusedWoodPlanksChair;
  public static Block vibrantWoodChair;
  
  public static Block infusedWoodTable;
  public static Block infusedWoodPlanksTable;
  public static Block vibrantWoodTable;
  private static StairBase infusedWoodPlanksStairs;
  private static SlabBase infusedWoodPlanksHalf;
  private static SlabBase infusedWoodPlanksDouble;
  
  public static void init() {
    
    infusedWoodPlanksStairs = new StairBase("infused_wood_planks", Blocks.PLANKS.getDefaultState());
    infusedWoodPlanksHalf = new BarkHalfSlabBase("infused_wood_planks");
    infusedWoodPlanksDouble = new BarkDoubleSlabBase("infused_wood_planks", infusedWoodPlanksHalf);
    
    infusedWoodChair = new ChairBase("infused_wood");
    infusedWoodPlanksChair = new ChairBase("infused_wood_planks");
    vibrantWoodChair = new ChairBase("vibrant_wood");
    
    infusedWoodTable = new TableBase("infused_wood");
    infusedWoodPlanksTable = new TableBase("infused_wood_planks");
    vibrantWoodTable = new TableBase("vibrant_wood");
  }

  @SubscribeEvent
  public static void registerBlocks(RegistryEvent.Register<Block> event) {
    if(Bark.isAstralSorceryLoaded && Bark.isRusticLoaded)
      event.getRegistry().registerAll(
          infusedWoodPlanksStairs,
          infusedWoodPlanksHalf,
          infusedWoodPlanksDouble,
          
          infusedWoodChair,
          infusedWoodPlanksChair,
          vibrantWoodChair,
          
          infusedWoodTable,
          infusedWoodPlanksTable,
          vibrantWoodTable
      );
  }

  @SubscribeEvent
  public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
    if(Bark.isAstralSorceryLoaded && Bark.isRusticLoaded)
      event.getRegistry().registerAll(
          ((StairBase)infusedWoodPlanksStairs).getItemBlock(),
          ((DoubleSlabBase)infusedWoodPlanksDouble).getItemSlab(),
          
          ((ChairBase)infusedWoodChair).getItemBlock(),
          ((ChairBase)infusedWoodPlanksChair).getItemBlock(),
          ((ChairBase)vibrantWoodChair).getItemBlock(),
          ((TableBase)infusedWoodTable).getItemBlock(),
          ((TableBase)infusedWoodPlanksTable).getItemBlock(),
          ((TableBase)vibrantWoodTable).getItemBlock()
      );
  }

  @SubscribeEvent
  public static void registerRenders(ModelRegistryEvent event) { 
    if(Bark.isAstralSorceryLoaded && Bark.isRusticLoaded) {
      registerRender(Item.getItemFromBlock(infusedWoodPlanksStairs));
      registerRender(Item.getItemFromBlock(infusedWoodPlanksHalf));
      
      registerRender(Item.getItemFromBlock(infusedWoodChair));
      registerRender(Item.getItemFromBlock(infusedWoodPlanksChair));
      registerRender(Item.getItemFromBlock(vibrantWoodChair));
      registerRender(Item.getItemFromBlock(infusedWoodTable));
      registerRender(Item.getItemFromBlock(infusedWoodPlanksTable));
      registerRender(Item.getItemFromBlock(vibrantWoodTable));
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
