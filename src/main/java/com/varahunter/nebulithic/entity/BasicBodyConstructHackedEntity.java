
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
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
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

import com.varahunter.nebulithic.procedures.BasicBodyConstructHackedEntityDiesProcedure;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class BasicBodyConstructHackedEntity extends NebulithicAscensionRewrittenModElements.ModElement {
	public static EntityType entity = null;
	public BasicBodyConstructHackedEntity(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 282);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f))
						.build("basic_body_construct_hacked").setRegistryName("basic_body_construct_hacked");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16750900, -52429, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("basic_body_construct_hacked_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelBasicBodyConstruct(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nebulithic_ascension_rewritten:textures/basicbodyconstructhacked.png");
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
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
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
				BasicBodyConstructHackedEntityDiesProcedure.executeProcedure($_dependencies);
			}
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
	public static class ModelBasicBodyConstruct extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer legLeft;
		private final ModelRenderer bone4;
		private final ModelRenderer bone3;
		private final ModelRenderer bone5;
		public ModelBasicBodyConstruct() {
			textureWidth = 128;
			textureHeight = 128;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(3.0F, 24.0F, 0.0F);
			bone.setTextureOffset(0, 0).addBox(-12.0F, -33.0F, -8.0F, 19.0F, 23.0F, 17.0F, 0.0F, false);
			legLeft = new ModelRenderer(this);
			legLeft.setRotationPoint(3.5F, -7.75F, 2.5F);
			bone.addChild(legLeft);
			legLeft.setTextureOffset(32, 40).addBox(0.5F, -3.25F, -3.5F, 8.0F, 11.0F, 8.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(5.5F, 7.75F, -4.5F);
			legLeft.addChild(bone4);
			bone4.setTextureOffset(55, 0).addBox(-5.0F, -2.0F, -8.0F, 8.0F, 2.0F, 9.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(-7.5F, -9.75F, 3.5F);
			bone.addChild(bone3);
			bone3.setTextureOffset(0, 40).addBox(-8.5F, -1.25F, -4.5F, 8.0F, 11.0F, 8.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(-3.5F, 9.75F, -5.5F);
			bone3.addChild(bone5);
			bone5.setTextureOffset(55, 55).addBox(-5.0F, -2.0F, -8.0F, 8.0F, 2.0F, 9.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.bone3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.legLeft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
