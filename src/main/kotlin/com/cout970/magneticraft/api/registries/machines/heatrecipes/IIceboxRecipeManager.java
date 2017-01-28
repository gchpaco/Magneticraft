package com.cout970.magneticraft.api.registries.machines.heatrecipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

/**
 * Created by cout970 on 24/08/2016.
 */
public interface IIceboxRecipeManager {

    /**
     * Retrieves the first recipe that matches the given input
     *
     * @param input the input to check the recipes
     * @return the recipes that matches the input or null if none matches the input
     */
    IIceboxRecipe findRecipe(ItemStack input);

    /**
     * Retrieves the first reverse-capable recipe that matches the given output
     *
     * @param output the output to check the recipes
     * @return the recipes that matches the input or null if none matches the output
     */
    IIceboxRecipe findRecipeReverse(FluidStack output);

    /**
     * The list with all valid output fluids
     */
    List<Fluid> getValidFluids();

    /**
     * The list with all registered recipes
     */
    List<IIceboxRecipe> getRecipes();

    /**
     * Register a recipe if is not already registered
     *
     * @param recipe The recipe to register
     * @return if the registration has ended successfully
     */
    boolean registerRecipe(IIceboxRecipe recipe);

    /**
     * Creates a default recipe
     *
     * @param input        the input stack
     * @param output       the output stack
     * @param heat         the heat consumed or generated by the recipe
     * @param specificHeat the heat consumed or generated per kelvin of temperature change of the output (used to determine energy requried to heat the output up to ambient temperature)
     * @param minTemp      the minimum temperature required for the recipe to craft
     * @param maxTemp      the maximum temperature at which the recipe can craft
     * @param reverse      if true, the recipe will run in reverse if below its minimum temperature
     */
    IIceboxRecipe createRecipe(ItemStack input, FluidStack output, long heat, double specificHeat, double minTemp, double maxTemp, boolean reverse);
}
