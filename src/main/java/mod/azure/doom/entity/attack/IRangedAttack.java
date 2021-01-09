
package mod.azure.doom.entity.attack;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public interface IRangedAttack {

	public Entity getProjectile(World world, double d2, double d3, double d4);

	public AttackSound getDefaultAttackSound();

}