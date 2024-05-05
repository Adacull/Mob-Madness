package net.adacull.mobmadness.item;

import net.adacull.mobmadness.MobMadness;
import net.adacull.mobmadness.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MobMadness.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MM_TAB = CREATIVE_MODE_TABS.register("mm_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SUSPICIOUS_BRICKS.get()))
                    .title(Component.translatable("creativetab.mm_tab"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(ModItems.BLOWPIPE.get());
                        output.accept(ModItems.CARD.get());
                        output.accept(ModItems.MERCHANT_SPAWN_EGG.get());


                        output.accept(ModBlocks.SUSPICIOUS_BRICKS.get());
                        output.accept(ModBlocks.CHISELED_SUSPICIOUS_BRICKS.get());
                        output.accept(ModBlocks.DIVIDED_SUSPICIOUS_BRICKS.get());
                        output.accept(ModBlocks.CRACKED_SUSPICIOUS_BRICKS.get());
                        output.accept(ModBlocks.CRACKED_CHISELED_SUSPICIOUS_BRICKS.get());
                        output.accept(ModBlocks.SUSPICIOUS_SUSPICIOUS_BRICKS.get());
                        output.accept(ModBlocks.CRACK_SUSPICIOUS_BRICKS.get());
                        output.accept(ModBlocks.CRACK_CRACKED_SUSPICIOUS_BRICKS.get());

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
