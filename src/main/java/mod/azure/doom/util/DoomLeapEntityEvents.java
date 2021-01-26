package mod.azure.doom.util;

import java.util.HashMap;

import mod.azure.doom.util.registry.DoomEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

/**
 * 
 * @credit to https://gitlab.com/modding-legacy/
 *
 */
public class DoomLeapEntityEvents {
	public static HashMap<String, Boolean> uuidHasJumpedMap = new HashMap<String, Boolean>();
	int cooldown = 0;

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		LivingEntity entity = event.getEntityLiving();

		if (entity instanceof PlayerEntity && uuidHasJumpedMap.containsKey(entity.getUniqueID().toString())) {
			float enchantmentLevel = EnchantmentHelper.getMaxEnchantmentLevel(DoomEnchantments.LEAPING_DOOM.get(),
					entity);
			boolean usedMidAirJump = uuidHasJumpedMap.get(entity.getUniqueID().toString());
			boolean playerJumping = ObfuscationReflectionHelper.getPrivateValue(LivingEntity.class, entity,
					"field_70703_bu");
			boolean canJump = !entity.isOnGround() && !usedMidAirJump;

			if (entity.isOnGround()) {
				uuidHasJumpedMap.put(entity.getUniqueID().toString(), false);
			}

			if (!(enchantmentLevel > 0))
				return;

			if (canJump && !entity.isElytraFlying() && !((PlayerEntity) entity).abilities.isFlying) {
				if (playerJumping && entity.getMotion().getY() < 0) {
					entity.setMotion(entity.getMotion().getX(), 0.8D, entity.getMotion().getZ());
					uuidHasJumpedMap.put(entity.getUniqueID().toString(), true);

					entity.playSound(SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, 0.3F, 2.0F);
					if (!entity.isOnGround()) {
						if (entity instanceof ServerPlayerEntity) {
							entity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 100, 4));
						}
					}
					for (int i = 0; i < 20; ++i) {
						double d0 = entity.world.rand.nextGaussian() * 0.02D;
						double d1 = entity.world.rand.nextGaussian() * 0.02D;
						double d2 = entity.world.rand.nextGaussian() * 0.02D;

						entity.world.addParticle(ParticleTypes.CRIT,
								entity.getPosX() + (double) (entity.world.rand.nextFloat() * entity.getWidth() * 2.0F)
										- (double) entity.getWidth() - d0 * 10.0D,
								entity.getPosY() - d1 * 10.0D,
								entity.getPosZ() + (double) (entity.world.rand.nextFloat() * entity.getWidth() * 2.0F)
										- (double) entity.getWidth() - d2 * 10.0D,
								d0, d1, d2);
					}
				}

			}
		} else if (entity instanceof PlayerEntity) {
			uuidHasJumpedMap.put(entity.getUniqueID().toString(), false);
		}
	}

	@SubscribeEvent
	public void onLivingFall(LivingFallEvent event) {
		float enchantmentLevel = EnchantmentHelper.getMaxEnchantmentLevel(DoomEnchantments.LEAPING_DOOM.get(),
				event.getEntityLiving());

		if (enchantmentLevel > 0 && uuidHasJumpedMap.containsKey(event.getEntityLiving().getUniqueID().toString())
				&& uuidHasJumpedMap.get(event.getEntityLiving().getUniqueID().toString())) {
			int i = MathHelper.ceil((event.getDistance() - 1.0F - enchantmentLevel) * 0);
			event.setDistance(i);
		}
	}

}
