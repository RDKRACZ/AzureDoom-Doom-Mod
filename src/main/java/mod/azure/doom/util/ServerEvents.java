package mod.azure.doom.util;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.DemonEntity;
import mod.azure.doom.item.weapons.AxeMarauderItem;
import mod.azure.doom.item.weapons.DoomBaseItem;
import mod.azure.doom.item.weapons.SwordCrucibleItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod.EventBusSubscriber(modid = DoomMod.MODID)
public class ServerEvents {

	@SubscribeEvent
	public static void onLivingUpdateEvent(LivingEvent.LivingUpdateEvent event) {

		LivingEntity le = event.getEntityLiving();
		if (!FMLEnvironment.production) {
			if (le instanceof DemonEntity) {
				PathNavigator navi = ((DemonEntity) le).getNavigator();
				if (le.world instanceof ServerWorld && le.world.getGameTime() % 10 == 0) {
					Path path = navi.getPath();
					if (path != null) {
						for (int i = path.getCurrentPathIndex(); i < path.getCurrentPathLength(); i++) {
							// get current point
							BlockPos pos = path.getPathPointFromIndex(i).func_224759_a();
							// get next point (or current point)
							BlockPos nextPos = (i + 1) != path.getCurrentPathLength()
									? path.getPathPointFromIndex(i + 1).func_224759_a()
									: pos;
							// get difference for vector
							BlockPos endPos = nextPos.subtract(pos);
							// render pathpoints
							((ServerWorld) le.world).spawnParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5,
									pos.getY() + 0.5, pos.getZ() + 0.5, 0, 0, 0, 0, 0);
							// send a particle between points for direction
							((ServerWorld) le.world).spawnParticle(ParticleTypes.END_ROD, pos.getX() + 0.5,
									pos.getY() + 0.5, pos.getZ() + 0.5, 0, endPos.getX(), endPos.getY(), endPos.getZ(),
									0.1);
						}
						// render end point
						BlockPos pos = navi.getTargetPos();
						((ServerWorld) le.world).spawnParticle(ParticleTypes.HEART, pos.getX() + 0.5, pos.getY() + 0.5,
								pos.getZ() + 0.5, 0, 0, 0, 0, 0);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void anvilEvent(AnvilUpdateEvent event) {
		if ((event.getLeft().getItem() instanceof DoomBaseItem)
				|| (event.getLeft().getItem() instanceof AxeMarauderItem)
				|| (event.getLeft().getItem() instanceof SwordCrucibleItem)
						&& event.getRight().getItem() == Items.ENCHANTED_BOOK) {
			event.setCanceled(true);
		}
	}

}
