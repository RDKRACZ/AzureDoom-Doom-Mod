package mod.azure.doomweapon.item.powerup;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.util.registry.DoomItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosAPI;
import top.theillusivec4.curios.api.capability.CuriosCapability;
import top.theillusivec4.curios.api.capability.ICurio;

public class SoulCubeItem extends Item {

	public SoulCubeItem() {
		super(new Item.Properties().group(DoomMod.DoomItemGroup).maxStackSize(1));
	}

	@Override
	public ICapabilityProvider initCapabilities(final ItemStack stack, CompoundNBT unused) {
		ICurio curio = new ICurio() {
			@Override
			public boolean canRightClickEquip() {
				return true;
			}

			@Override
			public boolean canEquip(String identifier, LivingEntity entityLivingBase) {
				return !CuriosAPI.getCurioEquipped(DoomItems.SOULCUBE.get(), entityLivingBase).isPresent();
			}
		};

		return new ICapabilityProvider() {
			private final LazyOptional<ICurio> curioOpt = LazyOptional.of(() -> curio);

			@Nonnull
			@Override
			public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {

				return CuriosCapability.ITEM.orEmpty(cap, curioOpt);
			}
		};
	}
}