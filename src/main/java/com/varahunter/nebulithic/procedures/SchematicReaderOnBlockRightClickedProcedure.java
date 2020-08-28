package com.varahunter.nebulithic.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.DirectionProperty;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import java.util.Map;

import com.varahunter.nebulithic.item.FloppyDiskItem;
import com.varahunter.nebulithic.block.ActiveSchematicReaderBlock;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class SchematicReaderOnBlockRightClickedProcedure extends NebulithicAscensionRewrittenModElements.ModElement {
	public SchematicReaderOnBlockRightClickedProcedure(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 229);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SchematicReaderOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SchematicReaderOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SchematicReaderOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SchematicReaderOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SchematicReaderOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(FloppyDiskItem.block, (int) (1)).getItem()) && ((new Object() {
					public Direction getDirection(BlockPos pos) {
						try {
							BlockState _bs = world.getBlockState(pos);
							DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
							return _bs.get(property);
						} catch (Exception e) {
							return Direction.NORTH;
						}
					}
				}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.SOUTH))) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(FloppyDiskItem.block, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ActiveSchematicReaderBlock.block.getDefaultState(), 3);
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
						_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.SOUTH), 3);
			} catch (Exception e) {
			}
		} else if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					return _bs.get(property);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.WEST)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(FloppyDiskItem.block, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ActiveSchematicReaderBlock.block.getDefaultState(), 3);
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
						_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.WEST), 3);
			} catch (Exception e) {
			}
		} else if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					return _bs.get(property);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.EAST)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ActiveSchematicReaderBlock.block.getDefaultState(), 3);
			try {
				BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
						_bs.with((DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing"), Direction.EAST), 3);
			} catch (Exception e) {
			}
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(FloppyDiskItem.block, (int) (1)).getItem())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ActiveSchematicReaderBlock.block.getDefaultState(), 3);
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(FloppyDiskItem.block, (int) (1)).getItem() == p.getItem(),
						(int) 1);
		}
	}
}
