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
public class EmbersCompat {
  
  public static Block sealedPlanksChair;
  public static Block sealedPlanksTable;
  
  public static void init() {
    sealedPlanksChair = new ChairBase("sealed_planks");
    sealedPlanksTable = new TableBase("sealed_planks");
  }

  @SubscribeEvent
  public static void registerBlocks(RegistryEvent.Register<Block> event) {
    if(Bark.isEmbersLoaded && Bark.isRusticLoaded)
      event.getRegistry().registerAll(
          sealedPlanksChair,
          sealedPlanksTable
      );
  }

  @SubscribeEvent
  public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
    if(Bark.isEmbersLoaded && Bark.isRusticLoaded)
      event.getRegistry().registerAll(
          ((ChairBase)sealedPlanksChair).getItemBlock(),
          ((TableBase)sealedPlanksTable).getItemBlock()
      );
  }

  @SubscribeEvent
  public static void registerRenders(ModelRegistryEvent event) { 
    if(Bark.isEmbersLoaded && Bark.isRusticLoaded) {
      registerRender(Item.getItemFromBlock(sealedPlanksChair));
      registerRender(Item.getItemFromBlock(sealedPlanksTable));
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
