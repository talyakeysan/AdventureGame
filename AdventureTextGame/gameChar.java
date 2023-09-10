package AdventureTextGame;

public class gameChar {
	private int id;
	private int damage;
	 private String name;
	 private int health;
	 private int money ;
	 
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}



	public gameChar(int id, int damage, String name, int health, int money) {
		super();
		this.id =id;
		this.damage = damage;
		this.name = name;
		this.health = health;
		this.money = money;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
