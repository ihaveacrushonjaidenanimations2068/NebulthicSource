
package com.varahunter.nebulithic.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
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
public class ContemplatorEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public ContemplatorEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 142);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("contemplator")
						.setRegistryName("contemplator");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -65281, -13369549, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("contemplator"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("nebulithic_ascension_rewritten:eczemic_snowy_hilly_barrens")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("nebulithic_ascension_rewritten:eczemic_hilly_barrens")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 20, 4, 4));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelNewContemplator(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/newcontemplator.png");
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
			experienceValue = 0;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
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
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelNewContemplator extends EntityModel<Entity> {
		private final ModelRenderer legRight;
		private final ModelRenderer bone3;
		private final ModelRenderer legLeft;
		private final ModelRenderer bone4;
		private final ModelRenderer body;
		private final ModelRenderer waist1;
		private final ModelRenderer wingRight;
		private final ModelRenderer wingLeft;
		private final ModelRenderer headBase;
		private final ModelRenderer antennaRight;
		private final ModelRenderer antennaRight2;
		private final ModelRenderer armRightBase;
		private final ModelRenderer armRightBase2;
		private final ModelRenderer bone;
		private final ModelRenderer armLeftBase;
		private final ModelRenderer armLeftBase2;
		private final ModelRenderer sword;
		private final ModelRenderer hilt;
		private final ModelRenderer hilt2;
		private final ModelRenderer blade;
		public ModelNewContemplator() {
			textureWidth = 128;
			textureHeight = 128;
			legRight = new ModelRenderer(this);
			legRight.setRotationPoint(-4.0F, 3.0F, 3.0F);
			setRotationAngle(legRight, -0.7854F, 0.0F, 0.0F);
			legRight.setTextureOffset(46, 46).addBox(-3.0F, -1.5858F, -1.5858F, 4.0F, 13.0F, 4.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(-1.0F, 11.5858F, 0.5858F);
			legRight.addChild(bone3);
			setRotationAngle(bone3, 0.7854F, 0.0F, 0.0F);
			bone3.setTextureOffset(58, 59).addBox(-2.0F, -1.0569F, -1.4142F, 4.0F, 13.0F, 4.0F, 0.0F, false);
			legLeft = new ModelRenderer(this);
			legLeft.setRotationPoint(4.0F, 1.0F, 2.0F);
			setRotationAngle(legLeft, -0.7854F, 0.0F, 0.0F);
			legLeft.setTextureOffset(62, 35).addBox(-2.0F, -0.1716F, 0.8284F, 4.0F, 13.0F, 4.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(-0.4F, 10.1F, -0.1F);
			legLeft.addChild(bone4);
			setRotationAngle(bone4, 0.7854F, 0.0F, 0.0F);
			bone4.setTextureOffset(62, 16).addBox(-1.6F, 2.5858F, -1.2728F, 4.0F, 13.0F, 4.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(-1.0F, 0.0F, 1.0F);
			setRotationAngle(body, 0.5236F, 0.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-6.0F, -13.5359F, -4.0F, 13.0F, 15.0F, 7.0F, 0.0F, false);
			waist1 = new ModelRenderer(this);
			waist1.setRotationPoint(1.0F, 24.0F, -1.0F);
			body.addChild(waist1);
			waist1.setTextureOffset(0, 22).addBox(-3.0F, -22.5359F, -2.0F, 5.0F, 5.0F, 4.0F, 0.0F, false);
			wingRight = new ModelRenderer(this);
			wingRight.setRotationPoint(4.0F, -8.6699F, 0.5F);
			body.addChild(wingRight);
			setRotationAngle(wingRight, 0.0F, 0.0F, -0.3491F);
			wingRight.setTextureOffset(0, 39).addBox(-3.0F, -3.5359F, 0.0F, 7.0F, 30.0F, 5.0F, 0.0F, false);
			wingLeft = new ModelRenderer(this);
			wingLeft.setRotationPoint(-2.0F, -9.8038F, 6.0F);
			body.addChild(wingLeft);
			setRotationAngle(wingLeft, 0.0F, 0.0F, 0.2618F);
			wingLeft.setTextureOffset(24, 39).addBox(-3.3276F, -2.4905F, -5.5F, 6.0F, 30.0F, 5.0F, 0.0F, false);
			headBase = new ModelRenderer(this);
			headBase.setRotationPoint(-1.0F, -12.0F, -8.0F);
			headBase.setTextureOffset(44, 0).addBox(-3.0F, -5.0F, -5.0F, 7.0F, 7.0F, 9.0F, 0.0F, false);
			antennaRight = new ModelRenderer(this);
			antennaRight.setRotationPoint(1.0F, 36.0F, 8.0F);
			headBase.addChild(antennaRight);
			antennaRight.setTextureOffset(52, 70).addBox(-4.0F, -49.0F, -8.0F, 0.0F, 10.0F, 3.0F, 0.0F, false);
			antennaRight2 = new ModelRenderer(this);
			antennaRight2.setRotationPoint(6.0F, -5.0F, 1.0F);
			headBase.addChild(antennaRight2);
			setRotationAngle(antennaRight2, -0.4363F, 0.0F, 0.0F);
			antennaRight2.setTextureOffset(52, 60).addBox(-1.9F, -8.0F, -2.0F, 0.0F, 10.0F, 3.0F, 0.0F, false);
			armRightBase = new ModelRenderer(this);
			armRightBase.setRotationPoint(-8.0F, -11.0F, -5.0F);
			armRightBase.setTextureOffset(30, 74).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 10.0F, 2.0F, 0.0F, false);
			armRightBase2 = new ModelRenderer(this);
			armRightBase2.setRotationPoint(-1.0F, 5.0F, 1.0F);
			armRightBase.addChild(armRightBase2);
			setRotationAngle(armRightBase2, -0.4363F, 0.0F, 0.0F);
			armRightBase2.setTextureOffset(0, 74).addBox(-1.0F, 3.6252F, -0.3095F, 3.0F, 10.0F, 3.0F, 0.0F, false);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(8.0F, 35.0F, 5.0F);
			armRightBase.addChild(bone);
			armLeftBase = new ModelRenderer(this);
			armLeftBase.setRotationPoint(7.0F, -11.0F, -5.0F);
			armLeftBase.setTextureOffset(20, 74).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 10.0F, 2.0F, 0.0F, false);
			armLeftBase2 = new ModelRenderer(this);
			armLeftBase2.setRotationPoint(1.0F, 5.0F, 0.0F);
			armLeftBase.addChild(armLeftBase2);
			setRotationAngle(armLeftBase2, -0.5236F, 0.0F, 0.0F);
			armLeftBase2.setTextureOffset(71, 73).addBox(-2.0F, 3.4641F, 1.0F, 3.0F, 10.0F, 3.0F, 0.0F, false);
			sword = new ModelRenderer(this);
			sword.setRotationPoint(-0.5F, 32.8923F, 23.9904F);
			armLeftBase2.addChild(sword);
			hilt = new ModelRenderer(this);
			hilt.setRotationPoint(0.0F, 0.0F, 0.0F);
			sword.addChild(hilt);
			hilt.setTextureOffset(22, 4).addBox(-1.0F, -23.0F, -33.0F, 2.0F, 2.0F, 18.0F, 0.0F, false);
			hilt2 = new ModelRenderer(this);
			hilt2.setRotationPoint(0.0F, 1.4282F, 13.5263F);
			hilt.addChild(hilt2);
			hilt2.setTextureOffset(12, 74).addBox(-1.0F, -29.0999F, -48.054F, 2.0F, 12.0F, 2.0F, 0.0F, false);
			hilt2.setTextureOffset(46, 63).addBox(-1.0F, -32.775F, -48.9449F, 2.0F, 19.0F, 1.0F, 0.0F, false);
			blade = new ModelRenderer(this);
			blade.setRotationPoint(0.0F, -23.7032F, -52.9449F);
			hilt2.addChild(blade);
			blade.setTextureOffset(0, 0).addBox(-0.2F, -2.4134F, -28.3519F, 0.0F, 6.0F, 33.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			legRight.render(matrixStack, buffer, packedLight, packedOverlay);
			legLeft.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			headBase.render(matrixStack, buffer, packedLight, packedOverlay);
			armRightBase.render(matrixStack, buffer, packedLight, packedOverlay);
			armLeftBase.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.legRight.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.headBase.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.headBase.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.armLeftBase.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.legLeft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.armRightBase.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}
