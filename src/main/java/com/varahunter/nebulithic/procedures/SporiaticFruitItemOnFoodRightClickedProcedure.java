package com.varahunter.nebulithic.procedures;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

import com.varahunter.nebulithic.block.SporiaticfruitBlock;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class SporiaticFruitItemOnFoodRightClickedProcedure extends NebulithicAscensionRewrittenModElements.ModElement {
	public SporiaticFruitItemOnFoodRightClickedProcedure(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 34);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SporiaticFruitItemOnFoodRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SporiaticFruitItemOnFoodRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SporiaticFruitItemOnFoodRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SporiaticFruitItemOnFoodRightClicked!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), SporiaticfruitBlock.block.getDefaultState(), 3);
	}
}
