
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
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
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
public class LithosaurusEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public LithosaurusEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 199);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("lithosaurus")
						.setRegistryName("lithosaurus");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -6710887, -3355444, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("lithosaurus"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("nebulithic_ascension_rewritten:hilly_barrens")))
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
			return new MobRenderer(renderManager, new ModelLithosaurus(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/lithosaurus.png");
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
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, FrostuskEntity.CustomEntity.class, false, false));
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(6, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.step"));
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
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelLithosaurus extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer legFrontLeftBase;
		private final ModelRenderer bone2;
		private final ModelRenderer legFrontRightBase;
		private final ModelRenderer bone3;
		private final ModelRenderer legBackRightBase;
		private final ModelRenderer bone4;
		private final ModelRenderer legBackLeftBase;
		private final ModelRenderer bone5;
		private final ModelRenderer bone6;
		private final ModelRenderer bone7;
		private final ModelRenderer bone8;
		private final ModelRenderer bone9;
		private final ModelRenderer bone10;
		public ModelLithosaurus() {
			textureWidth = 128;
			textureHeight = 128;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone.setTextureOffset(0, 0).addBox(-8.0F, -24.0F, -12.0F, 16.0F, 15.0F, 29.0F, 1.0F, false);
			legFrontLeftBase = new ModelRenderer(this);
			legFrontLeftBase.setRotationPoint(10.0F, 10.0F, -9.0F);
			legFrontLeftBase.setTextureOffset(43, 74).addBox(-2.0F, -3.0F, -2.0F, 3.0F, 5.0F, 5.0F, 1.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(9.0F, 14.0F, -8.0F);
			legFrontLeftBase.addChild(bone2);
			bone2.setTextureOffset(34, 44).addBox(-11.0F, -10.0F, 6.0F, 3.0F, 9.0F, 5.0F, 1.0F, false);
			legFrontRightBase = new ModelRenderer(this);
			legFrontRightBase.setRotationPoint(-9.0F, 9.0F, -8.0F);
			legFrontRightBase.setTextureOffset(27, 74).addBox(-2.0F, -2.0F, -3.0F, 3.0F, 5.0F, 5.0F, 1.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(9.0F, 15.0F, -9.0F);
			legFrontRightBase.addChild(bone3);
			bone3.setTextureOffset(0, 44).addBox(-11.0F, -10.0F, 6.0F, 3.0F, 9.0F, 5.0F, 1.0F, false);
			legBackRightBase = new ModelRenderer(this);
			legBackRightBase.setRotationPoint(-10.0F, 9.0F, 9.0F);
			legBackRightBase.setTextureOffset(16, 68).addBox(-1.0F, -2.0F, -3.0F, 3.0F, 5.0F, 5.0F, 1.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(10.0F, 15.0F, -9.0F);
			legBackRightBase.addChild(bone4);
			bone4.setTextureOffset(11, 11).addBox(-11.0F, -10.0F, 6.0F, 3.0F, 9.0F, 5.0F, 1.0F, false);
			legBackLeftBase = new ModelRenderer(this);
			legBackLeftBase.setRotationPoint(10.0F, 10.0F, 9.0F);
			legBackLeftBase.setTextureOffset(0, 68).addBox(-2.0F, -3.0F, -3.0F, 3.0F, 5.0F, 5.0F, 1.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(9.0F, 14.0F, -9.0F);
			legBackLeftBase.addChild(bone5);
			bone5.setTextureOffset(0, 0).addBox(-11.0F, -10.0F, 6.0F, 3.0F, 9.0F, 5.0F, 1.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone6.setTextureOffset(68, 44).addBox(-6.0F, -23.0F, -25.0F, 12.0F, 6.0F, 13.0F, 1.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(0.0F, 8.0F, 0.0F);
			bone6.addChild(bone7);
			bone7.setTextureOffset(73, 73).addBox(-6.0F, -23.0F, -25.0F, 12.0F, 3.0F, 13.0F, 1.0F, false);
			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(0.0F, 24.0F, 2.0F);
			bone8.setTextureOffset(34, 50).addBox(-3.0F, -19.0F, 11.0F, 8.0F, 6.0F, 18.0F, 1.0F, false);
			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(0.0F, 0.0F, 18.0F);
			bone8.addChild(bone9);
			bone9.setTextureOffset(0, 44).addBox(-3.0F, -19.0F, 13.0F, 8.0F, 6.0F, 18.0F, 1.0F, false);
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(0.0F, 0.0F, -2.0F);
			bone8.addChild(bone10);
			bone10.setTextureOffset(61, 0).addBox(-7.0F, -22.0F, 52.0F, 16.0F, 13.0F, 10.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			legFrontLeftBase.render(matrixStack, buffer, packedLight, packedOverlay);
			legFrontRightBase.render(matrixStack, buffer, packedLight, packedOverlay);
			legBackRightBase.render(matrixStack, buffer, packedLight, packedOverlay);
			legBackLeftBase.render(matrixStack, buffer, packedLight, packedOverlay);
			bone6.render(matrixStack, buffer, packedLight, packedOverlay);
			bone8.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.legFrontRightBase.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.legFrontLeftBase.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.legBackRightBase.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.legBackLeftBase.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
