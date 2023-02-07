package com.maskon.warchemy.mixin;

import com.maskon.warchemy.IceHeart;
import com.maskon.warchemy.Warchemy;
import net.minecraft.enchantment.FrostWalkerEnchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class PlayerMixin{


	@Shadow
	protected abstract void addSoulSpeedBoostIfNeeded();

	@Shadow
	protected abstract void removeSoulSpeedBoost();

	@Inject( method = "Lnet/minecraft/entity/LivingEntity;applyMovementEffects(Lnet/minecraft/util/math/BlockPos;)V", at = @At("HEAD"))
	private void applyMovementEffects(BlockPos pos, CallbackInfo callback) {
		LivingEntity casted = ((LivingEntity)(Object)this);
		ItemStack itemStack = casted.getStackInHand(hand);
		if(itemStack.isOf(Warchemy.ICE_HEART))
		{
			if (Warchemy.ICE_HEART.isFrostActive())
			{
				FrostWalkerEnchantment.freezeWater(casted, casted.world, pos, Warchemy.ICE_HEART.getFrostlevel());
			}
		}
	}
	private Hand hand;


}

	/*@Override
	public Iterable<ItemStack> getArmorItems() {
		return null;
	}

	@Override
	public ItemStack getEquippedStack(EquipmentSlot slot) {
		return null;
	}

	@Override
	public void equipStack(EquipmentSlot slot, ItemStack stack) {

	}

	@Override
	public Arm getMainArm() {
		return null;
	}*/

