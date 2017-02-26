/*
 * Copyright (c) TheDragonTeam 2016-2017.
 */

package net.thedragonteam.armorplus.compat.jei.workbench

import mezz.jei.api.recipe.IRecipeHandler
import mezz.jei.api.recipe.IRecipeWrapper
import mezz.jei.util.ErrorUtil
import mezz.jei.util.Log
import net.minecraft.item.ItemStack
import net.thedragonteam.armorplus.api.Constants
import net.thedragonteam.armorplus.api.crafting.workbench.ShapelessRecipes

class WBShapelessRecipeHandler : IRecipeHandler<ShapelessRecipes> {
    override fun getRecipeClass(): Class<ShapelessRecipes> {
        return ShapelessRecipes::class.java
    }

    override fun getRecipeCategoryUid(recipe: ShapelessRecipes): String {
        return Constants.Compat.JEI_CATEGORY_WORKBENCH
    }

    override fun getRecipeWrapper(recipe: ShapelessRecipes): IRecipeWrapper {
        return WBShapelessRecipeWrapper(recipe)
    }

    override fun isRecipeValid(recipe: ShapelessRecipes): Boolean {
        var inputCount = 0
        for (input in recipe.input) {
            when (input) {
                is ItemStack -> inputCount++
                else -> {
                    val recipeInfo = ErrorUtil.getInfoFromRecipe(recipe, this)
                    Log.error("Recipe has an input that is not an ItemStack. {}", recipeInfo)
                    return false
                }
            }
        }
        if (inputCount > 9) {
            val recipeInfo = ErrorUtil.getInfoFromRecipe(recipe, this)
            Log.error("Recipe has too many inputs. {}", recipeInfo)
            return false
        }
        return inputCount > 0
    }
}