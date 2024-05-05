package net.adacull.mobmadness.datagen;

import net.adacull.mobmadness.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLOWPIPE.get())
                .pattern(" S ")
                .pattern(" B ")
                .pattern("   ")
                .define('B', Items.BAMBOO)
                .define('S', Items.STRING)
                .unlockedBy("has_bamboo", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.BAMBOO).build()))
                .save(pWriter);

    }
}

