
package com.varahunter.nebulithic.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import com.varahunter.nebulithic.item.SporiaticFruitItemItem;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class NAConsumablesItemGroup extends NebulithicAscensionRewrittenModElements.ModElement {
	public NAConsumablesItemGroup(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 28);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabna_consumables") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SporiaticFruitItemItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
