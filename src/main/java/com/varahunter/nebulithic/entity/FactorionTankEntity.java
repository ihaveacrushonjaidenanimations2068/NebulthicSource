
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

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import java.util.Map;
import java.util.HashMap;

import com.varahunter.nebulithic.procedures.FactorionTankEntityIsHurtProcedure;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class FactorionTankEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public FactorionTankEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 232);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 18f)).build("factorion_tank")
						.setRegistryName("factorion_tank");
		elements.entities.add(() -> entity);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelFactorionTank(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/factorion.newpng.png");
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
			enablePersistence();
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
				FactorionTankEntityIsHurtProcedure.executeProcedure($_dependencies);
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
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelFactorionTank extends EntityModel<Entity> {
		private final ModelRenderer RightLegBase;
		private final ModelRenderer tankTread;
		private final ModelRenderer bone5;
		private final ModelRenderer bone2;
		private final ModelRenderer bone3;
		private final ModelRenderer bone4;
		private final ModelRenderer bone6;
		private final ModelRenderer bone7;
		private final ModelRenderer bone8;
		private final ModelRenderer bone9;
		private final ModelRenderer tankTread3;
		private final ModelRenderer bone10;
		private final ModelRenderer bone24;
		private final ModelRenderer bone25;
		private final ModelRenderer bone26;
		private final ModelRenderer bone27;
		private final ModelRenderer bone28;
		private final ModelRenderer bone29;
		private final ModelRenderer bone30;
		private final ModelRenderer bone19;
		private final ModelRenderer bone22;
		private final ModelRenderer RightLegBase2;
		private final ModelRenderer tankTread2;
		private final ModelRenderer bone11;
		private final ModelRenderer bone12;
		private final ModelRenderer bone13;
		private final ModelRenderer bone14;
		private final ModelRenderer bone15;
		private final ModelRenderer bone16;
		private final ModelRenderer bone17;
		private final ModelRenderer bone18;
		private final ModelRenderer tankTread4;
		private final ModelRenderer bone31;
		private final ModelRenderer bone32;
		private final ModelRenderer bone33;
		private final ModelRenderer bone34;
		private final ModelRenderer bone35;
		private final ModelRenderer bone36;
		private final ModelRenderer bone37;
		private final ModelRenderer bone38;
		private final ModelRenderer bone20;
		private final ModelRenderer bone21;
		private final ModelRenderer bone23;
		private final ModelRenderer bone;
		private final ModelRenderer leftArm;
		private final ModelRenderer bone41;
		private final ModelRenderer bone48;
		private final ModelRenderer rightArm;
		private final ModelRenderer bone42;
		private final ModelRenderer bone49;
		private final ModelRenderer head;
		private final ModelRenderer bone44;
		private final ModelRenderer bone45;
		private final ModelRenderer bone46;
		private final ModelRenderer bone47;
		private final ModelRenderer bone39;
		public ModelFactorionTank() {
			textureWidth = 512;
			textureHeight = 512;
			RightLegBase = new ModelRenderer(this);
			RightLegBase.setRotationPoint(13.0F, -84.0F, 16.0F);
			setRotationAngle(RightLegBase, -1.5708F, 0.0F, 0.0F);
			RightLegBase.setTextureOffset(210, 384).addBox(-2.0F, -8.0F, 87.0F, 19.0F, 109.0F, 18.0F, 0.0F, false);
			tankTread = new ModelRenderer(this);
			tankTread.setRotationPoint(-13.0F, 106.0F, 4.0F);
			RightLegBase.addChild(tankTread);
			tankTread.setTextureOffset(331, 295).addBox(30.0F, -56.0F, 86.0F, 7.0F, 30.0F, 2.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
			tankTread.addChild(bone5);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(0.0F, -4.0F, 7.0F);
			tankTread.addChild(bone2);
			setRotationAngle(bone2, 0.4363F, 0.0F, 0.0F);
			bone2.setTextureOffset(266, 188).addBox(30.0F, 13.4481F, 80.8959F, 7.0F, 7.0F, 2.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
			tankTread.addChild(bone3);
			bone3.setTextureOffset(200, 245).addBox(30.0F, -21.0F, 89.0F, 7.0F, 2.0F, 10.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(0.0F, -4.0F, -6.0F);
			tankTread.addChild(bone4);
			setRotationAngle(bone4, -0.3491F, 0.0F, 0.0F);
			bone4.setTextureOffset(266, 179).addBox(30.0F, -57.0075F, 91.5374F, 7.0F, 7.0F, 2.0F, 0.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
			tankTread.addChild(bone6);
			bone6.setTextureOffset(322, 89).addBox(30.0F, -55.5778F, 99.3941F, 7.0F, 30.0F, 2.0F, 0.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(0.0F, 0.0F, -1.0F);
			tankTread.addChild(bone7);
			setRotationAngle(bone7, 0.2618F, 0.0F, 0.0F);
			bone7.setTextureOffset(262, 47).addBox(30.0F, -33.2166F, 111.0309F, 7.0F, 7.0F, 2.0F, 0.0F, false);
			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(0.0F, 0.0F, -1.0F);
			tankTread.addChild(bone8);
			bone8.setTextureOffset(86, 245).addBox(30.0F, -61.8217F, 88.6506F, 7.0F, 2.0F, 10.0F, 0.0F, false);
			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(0.0F, -8.0F, -36.0F);
			tankTread.addChild(bone9);
			setRotationAngle(bone9, -0.1745F, 0.0F, 0.0F);
			bone9.setTextureOffset(254, 37).addBox(30.0F, -74.471F, 111.9851F, 7.0F, 7.0F, 2.0F, 0.0F, false);
			tankTread3 = new ModelRenderer(this);
			tankTread3.setRotationPoint(-13.0F, 62.0F, 3.0F);
			RightLegBase.addChild(tankTread3);
			tankTread3.setTextureOffset(304, 0).addBox(30.0F, -56.0F, 86.0F, 7.0F, 30.0F, 2.0F, 0.0F, false);
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
			tankTread3.addChild(bone10);
			bone24 = new ModelRenderer(this);
			bone24.setRotationPoint(0.0F, -4.0F, 7.0F);
			tankTread3.addChild(bone24);
			setRotationAngle(bone24, 0.4363F, 0.0F, 0.0F);
			bone24.setTextureOffset(0, 242).addBox(30.0F, 13.4481F, 80.8959F, 7.0F, 7.0F, 2.0F, 0.0F, false);
			bone25 = new ModelRenderer(this);
			bone25.setRotationPoint(0.0F, 0.0F, 0.0F);
			tankTread3.addChild(bone25);
			bone25.setTextureOffset(86, 233).addBox(30.0F, -21.0F, 89.0F, 7.0F, 2.0F, 10.0F, 0.0F, false);
			bone26 = new ModelRenderer(this);
			bone26.setRotationPoint(0.0F, -4.0F, -6.0F);
			tankTread3.addChild(bone26);
			setRotationAngle(bone26, -0.3491F, 0.0F, 0.0F);
			bone26.setTextureOffset(110, 233).addBox(30.0F, -57.0075F, 91.5374F, 7.0F, 7.0F, 2.0F, 0.0F, false);
			bone27 = new ModelRenderer(this);
			bone27.setRotationPoint(0.0F, 0.0F, 0.0F);
			tankTread3.addChild(bone27);
			bone27.setTextureOffset(246, 295).addBox(30.0F, -55.5778F, 99.3941F, 7.0F, 30.0F, 2.0F, 0.0F, false);
			bone28 = new ModelRenderer(this);
			bone28.setRotationPoint(0.0F, 0.0F, -1.0F);
			tankTread3.addChild(bone28);
			setRotationAngle(bone28, 0.2618F, 0.0F, 0.0F);
			bone28.setTextureOffset(0, 233).addBox(30.0F, -33.2166F, 111.0309F, 7.0F, 7.0F, 2.0F, 0.0F, false);
			bone29 = new ModelRenderer(this);
			bone29.setRotationPoint(0.0F, 0.0F, -1.0F);
			tankTread3.addChild(bone29);
			bone29.setTextureOffset(230, 37).addBox(30.0F, -61.8217F, 88.6506F, 7.0F, 2.0F, 10.0F, 0.0F, false);
			bone30 = new ModelRenderer(this);
			bone30.setRotationPoint(0.0F, -8.0F, -36.0F);
			tankTread3.addChild(bone30);
			setRotationAngle(bone30, -0.1745F, 0.0F, 0.0F);
			bone30.setTextureOffset(220, 145).addBox(30.0F, -74.471F, 111.9851F, 7.0F, 7.0F, 2.0F, 0.0F, false);
			bone19 = new ModelRenderer(this);
			bone19.setRotationPoint(-13.0F, 106.0F, 2.0F);
			RightLegBase.addChild(bone19);
			bone19.setTextureOffset(266, 201).addBox(11.0F, -5.0F, 85.0F, 19.0F, 4.0F, 18.0F, 0.0F, false);
			bone22 = new ModelRenderer(this);
			bone22.setRotationPoint(27.0F, 99.0F, -2.0F);
			RightLegBase.addChild(bone22);
			setRotationAngle(bone22, 0.8727F, 0.0F, 0.0F);
			bone22.setTextureOffset(0, 19).addBox(-29.0F, 69.6384F, 50.1955F, 19.0F, 2.0F, 6.0F, 0.0F, false);
			RightLegBase2 = new ModelRenderer(this);
			RightLegBase2.setRotationPoint(-10.0F, -86.0F, 16.0F);
			setRotationAngle(RightLegBase2, -1.5708F, 0.0F, 0.0F);
			RightLegBase2.setTextureOffset(382, 179).addBox(-19.0F, -10.0F, 89.0F, 19.0F, 110.0F, 18.0F, 0.0F, false);
			tankTread2 = new ModelRenderer(this);
			tankTread2.setRotationPoint(-31.0F, 105.0F, 6.0F);
			RightLegBase2.addChild(tankTread2);
			tankTread2.setTextureOffset(313, 295).addBox(5.0F, -56.0F, 86.0F, 7.0F, 30.0F, 2.0F, 0.0F, false);
			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
			tankTread2.addChild(bone11);
			bone12 = new ModelRenderer(this);
			bone12.setRotationPoint(0.0F, -4.0F, 7.0F);
			tankTread2.addChild(bone12);
			setRotationAngle(bone12, 0.4363F, 0.0F, 0.0F);
			bone12.setTextureOffset(120, 251).addBox(5.0F, 13.4481F, 80.8959F, 7.0F, 7.0F, 2.0F, 0.0F, false);
			bone13 = new ModelRenderer(this);
			bone13.setRotationPoint(0.0F, 0.0F, 0.0F);
			tankTread2.addChild(bone13);
			bone13.setTextureOffset(224, 235).addBox(5.0F, -21.0F, 89.0F, 7.0F, 2.0F, 10.0F, 0.0F, false);
			bone14 = new ModelRenderer(this);
			bone14.setRotationPoint(0.0F, -4.0F, -6.0F);
			tankTread2.addChild(bone14);
			setRotationAngle(bone14, -0.3491F, 0.0F, 0.0F);
			bone14.setTextureOffset(0, 251).addBox(5.0F, -57.0075F, 91.5374F, 7.0F, 7.0F, 2.0F, 0.0F, false);
			bone15 = new ModelRenderer(this);
			bone15.setRotationPoint(0.0F, 0.0F, 0.0F);
			tankTread2.addChild(bone15);
			bone15.setTextureOffset(304, 89).addBox(5.0F, -55.5778F, 99.3941F, 7.0F, 30.0F, 2.0F, 0.0F, false);
			bone16 = new ModelRenderer(this);
			bone16.setRotationPoint(0.0F, 0.0F, -1.0F);
			tankTread2.addChild(bone16);
			setRotationAngle(bone16, 0.2618F, 0.0F, 0.0F);
			bone16.setTextureOffset(234, 247).addBox(5.0F, -34.1825F, 111.2898F, 7.0F, 7.0F, 2.0F, 0.0F, false);
			bone17 = new ModelRenderer(this);
			bone17.setRotationPoint(0.0F, 0.0F, -1.0F);
			tankTread2.addChild(bone17);
			bone17.setTextureOffset(200, 233).addBox(5.0F, -61.8217F, 88.6506F, 7.0F, 2.0F, 10.0F, 0.0F, false);
			bone18 = new ModelRenderer(this);
			bone18.setRotationPoint(0.0F, -8.0F, -36.0F);
			tankTread2.addChild(bone18);
			setRotationAngle(bone18, -0.1745F, 0.0F, 0.0F);
			bone18.setTextureOffset(120, 242).addBox(5.0F, -74.471F, 111.9851F, 7.0F, 7.0F, 2.0F, 0.0F, false);
			tankTread4 = new ModelRenderer(this);
			tankTread4.setRotationPoint(-31.0F, 56.0F, 5.0F);
			RightLegBase2.addChild(tankTread4);
			tankTread4.setTextureOffset(228, 295).addBox(5.0F, -56.0F, 86.0F, 7.0F, 30.0F, 2.0F, 0.0F, false);
			bone31 = new ModelRenderer(this);
			bone31.setRotationPoint(0.0F, 0.0F, 0.0F);
			tankTread4.addChild(bone31);
			bone32 = new ModelRenderer(this);
			bone32.setRotationPoint(0.0F, -4.0F, 7.0F);
			tankTread4.addChild(bone32);
			setRotationAngle(bone32, 0.4363F, 0.0F, 0.0F);
			bone32.setTextureOffset(220, 136).addBox(5.0F, 13.4481F, 80.8959F, 7.0F, 7.0F, 2.0F, 0.0F, false);
			bone33 = new ModelRenderer(this);
			bone33.setRotationPoint(0.0F, 0.0F, 0.0F);
			tankTread4.addChild(bone33);
			bone33.setTextureOffset(0, 169).addBox(5.0F, -21.0F, 89.0F, 7.0F, 2.0F, 10.0F, 0.0F, false);
			bone34 = new ModelRenderer(this);
			bone34.setRotationPoint(0.0F, -4.0F, -6.0F);
			tankTread4.addChild(bone34);
			setRotationAngle(bone34, -0.3491F, 0.0F, 0.0F);
			bone34.setTextureOffset(24, 169).addBox(5.0F, -57.0075F, 91.5374F, 7.0F, 7.0F, 2.0F, 0.0F, false);
			bone35 = new ModelRenderer(this);
			bone35.setRotationPoint(0.0F, 0.0F, 0.0F);
			tankTread4.addChild(bone35);
			bone35.setTextureOffset(286, 89).addBox(5.0F, -55.5778F, 99.3941F, 7.0F, 30.0F, 2.0F, 0.0F, false);
			bone36 = new ModelRenderer(this);
			bone36.setRotationPoint(0.0F, 0.0F, -1.0F);
			tankTread4.addChild(bone36);
			setRotationAngle(bone36, 0.2618F, 0.0F, 0.0F);
			bone36.setTextureOffset(11, 136).addBox(5.0F, -33.2166F, 111.0309F, 7.0F, 7.0F, 2.0F, 0.0F, false);
			bone37 = new ModelRenderer(this);
			bone37.setRotationPoint(0.0F, 0.0F, -1.0F);
			tankTread4.addChild(bone37);
			bone37.setTextureOffset(22, 44).addBox(5.0F, -61.8217F, 88.6506F, 7.0F, 2.0F, 10.0F, 0.0F, false);
			bone38 = new ModelRenderer(this);
			bone38.setRotationPoint(0.0F, -8.0F, -36.0F);
			tankTread4.addChild(bone38);
			setRotationAngle(bone38, -0.1745F, 0.0F, 0.0F);
			bone38.setTextureOffset(32, 35).addBox(5.0F, -74.471F, 111.9851F, 7.0F, 7.0F, 2.0F, 0.0F, false);
			bone20 = new ModelRenderer(this);
			bone20.setRotationPoint(50.0F, 105.0F, 4.0F);
			RightLegBase2.addChild(bone20);
			bone20.setTextureOffset(266, 179).addBox(-69.0F, -5.0F, 85.0F, 19.0F, 4.0F, 18.0F, 0.0F, false);
			bone21 = new ModelRenderer(this);
			bone21.setRotationPoint(10.0F, 98.0F, 0.0F);
			RightLegBase2.addChild(bone21);
			setRotationAngle(bone21, 0.8727F, 0.0F, 0.0F);
			bone21.setTextureOffset(0, 27).addBox(-29.0F, 68.7942F, 49.2523F, 19.0F, 2.0F, 6.0F, 0.0F, false);
			bone23 = new ModelRenderer(this);
			bone23.setRotationPoint(-31.0F, 33.0F, 0.0F);
			bone23.setTextureOffset(230, 0).addBox(21.0F, -30.0F, -8.0F, 21.0F, 21.0F, 16.0F, 0.0F, false);
			bone23.setTextureOffset(220, 136).addBox(-5.0F, -51.0F, -13.0F, 71.0F, 21.0F, 22.0F, 0.0F, false);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, -28.0F, 89.0F);
			setRotationAngle(bone, 1.5708F, 0.0F, 0.0F);
			bone.setTextureOffset(0, 136).addBox(-46.0F, -92.0F, -27.0F, 87.0F, 51.0F, 46.0F, 0.0F, false);
			bone.setTextureOffset(0, 0).addBox(-46.0F, -170.0F, -31.0F, 87.0F, 80.0F, 56.0F, 0.0F, false);
			leftArm = new ModelRenderer(this);
			leftArm.setRotationPoint(22.0F, -56.0F, 128.0F);
			setRotationAngle(leftArm, -1.5708F, 0.0F, -1.5708F);
			leftArm.setTextureOffset(228, 233).addBox(-8.0F, 78.0F, -13.0F, 47.0F, 32.0F, 30.0F, 0.0F, false);
			bone41 = new ModelRenderer(this);
			bone41.setRotationPoint(-165.0F, 247.0F, -3.0F);
			leftArm.addChild(bone41);
			bone41.setTextureOffset(114, 233).addBox(161.0F, -137.0F, -9.0F, 29.0F, 129.0F, 28.0F, 0.0F, false);
			bone48 = new ModelRenderer(this);
			bone48.setRotationPoint(-50.0F, 247.0F, -3.0F);
			leftArm.addChild(bone48);
			bone48.setTextureOffset(228, 295).addBox(75.0F, -88.0F, -14.0F, 23.0F, 50.0F, 39.0F, 0.0F, false);
			rightArm = new ModelRenderer(this);
			rightArm.setRotationPoint(-28.0F, -55.0F, 127.0F);
			setRotationAngle(rightArm, -1.5708F, 0.0F, 1.5708F);
			rightArm.setTextureOffset(352, 352).addBox(-36.0F, 79.0F, -10.0F, 45.0F, 32.0F, 30.0F, 0.0F, false);
			bone42 = new ModelRenderer(this);
			bone42.setRotationPoint(-183.0F, 248.0F, 0.0F);
			rightArm.addChild(bone42);
			bone42.setTextureOffset(0, 233).addBox(155.0F, -137.0F, -9.0F, 29.0F, 129.0F, 28.0F, 0.0F, false);
			bone49 = new ModelRenderer(this);
			bone49.setRotationPoint(-118.0F, 248.0F, 0.0F);
			rightArm.addChild(bone49);
			bone49.setTextureOffset(286, 0).addBox(70.0F, -88.0F, -14.0F, 23.0F, 50.0F, 39.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(-3.0F, -54.0F, 31.0F);
			setRotationAngle(head, 1.5708F, 0.0F, 0.0F);
			head.setTextureOffset(0, 390).addBox(-15.0F, -19.0F, -21.0F, 30.0F, 27.0F, 30.0F, 0.0F, false);
			bone44 = new ModelRenderer(this);
			bone44.setRotationPoint(15.0F, -107.0F, -3.0F);
			head.addChild(bone44);
			setRotationAngle(bone44, -0.6109F, 0.0F, 0.0F);
			bone44.setTextureOffset(20, 136).addBox(0.0F, 59.0003F, 48.9162F, 1.0F, 24.0F, 9.0F, 0.0F, false);
			bone45 = new ModelRenderer(this);
			bone45.setRotationPoint(-17.0F, -107.0F, -3.0F);
			head.addChild(bone45);
			setRotationAngle(bone45, -0.6109F, 0.0F, 0.0F);
			bone45.setTextureOffset(0, 136).addBox(0.0F, 59.0003F, 48.9162F, 1.0F, 24.0F, 9.0F, 0.0F, false);
			bone46 = new ModelRenderer(this);
			bone46.setRotationPoint(5.0F, 175.0F, -8.0F);
			head.addChild(bone46);
			bone46.setTextureOffset(0, 35).addBox(-9.0F, -178.0F, -14.0F, 9.0F, 12.0F, 7.0F, 0.0F, false);
			bone47 = new ModelRenderer(this);
			bone47.setRotationPoint(46.0F, 104.0F, -104.0F);
			bone47.setTextureOffset(0, 0).addBox(-26.0F, -174.0F, -7.0F, 13.0F, 11.0F, 8.0F, 0.0F, false);
			bone47.setTextureOffset(361, 40).addBox(-28.0F, -178.0F, -56.0F, 15.0F, 15.0F, 49.0F, 0.0F, false);
			bone39 = new ModelRenderer(this);
			bone39.setRotationPoint(-13.0F, 104.0F, -104.0F);
			bone39.setTextureOffset(0, 0).addBox(-26.0F, -174.0F, -7.0F, 13.0F, 11.0F, 8.0F, 0.0F, false);
			bone39.setTextureOffset(361, 40).addBox(-28.0F, -178.0F, -56.0F, 15.0F, 15.0F, 49.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			RightLegBase.render(matrixStack, buffer, packedLight, packedOverlay);
			RightLegBase2.render(matrixStack, buffer, packedLight, packedOverlay);
			bone23.render(matrixStack, buffer, packedLight, packedOverlay);
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
			rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			bone47.render(matrixStack, buffer, packedLight, packedOverlay);
			bone39.render(matrixStack, buffer, packedLight, packedOverlay);
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
