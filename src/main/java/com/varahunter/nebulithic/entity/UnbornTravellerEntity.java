
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

import java.util.Map;
import java.util.HashMap;

import com.varahunter.nebulithic.procedures.UnbornTravellerEntityIsHurtProcedure;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class UnbornTravellerEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public UnbornTravellerEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 242);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 2.1f)).build("unborn_traveller")
						.setRegistryName("unborn_traveller");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -6710887, -65281, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("unborn_traveller_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelUnbornTraveller(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/unborn_traveller.png");
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
					.getValue(new ResourceLocation("nebulithic_ascension_rewritten:entity.unborn.breath"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
					.getValue(new ResourceLocation("nebulithic_ascension_rewritten:entity.unborn.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
					.getValue(new ResourceLocation("nebulithic_ascension_rewritten:entity.unborn.death"));
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
				$_dependencies.put("sourceentity", sourceentity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				UnbornTravellerEntityIsHurtProcedure.executeProcedure($_dependencies);
			}
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(49);
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
	public static class ModelUnbornTraveller extends EntityModel<Entity> {
		private final ModelRenderer rightLeg;
		private final ModelRenderer bone;
		private final ModelRenderer bone4;
		private final ModelRenderer bone7;
		private final ModelRenderer bone5;
		private final ModelRenderer leftLeg;
		private final ModelRenderer bone3;
		private final ModelRenderer bone6;
		private final ModelRenderer bone9;
		private final ModelRenderer bone10;
		private final ModelRenderer bone11;
		private final ModelRenderer bone12;
		private final ModelRenderer bone13;
		private final ModelRenderer bone14;
		private final ModelRenderer Backpac;
		private final ModelRenderer leftArm;
		private final ModelRenderer bone16;
		private final ModelRenderer bone17;
		private final ModelRenderer bone21;
		private final ModelRenderer bone22;
		private final ModelRenderer bone23;
		private final ModelRenderer bone24;
		private final ModelRenderer RightArm;
		private final ModelRenderer bone19;
		private final ModelRenderer bone20;
		private final ModelRenderer bone29;
		private final ModelRenderer bone30;
		private final ModelRenderer bone31;
		private final ModelRenderer bone32;
		private final ModelRenderer Head;
		private final ModelRenderer Jaw;
		public ModelUnbornTraveller() {
			textureWidth = 128;
			textureHeight = 128;
			rightLeg = new ModelRenderer(this);
			rightLeg.setRotationPoint(-3.0F, 6.0F, -0.7F);
			setRotationAngle(rightLeg, 0.0F, 0.0873F, 0.0F);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(3.0F, 18.0F, 0.7F);
			rightLeg.addChild(bone);
			bone.setTextureOffset(31, 55).addBox(-5.0F, -1.0F, -5.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(3.0F, 18.0F, 0.7F);
			rightLeg.addChild(bone4);
			bone4.setTextureOffset(49, 52).addBox(-5.0F, -9.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(3.0F, 18.0F, 0.7F);
			rightLeg.addChild(bone7);
			bone7.setTextureOffset(50, 9).addBox(-5.0F, -18.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(3.0F, 18.0F, 0.7F);
			rightLeg.addChild(bone5);
			bone5.setTextureOffset(7, 9).addBox(-4.0F, -10.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			leftLeg = new ModelRenderer(this);
			leftLeg.setRotationPoint(4.0F, 7.0F, -0.7F);
			setRotationAngle(leftLeg, 0.0F, -0.0873F, 0.0F);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(-4.0F, 17.0F, 0.7F);
			leftLeg.addChild(bone3);
			bone3.setTextureOffset(52, 44).addBox(3.0F, -1.0F, -5.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(-4.0F, 17.0F, 0.7F);
			leftLeg.addChild(bone6);
			bone6.setTextureOffset(24, 47).addBox(3.0F, -9.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);
			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(-4.0F, 17.0F, 0.7F);
			leftLeg.addChild(bone9);
			bone9.setTextureOffset(12, 47).addBox(3.0F, -18.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(-4.0F, 17.0F, 0.7F);
			leftLeg.addChild(bone10);
			bone10.setTextureOffset(0, 9).addBox(4.0F, -10.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone11.setTextureOffset(28, 28).addBox(-3.0F, -20.0F, -3.0F, 7.0F, 4.0F, 5.0F, 0.0F, false);
			bone12 = new ModelRenderer(this);
			bone12.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone12.setTextureOffset(37, 20).addBox(-2.0F, -24.0F, -2.0F, 5.0F, 4.0F, 3.0F, 0.0F, false);
			bone13 = new ModelRenderer(this);
			bone13.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone13.setTextureOffset(0, 20).addBox(-3.0F, -33.0F, -5.0F, 7.0F, 9.0F, 7.0F, 0.0F, false);
			bone14 = new ModelRenderer(this);
			bone14.setRotationPoint(0.0F, -9.0F, -1.0F);
			setRotationAngle(bone14, 0.3491F, 0.0F, 0.0F);
			bone14.setTextureOffset(0, 0).addBox(-6.0F, -7.9739F, -8.1809F, 14.0F, 9.0F, 11.0F, 0.0F, false);
			Backpac = new ModelRenderer(this);
			Backpac.setRotationPoint(0.0F, 33.0F, 1.0F);
			bone14.addChild(Backpac);
			Backpac.setTextureOffset(76, 32).addBox(-6.0F, -42.5373F, 1.6238F, 14.0F, 17.0F, 5.0F, 0.0F, false);
			Backpac.setTextureOffset(114, 49).addBox(-6.0F, -36.4562F, -9.9281F, 0.0F, 1.0F, 12.0F, 0.0F, false);
			Backpac.setTextureOffset(114, 49).addBox(8.1F, -36.4562F, -9.9281F, 0.0F, 1.0F, 12.0F, 0.0F, true);
			leftArm = new ModelRenderer(this);
			leftArm.setRotationPoint(9.0F, -15.0F, -3.0F);
			leftArm.setTextureOffset(20, 37).addBox(-1.0F, -2.0F, -2.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			bone16 = new ModelRenderer(this);
			bone16.setRotationPoint(-9.0F, 39.0F, 3.0F);
			leftArm.addChild(bone16);
			bone16.setTextureOffset(52, 34).addBox(9.0F, -36.0F, -4.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);
			bone17 = new ModelRenderer(this);
			bone17.setRotationPoint(1.6F, 11.0F, 0.3F);
			leftArm.addChild(bone17);
			setRotationAngle(bone17, -0.6109F, 0.0F, 0.0F);
			bone17.setTextureOffset(0, 46).addBox(-1.6F, -1.7942F, -2.181F, 3.0F, 12.0F, 3.0F, 0.0F, false);
			bone21 = new ModelRenderer(this);
			bone21.setRotationPoint(1.4F, 18.0F, -6.0F);
			leftArm.addChild(bone21);
			setRotationAngle(bone21, -0.6109F, 0.0F, 0.0F);
			bone21.setTextureOffset(9, 58).addBox(0.4F, 0.8F, -1.1F, 1.0F, 3.0F, 3.0F, 0.0F, false);
			bone22 = new ModelRenderer(this);
			bone22.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone21.addChild(bone22);
			bone22.setTextureOffset(8, 3).addBox(1.5F, 3.8F, -1.1F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			bone23 = new ModelRenderer(this);
			bone23.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone21.addChild(bone23);
			bone23.setTextureOffset(8, 0).addBox(1.4F, 3.8F, 0.1F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			bone24 = new ModelRenderer(this);
			bone24.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone21.addChild(bone24);
			bone24.setTextureOffset(6, 6).addBox(1.4F, 3.8F, 1.2F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			RightArm = new ModelRenderer(this);
			RightArm.setRotationPoint(-6.9F, -14.0F, -2.6F);
			setRotationAngle(RightArm, 0.0873F, 0.0F, 0.0F);
			RightArm.setTextureOffset(0, 36).addBox(-4.0F, -3.0F, -2.4F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			bone19 = new ModelRenderer(this);
			bone19.setRotationPoint(7.0F, 38.0F, 2.6F);
			RightArm.addChild(bone19);
			bone19.setTextureOffset(52, 24).addBox(-10.0F, -36.0F, -4.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);
			bone20 = new ModelRenderer(this);
			bone20.setRotationPoint(-1.0F, 10.0F, 0.6F);
			RightArm.addChild(bone20);
			setRotationAngle(bone20, -0.6981F, 0.0F, 0.0F);
			bone20.setTextureOffset(40, 40).addBox(-2.0F, -1.4088F, -2.8767F, 3.0F, 12.0F, 3.0F, 0.0F, false);
			bone29 = new ModelRenderer(this);
			bone29.setRotationPoint(-3.4F, 17.0F, -6.4F);
			RightArm.addChild(bone29);
			setRotationAngle(bone29, -0.6109F, 0.0F, 0.0F);
			bone29.setTextureOffset(0, 0).addBox(0.5F, 0.6527F, -1.9356F, 1.0F, 3.0F, 3.0F, 0.0F, false);
			bone30 = new ModelRenderer(this);
			bone30.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone29.addChild(bone30);
			bone30.setTextureOffset(4, 5).addBox(0.5F, 3.6527F, -1.9356F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			bone31 = new ModelRenderer(this);
			bone31.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone29.addChild(bone31);
			bone31.setTextureOffset(2, 5).addBox(0.6F, 3.6527F, -0.7356F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			bone32 = new ModelRenderer(this);
			bone32.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone29.addChild(bone32);
			bone32.setTextureOffset(0, 5).addBox(0.6F, 3.6527F, 0.3644F, 0.0F, 3.0F, 1.0F, 0.0F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.6F, -14.0F, -9.0F);
			Head.setTextureOffset(39, 0).addBox(-2.3F, -4.0F, -5.3F, 5.0F, 4.0F, 5.0F, 0.0F, false);
			Jaw = new ModelRenderer(this);
			Jaw.setRotationPoint(-0.6F, 0.0F, -2.0F);
			Head.addChild(Jaw);
			setRotationAngle(Jaw, 0.2618F, 0.0F, 0.0F);
			Jaw.setTextureOffset(21, 20).addBox(-0.7F, 0.0F, -3.3F, 3.0F, 2.0F, 5.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
			bone11.render(matrixStack, buffer, packedLight, packedOverlay);
			bone12.render(matrixStack, buffer, packedLight, packedOverlay);
			bone13.render(matrixStack, buffer, packedLight, packedOverlay);
			bone14.render(matrixStack, buffer, packedLight, packedOverlay);
			leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
			RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
