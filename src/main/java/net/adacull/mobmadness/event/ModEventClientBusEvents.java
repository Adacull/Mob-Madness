package net.adacull.mobmadness.event;

import net.adacull.mobmadness.MobMadness;
import net.adacull.mobmadness.particle.ModParticles;
import net.adacull.mobmadness.particle.SeedsParticles;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MobMadness.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.SEEDS_PARTICLES.get(), SeedsParticles.Provider::new);
    }

}
