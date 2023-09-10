package AdventureTextGame;

public class Inventory {
	private int weaponDamage;
	private String weaponName;
	private Armour armour;
	
	
	public Inventory(int weaponDamage, String weaponName,Armour armour) {
		
		this.weaponDamage= 0;
		this.weaponName= "Fist";
		this.armour = new Armour(-1, 0, 0, "Cloth Covering");
	}

	public int getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public Armour getArmour() {
		return armour;
	}

	public void setArmour(Armour armour) {
		this.armour = armour;
	}

}
