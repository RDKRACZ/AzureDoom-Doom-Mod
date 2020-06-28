package mod.azure.doomweapon.client.render.projectiles;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.projectiles.EnergyCellEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class EnergyCellRender extends ArrowRenderer<EnergyCellEntity> {

	private static final ResourceLocation ENERGY_CELL_TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/projectiles/plasma_ball.png");

	public EnergyCellRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getEntityTexture(EnergyCellEntity entity) {
		return ENERGY_CELL_TEXTURE;
	}

}