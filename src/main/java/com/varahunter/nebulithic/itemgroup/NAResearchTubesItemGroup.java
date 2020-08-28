
package com.varahunter.nebulithic.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import com.varahunter.nebulithic.item.ResearchTubeUnbornItem;
import com.varahunter.nebulithic.NebulithicAscensionRewrittenModElements;

@NebulithicAscensionRewrittenModElements.ModElement.Tag
public class NAResearchTubesItemGroup extends NebulithicAscensionRewrittenModElements.ModElement {
	public NAResearchTubesItemGroup(NebulithicAscensionRewrittenModElements instance) {
		super(instance, 240);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabna_research_tubes") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ResearchTubeUnbornItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
