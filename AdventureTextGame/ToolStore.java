package AdventureTextGame;

public class ToolStore extends NormalLoc{

	public ToolStore(Player player, String name) {
		super(player, "Store" );
		// TODO Auto-generated constructor stub
	}
	@Override
	boolean onLocation() {
		System.out.println("*** Welcome to the store !");
		boolean showMenu = true;
	
		while (showMenu) {System.out.println("\n1- WEAPONS");
		System.out.println("2- ARMOURS");
		System.out.println("3- EXIT");
		System.out.println("\t< Select one > : ");
		int selectvar =input.nextInt();
		
		while (selectvar < 1 || selectvar > 3 ) {
			System.out.println("Unvalid number,choose 1,2 or 3:  ");
			selectvar = input.nextInt();
		
		}
		switch (selectvar) {
		case 1:
			printWeapon();
			break;
		case 2:
			printArmour();
			break;
		case 3:
			System.out.println("See you again..");
			showMenu = false;
			break;
			
		}	}
	
		return true;
	 
	}
	public void printWeapon() {
		System.out.println("---- WEAPONS ----");
		System.out.println("\n1) Pistol:");
		System.out.println("************");
		System.out.println("Damage= -2\nPrice= 25 ");
		
		System.out.println("\n2) Sword:");
		System.out.println("************");
		System.out.println("Damage= -3\nPrice= 35 ");
		
		
		System.out.println("\n3) Rifle:");
		System.out.println("*************");
		System.out.println("Damage= -7\nPrice= 45");
		
		System.out.println("	\n---PRESS ZERO TO EXIT---");
		
		System.out.print("\nChoose a weapon: ");
		int selectweapon = input.nextInt();
		while (selectweapon < 0 || selectweapon > 3 ) {
			System.out.println("Unvalid number,choose 1,2 or 3:  ");
			selectweapon = input.nextInt();
			
		}
		
		if (selectweapon == 1 ) {
			if (this.getPlayer().getMoney() < 25) {
				System.out.println("[*] You don't have enough money. You need at least " + (25 -  this.getPlayer().getMoney()) + " coins to buy this!");
			}
			else {
				int balance = this.getPlayer().getMoney()- 25;
				System.out.println("PURCHASING IS SUCCESSFUL!\n ");
				this.getPlayer().setMoney(balance);
				System.out.println(">>The money left is: " + this.getPlayer().getMoney());
				System.out.println("\n-Previous weapon: " + this.getPlayer().getInventory().getWeaponName());
				this.getPlayer().getInventory().setWeaponDamage(2);
				this.getPlayer().getInventory().setWeaponName("Pistol");
				System.out.println("+New weapon: " + this.getPlayer().getInventory().getWeaponName() );
			}
		}
		if (selectweapon == 2 ) {
			if (this.getPlayer().getMoney() < 35) {
				System.out.println("[*] You don't have enough money. You need at least " + (35 -  this.getPlayer().getMoney()) + " coins to buy this!");
			}
			else {
				int balance = this.getPlayer().getMoney()- 35;
				System.out.println("PURCHASING IS SUCCESSFUL!\n ");
				this.getPlayer().setMoney(balance);
				System.out.println(">>The money left is: " + this.getPlayer().getMoney());
				System.out.println("\n-Previous weapon: " + this.getPlayer().getInventory().getWeaponName());
				this.getPlayer().getInventory().setWeaponDamage(3);
				this.getPlayer().getInventory().setWeaponName("Sword");
				System.out.println("+New weapon: " + this.getPlayer().getInventory().getWeaponName() );
			}
		}
		
		if (selectweapon == 3 ) {
			if (this.getPlayer().getMoney() < 45) {
				System.out.println("[*] You don't have enough money. You need at least " + (45 -  this.getPlayer().getMoney()) + " coins to buy this!");
			}
			else {
				int balance = this.getPlayer().getMoney()- 45;
				System.out.println("PURCHASING IS SUCCESSFUL!\n ");
				this.getPlayer().setMoney(balance);
				System.out.println(">>The money left is: " + this.getPlayer().getMoney());
				System.out.println("\n-Previous weapon: " + this.getPlayer().getInventory().getWeaponName());
				this.getPlayer().getInventory().setWeaponDamage(7);
				this.getPlayer().getInventory().setWeaponName("Rifle");
				System.out.println("+New weapon: " + this.getPlayer().getInventory().getWeaponName() );
			}
		}
		
	}
	public void printArmour() {
		System.out.println("---- ARMOURS ----");
		for(Armour a :Armour.armours()) {
			System.out.println();
			System.out.println(a.getId() + ") " + a.getName() + ":");
			System.out.println("***********");
			System.out.println("Block= " + a.getBlock());
			System.out.println("Price= " + a.getPrice());
			}
		System.out.println("	\n---PRESS ZERO TO EXIT---");
		System.out.print("\nChoose an armour: ");
		int selectarmour = input.nextInt();
		while (selectarmour < 0 ||selectarmour > 3 ) {
			System.out.println("Unvalid number,choose 1,2 or 3:  ");
			selectarmour = input.nextInt();
		}
	if (selectarmour != 0)	{
	    Armour selectedArmour = Armour.getArmourObj(selectarmour);
	    
		if (selectedArmour != null ) {
			if (selectedArmour.getPrice() > this.getPlayer().getMoney()) {
				System.out.println("[*] You don't have enough money. You need at least " + (selectedArmour.getPrice() - this.getPlayer().getMoney()) + " coins to buy this!");
			
			}
			else {
				System.out.println("PURCHASING IS SUCCESSFUL!\n ");
				this.getPlayer().setMoney(this.getPlayer().getMoney()- selectedArmour.getPrice());
				System.out.println(">>The money left is: " + this.getPlayer().getMoney());
				
				System.out.println("\n-Previous armour: " + this.getPlayer().getInventory().getArmour().getName());
				
				this.getPlayer().getInventory().setArmour(selectedArmour);
				System.out.println("+New armour: " + selectedArmour.getName() );
			}}
		}
	
	}

}
