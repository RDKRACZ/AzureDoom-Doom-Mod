package mod.azure.doom.util.registry;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ArachnotronEntity;
import mod.azure.doom.entity.ArchvileEntity;
import mod.azure.doom.entity.BaronEntity;
import mod.azure.doom.entity.CacodemonEntity;
import mod.azure.doom.entity.ChaingunnerEntity;
import mod.azure.doom.entity.Cyberdemon2016Entity;
import mod.azure.doom.entity.CyberdemonEntity;
import mod.azure.doom.entity.GargoyleEntity;
import mod.azure.doom.entity.GoreNestEntity;
import mod.azure.doom.entity.Hellknight2016Entity;
import mod.azure.doom.entity.HellknightEntity;
import mod.azure.doom.entity.IconofsinEntity;
import mod.azure.doom.entity.Imp2016Entity;
import mod.azure.doom.entity.ImpEntity;
import mod.azure.doom.entity.LostSoulEntity;
import mod.azure.doom.entity.MancubusEntity;
import mod.azure.doom.entity.MarauderEntity;
import mod.azure.doom.entity.MechaZombieEntity;
import mod.azure.doom.entity.NightmareImpEntity;
import mod.azure.doom.entity.PainEntity;
import mod.azure.doom.entity.PinkyEntity;
import mod.azure.doom.entity.PossessedScientistEntity;
import mod.azure.doom.entity.PossessedSoldierEntity;
import mod.azure.doom.entity.RevenantEntity;
import mod.azure.doom.entity.ShotgunguyEntity;
import mod.azure.doom.entity.SpiderdemonEntity;
import mod.azure.doom.entity.UnwillingEntity;
import mod.azure.doom.entity.ZombiemanEntity;
import mod.azure.doom.entity.projectiles.ArgentBoltEntity;
import mod.azure.doom.entity.projectiles.BFGEntity;
import mod.azure.doom.entity.projectiles.BarrelEntity;
import mod.azure.doom.entity.projectiles.BulletEntity;
import mod.azure.doom.entity.projectiles.ChaingunBulletEntity;
import mod.azure.doom.entity.projectiles.EnergyCellEntity;
import mod.azure.doom.entity.projectiles.RocketEntity;
import mod.azure.doom.entity.projectiles.ShotgunShellEntity;
import mod.azure.doom.entity.projectiles.UnmaykrBoltEntity;
import mod.azure.doom.entity.projectiles.entity.ArchvileFiring;
import mod.azure.doom.entity.projectiles.entity.BarenBlastEntity;
import mod.azure.doom.entity.projectiles.entity.ChaingunMobEntity;
import mod.azure.doom.entity.projectiles.entity.EnergyCellMobEntity;
import mod.azure.doom.entity.projectiles.entity.RocketMobEntity;
import mod.azure.doom.entity.tileentity.E1M1Door4Entity;
import mod.azure.doom.entity.tileentity.IconBlockEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			DoomMod.MODID);

	public static final DeferredRegister<TileEntityType<?>> TILE_TYPES = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, DoomMod.MODID);

	public static final RegistryObject<TileEntityType<IconBlockEntity>> ICON = TILE_TYPES.register("icon",
			() -> TileEntityType.Builder.<IconBlockEntity>create(IconBlockEntity::new, DoomBlocks.DOOM_WALL1.get())
					.build(null));

	public static final RegistryObject<TileEntityType<E1M1Door4Entity>> E1M1DOOR4 = TILE_TYPES.register("e1m1door4",
			() -> TileEntityType.Builder.<E1M1Door4Entity>create(E1M1Door4Entity::new, DoomBlocks.E1M1DOOR4.get())
					.build(null));

	public static final RegistryObject<EntityType<ArchvileFiring>> FIRING = ENTITY_TYPES.register("archvile_firing",
			() -> EntityType.Builder.<ArchvileFiring>create(ArchvileFiring::new, EntityClassification.MISC)
					.size(0.5F, 0.8F).trackingRange(10)
					.build(new ResourceLocation(DoomMod.MODID, "archvile_firing").toString()));

	public static final RegistryObject<EntityType<BarrelEntity>> BARREL = ENTITY_TYPES.register("barrel",
			() -> EntityType.Builder.<BarrelEntity>create(BarrelEntity::new, EntityClassification.MISC)
					.size(0.98F, 0.98F).trackingRange(10)
					.build(new ResourceLocation(DoomMod.MODID, "barrel").toString()));

	public static final RegistryObject<EntityType<ShotgunShellEntity>> SHOTGUN_SHELL = ENTITY_TYPES.register(
			"shotgun_shell",
			() -> EntityType.Builder.<ShotgunShellEntity>create(ShotgunShellEntity::new, EntityClassification.MISC)
					.size(0.5F, 0.5F).trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "shotgun_shell").toString()));

	public static final RegistryObject<EntityType<ArgentBoltEntity>> ARGENT_BOLT = ENTITY_TYPES.register("argent_bolt",
			() -> EntityType.Builder.<ArgentBoltEntity>create(ArgentBoltEntity::new, EntityClassification.MISC)
					.trackingRange(9).size(0.5F, 0.5F)
					.build(new ResourceLocation(DoomMod.MODID, "argent_bolt").toString()));

	public static final RegistryObject<EntityType<UnmaykrBoltEntity>> UNMAYKR = ENTITY_TYPES.register("unmaykr_bolt",
			() -> EntityType.Builder.<UnmaykrBoltEntity>create(UnmaykrBoltEntity::new, EntityClassification.MISC)
					.trackingRange(9).size(0.5F, 0.5F)
					.build(new ResourceLocation(DoomMod.MODID, "unmaykr_bolt").toString()));

	public static final RegistryObject<EntityType<EnergyCellEntity>> ENERGY_CELL = ENTITY_TYPES.register("energy_cell",
			() -> EntityType.Builder.<EnergyCellEntity>create(EnergyCellEntity::new, EntityClassification.MISC)
					.trackingRange(9).size(0.5F, 0.5F)
					.build(new ResourceLocation(DoomMod.MODID, "energy_cell").toString()));

	public static final RegistryObject<EntityType<BFGEntity>> BFG_CELL = ENTITY_TYPES.register("bfg_cell",
			() -> EntityType.Builder.<BFGEntity>create(BFGEntity::new, EntityClassification.MISC).size(2.0F, 2.0F)
					.trackingRange(9).build(new ResourceLocation(DoomMod.MODID, "bfg_cell").toString()));

	public static final RegistryObject<EntityType<RocketEntity>> ROCKET = ENTITY_TYPES.register("rocket",
			() -> EntityType.Builder.<RocketEntity>create(RocketEntity::new, EntityClassification.MISC).size(0.5F, 0.5F)
					.trackingRange(9).build(new ResourceLocation(DoomMod.MODID, "rocket").toString()));

	public static final RegistryObject<EntityType<LostSoulEntity>> LOST_SOUL = ENTITY_TYPES.register("lost_soul",
			() -> EntityType.Builder.<LostSoulEntity>create(LostSoulEntity::new, EntityClassification.MISC)
					.size(1.0F, 1.0F).trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "lost_soul").toString()));

	public static final RegistryObject<EntityType<BarenBlastEntity>> BARENBLAST = ENTITY_TYPES.register("barenblast",
			() -> EntityType.Builder.<BarenBlastEntity>create(BarenBlastEntity::new, EntityClassification.MISC)
					.size(1.0F, 1.0F).trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "barenblast").toString()));

	public static final RegistryObject<EntityType<BulletEntity>> BULLETS = ENTITY_TYPES.register("bullets",
			() -> EntityType.Builder.<BulletEntity>create(BulletEntity::new, EntityClassification.MISC).size(0.5F, 0.5F)
					.trackingRange(9).build(new ResourceLocation(DoomMod.MODID, "bullets").toString()));

	public static final RegistryObject<EntityType<ChaingunBulletEntity>> CHAINGUN_BULLET = ENTITY_TYPES.register(
			"chaingunbullets",
			() -> EntityType.Builder.<ChaingunBulletEntity>create(ChaingunBulletEntity::new, EntityClassification.MISC)
					.size(0.5F, 0.5F).trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "chaingunbullets").toString()));

	public static final RegistryObject<EntityType<ImpEntity>> IMP = ENTITY_TYPES.register("imp",
			() -> EntityType.Builder.create(ImpEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().trackingRange(9).build(new ResourceLocation(DoomMod.MODID, "imp").toString()));

	public static final RegistryObject<EntityType<NightmareImpEntity>> NIGHTMARE_IMP = ENTITY_TYPES.register(
			"nightmare_imp",
			() -> EntityType.Builder.create(NightmareImpEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "nightmare_imp").toString()));

	public static final RegistryObject<EntityType<PinkyEntity>> PINKY = ENTITY_TYPES.register("pinky",
			() -> EntityType.Builder.create(PinkyEntity::new, EntityClassification.MONSTER).size(1.7f, 2.2F)
					.immuneToFire().trackingRange(9).build(new ResourceLocation(DoomMod.MODID, "pinky").toString()));

	public static final RegistryObject<EntityType<CacodemonEntity>> CACODEMON = ENTITY_TYPES.register("cacodemon",
			() -> EntityType.Builder.create(CacodemonEntity::new, EntityClassification.MONSTER).size(2.0F, 2.0F)
					.immuneToFire().trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "cacodemon").toString()));

	public static final RegistryObject<EntityType<ArchvileEntity>> ARCHVILE = ENTITY_TYPES.register("archvile",
			() -> EntityType.Builder.create(ArchvileEntity::new, EntityClassification.MONSTER).size(0.6F, 2.9F)
					.immuneToFire().trackingRange(9).build(new ResourceLocation(DoomMod.MODID, "archvile").toString()));

	public static final RegistryObject<EntityType<BaronEntity>> BARON = ENTITY_TYPES.register("baron",
			() -> EntityType.Builder.create(BaronEntity::new, EntityClassification.MONSTER).trackingRange(9)
					.size(1.3f, 3.9F).immuneToFire().trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "baron").toString()));

	public static final RegistryObject<EntityType<MancubusEntity>> MANCUBUS = ENTITY_TYPES.register("mancubus",
			() -> EntityType.Builder.create(MancubusEntity::new, EntityClassification.MONSTER).trackingRange(9)
					.size(2.3F, 3.0F).immuneToFire().trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "mancubus").toString()));

	public static final RegistryObject<EntityType<SpiderdemonEntity>> SPIDERDEMON = ENTITY_TYPES.register("spiderdemon",
			() -> EntityType.Builder.create(SpiderdemonEntity::new, EntityClassification.MONSTER).size(6.0F, 4.0F)
					.immuneToFire().trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "spiderdemon").toString()));

	public static final RegistryObject<EntityType<ArachnotronEntity>> ARACHNOTRON = ENTITY_TYPES.register("arachnotron",
			() -> EntityType.Builder.create(ArachnotronEntity::new, EntityClassification.MONSTER).size(5.0F, 2.0F)
					.immuneToFire().trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "arachnotron").toString()));

	public static final RegistryObject<EntityType<ZombiemanEntity>> ZOMBIEMAN = ENTITY_TYPES.register("zombieman",
			() -> EntityType.Builder.create(ZombiemanEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "zombieman").toString()));

	public static final RegistryObject<EntityType<RevenantEntity>> REVENANT = ENTITY_TYPES.register("revenant",
			() -> EntityType.Builder.create(RevenantEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().trackingRange(9).build(new ResourceLocation(DoomMod.MODID, "revenant").toString()));

	public static final RegistryObject<EntityType<Imp2016Entity>> IMP2016 = ENTITY_TYPES.register("imp2016",
			() -> EntityType.Builder.create(Imp2016Entity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().trackingRange(9).build(new ResourceLocation(DoomMod.MODID, "imp2016").toString()));

	public static final RegistryObject<EntityType<ChaingunnerEntity>> CHAINGUNNER = ENTITY_TYPES.register("chaingunner",
			() -> EntityType.Builder.create(ChaingunnerEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "chaingunner").toString()));

	public static final RegistryObject<EntityType<MarauderEntity>> MARAUDER = ENTITY_TYPES.register("marauder",
			() -> EntityType.Builder.create(MarauderEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().trackingRange(9).build(new ResourceLocation(DoomMod.MODID, "marauder").toString()));

	public static final RegistryObject<EntityType<ShotgunguyEntity>> SHOTGUNGUY = ENTITY_TYPES.register("shotgunguy",
			() -> EntityType.Builder.create(ShotgunguyEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "shotgunguy").toString()));

	public static final RegistryObject<EntityType<PainEntity>> PAIN = ENTITY_TYPES.register("painelemental",
			() -> EntityType.Builder.create(PainEntity::new, EntityClassification.MONSTER).size(2.0F, 2.0F)
					.immuneToFire().trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "painelemental").toString()));

	public static final RegistryObject<EntityType<HellknightEntity>> HELLKNIGHT = ENTITY_TYPES.register("hellknight",
			() -> EntityType.Builder.create(HellknightEntity::new, EntityClassification.MONSTER).size(1.4F, 3.5F)
					.immuneToFire().trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "hellknight").toString()));

	public static final RegistryObject<EntityType<Hellknight2016Entity>> HELLKNIGHT2016 = ENTITY_TYPES.register(
			"hellknight2016",
			() -> EntityType.Builder
					.<Hellknight2016Entity>create(Hellknight2016Entity::new, EntityClassification.MONSTER)
					.size(1.8F, 3.0F).trackingRange(9).immuneToFire()
					.build(new ResourceLocation(DoomMod.MODID, "hellknight2016").toString()));

	public static final RegistryObject<EntityType<CyberdemonEntity>> CYBERDEMON = ENTITY_TYPES.register("cyberdemon",
			() -> EntityType.Builder.create(CyberdemonEntity::new, EntityClassification.MONSTER).size(1.6f, 4.75F)
					.immuneToFire().trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "cyberdemon").toString()));

	public static final RegistryObject<EntityType<Cyberdemon2016Entity>> CYBERDEMON2016 = ENTITY_TYPES.register(
			"cyberdemon2016",
			() -> EntityType.Builder.create(Cyberdemon2016Entity::new, EntityClassification.MONSTER).size(1.6f, 4.75F)
					.immuneToFire().trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "cyberdemon2016").toString()));

	public static final RegistryObject<EntityType<UnwillingEntity>> UNWILLING = ENTITY_TYPES.register("unwilling",
			() -> EntityType.Builder.create(UnwillingEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "unwilling").toString()));

	public static final RegistryObject<EntityType<PossessedSoldierEntity>> POSSESSEDSOLDIER = ENTITY_TYPES.register(
			"possessed_soldier",
			() -> EntityType.Builder.create(PossessedSoldierEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.immuneToFire().trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "possessed_soldier").toString()));

	public static final RegistryObject<EntityType<GoreNestEntity>> GORE_NEST = ENTITY_TYPES.register("gore_nest",
			() -> EntityType.Builder.create(GoreNestEntity::new, EntityClassification.MONSTER).size(3.0f, 4.0F)
					.immuneToFire().trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "gore_nest").toString()));

	public static final RegistryObject<EntityType<PossessedScientistEntity>> POSSESSEDSCIENTIST = ENTITY_TYPES.register(
			"possessed_scientist",
			() -> EntityType.Builder.create(PossessedScientistEntity::new, EntityClassification.MONSTER)
					.size(1.5f, 1.95F).trackingRange(9).immuneToFire()
					.build(new ResourceLocation(DoomMod.MODID, "possessed_scientist").toString()));

	public static final RegistryObject<EntityType<MechaZombieEntity>> MECHAZOMBIE = ENTITY_TYPES.register("mechazombie",
			() -> EntityType.Builder.create(MechaZombieEntity::new, EntityClassification.MONSTER).size(0.6f, 1.95F)
					.trackingRange(9).immuneToFire()
					.build(new ResourceLocation(DoomMod.MODID, "mechazombie").toString()));

	public static final RegistryObject<EntityType<IconofsinEntity>> ICONOFSIN = ENTITY_TYPES.register("iconofsin",
			() -> EntityType.Builder.create(IconofsinEntity::new, EntityClassification.MONSTER).size(2.4f, 10.0F)
					.trackingRange(9).immuneToFire()
					.build(new ResourceLocation(DoomMod.MODID, "iconofsin").toString()));

	public static final RegistryObject<EntityType<EnergyCellMobEntity>> ENERGY_CELL_MOB = ENTITY_TYPES.register(
			"energy_cell_mob",
			() -> EntityType.Builder.<EnergyCellMobEntity>create(EnergyCellMobEntity::new, EntityClassification.MISC)
					.trackingRange(9).size(0.5F, 0.5F)
					.build(new ResourceLocation(DoomMod.MODID, "energy_cell_mob").toString()));

	public static final RegistryObject<EntityType<RocketMobEntity>> ROCKET_MOB = ENTITY_TYPES.register("rocket_mob",
			() -> EntityType.Builder.<RocketMobEntity>create(RocketMobEntity::new, EntityClassification.MISC)
					.size(0.5F, 0.5F).trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "rocket_mob").toString()));

	public static final RegistryObject<EntityType<ChaingunMobEntity>> CHAINGUN_MOB = ENTITY_TYPES.register(
			"chaingun_mob",
			() -> EntityType.Builder.<ChaingunMobEntity>create(ChaingunMobEntity::new, EntityClassification.MISC)
					.size(0.5F, 0.5F).trackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "chaingun_mob").toString()));

	public static final RegistryObject<EntityType<GargoyleEntity>> GARGOYLE = ENTITY_TYPES.register("gargoyle",
			() -> EntityType.Builder.create(GargoyleEntity::new, EntityClassification.MONSTER).size(1.3f, 2.25F)
					.immuneToFire().trackingRange(9).build(new ResourceLocation(DoomMod.MODID, "gargoyle").toString()));

}