package net.adacull.mobmadness.entity.layers;

import net.adacull.mobmadness.MobMadness;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation SEEDS_PROJECTILE_LAYER = new ModelLayerLocation(
            new ResourceLocation(MobMadness.MOD_ID, "seeds_projectile_layer"), "seeds_projectile_layer");

    public static final ModelLayerLocation MERCHANT_LAYER = new ModelLayerLocation(
            new ResourceLocation(MobMadness.MOD_ID, "merchant_layer"), "merchant_layer");

}
