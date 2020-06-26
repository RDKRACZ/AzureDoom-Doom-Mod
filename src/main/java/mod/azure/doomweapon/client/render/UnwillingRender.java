package mod.azure.doomweapon.client.render;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.UnwillingModel;
import mod.azure.doomweapon.entity.UnwillingEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class UnwillingRender extends MobRenderer<UnwillingEntity, UnwillingModel<UnwillingEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/unwilling.png");

	public UnwillingRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new UnwillingModel<UnwillingEntity>(0.5f, false), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(UnwillingEntity entity) {
		return TEXTURE;
	}

}