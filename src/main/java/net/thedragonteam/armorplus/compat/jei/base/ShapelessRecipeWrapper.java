package net.thedragonteam.armorplus.compat.jei.base;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.thedragonteam.armorplus.api.crafting.IRecipe;
import net.thedragonteam.armorplus.compat.jei.JEIUtils;

import java.util.Objects;

public class ShapelessRecipeWrapper implements IRecipeWrapper {

    private final IRecipe recipe;
    private final NonNullList<ItemStack> input;

    public ShapelessRecipeWrapper(IRecipe recipe, NonNullList<ItemStack> inputList) {
        this.recipe = recipe;
        this.input = inputList;
        inputList.stream().filter(Objects::nonNull).filter(itemStack ->
                !itemStack.isEmpty() && itemStack.getCount() != 1
        ).forEachOrdered(itemStack -> itemStack.setCount(1));
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        JEIUtils.getIngredients(ingredients, recipe, input);
    }
}