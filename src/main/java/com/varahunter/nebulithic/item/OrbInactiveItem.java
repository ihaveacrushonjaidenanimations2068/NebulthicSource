
package com.varahunter.nebulithic.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import com.varahunter.nebulithic.itemgroup.NAItemsItemGroup;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class OrbInactiveItem extends NebulithicAscensionRewrittenModElements.ModElement {
	@ObjectHolder("nebulithic_ascension_rewritten:orb_inactive")
	public static final Item block = null;
	public OrbInactiveItem(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 243);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(NAItemsItemGroup.tab).maxStackSize(64));
			setRegistryName("orb_inactive");
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
