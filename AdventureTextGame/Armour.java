package AdventureTextGame;

public class Armour {
	private int id;
	private int block;
	private int price;
	private String name;
	
	
	public Armour(int id, int block, int price, String name) {
		
		this.id = id;
		this.block = block;
		this.price = price;
		this.name = name;
	}
	
	public static Armour[] armours() {
		Armour[] armourList = new Armour[3];
		armourList[0]= new Armour(1, 1, 15, "Light");
		armourList[1]= new Armour(2, 3, 25, "Medium");
		armourList[2]= new Armour(3, 5, 35, "Heavy");
		return armourList;
		
	}
	public static Armour getArmourObj(int id) {
		
		for (Armour a : Armour.armours()) {
			if (a.getId() == id) {
				return a;
			}
			
			}
		
		return null;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}

}
