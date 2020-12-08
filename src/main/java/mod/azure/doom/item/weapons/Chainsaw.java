package mod.azure.doom.item.weapons;

import mod.azure.doom.DoomMod;
import mod.azure.doom.util.enums.DoomTier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class Chainsaw extends SwordItem {

	public Chainsaw() {
		super(DoomTier.DOOM, 2, -2.4F,
				new Item.Properties().group(DoomMod.DoomWeaponItemGroup).maxStackSize(1).maxDamage(600));
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return DoomTier.DOOM.getRepairMaterial().test(repair) || super.getIsRepairable(toRepair, repair);
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		LivingEntity user = (LivingEntity) entityIn;
		PlayerEntity player = (PlayerEntity) entityIn;
		final Vector3d facing = Vector3d.fromPitchYaw(user.getPitchYaw()).normalize();
		if (player.getHeldItemMainhand().isItemEqualIgnoreDurability(stack) && stack.getDamage() < 599) {
			final AxisAlignedBB aabb = new AxisAlignedBB(entityIn.getPosition().up()).grow(1D, 1D, 1D)
					.offset(facing.scale(1D));
			entityIn.getEntityWorld().getEntitiesWithinAABBExcludingEntity(user, aabb).forEach(e -> doDamage(user, e));
			entityIn.getEntityWorld().getEntitiesWithinAABBExcludingEntity(user, aabb)
					.forEach(e -> e.world.addParticle(RedstoneParticleData.REDSTONE_DUST, user.getPosXRandom(0.5D),
							user.getPosYRandom(), user.getPosZRandom(0.5D), 0.0D, 0D, 0D));
			if (!player.abilities.isCreativeMode) {
				stack.setDamage(stack.getDamage() + 1);
			}
		}
	}

	private void doDamage(final LivingEntity user, final Entity target) {
		target.attackEntityFrom(DamageSource.causeThornsDamage(target), 2F);
	}

}