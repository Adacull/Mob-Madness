package net.adacull.mobmadness.item;

import net.adacull.mobmadness.MobMadness;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.BLOWPIPE.get(), new ResourceLocation(MobMadness.MOD_ID, "trans"),
                (pStack, pLevel, pEntity, pSeed) -> pStack.hasTag() ? 1f : 0f);
    }


}
