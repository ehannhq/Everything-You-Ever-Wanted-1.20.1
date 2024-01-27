package net.ehann.everythingmod.datagen;

import net.ehann.everythingmod.EverythingMod;
import net.ehann.everythingmod.item.ModItem;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;


public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> VOIDIUM = List.of(ModItem.VOIDIUMCHUNK.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, VOIDIUM, RecipeCategory.MISC, ModItem.VOIDIUM.get(), 0.25f, 200, "voidstone");
        oreBlasting(pWriter, VOIDIUM, RecipeCategory.MISC, ModItem.VOIDIUM.get(), 0.25f, 100, "voidstone");

        smithing(pWriter, ModItem.VOIDIUM_UPGRADE_TEMPLATE.get(), Items.DIAMOND_HELMET, ModItem.VOIDIUM.get(), RecipeCategory.MISC, ModItem.VOIDIUM_HELMET.get());
        smithing(pWriter, ModItem.VOIDIUM_UPGRADE_TEMPLATE.get(), Items.DIAMOND_CHESTPLATE, ModItem.VOIDIUM.get(), RecipeCategory.MISC, ModItem.VOIDIUM_CHESTPLATE.get());
        smithing(pWriter, ModItem.VOIDIUM_UPGRADE_TEMPLATE.get(), Items.DIAMOND_LEGGINGS, ModItem.VOIDIUM.get(), RecipeCategory.MISC, ModItem.VOIDIUM_LEGGINGS.get());
        smithing(pWriter, ModItem.VOIDIUM_UPGRADE_TEMPLATE.get(), Items.DIAMOND_BOOTS, ModItem.VOIDIUM.get(), RecipeCategory.MISC, ModItem.VOIDIUM_BOOTS.get());

        smithing(pWriter, ModItem.VOIDIUM_UPGRADE_TEMPLATE.get(), Items.DIAMOND_SWORD, ModItem.VOIDIUM.get(), RecipeCategory.MISC, ModItem.VOIDIUM_SWORD.get());
        smithing(pWriter, ModItem.VOIDIUM_UPGRADE_TEMPLATE.get(), Items.DIAMOND_PICKAXE, ModItem.VOIDIUM.get(), RecipeCategory.MISC, ModItem.VOIDIUM_PICKAXE.get());
        smithing(pWriter, ModItem.VOIDIUM_UPGRADE_TEMPLATE.get(), Items.DIAMOND_AXE, ModItem.VOIDIUM.get(), RecipeCategory.MISC, ModItem.VOIDIUM_AXE.get());
        smithing(pWriter, ModItem.VOIDIUM_UPGRADE_TEMPLATE.get(), Items.DIAMOND_SHOVEL, ModItem.VOIDIUM.get(), RecipeCategory.MISC, ModItem.VOIDIUM_SHOVEL.get());
        smithing(pWriter, ModItem.VOIDIUM_UPGRADE_TEMPLATE.get(), Items.DIAMOND_HOE, ModItem.VOIDIUM.get(), RecipeCategory.MISC, ModItem.VOIDIUM_HOE.get());

//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.VOIDSTONECHUNK.get())
//                .pattern("PPP")
//                .pattern("PPP")
//                .pattern("PPP")
//                .define('P', ModBlock.END_ORE.get())
//                .unlockedBy(getHasName(ModBlock.END_ORE.get()), has(ModBlock.END_ORE.get()))
//                .save(pWriter);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.MINECRAFT.get())
                    .requires(ModItem.VOIDIUM.get())
                    .requires(Items.NETHERITE_INGOT)
                    .requires(Items.DIAMOND)
                    .requires(Items.EMERALD)
                    .requires(Items.GOLD_INGOT)
                    .requires(Items.IRON_INGOT)
                    .requires(Items.LAPIS_LAZULI)
                    .requires(Items.REDSTONE)
                    .requires(Items.AMETHYST_SHARD)
                    .save(pWriter);
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
    protected static void smithing(Consumer<FinishedRecipe> pFinishedRecipeConsumer, Item pSmithingTemplate, Item pIngredientItem, Item pUpgradeItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(pSmithingTemplate),
                Ingredient.of(pIngredientItem), Ingredient.of(pUpgradeItem),
                pCategory, pResultItem).unlocks("smithing", has(Items.STONE)).save(pFinishedRecipeConsumer,
                EverythingMod.MOD_ID + ":" + getItemName(pResultItem) + "_smithing");
    }
}
