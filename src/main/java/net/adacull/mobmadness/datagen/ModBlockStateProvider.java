package net.adacull.mobmadness.datagen;

import net.adacull.mobmadness.MobMadness;
import net.adacull.mobmadness.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MobMadness.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SUSPICIOUS_BRICKS);
        blockWithItem(ModBlocks.CHISELED_SUSPICIOUS_BRICKS);
        blockWithItem(ModBlocks.CRACKED_SUSPICIOUS_BRICKS);
        blockWithItem(ModBlocks.DIVIDED_SUSPICIOUS_BRICKS);
        blockWithItem(ModBlocks.CRACKED_CHISELED_SUSPICIOUS_BRICKS);
        blockWithItem(ModBlocks.SUSPICIOUS_SUSPICIOUS_BRICKS);
        blockWithItem(ModBlocks.CRACK_SUSPICIOUS_BRICKS);
        blockWithItem(ModBlocks.CRACK_CRACKED_SUSPICIOUS_BRICKS);
    }


    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("mobmadness:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
