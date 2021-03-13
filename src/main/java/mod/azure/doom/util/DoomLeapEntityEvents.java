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

		if (entity instanceof PlayerEntity && uuidHasJumpedMap.containsKey(entity.getUUID().toString())) {
			float enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(DoomEnchantments.LEAPING_DOOM.get(),
					entity);
			boolean usedMidAirJump = uuidHasJumpedMap.get(entity.getUUID().toString());
			boolean playerJumping = ObfuscationReflectionHelper.getPrivateValue(LivingEntity.class, entity,
					"jumping");
			boolean canJump = !entity.isOnGround() && !usedMidAirJump;

			if (entity.isOnGround()) {
				uuidHasJumpedMap.put(entity.getUUID().toString(), false);
			}

			if (!(enchantmentLevel > 0))
				return;

			if (canJump && !entity.isFallFlying() && !((PlayerEntity) entity).abilities.flying) {
				if (playerJumping && entity.getDeltaMovement().y() < 0) {
					entity.setDeltaMovement(entity.getDeltaMovement().x(), 0.8D, entity.getDeltaMovement().z());
					uuidHasJumpedMap.put(entity.getUUID().toString(), true);

					entity.playSound(SoundEvents.GENERIC_EXTINGUISH_FIRE, 0.3F, 2.0F);
					if (!entity.isOnGround()) {
						if (entity instanceof ServerPlayerEntity) {
							entity.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 100, 4));
						}
					}
					for (int i = 0; i < 20; ++i) {
						double d0 = entity.level.random.nextGaussian() * 0.02D;
						double d1 = entity.level.random.nextGaussian() * 0.02D;
						double d2 = entity.level.random.nextGaussian() * 0.02D;

						entity.level.addParticle(ParticleTypes.CRIT,
								entity.getX() + (double) (entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F)
										- (double) entity.getBbWidth() - d0 * 10.0D,
								entity.getY() - d1 * 10.0D,
								entity.getZ() + (double) (entity.level.random.nextFloat() * entity.getBbWidth() * 2.0F)
										- (double) entity.getBbWidth() - d2 * 10.0D,
								d0, d1, d2);
					}
				}

			}
		} else if (entity instanceof PlayerEntity) {
			uuidHasJumpedMap.put(entity.getUUID().toString(), false);
		}
	}

	@SubscribeEvent
	public void onLivingFall(LivingFallEvent event) {
		float enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(DoomEnchantments.LEAPING_DOOM.get(),
				event.getEntityLiving());

		if (enchantmentLevel > 0 && uuidHasJumpedMap.containsKey(event.getEntityLiving().getUUID().toString())
				&& uuidHasJumpedMap.get(event.getEntityLiving().getUUID().toString())) {
			int i = MathHelper.ceil((event.getDistance() - 1.0F - enchantmentLevel) * 0);
			event.setDistance(i);
		}
	}

}
