
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
public class RazorbirdEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public RazorbirdEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 88);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("razorbird")
						.setRegistryName("razorbird");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -65281, -10027213, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("razorbird_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("nebulithic_ascension_rewritten:purple_mebris_forest")))
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
			return new MobRenderer(renderManager, new ModelNewRazorbird(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/newrazorbird.png");
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
	public static class ModelNewRazorbird extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer bone2;
		private final ModelRenderer bone3;
		private final ModelRenderer bone4;
		private final ModelRenderer bone5;
		private final ModelRenderer bone6;
		private final ModelRenderer bone7;
		private final ModelRenderer bone21;
		private final ModelRenderer bone24;
		private final ModelRenderer bone8;
		private final ModelRenderer bone22;
		private final ModelRenderer bone23;
		private final ModelRenderer bone9;
		private final ModelRenderer bone10;
		private final ModelRenderer bone11;
		private final ModelRenderer bone12;
		private final ModelRenderer bone13;
		private final ModelRenderer bone14;
		private final ModelRenderer bone15;
		private final ModelRenderer bone16;
		private final ModelRenderer bone17;
		private final ModelRenderer bone18;
		private final ModelRenderer bone19;
		private final ModelRenderer bone20;
		public ModelNewRazorbird() {
			textureWidth = 256;
			textureHeight = 256;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone.setTextureOffset(0, 36).addBox(-9.0F, -43.0F, -19.0F, 16.0F, 13.0F, 30.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(0.0F, 0.0F, 30.0F);
			bone.addChild(bone2);
			bone2.setTextureOffset(62, 38).addBox(-7.0F, -41.0F, -19.0F, 12.0F, 9.0F, 15.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(8.0F, -12.0F, -18.0F);
			bone3.setTextureOffset(62, 36).addBox(-1.0F, -3.0F, -1.0F, 49.0F, 1.0F, 1.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(-10.0F, 36.0F, 19.0F);
			bone3.addChild(bone4);
			bone4.setTextureOffset(0, 18).addBox(9.0F, -38.0F, -19.0F, 44.0F, 1.0F, 17.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(-13.0F, -14.0F, -12.0F);
			bone5.setTextureOffset(62, 62).addBox(-47.0F, -1.0F, -7.0F, 51.0F, 1.0F, 1.0F, 0.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(-36.0F, 38.0F, 13.0F);
			bone5.addChild(bone6);
			bone6.setTextureOffset(0, 0).addBox(-7.0F, -38.0F, -19.0F, 47.0F, 1.0F, 17.0F, 0.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(-9.0F, -12.0F, 18.0F);
			setRotationAngle(bone7, 1.5708F, 0.0F, 0.0F);
			bone7.setTextureOffset(16, 123).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 19.0F, 4.0F, 0.0F, false);
			bone21 = new ModelRenderer(this);
			bone21.setRotationPoint(0.0F, 37.5397F, 1.4559F);
			bone7.addChild(bone21);
			setRotationAngle(bone21, -1.0472F, 0.0F, 0.0F);
			bone21.setTextureOffset(118, 86).addBox(-1.0F, -10.741F, -21.5159F, 4.0F, 19.0F, 4.0F, 0.0F, false);
			bone24 = new ModelRenderer(this);
			bone24.setRotationPoint(14.0F, 18.0F, 10.0F);
			bone7.addChild(bone24);
			setRotationAngle(bone24, -0.3491F, 0.0F, 0.0F);
			bone24.setTextureOffset(0, 36).addBox(-15.0F, 16.3513F, -31.0725F, 4.0F, 2.0F, 11.0F, 0.0F, false);
			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(5.0F, -10.0F, 18.0F);
			setRotationAngle(bone8, 1.5708F, 0.0F, 0.0F);
			bone8.setTextureOffset(0, 123).addBox(-2.0F, -3.8126F, -1.1548F, 4.0F, 19.0F, 4.0F, 0.0F, false);
			bone22 = new ModelRenderer(this);
			bone22.setRotationPoint(-1.0F, 35.7271F, 10.3012F);
			bone8.addChild(bone22);
			setRotationAngle(bone22, -0.7854F, 0.0F, 0.0F);
			bone22.setTextureOffset(108, 118).addBox(-1.0F, -9.2516F, -23.7959F, 4.0F, 19.0F, 4.0F, 0.0F, false);
			bone23 = new ModelRenderer(this);
			bone23.setRotationPoint(0.0F, 18.7271F, 2.3012F);
			bone8.addChild(bone23);
			setRotationAngle(bone23, -0.2618F, 0.0F, 0.0F);
			bone23.setTextureOffset(0, 49).addBox(-2.0F, 12.8946F, -20.8906F, 4.0F, 2.0F, 11.0F, 0.0F, false);
			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(4.0F, -16.0F, 25.0F);
			setRotationAngle(bone9, 0.0F, 0.3491F, 0.0F);
			bone9.setTextureOffset(0, 101).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 20.0F, 0.0F, false);
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(2.0F, -16.0F, 25.0F);
			setRotationAngle(bone10, 0.0F, 0.1745F, 0.0F);
			bone10.setTextureOffset(96, 64).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 20.0F, 0.0F, false);
			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(0.0F, -17.0F, 27.0F);
			setRotationAngle(bone11, 0.0F, 0.0873F, 0.0F);
			bone11.setTextureOffset(94, 96).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 20.0F, 0.0F, false);
			bone12 = new ModelRenderer(this);
			bone12.setRotationPoint(-2.0F, -17.0F, 27.0F);
			setRotationAngle(bone12, 0.0F, -0.0873F, 0.0F);
			bone12.setTextureOffset(70, 94).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 20.0F, 0.0F, false);
			bone13 = new ModelRenderer(this);
			bone13.setRotationPoint(-3.0F, -16.0F, 27.0F);
			setRotationAngle(bone13, 0.0F, -0.1745F, 0.0F);
			bone13.setTextureOffset(46, 79).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 20.0F, 0.0F, false);
			bone14 = new ModelRenderer(this);
			bone14.setRotationPoint(-6.0F, -17.0F, 28.0F);
			setRotationAngle(bone14, 0.0F, -0.3491F, 0.0F);
			bone14.setTextureOffset(72, 72).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 20.0F, 0.0F, false);
			bone15 = new ModelRenderer(this);
			bone15.setRotationPoint(-1.0F, -13.0F, -16.0F);
			bone15.setTextureOffset(0, 79).addBox(-6.0F, -4.0F, -14.0F, 12.0F, 11.0F, 11.0F, 0.0F, false);
			bone16 = new ModelRenderer(this);
			bone16.setRotationPoint(1.0F, 37.0F, 16.0F);
			bone15.addChild(bone16);
			bone16.setTextureOffset(101, 38).addBox(-4.0F, -36.0F, -43.0F, 6.0F, 2.0F, 13.0F, 0.0F, false);
			bone17 = new ModelRenderer(this);
			bone17.setRotationPoint(0.0F, 23.0F, -4.0F);
			bone15.addChild(bone17);
			setRotationAngle(bone17, 0.4363F, 0.0F, 0.0F);
			bone17.setTextureOffset(76, 118).addBox(-3.0F, -22.5397F, -11.4559F, 6.0F, 2.0F, 10.0F, 0.0F, false);
			bone18 = new ModelRenderer(this);
			bone18.setRotationPoint(1.0F, 37.0F, 16.0F);
			bone15.addChild(bone18);
			bone18.setTextureOffset(0, 0).addBox(-1.0F, -48.0F, -25.0F, 0.0F, 7.0F, 7.0F, 0.0F, false);
			bone19 = new ModelRenderer(this);
			bone19.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone19.setTextureOffset(117, 7).addBox(-13.0F, -46.0F, -19.0F, 5.0F, 15.0F, 11.0F, 0.0F, false);
			bone20 = new ModelRenderer(this);
			bone20.setRotationPoint(22.0F, 24.0F, 0.0F);
			bone20.setTextureOffset(44, 105).addBox(-15.0F, -46.0F, -19.0F, 5.0F, 15.0F, 11.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			bone3.render(matrixStack, buffer, packedLight, packedOverlay);
			bone5.render(matrixStack, buffer, packedLight, packedOverlay);
			bone7.render(matrixStack, buffer, packedLight, packedOverlay);
			bone8.render(matrixStack, buffer, packedLight, packedOverlay);
			bone9.render(matrixStack, buffer, packedLight, packedOverlay);
			bone10.render(matrixStack, buffer, packedLight, packedOverlay);
			bone11.render(matrixStack, buffer, packedLight, packedOverlay);
			bone12.render(matrixStack, buffer, packedLight, packedOverlay);
			bone13.render(matrixStack, buffer, packedLight, packedOverlay);
			bone14.render(matrixStack, buffer, packedLight, packedOverlay);
			bone15.render(matrixStack, buffer, packedLight, packedOverlay);
			bone19.render(matrixStack, buffer, packedLight, packedOverlay);
			bone20.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.bone4.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.bone7.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.bone8.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.bone3.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
