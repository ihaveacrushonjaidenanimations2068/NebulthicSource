
package com.varahunter.nebulithic.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.block.BlockState;

import java.util.Map;
import java.util.HashMap;

import com.varahunter.nebulithic.procedures.SatelliteConstructBossEntityIsHurtProcedure;
import com.varahunter.nebulithic.item.PersonalRayGunWeaponModeItem;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class SatelliteConstructBossEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public SatelliteConstructBossEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 290);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f))
						.build("satellite_construct_boss").setRegistryName("satellite_construct_boss");
		elements.entities.add(() -> entity);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelNanosianSatellite(), 0.5f) {
				{
					this.addLayer(new GlowingLayer<>(this));
				}
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/nanosiansatellitehacked.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity implements IRangedAttackMob {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 12000;
			setNoAI(false);
			enablePersistence();
			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(6, new SwimGoal(this));
			this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10) {
				@Override
				public boolean shouldContinueExecuting() {
					return this.shouldExecute();
				}
			});
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
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean onLivingFall(float l, float d) {
			return false;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			Entity sourceentity = source.getTrueSource();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SatelliteConstructBossEntityIsHurtProcedure.executeProcedure($_dependencies);
			}
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(400);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(100);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(40);
			if (this.getAttribute(SharedMonsterAttributes.FLYING_SPEED) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3);
		}

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			PersonalRayGunWeaponModeItem.shoot(this, target);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.NOTCHED_20);
		@Override
		public void addTrackingPlayer(ServerPlayerEntity player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(ServerPlayerEntity player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void updateAITasks() {
			super.updateAITasks();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn
					.getBuffer(RenderType.getEyes(new ResourceLocation("nebulithic_ascension_rewritten:textures/nanosiansatellitehacked.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelNanosianSatellite extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer bone2;
		private final ModelRenderer bone3;
		private final ModelRenderer bone4;
		private final ModelRenderer bone5;
		private final ModelRenderer bone6;
		private final ModelRenderer bone7;
		private final ModelRenderer bone8;
		private final ModelRenderer bone9;
		private final ModelRenderer bone11;
		private final ModelRenderer bone10;
		private final ModelRenderer bone12;
		public ModelNanosianSatellite() {
			textureWidth = 256;
			textureHeight = 256;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone.setTextureOffset(0, 0).addBox(-15.0F, -73.0F, -16.0F, 30.0F, 30.0F, 30.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(0.0F, 8.0F, -24.0F);
			bone2.setTextureOffset(81, 93).addBox(-16.0F, -58.0F, -7.0F, 32.0F, 32.0F, 15.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(0.0F, 8.0F, -24.0F);
			setRotationAngle(bone3, 0.0F, 0.0F, 0.7854F);
			bone3.setTextureOffset(0, 60).addBox(-45.6985F, -45.6985F, -8.0F, 32.0F, 32.0F, 16.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone4.setTextureOffset(112, 140).addBox(-1.0F, -43.0F, -3.0F, 4.0F, 15.0F, 4.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(0.25F, -36.5F, 0.0F);
			bone4.addChild(bone5);
			setRotationAngle(bone5, 0.1745F, 0.0F, 0.0F);
			bone5.setTextureOffset(74, 140).addBox(-3.25F, 8.576F, -9.1318F, 7.0F, 6.0F, 12.0F, 0.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(-0.25F, 36.5F, 0.0F);
			bone5.addChild(bone6);
			bone6.setTextureOffset(90, 0).addBox(-2.0F, -26.924F, -19.1318F, 5.0F, 4.0F, 10.0F, 0.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(-0.25F, 36.5F, 0.0F);
			bone5.addChild(bone7);
			bone7.setTextureOffset(0, 12).addBox(4.0F, -24.924F, -9.1318F, 5.0F, 0.0F, 12.0F, 0.0F, false);
			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(-12.25F, 36.5F, 0.0F);
			bone5.addChild(bone8);
			bone8.setTextureOffset(0, 0).addBox(4.0F, -24.924F, -9.1318F, 5.0F, 0.0F, 12.0F, 0.0F, false);
			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(16.5F, -31.0F, -0.5F);
			setRotationAngle(bone9, -0.4363F, 0.0F, 0.0F);
			bone9.setTextureOffset(80, 68).addBox(-1.5F, -5.5315F, -4.6131F, 36.0F, 4.0F, 4.0F, 0.0F, false);
			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(-16.5F, 55.0F, 0.5F);
			bone9.addChild(bone11);
			bone11.setTextureOffset(120, 0).addBox(15.0F, -85.5315F, -4.1131F, 35.0F, 52.0F, 2.0F, 0.0F, false);
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(-16.5F, -30.0F, -0.5F);
			setRotationAngle(bone10, -0.4363F, 0.0F, 0.0F);
			bone10.setTextureOffset(80, 60).addBox(-34.5F, -6.5315F, -4.6131F, 36.0F, 4.0F, 4.0F, 0.0F, false);
			bone12 = new ModelRenderer(this);
			bone12.setRotationPoint(-47.5F, 54.0F, 0.5F);
			bone10.addChild(bone12);
			bone12.setTextureOffset(0, 108).addBox(15.0F, -85.5315F, -4.1131F, 35.0F, 52.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			bone2.render(matrixStack, buffer, packedLight, packedOverlay);
			bone3.render(matrixStack, buffer, packedLight, packedOverlay);
			bone4.render(matrixStack, buffer, packedLight, packedOverlay);
			bone9.render(matrixStack, buffer, packedLight, packedOverlay);
			bone10.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
