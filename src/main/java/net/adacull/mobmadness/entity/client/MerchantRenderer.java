package net.adacull.mobmadness.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.adacull.mobmadness.MobMadness;
import net.adacull.mobmadness.entity.custom.MerchantEntity;
import net.adacull.mobmadness.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MerchantRenderer extends MobRenderer<MerchantEntity, MerchantModel<MerchantEntity>> {
    public static final ResourceLocation MERCHANT_LOCATION = new ResourceLocation(MobMadness.MOD_ID, "textures/entity/merchant.png");

    public MerchantRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MerchantModel<>(pContext.bakeLayer(ModModelLayers.MERCHANT_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(MerchantEntity pEntity) {
        return MERCHANT_LOCATION;
    }

    @Override
    public void render(MerchantEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isAlive()) {
            pPoseStack.scale(1.45f, 1.45f, 1.45f);

        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
