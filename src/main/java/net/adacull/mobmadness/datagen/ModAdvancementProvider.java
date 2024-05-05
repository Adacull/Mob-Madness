package net.adacull.mobmadness.datagen;

import net.adacull.mobmadness.MobMadness;
import net.adacull.mobmadness.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class ModAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.BLOWPIPE.get()),
                        Component.literal("Mob Madness"), Component.literal("Pshwooo!"),
                        new ResourceLocation(MobMadness.MOD_ID, "textures/item/blowpipe.png"), FrameType.TASK,
                        true, true, false))
                .addCriterion("has_blowpipe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BLOWPIPE.get()))
                .save(saver, new ResourceLocation(MobMadness.MOD_ID, "mobmadness"), existingFileHelper);



    }
}
