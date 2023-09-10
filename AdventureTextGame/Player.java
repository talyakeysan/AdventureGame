package AdventureTextGame;

import java.util.Scanner;


public class Player {
	 private int id;
	 private int damage;
	 private int health;
	 private int money ;
	 private String name; 
	 private String charName;
	 private Scanner input = new Scanner(System.in);
	 private Inventory inventory;
	 
	 public Player(String name) {
		 this.name = name ;
		 this.inventory = new Inventory(damage, name, null);
	 }
	 public  void selectChar() {
		 gameChar[] charList = { new Samurai(id,damage, charName, health, money), new Archer(id,damage,charName, health, money), new Knight(id,damage,charName, health, money)};
		 System.out.println("\n   \t ------ CHARACTERS ------");
		 System.out.println("\n*************************************************************");
		 
		 for (gameChar gamechar  : charList) {
			System.out.println("\nID:" + gamechar.getId() +
					"\tCharacter: " + gamechar.getName() + 
					"\t Damage:" + gamechar.getDamage() + 
					"\t Health:" + gamechar.getHealth() + 
					"\t Money:" + gamechar.getMoney() );
				
		 
		}
		 System.out.println("\n*************************************************************");
		 System.out.println("Enter ID of the character that you want to choose: ");
		 int selectChar = input.nextInt();
		 switch (selectChar) {
		 
		    case 1:
		    	initPlayer(new Samurai(selectChar, selectChar, charName, selectChar, selectChar));
		    	break;
		    case 2:
		    	initPlayer(new Archer(selectChar,selectChar, charName, selectChar, selectChar));
		    	break;
		    case 3:
		    	initPlayer(new Knight(selectChar,selectChar, charName, selectChar, selectChar));
		    	break;
		    default:
		    	initPlayer(new Samurai(selectChar,selectChar, charName, selectChar, selectChar));
		    	System.out.println("Since you didn't choose, Samurai chose you !");
		    	 
		 }
		 System.out.println("\nYour character is, " + this.getCharName() + ". "
				 );
	}
	 
	public void initPlayer(gameChar gamechar) {
		this.setCharName(gamechar.getName());
		this.setDamage(gamechar.getDamage());
		this.setHealth(gamechar.getHealth());
		this.setMoney(gamechar.getMoney());
		
	}  
	 public void printInfo() {
		 System.out.println("\nYour features;"
		 		+ "\nWeapon: "  + this.getInventory().getWeaponName() +
		 		"\nArmour: "  + this.getInventory().getArmour().getName() +
		 		"\nBlock: "  + this.getInventory().getArmour().getBlock() +
				 "\nDamage:" + this.getDamage() +
				 "\nHealth:" + this.getHealth() +
				 "\nMoney:"  + this.getMoney()
				 );
		 
	 }
	
	
	public int getDamage() {
		return damage + this.getInventory().getWeaponDamage();
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if (health < 0) {
			health = 0;
		}
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}


	 
	 
}
