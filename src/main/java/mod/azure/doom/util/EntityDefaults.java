package mod.azure.doom.util;

public class EntityDefaults {

	public enum EntityConfigType {

		ARACHNOTRON("Arachnotron", new EntityDefaults(false, 4, 100).setRangedDamage(4)),
		BARON("Baron", new EntityDefaults(true, 1, 180).setRangedDamage(6)),
		CACODEMON("Cacodemon", new EntityDefaults(false, 2, 80).setRangedDamage(6)),
		CHAINGUNNER("Chaingunner", new EntityDefaults(false, 4, 15).setRangedDamage(4)),
		CYBER_DEMON_2016("Cyber Demon 2016", new EntityDefaults(true, 1, 300).setRangedDamage(6)),
		CYBER_DEMON("Cyber Demon", new EntityDefaults(true, 1, 300).setRangedDamage(6)),
		GARGOYLE("Gargoyle", new EntityDefaults(false, 4, 30).setRangedDamage(5)),
		MANCUBUS("Mancubus", new EntityDefaults(true, 1, 80).setRangedDamage(6)),
		MECHA_ZOMBIE("Mecha Zombie", new EntityDefaults(false, 4, 25).setRangedDamage(5)),
		IMP_2016("Imp 2016", new EntityDefaults(false, 4, 30).setRangedDamage(5)),
		IMP("Imp", new EntityDefaults(false, 4, 30).setRangedDamage(5)),
		NIGHTMARE_IMP("Nightmare Imp", new EntityDefaults(false, 4, 30).setRangedDamage(5)),
		POSSESSED_SOLDIER("Possessed Soldier", new EntityDefaults(false, 4, 15).setRangedDamage(3)),
		REVENANT("Revenant", new EntityDefaults(true, 1, 20).setRangedDamage(1)),
		SHOTGUN_GUY("Shotgun Guy", new EntityDefaults(false, 4, 15).setRangedDamage(4)),
		SPIDER_DEMON("Spider Demon", new EntityDefaults(true, 1, 300).setRangedDamage(3)),
		ZOMBIEMAN("Zombieman", new EntityDefaults(false, 4, 15).setRangedDamage(4));

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

	private float defaultRangedDamage;

	public EntityDefaults(boolean heavy, int defaultMaxRoll, double defaultMaxHealth) {
	}

	public EntityDefaults setRangedDamage(float defaultRangedDamage) {
		this.defaultRangedDamage = defaultRangedDamage;
		return this;
	}

	public float getDefaultRangedDamage() {
		return defaultRangedDamage;
	}

}
