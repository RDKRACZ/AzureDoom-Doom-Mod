package mod.azure.doomweapon.item;

import java.util.List;

import mod.azure.doomweapon.DoomMod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ArgentEnergyItem extends Item {

	public ArgentEnergyItem() {
		super(new Item.Properties().group(DoomMod.DoomPowerUPItemGroup));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("\u00A7c" + "\u00A7o" + "Created by combining the tortured"));
		tooltip.add(new StringTextComponent("\u00A7c" + "\u00A7o" + "souls of the Nether and the power"));
		tooltip.add(new StringTextComponent("\u00A7c" + "\u00A7o" + "of the Aether."));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 100000;
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

	public int GetFuelValue() {
		return 1200;
	}
}