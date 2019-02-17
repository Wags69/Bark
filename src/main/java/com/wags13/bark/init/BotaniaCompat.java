package com.wags13.bark.init;

import com.wags13.bark.Bark;
import com.wags13.bark.blocks.ChairBase;
import com.wags13.bark.blocks.TableBase;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Bark.ID)
public class BotaniaCompat {
  
  public static Block livingwoodChair;
  public static Block livingwoodPlankChair;
  public static Block mossyLivingwoodPlanksChair;
  public static Block dreamwoodChair;
  public static Block dreamwoodPlankChair;
  public static Block mossyDreamwoodPlanksChair;
  public static Block shimmerwoodChair;
  
  public static Block livingwoodTable;
  public static Block livingwoodPlankTable;
  public static Block mossyLivingwoodPlanksTable;
  public static Block dreamwoodTable;
  public static Block dreamwoodPlankTable;
  public static Block mossyDreamwoodPlanksTable;
  public static Block shimmerwoodTable;

  public static void init() {
    livingwoodChair = new ChairBase("livingwood");
    livingwoodPlankChair = new ChairBase("livingwood_planks");
    mossyLivingwoodPlanksChair = new ChairBase("mossy_livingwood_planks");
    dreamwoodChair = new ChairBase("dreamwood");
    dreamwoodPlankChair = new ChairBase("dreamwood_planks");
    mossyDreamwoodPlanksChair = new ChairBase("mossy_dreamwood_planks");
    shimmerwoodChair = new ChairBase("shimmerwood");
    livingwoodTable = new TableBase("livingwood");
    livingwoodPlankTable = new TableBase("livingwood_planks");
    mossyLivingwoodPlanksTable = new TableBase("mossy_livingwood_planks");
    dreamwoodTable = new TableBase("dreamwood");
    dreamwoodPlankTable = new TableBase("dreamwood_planks");
    mossyDreamwoodPlanksTable = new TableBase("mossy_dreamwood_planks");
    shimmerwoodTable = new TableBase("shimmerwood");
  }

  @SubscribeEvent
  public static void registerBlocks(RegistryEvent.Register<Block> event) {
    if(Bark.isBotaniaLoaded && Bark.isRusticLoaded)
      event.getRegistry().registerAll(
          livingwoodChair,
          livingwoodPlankChair,
          mossyLivingwoodPlanksChair,
          dreamwoodChair,
          dreamwoodPlankChair,
          mossyDreamwoodPlanksChair,
          shimmerwoodChair,
          
          livingwoodTable,
          livingwoodPlankTable,
          mossyLivingwoodPlanksTable,
          dreamwoodTable,
          dreamwoodPlankTable,
          mossyDreamwoodPlanksTable,
          shimmerwoodTable
      );
  }

  @SubscribeEvent
  public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
    if(Bark.isBotaniaLoaded && Bark.isRusticLoaded)
      event.getRegistry().registerAll(
          ((ChairBase)livingwoodChair).getItemBlock(),
          ((ChairBase)livingwoodPlankChair).getItemBlock(),
          ((ChairBase)mossyLivingwoodPlanksChair).getItemBlock(),
          ((ChairBase)dreamwoodChair).getItemBlock(),
          ((ChairBase)dreamwoodPlankChair).getItemBlock(),
          ((ChairBase)mossyDreamwoodPlanksChair).getItemBlock(),
          ((ChairBase)shimmerwoodChair).getItemBlock(),
          
          ((TableBase)livingwoodTable).getItemBlock(),
          ((TableBase)livingwoodPlankTable).getItemBlock(),
          ((TableBase)mossyLivingwoodPlanksTable).getItemBlock(),
          ((TableBase)dreamwoodTable).getItemBlock(),
          ((TableBase)dreamwoodPlankTable).getItemBlock(),
          ((TableBase)mossyDreamwoodPlanksTable).getItemBlock(),
          ((TableBase)shimmerwoodTable).getItemBlock()
      );
  }

  @SubscribeEvent
  public static void registerRenders(ModelRegistryEvent event) { 
    if(Bark.isBotaniaLoaded && Bark.isRusticLoaded) {
      registerRender(Item.getItemFromBlock(livingwoodChair));
      registerRender(Item.getItemFromBlock(livingwoodPlankChair));
      registerRender(Item.getItemFromBlock(mossyLivingwoodPlanksChair));
      registerRender(Item.getItemFromBlock(dreamwoodChair));
      registerRender(Item.getItemFromBlock(dreamwoodPlankChair));
      registerRender(Item.getItemFromBlock(mossyDreamwoodPlanksChair));
      registerRender(Item.getItemFromBlock(shimmerwoodChair));
      
      registerRender(Item.getItemFromBlock(livingwoodTable));
      registerRender(Item.getItemFromBlock(livingwoodPlankTable));
      registerRender(Item.getItemFromBlock(mossyLivingwoodPlanksTable));
      registerRender(Item.getItemFromBlock(dreamwoodTable));
      registerRender(Item.getItemFromBlock(dreamwoodPlankTable));
      registerRender(Item.getItemFromBlock(mossyDreamwoodPlanksTable));
      registerRender(Item.getItemFromBlock(shimmerwoodTable));
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
