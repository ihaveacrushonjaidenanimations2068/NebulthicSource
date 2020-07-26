package com.varahunter.nebulithic.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;

import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class HemopineShrubOnBlockRightClickedProcedure extends NebulithicAscensionRewrittenModElements.ModElement {
	public HemopineShrubOnBlockRightClickedProcedure(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 33);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure HemopineShrubOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure HemopineShrubOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure HemopineShrubOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HemopineShrubOnBlockRightClicked!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((Math.random() == 0)) {
			if (!world.isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("nebulithic_ascension_rewritten", "hemopine_tree"));
				if (template != null) {
					template.addBlocksToWorldChunk(world, new BlockPos((int) x, (int) y, (int) z), new PlacementSettings().setRotation(Rotation.NONE)
							.setMirror(Mirror.NONE).setChunk((ChunkPos) null).setIgnoreEntities(false));
				}
			}
		}
		if ((Math.random() == 1)) {
			if (!world.isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("nebulithic_ascension_rewritten", "hemopine_tree_2"));
				if (template != null) {
					template.addBlocksToWorldChunk(world, new BlockPos((int) x, (int) y, (int) z), new PlacementSettings().setRotation(Rotation.NONE)
							.setMirror(Mirror.NONE).setChunk((ChunkPos) null).setIgnoreEntities(false));
				}
			}
		} else {
			if (!world.isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("nebulithic_ascension_rewritten", "hemopine_tree_3"));
				if (template != null) {
					template.addBlocksToWorldChunk(world, new BlockPos((int) x, (int) y, (int) z), new PlacementSettings().setRotation(Rotation.NONE)
							.setMirror(Mirror.NONE).setChunk((ChunkPos) null).setIgnoreEntities(false));
				}
			}
		}
	}
}