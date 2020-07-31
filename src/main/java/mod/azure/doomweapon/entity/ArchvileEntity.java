package mod.azure.doomweapon.entity;

import java.util.EnumSet;
import java.util.Random;

import mod.azure.doomweapon.entity.ai.goal.DemonAttackGoal;
import mod.azure.doomweapon.util.registry.DoomItems;
import mod.azure.doomweapon.util.registry.ModEntityTypes;
import mod.azure.doomweapon.util.registry.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class ArchvileEntity extends DemonEntity {

	public ArchvileEntity(EntityType<ArchvileEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	public ArchvileEntity(World worldIn) {
		this(ModEntityTypes.ARCHVILE.get(), worldIn);
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public static boolean spawning(EntityType<ArchvileEntity> p_223337_0_, IWorld p_223337_1_, SpawnReason reason,
			BlockPos p_223337_3_, Random p_223337_4_) {
		return p_223337_1_.getDifficulty() != Difficulty.PEACEFUL;
	}

	@Override
	public boolean isChild() {
		return false;
	}

	protected boolean shouldDrown() {
		return false;
	}

	protected boolean shouldBurnInDay() {
		return false;
	}

	protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropSpecialItems(source, looting, recentlyHitIn);
		ItemEntity itementity = this.entityDropItem(DoomItems.ARGENT_ENERGY.get());
		if (itementity != null) {
			itementity.isImmuneToFire();
			itementity.setNoDespawn();
			itementity.setGlowing(true);
		}
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(2, new DemonAttackGoal(this, 1.0D, false));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.3F);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(64.0D);
	}

	protected boolean teleportRandomly() {
		if (!this.world.isRemote() && this.isAlive()) {
			double d0 = this.getPosX() + (this.rand.nextDouble() - 0.5D) * 64.0D;
			double d1 = this.getPosY() + (double) (this.rand.nextInt(64) - 32);
			double d2 = this.getPosZ() + (this.rand.nextDouble() - 0.5D) * 64.0D;
			return this.teleportTo(d0, d1, d2);
		} else {
			return false;
		}
	}

	private boolean teleportToEntity(Entity p_70816_1_) {
		Vec3d vec3d = new Vec3d(this.getPosX() - p_70816_1_.getPosX(),
				this.getPosYHeight(0.5D) - p_70816_1_.getPosYEye(), this.getPosZ() - p_70816_1_.getPosZ());
		vec3d = vec3d.normalize();
		double d1 = this.getPosX() + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3d.x * 16.0D;
		double d2 = this.getPosY() + (double) (this.rand.nextInt(16) - 8) - vec3d.y * 16.0D;
		double d3 = this.getPosZ() + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3d.z * 16.0D;
		return this.teleportTo(d1, d2, d3);
	}

	private boolean shouldAttackPlayer(PlayerEntity player) {
		ItemStack itemstack = player.inventory.armorInventory.get(3);
		if (itemstack.getItem() == Blocks.CARVED_PUMPKIN.asItem()) {
			return false;
		} else {
			Vec3d vec3d = player.getLook(1.0F).normalize();
			Vec3d vec3d1 = new Vec3d(this.getPosX() - player.getPosX(), this.getPosYEye() - player.getPosYEye(),
					this.getPosZ() - player.getPosZ());
			double d0 = vec3d1.length();
			vec3d1 = vec3d1.normalize();
			double d1 = vec3d.dotProduct(vec3d1);
			return d1 > 1.0D - 0.025D / d0 ? player.canEntityBeSeen(this) : false;
		}
	}

	private boolean teleportTo(double x, double y, double z) {
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(x, y, z);

		while (blockpos$mutable.getY() > 0
				&& !this.world.getBlockState(blockpos$mutable).getMaterial().blocksMovement()) {
			blockpos$mutable.move(Direction.DOWN);
		}

		BlockState blockstate = this.world.getBlockState(blockpos$mutable);
		boolean flag = blockstate.getMaterial().blocksMovement();
		boolean flag1 = blockstate.getFluidState().isTagged(FluidTags.WATER);
		if (flag && !flag1) {
			net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(
					this, x, y, z, 0);
			if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
				return false;
			boolean flag2 = this.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
			if (flag2) {
				this.world.playSound((PlayerEntity) null, this.prevPosX, this.prevPosY, this.prevPosZ,
						ModSoundEvents.ARCHVILE_PORTAL.get(), this.getSoundCategory(), 1.0F, 1.0F);
				this.playSound(ModSoundEvents.ARCHVILE_PORTAL.get(), 1.0F, 1.0F);
			}

			return flag2;
		} else {
			return false;
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.ARCHVILE_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.ARCHVILE_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.ARCHVILE_DEATH.get();
	}
	static class FindPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		private final ArchvileEntity enderman;
		/** The player */
		private PlayerEntity player;
		private int aggroTime;
		private int teleportTime;
		private final EntityPredicate field_220791_m;
		private final EntityPredicate field_220792_n = (new EntityPredicate()).setLineOfSiteRequired();

		public FindPlayerGoal(ArchvileEntity endermanIn) {
			super(endermanIn, PlayerEntity.class, false);
			this.enderman = endermanIn;
			this.field_220791_m = (new EntityPredicate()).setDistance(this.getTargetDistance())
					.setCustomPredicate((p_220790_1_) -> {
						return endermanIn.shouldAttackPlayer((PlayerEntity) p_220790_1_);
					});
		}

		public boolean shouldExecute() {
			this.player = this.enderman.world.getClosestPlayer(this.field_220791_m, this.enderman);
			return this.player != null;
		}

		public void startExecuting() {
			this.aggroTime = 5;
			this.teleportTime = 0;
		}

		public void resetTask() {
			this.player = null;
			super.resetTask();
		}

		public boolean shouldContinueExecuting() {
			if (this.player != null) {
				if (!this.enderman.shouldAttackPlayer(this.player)) {
					return false;
				} else {
					this.enderman.faceEntity(this.player, 10.0F, 10.0F);
					return true;
				}
			} else {
				return this.nearestTarget != null && this.field_220792_n.canTarget(this.enderman, this.nearestTarget)
						? true
						: super.shouldContinueExecuting();
			}
		}

		public void tick() {
			if (this.player != null) {
				if (--this.aggroTime <= 0) {
					this.nearestTarget = this.player;
					this.player = null;
					super.startExecuting();
				}
			} else {
				if (this.nearestTarget != null && !this.enderman.isPassenger()) {
					if (this.enderman.shouldAttackPlayer((PlayerEntity) this.nearestTarget)) {
						if (this.nearestTarget.getDistanceSq(this.enderman) < 16.0D) {
							this.enderman.teleportRandomly();
						}

						this.teleportTime = 0;
					} else if (this.nearestTarget.getDistanceSq(this.enderman) > 256.0D && this.teleportTime++ >= 30
							&& this.enderman.teleportToEntity(this.nearestTarget)) {
						this.teleportTime = 0;
					}
				}

				super.tick();
			}

		}
	}

	static class StareGoal extends Goal {
		private final ArchvileEntity enderman;
		private LivingEntity targetPlayer;

		public StareGoal(ArchvileEntity endermanIn) {
			this.enderman = endermanIn;
			this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
		}

		public boolean shouldExecute() {
			this.targetPlayer = this.enderman.getAttackTarget();
			if (!(this.targetPlayer instanceof PlayerEntity)) {
				return false;
			} else {
				double d0 = this.targetPlayer.getDistanceSq(this.enderman);
				return d0 > 256.0D ? false : this.enderman.shouldAttackPlayer((PlayerEntity) this.targetPlayer);
			}
		}

		public void startExecuting() {
			this.enderman.getNavigator().clearPath();
		}

		public void tick() {
			this.enderman.getLookController().setLookPosition(this.targetPlayer.getPosX(),
					this.targetPlayer.getPosYEye(), this.targetPlayer.getPosZ());
		}
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 4;
	}

}