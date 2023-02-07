package com.maskon.warchemy;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Iterator;

public class IceHeart extends Item {
	protected boolean frostActive = false;
	protected int frostlevel = 2;
	public IceHeart(Settings settings) {
		super(settings);
	}

	public boolean isFrostActive() {
		return frostActive;
	}

	public int getFrostlevel() {
		return frostlevel;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand)
	{
		if(playerEntity.isSneaking())
		{
			this.frostActive = !this.frostActive;
		}
		return TypedActionResult.success(playerEntity.getStackInHand(hand));
	}

}
