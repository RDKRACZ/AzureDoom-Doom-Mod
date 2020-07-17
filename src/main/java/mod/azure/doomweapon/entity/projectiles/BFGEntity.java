package mod.azure.doomweapon.entity.projectiles;

import java.util.List;

import mod.azure.doomweapon.util.registry.ModEntityTypes;
import mod.azure.doomweapon.util.registry.ModSoundEvents;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BFGEntity extends AbstractArrowEntity {

	private final Item referenceItem;

	@SuppressWarnings("unchecked")
	public BFGEntity(EntityType<?> type, World world) {
		super((EntityType<? extends AbstractArrowEntity>) type, world);
		this.referenceItem = null;
	}

	public BFGEntity(LivingEntity shooter, World world, Item referenceItemIn) {
		super(ModEntityTypes.BFG_CELL.get(), shooter, world);
		this.referenceItem = referenceItemIn;
	}

	protected void func_225516_i_() {
		this.remove();
	}

	@Override
	public ItemStack getArrowStack() {
		return new ItemStack(this.referenceItem);
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public boolean hasNoGravity() {
		return true;
	}

	protected IParticleData getParticle() {
		return ParticleTypes.TOTEM_OF_UNDYING;
	}

	@Override
	protected void onHit(RayTraceResult result) {
		super.onHit(result);
		if (!this.world.isRemote) {
			List<LivingEntity> list = this.world.getEntitiesWithinAABB(LivingEntity.class,
					this.getBoundingBox().grow(4.0D, 2.0D, 4.0D));
			AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(this.world, this.getPosX(),
					this.getPosY(), this.getPosZ());
			areaeffectcloudentity.setParticleData(ParticleTypes.TOTEM_OF_UNDYING);
			areaeffectcloudentity.setRadius(3.0F);
			areaeffectcloudentity.setDuration(10);
			areaeffectcloudentity.setRadiusPerTick(
					(7.0F - areaeffectcloudentity.getRadius()) / (float) areaeffectcloudentity.getDuration());
			areaeffectcloudentity.addEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, 1));
			if (!list.isEmpty()) {
				for (LivingEntity livingentity : list) {
					double d0 = this.getDistanceSq(livingentity);
					if (d0 < 16.0D) {
						areaeffectcloudentity.setPosition(livingentity.getPosX(), livingentity.getPosY(),
								livingentity.getPosZ());
						break;
					}
				}
			}

			this.world.playEvent(2006, new BlockPos(this), 0);
			this.world.addEntity(areaeffectcloudentity);
			this.explode();
			this.remove();
		}
		this.playSound(ModSoundEvents.ROCKET_HIT.get(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	}

	protected void explode() {
		this.world.createExplosion(this, this.getPosX(), this.getPosYHeight(0.0625D), this.getPosZ(), 12.0F,
				Explosion.Mode.NONE);
	}
}