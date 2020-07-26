
package com.varahunter.nebulithic.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.player.PlayerEntity;

import com.varahunter.nebulithic.procedures.SporiaticFruitItemOnFoodRightClickedProcedure;
import com.varahunter.nebulithic.itemgroup.NAConsumablesItemGroup;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class SporiaticFruitItemItem extends NebulithicAscensionRewrittenModElements.ModElement {
	@ObjectHolder("nebulithic_ascension_rewritten:sporiatic_fruit_item")
	public static final Item block = null;
	public SporiaticFruitItemItem(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(NAConsumablesItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(4).saturation(0.3f).build()));
			setRegistryName("sporiatic_fruit_item");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SporiaticFruitItemOnFoodRightClickedProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}
	}
}
