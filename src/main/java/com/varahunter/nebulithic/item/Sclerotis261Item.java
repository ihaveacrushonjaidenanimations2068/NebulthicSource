
package com.varahunter.nebulithic.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ActionResultType;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;

import com.varahunter.nebulithic.world.dimension.Sclerotis261Dimension;
import com.varahunter.nebulithic.itemgroup.NAItemsItemGroup;

public class Sclerotis261Item extends Item {
	@ObjectHolder("nebulithic_ascension_rewritten:sclerotis_261")
	public static final Item block = null;
	public Sclerotis261Item() {
		super(new Item.Properties().group(NAItemsItemGroup.tab).maxDamage(64));
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity entity = context.getPlayer();
		BlockPos pos = context.getPos().offset(context.getFace());
		ItemStack itemstack = context.getItem();
		World world = context.getWorld();
		if (!entity.canPlayerEdit(pos, context.getFace(), itemstack)) {
			return ActionResultType.FAIL;
		} else {
			if (world.isAirBlock(pos))
				Sclerotis261Dimension.portal.portalSpawn(world, pos);
			itemstack.damageItem(1, entity, c -> c.sendBreakAnimation(context.getHand()));
			return ActionResultType.SUCCESS;
		}
	}
}
