package mod.azure.doom.util.config;

public class EntityDefaults {

	public enum EntityConfigType {

		ARACHNOTRON("Arachnotron", new EntityDefaults(false, 4, 100).setMeleeDamage(8).setRangedDamage(4).setGeneralSpeed(0.25)),
		ARCHVILE("Archvile", new EntityDefaults(true, 2, 100).setMeleeDamage(7).setGeneralSpeed(0.25)),
		BARON("Baron", new EntityDefaults(true, 1, 180).setMeleeDamage(15).setGeneralSpeed(0.25).setRangedDamage(6)),
		CACODEMON("Cacodemon", new EntityDefaults(false, 2, 80).setGeneralSpeed(0.25).setRangedDamage(6)),
		CHAINGUNNER("Chaingunner", new EntityDefaults(false, 4, 15).setMeleeDamage(4).setRangedDamage(4).setGeneralSpeed(0.25)),
		CYBER_DEMON_2016("Cyber Demon 2016", new EntityDefaults(true, 1, 300).setMeleeDamage(15).setGeneralSpeed(0.25).setRangedDamage(6)),
		CYBER_DEMON("Cyber Demon", new EntityDefaults(true, 1, 300).setMeleeDamage(15).setGeneralSpeed(0.25).setRangedDamage(6)),
		GARGOYLE("Gargoyle", new EntityDefaults(false, 4, 30).setMeleeDamage(4).setRangedDamage(5).setGeneralSpeed(0.25).setFlySpeed(2.25)),
		GORE_NEST("Gore Nest", new EntityDefaults(true, 1, 5).setGeneralSpeed(0).setMeleeDamage(15)),
		HELL_KNIGHT_2016("Hell Knight 2016", new EntityDefaults(true, 1, 90).setMeleeDamage(8).setGeneralSpeed(0.25)),
		HELL_KNIGHT("Hell Knight", new EntityDefaults(true, 1, 90).setMeleeDamage(8).setGeneralSpeed(0.25)),
		ICON_OF_SIN("Icon of Sin", new EntityDefaults(true, 1, 1000).setMeleeDamage(30).setGeneralSpeed(0.25)),
		IMP_2016("Imp 2016", new EntityDefaults(false, 4, 30).setRangedDamage(5).setMeleeDamage(4).setGeneralSpeed(0.25)),
		IMP("Imp", new EntityDefaults(false, 4, 30).setRangedDamage(5).setMeleeDamage(4).setGeneralSpeed(0.25)),
		LOST_SOUL("Lost Soul", new EntityDefaults(false, 4, 10).setMeleeDamage(1).setGeneralSpeed(0.25)),
		MANCUBUS("Mancubus", new EntityDefaults(true, 1, 80).setMeleeDamage(8).setRangedDamage(6).setGeneralSpeed(0.25)),
		MARAUDER("Marauder", new EntityDefaults(true, 1, 45).setMeleeDamage(12).setGeneralSpeed(0.25)),
		MECHA_ZOMBIE("Mecha Zombie", new EntityDefaults(false, 4, 25).setMeleeDamage(15).setRangedDamage(5).setGeneralSpeed(0.25)),
		NIGHTMARE_IMP("Nightmare Imp", new EntityDefaults(false, 4, 30).setMeleeDamage(4).setRangedDamage(5).setGeneralSpeed(0.25)),
		PAIN("Pain", new EntityDefaults(false, 2, 80).setGeneralSpeed(0.25)),
		PINKY("Pinky", new EntityDefaults(false, 4, 75).setMeleeDamage(6).setGeneralSpeed(0.25)),
		POSSESSED_SCIENTIST("Possessed Scientist", new EntityDefaults(false, 1, 15).setMeleeDamage(4).setGeneralSpeed(0.15)),
		POSSESSED_SOLDIER("Possessed Soldier", new EntityDefaults(false, 4, 15).setMeleeDamage(4).setRangedDamage(3).setGeneralSpeed(0.25)),
		REVENANT("Revenant", new EntityDefaults (true, 1, 20).setMeleeDamage(6).setRangedDamage(1).setGeneralSpeed(0.25)),
		SHOTGUN_GUY("Shotgun Guy", new EntityDefaults(false, 4, 15).setMeleeDamage(4).setRangedDamage(4).setGeneralSpeed(0.25)),
		SPIDER_DEMON("Spider Demon", new EntityDefaults(true, 1, 300).setRangedDamage(3).setMeleeDamage(8).setGeneralSpeed(0.25)),
		UNWILLING("Unwilling", new EntityDefaults(false, 4, 15).setMeleeDamage(4).setGeneralSpeed(0.25)),
		ZOMBIEMAN("Zombieman", new EntityDefaults(false, 4, 15).setMeleeDamage(4).setRangedDamage(4).setGeneralSpeed(0.25));

		EntityConfigType(String display, EntityDefaults defaults) {
			this.display = display;
			defaultAttributes = defaults;
		}

		private EntityDefaults defaultAttributes;

		public EntityDefaults getDefaultAttributes() {
			return defaultAttributes;
		}

		private String display;

		@Override
		public String toString() {
			return display;
		}
	}

	private int defaultMaxRoll = 1;
	private double defaultMaxHealth;
	private double defaultGeneralSpeed;
	private double defaultFlySpeed;
	private double defaultMeleeDamage;
	private float defaultRangedDamage;
	private boolean isHeavy = false;

	public EntityDefaults(boolean heavy, int defaultMaxRoll, double defaultMaxHealth) {
		isHeavy = heavy;
		this.defaultMaxRoll = defaultMaxRoll;
		this.defaultMaxHealth = defaultMaxHealth;
	}

	public EntityDefaults setGeneralSpeed(double defaultGeneralSpeed) {
		this.defaultGeneralSpeed = defaultGeneralSpeed;
		return this;
	}

	public EntityDefaults setFlySpeed(double defaultFlySpeed) {
		this.defaultFlySpeed = defaultFlySpeed;
		return this;
	}

	public EntityDefaults setMeleeDamage(double defaultMeleeDamage) {
		this.defaultMeleeDamage = defaultMeleeDamage;
		return this;
	}

	public EntityDefaults setRangedDamage(float defaultRangedDamage) {
		this.defaultRangedDamage = defaultRangedDamage;
		return this;
	}

	public boolean isHeavy() {
		return isHeavy;
	}

	public int getDefaultMaxRoll() {
		return defaultMaxRoll;
	}

	public float getDefaultRangedDamage() {
		return defaultRangedDamage;
	}

	public double getDefaultMeleeDamage() {
		return defaultMeleeDamage;
	}

	public double getDefaultFlySpeed() {
		return defaultFlySpeed;
	}

	public double getDefaultGeneralSpeed() {
		return defaultGeneralSpeed;
	}

	public double getDefaultMaxHealth() {
		return defaultMaxHealth;
	}

}
