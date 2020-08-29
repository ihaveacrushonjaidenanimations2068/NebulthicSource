
package com.varahunter.nebulithic.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import com.varahunter.nebulithic.itemgroup.NAMountsItemGroup;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class TankUnitItem extends NebulithicAscensionRewrittenModElements.ModElement {
	@ObjectHolder("nebulithic_ascension_rewritten:tank_unit")
	public static final Item block = null;
	public TankUnitItem(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 251);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(NAMountsItemGroup.tab).maxStackSize(64));
			setRegistryName("tank_unit");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
