package com.idtech.entity;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.idtech.BaseMod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class EvilRabbitModel<T extends EvilRabbit> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "evilrabbit"), "main");
	private final ModelPart rearFootLeft;
	private final ModelPart rearFootRight;
	private final ModelPart haunchLeft;
	private final ModelPart haunchRight;
	private final ModelPart body;
	private final ModelPart frontLegLeft;
	private final ModelPart frontLegRight;
	private final ModelPart head;
	private final ModelPart earRight;
	private final ModelPart earLeft;
	private final ModelPart tail;
	private final ModelPart nose;

	public EvilRabbitModel(ModelPart root) {
		this.rearFootLeft = root.getChild("rearFootLeft");
		this.rearFootRight = root.getChild("rearFootRight");
		this.haunchLeft = root.getChild("haunchLeft");
		this.haunchRight = root.getChild("haunchRight");
		this.body = root.getChild("body");
		this.frontLegLeft = root.getChild("frontLegLeft");
		this.frontLegRight = root.getChild("frontLegRight");
		this.head = root.getChild("head");
		this.earRight = root.getChild("earRight");
		this.earLeft = root.getChild("earLeft");
		this.tail = root.getChild("tail");
		this.nose = root.getChild("nose");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition rearFootLeft = partdefinition.addOrReplaceChild("rearFootLeft", CubeListBuilder.create().texOffs(8, 24).mirror().addBox(-1.0F, 5.5F, -3.7F, 2.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 17.5F, 3.7F));

		PartDefinition rearFootRight = partdefinition.addOrReplaceChild("rearFootRight", CubeListBuilder.create().texOffs(26, 24).mirror().addBox(-1.0F, 5.5F, -3.7F, 2.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 17.5F, 3.7F));

		PartDefinition haunchLeft = partdefinition.addOrReplaceChild("haunchLeft", CubeListBuilder.create().texOffs(16, 15).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 17.5F, 3.7F, -0.3491F, 0.0F, 0.0F));

		PartDefinition haunchRight = partdefinition.addOrReplaceChild("haunchRight", CubeListBuilder.create().texOffs(30, 15).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 17.5F, 3.7F, -0.3491F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, -2.0F, -10.0F, 6.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 19.0F, 8.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition frontLegLeft = partdefinition.addOrReplaceChild("frontLegLeft", CubeListBuilder.create().texOffs(8, 15).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 17.0F, -1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition frontLegRight = partdefinition.addOrReplaceChild("frontLegRight", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 17.0F, -1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-2.5F, -4.0F, -5.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 16.0F, -1.0F));

		PartDefinition horn = head.addOrReplaceChild("horn", CubeListBuilder.create().texOffs(40, 13).addBox(0.0F, -6.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition horn_r1 = horn.addOrReplaceChild("horn_r1", CubeListBuilder.create().texOffs(40, 13).addBox(-4.75F, -2.95F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 13).addBox(-4.75F, -2.95F, -2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, -3.0F, 0.0F, -1.5708F, 1.5708F));

		PartDefinition horn_r2 = horn.addOrReplaceChild("horn_r2", CubeListBuilder.create().texOffs(40, 13).addBox(-1.75F, -1.95F, -3.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, -3.0F, 0.0F, -1.5708F, 0.9599F));

		PartDefinition horn_r3 = horn.addOrReplaceChild("horn_r3", CubeListBuilder.create().texOffs(40, 13).addBox(-0.863F, -1.4617F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -4.0F, -3.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition horn2 = head.addOrReplaceChild("horn2", CubeListBuilder.create().texOffs(40, 13).mirror().addBox(-2.0F, -6.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition horn_r4 = horn2.addOrReplaceChild("horn_r4", CubeListBuilder.create().texOffs(40, 13).mirror().addBox(2.75F, -2.95F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(40, 13).mirror().addBox(-1.25F, -2.95F, -2.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -4.0F, -3.0F, 0.0F, 1.5708F, -1.5708F));

		PartDefinition horn_r5 = horn2.addOrReplaceChild("horn_r5", CubeListBuilder.create().texOffs(40, 13).mirror().addBox(-1.25F, -1.95F, -3.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -4.0F, -3.0F, 0.0F, 1.5708F, -0.9599F));

		PartDefinition horn_r6 = horn2.addOrReplaceChild("horn_r6", CubeListBuilder.create().texOffs(40, 13).mirror().addBox(-3.137F, -1.4617F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -4.0F, -3.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition earRight = partdefinition.addOrReplaceChild("earRight", CubeListBuilder.create().texOffs(58, 0).mirror().addBox(-2.5F, -9.0F, -1.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 16.0F, -1.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition earLeft = partdefinition.addOrReplaceChild("earLeft", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(0.5F, -9.0F, -1.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 16.0F, -1.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(52, 6).mirror().addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(56, 12).mirror().addBox(-1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(52, 19).mirror().addBox(-2.5F, -2.5F, 2.0F, 5.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 20.0F, 7.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition nose = partdefinition.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(32, 9).mirror().addBox(-0.5F, -2.5F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 16.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		rearFootLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rearFootRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		haunchLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		haunchRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		frontLegLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		frontLegRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		earRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		earLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		nose.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}