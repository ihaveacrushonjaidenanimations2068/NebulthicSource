
package com.varahunter.nebulithic.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class CactrapEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public CactrapEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 174);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("cactrap")
						.setRegistryName("cactrap");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -13369549, -256, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("cactrap"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelCactrap(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/cactrap-texturemap.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 5;
			setNoAI(true);
			enablePersistence();
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10);
		}
	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelCactrap extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer frontRightLeg;
		private final ModelRenderer frontLeftLeg;
		private final ModelRenderer backLeftLeg;
		private final ModelRenderer backLeftLeg2;
		private final ModelRenderer branch1;
		private final ModelRenderer branch2;
		private final ModelRenderer branch3;
		private final ModelRenderer branch4;
		private final ModelRenderer bone2;
		private final ModelRenderer bone3;
		private final ModelRenderer bone4;
		private final ModelRenderer bone5;
		private final ModelRenderer bone6;
		private final ModelRenderer bone7;
		private final ModelRenderer SmallHead;
		private final ModelRenderer SmallHead2;
		private final ModelRenderer SmallHead3;
		private final ModelRenderer SmallHead4;
		private final ModelRenderer SmallHead5;
		public ModelCactrap() {
			textureWidth = 128;
			textureHeight = 128;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone.setTextureOffset(0, 0).addBox(-5.0F, -25.0F, -5.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);
			frontRightLeg = new ModelRenderer(this);
			frontRightLeg.setRotationPoint(0.0F, 24.0F, 0.0F);
			frontRightLeg.setTextureOffset(67, 73).addBox(-6.0F, -11.0F, -6.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
			frontLeftLeg = new ModelRenderer(this);
			frontLeftLeg.setRotationPoint(10.0F, 24.0F, 0.0F);
			frontLeftLeg.setTextureOffset(16, 71).addBox(-6.0F, -11.0F, -6.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
			backLeftLeg = new ModelRenderer(this);
			backLeftLeg.setRotationPoint(10.0F, 24.0F, 9.0F);
			backLeftLeg.setTextureOffset(8, 71).addBox(-6.0F, -11.0F, -5.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
			backLeftLeg2 = new ModelRenderer(this);
			backLeftLeg2.setRotationPoint(0.0F, 24.0F, 9.0F);
			backLeftLeg2.setTextureOffset(0, 71).addBox(-6.0F, -11.0F, -5.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
			branch1 = new ModelRenderer(this);
			branch1.setRotationPoint(0.0F, 24.0F, 0.0F);
			branch1.setTextureOffset(0, 67).addBox(5.0F, -15.0F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
			branch1.setTextureOffset(59, 67).addBox(15.0F, -30.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
			branch2 = new ModelRenderer(this);
			branch2.setRotationPoint(-23.0F, 24.0F, 0.0F);
			branch2.setTextureOffset(63, 52).addBox(6.0F, -15.0F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
			branch2.setTextureOffset(28, 67).addBox(6.0F, -30.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
			branch3 = new ModelRenderer(this);
			branch3.setRotationPoint(-23.0F, 24.0F, -10.0F);
			branch3.setTextureOffset(16, 28).addBox(22.0F, -15.0F, -7.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
			branch3.setTextureOffset(51, 65).addBox(22.0F, -30.0F, -7.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
			branch4 = new ModelRenderer(this);
			branch4.setRotationPoint(-23.0F, 24.0F, 12.0F);
			branch4.setTextureOffset(0, 26).addBox(22.0F, -15.0F, -7.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
			branch4.setTextureOffset(43, 64).addBox(22.0F, -30.0F, 3.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone2.setTextureOffset(75, 75).addBox(-4.0F, -36.0F, -4.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
			bone2.setTextureOffset(40, 78).addBox(-4.5F, -36.0F, -4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
			bone2.setTextureOffset(0, 26).addBox(-5.3F, -40.0F, -5.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
			bone2.setTextureOffset(0, 0).addBox(-4.3F, -45.0F, -4.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(8.0F, 24.0F, 0.0F);
			bone3.setTextureOffset(26, 70).addBox(-4.0F, -36.0F, -4.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
			bone3.setTextureOffset(38, 78).addBox(-4.5F, -36.0F, -4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
			bone3.setTextureOffset(74, 28).addBox(-5.3F, -40.0F, -5.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
			bone3.setTextureOffset(30, 0).addBox(-4.3F, -45.0F, -4.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(8.0F, 24.0F, 8.0F);
			bone4.setTextureOffset(24, 70).addBox(-4.0F, -36.0F, -4.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
			bone4.setTextureOffset(36, 78).addBox(-4.5F, -36.0F, -4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
			bone4.setTextureOffset(67, 67).addBox(-5.3F, -38.0F, -5.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);
			bone4.setTextureOffset(0, 34).addBox(-0.3F, -37.0F, -4.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(0.0F, 24.0F, 8.0F);
			bone5.setTextureOffset(40, 66).addBox(-4.0F, -36.0F, -4.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
			bone5.setTextureOffset(77, 77).addBox(-4.5F, -36.0F, -4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
			bone5.setTextureOffset(16, 26).addBox(-5.3F, -40.0F, -5.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
			bone5.setTextureOffset(4, 4).addBox(-4.3F, -45.0F, -4.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(0.0F, 8.75F, 0.0F);
			bone6.setTextureOffset(38, 66).addBox(0.0F, -20.75F, -0.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
			bone6.setTextureOffset(76, 36).addBox(-0.5F, -20.75F, 0.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(4.0F, 4.25F, -4.0F);
			bone6.addChild(bone7);
			bone7.setTextureOffset(36, 66).addBox(-4.0F, -36.0F, 3.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
			bone7.setTextureOffset(76, 16).addBox(-4.5F, -36.0F, 4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
			SmallHead = new ModelRenderer(this);
			SmallHead.setRotationPoint(0.0F, 24.0F, 0.0F);
			SmallHead.setTextureOffset(41, 53).addBox(-4.0F, -39.0F, 15.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);
			SmallHead.setTextureOffset(19, 59).addBox(-3.0F, -34.0F, 17.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);
			SmallHead.setTextureOffset(57, 44).addBox(-3.0F, -37.0F, 17.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);
			SmallHead2 = new ModelRenderer(this);
			SmallHead2.setRotationPoint(0.0F, 24.0F, 0.0F);
			SmallHead2.setTextureOffset(54, 20).addBox(-4.0F, -39.0F, -17.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);
			SmallHead2.setTextureOffset(62, 8).addBox(-3.0F, -34.0F, -22.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);
			SmallHead2.setTextureOffset(58, 59).addBox(-3.0F, -37.0F, -22.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);
			SmallHead3 = new ModelRenderer(this);
			SmallHead3.setRotationPoint(0.0F, 24.0F, 0.0F);
			SmallHead3.setTextureOffset(35, 35).addBox(-17.0F, -39.0F, -5.0F, 2.0F, 9.0F, 9.0F, 0.0F, false);
			SmallHead3.setTextureOffset(17, 46).addBox(-22.0F, -34.0F, -4.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);
			SmallHead3.setTextureOffset(45, 10).addBox(-22.0F, -37.0F, -4.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);
			SmallHead4 = new ModelRenderer(this);
			SmallHead4.setRotationPoint(0.0F, 24.0F, 0.0F);
			SmallHead4.setTextureOffset(32, 17).addBox(15.0F, -39.0F, -4.0F, 2.0F, 9.0F, 9.0F, 0.0F, false);
			SmallHead4.setTextureOffset(0, 42).addBox(17.0F, -34.0F, -3.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);
			SmallHead4.setTextureOffset(30, 0).addBox(17.0F, -37.0F, -3.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);
			SmallHead5 = new ModelRenderer(this);
			SmallHead5.setRotationPoint(0.0F, 7.0F, 15.0F);
			SmallHead5.setTextureOffset(52, 33).addBox(-4.0F, -39.0F, -17.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);
			SmallHead5.setTextureOffset(0, 56).addBox(-3.0F, -34.0F, -22.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);
			SmallHead5.setTextureOffset(54, 0).addBox(-3.0F, -37.0F, -22.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			frontRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			frontLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			backLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			backLeftLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
			branch1.render(matrixStack, buffer, packedLight, packedOverlay);
			branch2.render(matrixStack, buffer, packedLight, packedOverlay);
			branch3.render(matrixStack, buffer, packedLight, packedOverlay);
			branch4.render(matrixStack, buffer, packedLight, packedOverlay);
			bone2.render(matrixStack, buffer, packedLight, packedOverlay);
			bone3.render(matrixStack, buffer, packedLight, packedOverlay);
			bone4.render(matrixStack, buffer, packedLight, packedOverlay);
			bone5.render(matrixStack, buffer, packedLight, packedOverlay);
			bone6.render(matrixStack, buffer, packedLight, packedOverlay);
			SmallHead.render(matrixStack, buffer, packedLight, packedOverlay);
			SmallHead2.render(matrixStack, buffer, packedLight, packedOverlay);
			SmallHead3.render(matrixStack, buffer, packedLight, packedOverlay);
			SmallHead4.render(matrixStack, buffer, packedLight, packedOverlay);
			SmallHead5.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
