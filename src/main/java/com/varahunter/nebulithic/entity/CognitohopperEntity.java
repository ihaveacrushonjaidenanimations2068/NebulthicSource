
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
import net.minecraft.world.IWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import com.varahunter.nebulithic.procedures.CognitohopperEntityDiesProcedure;
import com.varahunter.nebulithic.procedures.CognitohopperCreateSecretionsProcedure;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class CognitohopperEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public CognitohopperEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 293);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("cognitohopper")
						.setRegistryName("cognitohopper");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -65536, -52429, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("cognitohopper_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("nebulithic_ascension_rewritten:blood_forest")))
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
			return new MobRenderer(renderManager, new ModelCognitohopper(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/cognitohopper.png");
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
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, PlayerEntity.class, true, false));
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true));
			this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(4, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(6, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
					.getValue(new ResourceLocation("nebulithic_ascension_rewritten:enity.cognitohopper.step"));
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
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity sourceentity = source.getTrueSource();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				CognitohopperEntityDiesProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata,
				CompoundNBT tag) {
			ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				CognitohopperCreateSecretionsProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		public void baseTick() {
			super.baseTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				CognitohopperCreateSecretionsProcedure.executeProcedure($_dependencies);
			}
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
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK);
			this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(10D);
		}

		public void livingTick() {
			super.livingTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Random random = this.rand;
			Entity entity = this;
			if (true)
				for (int l = 0; l < 4; ++l) {
					double d0 = (x + random.nextFloat());
					double d1 = (y + random.nextFloat());
					double d2 = (z + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 0.5D;
					double d4 = (random.nextFloat() - 0.5D) * 0.5D;
					double d5 = (random.nextFloat() - 0.5D) * 0.5D;
					world.addParticle(ParticleTypes.FALLING_WATER, d0, d1, d2, d3, d4, d5);
				}
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelCognitohopper extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer bone4;
		private final ModelRenderer bone2;
		private final ModelRenderer bone3;
		private final ModelRenderer legLeft;
		private final ModelRenderer legLeft2;
		private final ModelRenderer legLeft3;
		private final ModelRenderer legLeft4;
		private final ModelRenderer legLeft5;
		private final ModelRenderer legLeft6;
		private final ModelRenderer legLeft7;
		private final ModelRenderer legLeft8;
		private final ModelRenderer legLeft9;
		private final ModelRenderer legLeft10;
		private final ModelRenderer legLeft11;
		private final ModelRenderer legLeft12;
		public ModelCognitohopper() {
			textureWidth = 128;
			textureHeight = 128;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(1.5F, 10.5F, 6.0F);
			setRotationAngle(bone, -0.6981F, 0.0F, 0.0F);
			bone.setTextureOffset(0, 0).addBox(-8.5F, -23.6148F, -17.9572F, 16.0F, 17.0F, 32.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(-1.0F, -13.433F, -6.073F);
			bone.addChild(bone4);
			setRotationAngle(bone4, 0.6545F, 0.0F, 0.0F);
			bone4.setTextureOffset(0, 49).addBox(-8.5F, -15.1922F, -31.2769F, 18.0F, 17.0F, 27.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone.addChild(bone2);
			bone2.setTextureOffset(62, 62).addBox(0.0F, -33.2934F, -17.9413F, 0.0F, 9.0F, 31.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(-0.5F, -19.8711F, -19.1976F);
			bone.addChild(bone3);
			setRotationAngle(bone3, 0.6981F, 0.0F, 0.0F);
			bone3.setTextureOffset(0, 62).addBox(0.5F, -9.3237F, -21.7116F, 0.0F, 11.0F, 31.0F, 0.0F, false);
			legLeft = new ModelRenderer(this);
			legLeft.setRotationPoint(10.5F, 8.25F, 14.25F);
			legLeft.setTextureOffset(96, 36).addBox(-4.5F, -2.25F, -1.25F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			legLeft2 = new ModelRenderer(this);
			legLeft2.setRotationPoint(-1.5F, 4.2576F, -14.401F);
			legLeft.addChild(legLeft2);
			setRotationAngle(legLeft2, -1.0036F, 0.0F, 0.0F);
			legLeft2.setTextureOffset(96, 18).addBox(-2.0F, -17.6884F, 0.5309F, 6.0F, 12.0F, 6.0F, 0.0F, false);
			legLeft3 = new ModelRenderer(this);
			legLeft3.setRotationPoint(1.0F, 11.4924F, -0.849F);
			legLeft2.addChild(legLeft3);
			setRotationAngle(legLeft3, 1.0036F, 0.0F, 0.0F);
			legLeft3.setTextureOffset(90, 67).addBox(-3.0F, -6.0F, 13.0F, 6.0F, 12.0F, 6.0F, 0.0F, false);
			legLeft4 = new ModelRenderer(this);
			legLeft4.setRotationPoint(-7.5F, 7.25F, 15.25F);
			legLeft4.setTextureOffset(90, 85).addBox(-2.5F, -1.25F, -2.25F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			legLeft5 = new ModelRenderer(this);
			legLeft5.setRotationPoint(0.5F, 5.2576F, -15.401F);
			legLeft4.addChild(legLeft5);
			setRotationAngle(legLeft5, -1.0036F, 0.0F, 0.0F);
			legLeft5.setTextureOffset(88, 0).addBox(-4.0F, -17.6884F, 0.5309F, 6.0F, 12.0F, 6.0F, 0.0F, false);
			legLeft6 = new ModelRenderer(this);
			legLeft6.setRotationPoint(-1.0F, 11.4924F, -0.849F);
			legLeft5.addChild(legLeft6);
			setRotationAngle(legLeft6, 1.0036F, 0.0F, 0.0F);
			legLeft6.setTextureOffset(87, 49).addBox(-3.0F, -6.0F, 13.0F, 6.0F, 12.0F, 6.0F, 0.0F, false);
			legLeft7 = new ModelRenderer(this);
			legLeft7.setRotationPoint(-7.5F, -4.75F, 3.25F);
			legLeft7.setTextureOffset(63, 67).addBox(-2.5F, -1.25F, -2.25F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			legLeft8 = new ModelRenderer(this);
			legLeft8.setRotationPoint(0.5F, 5.2576F, -14.401F);
			legLeft7.addChild(legLeft8);
			setRotationAngle(legLeft8, -1.0036F, 0.0F, 0.0F);
			legLeft8.setTextureOffset(63, 49).addBox(-4.0F, -16.0016F, -0.5437F, 6.0F, 12.0F, 6.0F, 0.0F, false);
			legLeft9 = new ModelRenderer(this);
			legLeft9.setRotationPoint(-1.0F, 11.4924F, -0.849F);
			legLeft8.addChild(legLeft9);
			setRotationAngle(legLeft9, 1.0036F, 0.0F, 0.0F);
			legLeft9.setTextureOffset(64, 0).addBox(-3.0F, -6.0F, 13.0F, 6.0F, 24.0F, 6.0F, 0.0F, false);
			legLeft10 = new ModelRenderer(this);
			legLeft10.setRotationPoint(10.5F, -6.25F, 1.25F);
			legLeft10.setTextureOffset(0, 67).addBox(-4.5F, 0.25F, -0.25F, 6.0F, 3.0F, 3.0F, 0.0F, false);
			legLeft11 = new ModelRenderer(this);
			legLeft11.setRotationPoint(-1.5F, 6.7576F, -12.401F);
			legLeft10.addChild(legLeft11);
			setRotationAngle(legLeft11, -1.0036F, 0.0F, 0.0F);
			legLeft11.setTextureOffset(0, 49).addBox(-2.0F, -16.0016F, -0.5437F, 6.0F, 12.0F, 6.0F, 0.0F, false);
			legLeft12 = new ModelRenderer(this);
			legLeft12.setRotationPoint(1.0F, 11.4924F, -0.849F);
			legLeft11.addChild(legLeft12);
			setRotationAngle(legLeft12, 1.0036F, 0.0F, 0.0F);
			legLeft12.setTextureOffset(0, 0).addBox(-3.0F, -6.0F, 13.0F, 6.0F, 24.0F, 6.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			legLeft.render(matrixStack, buffer, packedLight, packedOverlay);
			legLeft4.render(matrixStack, buffer, packedLight, packedOverlay);
			legLeft7.render(matrixStack, buffer, packedLight, packedOverlay);
			legLeft10.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.legLeft4.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.legLeft10.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.legLeft7.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.legLeft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
