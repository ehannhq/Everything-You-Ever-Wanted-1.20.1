package net.ehann.everythingmod.datagen;

import net.ehann.everythingmod.EverythingMod;
import net.ehann.everythingmod.block.ModBlock;
import net.ehann.everythingmod.item.ModItem;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> VOIDSTONE = List.of(ModItem.VOIDSTONECHUNK.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, VOIDSTONE, RecipeCategory.MISC, ModItem.VOIDSTONE.get(), 0.25f, 200, "voidstone");
        oreBlasting(pWriter, VOIDSTONE, RecipeCategory.MISC, ModItem.VOIDSTONE.get(), 0.25f, 100, "voidstone");

//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.VOIDSTONECHUNK.get())
//                .pattern("PPP")
//                .pattern("PPP")
//                .pattern("PPP")
//                .define('P', ModItem.END_ORE.get())
//                .unlockedBy(getHasName(ModItem.END_ORE.get()), has(ModItem.END_ORE.get()))
//                .save(pWriter);

//            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.VOIDSTONE.get())
//                    .requires(ModItem.VOIDSTONECHUNK.get())
//                    .unlockedBy(getHasName(ModItem.VOIDSTONECHUNK.get()), has(ModItem.VOIDSTONECHUNK.get()))
//                    .save(pWriter);
//
    }


    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, EverythingMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
