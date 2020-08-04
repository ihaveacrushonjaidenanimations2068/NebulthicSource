
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
public class FrostuskEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public FrostuskEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 181);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 0.8f)).build("frostusk")
						.setRegistryName("frostusk");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -1, -16724788, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("frostusk"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("nebulithic_ascension_rewritten:snowy_hilly_barrens")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("nebulithic_ascension_rewritten:sclerotis_258_ice_spikes")))
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
			return new MobRenderer(renderManager, new ModelFrostuskSmall(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/frostusksmall.png");
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
			return CreatureAttribute.UNDEAD;
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
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4);
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
	public static class ModelFrostuskSmall extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer frontLeftLeg;
		private final ModelRenderer bone2;
		private final ModelRenderer frontRightLeg;
		private final ModelRenderer bone3;
		private final ModelRenderer backRightLeg;
		private final ModelRenderer bone6;
		private final ModelRenderer backLeftLeg;
		private final ModelRenderer bone7;
		private final ModelRenderer head;
		private final ModelRenderer bone4;
		private final ModelRenderer bone8;
		private final ModelRenderer bone9;
		private final ModelRenderer bone10;
		private final ModelRenderer bone12;
		private final ModelRenderer spine;
		private final ModelRenderer bone5;
		private final ModelRenderer bone11;
		public ModelFrostuskSmall() {
			textureWidth = 64;
			textureHeight = 64;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone.setTextureOffset(0, 0).addBox(-2.0F, -5.0F, -5.0F, 4.0F, 3.0F, 10.0F, 0.0F, false);
			frontLeftLeg = new ModelRenderer(this);
			frontLeftLeg.setRotationPoint(2.4F, 21.5F, -3.6F);
			frontLeftLeg.setTextureOffset(4, 15).addBox(-0.4F, -0.5F, -0.4F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(-2.4F, 2.5F, 3.6F);
			frontLeftLeg.addChild(bone2);
			bone2.setTextureOffset(6, 4).addBox(2.0F, 0.0F, -5.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			frontRightLeg = new ModelRenderer(this);
			frontRightLeg.setRotationPoint(-2.2F, 21.6F, -3.5F);
			frontRightLeg.setTextureOffset(0, 15).addBox(-0.8F, -0.6F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(-2.8F, 2.4F, 3.5F);
			frontRightLeg.addChild(bone3);
			bone3.setTextureOffset(5, 1).addBox(2.0F, 0.0F, -5.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			backRightLeg = new ModelRenderer(this);
			backRightLeg.setRotationPoint(-2.2F, 21.7F, 3.3F);
			backRightLeg.setTextureOffset(4, 4).addBox(-0.8F, -0.7F, -0.3F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(-2.8F, 2.3F, 3.7F);
			backRightLeg.addChild(bone6);
			bone6.setTextureOffset(5, 0).addBox(2.0F, 0.0F, -5.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			backLeftLeg = new ModelRenderer(this);
			backLeftLeg.setRotationPoint(2.5F, 21.5F, 3.5F);
			backLeftLeg.setTextureOffset(0, 4).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(-2.5F, 2.5F, 3.5F);
			backLeftLeg.addChild(bone7);
			bone7.setTextureOffset(2, 4).addBox(2.0F, 0.0F, -5.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 24.0F, 0.0F);
			head.setTextureOffset(14, 23).addBox(-2.0F, -6.0F, -9.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(bone4);
			bone4.setTextureOffset(0, 15).addBox(-3.0F, -4.0F, -13.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(3.0F, 0.0F, 0.0F);
			head.addChild(bone8);
			bone8.setTextureOffset(10, 13).addBox(-1.0F, -4.0F, -13.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(bone9);
			bone9.setTextureOffset(20, 13).addBox(-2.0F, -7.0F, -9.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(bone10);
			bone10.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -11.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			bone12 = new ModelRenderer(this);
			bone12.setRotationPoint(0.0F, -3.0F, 0.0F);
			head.addChild(bone12);
			bone12.setTextureOffset(26, 0).addBox(-2.0F, -2.0F, -11.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);
			spine = new ModelRenderer(this);
			spine.setRotationPoint(0.0F, 24.0F, 0.0F);
			spine.setTextureOffset(0, 4).addBox(0.0F, -7.0F, -4.0F, 0.0F, 2.0F, 9.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone5.setTextureOffset(0, 25).addBox(-1.0F, -4.0F, 5.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			bone5.setTextureOffset(22, 5).addBox(-1.0F, -4.0F, 9.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone5.addChild(bone11);
			bone11.setTextureOffset(9, 0).addBox(-2.0F, -3.6F, 5.0F, 4.0F, 0.0F, 9.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			frontLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			frontRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			backRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			backLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			spine.render(matrixStack, buffer, packedLight, packedOverlay);
			bone5.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.frontRightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.backRightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.frontLeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.backLeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
