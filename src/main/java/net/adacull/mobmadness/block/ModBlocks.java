package net.adacull.mobmadness.block;

import net.adacull.mobmadness.MobMadness;
import net.adacull.mobmadness.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MobMadness.MOD_ID);

    public static final RegistryObject<Block> SUSPICIOUS_BRICKS = registerBlock("suspicious_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));

    public static final RegistryObject<Block> CRACKED_SUSPICIOUS_BRICKS = registerBlock("cracked_suspicious_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));

    public static final RegistryObject<Block> DIVIDED_SUSPICIOUS_BRICKS = registerBlock("divided_suspicious_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));

    public static final RegistryObject<Block> CHISELED_SUSPICIOUS_BRICKS = registerBlock("chiseled_suspicious_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));

    public static final RegistryObject<Block> CRACKED_CHISELED_SUSPICIOUS_BRICKS = registerBlock("cracked_chiseled_suspicious_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));

    public static final RegistryObject<Block> SUSPICIOUS_SUSPICIOUS_BRICKS = registerBlock("suspicious_suspicious_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE)));

    public static final RegistryObject<Block> CRACK_SUSPICIOUS_BRICKS = registerBlock("crack_suspicious_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE).lightLevel(blockState -> 7)));

    public static final RegistryObject<Block> CRACK_CRACKED_SUSPICIOUS_BRICKS = registerBlock("crack_cracked_suspicious_bricks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE)
                    .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.GILDED_BLACKSTONE).lightLevel(blockState -> 11)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
