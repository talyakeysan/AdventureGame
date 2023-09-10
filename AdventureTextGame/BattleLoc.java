package AdventureTextGame;

import java.util.Random;
import java.util.Scanner;


public abstract class BattleLoc extends Location {
	
	private Monster monster;
	private String award;
	private int maxMonster;
	private Scanner input = new Scanner(System.in);

	public BattleLoc(Player player, String name, Monster monster, String award, int maxMonster) {
		super(player, name);
		this.monster = monster;
		this.award= award;
		this.maxMonster = maxMonster;
		
	}

	
	
	@Override
	boolean onLocation() {
		int monsNumber = this.randomMonster();
		System.out.println("You are now in: " + this.getName());
		System.out.println("\nBe careful ! " + "There are " + monsNumber + " " + this.getMonster().getName() + "(s) that live here !");
		System.out.println("Now fight or flight !");
		System.out.println("\n\t  PRESS {F} TO FIGHT OR {R} TO RUN AWAY ");
		String selectBattle = input.nextLine();
		selectBattle = selectBattle.toUpperCase();
		
		if (selectBattle.equals("F")){
			System.out.println("The fight starts..");
			if (combat(monsNumber)) {
				System.out.println("\nYOU DEFEATED ALL " + this.getMonster().getName().toUpperCase() + "S IN THE " + this.getName().toUpperCase() +  " !");
			    return true;
			}
		}
		if (this.getPlayer().getHealth() <=0) {
			System.out.println("\t\nYOU DIED !..");
			return false;			
		}		

			
		
		return true;
		
	}
	
	
  public boolean combat(int monsNumber) {
	  
	for (int i = 1; i<= monsNumber; i++) {
		this.getMonster().setHealth(this.getMonster().getOriginalHealth());
		playerStats();
		monsterStats(i);
		while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
			System.out.println("\t\nPRESS {F} TO FIGHT or {R} TO RUN");
			String selectCombat = input.nextLine().toUpperCase();
			
			if (selectCombat.equals("F")) {
				
				System.out.println("\n--->YOU ATTACKED THE " + this.getMonster().getName().toUpperCase() + "!");
			    this.getMonster().setHealth(this.getMonster().getHealth() - getPlayer().getDamage());
			    afterhit();
			    if (this.getMonster().getHealth() > 0) {
			    	System.out.println();
			    	System.out.println("\n--->" + this.getMonster().getName().toUpperCase() + " ATTACKED YOU!");
			    	int monsterDamage = this.getMonster().getDamage() - getPlayer().getInventory().getArmour().getBlock();
			    	if (monsterDamage <0) {
			    		monsterDamage = 0 ;
			    	}
			    	this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
			    	afterhit();
			    }
			}
			else {
				return false;
			}
		}
		
		if (this.getMonster().getHealth() < this.getPlayer().getHealth() && this.getMonster().getHealth() == 0) {
			System.out.println("\t\nCONGRATS ! YOU DEFEATED THE ENEMY !");
			System.out.println("YOU JUST WON, " + this.getMonster().getAward() + " PRIZE MONEY !");
			this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
		    System.out.println("\n---> Your current money: " + this.getPlayer().getMoney());
		
		}
		else {
			return false;
		}
		
	}
		
		return true;
		
			
		}
        
        public void afterhit() {
        	System.out.println("\n##############################");
        	System.out.println();
        	System.out.println("Your health: "+ this.getPlayer().getHealth());
        	System.out.println(this.getMonster().getName() + "'s health: " + this.getMonster().getHealth());
        	System.out.println("\n##############################");
        }
        


public void playerStats() {
	System.out.println("\t\nPlayer Statistics ");
	System.out.println("--------------------------");
	System.out.println("Health: "+ this.getPlayer().getHealth());
	System.out.println("Damage: "+ this.getPlayer().getDamage());
	System.out.println("Weapon: "+ this.getPlayer().getInventory().getWeaponName());
	System.out.println("Armour: "+ this.getPlayer().getInventory().getArmour().getName() );
	System.out.println("Block: "+ this.getPlayer().getInventory().getArmour().getBlock());
	System.out.println("Money: "+ this.getPlayer().getMoney());
	
}
public void monsterStats(int i) {
	System.out.println("\t\n" + i + "." + this.getMonster().getName() + " Statistics" );
	System.out.println("--------------------------");
	System.out.println("Health: " + this.getMonster().getHealth());
	System.out.println("Damage: " + this.getMonster().getDamage());
	System.out.println("Reward: " + this.getMonster().getAward());
}


	public int randomMonster(){
		Random r= new Random();
		return r.nextInt(this.getMaxMonster()) +1;
	}
	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}



	public int getMaxMonster() {
		return maxMonster;
	}



	public void setMaxMonster(int maxMonster) {
		this.maxMonster = maxMonster;
	}

}
