package mod.azure.doomweapon.util.registry;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.ArchvileEntity;
import mod.azure.doomweapon.entity.BaronEntity;
import mod.azure.doomweapon.entity.CacodemonEntity;
import mod.azure.doomweapon.entity.ChaingunnerEntity;
import mod.azure.doomweapon.entity.Cyberdemon2016Entity;
import mod.azure.doomweapon.entity.CyberdemonEntity;
import mod.azure.doomweapon.entity.HellknightEntity;
import mod.azure.doomweapon.entity.IconofsinEntity;
import mod.azure.doomweapon.entity.Imp2016Entity;
import mod.azure.doomweapon.entity.ImpEntity;
import mod.azure.doomweapon.entity.LostSoulEntity;
import mod.azure.doomweapon.entity.MancubusEntity;
import mod.azure.doomweapon.entity.MarauderEntity;
import mod.azure.doomweapon.entity.PainEntity;
import mod.azure.doomweapon.entity.PinkyEntity;
import mod.azure.doomweapon.entity.PossessedScientistEntity;
import mod.azure.doomweapon.entity.PossessedSoldierEntity;
import mod.azure.doomweapon.entity.RevenantEntity;
import mod.azure.doomweapon.entity.ShotgunguyEntity;
import mod.azure.doomweapon.entity.SpiderdemonEntity;
import mod.azure.doomweapon.entity.UnwillingEntity;
import mod.azure.doomweapon.entity.ZombiemanEntity;
import mod.azure.doomweapon.entity.projectiles.ArgentBoltEntity;
import mod.azure.doomweapon.entity.projectiles.BFGEntity;
import mod.azure.doomweapon.entity.projectiles.BarenBlastEntity;
import mod.azure.doomweapon.entity.projectiles.BarrelEntity;
import mod.azure.doomweapon.entity.projectiles.BulletEntity;
import mod.azure.doomweapon.entity.projectiles.ChaingunBulletEntity;
import mod.azure.doomweapon.entity.projectiles.EnergyCellEntity;
import mod.azure.doomweapon.entity.projectiles.PainShootEntity;
import mod.azure.doomweapon.entity.projectiles.RocketEntity;
import mod.azure.doomweapon.entity.projectiles.ShotgunShellEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			DoomMod.MODID);

	public static final RegistryObject<EntityType<BarrelEntity>> BARREL = ENTITY_TYPES.register("barrel",
			() -> EntityType.Builder.<BarrelEntity>create(BarrelEntity::new, EntityClassification.MISC)
					.size(0.98F, 0.98F).func_233606_a_(10)
					.build(new ResourceLocation(DoomMod.MODID, "barrel").toString()));

	public static final RegistryObject<EntityType<ShotgunShellEntity>> SHOTGUN_SHELL = ENTITY_TYPES.register(
			"shotgun_shell",
			() -> EntityType.Builder.<ShotgunShellEntity>create(ShotgunShellEntity::new, EntityClassification.MISC)
					.size(0.5F, 0.5F).func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "shotgun_shell").toString()));

	public static final RegistryObject<EntityType<ArgentBoltEntity>> ARGENT_BOLT = ENTITY_TYPES.register("argent_bolt",
			() -> EntityType.Builder.<ArgentBoltEntity>create(ArgentBoltEntity::new, EntityClassification.MISC)
					.func_233606_a_(9).size(0.5F, 0.5F)
					.build(new ResourceLocation(DoomMod.MODID, "argent_bolt").toString()));

	public static final RegistryObject<EntityType<EnergyCellEntity>> ENERGY_CELL = ENTITY_TYPES.register("energy_cell",
			() -> EntityType.Builder.<EnergyCellEntity>create(EnergyCellEntity::new, EntityClassification.MISC)
					.func_233606_a_(9).size(0.5F, 0.5F)
					.build(new ResourceLocation(DoomMod.MODID, "energy_cell").toString()));

	public static final RegistryObject<EntityType<BFGEntity>> BFG_CELL = ENTITY_TYPES.register("bfg_cell",
			() -> EntityType.Builder.<BFGEntity>create(BFGEntity::new, EntityClassification.MISC).size(2.0F, 2.0F)
					.func_233606_a_(9).build(new ResourceLocation(DoomMod.MODID, "bfg_cell").toString()));

	public static final RegistryObject<EntityType<RocketEntity>> ROCKET = ENTITY_TYPES.register("rocket",
			() -> EntityType.Builder.<RocketEntity>create(RocketEntity::new, EntityClassification.MISC).size(0.5F, 0.5F)
					.func_233606_a_(9).build(new ResourceLocation(DoomMod.MODID, "rocket").toString()));

	public static final RegistryObject<EntityType<PainShootEntity>> LOST_SOUL_SHOOT = ENTITY_TYPES.register(
			"lost_soul_shot",
			() -> EntityType.Builder.<PainShootEntity>create(PainShootEntity::new, EntityClassification.MISC)
					.size(1.0F, 1.0F).func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "lost_soul_shot").toString()));

	public static final RegistryObject<EntityType<BarenBlastEntity>> BARENBLAST = ENTITY_TYPES.register("barenblast",
			() -> EntityType.Builder.<BarenBlastEntity>create(BarenBlastEntity::new, EntityClassification.MISC)
					.size(1.0F, 1.0F).func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "barenblast").toString()));

	public static final RegistryObject<EntityType<BulletEntity>> BULLETS = ENTITY_TYPES.register("bullets",
			() -> EntityType.Builder.<BulletEntity>create(BulletEntity::new, EntityClassification.MISC).size(0.5F, 0.5F)
					.func_233606_a_(9).build(new ResourceLocation(DoomMod.MODID, "bullets").toString()));

	public static final RegistryObject<EntityType<ChaingunBulletEntity>> CHAINGUN_BULLET = ENTITY_TYPES.register(
			"chaingunbullets",
			() -> EntityType.Builder.<ChaingunBulletEntity>create(ChaingunBulletEntity::new, EntityClassification.MISC)
					.size(0.5F, 0.5F).func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "chaingunbullets").toString()));

	public static final RegistryObject<EntityType<ImpEntity>> IMP = ENTITY_TYPES.register("imp",
			() -> EntityType.Builder.create(ImpEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().func_233606_a_(9).build(new ResourceLocation(DoomMod.MODID, "imp").toString()));

	public static final RegistryObject<EntityType<PinkyEntity>> PINKY = ENTITY_TYPES.register("pinky",
			() -> EntityType.Builder.create(PinkyEntity::new, EntityClassification.MONSTER).size(1.7f, 2.2F)
					.immuneToFire().func_233606_a_(9).build(new ResourceLocation(DoomMod.MODID, "pinky").toString()));

	public static final RegistryObject<EntityType<LostSoulEntity>> LOST_SOUL = ENTITY_TYPES.register("lost_soul",
			() -> EntityType.Builder.create(LostSoulEntity::new, EntityClassification.MONSTER).size(1.0F, 1.0F)
					.immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "lost_soul").toString()));

	public static final RegistryObject<EntityType<CacodemonEntity>> CACODEMON = ENTITY_TYPES.register("cacodemon",
			() -> EntityType.Builder.create(CacodemonEntity::new, EntityClassification.MONSTER).size(2.0F, 2.0F)
					.immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "cacodemon").toString()));

	public static final RegistryObject<EntityType<ArchvileEntity>> ARCHVILE = ENTITY_TYPES.register("archvile",
			() -> EntityType.Builder.create(ArchvileEntity::new, EntityClassification.MONSTER).size(0.6F, 2.9F)
					.immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "archvile").toString()));

	public static final RegistryObject<EntityType<BaronEntity>> BARON = ENTITY_TYPES.register("baron",
			() -> EntityType.Builder.create(BaronEntity::new, EntityClassification.MONSTER).func_233606_a_(9)
					.size(1.0f, 3.9F).immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "baron").toString()));

	public static final RegistryObject<EntityType<MancubusEntity>> MANCUBUS = ENTITY_TYPES.register("mancubus",
			() -> EntityType.Builder.create(MancubusEntity::new, EntityClassification.MONSTER).func_233606_a_(9)
					.size(1.9F, 5.4F).immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "mancubus").toString()));

	public static final RegistryObject<EntityType<SpiderdemonEntity>> SPIDERDEMON = ENTITY_TYPES.register("spiderdemon",
			() -> EntityType.Builder.create(SpiderdemonEntity::new, EntityClassification.MONSTER).size(3.0F, 3.5F)
					.immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "spiderdemon").toString()));

	public static final RegistryObject<EntityType<ZombiemanEntity>> ZOMBIEMAN = ENTITY_TYPES.register("zombieman",
			() -> EntityType.Builder.create(ZombiemanEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "zombieman").toString()));

	public static final RegistryObject<EntityType<RevenantEntity>> REVENANT = ENTITY_TYPES.register("revenant",
			() -> EntityType.Builder.create(RevenantEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "revenant").toString()));

	public static final RegistryObject<EntityType<Imp2016Entity>> IMP2016 = ENTITY_TYPES.register("imp2016",
			() -> EntityType.Builder.create(Imp2016Entity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().func_233606_a_(9).build(new ResourceLocation(DoomMod.MODID, "imp2016").toString()));

	public static final RegistryObject<EntityType<ChaingunnerEntity>> CHAINGUNNER = ENTITY_TYPES.register("chaingunner",
			() -> EntityType.Builder.create(ChaingunnerEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "chaingunner").toString()));

	public static final RegistryObject<EntityType<MarauderEntity>> MARAUDER = ENTITY_TYPES.register("marauder",
			() -> EntityType.Builder.create(MarauderEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "marauder").toString()));

	public static final RegistryObject<EntityType<ShotgunguyEntity>> SHOTGUNGUY = ENTITY_TYPES.register("shotgunguy",
			() -> EntityType.Builder.create(ShotgunguyEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "shotgunguy").toString()));

	public static final RegistryObject<EntityType<PainEntity>> PAIN = ENTITY_TYPES.register("painelemental",
			() -> EntityType.Builder.create(PainEntity::new, EntityClassification.MONSTER).size(2.0F, 2.0F)
					.immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "painelemental").toString()));

	public static final RegistryObject<EntityType<HellknightEntity>> HELLKNIGHT = ENTITY_TYPES.register("hellknight",
			() -> EntityType.Builder.create(HellknightEntity::new, EntityClassification.MONSTER).size(1.4F, 2.7F)
					.immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "hellknight").toString()));

	public static final RegistryObject<EntityType<CyberdemonEntity>> CYBERDEMON = ENTITY_TYPES.register("cyberdemon",
			() -> EntityType.Builder.create(CyberdemonEntity::new, EntityClassification.MONSTER).size(1.6f, 4.75F)
					.immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "cyberdemon").toString()));

	public static final RegistryObject<EntityType<Cyberdemon2016Entity>> CYBERDEMON2016 = ENTITY_TYPES.register(
			"cyberdemon2016",
			() -> EntityType.Builder.create(Cyberdemon2016Entity::new, EntityClassification.MONSTER).size(1.6f, 4.75F)
					.immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "cyberdemon2016").toString()));

	public static final RegistryObject<EntityType<UnwillingEntity>> UNWILLING = ENTITY_TYPES.register("unwilling",
			() -> EntityType.Builder.create(UnwillingEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "unwilling").toString()));

	public static final RegistryObject<EntityType<PossessedSoldierEntity>> POSSESSEDSOLDIER = ENTITY_TYPES.register(
			"possessed_soldier",
			() -> EntityType.Builder.create(PossessedSoldierEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().func_233606_a_(9)
					.build(new ResourceLocation(DoomMod.MODID, "possessed_soldier").toString()));

	public static final RegistryObject<EntityType<PossessedScientistEntity>> POSSESSEDSCIENTIST = ENTITY_TYPES.register(
			"possessed_scientist",
			() -> EntityType.Builder.create(PossessedScientistEntity::new, EntityClassification.MONSTER)
					.size(0.6f, 1.95F).func_233606_a_(9).immuneToFire()
					.build(new ResourceLocation(DoomMod.MODID, "possessed_scientist").toString()));

	public static final RegistryObject<EntityType<IconofsinEntity>> ICONOFSIN = ENTITY_TYPES.register("iconofsin",
			() -> EntityType.Builder.create(IconofsinEntity::new, EntityClassification.MONSTER).size(2.4f, 10.0F)
					.func_233606_a_(9).immuneToFire()
					.build(new ResourceLocation(DoomMod.MODID, "iconofsin").toString()));

}