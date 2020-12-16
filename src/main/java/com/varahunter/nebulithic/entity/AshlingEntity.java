
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
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
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import java.util.Random;

import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class AshlingEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public AshlingEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 52);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("ashling")
						.setRegistryName("ashling");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -10066330, -52429, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("ashling_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("nebulithic_ascension_rewritten:acrid_wastes")))
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
			return new MobRenderer(renderManager, new ModelSmallAshDragonGround(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/smallashdragonground.png");
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
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.8, 20) {
				@Override
				protected Vec3d getPosition() {
					Random random = CustomEntity.this.getRNG();
					double dir_x = CustomEntity.this.getPosX() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = CustomEntity.this.getPosY() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = CustomEntity.this.getPosZ() + ((random.nextFloat() * 2 - 1) * 16);
					return new Vec3d(dir_x, dir_y, dir_z);
				}
			});
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

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.phantom.death"));
		}

		@Override
		public boolean onLivingFall(float l, float d) {
			return false;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
			if (this.getAttribute(SharedMonsterAttributes.FLYING_SPEED) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3);
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

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelSmallAshDragonGround extends EntityModel<Entity> {
		private final ModelRenderer legRight;
		private final ModelRenderer bone3;
		private final ModelRenderer bone5;
		private final ModelRenderer LegLeft;
		private final ModelRenderer bone4;
		private final ModelRenderer bone6;
		private final ModelRenderer bone7;
		private final ModelRenderer wingLeft;
		private final ModelRenderer bone10;
		private final ModelRenderer bone14;
		private final ModelRenderer wingRight;
		private final ModelRenderer bone11;
		private final ModelRenderer bone13;
		private final ModelRenderer head;
		private final ModelRenderer bone15;
		private final ModelRenderer bone24;
		private final ModelRenderer bone16;
		private final ModelRenderer bone17;
		private final ModelRenderer bone18;
		private final ModelRenderer taill;
		private final ModelRenderer bone20;
		private final ModelRenderer bone21;
		private final ModelRenderer bone22;
		private final ModelRenderer Spine;
		public ModelSmallAshDragonGround() {
			textureWidth = 128;
			textureHeight = 128;
			legRight = new ModelRenderer(this);
			legRight.setRotationPoint(-4.0F, -4.0F, 1.0F);
			legRight.setTextureOffset(24, 71).addBox(-2.0F, 27.0F, -6.0F, 4.0F, 1.0F, 8.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(0.0F, 27.0F, 0.0F);
			legRight.addChild(bone3);
			setRotationAngle(bone3, 0.3491F, 0.0F, 0.0F);
			bone3.setTextureOffset(32, 80).addBox(-1.0F, -15.316F, -0.1206F, 2.0F, 16.0F, 2.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(0.0F, 12.0F, -6.0F);
			legRight.addChild(bone5);
			setRotationAngle(bone5, -0.4363F, 0.0F, 0.0F);
			bone5.setTextureOffset(56, 73).addBox(-1.0F, -15.6858F, 0.8618F, 2.0F, 16.0F, 2.0F, 0.0F, false);
			LegLeft = new ModelRenderer(this);
			LegLeft.setRotationPoint(4.0F, -4.0F, 2.0F);
			LegLeft.setTextureOffset(61, 61).addBox(-2.0F, 27.0F, -7.0F, 4.0F, 1.0F, 8.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(0.0F, 27.0F, -2.0F);
			LegLeft.addChild(bone4);
			setRotationAngle(bone4, 0.3491F, 0.0F, 0.0F);
			bone4.setTextureOffset(24, 80).addBox(-1.0F, -14.9739F, 0.8191F, 2.0F, 16.0F, 2.0F, 0.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(0.0F, 12.0F, -7.0F);
			LegLeft.addChild(bone6);
			setRotationAngle(bone6, -0.4363F, 0.0F, 0.0F);
			bone6.setTextureOffset(48, 73).addBox(-1.0F, -15.6858F, 0.8618F, 2.0F, 16.0F, 2.0F, 0.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone7.setTextureOffset(0, 33).addBox(-5.0F, -48.0F, -3.0F, 10.0F, 19.0F, 9.0F, 0.0F, false);
			wingLeft = new ModelRenderer(this);
			wingLeft.setRotationPoint(6.0F, -22.0F, 0.0F);
			setRotationAngle(wingLeft, 0.0F, 0.0F, 0.7854F);
			wingLeft.setTextureOffset(38, 50).addBox(-2.0F, -1.0F, 0.0F, 24.0F, 2.0F, 2.0F, 0.0F, false);
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(-6.0F, 46.0F, 0.0F);
			wingLeft.addChild(bone10);
			bone10.setTextureOffset(31, 0).addBox(5.0F, -46.0F, 2.0F, 23.0F, 0.0F, 8.0F, 0.0F, false);
			bone14 = new ModelRenderer(this);
			bone14.setRotationPoint(0.0F, 0.0F, 1.0F);
			wingLeft.addChild(bone14);
			bone14.setTextureOffset(52, 20).addBox(21.9203F, -1.2929F, -1.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
			wingRight = new ModelRenderer(this);
			wingRight.setRotationPoint(-6.0F, -22.0F, 1.0F);
			setRotationAngle(wingRight, 0.0F, 0.0F, -0.7854F);
			wingRight.setTextureOffset(39, 8).addBox(-22.0F, -1.0F, -1.0F, 24.0F, 2.0F, 2.0F, 0.0F, false);
			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(-27.0F, 46.0F, -1.0F);
			wingRight.addChild(bone11);
			bone11.setTextureOffset(0, 25).addBox(5.0F, -46.0F, 2.0F, 23.0F, 0.0F, 8.0F, 0.0F, false);
			bone13 = new ModelRenderer(this);
			bone13.setRotationPoint(0.0F, 0.0F, 0.0F);
			wingRight.addChild(bone13);
			bone13.setTextureOffset(61, 54).addBox(-29.9203F, -1.2929F, -1.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -24.0F, 0.0F);
			head.setTextureOffset(0, 0).addBox(-7.0F, -12.0F, -8.0F, 13.0F, 12.0F, 13.0F, 0.0F, false);
			bone15 = new ModelRenderer(this);
			bone15.setRotationPoint(0.0F, -1.0F, -8.0F);
			head.addChild(bone15);
			setRotationAngle(bone15, 0.5236F, 0.0F, 0.0F);
			bone15.setTextureOffset(45, 24).addBox(-7.0F, -2.0F, -9.0F, 13.0F, 3.0F, 9.0F, 0.0F, false);
			bone24 = new ModelRenderer(this);
			bone24.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone15.addChild(bone24);
			bone24.setTextureOffset(52, 12).addBox(-6.0F, -4.0F, -7.0F, 11.0F, 2.0F, 6.0F, 0.0F, false);
			bone16 = new ModelRenderer(this);
			bone16.setRotationPoint(0.0F, -3.0F, 0.0F);
			head.addChild(bone16);
			bone16.setTextureOffset(38, 38).addBox(-7.0F, -3.0F, -17.0F, 13.0F, 3.0F, 9.0F, 0.0F, false);
			bone17 = new ModelRenderer(this);
			bone17.setRotationPoint(0.0F, -5.0F, 4.0F);
			head.addChild(bone17);
			setRotationAngle(bone17, -0.6109F, 0.0F, 0.0F);
			bone17.setTextureOffset(70, 70).addBox(6.0F, -14.0F, -9.0F, 1.0F, 14.0F, 6.0F, 0.0F, false);
			bone18 = new ModelRenderer(this);
			bone18.setRotationPoint(-14.0F, -12.0F, -4.0F);
			head.addChild(bone18);
			setRotationAngle(bone18, -0.6109F, 0.0F, 0.0F);
			bone18.setTextureOffset(10, 69).addBox(6.0F, -10.5425F, 0.7207F, 1.0F, 14.0F, 6.0F, 0.0F, false);
			taill = new ModelRenderer(this);
			taill.setRotationPoint(0.0F, -4.0F, 7.0F);
			setRotationAngle(taill, -0.5236F, 0.0F, 0.0F);
			taill.setTextureOffset(42, 56).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 15.0F, 0.0F, false);
			bone20 = new ModelRenderer(this);
			bone20.setRotationPoint(0.0F, 28.0F, -6.0F);
			taill.addChild(bone20);
			bone20.setTextureOffset(0, 50).addBox(0.0F, -34.0F, 5.0F, 0.0F, 4.0F, 15.0F, 0.0F, false);
			bone21 = new ModelRenderer(this);
			bone21.setRotationPoint(7.0F, -7.0F, 29.0F);
			taill.addChild(bone21);
			bone21.setTextureOffset(23, 54).addBox(-8.0F, 5.0F, -15.0F, 2.0F, 2.0F, 15.0F, 0.0F, false);
			bone22 = new ModelRenderer(this);
			bone22.setRotationPoint(-7.0F, 6.0F, -14.0F);
			bone21.addChild(bone22);
			bone22.setTextureOffset(0, 46).addBox(0.0F, -5.0F, -1.0F, 0.0F, 4.0F, 15.0F, 0.0F, false);
			Spine = new ModelRenderer(this);
			Spine.setRotationPoint(0.0F, 24.0F, 0.0F);
			Spine.setTextureOffset(0, 64).addBox(0.0F, -48.0F, 6.0F, 0.0F, 19.0F, 5.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			legRight.render(matrixStack, buffer, packedLight, packedOverlay);
			LegLeft.render(matrixStack, buffer, packedLight, packedOverlay);
			bone7.render(matrixStack, buffer, packedLight, packedOverlay);
			wingLeft.render(matrixStack, buffer, packedLight, packedOverlay);
			wingRight.render(matrixStack, buffer, packedLight, packedOverlay);
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			taill.render(matrixStack, buffer, packedLight, packedOverlay);
			Spine.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.wingRight.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.legRight.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.wingLeft.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.LegLeft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
