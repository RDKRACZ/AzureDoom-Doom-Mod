package mod.azure.doomweapon.item.ammo;

import java.util.List;

import mod.azure.doomweapon.entity.projectiles.RocketEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;

public class Rocket extends ArrowItem {

	public final float damage;
	private RegistryObject<Item> ref;

	public Rocket(Properties properties, float damageIn) {
		super(properties);
		this.damage = damageIn;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("\u00A7o" + "Used for the Rocket Launcher."));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
		int enchant = net.minecraft.enchantment.EnchantmentHelper
				.getEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY, bow);
		return enchant <= 0 ? false : this instanceof Rocket;
	}

	public Rocket setItemReference(RegistryObject<Item> refIn) {
		this.ref = refIn;
		return this;
	}

	@Override
	public RocketEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		RocketEntity arrowentity = new RocketEntity(shooter, worldIn, ref.get());
		arrowentity.setDamage(this.damage);
		return arrowentity;
	}

}