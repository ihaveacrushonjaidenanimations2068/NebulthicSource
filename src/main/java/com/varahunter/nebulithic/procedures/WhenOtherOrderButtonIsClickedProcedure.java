package com.varahunter.nebulithic.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.varahunter.nebulithic.block.PlacedSatelliteINfoPadBlock;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class WhenOtherOrderButtonIsClickedProcedure extends NebulithicAscensionRewrittenModElements.ModElement {
	public WhenOtherOrderButtonIsClickedProcedure(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 265);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure WhenOtherOrderButtonIsClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure WhenOtherOrderButtonIsClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure WhenOtherOrderButtonIsClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure WhenOtherOrderButtonIsClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure WhenOtherOrderButtonIsClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getDimension().getType().getId()) == (-1))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent("We apologize for the inconvenience, but the sattelite is currently unavailable for fabrication"),
						(false));
			}
		} else if (((world.getDimension().getType().getId()) == 0)) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 40), (int) z), PlacedSatelliteINfoPadBlock.block.getDefaultState(), 3);
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						"Sending 1x Satellite Information pad to current location. Please be advisedd to move out of the way before the phone hits to avoid head injuries. Thank you for choosing our products."),
						(false));
			}
		}
	}
}
