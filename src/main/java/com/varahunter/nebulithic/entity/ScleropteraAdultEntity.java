
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
public class ScleropteraAdultEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public ScleropteraAdultEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 227);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("scleroptera_adult")
						.setRegistryName("scleroptera_adult");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16724737, -16724788, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("scleroptera_adult_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("nebulithic_ascension_rewritten:sclerotic_clearing")))
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
			return new MobRenderer(renderManager, new ModelAdultScleroptera(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/adultscleroptera.png");
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
	public static class ModelAdultScleroptera extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer frontLeftLeg;
		private final ModelRenderer bone3;
		private final ModelRenderer bone7;
		private final ModelRenderer bone6;
		private final ModelRenderer bone16;
		private final ModelRenderer backRightLeg;
		private final ModelRenderer bone9;
		private final ModelRenderer bone15;
		private final ModelRenderer frontRightLeg;
		private final ModelRenderer bone5;
		private final ModelRenderer bone10;
		private final ModelRenderer bone11;
		private final ModelRenderer bone17;
		private final ModelRenderer backLeftLeg;
		private final ModelRenderer bone13;
		private final ModelRenderer bone14;
		private final ModelRenderer head;
		private final ModelRenderer bone19;
		private final ModelRenderer bone20;
		private final ModelRenderer bone21;
		private final ModelRenderer bone23;
		private final ModelRenderer bone24;
		private final ModelRenderer TAil;
		public ModelAdultScleroptera() {
			textureWidth = 128;
			textureHeight = 128;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(-1.0F, 11.0F, 7.5F);
			bone.setTextureOffset(0, 0).addBox(-5.0F, -9.0F, -17.5F, 10.0F, 10.0F, 19.0F, 0.0F, false);
			frontLeftLeg = new ModelRenderer(this);
			frontLeftLeg.setRotationPoint(5.25F, 10.5F, -8.0F);
			frontLeftLeg.setTextureOffset(64, 70).addBox(-1.25F, -0.5F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(-0.25F, 9.5F, 0.0F);
			frontLeftLeg.addChild(bone3);
			setRotationAngle(bone3, -0.7854F, 0.0F, 0.0F);
			bone3.setTextureOffset(56, 68).addBox(-1.0F, -2.1803F, -2.7714F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(-5.0F, 3.0F, 8.0F);
			bone3.addChild(bone7);
			bone7.setTextureOffset(26, 41).addBox(7.0F, -31.1803F, -17.0141F, 0.0F, 31.0F, 11.0F, 0.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(-5.25F, 12.5F, 8.0F);
			frontLeftLeg.addChild(bone6);
			bone6.setTextureOffset(0, 23).addBox(5.0F, -12.0F, -7.0F, 0.0F, 7.0F, 6.0F, 0.0F, false);
			bone16 = new ModelRenderer(this);
			bone16.setRotationPoint(-0.25F, 2.5F, -8.5F);
			frontLeftLeg.addChild(bone16);
			bone16.setTextureOffset(48, 48).addBox(-3.0F, 9.0F, -4.0F, 6.0F, 1.0F, 10.0F, 0.0F, false);
			backRightLeg = new ModelRenderer(this);
			backRightLeg.setRotationPoint(-6.0F, 11.6667F, 5.3333F);
			backRightLeg.setTextureOffset(48, 67).addBox(-1.0F, -1.6667F, 0.6667F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(0.0F, 2.3333F, 1.6667F);
			backRightLeg.addChild(bone9);
			setRotationAngle(bone9, 0.7854F, 0.0F, 0.0F);
			bone9.setTextureOffset(66, 0).addBox(-1.0F, 2.1213F, -3.5355F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			bone15 = new ModelRenderer(this);
			bone15.setRotationPoint(0.0F, 2.3333F, 2.1667F);
			backRightLeg.addChild(bone15);
			bone15.setTextureOffset(48, 19).addBox(-3.0F, 9.0F, -4.0F, 6.0F, 1.0F, 10.0F, 0.0F, false);
			frontRightLeg = new ModelRenderer(this);
			frontRightLeg.setRotationPoint(-6.75F, 11.5F, -9.0F);
			frontRightLeg.setTextureOffset(52, 30).addBox(-1.25F, -1.5F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(-0.25F, 8.5F, 1.0F);
			frontRightLeg.addChild(bone5);
			setRotationAngle(bone5, -0.7854F, 0.0F, 0.0F);
			bone5.setTextureOffset(39, 0).addBox(-1.0F, -2.1803F, -2.7714F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(-5.0F, 3.0F, 8.0F);
			bone5.addChild(bone10);
			bone10.setTextureOffset(0, 39).addBox(3.8F, -31.8874F, -16.4785F, 0.0F, 31.0F, 13.0F, 0.0F, false);
			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(-5.25F, 11.5F, 9.0F);
			frontRightLeg.addChild(bone11);
			bone11.setTextureOffset(0, 0).addBox(5.0F, -12.0F, -7.0F, 0.0F, 7.0F, 7.0F, 0.0F, false);
			bone17 = new ModelRenderer(this);
			bone17.setRotationPoint(-0.25F, 1.5F, -7.5F);
			frontRightLeg.addChild(bone17);
			bone17.setTextureOffset(30, 30).addBox(-3.0F, 9.0F, -4.0F, 6.0F, 1.0F, 10.0F, 0.0F, false);
			backLeftLeg = new ModelRenderer(this);
			backLeftLeg.setRotationPoint(5.0F, 11.0F, 6.5F);
			backLeftLeg.setTextureOffset(0, 36).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			bone13 = new ModelRenderer(this);
			bone13.setRotationPoint(0.0F, 3.0F, 0.5F);
			backLeftLeg.addChild(bone13);
			setRotationAngle(bone13, 0.7854F, 0.0F, 0.0F);
			bone13.setTextureOffset(30, 30).addBox(-1.0F, 2.1213F, -3.5355F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			bone14 = new ModelRenderer(this);
			bone14.setRotationPoint(0.0F, 3.0F, 1.0F);
			backLeftLeg.addChild(bone14);
			bone14.setTextureOffset(52, 31).addBox(-3.0F, 9.0F, -4.0F, 6.0F, 1.0F, 10.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(-0.1667F, 4.1667F, -10.4167F);
			head.setTextureOffset(39, 0).addBox(-4.8333F, -1.1667F, -9.5833F, 8.0F, 8.0F, 11.0F, 0.0F, false);
			bone19 = new ModelRenderer(this);
			bone19.setRotationPoint(0.1667F, 19.8333F, 10.4167F);
			head.addChild(bone19);
			bone19.setTextureOffset(48, 42).addBox(3.0F, -28.0F, -14.0F, 1.0F, 8.0F, 4.0F, 0.0F, false);
			bone20 = new ModelRenderer(this);
			bone20.setRotationPoint(-8.8333F, 19.8333F, 10.4167F);
			head.addChild(bone20);
			bone20.setTextureOffset(8, 32).addBox(3.0F, -28.0F, -14.0F, 1.0F, 8.0F, 4.0F, 0.0F, false);
			bone21 = new ModelRenderer(this);
			bone21.setRotationPoint(-0.8333F, 5.3333F, -9.3333F);
			head.addChild(bone21);
			bone21.setTextureOffset(63, 63).addBox(-2.5F, -1.0F, -4.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
			bone23 = new ModelRenderer(this);
			bone23.setRotationPoint(-0.3333F, 8.3333F, 3.1667F);
			head.addChild(bone23);
			bone23.setTextureOffset(48, 59).addBox(-3.0F, -7.0F, -17.0F, 5.0F, 3.0F, 5.0F, 0.0F, false);
			bone24 = new ModelRenderer(this);
			bone24.setRotationPoint(-0.3333F, 11.3333F, 3.1667F);
			head.addChild(bone24);
			bone24.setTextureOffset(0, 0).addBox(-3.0F, -8.0F, -17.0F, 5.0F, 1.0F, 4.0F, 0.0F, false);
			TAil = new ModelRenderer(this);
			TAil.setRotationPoint(-1.0F, 7.0F, 10.0F);
			TAil.setTextureOffset(0, 29).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 5.0F, 18.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			frontLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			backRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			frontRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			backLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			TAil.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.frontRightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.backRightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.frontLeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.backLeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
