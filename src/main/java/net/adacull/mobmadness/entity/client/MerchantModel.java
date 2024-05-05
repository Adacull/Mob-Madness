package net.adacull.mobmadness.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.adacull.mobmadness.entity.animations.ModAnimationDefinitions;
import net.adacull.mobmadness.entity.custom.MerchantEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class MerchantModel<T extends MerchantEntity> extends HierarchicalModel<T> {


	private final ModelPart merchant;
	private final ModelPart head;

	public MerchantModel(ModelPart root) {
		this.merchant = root.getChild("merchant");
		this.head = merchant.getChild("body").getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition merchant = partdefinition.addOrReplaceChild("merchant", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = merchant.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arms = body.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm2 = Arms.addOrReplaceChild("Arm2", CubeListBuilder.create().texOffs(0, 52).addBox(-2.0F, 0.0F, -3.0F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, -19.0F, 2.0F));

		PartDefinition Arm1 = Arms.addOrReplaceChild("Arm1", CubeListBuilder.create().texOffs(49, 47).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, -19.0F, 2.0F));

		PartDefinition Belly = body.addOrReplaceChild("Belly", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -21.0F, -5.0F, 16.0F, 17.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Legs = body.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Leg1 = Legs.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(45, 0).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -4.0F, 2.0F));

		PartDefinition Leg2 = Legs.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(37, 30).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -4.0F, 2.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 30).addBox(-5.0F, -26.0F, -7.0F, 10.0F, 5.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Nose = head.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -22.0F, -9.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(MerchantEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(entity, netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.MERCHANT_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(entity.idleAnimationState, ModAnimationDefinitions.MERCHANT_IDLE, ageInTicks, 1f);
	}

	private void applyHeadRotation(MerchantEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float) Math.PI / 180F);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		merchant.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return merchant;
	}
}