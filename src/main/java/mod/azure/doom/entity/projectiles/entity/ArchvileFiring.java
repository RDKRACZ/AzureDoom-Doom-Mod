package mod.azure.doom.entity.projectiles.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.EvokerFangsEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class ArchvileFiring extends EvokerFangsEntity implements IAnimatable {

	public ArchvileFiring(EntityType<? extends EvokerFangsEntity> p_i50170_1_, World p_i50170_2_) {
		super(p_i50170_1_, p_i50170_2_);
	}

	public ArchvileFiring(World worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_,
			LivingEntity casterIn) {
		super(worldIn, x, y, z, p_i47276_8_, p_i47276_9_, casterIn);
	}

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		return PlayState.STOP;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<ArchvileFiring>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

}