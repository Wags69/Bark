package com.wags13.bark.recipe;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;
import com.wags13.bark.Bark;

import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class RusticRecipesFactory implements IConditionFactory {

  @Override
  public BooleanSupplier parse(JsonContext context, JsonObject json) {
    final boolean condition = Boolean.parseBoolean(JsonUtils.getString(json, "condition").toLowerCase());
    return () -> Bark.isRusticLoaded == condition;
  }

}
