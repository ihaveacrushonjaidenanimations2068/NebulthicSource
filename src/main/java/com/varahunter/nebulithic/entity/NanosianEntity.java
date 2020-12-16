
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
public class NanosianEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public NanosianEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 254);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("nanosian")
						.setRegistryName("nanosian");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16750900, -13369549, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("nanosian_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelNanosianWinged(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/modelnanosianwinged.png");
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
	public static class ModelNanosianWinged extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer bone2;
		private final ModelRenderer bone3;
		private final ModelRenderer bone4;
		private final ModelRenderer bone5;
		private final ModelRenderer bone6;
		private final ModelRenderer bone7;
		private final ModelRenderer bone9;
		private final ModelRenderer bone19;
		private final ModelRenderer bone13;
		private final ModelRenderer bone8;
		private final ModelRenderer bone10;
		private final ModelRenderer bone18;
		private final ModelRenderer bone12;
		private final ModelRenderer bone11;
		private final ModelRenderer bone14;
		private final ModelRenderer bone15;
		private final ModelRenderer bone20;
		private final ModelRenderer bone17;
		private final ModelRenderer bone16;
		public ModelNanosianWinged() {
			textureWidth = 64;
			textureHeight = 64;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(-2.0F, 9.0F, 1.0F);
			bone.setTextureOffset(0, 34).addBox(-3.0F, 13.0F, -5.0F, 4.0F, 2.0F, 7.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(2.0F, 15.0F, 0.0F);
			bone.addChild(bone2);
			bone2.setTextureOffset(30, 39).addBox(-4.0F, -16.0F, -2.0F, 2.0F, 14.0F, 2.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(4.0F, 8.0F, 1.0F);
			bone3.setTextureOffset(21, 30).addBox(-3.0F, 14.0F, -5.0F, 4.0F, 2.0F, 7.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(-2.0F, 16.0F, 0.0F);
			bone3.addChild(bone4);
			bone4.setTextureOffset(22, 39).addBox(0.0F, -16.0F, -2.0F, 2.0F, 14.0F, 2.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone5.setTextureOffset(38, 38).addBox(-2.0F, -16.0F, -2.0F, 4.0F, 3.0F, 5.0F, 0.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(2.0F, 0.0F, 0.0F);
			bone5.addChild(bone6);
			setRotationAngle(bone6, 0.0F, 3.1416F, 0.0F);
			bone6.setTextureOffset(0, 0).addBox(-2.0F, -25.0F, -2.0F, 8.0F, 9.0F, 5.0F, 0.0F, false);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(5.0F, 0.0F, 0.0F);
			bone7.setTextureOffset(38, 4).addBox(-1.0F, -1.0F, -3.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);
			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(-5.0F, 24.0F, 0.0F);
			bone7.addChild(bone9);
			bone9.setTextureOffset(38, 46).addBox(5.0F, -23.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			bone19 = new ModelRenderer(this);
			bone19.setRotationPoint(2.0F, 6.0F, 0.0F);
			bone7.addChild(bone19);
			setRotationAngle(bone19, -0.4363F, 0.0F, 0.0F);
			bone19.setTextureOffset(0, 43).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			bone13 = new ModelRenderer(this);
			bone13.setRotationPoint(-6.0F, 18.0F, 0.0F);
			bone19.addChild(bone13);
			bone13.setTextureOffset(0, 14).addBox(5.0F, -13.0F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(-5.0F, 0.0F, 0.1667F);
			bone8.setTextureOffset(36, 30).addBox(-3.0F, -1.0F, -2.1667F, 4.0F, 2.0F, 5.0F, 0.0F, false);
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(7.0F, 24.0F, -0.1667F);
			bone8.addChild(bone10);
			bone10.setTextureOffset(45, 11).addBox(-9.0F, -23.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			bone18 = new ModelRenderer(this);
			bone18.setRotationPoint(0.0F, 6.0F, -0.1667F);
			bone8.addChild(bone18);
			setRotationAngle(bone18, -0.4363F, 0.0F, 0.0F);
			bone18.setTextureOffset(8, 43).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
			bone12 = new ModelRenderer(this);
			bone12.setRotationPoint(-7.0F, 18.0F, 0.0F);
			bone18.addChild(bone12);
			bone12.setTextureOffset(0, 34).addBox(5.0F, -13.0F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(2.0F, 24.0F, 0.0F);
			setRotationAngle(bone11, 0.0F, 3.1416F, 0.0F);
			bone11.setTextureOffset(19, 7).addBox(-1.0F, -31.0F, -3.0F, 6.0F, 6.0F, 7.0F, 0.0F, false);
			bone14 = new ModelRenderer(this);
			bone14.setRotationPoint(0.0F, -6.0F, 0.0F);
			bone11.addChild(bone14);
			setRotationAngle(bone14, 0.2618F, 0.0F, 0.0F);
			bone14.setTextureOffset(0, 14).addBox(-1.0F, -28.1469F, 3.0754F, 6.0F, 6.0F, 7.0F, 0.0F, false);
			bone15 = new ModelRenderer(this);
			bone15.setRotationPoint(-1.0F, 0.0F, -2.0F);
			setRotationAngle(bone15, 0.0F, 0.0F, 0.5236F);
			bone15.setTextureOffset(0, 30).addBox(-12.866F, -0.5F, 4.1F, 13.0F, 3.0F, 1.0F, 0.0F, false);
			bone20 = new ModelRenderer(this);
			bone20.setRotationPoint(-1.0F, 4.0F, -2.0F);
			setRotationAngle(bone20, 0.0F, 0.0F, -0.5236F);
			bone20.setTextureOffset(21, 0).addBox(-12.866F, -1.5F, 4.0F, 13.0F, 3.0F, 1.0F, 0.0F, false);
			bone17 = new ModelRenderer(this);
			bone17.setRotationPoint(4.0F, 5.0F, -2.0F);
			setRotationAngle(bone17, 0.0F, 0.0F, 0.5236F);
			bone17.setTextureOffset(25, 26).addBox(-1.866F, -1.5F, 4.0F, 13.0F, 3.0F, 1.0F, 0.0F, false);
			bone16 = new ModelRenderer(this);
			bone16.setRotationPoint(5.0F, 1.0F, 4.0F);
			setRotationAngle(bone16, 0.0F, 0.0F, -0.5236F);
			bone16.setTextureOffset(26, 20).addBox(-1.866F, -2.5F, -2.0F, 13.0F, 3.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			bone3.render(matrixStack, buffer, packedLight, packedOverlay);
			bone5.render(matrixStack, buffer, packedLight, packedOverlay);
			bone7.render(matrixStack, buffer, packedLight, packedOverlay);
			bone8.render(matrixStack, buffer, packedLight, packedOverlay);
			bone11.render(matrixStack, buffer, packedLight, packedOverlay);
			bone15.render(matrixStack, buffer, packedLight, packedOverlay);
			bone20.render(matrixStack, buffer, packedLight, packedOverlay);
			bone17.render(matrixStack, buffer, packedLight, packedOverlay);
			bone16.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.bone.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.bone7.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.bone8.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.bone3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
