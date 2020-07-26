
package com.varahunter.nebulithic.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import com.varahunter.nebulithic.item.MierrogeniaItem;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class NAItemsItemGroup extends NebulithicAscensionRewrittenModElements.ModElement {
	public NAItemsItemGroup(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 25);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabna_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MierrogeniaItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
