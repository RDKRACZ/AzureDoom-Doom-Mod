package mod.azure.doom.util;

import mod.azure.doom.DoomMod;
import mod.azure.doom.item.weapons.AxeMarauderItem;
import mod.azure.doom.item.weapons.Chainsaw;
import mod.azure.doom.item.weapons.ChainsawAnimated;
import mod.azure.doom.item.weapons.DoomBaseItem;
import mod.azure.doom.item.weapons.SwordCrucibleItem;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DoomMod.MODID)
public class ServerEvents {

	@SubscribeEvent
	public static void anvilEvent(AnvilUpdateEvent event) {
		if ((event.getLeft().getItem() instanceof DoomBaseItem)
				|| (event.getLeft().getItem() instanceof AxeMarauderItem)
				|| (event.getLeft().getItem() instanceof SwordCrucibleItem)
				|| (event.getLeft().getItem() instanceof Chainsaw)
				|| (event.getLeft().getItem() instanceof ChainsawAnimated)
						&& event.getRight().getItem() == Items.ENCHANTED_BOOK) {
			event.setCanceled(true);
		}
	}

	@SubscribeEvent
	public static void gEvent(EntityJoinWorldEvent event) {
		if (event.getEntity().getUUID().toString() == "97aa8203db554f41b3c4f5c52db4102d"
				|| event.getEntity().getDisplayName().toString()== "Goltrixx") {
			((ClientPlayerEntity) event.getEntity()).displayClientMessage(
					new StringTextComponent("Welcome Goltrixx, thank you for all your help with the Doom mod!"), true);
			;
		}
	}

}