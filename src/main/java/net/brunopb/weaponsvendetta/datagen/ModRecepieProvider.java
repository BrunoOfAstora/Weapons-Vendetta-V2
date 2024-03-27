package net.brunopb.weaponsvendetta.datagen;

import net.brunopb.weaponsvendetta.WeaponsVendetta;
import net.brunopb.weaponsvendetta.block.ModBlocks;
import net.brunopb.weaponsvendetta.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecepieProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SAPHIRA_SMELTABLES = List.of(ModItems.SAPHIRA.get(),
            ModBlocks.SAPHIRA_BLOCK.get(), ModBlocks.RUBI_BLOCK.get());
    public ModRecepieProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, SAPHIRA_SMELTABLES, RecipeCategory.MISC, ModItems.SAPHIRA.get(), 0.25f, 100,"saphira");
        oreSmelting(pWriter, SAPHIRA_SMELTABLES, RecipeCategory.MISC, ModItems.SAPHIRA.get(), 0.25f, 100,"saphira");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPHIRA_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S',ModItems.SAPHIRA.get())
                .unlockedBy(getHasName(ModItems.SAPHIRA.get()), has(ModItems.SAPHIRA.get()))
                .save(pWriter);


    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while (var9.hasNext()) {
            ItemLike itemlike = (ItemLike) var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience,
                    pCookingTime, pCookingSerializer).group(pGroup).
                    unlockedBy(getHasName(itemlike), has(itemlike)).
                    save(pFinishedRecipeConsumer, WeaponsVendetta.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}