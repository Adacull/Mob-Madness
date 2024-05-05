package net.adacull.mobmadness.datagen;

import net.adacull.mobmadness.MobMadness;
import net.adacull.mobmadness.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

    public class ModItemModelProvider extends ItemModelProvider {
        public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
            super(output, MobMadness.MOD_ID, existingFileHelper);
        }

        @Override
        protected void registerModels() {
            simpleItem(ModItems.CARD);
            withExistingParent(ModItems.MERCHANT_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        }


        private ItemModelBuilder complexBlock(Block block) {
            return withExistingParent(ForgeRegistries.BLOCKS.getKey(block).getPath(), new ResourceLocation(MobMadness.MOD_ID,
                    "block/" + ForgeRegistries.BLOCKS.getKey(block).getPath()));
        }

        public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
            this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                    .texture("texture",  new ResourceLocation(MobMadness.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
        }

        public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
            this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                    .texture("texture",  new ResourceLocation(MobMadness.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
        }

        private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
            return withExistingParent(item.getId().getPath(),
                    new ResourceLocation("item/handheld")).texture("layer0",
                    new ResourceLocation(MobMadness.MOD_ID,"item/" + item.getId().getPath()));
        }


        private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
            return withExistingParent(item.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(MobMadness.MOD_ID,"item/" + item.getId().getPath()));
        }

    }
