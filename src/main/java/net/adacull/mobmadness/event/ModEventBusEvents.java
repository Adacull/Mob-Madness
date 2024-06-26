package net.adacull.mobmadness.event;

import net.adacull.mobmadness.MobMadness;
import net.adacull.mobmadness.entity.ModEntities;
import net.adacull.mobmadness.entity.client.MerchantModel;
import net.adacull.mobmadness.entity.client.SeedsProjectileModel;
import net.adacull.mobmadness.entity.custom.MerchantEntity;
import net.adacull.mobmadness.entity.layers.ModModelLayers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MobMadness.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.SEEDS_PROJECTILE_LAYER, SeedsProjectileModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.MERCHANT_LAYER, MerchantModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MERCHANT.get(), MerchantEntity.createAttributes().build());
    }


}
