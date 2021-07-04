package mod.azure.doom.entity.tileentity;

import java.util.List;

import mod.azure.doom.entity.DemonEntity;
import mod.azure.doom.util.registry.ModEntityTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class TotemEntity extends TileEntity implements IAnimatable, ITickableTileEntity {
	private final AnimationFactory factory = new AnimationFactory(this);

	private <E extends TileEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
		return PlayState.CONTINUE;
	}

	public TotemEntity() {
		super(ModEntityTypes.TOTEM.get());
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<TotemEntity>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	}

	@Override
	public void tick() {
		if (this.level.getGameTime() % 80L == 0L) {
			this.applyEffects();
		}
	}
	
	@Override
	public void setRemoved() {
		this.removeEffects();
		super.setRemoved();
	}

	private void applyEffects() {
		if (!this.level.isClientSide) {
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB(this.worldPosition)).inflate(40).expandTowards(0.0D,
					(double) this.level.getMaxBuildHeight(), 0.0D);
			List<DemonEntity> list = this.level.getEntitiesOfClass(DemonEntity.class, axisalignedbb);
			for (DemonEntity entity : list) {
				entity.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 1000, 1));
				entity.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 1000, 1));
				entity.setGlowing(true);
			}
		}
	}

	private void removeEffects() {
		if (!this.level.isClientSide) {
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB(this.worldPosition)).inflate(40).expandTowards(0.0D,
					(double) this.level.getMaxBuildHeight(), 0.0D);
			List<DemonEntity> list = this.level.getEntitiesOfClass(DemonEntity.class, axisalignedbb);
			for (DemonEntity entity : list) {
				entity.setGlowing(false);
				entity.removeAllEffects();
			}
		}
	}
}