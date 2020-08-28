package com.varahunter.nebulithic.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;

import java.util.Map;

import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class ResearchTubeUnbornRightClickedOnBlockProcedure extends NebulithicAscensionRewrittenModElements.ModElement {
	public ResearchTubeUnbornRightClickedOnBlockProcedure(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 239);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ResearchTubeUnbornRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ResearchTubeUnbornRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ResearchTubeUnbornRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ResearchTubeUnbornRightClickedOnBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.getWorld().isRemote) {
			Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
					.getTemplateDefaulted(new ResourceLocation("nebulithic_ascension_rewritten", "research_tube_unborn"));
			if (template != null) {
				template.addBlocksToWorld(world, new BlockPos((int) x, (int) y, (int) z),
						new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
			}
		}
	}
}
