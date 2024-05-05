package net.adacull.mobmadness;

import com.mojang.logging.LogUtils;
import net.adacull.mobmadness.block.ModBlocks;
import net.adacull.mobmadness.entity.ModEntities;
import net.adacull.mobmadness.entity.client.MerchantRenderer;
import net.adacull.mobmadness.entity.client.SeedsProjectileRenderer;
import net.adacull.mobmadness.entity.custom.MerchantEntity;
import net.adacull.mobmadness.item.ModCreativeModeTabs;
import net.adacull.mobmadness.item.ModItemProperties;
import net.adacull.mobmadness.item.ModItems;
import net.adacull.mobmadness.particle.ModParticles;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MobMadness.MOD_ID)
public class MobMadness
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "mobmadness";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public MobMadness()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEntities.register(modEventBus);

        ModParticles.register(modEventBus);





        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.SEED_PROJECTILE.get(), SeedsProjectileRenderer::new);
            EntityRenderers.register(ModEntities.CARD_PROJECTILE.get(), ThrownItemRenderer::new);

            EntityRenderers.register(ModEntities.MERCHANT.get(), MerchantRenderer::new);

            event.enqueueWork(() -> {
                ModItemProperties.addCustomItemProperties();
            });
        }
    }
}
