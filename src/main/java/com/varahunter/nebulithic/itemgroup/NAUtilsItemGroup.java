
package com.varahunter.nebulithic.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import com.varahunter.nebulithic.block.SchematicReaderBlock;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class NAUtilsItemGroup extends NebulithicAscensionRewrittenModElements.ModElement {
	public NAUtilsItemGroup(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 235);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabna_utils") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SchematicReaderBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
