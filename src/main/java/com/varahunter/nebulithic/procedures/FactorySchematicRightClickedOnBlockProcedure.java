package com.varahunter.nebulithic.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.varahunter.nebulithic.entity.FactorionTankEntity;
import com.varahunter.nebulithic.block.ActiveSchematicReaderBlock;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class FactorySchematicRightClickedOnBlockProcedure extends NebulithicAscensionRewrittenModElements.ModElement {
	public FactorySchematicRightClickedOnBlockProcedure(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 231);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FactorySchematicRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FactorySchematicRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FactorySchematicRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FactorySchematicRightClickedOnBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == ActiveSchematicReaderBlock.block.getDefaultState()
				.getBlock())) {
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new FactorionTankEntity.CustomEntity(FactorionTankEntity.entity, world.getWorld());
				entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
