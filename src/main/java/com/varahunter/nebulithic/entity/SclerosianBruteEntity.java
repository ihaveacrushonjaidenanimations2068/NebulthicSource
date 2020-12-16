
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
public class SclerosianBruteEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public SclerosianBruteEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 124);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("sclerosian_brute")
						.setRegistryName("sclerosian_brute");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16724788, -65281, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("sclerosian_brute_spawn_egg"));
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
			return new MobRenderer(renderManager, new ModelNewSclerosianBrute(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/newsclerosianbrute.png");
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
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
					.getValue(new ResourceLocation("nebulithic_ascension_rewritten:entiy.brute.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
					.getValue(new ResourceLocation("nebulithic_ascension_rewritten:entity.brute.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
					.getValue(new ResourceLocation("nebulithic_ascension_rewritten:entity.brute.death"));
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
	public static class ModelNewSclerosianBrute extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer bone2;
		private final ModelRenderer bone5;
		private final ModelRenderer bone3;
		private final ModelRenderer bone4;
		private final ModelRenderer bone6;
		private final ModelRenderer bone7;
		private final ModelRenderer bone8;
		private final ModelRenderer bone9;
		private final ModelRenderer bone10;
		private final ModelRenderer bone11;
		private final ModelRenderer bone15;
		private final ModelRenderer bone20;
		private final ModelRenderer bone21;
		private final ModelRenderer bone22;
		private final ModelRenderer bone23;
		private final ModelRenderer bone12;
		private final ModelRenderer bone13;
		private final ModelRenderer bone14;
		private final ModelRenderer bone16;
		private final ModelRenderer bone17;
		private final ModelRenderer bone18;
		private final ModelRenderer bone19;
		private final ModelRenderer bone24;
		private final ModelRenderer bone27;
		private final ModelRenderer bone25;
		private final ModelRenderer bone26;
		public ModelNewSclerosianBrute() {
			textureWidth = 256;
			textureHeight = 256;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(-9.0F, -6.0F, 5.0F);
			bone.setTextureOffset(148, 0).addBox(-2.0F, 26.0F, -11.0F, 8.0F, 3.0F, 13.0F, 1.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(7.0F, 29.0F, -5.0F);
			bone.addChild(bone2);
			bone2.setTextureOffset(153, 27).addBox(-9.0F, -4.0F, -1.0F, 8.0F, 1.0F, 8.0F, 1.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(2.0F, 0.0F, -1.0F);
			bone.addChild(bone5);
			bone5.setTextureOffset(116, 158).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 25.0F, 8.0F, 1.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(7.0F, -7.0F, 5.0F);
			bone3.setTextureOffset(139, 112).addBox(-4.0F, 27.0F, -11.0F, 8.0F, 3.0F, 13.0F, 1.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(5.0F, 30.0F, -5.0F);
			bone3.addChild(bone4);
			bone4.setTextureOffset(152, 42).addBox(-9.0F, -4.0F, -1.0F, 8.0F, 1.0F, 8.0F, 1.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(5.0F, 11.0F, -5.0F);
			bone3.addChild(bone6);
			bone6.setTextureOffset(84, 158).addBox(-9.0F, -10.0F, 0.0F, 8.0F, 25.0F, 8.0F, 1.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone7.setTextureOffset(88, 45).addBox(-12.0F, -40.0F, -4.0F, 25.0F, 9.0F, 14.0F, 0.0F, false);
			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone8.setTextureOffset(0, 59).addBox(-15.0F, -77.0F, -7.0F, 29.0F, 37.0F, 22.0F, 0.0F, false);
			bone8.setTextureOffset(0, 0).addBox(-15.0F, -77.0F, -7.0F, 29.0F, 37.0F, 22.0F, 1.0F, false);
			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(16.0F, -53.0F, 6.0F);
			bone9.setTextureOffset(0, 118).addBox(-2.0F, 0.0F, -6.0F, 20.0F, 4.0F, 11.0F, 0.0F, false);
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(-16.0F, 77.0F, -6.0F);
			bone9.addChild(bone10);
			bone10.setTextureOffset(0, 133).addBox(18.0F, -73.0F, 0.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);
			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(23.0F, -57.0F, 5.0F);
			bone10.addChild(bone11);
			setRotationAngle(bone11, -0.6109F, 0.0F, 0.0F);
			bone11.setTextureOffset(52, 124).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 25.0F, 10.0F, 0.0F, false);
			bone15 = new ModelRenderer(this);
			bone15.setRotationPoint(-23.0F, 56.0F, -5.0F);
			bone11.addChild(bone15);
			bone15.setTextureOffset(80, 0).addBox(19.0F, -32.0F, 1.0F, 8.0F, 4.0F, 8.0F, 0.0F, false);
			bone20 = new ModelRenderer(this);
			bone20.setRotationPoint(0.0F, 1.0F, 0.0F);
			bone15.addChild(bone20);
			bone20.setTextureOffset(8, 8).addBox(25.0F, -29.0F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			bone21 = new ModelRenderer(this);
			bone21.setRotationPoint(0.0F, 1.0F, -3.0F);
			bone15.addChild(bone21);
			bone21.setTextureOffset(0, 6).addBox(25.0F, -29.0F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			bone22 = new ModelRenderer(this);
			bone22.setRotationPoint(0.0F, 1.0F, -6.0F);
			bone15.addChild(bone22);
			bone22.setTextureOffset(0, 0).addBox(25.0F, -29.0F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			bone23 = new ModelRenderer(this);
			bone23.setRotationPoint(1.0F, 0.1808F, -0.5736F);
			bone15.addChild(bone23);
			bone23.setTextureOffset(64, 80).addBox(19.0F, -29.0F, -27.0F, 6.0F, 6.0F, 38.0F, 3.0F, false);
			bone12 = new ModelRenderer(this);
			bone12.setRotationPoint(-11.0F, -49.0F, 7.0F);
			bone12.setTextureOffset(102, 27).addBox(-24.0F, -4.0F, -7.0F, 20.0F, 4.0F, 11.0F, 0.0F, false);
			bone13 = new ModelRenderer(this);
			bone13.setRotationPoint(-38.0F, 73.0F, -7.0F);
			bone12.addChild(bone13);
			bone13.setTextureOffset(132, 132).addBox(18.0F, -73.0F, 0.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);
			bone14 = new ModelRenderer(this);
			bone14.setRotationPoint(22.0F, -58.0F, 7.0F);
			bone13.addChild(bone14);
			setRotationAngle(bone14, -0.5236F, 0.0F, 0.0F);
			bone14.setTextureOffset(92, 124).addBox(-4.0F, 1.0F, -7.0F, 10.0F, 24.0F, 10.0F, 0.0F, false);
			bone16 = new ModelRenderer(this);
			bone16.setRotationPoint(-22.0F, 57.0F, -7.0F);
			bone14.addChild(bone16);
			bone16.setTextureOffset(80, 68).addBox(19.0F, -32.0F, 1.0F, 8.0F, 4.0F, 8.0F, 0.0F, false);
			bone17 = new ModelRenderer(this);
			bone17.setRotationPoint(0.0F, 1.0F, 0.0F);
			bone16.addChild(bone17);
			bone17.setTextureOffset(8, 14).addBox(19.0F, -29.0F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			bone18 = new ModelRenderer(this);
			bone18.setRotationPoint(0.0F, 1.0F, -3.0F);
			bone16.addChild(bone18);
			bone18.setTextureOffset(0, 12).addBox(19.0F, -29.0F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			bone19 = new ModelRenderer(this);
			bone19.setRotationPoint(0.0F, 1.0F, -6.0F);
			bone16.addChild(bone19);
			bone19.setTextureOffset(8, 0).addBox(19.0F, -29.0F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			bone24 = new ModelRenderer(this);
			bone24.setRotationPoint(0.0F, -54.0F, 3.0F);
			bone24.setTextureOffset(114, 90).addBox(-8.0F, -9.0F, -8.0F, 15.0F, 6.0F, 16.0F, 0.0F, false);
			bone27 = new ModelRenderer(this);
			bone27.setRotationPoint(-2.0F, -10.0F, 8.0F);
			bone24.addChild(bone27);
			bone27.setTextureOffset(114, 68).addBox(-6.0F, 1.0F, -17.0F, 15.0F, 6.0F, 16.0F, 1.0F, false);
			bone25 = new ModelRenderer(this);
			bone25.setRotationPoint(0.0F, 62.0F, -3.0F);
			bone24.addChild(bone25);
			bone25.setTextureOffset(102, 0).addBox(-8.0F, -82.0F, -5.0F, 15.0F, 11.0F, 16.0F, 0.0F, false);
			bone26 = new ModelRenderer(this);
			bone26.setRotationPoint(0.0F, 68.0F, -3.0F);
			bone24.addChild(bone26);
			bone26.setTextureOffset(34, 153).addBox(-3.0F, -71.0F, 1.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			bone3.render(matrixStack, buffer, packedLight, packedOverlay);
			bone7.render(matrixStack, buffer, packedLight, packedOverlay);
			bone8.render(matrixStack, buffer, packedLight, packedOverlay);
			bone9.render(matrixStack, buffer, packedLight, packedOverlay);
			bone12.render(matrixStack, buffer, packedLight, packedOverlay);
			bone24.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.bone24.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.bone24.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.bone.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.bone9.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.bone12.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.bone3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
