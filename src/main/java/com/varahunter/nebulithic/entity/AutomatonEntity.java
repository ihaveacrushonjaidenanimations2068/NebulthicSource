
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

import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class AutomatonEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public AutomatonEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 233);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 2f)).build("automaton")
						.setRegistryName("automaton");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -10066330, -52429, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("automaton"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelAutomaton(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/automaton.png");
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
	public static class ModelAutomaton extends EntityModel<Entity> {
		private final ModelRenderer waist;
		private final ModelRenderer spine;
		private final ModelRenderer legLeft;
		private final ModelRenderer legRight4;
		private final ModelRenderer legRight;
		private final ModelRenderer legRight2;
		private final ModelRenderer powerCore;
		private final ModelRenderer chest1;
		private final ModelRenderer chest2;
		private final ModelRenderer hatch;
		private final ModelRenderer hatch2;
		private final ModelRenderer batteryPack;
		private final ModelRenderer headBase;
		private final ModelRenderer shoulderRight;
		private final ModelRenderer bone;
		private final ModelRenderer shoulderRight2;
		private final ModelRenderer bone2;
		public ModelAutomaton() {
			textureWidth = 128;
			textureHeight = 128;
			waist = new ModelRenderer(this);
			waist.setRotationPoint(0.0F, 24.0F, 0.0F);
			waist.setTextureOffset(0, 29).addBox(-9.0F, -37.0F, -4.0F, 18.0F, 6.0F, 9.0F, 0.0F, false);
			spine = new ModelRenderer(this);
			spine.setRotationPoint(0.0F, -38.0F, 4.0F);
			waist.addChild(spine);
			spine.setTextureOffset(58, 88).addBox(-2.0F, -13.0F, 0.0F, 4.0F, 14.0F, 1.0F, 0.0F, false);
			legLeft = new ModelRenderer(this);
			legLeft.setRotationPoint(-5.0F, -31.0F, 0.0F);
			waist.addChild(legLeft);
			legLeft.setTextureOffset(59, 66).addBox(-3.0F, 16.0F, -3.0F, 7.0F, 15.0F, 7.0F, 0.0F, false);
			legRight4 = new ModelRenderer(this);
			legRight4.setRotationPoint(-4.0F, 15.0F, 0.0F);
			legLeft.addChild(legRight4);
			legRight4.setTextureOffset(54, 0).addBox(1.0F, -15.0F, -3.0F, 7.0F, 16.0F, 7.0F, 0.0F, false);
			legRight = new ModelRenderer(this);
			legRight.setRotationPoint(5.0F, -32.0F, 0.0F);
			waist.addChild(legRight);
			legRight.setTextureOffset(0, 68).addBox(-4.0F, 17.0F, -3.0F, 7.0F, 15.0F, 7.0F, 0.0F, false);
			legRight2 = new ModelRenderer(this);
			legRight2.setRotationPoint(-5.0F, 16.0F, 0.0F);
			legRight.addChild(legRight2);
			legRight2.setTextureOffset(31, 66).addBox(1.0F, -15.0F, -3.0F, 7.0F, 16.0F, 7.0F, 0.0F, false);
			powerCore = new ModelRenderer(this);
			powerCore.setRotationPoint(0.0F, 24.0F, 0.0F);
			powerCore.setTextureOffset(26, 44).addBox(-2.4F, -49.0F, -1.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			chest1 = new ModelRenderer(this);
			chest1.setRotationPoint(0.0F, 0.0F, 0.0F);
			powerCore.addChild(chest1);
			chest1.setTextureOffset(0, 44).addBox(-9.0F, -51.0F, -7.0F, 7.0F, 12.0F, 12.0F, 0.0F, false);
			chest2 = new ModelRenderer(this);
			chest2.setRotationPoint(11.0F, 0.0F, 0.0F);
			powerCore.addChild(chest2);
			chest2.setTextureOffset(42, 42).addBox(-9.0F, -51.0F, -7.0F, 7.0F, 12.0F, 12.0F, 0.0F, false);
			hatch = new ModelRenderer(this);
			hatch.setRotationPoint(0.0F, 0.0F, 0.0F);
			powerCore.addChild(hatch);
			hatch.setTextureOffset(45, 23).addBox(-3.0F, -51.0F, -7.0F, 6.0F, 1.0F, 12.0F, 0.0F, false);
			hatch2 = new ModelRenderer(this);
			hatch2.setRotationPoint(0.0F, 0.0F, 0.0F);
			hatch.addChild(hatch2);
			hatch2.setTextureOffset(87, 64).addBox(-3.0F, -51.0F, -8.0F, 6.0F, 12.0F, 1.0F, 0.0F, false);
			batteryPack = new ModelRenderer(this);
			batteryPack.setRotationPoint(0.0F, 0.0F, 0.0F);
			powerCore.addChild(batteryPack);
			batteryPack.setTextureOffset(0, 0).addBox(-9.0F, -51.0F, 5.0F, 18.0F, 20.0F, 9.0F, 0.0F, false);
			headBase = new ModelRenderer(this);
			headBase.setRotationPoint(0.0F, -26.0F, -1.0F);
			headBase.setTextureOffset(68, 36).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			shoulderRight = new ModelRenderer(this);
			shoulderRight.setRotationPoint(9.0F, -25.0F, -1.0F);
			shoulderRight.setTextureOffset(80, 52).addBox(0.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(1.0F, -2.0F, 0.0F);
			shoulderRight.addChild(bone);
			bone.setTextureOffset(82, 0).addBox(0.0F, 5.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);
			shoulderRight2 = new ModelRenderer(this);
			shoulderRight2.setRotationPoint(-12.0F, -25.0F, 0.0F);
			shoulderRight2.setTextureOffset(69, 23).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(2.0F, -2.0F, -1.0F);
			shoulderRight2.addChild(bone2);
			bone2.setTextureOffset(83, 84).addBox(-4.0F, 5.0F, -2.0F, 4.0F, 13.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			waist.render(matrixStack, buffer, packedLight, packedOverlay);
			powerCore.render(matrixStack, buffer, packedLight, packedOverlay);
			headBase.render(matrixStack, buffer, packedLight, packedOverlay);
			shoulderRight.render(matrixStack, buffer, packedLight, packedOverlay);
			shoulderRight2.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.legRight.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.headBase.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.headBase.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.shoulderRight.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.shoulderRight2.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.legLeft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
