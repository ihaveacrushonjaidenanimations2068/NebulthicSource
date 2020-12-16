
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import java.util.Map;
import java.util.HashMap;

import com.varahunter.nebulithic.procedures.CactrapEntityDiesProcedure;
import com.varahunter.nebulithic.item.CactrapBarbItem;
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
		elements.items.add(
				() -> new SpawnEggItem(entity, -13369549, -256, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("cactrap_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelCactrap(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/cactrap.png");
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
			experienceValue = 5;
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
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, TargetDummyEntity.CustomEntity.class, false, false));
			this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(4, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(5, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(7, new SwimGoal(this));
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
				CactrapEntityDiesProcedure.executeProcedure($_dependencies);
			}
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

		public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
			CactrapBarbItem.shoot(this, target);
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
			bone.setTextureOffset(34, 0).addBox(-5.0F, -25.0F, -5.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);
			frontRightLeg = new ModelRenderer(this);
			frontRightLeg.setRotationPoint(-5.0F, 14.0F, -4.0F);
			frontRightLeg.setTextureOffset(90, 96).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
			frontLeftLeg = new ModelRenderer(this);
			frontLeftLeg.setRotationPoint(5.0F, 14.0F, -5.0F);
			frontLeftLeg.setTextureOffset(82, 96).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
			backLeftLeg = new ModelRenderer(this);
			backLeftLeg.setRotationPoint(5.0F, 14.0F, 4.0F);
			backLeftLeg.setTextureOffset(8, 95).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
			backLeftLeg2 = new ModelRenderer(this);
			backLeftLeg2.setRotationPoint(-5.0F, 14.0F, 5.0F);
			backLeftLeg2.setTextureOffset(0, 95).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
			branch1 = new ModelRenderer(this);
			branch1.setRotationPoint(0.0F, 24.0F, 0.0F);
			branch1.setTextureOffset(78, 20).addBox(5.0F, -15.0F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
			branch1.setTextureOffset(30, 91).addBox(15.0F, -30.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
			branch1.setTextureOffset(34, 66).addBox(8.0F, -31.0F, -0.2F, 17.0F, 15.0F, 0.0F, 0.0F, false);
			branch1.setTextureOffset(34, 34).addBox(16.0F, -31.0F, -9.2F, 0.0F, 15.0F, 17.0F, 0.0F, false);
			branch2 = new ModelRenderer(this);
			branch2.setRotationPoint(-23.0F, 24.0F, 0.0F);
			branch2.setTextureOffset(68, 62).addBox(6.0F, -15.0F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
			branch2.setTextureOffset(22, 91).addBox(6.0F, -30.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
			branch2.setTextureOffset(34, 34).addBox(0.0F, -31.0F, -0.8F, 17.0F, 15.0F, 0.0F, 0.0F, false);
			branch2.setTextureOffset(0, 15).addBox(7.2F, -31.0F, -9.0F, 0.0F, 15.0F, 17.0F, 0.0F, false);
			branch3 = new ModelRenderer(this);
			branch3.setRotationPoint(-23.0F, 24.0F, -10.0F);
			branch3.setTextureOffset(62, 14).addBox(22.0F, -15.0F, -7.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
			branch3.setTextureOffset(74, 89).addBox(22.0F, -30.0F, -7.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
			branch3.setTextureOffset(0, 62).addBox(13.8F, -31.0F, -6.0F, 17.0F, 15.0F, 0.0F, 0.0F, false);
			branch3.setTextureOffset(0, 30).addBox(22.8F, -31.0F, -15.0F, 0.0F, 15.0F, 17.0F, 0.0F, false);
			branch4 = new ModelRenderer(this);
			branch4.setRotationPoint(-23.0F, 24.0F, 12.0F);
			branch4.setTextureOffset(56, 37).addBox(22.0F, -15.0F, -7.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
			branch4.setTextureOffset(66, 89).addBox(22.0F, -30.0F, 3.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
			branch4.setTextureOffset(0, 0).addBox(22.8F, -31.0F, -3.0F, 0.0F, 15.0F, 17.0F, 0.0F, false);
			branch4.setTextureOffset(0, 0).addBox(14.0F, -31.0F, 4.2F, 17.0F, 15.0F, 0.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone2.setTextureOffset(16, 94).addBox(-4.0F, -36.0F, -4.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
			bone2.setTextureOffset(44, 100).addBox(-4.5F, -36.0F, -4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
			bone2.setTextureOffset(90, 66).addBox(-5.3F, -40.0F, -5.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
			bone2.setTextureOffset(62, 28).addBox(-4.3F, -45.0F, -4.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(8.0F, 24.0F, 0.0F);
			bone3.setTextureOffset(42, 90).addBox(-4.0F, -36.0F, -4.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
			bone3.setTextureOffset(99, 57).addBox(-4.5F, -36.0F, -4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
			bone3.setTextureOffset(46, 81).addBox(-5.3F, -40.0F, -5.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
			bone3.setTextureOffset(58, 26).addBox(-4.3F, -45.0F, -4.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(8.0F, 24.0F, 8.0F);
			bone4.setTextureOffset(40, 90).addBox(-4.0F, -36.0F, -4.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
			bone4.setTextureOffset(98, 74).addBox(-4.5F, -36.0F, -4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
			bone4.setTextureOffset(13, 77).addBox(-5.3F, -40.0F, -5.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
			bone4.setTextureOffset(38, 0).addBox(-4.3F, -45.0F, -4.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(0.0F, 24.0F, 8.0F);
			bone5.setTextureOffset(38, 90).addBox(-4.0F, -36.0F, -4.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
			bone5.setTextureOffset(98, 98).addBox(-4.5F, -36.0F, -4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
			bone5.setTextureOffset(68, 28).addBox(-5.3F, -40.0F, -5.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
			bone5.setTextureOffset(34, 0).addBox(-4.3F, -45.0F, -4.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(0.0F, 8.75F, 0.0F);
			bone6.setTextureOffset(27, 76).addBox(0.0F, -20.75F, -0.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
			bone6.setTextureOffset(20, 95).addBox(-0.5F, -20.75F, 0.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(4.0F, 4.25F, -4.0F);
			bone6.addChild(bone7);
			bone7.setTextureOffset(25, 76).addBox(-4.0F, -36.0F, 3.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
			bone7.setTextureOffset(18, 95).addBox(-4.5F, -36.0F, 4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
			SmallHead = new ModelRenderer(this);
			SmallHead.setRotationPoint(0.0F, 24.0F, 0.0F);
			SmallHead.setTextureOffset(44, 89).addBox(-4.0F, -39.0F, 15.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);
			SmallHead.setTextureOffset(90, 49).addBox(-3.0F, -34.0F, 17.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);
			SmallHead.setTextureOffset(89, 41).addBox(-3.0F, -37.0F, 17.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);
			SmallHead2 = new ModelRenderer(this);
			SmallHead2.setRotationPoint(0.0F, 24.0F, 0.0F);
			SmallHead2.setTextureOffset(88, 26).addBox(-4.0F, -39.0F, -17.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);
			SmallHead2.setTextureOffset(88, 0).addBox(-3.0F, -34.0F, -22.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);
			SmallHead2.setTextureOffset(34, 26).addBox(-3.0F, -37.0F, -22.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);
			SmallHead3 = new ModelRenderer(this);
			SmallHead3.setRotationPoint(0.0F, 24.0F, 0.0F);
			SmallHead3.setTextureOffset(0, 77).addBox(-17.0F, -39.0F, -5.0F, 2.0F, 9.0F, 9.0F, 0.0F, false);
			SmallHead3.setTextureOffset(22, 81).addBox(-22.0F, -34.0F, -4.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);
			SmallHead3.setTextureOffset(61, 79).addBox(-22.0F, -37.0F, -4.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);
			SmallHead4 = new ModelRenderer(this);
			SmallHead4.setRotationPoint(0.0F, 24.0F, 0.0F);
			SmallHead4.setTextureOffset(72, 28).addBox(15.0F, -39.0F, -4.0F, 2.0F, 9.0F, 9.0F, 0.0F, false);
			SmallHead4.setTextureOffset(78, 10).addBox(17.0F, -34.0F, -3.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);
			SmallHead4.setTextureOffset(64, 0).addBox(17.0F, -37.0F, -3.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);
			SmallHead5 = new ModelRenderer(this);
			SmallHead5.setRotationPoint(0.0F, 7.0F, 15.0F);
			SmallHead5.setTextureOffset(85, 85).addBox(-4.0F, -39.0F, -17.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);
			SmallHead5.setTextureOffset(68, 51).addBox(-3.0F, -34.0F, -25.0F, 7.0F, 3.0F, 8.0F, 0.0F, false);
			SmallHead5.setTextureOffset(68, 68).addBox(-3.0F, -37.0F, -25.0F, 7.0F, 3.0F, 8.0F, 0.0F, false);
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

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.frontRightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.frontLeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.backLeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.backLeftLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
