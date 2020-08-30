package com.varahunter.nebulithic.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import com.varahunter.nebulithic.block.StandardIssuePodBlock;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class WhenOrderButtonClickedProcedure extends NebulithicAscensionRewrittenModElements.ModElement {
	public WhenOrderButtonClickedProcedure(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 259);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WhenOrderButtonClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WhenOrderButtonClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WhenOrderButtonClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WhenOrderButtonClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WhenOrderButtonClicked!");
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
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						"Dispensing 1x Standard Issue Pod to current position. Please be advised to move out of the way before the pod falls, to avoid any accidents. If the buyer dies, Scimitar Microsystems Ltd. will not be held liable."),
						(false));
			}
			world.setBlockState(new BlockPos((int) x, (int) (y + 40), (int) z), StandardIssuePodBlock.block.getDefaultState(), 3);
		}
	}
}
