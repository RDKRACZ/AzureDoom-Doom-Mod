package mod.azure.doom.client.render.projectiles;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.projectiles.ChaingunBulletEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class ChaingunBulletRender extends ArrowRenderer<ChaingunBulletEntity> {

	private static final ResourceLocation SHOTGUN_SHELL_TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/projectiles/shotgun_shell.png");

	public ChaingunBulletRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getTextureLocation(ChaingunBulletEntity entity) {
		return SHOTGUN_SHELL_TEXTURE;
	}

}