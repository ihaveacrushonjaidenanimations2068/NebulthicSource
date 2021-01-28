
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
public class SymbiceliumEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public SymbiceliumEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 298);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("symbicelium")
						.setRegistryName("symbicelium");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -1, -65536, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("symbicelium_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelSymbicelium(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/symbicelium.png");
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
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelSymbicelium extends EntityModel<Entity> {
		private final ModelRenderer leftFrontLeg;
		private final ModelRenderer leftBackLeg;
		private final ModelRenderer rightBackLeg;
		private final ModelRenderer rightFrontLeg;
		private final ModelRenderer bone5;
		private final ModelRenderer bone6;
		private final ModelRenderer bone7;
		private final ModelRenderer bone8;
		private final ModelRenderer bone9;
		private final ModelRenderer bone10;
		private final ModelRenderer bone11;
		private final ModelRenderer bone12;
		private final ModelRenderer bone13;
		private final ModelRenderer bone14;
		public ModelSymbicelium() {
			textureWidth = 64;
			textureHeight = 64;
			leftFrontLeg = new ModelRenderer(this);
			leftFrontLeg.setRotationPoint(7.0F, 16.0F, -7.0F);
			leftFrontLeg.setTextureOffset(22, 47).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			leftBackLeg = new ModelRenderer(this);
			leftBackLeg.setRotationPoint(5.0F, 16.0F, 5.0F);
			leftBackLeg.setTextureOffset(0, 46).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			rightBackLeg = new ModelRenderer(this);
			rightBackLeg.setRotationPoint(-5.0F, 16.0F, 5.0F);
			rightBackLeg.setTextureOffset(14, 45).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			rightFrontLeg = new ModelRenderer(this);
			rightFrontLeg.setRotationPoint(-7.0F, 16.0F, -7.0F);
			rightFrontLeg.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone5.setTextureOffset(0, 0).addBox(-6.0F, -19.0F, -6.0F, 12.0F, 11.0F, 12.0F, 0.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(0.0F, -8.0F, -0.25F);
			bone5.addChild(bone6);
			bone6.setTextureOffset(0, 34).addBox(-2.0F, -4.0F, -2.75F, 4.0F, 8.0F, 4.0F, 0.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(0.0F, -7.0F, -10.75F);
			bone6.addChild(bone7);
			bone7.setTextureOffset(44, 44).addBox(-2.0F, 8.0F, 4.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(0.0F, -7.0F, -14.75F);
			bone6.addChild(bone8);
			bone8.setTextureOffset(28, 42).addBox(-2.0F, 8.0F, 4.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(0.0F, -7.0F, -18.75F);
			bone6.addChild(bone9);
			bone9.setTextureOffset(40, 23).addBox(-2.0F, 8.0F, 4.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(0.0F, -3.0F, 0.0F);
			bone9.addChild(bone10);
			bone10.setTextureOffset(16, 38).addBox(-2.0F, 8.0F, 4.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(0.0F, -3.0F, 0.0F);
			bone10.addChild(bone11);
			bone11.setTextureOffset(36, 0).addBox(-2.0F, 8.0F, 4.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			bone12 = new ModelRenderer(this);
			bone12.setRotationPoint(0.0F, -3.0F, 0.0F);
			bone11.addChild(bone12);
			bone12.setTextureOffset(24, 23).addBox(-2.0F, 8.0F, 4.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			bone13 = new ModelRenderer(this);
			bone13.setRotationPoint(0.0F, 0.0F, -4.0F);
			bone12.addChild(bone13);
			bone13.setTextureOffset(28, 30).addBox(-4.0F, 5.0F, 4.0F, 8.0F, 8.0F, 4.0F, 0.0F, false);
			bone14 = new ModelRenderer(this);
			bone14.setRotationPoint(0.0F, -11.0F, 0.0F);
			bone5.addChild(bone14);
			bone14.setTextureOffset(0, 23).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 3.0F, 8.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			leftFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			leftBackLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			rightBackLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			rightFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			bone5.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.leftBackLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.bone6.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.bone6.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leftFrontLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rightFrontLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightBackLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
