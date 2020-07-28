
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
public class HypotarantulaEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public HypotarantulaEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 127);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("hypotarantula")
						.setRegistryName("hypotarantula");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -1, -16711732, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("hypotarantula"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelHypotarantula(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/hypotarantula.png");
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

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.death"));
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
	// Exported for Minecraft version 1.12
	// Paste this class into your mod and generate all required imports
	public static class ModelHypotarantula extends EntityModel<Entity> {
		private final ModelRenderer sac;
		private final ModelRenderer stinger;
		private final ModelRenderer body;
		private final ModelRenderer head;
		private final ModelRenderer jaw;
		private final ModelRenderer mandible2;
		private final ModelRenderer jaw2;
		private final ModelRenderer mandible;
		private final ModelRenderer leg1;
		private final ModelRenderer leg1Child;
		private final ModelRenderer leg2;
		private final ModelRenderer leg1Child2;
		private final ModelRenderer leg3;
		private final ModelRenderer leg1Child3;
		private final ModelRenderer leg4;
		private final ModelRenderer leg1Child4;
		private final ModelRenderer leg1Child5;
		private final ModelRenderer leg5;
		private final ModelRenderer leg1Child6;
		private final ModelRenderer leg6;
		private final ModelRenderer leg1Child7;
		private final ModelRenderer leg7;
		private final ModelRenderer leg1Child8;
		private final ModelRenderer leg8;
		public ModelHypotarantula() {
			textureWidth = 128;
			textureHeight = 128;
			sac = new ModelRenderer(this);
			sac.setRotationPoint(0.0F, 14.0F, -9.0F);
			setRotationAngle(sac, 0.5236F, 0.0F, 0.0F);
			addBoxHelper(sac, 0, 34, -8.0F, 4.3301F, 18.2846F, 16, 12, 17, 0.0F, false);
			stinger = new ModelRenderer(this);
			stinger.setRotationPoint(0.0F, 10.0F, 9.0F);
			sac.addChild(stinger);
			addBoxHelper(stinger, 0, 0, 0.0F, -0.2583F, 27.2846F, 0, 1, 5, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 13.0F, -29.0F);
			addBoxHelper(body, 0, 0, -5.0F, -2.0F, 18.0F, 11, 8, 26, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 24.0F, 0.0F);
			addBoxHelper(head, 48, 0, -3.0F, -16.0F, -20.0F, 8, 6, 9, 0.0F, false);
			jaw = new ModelRenderer(this);
			jaw.setRotationPoint(3.0F, -11.0F, -11.0F);
			head.addChild(jaw);
			setRotationAngle(jaw, 0.3491F, 0.0F, 0.0F);
			addBoxHelper(jaw, 0, 67, -2.0F, 1.0F, -9.0F, 4, 3, 10, 1.0F, false);
			mandible2 = new ModelRenderer(this);
			mandible2.setRotationPoint(6.0F, 17.0F, 5.0F);
			jaw.addChild(mandible2);
			addBoxHelper(mandible2, 0, 6, -4.0F, -22.0F, -15.0F, 1, 5, 1, 0.0F, false);
			jaw2 = new ModelRenderer(this);
			jaw2.setRotationPoint(0.0F, -9.0F, -11.0F);
			head.addChild(jaw2);
			setRotationAngle(jaw2, 0.3491F, 0.0F, 0.0F);
			addBoxHelper(jaw2, 66, 50, -3.0F, -1.0F, -9.0F, 4, 3, 10, 1.0F, false);
			mandible = new ModelRenderer(this);
			mandible.setRotationPoint(0.0F, 15.0F, 5.0F);
			jaw2.addChild(mandible);
			addBoxHelper(mandible, 4, 6, -4.0F, -22.0F, -15.0F, 1, 5, 1, 0.0F, false);
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(6.0F, 13.0F, -8.0F);
			addBoxHelper(leg1, 48, 71, 0.0F, -1.0F, -1.0F, 13, 2, 2, 0.0F, false);
			leg1Child = new ModelRenderer(this);
			leg1Child.setRotationPoint(12.6F, -1.2F, 0.0F);
			leg1.addChild(leg1Child);
			setRotationAngle(leg1Child, 0.0F, 0.0F, 0.7854F);
			addBoxHelper(leg1Child, 42, 63, 0.4037F, -0.1433F, -1.0F, 19, 2, 2, 0.0F, false);
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(5.0F, 13.0F, -5.0F);
			addBoxHelper(leg2, 18, 71, 1.0F, -1.0F, -1.0F, 13, 2, 2, 0.0F, false);
			leg1Child2 = new ModelRenderer(this);
			leg1Child2.setRotationPoint(14.0F, -1.0F, 0.0F);
			leg2.addChild(leg1Child2);
			setRotationAngle(leg1Child2, 0.0F, 0.0F, 0.7854F);
			addBoxHelper(leg1Child2, 0, 63, 0.0F, 0.0F, -1.0F, 19, 2, 2, 0.0F, false);
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(6.0F, 13.0F, -2.0F);
			addBoxHelper(leg3, 48, 67, 0.0F, -1.0F, -1.0F, 13, 2, 2, 0.0F, false);
			leg1Child3 = new ModelRenderer(this);
			leg1Child3.setRotationPoint(13.0F, -1.0F, 0.0F);
			leg3.addChild(leg1Child3);
			setRotationAngle(leg1Child3, 0.0F, 0.0F, 0.7854F);
			addBoxHelper(leg1Child3, 49, 46, 0.0F, 0.0F, -1.0F, 19, 2, 2, 0.0F, false);
			leg4 = new ModelRenderer(this);
			leg4.setRotationPoint(7.0F, 13.0F, 1.0F);
			addBoxHelper(leg4, 18, 67, -1.0F, -1.0F, -1.0F, 13, 2, 2, 0.0F, false);
			leg1Child4 = new ModelRenderer(this);
			leg1Child4.setRotationPoint(12.0F, -1.0F, 0.0F);
			leg4.addChild(leg1Child4);
			setRotationAngle(leg1Child4, 0.0F, 0.0F, 0.7854F);
			addBoxHelper(leg1Child4, 49, 42, 0.0F, 0.0F, -1.0F, 19, 2, 2, 0.0F, false);
			leg1Child5 = new ModelRenderer(this);
			leg1Child5.setRotationPoint(-5.0F, 13.0F, -8.0F);
			addBoxHelper(leg1Child5, 74, 27, -12.0F, -1.0F, -1.0F, 12, 2, 2, 0.0F, false);
			leg5 = new ModelRenderer(this);
			leg5.setRotationPoint(-12.0F, -1.0F, 0.0F);
			leg1Child5.addChild(leg5);
			setRotationAngle(leg5, 0.0F, 0.0F, -0.7854F);
			addBoxHelper(leg5, 49, 38, -19.0F, 0.0F, -1.0F, 19, 2, 2, 0.0F, false);
			leg1Child6 = new ModelRenderer(this);
			leg1Child6.setRotationPoint(-4.0F, 12.0F, -5.0F);
			addBoxHelper(leg1Child6, 74, 23, -13.0F, 0.0F, -1.0F, 12, 2, 2, 0.0F, false);
			leg6 = new ModelRenderer(this);
			leg6.setRotationPoint(-13.0F, 0.0F, 0.0F);
			leg1Child6.addChild(leg6);
			setRotationAngle(leg6, 0.0F, 0.0F, -0.7854F);
			addBoxHelper(leg6, 49, 34, -19.0F, 0.0F, -1.0F, 19, 2, 2, 0.0F, false);
			leg1Child7 = new ModelRenderer(this);
			leg1Child7.setRotationPoint(-5.0F, 13.0F, -2.0F);
			addBoxHelper(leg1Child7, 73, 4, -12.0F, -1.0F, -1.0F, 12, 2, 2, 0.0F, false);
			leg7 = new ModelRenderer(this);
			leg7.setRotationPoint(-12.0F, -1.0F, 0.0F);
			leg1Child7.addChild(leg7);
			setRotationAngle(leg7, 0.0F, 0.0F, -0.7854F);
			addBoxHelper(leg7, 48, 19, -19.0F, 0.0F, -1.0F, 19, 2, 2, 0.0F, false);
			leg1Child8 = new ModelRenderer(this);
			leg1Child8.setRotationPoint(-5.0F, 13.0F, 1.0F);
			addBoxHelper(leg1Child8, 73, 0, -12.0F, -1.0F, -1.0F, 12, 2, 2, 0.0F, false);
			leg8 = new ModelRenderer(this);
			leg8.setRotationPoint(-18.0F, -1.0F, 0.0F);
			leg1Child8.addChild(leg8);
			setRotationAngle(leg8, 0.0F, 0.0F, -0.7854F);
			addBoxHelper(leg8, 48, 15, -14.7574F, 4.2426F, -1.0F, 19, 2, 2, 0.0F, false);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			sac.render(ms, vb, i1, i2, f1, f2, f3, f4);
			body.render(ms, vb, i1, i2, f1, f2, f3, f4);
			head.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg1.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg2.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg3.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg4.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg1Child5.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg1Child6.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg1Child7.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg1Child8.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.leg1.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
			this.leg4.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
			this.leg2.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
			this.leg3.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
			this.leg1Child6.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leg1Child5.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leg1Child8.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leg1Child7.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta) {
		addBoxHelper(renderer, texU, texV, x, y, z, dx, dy, dz, delta, renderer.mirror);
	}

	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta,
			boolean mirror) {
		renderer.mirror = mirror;
		renderer.addBox("", x, y, z, dx, dy, dz, delta, texU, texV);
	}
}
