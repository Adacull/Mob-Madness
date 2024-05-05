package net.adacull.mobmadness.entity;

import net.adacull.mobmadness.MobMadness;
import net.adacull.mobmadness.entity.custom.CardProjectileEntity;
import net.adacull.mobmadness.entity.custom.MerchantEntity;
import net.adacull.mobmadness.entity.custom.SeedProjectileEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MobMadness.MOD_ID);

    public static final RegistryObject<EntityType<SeedProjectileEntity>> SEED_PROJECTILE =
            ENTITY_TYPES.register("seed_projectile",
                    () -> EntityType.Builder.<SeedProjectileEntity>of(SeedProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .build("seed_projectile"));

    public static final RegistryObject<EntityType<CardProjectileEntity>> CARD_PROJECTILE =
            ENTITY_TYPES.register("card_projectile",
                    () -> EntityType.Builder.<CardProjectileEntity>of(CardProjectileEntity::new, MobCategory.MISC)
                            .sized(0.4f, 0.4f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .setCustomClientFactory(((spawnEntity, level) -> new CardProjectileEntity(level)))
                            .build("card_projectile"));

    public static final RegistryObject<EntityType<MerchantEntity>> MERCHANT =
            ENTITY_TYPES.register("merchant",
                    () -> EntityType.Builder.of(MerchantEntity::new, MobCategory.CREATURE)
                            .sized(1.5f, 1.75f)
                            .build("merchant"));






    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
