package mod.azure.doom.util.registry;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ArachnotronEntity;
import mod.azure.doom.entity.ArchvileEntity;
import mod.azure.doom.entity.BaronEntity;
import mod.azure.doom.entity.CacodemonEntity;
import mod.azure.doom.entity.ChaingunnerEntity;
import mod.azure.doom.entity.CueBallEntity;
import mod.azure.doom.entity.Cyberdemon2016Entity;
import mod.azure.doom.entity.CyberdemonEntity;
import mod.azure.doom.entity.DoomHunterEntity;
import mod.azure.doom.entity.GargoyleEntity;
import mod.azure.doom.entity.GoreNestEntity;
import mod.azure.doom.entity.Hellknight2016Entity;
import mod.azure.doom.entity.HellknightEntity;
import mod.azure.doom.entity.IconofsinEntity;
import mod.azure.doom.entity.Imp2016Entity;
import mod.azure.doom.entity.ImpEntity;
import mod.azure.doom.entity.ImpStoneEntity;
import mod.azure.doom.entity.LostSoulEntity;
import mod.azure.doom.entity.MancubusEntity;
import mod.azure.doom.entity.MarauderEntity;
import mod.azure.doom.entity.MechaZombieEntity;
import mod.azure.doom.entity.NightmareImpEntity;
import mod.azure.doom.entity.PainEntity;
import mod.azure.doom.entity.PinkyEntity;
import mod.azure.doom.entity.PossessedScientistEntity;
import mod.azure.doom.entity.PossessedSoldierEntity;
import mod.azure.doom.entity.ProwlerEntity;
import mod.azure.doom.entity.RevenantEntity;
import mod.azure.doom.entity.ShotgunguyEntity;
import mod.azure.doom.entity.SpectreEntity;
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
			() -> TileEntityType.Builder.<IconBlockEntity>of(IconBlockEntity::new, DoomBlocks.DOOM_WALL1.get())
					.build(null));

	public static final RegistryObject<EntityType<ArchvileFiring>> FIRING = ENTITY_TYPES.register("archvile_firing",
			() -> EntityType.Builder.<ArchvileFiring>of(ArchvileFiring::new, EntityClassification.MISC)
					.sized(0.5F, 0.8F).clientTrackingRange(10)
					.build(new ResourceLocation(DoomMod.MODID, "archvile_firing").toString()));

	public static final RegistryObject<EntityType<BarrelEntity>> BARREL = ENTITY_TYPES.register("barrel",
			() -> EntityType.Builder.<BarrelEntity>of(BarrelEntity::new, EntityClassification.MISC).sized(0.98F, 0.98F)
					.clientTrackingRange(10).build(new ResourceLocation(DoomMod.MODID, "barrel").toString()));

	public static final RegistryObject<EntityType<ShotgunShellEntity>> SHOTGUN_SHELL = ENTITY_TYPES.register(
			"shotgun_shell",
			() -> EntityType.Builder.<ShotgunShellEntity>of(ShotgunShellEntity::new, EntityClassification.MISC)
					.sized(0.5F, 0.5F).clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "shotgun_shell").toString()));

	public static final RegistryObject<EntityType<ArgentBoltEntity>> ARGENT_BOLT = ENTITY_TYPES.register("argent_bolt",
			() -> EntityType.Builder.<ArgentBoltEntity>of(ArgentBoltEntity::new, EntityClassification.MISC)
					.clientTrackingRange(9).sized(0.5F, 0.5F)
					.build(new ResourceLocation(DoomMod.MODID, "argent_bolt").toString()));

	public static final RegistryObject<EntityType<UnmaykrBoltEntity>> UNMAYKR = ENTITY_TYPES.register("unmaykr_bolt",
			() -> EntityType.Builder.<UnmaykrBoltEntity>of(UnmaykrBoltEntity::new, EntityClassification.MISC)
					.clientTrackingRange(9).sized(0.5F, 0.5F)
					.build(new ResourceLocation(DoomMod.MODID, "unmaykr_bolt").toString()));

	public static final RegistryObject<EntityType<EnergyCellEntity>> ENERGY_CELL = ENTITY_TYPES.register("energy_cell",
			() -> EntityType.Builder.<EnergyCellEntity>of(EnergyCellEntity::new, EntityClassification.MISC)
					.clientTrackingRange(9).sized(0.5F, 0.5F)
					.build(new ResourceLocation(DoomMod.MODID, "energy_cell").toString()));

	public static final RegistryObject<EntityType<BFGEntity>> BFG_CELL = ENTITY_TYPES.register("bfg_cell",
			() -> EntityType.Builder.<BFGEntity>of(BFGEntity::new, EntityClassification.MISC).sized(2.0F, 2.0F)
					.clientTrackingRange(9).build(new ResourceLocation(DoomMod.MODID, "bfg_cell").toString()));

	public static final RegistryObject<EntityType<RocketEntity>> ROCKET = ENTITY_TYPES.register("rocket",
			() -> EntityType.Builder.<RocketEntity>of(RocketEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.clientTrackingRange(9).build(new ResourceLocation(DoomMod.MODID, "rocket").toString()));

	public static final RegistryObject<EntityType<LostSoulEntity>> LOST_SOUL = ENTITY_TYPES.register("lost_soul",
			() -> EntityType.Builder.<LostSoulEntity>of(LostSoulEntity::new, EntityClassification.MISC)
					.sized(1.0F, 1.0F).clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "lost_soul").toString()));

	public static final RegistryObject<EntityType<BarenBlastEntity>> BARENBLAST = ENTITY_TYPES.register("barenblast",
			() -> EntityType.Builder.<BarenBlastEntity>of(BarenBlastEntity::new, EntityClassification.MISC)
					.sized(1.0F, 1.0F).clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "barenblast").toString()));

	public static final RegistryObject<EntityType<BulletEntity>> BULLETS = ENTITY_TYPES.register("bullets",
			() -> EntityType.Builder.<BulletEntity>of(BulletEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F)
					.clientTrackingRange(9).build(new ResourceLocation(DoomMod.MODID, "bullets").toString()));

	public static final RegistryObject<EntityType<ChaingunBulletEntity>> CHAINGUN_BULLET = ENTITY_TYPES.register(
			"chaingunbullets",
			() -> EntityType.Builder.<ChaingunBulletEntity>of(ChaingunBulletEntity::new, EntityClassification.MISC)
					.sized(0.5F, 0.5F).clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "chaingunbullets").toString()));

	public static final RegistryObject<EntityType<ImpEntity>> IMP = ENTITY_TYPES.register("imp",
			() -> EntityType.Builder.of(ImpEntity::new, EntityClassification.MONSTER).sized(0.6f, 1.95F).fireImmune()
					.clientTrackingRange(9).build(new ResourceLocation(DoomMod.MODID, "imp").toString()));

	public static final RegistryObject<EntityType<NightmareImpEntity>> NIGHTMARE_IMP = ENTITY_TYPES.register(
			"nightmare_imp",
			() -> EntityType.Builder.of(NightmareImpEntity::new, EntityClassification.MONSTER).sized(0.6f, 1.95F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "nightmare_imp").toString()));

	public static final RegistryObject<EntityType<PinkyEntity>> PINKY = ENTITY_TYPES.register("pinky",
			() -> EntityType.Builder.of(PinkyEntity::new, EntityClassification.MONSTER).sized(1.7f, 2.2F).fireImmune()
					.clientTrackingRange(9).build(new ResourceLocation(DoomMod.MODID, "pinky").toString()));

	public static final RegistryObject<EntityType<SpectreEntity>> SPECTRE = ENTITY_TYPES.register("spectre",
			() -> EntityType.Builder.of(SpectreEntity::new, EntityClassification.MONSTER).sized(1.7f, 2.2F).fireImmune()
					.clientTrackingRange(9).build(new ResourceLocation(DoomMod.MODID, "spectre").toString()));

	public static final RegistryObject<EntityType<CacodemonEntity>> CACODEMON = ENTITY_TYPES.register("cacodemon",
			() -> EntityType.Builder.of(CacodemonEntity::new, EntityClassification.MONSTER).sized(2.0F, 2.0F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "cacodemon").toString()));

	public static final RegistryObject<EntityType<ArchvileEntity>> ARCHVILE = ENTITY_TYPES.register("archvile",
			() -> EntityType.Builder.of(ArchvileEntity::new, EntityClassification.MONSTER).sized(0.9F, 3.3F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "archvile").toString()));

	public static final RegistryObject<EntityType<BaronEntity>> BARON = ENTITY_TYPES.register("baron",
			() -> EntityType.Builder.of(BaronEntity::new, EntityClassification.MONSTER).clientTrackingRange(9)
					.sized(1.3f, 3.9F).fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "baron").toString()));

	public static final RegistryObject<EntityType<MancubusEntity>> MANCUBUS = ENTITY_TYPES.register("mancubus",
			() -> EntityType.Builder.of(MancubusEntity::new, EntityClassification.MONSTER).clientTrackingRange(9)
					.sized(2.3F, 3.0F).fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "mancubus").toString()));

	public static final RegistryObject<EntityType<SpiderdemonEntity>> SPIDERDEMON = ENTITY_TYPES.register("spiderdemon",
			() -> EntityType.Builder.of(SpiderdemonEntity::new, EntityClassification.MONSTER).sized(6.0F, 4.0F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "spiderdemon").toString()));

	public static final RegistryObject<EntityType<ArachnotronEntity>> ARACHNOTRON = ENTITY_TYPES.register("arachnotron",
			() -> EntityType.Builder.of(ArachnotronEntity::new, EntityClassification.MONSTER).sized(4.0F, 2.0F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "arachnotron").toString()));

	public static final RegistryObject<EntityType<ZombiemanEntity>> ZOMBIEMAN = ENTITY_TYPES.register("zombieman",
			() -> EntityType.Builder.of(ZombiemanEntity::new, EntityClassification.MONSTER).sized(0.75f, 2.1F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "zombieman").toString()));

	public static final RegistryObject<EntityType<RevenantEntity>> REVENANT = ENTITY_TYPES.register("revenant",
			() -> EntityType.Builder.of(RevenantEntity::new, EntityClassification.MONSTER).sized(0.6f, 1.95F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "revenant").toString()));

	public static final RegistryObject<EntityType<Imp2016Entity>> IMP2016 = ENTITY_TYPES.register("imp2016",
			() -> EntityType.Builder.of(Imp2016Entity::new, EntityClassification.MONSTER).sized(0.6f, 1.95F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "imp2016").toString()));

	public static final RegistryObject<EntityType<ImpStoneEntity>> IMP_STONE = ENTITY_TYPES.register("stone_imp",
			() -> EntityType.Builder.of(ImpStoneEntity::new, EntityClassification.MONSTER).sized(0.6f, 1.95F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "stone_imp").toString()));

	public static final RegistryObject<EntityType<ChaingunnerEntity>> CHAINGUNNER = ENTITY_TYPES.register("chaingunner",
			() -> EntityType.Builder.of(ChaingunnerEntity::new, EntityClassification.MONSTER).sized(0.75f, 2.1F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "chaingunner").toString()));

	public static final RegistryObject<EntityType<MarauderEntity>> MARAUDER = ENTITY_TYPES.register("marauder",
			() -> EntityType.Builder.of(MarauderEntity::new, EntityClassification.MONSTER).sized(0.75f, 2.1F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "marauder").toString()));

	public static final RegistryObject<EntityType<ShotgunguyEntity>> SHOTGUNGUY = ENTITY_TYPES.register("shotgunguy",
			() -> EntityType.Builder.of(ShotgunguyEntity::new, EntityClassification.MONSTER).sized(0.75f, 2.1F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "shotgunguy").toString()));

	public static final RegistryObject<EntityType<PainEntity>> PAIN = ENTITY_TYPES.register("painelemental",
			() -> EntityType.Builder.of(PainEntity::new, EntityClassification.MONSTER).sized(2.0F, 2.0F).fireImmune()
					.clientTrackingRange(9).build(new ResourceLocation(DoomMod.MODID, "painelemental").toString()));

	public static final RegistryObject<EntityType<HellknightEntity>> HELLKNIGHT = ENTITY_TYPES.register("hellknight",
			() -> EntityType.Builder.of(HellknightEntity::new, EntityClassification.MONSTER).sized(1.4F, 3.5F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "hellknight").toString()));

	public static final RegistryObject<EntityType<Hellknight2016Entity>> HELLKNIGHT2016 = ENTITY_TYPES.register(
			"hellknight2016",
			() -> EntityType.Builder.<Hellknight2016Entity>of(Hellknight2016Entity::new, EntityClassification.MONSTER)
					.sized(1.8F, 3.0F).clientTrackingRange(9).fireImmune()
					.build(new ResourceLocation(DoomMod.MODID, "hellknight2016").toString()));

	public static final RegistryObject<EntityType<Hellknight2016Entity>> DREADKNIGHT = ENTITY_TYPES.register(
			"dreadknight",
			() -> EntityType.Builder.<Hellknight2016Entity>of(Hellknight2016Entity::new, EntityClassification.MONSTER)
					.sized(1.8F, 3.0F).clientTrackingRange(9).fireImmune()
					.build(new ResourceLocation(DoomMod.MODID, "dreadknight").toString()));

	public static final RegistryObject<EntityType<CyberdemonEntity>> CYBERDEMON = ENTITY_TYPES.register("cyberdemon",
			() -> EntityType.Builder.of(CyberdemonEntity::new, EntityClassification.MONSTER).sized(3.0f, 7.0F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "cyberdemon").toString()));

	public static final RegistryObject<EntityType<Cyberdemon2016Entity>> CYBERDEMON2016 = ENTITY_TYPES.register(
			"cyberdemon2016",
			() -> EntityType.Builder.of(Cyberdemon2016Entity::new, EntityClassification.MONSTER).sized(3.0f, 7.0F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "cyberdemon2016").toString()));

	public static final RegistryObject<EntityType<Cyberdemon2016Entity>> TYRANT = ENTITY_TYPES.register("tyrant",
			() -> EntityType.Builder.of(Cyberdemon2016Entity::new, EntityClassification.MONSTER).sized(3.0f, 7.0F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "tyrant").toString()));

	public static final RegistryObject<EntityType<UnwillingEntity>> UNWILLING = ENTITY_TYPES.register("unwilling",
			() -> EntityType.Builder.of(UnwillingEntity::new, EntityClassification.MONSTER).sized(0.6f, 1.95F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "unwilling").toString()));

	public static final RegistryObject<EntityType<PossessedSoldierEntity>> POSSESSEDSOLDIER = ENTITY_TYPES.register(
			"possessed_soldier",
			() -> EntityType.Builder.of(PossessedSoldierEntity::new, EntityClassification.MONSTER).sized(0.9f, 2.35F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "possessed_soldier").toString()));

	public static final RegistryObject<EntityType<GoreNestEntity>> GORE_NEST = ENTITY_TYPES.register("gore_nest",
			() -> EntityType.Builder.of(GoreNestEntity::new, EntityClassification.MONSTER).sized(3.0f, 4.0F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "gore_nest").toString()));

	public static final RegistryObject<EntityType<PossessedScientistEntity>> POSSESSEDSCIENTIST = ENTITY_TYPES.register(
			"possessed_scientist",
			() -> EntityType.Builder.of(PossessedScientistEntity::new, EntityClassification.MONSTER).sized(1.5f, 1.95F)
					.clientTrackingRange(9).fireImmune()
					.build(new ResourceLocation(DoomMod.MODID, "possessed_scientist").toString()));

	public static final RegistryObject<EntityType<PossessedScientistEntity>> POSSESSEDWORKER = ENTITY_TYPES.register(
			"possessed_worker",
			() -> EntityType.Builder.of(PossessedScientistEntity::new, EntityClassification.MONSTER).sized(1.5f, 1.95F)
					.clientTrackingRange(9).fireImmune()
					.build(new ResourceLocation(DoomMod.MODID, "possessed_worker").toString()));

	public static final RegistryObject<EntityType<CueBallEntity>> CUEBALL = ENTITY_TYPES.register("cueball",
			() -> EntityType.Builder.of(CueBallEntity::new, EntityClassification.MONSTER).sized(1.1F, 2.1F)
					.clientTrackingRange(9).fireImmune()
					.build(new ResourceLocation(DoomMod.MODID, "cueball").toString()));

	public static final RegistryObject<EntityType<MechaZombieEntity>> MECHAZOMBIE = ENTITY_TYPES.register("mechazombie",
			() -> EntityType.Builder.of(MechaZombieEntity::new, EntityClassification.MONSTER).sized(1.2f, 2.3F)
					.clientTrackingRange(9).fireImmune()
					.build(new ResourceLocation(DoomMod.MODID, "mechazombie").toString()));

	public static final RegistryObject<EntityType<ProwlerEntity>> PROWLER = ENTITY_TYPES.register("prowler",
			() -> EntityType.Builder.of(ProwlerEntity::new, EntityClassification.MONSTER).sized(1.2f, 2.3F)
					.clientTrackingRange(9).fireImmune()
					.build(new ResourceLocation(DoomMod.MODID, "prowler").toString()));

	public static final RegistryObject<EntityType<IconofsinEntity>> ICONOFSIN = ENTITY_TYPES.register("iconofsin",
			() -> EntityType.Builder.of(IconofsinEntity::new, EntityClassification.MONSTER).sized(6.3f, 20.0F)
					.clientTrackingRange(9).fireImmune()
					.build(new ResourceLocation(DoomMod.MODID, "iconofsin").toString()));

	public static final RegistryObject<EntityType<EnergyCellMobEntity>> ENERGY_CELL_MOB = ENTITY_TYPES.register(
			"energy_cell_mob",
			() -> EntityType.Builder.<EnergyCellMobEntity>of(EnergyCellMobEntity::new, EntityClassification.MISC)
					.clientTrackingRange(9).sized(0.5F, 0.5F)
					.build(new ResourceLocation(DoomMod.MODID, "energy_cell_mob").toString()));

	public static final RegistryObject<EntityType<RocketMobEntity>> ROCKET_MOB = ENTITY_TYPES.register("rocket_mob",
			() -> EntityType.Builder.<RocketMobEntity>of(RocketMobEntity::new, EntityClassification.MISC)
					.sized(0.5F, 0.5F).clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "rocket_mob").toString()));

	public static final RegistryObject<EntityType<ChaingunMobEntity>> CHAINGUN_MOB = ENTITY_TYPES.register(
			"chaingun_mob",
			() -> EntityType.Builder.<ChaingunMobEntity>of(ChaingunMobEntity::new, EntityClassification.MISC)
					.sized(0.5F, 0.5F).clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "chaingun_mob").toString()));

	public static final RegistryObject<EntityType<GargoyleEntity>> GARGOYLE = ENTITY_TYPES.register("gargoyle",
			() -> EntityType.Builder.of(GargoyleEntity::new, EntityClassification.MONSTER).sized(1.3f, 2.25F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "gargoyle").toString()));

	public static final RegistryObject<EntityType<DoomHunterEntity>> DOOMHUNTER = ENTITY_TYPES.register("doom_hunter",
			() -> EntityType.Builder.of(DoomHunterEntity::new, EntityClassification.MONSTER).sized(3.0f, 7.0F)
					.fireImmune().clientTrackingRange(9)
					.build(new ResourceLocation(DoomMod.MODID, "doom_hunter").toString()));

//	public static final RegistryObject<EntityType<PinkyEntity>> PINKY2016 = ENTITY_TYPES.register("pinky2016",
//			() -> EntityType.Builder.of(PinkyEntity::new, EntityClassification.MONSTER).sized(1.7f, 2.2F)
//					.fireImmune().clientTrackingRange(9).build(new ResourceLocation(DoomMod.MODID, "pinky2016").toString()));

//	public static final RegistryObject<EntityType<WhiplashEntity>> WHIPLASH = ENTITY_TYPES.register("whiplash",
//			() -> EntityType.Builder.of(WhiplashEntity::new, EntityClassification.MONSTER).sized(1.7f, 2.2F)
//					.fireImmune().clientTrackingRange(9).build(new ResourceLocation(DoomMod.MODID, "whiplash").toString()));

//	public static final RegistryObject<EntityType<BaronEntity>> BARON2016 = ENTITY_TYPES.register("baron2016",
//			() -> EntityType.Builder.of(BaronEntity::new, EntityClassification.MONSTER).sized(1.7f, 2.2F)
//					.fireImmune().clientTrackingRange(9).build(new ResourceLocation(DoomMod.MODID, "baron2016").toString()));

//	public static final RegistryObject<EntityType<FireBaronEntity>> FIREBARON = ENTITY_TYPES.register("baron2016",
//			() -> EntityType.Builder.of(FireBaronEntity::new, EntityClassification.MONSTER).sized(1.7f, 2.2F)
//					.fireImmune().clientTrackingRange(9).build(new ResourceLocation(DoomMod.MODID, "baron2016").toString()));

//	public static final RegistryObject<EntityType<ArmorBaronEntity>> ARMORBARON = ENTITY_TYPES.register("armoredbaron",
//			() -> EntityType.Builder.of(ArmorBaronEntity::new, EntityClassification.MONSTER).sized(1.7f, 2.2F)
//					.fireImmune().clientTrackingRange(9).build(new ResourceLocation(DoomMod.MODID, "armoredbaron").toString()));

//	public static final RegistryObject<EntityType<MaykrDroneEntity>> MAYKRDRONE = ENTITY_TYPES.register("maykr_drone",
//			() -> EntityType.Builder.of(MaykrDroneEntity::new, EntityClassification.MONSTER).sized(1.7f, 2.2F)
//					.fireImmune().clientTrackingRange(9).build(new ResourceLocation(DoomMod.MODID, "maykr_drone").toString()));

//	public static final RegistryObject<EntityType<BloodMaykrEntity>> BLOODMAYKR = ENTITY_TYPES.register("blood_maykr",
//			() -> EntityType.Builder.of(BloodMaykrEntity::new, EntityClassification.MONSTER).sized(1.7f, 2.2F)
//					.fireImmune().clientTrackingRange(9).build(new ResourceLocation(DoomMod.MODID, "blood_maykr").toString()));

//	public static final RegistryObject<EntityType<KhanMakyrEntity>> KHANMAKER = ENTITY_TYPES.register("khan_maykr",
//			() -> EntityType.Builder.of(KhanMakyrEntity::new, EntityClassification.MONSTER).sized(1.7f, 2.2F)
//					.fireImmune().clientTrackingRange(9).build(new ResourceLocation(DoomMod.MODID, "khan_maykr").toString()));

}