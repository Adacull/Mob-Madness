package net.adacull.mobmadness.datagen.loot;

import net.adacull.mobmadness.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SUSPICIOUS_BRICKS.get());
        this.dropSelf(ModBlocks.CRACKED_SUSPICIOUS_BRICKS.get());
        this.dropSelf(ModBlocks.DIVIDED_SUSPICIOUS_BRICKS.get());
        this.dropSelf(ModBlocks.CHISELED_SUSPICIOUS_BRICKS.get());
        this.dropSelf(ModBlocks.SUSPICIOUS_SUSPICIOUS_BRICKS.get());
        this.dropSelf(ModBlocks.CRACKED_CHISELED_SUSPICIOUS_BRICKS.get());
        this.dropSelf(ModBlocks.CRACK_SUSPICIOUS_BRICKS.get());
        this.dropSelf(ModBlocks.CRACK_CRACKED_SUSPICIOUS_BRICKS.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;

    }
}
