package net.adacull.mobmadness.item;

import net.adacull.mobmadness.MobMadness;
import net.adacull.mobmadness.entity.ModEntities;
import net.adacull.mobmadness.item.custom.BlowpipeItem;
import net.adacull.mobmadness.item.custom.CardItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MobMadness.MOD_ID);

    public static final RegistryObject<Item> BLOWPIPE = ITEMS.register("blowpipe",
            () -> new BlowpipeItem(new Item.Properties().stacksTo(1).durability(240)));
    public static final RegistryObject<Item> CARD = ITEMS.register("card",
            () -> new CardItem(new Item.Properties()));
    public static final RegistryObject<Item> MERCHANT_SPAWN_EGG = ITEMS.register("merchant_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MERCHANT, 0x084c18, 0x5d2063, new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
