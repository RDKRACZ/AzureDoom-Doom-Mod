package mod.azure.doom.item.armor.skin;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.BipedModelSkin;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeItem;

public class SkinArmor extends ArmorItem implements IForgeItem {

	public SkinArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
	}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

	@Override
	public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
		ItemStack stack = new ItemStack(this);
		stack.hasTag();
		stack.addEnchantment(Enchantments.FIRE_PROTECTION, 1);
		if (group == DoomMod.DoomArmorItemGroup) {
			items.add(stack);
		}
	}

	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		stack.hasTag();
		stack.addEnchantment(Enchantments.FIRE_PROTECTION, 1);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@OnlyIn(Dist.CLIENT)
	@Override
	public final BipedModel getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot,
			BipedModel _default) {
		final BipedModelSkin model = new BipedModelSkin(0f, false);
		if (!itemStack.isEmpty()) {
			if (itemStack.getItem() instanceof ArmorItem) {
				model.bipedHead.showModel = armorSlot == EquipmentSlotType.HEAD;
				model.bipedBody.showModel = armorSlot == EquipmentSlotType.CHEST;
				model.bipedRightArm.showModel = armorSlot == EquipmentSlotType.CHEST;
				model.bipedLeftArm.showModel = armorSlot == EquipmentSlotType.CHEST;
				model.bipedRightLeg.showModel = armorSlot == EquipmentSlotType.LEGS;
				model.bipedLeftLeg.showModel = armorSlot == EquipmentSlotType.LEGS;
				model.bipedHeadwear.showModel = armorSlot == EquipmentSlotType.HEAD;
				model.bipedBodyWear.showModel = armorSlot == EquipmentSlotType.CHEST;
				model.bipedRightArmwear.showModel = armorSlot == EquipmentSlotType.CHEST;
				model.bipedLeftArmwear.showModel = armorSlot == EquipmentSlotType.CHEST;
				model.bipedRightLegwear.showModel = (armorSlot == EquipmentSlotType.LEGS);
				model.bipedLeftLegwear.showModel = (armorSlot == EquipmentSlotType.LEGS);
				model.isSneak = _default.isSneak;
				model.isSitting = _default.isSitting;
				model.isChild = _default.isChild;
				model.rightArmPose = _default.rightArmPose;
				model.leftArmPose = _default.leftArmPose;
				return model;
			}
		}
		return null;
	}

}