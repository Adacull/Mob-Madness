package net.adacull.mobmadness.datagen;

import net.adacull.mobmadness.MobMadness;
import net.adacull.mobmadness.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MobMadness.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SUSPICIOUS_BRICKS.get())
                .add(ModBlocks.CHISELED_SUSPICIOUS_BRICKS.get())
                .add(ModBlocks.CRACKED_SUSPICIOUS_BRICKS.get())
                .add(ModBlocks.DIVIDED_SUSPICIOUS_BRICKS.get())
                .add(ModBlocks.CRACKED_CHISELED_SUSPICIOUS_BRICKS.get())
                .add(ModBlocks.SUSPICIOUS_SUSPICIOUS_BRICKS.get())
                .add(ModBlocks.CRACK_SUSPICIOUS_BRICKS.get())
                .add(ModBlocks.CRACK_CRACKED_SUSPICIOUS_BRICKS.get());


    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}

