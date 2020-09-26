package mod.azure.doomweapon.util.registry;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.item.ArgentEnergyItem;
import mod.azure.doomweapon.item.ArgentPlateItem;
import mod.azure.doomweapon.item.DaisyItem;
import mod.azure.doomweapon.item.E1M1MusicDisc;
import mod.azure.doomweapon.item.UnopenedItem;
import mod.azure.doomweapon.item.ammo.ArgentBolt;
import mod.azure.doomweapon.item.ammo.BFGCell;
import mod.azure.doomweapon.item.ammo.ChaingunAmmo;
import mod.azure.doomweapon.item.ammo.ClipAmmo;
import mod.azure.doomweapon.item.ammo.EnergyCell;
import mod.azure.doomweapon.item.ammo.Rocket;
import mod.azure.doomweapon.item.ammo.ShellAmmo;
import mod.azure.doomweapon.item.ammo.UnmaykrBolt;
import mod.azure.doomweapon.item.armor.AstroDoomArmor;
import mod.azure.doomweapon.item.armor.ClassicDoomArmor;
import mod.azure.doomweapon.item.armor.CrimsonDoomArmor;
import mod.azure.doomweapon.item.armor.CultistDoomArmor;
import mod.azure.doomweapon.item.armor.DemonicDoomArmor;
import mod.azure.doomweapon.item.armor.DoomArmor;
import mod.azure.doomweapon.item.armor.DoomicornDoomArmor;
import mod.azure.doomweapon.item.armor.EmberDoomArmor;
import mod.azure.doomweapon.item.armor.GoldDoomArmor;
import mod.azure.doomweapon.item.armor.MaykrDoomArmor;
import mod.azure.doomweapon.item.armor.MidnightDoomArmor;
import mod.azure.doomweapon.item.armor.MulletDoomArmor;
import mod.azure.doomweapon.item.armor.NightmareDoomArmor;
import mod.azure.doomweapon.item.armor.PainterDoomArmor;
import mod.azure.doomweapon.item.armor.PhobosDoomArmor;
import mod.azure.doomweapon.item.armor.PraetorDoomArmor;
import mod.azure.doomweapon.item.armor.PurplePonyDoomArmor;
import mod.azure.doomweapon.item.armor.SentinelDoomArmor;
import mod.azure.doomweapon.item.armor.ZombieDoomArmor;
import mod.azure.doomweapon.item.eggs.DoomSpawnEgg;
import mod.azure.doomweapon.item.powerup.InmortalSphereItem;
import mod.azure.doomweapon.item.powerup.InvisibleSphereItem;
import mod.azure.doomweapon.item.powerup.MegaSphereItem;
import mod.azure.doomweapon.item.powerup.PowerSphereItem;
import mod.azure.doomweapon.item.powerup.SoulCubeItem;
import mod.azure.doomweapon.item.tools.ArgentAxe;
import mod.azure.doomweapon.item.tools.ArgentHoe;
import mod.azure.doomweapon.item.tools.ArgentPaxel;
import mod.azure.doomweapon.item.tools.ArgentPickaxe;
import mod.azure.doomweapon.item.tools.ArgentShovel;
import mod.azure.doomweapon.item.weapons.ArgentSword;
import mod.azure.doomweapon.item.weapons.AxeMarauderItem;
import mod.azure.doomweapon.item.weapons.BFG;
import mod.azure.doomweapon.item.weapons.Ballista;
import mod.azure.doomweapon.item.weapons.Chaingun;
import mod.azure.doomweapon.item.weapons.Chainsaw;
import mod.azure.doomweapon.item.weapons.DoomBlade;
import mod.azure.doomweapon.item.weapons.PistolItem;
import mod.azure.doomweapon.item.weapons.PlasmaGun;
import mod.azure.doomweapon.item.weapons.RocketLauncher;
import mod.azure.doomweapon.item.weapons.Shotgun;
import mod.azure.doomweapon.item.weapons.SuperShotgun;
import mod.azure.doomweapon.item.weapons.SwordCrucibleItem;
import mod.azure.doomweapon.item.weapons.Unmaykr;
import mod.azure.doomweapon.util.enums.DoomArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DoomItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DoomMod.MODID);

	public static final RegistryObject<Item> ITEM = ITEMS.register("barrel",
			() -> new BlockItem(DoomBlocks.BARREL_BLOCK.get(),
					new Item.Properties().group(DoomMod.DoomBlockItemGroup)));

	public static final RegistryObject<Item> ARGENT_BLOCK = ITEMS.register("argent_block",
			() -> new BlockItem(DoomBlocks.ARGENT_BLOCK.get(),
					new Item.Properties().group(DoomMod.DoomBlockItemGroup)));

	public static final RegistryObject<Item> DOOM_SAND = ITEMS.register("doom_sand",
			() -> new BlockItem(DoomBlocks.DOOM_SAND.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));

	public static final RegistryObject<Item> ARGENT_LAMP_BLOCK = ITEMS.register("argent_lamp_block",
			() -> new BlockItem(DoomBlocks.ARGENT_LAMP_BLOCK.get(),
					new Item.Properties().group(DoomMod.DoomBlockItemGroup)));

	public static final RegistryObject<Item> DOOM_WALL1 = ITEMS.register("icon_wall1",
			() -> new BlockItem(DoomBlocks.DOOM_WALL1.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));
	public static final RegistryObject<Item> DOOM_WALL2 = ITEMS.register("icon_wall2",
			() -> new BlockItem(DoomBlocks.DOOM_WALL2.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));
	public static final RegistryObject<Item> DOOM_WALL3 = ITEMS.register("icon_wall3",
			() -> new BlockItem(DoomBlocks.DOOM_WALL3.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));
	public static final RegistryObject<Item> DOOM_WALL4 = ITEMS.register("icon_wall4",
			() -> new BlockItem(DoomBlocks.DOOM_WALL4.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));
	public static final RegistryObject<Item> DOOM_WALL5 = ITEMS.register("icon_wall5",
			() -> new BlockItem(DoomBlocks.DOOM_WALL5.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));
	public static final RegistryObject<Item> DOOM_WALL6 = ITEMS.register("icon_wall6",
			() -> new BlockItem(DoomBlocks.DOOM_WALL6.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));
	public static final RegistryObject<Item> DOOM_WALL7 = ITEMS.register("icon_wall7",
			() -> new BlockItem(DoomBlocks.DOOM_WALL7.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));
	public static final RegistryObject<Item> DOOM_WALL8 = ITEMS.register("icon_wall8",
			() -> new BlockItem(DoomBlocks.DOOM_WALL8.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));
	public static final RegistryObject<Item> DOOM_WALL9 = ITEMS.register("icon_wall9",
			() -> new BlockItem(DoomBlocks.DOOM_WALL9.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));
	public static final RegistryObject<Item> DOOM_WALL10 = ITEMS.register("icon_wall10",
			() -> new BlockItem(DoomBlocks.DOOM_WALL10.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));
	public static final RegistryObject<Item> DOOM_WALL11 = ITEMS.register("icon_wall11",
			() -> new BlockItem(DoomBlocks.DOOM_WALL11.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));
	public static final RegistryObject<Item> DOOM_WALL12 = ITEMS.register("icon_wall12",
			() -> new BlockItem(DoomBlocks.DOOM_WALL12.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));
	public static final RegistryObject<Item> DOOM_WALL13 = ITEMS.register("icon_wall13",
			() -> new BlockItem(DoomBlocks.DOOM_WALL13.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));
	public static final RegistryObject<Item> DOOM_WALL14 = ITEMS.register("icon_wall14",
			() -> new BlockItem(DoomBlocks.DOOM_WALL14.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));
	public static final RegistryObject<Item> DOOM_WALL15 = ITEMS.register("icon_wall15",
			() -> new BlockItem(DoomBlocks.DOOM_WALL15.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));
	public static final RegistryObject<Item> DOOM_WALL16 = ITEMS.register("icon_wall16",
			() -> new BlockItem(DoomBlocks.DOOM_WALL16.get(), new Item.Properties().group(DoomMod.DoomBlockItemGroup)));

	// AMMO
	public static final RegistryObject<Item> SHOTGUN_SHELLS = ITEMS.register("shotgun_shells",
			() -> new ShellAmmo(new Item.Properties().group(DoomMod.DoomWeaponItemGroup), 2.0F));
	public static final RegistryObject<Item> ARGENT_BOLT = ITEMS.register("argent_bolt",
			() -> new ArgentBolt(new Item.Properties().group(DoomMod.DoomWeaponItemGroup), 2.7F));
	public static final RegistryObject<Item> UNMAKRY_BOLT = ITEMS.register("unmaykr_bolt",
			() -> new UnmaykrBolt(10.7F));
	public static final RegistryObject<Item> ENERGY_CELLS = ITEMS.register("energy_cells",
			() -> new EnergyCell(new Item.Properties().group(DoomMod.DoomWeaponItemGroup), 10.0F));
	public static final RegistryObject<Item> CHAINGUN_BULLETS = ITEMS.register("chaingunbullets",
			() -> new ChaingunAmmo(new Item.Properties().group(DoomMod.DoomWeaponItemGroup), 10.0F));
	public static final RegistryObject<Item> BULLETS = ITEMS.register("bullets",
			() -> new ClipAmmo(new Item.Properties().group(DoomMod.DoomWeaponItemGroup), 1.2F));
	public static final RegistryObject<Item> BFG_CELL = ITEMS.register("bfg_cell",
			() -> new BFGCell(new Item.Properties().group(DoomMod.DoomWeaponItemGroup), 1.2F));
	public static final RegistryObject<Item> ROCKET = ITEMS.register("rocket",
			() -> new Rocket(new Item.Properties().group(DoomMod.DoomWeaponItemGroup), 1.2F));
	// MISC
	public static final RegistryObject<Item> ARGENT_ENERGY = ITEMS.register("argent_energy",
			() -> new ArgentEnergyItem());
	public static final RegistryObject<Item> ARGENT_PLATE = ITEMS.register("argent_plate", () -> new ArgentPlateItem());
	public static final RegistryObject<Item> DAISY = ITEMS.register("daisy", () -> new DaisyItem());
	public static final RegistryObject<Item> E1M1_MUSIC_DISC = ITEMS.register("e1m1_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E1M1));
	public static final RegistryObject<Item> E1M2_MUSIC_DISC = ITEMS.register("e1m2_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E1M2));
	public static final RegistryObject<Item> E1M3_MUSIC_DISC = ITEMS.register("e1m3_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E1M3));
	public static final RegistryObject<Item> E1M4_MUSIC_DISC = ITEMS.register("e1m4_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E1M4));
	public static final RegistryObject<Item> E1M5_MUSIC_DISC = ITEMS.register("e1m5_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E1M5));
	public static final RegistryObject<Item> E1M6_MUSIC_DISC = ITEMS.register("e1m6_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E1M6));
	public static final RegistryObject<Item> E1M7_MUSIC_DISC = ITEMS.register("e1m7_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E1M7));
	public static final RegistryObject<Item> E1M8_MUSIC_DISC = ITEMS.register("e1m8_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E1M8));
	public static final RegistryObject<Item> E1M9_MUSIC_DISC = ITEMS.register("e1m9_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E1M9));
	public static final RegistryObject<Item> E2M1_MUSIC_DISC = ITEMS.register("e2m1_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E2M1));
	public static final RegistryObject<Item> E2M2_MUSIC_DISC = ITEMS.register("e2m2_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E2M2));
	public static final RegistryObject<Item> E2M3_MUSIC_DISC = ITEMS.register("e2m3_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E2M3));
	public static final RegistryObject<Item> E2M4_MUSIC_DISC = ITEMS.register("e2m4_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E2M4));
	public static final RegistryObject<Item> E2M5_MUSIC_DISC = ITEMS.register("e2m5_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E2M5));
	public static final RegistryObject<Item> E2M6_MUSIC_DISC = ITEMS.register("e2m6_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E2M6));
	public static final RegistryObject<Item> E2M7_MUSIC_DISC = ITEMS.register("e2m7_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E2M7));
	public static final RegistryObject<Item> E2M8_MUSIC_DISC = ITEMS.register("e2m8_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E2M8));
	public static final RegistryObject<Item> E2M9_MUSIC_DISC = ITEMS.register("e2m9_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E2M9));
	public static final RegistryObject<Item> E3M1_MUSIC_DISC = ITEMS.register("e3m1_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E3M1));
	public static final RegistryObject<Item> E3M2_MUSIC_DISC = ITEMS.register("e3m2_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E3M2));
	public static final RegistryObject<Item> E3M3_MUSIC_DISC = ITEMS.register("e3m3_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E3M3));
	public static final RegistryObject<Item> E3M4_MUSIC_DISC = ITEMS.register("e3m4_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E3M4));
	public static final RegistryObject<Item> E3M5_MUSIC_DISC = ITEMS.register("e3m5_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E3M5));
	public static final RegistryObject<Item> E3M6_MUSIC_DISC = ITEMS.register("e3m6_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E3M6));
	public static final RegistryObject<Item> E3M7_MUSIC_DISC = ITEMS.register("e3m7_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E3M7));
	public static final RegistryObject<Item> E3M8_MUSIC_DISC = ITEMS.register("e3m8_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E3M8));
	public static final RegistryObject<Item> E3M9_MUSIC_DISC = ITEMS.register("e3m9_music_disc",
			() -> new E1M1MusicDisc(ModSoundEvents.E3M9));
	public static final RegistryObject<Item> INMORTAL = ITEMS.register("inmortalsphere",
			() -> new InmortalSphereItem());
	public static final RegistryObject<Item> INVISIBLE = ITEMS.register("invisiblesphere",
			() -> new InvisibleSphereItem());
	public static final RegistryObject<Item> MEGA = ITEMS.register("megasphere", () -> new MegaSphereItem());
	public static final RegistryObject<Item> POWER = ITEMS.register("powersphere", () -> new PowerSphereItem());
	public static final RegistryObject<Item> SOULCUBE = ITEMS.register("soulcube", () -> new SoulCubeItem());
	public static final RegistryObject<Item> IMP_SPAWN_EGG = ITEMS.register("imp_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.IMP, 11022961, 11035249));
	public static final RegistryObject<Item> ARACHNOTRON_SPAWN_EGG = ITEMS.register("arachnotron_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.ARACHNOTRON, 11022961, 11035249));
	public static final RegistryObject<Item> LOST_SOUL_SPAWN_EGG = ITEMS.register("lost_soul_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.LOST_SOUL, 11022961, 11035249));
	public static final RegistryObject<Item> NIGHTMAREIMP_SPAWN_EGG = ITEMS.register("nightmare_imp_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.NIGHTMARE_IMP, 11022961, 11035249));
	public static final RegistryObject<Item> PINKY_SPAWN_EGG = ITEMS.register("pinky_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.PINKY, 11022961, 11035249));
	public static final RegistryObject<Item> ARCHVILE_SPAWN_EGG = ITEMS.register("archvile_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.ARCHVILE, 11022961, 11035249));
	public static final RegistryObject<Item> BARON_SPAWN_EGG = ITEMS.register("baron_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.BARON, 11022961, 11035249));
	public static final RegistryObject<Item> CACODEMON_SPAWN_EGG = ITEMS.register("cacodemon_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.CACODEMON, 11022961, 11035249));
	public static final RegistryObject<Item> MANCUBUS_SPAWN_EGG = ITEMS.register("mancubus_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.MANCUBUS, 11022961, 11035249));
	public static final RegistryObject<Item> SPIDERDEMON_SPAWN_EGG = ITEMS.register("spiderdemon_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.SPIDERDEMON, 11022961, 11035249));
	public static final RegistryObject<Item> ZOMBIEMAN_SPAWN_EGG = ITEMS.register("zombieman_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.ZOMBIEMAN, 11022961, 11035249));
	public static final RegistryObject<Item> CHAINGUNNER_SPAWN_EGG = ITEMS.register("chaingunner_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.CHAINGUNNER, 11022961, 11035249));
	public static final RegistryObject<Item> HELLKNIGHT_SPAWN_EGG = ITEMS.register("hellknight_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.HELLKNIGHT, 11022961, 11035249));
	public static final RegistryObject<Item> IMP2016_SPAWN_EGG = ITEMS.register("imp2016_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.IMP2016, 11022961, 11035249));
	public static final RegistryObject<Item> MARAUDER_SPAWN_EGG = ITEMS.register("marauder_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.MARAUDER, 11022961, 11035249));
	public static final RegistryObject<Item> PAIN_SPAWN_EGG = ITEMS.register("pain_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.PAIN, 11022961, 11035249));
	public static final RegistryObject<Item> REVENANT_SPAWN_EGG = ITEMS.register("revenant_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.REVENANT, 11022961, 11035249));
	public static final RegistryObject<Item> SHOTGUNGUY_SPAWN_EGG = ITEMS.register("shotgunguy_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.SHOTGUNGUY, 11022961, 11035249));
	public static final RegistryObject<Item> CYBERDEMON_SPAWN_EGG = ITEMS.register("cyberdemon_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.CYBERDEMON, 11022961, 11035249));
	public static final RegistryObject<Item> CYBERDEMON2016_SPAWN_EGG = ITEMS.register("cyberdemon2016_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.CYBERDEMON2016, 11022961, 11035249));
	public static final RegistryObject<Item> ICON_SPAWN_EGG = ITEMS.register("icon_of_sin_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.ICONOFSIN, 11022961, 11035249));
	public static final RegistryObject<Item> UNWILLING_SPAWN_EGG = ITEMS.register("unwilling_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.UNWILLING, 11022961, 11035249));
	public static final RegistryObject<Item> POSSESSED_SCIENTIST_SPAWN_EGG = ITEMS.register(
			"possessed_scientist_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.POSSESSEDSCIENTIST, 11022961, 11035249));
	public static final RegistryObject<Item> POSSESSED_SOLDIER_SPAWN_EGG = ITEMS.register("possessed_soldier_spawn_egg",
			() -> new DoomSpawnEgg(ModEntityTypes.POSSESSEDSOLDIER, 11022961, 11035249));
	// WEAPONS AND TOOLS
	public static final RegistryObject<Item> CRUCIBLESWORD = ITEMS.register("cruciblesword",
			() -> new SwordCrucibleItem());
	public static final RegistryObject<Item> ARGENT_AXE = ITEMS.register("argent_axe", () -> new ArgentAxe());
	public static final RegistryObject<Item> ARGENT_HOE = ITEMS.register("argent_hoe", () -> new ArgentHoe());
	public static final RegistryObject<Item> ARGENT_PAXEL = ITEMS.register("argent_paxel", () -> new ArgentPaxel());
	public static final RegistryObject<Item> ARGENT_PICKAXE = ITEMS.register("argent_pickaxe",
			() -> new ArgentPickaxe());
	public static final RegistryObject<Item> ARGENT_SHOVEL = ITEMS.register("argent_shovel", () -> new ArgentShovel());
	public static final RegistryObject<Item> ARGENT_SWORD = ITEMS.register("argent_sword", () -> new ArgentSword());
	public static final RegistryObject<Item> DOOM_BLADE = ITEMS.register("doomblade", () -> new DoomBlade());
	public static final RegistryObject<Item> CHAINSAW = ITEMS.register("chainsaw", () -> new Chainsaw());
	public static final RegistryObject<Item> SWORD_CLOSED = ITEMS.register("cruciblesword_closed",
			() -> new UnopenedItem());
	public static final RegistryObject<Item> AXE_OPEN = ITEMS.register("axe_marauder_open",
			() -> new AxeMarauderItem());
	public static final RegistryObject<Item> AXE_CLOSED = ITEMS.register("axe_marauder_closed",
			() -> new UnopenedItem());
	public static final RegistryObject<Item> SSG = ITEMS.register("supershotgun", () -> new SuperShotgun());
	public static final RegistryObject<Item> SG = ITEMS.register("shotgun", () -> new Shotgun());
	public static final RegistryObject<Item> BFG = ITEMS.register("bfg9000", () -> new BFG());
	public static final RegistryObject<Item> BFG_ETERNAL = ITEMS.register("bfg_eternal", () -> new BFG());
	public static final RegistryObject<Item> PLASMAGUN = ITEMS.register("plasmagun", () -> new PlasmaGun());
	public static final RegistryObject<Item> ROCKETLAUNCHER = ITEMS.register("rocketlauncher",
			() -> new RocketLauncher());
	public static final RegistryObject<Item> UNMAYKR = ITEMS.register("unmaykr", () -> new Unmaykr());
	public static final RegistryObject<Item> BALLISTA = ITEMS.register("ballista", () -> new Ballista());
	public static final RegistryObject<Item> CHAINGUN = ITEMS.register("chaingun", () -> new Chaingun());
	public static final RegistryObject<Item> PISTOL = ITEMS.register("pistol", () -> new PistolItem());
	// ARMOR
	public static final RegistryObject<Item> DOOM_HELMET = ITEMS.register("doom_helmet",
			() -> new DoomArmor(DoomArmorMaterial.DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> DOOM_CHESTPLATE = ITEMS.register("doom_chestplate",
			() -> new DoomArmor(DoomArmorMaterial.DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> DOOM_LEGGINGS = ITEMS.register("doom_leggings",
			() -> new DoomArmor(DoomArmorMaterial.DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> DOOM_BOOTS = ITEMS.register("doom_boots",
			() -> new DoomArmor(DoomArmorMaterial.DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> PRAETOR_DOOM_HELMET = ITEMS.register("praetor_doom_helmet",
			() -> new PraetorDoomArmor(DoomArmorMaterial.PRAETOR_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> PRAETOR_DOOM_CHESTPLATE = ITEMS.register("praetor_doom_chestplate",
			() -> new PraetorDoomArmor(DoomArmorMaterial.PRAETOR_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> PRAETOR_DOOM_LEGGINGS = ITEMS.register("praetor_doom_leggings",
			() -> new PraetorDoomArmor(DoomArmorMaterial.PRAETOR_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> PRAETOR_DOOM_BOOTS = ITEMS.register("praetor_doom_boots",
			() -> new PraetorDoomArmor(DoomArmorMaterial.PRAETOR_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> ASTRO_DOOM_HELMET = ITEMS.register("astro_doom_helmet",
			() -> new AstroDoomArmor(DoomArmorMaterial.ASTRO_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> ASTRO_DOOM_CHESTPLATE = ITEMS.register("astro_doom_chestplate",
			() -> new AstroDoomArmor(DoomArmorMaterial.ASTRO_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> ASTRO_DOOM_LEGGINGS = ITEMS.register("astro_doom_leggings",
			() -> new AstroDoomArmor(DoomArmorMaterial.ASTRO_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> ASTRO_DOOM_BOOTS = ITEMS.register("astro_doom_boots",
			() -> new AstroDoomArmor(DoomArmorMaterial.ASTRO_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> CRIMSON_DOOM_HELMET = ITEMS.register("crimson_doom_helmet",
			() -> new CrimsonDoomArmor(DoomArmorMaterial.CRIMSON_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> CRIMSON_DOOM_CHESTPLATE = ITEMS.register("crimson_doom_chestplate",
			() -> new CrimsonDoomArmor(DoomArmorMaterial.CRIMSON_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> CRIMSON_DOOM_LEGGINGS = ITEMS.register("crimson_doom_leggings",
			() -> new CrimsonDoomArmor(DoomArmorMaterial.CRIMSON_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> CRIMSON_DOOM_BOOTS = ITEMS.register("crimson_doom_boots",
			() -> new CrimsonDoomArmor(DoomArmorMaterial.CRIMSON_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> MIDNIGHT_DOOM_HELMET = ITEMS.register("midnight_doom_helmet",
			() -> new MidnightDoomArmor(DoomArmorMaterial.MIDNIGHT_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> MIDNIGHT_DOOM_CHESTPLATE = ITEMS.register("midnight_doom_chestplate",
			() -> new MidnightDoomArmor(DoomArmorMaterial.MIDNIGHT_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> MIDNIGHT_DOOM_LEGGINGS = ITEMS.register("midnight_doom_leggings",
			() -> new MidnightDoomArmor(DoomArmorMaterial.MIDNIGHT_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> MIDNIGHT_DOOM_BOOTS = ITEMS.register("midnight_doom_boots",
			() -> new MidnightDoomArmor(DoomArmorMaterial.MIDNIGHT_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> DEMONCIDE_DOOM_HELMET = ITEMS.register("demoncide_doom_helmet",
			() -> new DemonicDoomArmor(DoomArmorMaterial.DEMONCIDE_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> DEMONCIDE_DOOM_CHESTPLATE = ITEMS.register("demoncide_doom_chestplate",
			() -> new DemonicDoomArmor(DoomArmorMaterial.DEMONCIDE_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> DEMONCIDE_DOOM_LEGGINGS = ITEMS.register("demoncide_doom_leggings",
			() -> new DemonicDoomArmor(DoomArmorMaterial.DEMONCIDE_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> DEMONCIDE_DOOM_BOOTS = ITEMS.register("demoncide_doom_boots",
			() -> new DemonicDoomArmor(DoomArmorMaterial.DEMONCIDE_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> DEMONIC_DOOM_HELMET = ITEMS.register("demonic_doom_helmet",
			() -> new DemonicDoomArmor(DoomArmorMaterial.DEMONIC_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> DEMONIC_DOOM_CHESTPLATE = ITEMS.register("demonic_doom_chestplate",
			() -> new DemonicDoomArmor(DoomArmorMaterial.DEMONIC_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> DEMONIC_DOOM_LEGGINGS = ITEMS.register("demonic_doom_leggings",
			() -> new DemonicDoomArmor(DoomArmorMaterial.DEMONIC_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> DEMONIC_DOOM_BOOTS = ITEMS.register("demonic_doom_boots",
			() -> new DemonicDoomArmor(DoomArmorMaterial.DEMONIC_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> SENTINEL_DOOM_HELMET = ITEMS.register("sentinel_doom_helmet",
			() -> new SentinelDoomArmor(DoomArmorMaterial.SENTINEL_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> SENTINEL_DOOM_CHESTPLATE = ITEMS.register("sentinel_doom_chestplate",
			() -> new SentinelDoomArmor(DoomArmorMaterial.SENTINEL_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> SENTINEL_DOOM_LEGGINGS = ITEMS.register("sentinel_doom_leggings",
			() -> new SentinelDoomArmor(DoomArmorMaterial.SENTINEL_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> SENTINEL_DOOM_BOOTS = ITEMS.register("sentinel_doom_boots",
			() -> new SentinelDoomArmor(DoomArmorMaterial.SENTINEL_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> EMBER_DOOM_HELMET = ITEMS.register("ember_doom_helmet",
			() -> new EmberDoomArmor(DoomArmorMaterial.EMBER_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> EMBER_DOOM_CHESTPLATE = ITEMS.register("ember_doom_chestplate",
			() -> new EmberDoomArmor(DoomArmorMaterial.EMBER_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> EMBER_DOOM_LEGGINGS = ITEMS.register("ember_doom_leggings",
			() -> new EmberDoomArmor(DoomArmorMaterial.EMBER_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> EMBER_DOOM_BOOTS = ITEMS.register("ember_doom_boots",
			() -> new EmberDoomArmor(DoomArmorMaterial.EMBER_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> ZOMBIE_DOOM_HELMET = ITEMS.register("zombie_doom_helmet",
			() -> new ZombieDoomArmor(DoomArmorMaterial.ZOMBIE_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> ZOMBIE_DOOM_CHESTPLATE = ITEMS.register("zombie_doom_chestplate",
			() -> new ZombieDoomArmor(DoomArmorMaterial.ZOMBIE_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> ZOMBIE_DOOM_LEGGINGS = ITEMS.register("zombie_doom_leggings",
			() -> new ZombieDoomArmor(DoomArmorMaterial.ZOMBIE_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> ZOMBIE_DOOM_BOOTS = ITEMS.register("zombie_doom_boots",
			() -> new ZombieDoomArmor(DoomArmorMaterial.ZOMBIE_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> PHOBOS_DOOM_HELMET = ITEMS.register("phobos_doom_helmet",
			() -> new PhobosDoomArmor(DoomArmorMaterial.PHOBOS_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> PHOBOS_DOOM_CHESTPLATE = ITEMS.register("phobos_doom_chestplate",
			() -> new PhobosDoomArmor(DoomArmorMaterial.PHOBOS_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> PHOBOS_DOOM_LEGGINGS = ITEMS.register("phobos_doom_leggings",
			() -> new PhobosDoomArmor(DoomArmorMaterial.PHOBOS_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> PHOBOS_DOOM_BOOTS = ITEMS.register("phobos_doom_boots",
			() -> new PhobosDoomArmor(DoomArmorMaterial.PHOBOS_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> NIGHTMARE_DOOM_HELMET = ITEMS.register("nightmare_doom_helmet",
			() -> new NightmareDoomArmor(DoomArmorMaterial.NIGHTMARE_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> NIGHTMARE_DOOM_CHESTPLATE = ITEMS.register("nightmare_doom_chestplate",
			() -> new NightmareDoomArmor(DoomArmorMaterial.NIGHTMARE_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> NIGHTMARE_DOOM_LEGGINGS = ITEMS.register("nightmare_doom_leggings",
			() -> new NightmareDoomArmor(DoomArmorMaterial.NIGHTMARE_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> NIGHTMARE_DOOM_BOOTS = ITEMS.register("nightmare_doom_boots",
			() -> new NightmareDoomArmor(DoomArmorMaterial.NIGHTMARE_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> PURPLEPONY_DOOM_HELMET = ITEMS.register("purplepony_doom_helmet",
			() -> new PurplePonyDoomArmor(DoomArmorMaterial.PURPLEPONY_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> PURPLEPONY_DOOM_CHESTPLATE = ITEMS.register("purplepony_doom_chestplate",
			() -> new PurplePonyDoomArmor(DoomArmorMaterial.PURPLEPONY_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> PURPLEPONY_DOOM_LEGGINGS = ITEMS.register("purplepony_doom_leggings",
			() -> new PurplePonyDoomArmor(DoomArmorMaterial.PURPLEPONY_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> PURPLEPONY_DOOM_BOOTS = ITEMS.register("purplepony_doom_boots",
			() -> new PurplePonyDoomArmor(DoomArmorMaterial.PURPLEPONY_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> DOOMICORN_DOOM_HELMET = ITEMS.register("doomicorn_doom_helmet",
			() -> new DoomicornDoomArmor(DoomArmorMaterial.DOOMICORN_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> DOOMICORN_DOOM_CHESTPLATE = ITEMS.register("doomicorn_doom_chestplate",
			() -> new DoomicornDoomArmor(DoomArmorMaterial.DOOMICORN_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> DOOMICORN_DOOM_LEGGINGS = ITEMS.register("doomicorn_doom_leggings",
			() -> new DoomicornDoomArmor(DoomArmorMaterial.DOOMICORN_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> DOOMICORN_DOOM_BOOTS = ITEMS.register("doomicorn_doom_boots",
			() -> new DoomicornDoomArmor(DoomArmorMaterial.DOOMICORN_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> GOLD_DOOM_HELMET = ITEMS.register("gold_doom_helmet",
			() -> new GoldDoomArmor(DoomArmorMaterial.GOLD_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> GOLD_DOOM_CHESTPLATE = ITEMS.register("gold_doom_chestplate",
			() -> new GoldDoomArmor(DoomArmorMaterial.GOLD_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> GOLD_DOOM_LEGGINGS = ITEMS.register("gold_doom_leggings",
			() -> new GoldDoomArmor(DoomArmorMaterial.GOLD_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> GOLD_DOOM_BOOTS = ITEMS.register("gold_doom_boots",
			() -> new GoldDoomArmor(DoomArmorMaterial.GOLD_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> TWENTY_FIVE_DOOM_HELMET = ITEMS.register("twenty_five_helmet",
			() -> new DoomArmor(DoomArmorMaterial.TWENTY_FIVE_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> TWENTY_FIVE_DOOM_CHESTPLATE = ITEMS.register("twenty_five_chestplate",
			() -> new DoomArmor(DoomArmorMaterial.TWENTY_FIVE_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> TWENTY_FIVE_DOOM_LEGGINGS = ITEMS.register("twenty_five_leggings",
			() -> new DoomArmor(DoomArmorMaterial.TWENTY_FIVE_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> TWENTY_FIVE_DOOM_BOOTS = ITEMS.register("twenty_five_boots",
			() -> new DoomArmor(DoomArmorMaterial.TWENTY_FIVE_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> BRONZE_DOOM_HELMET = ITEMS.register("bronze_doom_helmet",
			() -> new DoomArmor(DoomArmorMaterial.BRONZE_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> BRONZE_DOOM_CHESTPLATE = ITEMS.register("bronze_doom_chestplate",
			() -> new DoomArmor(DoomArmorMaterial.BRONZE_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> BRONZE_DOOM_LEGGINGS = ITEMS.register("bronze_doom_leggings",
			() -> new DoomArmor(DoomArmorMaterial.BRONZE_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> BRONZE_DOOM_BOOTS = ITEMS.register("bronze_doom_boots",
			() -> new DoomArmor(DoomArmorMaterial.BRONZE_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> CULTIST_DOOM_HELMET = ITEMS.register("cultist_doom_helmet",
			() -> new CultistDoomArmor(DoomArmorMaterial.CULTIST_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> CULTIST_DOOM_CHESTPLATE = ITEMS.register("cultist_doom_chestplate",
			() -> new CultistDoomArmor(DoomArmorMaterial.CULTIST_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> CULTIST_DOOM_LEGGINGS = ITEMS.register("cultist_doom_leggings",
			() -> new CultistDoomArmor(DoomArmorMaterial.CULTIST_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> CULTIST_DOOM_BOOTS = ITEMS.register("cultist_doom_boots",
			() -> new CultistDoomArmor(DoomArmorMaterial.CULTIST_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> MAYKR_DOOM_HELMET = ITEMS.register("maykr_doom_helmet",
			() -> new MaykrDoomArmor(DoomArmorMaterial.MAYKR_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> MAYKR_DOOM_CHESTPLATE = ITEMS.register("maykr_doom_chestplate",
			() -> new MaykrDoomArmor(DoomArmorMaterial.MAYKR_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> MAYKR_DOOM_LEGGINGS = ITEMS.register("maykr_doom_leggings",
			() -> new MaykrDoomArmor(DoomArmorMaterial.MAYKR_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> MAYKR_DOOM_BOOTS = ITEMS.register("maykr_doom_boots",
			() -> new MaykrDoomArmor(DoomArmorMaterial.MAYKR_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> PAINTER_DOOM_HELMET = ITEMS.register("painter_doom_helmet",
			() -> new PainterDoomArmor(DoomArmorMaterial.PAINTER_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> PAINTER_DOOM_CHESTPLATE = ITEMS.register("painter_doom_chestplate",
			() -> new PainterDoomArmor(DoomArmorMaterial.PAINTER_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> PAINTER_DOOM_LEGGINGS = ITEMS.register("painter_doom_leggings",
			() -> new PainterDoomArmor(DoomArmorMaterial.PAINTER_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> PAINTER_DOOM_BOOTS = ITEMS.register("painter_doom_boots",
			() -> new PainterDoomArmor(DoomArmorMaterial.PAINTER_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> CLASSIC_DOOM_HELMET = ITEMS.register("classic_doom_helmet",
			() -> new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> CLASSIC_DOOM_CHESTPLATE = ITEMS.register("classic_doom_chestplate",
			() -> new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> CLASSIC_DOOM_LEGGINGS = ITEMS.register("classic_doom_leggings",
			() -> new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> CLASSIC_RED_DOOM_CHESTPLATE = ITEMS.register("classic_red_chestplate",
			() -> new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_RED_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> CLASSIC_RED_DOOM_LEGGINGS = ITEMS.register("classic_red_leggings",
			() -> new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_RED_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> CLASSIC_INDIGO_DOOM_CHESTPLATE = ITEMS.register("classic_black_chestplate",
			() -> new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_INDIGO_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> CLASSIC_INDIGO_DOOM_LEGGINGS = ITEMS.register("classic_black_leggings",
			() -> new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_INDIGO_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> CLASSIC_BRONZE_DOOM_CHESTPLATE = ITEMS.register(
			"classic_bronze_chestplate",
			() -> new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_BRONZE_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> CLASSIC_BRONZE_DOOM_LEGGINGS = ITEMS.register("classic_bronze_leggings",
			() -> new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_BRONZE_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> CLASSIC_DOOM_BOOTS = ITEMS.register("classic_doom_boots",
			() -> new ClassicDoomArmor(DoomArmorMaterial.CLASSIC_DOOM_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> MULLET_DOOM_HELMET1 = ITEMS.register("redneck_doom1_helmet",
			() -> new MulletDoomArmor(DoomArmorMaterial.REDNECK1_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> MULLET_DOOM_HELMET2 = ITEMS.register("redneck_doom2_helmet",
			() -> new MulletDoomArmor(DoomArmorMaterial.REDNECK2_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> MULLET_DOOM_HELMET3 = ITEMS.register("redneck_doom3_helmet",
			() -> new MulletDoomArmor(DoomArmorMaterial.REDNECK3_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> MULLET_DOOM_CHESTPLATE1 = ITEMS.register("redneck_doom1_chestplate",
			() -> new MulletDoomArmor(DoomArmorMaterial.REDNECK1_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> MULLET_DOOM_CHESTPLATE2 = ITEMS.register("redneck_doom2_chestplate",
			() -> new MulletDoomArmor(DoomArmorMaterial.REDNECK2_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> MULLET_DOOM_CHESTPLATE3 = ITEMS.register("redneck_doom3_chestplate",
			() -> new MulletDoomArmor(DoomArmorMaterial.REDNECK3_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> MULLET_DOOM_LEGGINGS1 = ITEMS.register("redneck_doom1_leggings",
			() -> new MulletDoomArmor(DoomArmorMaterial.REDNECK1_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> MULLET_DOOM_LEGGINGS2 = ITEMS.register("redneck_doom2_leggings",
			() -> new MulletDoomArmor(DoomArmorMaterial.REDNECK2_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> MULLET_DOOM_LEGGINGS3 = ITEMS.register("redneck_doom3_leggings",
			() -> new MulletDoomArmor(DoomArmorMaterial.REDNECK3_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> MULLET_DOOM_BOOTS1 = ITEMS.register("redneck_doom1_boots",
			() -> new MulletDoomArmor(DoomArmorMaterial.REDNECK1_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> MULLET_DOOM_BOOTS2 = ITEMS.register("redneck_doom2_boots",
			() -> new MulletDoomArmor(DoomArmorMaterial.REDNECK2_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> MULLET_DOOM_BOOTS3 = ITEMS.register("redneck_doom3_boots",
			() -> new MulletDoomArmor(DoomArmorMaterial.REDNECK3_ARMOR, EquipmentSlotType.FEET));
	public static final RegistryObject<Item> HOTROD_HELMET = ITEMS.register("hotrod_helmet",
			() -> new DoomArmor(DoomArmorMaterial.HOTROD_DOOM_ARMOR, EquipmentSlotType.HEAD));
	public static final RegistryObject<Item> HOTROD_CHESTPLATE = ITEMS.register("hotrod_chestplate",
			() -> new DoomArmor(DoomArmorMaterial.HOTROD_DOOM_ARMOR, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> HOTROD_LEGGINGS = ITEMS.register("hotrod_leggings",
			() -> new DoomArmor(DoomArmorMaterial.HOTROD_DOOM_ARMOR, EquipmentSlotType.LEGS));
	public static final RegistryObject<Item> HOTROD_BOOTS = ITEMS.register("hotrod_boots",
			() -> new DoomArmor(DoomArmorMaterial.HOTROD_DOOM_ARMOR, EquipmentSlotType.FEET));
}