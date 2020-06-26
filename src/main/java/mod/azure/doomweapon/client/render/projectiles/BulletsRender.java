package mod.azure.doomweapon.client.render.projectiles;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.projectiles.BulletEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class BulletsRender extends ArrowRenderer<BulletEntity> {

	private static final ResourceLocation SHOTGUN_SHELL_TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/projectiles/shotgun_shell.png");

	public BulletsRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getEntityTexture(BulletEntity entity) {
		return SHOTGUN_SHELL_TEXTURE;
	}

}