package AdventureTextGame;

import java.util.Scanner;


public class Adventure_Game {
	
	private Scanner input= new Scanner(System.in);
	
	public void start() {
		
		System.out.println("Welcome to the adventure ! ");
		System.out.print("Please enter your name: ");
		String playerName = input.nextLine() ;
		Player player = new Player(playerName);
		System.out.println("Hello " + player.getName() + " say hi to this deserted island ! ");
		System.out.println("Let's see if you can survive..");
		System.out.println("\nNow choose your character wisely >.< ");
		player.selectChar();
		
		Location location = null;
		
		while (true) {
			player.printInfo();
			System.out.println();
			System.out.println("     ---------------");
			System.out.println("    |   Locations:  |");
			System.out.println("     ---------------");
			System.out.println("1- Safe House -> Enemies cannot attack you in your house ");
			System.out.println("2- Store -> You can buy weapon and armour");
			System.out.println("3- Cave -> Get the food in the cave without getting killed by zombies ");
			System.out.println("4- Forest -> To get some firewood you have to fight vampires");
			System.out.println("5- River -> If you need water you need to defeat bears first");
			System.out.println("\n\tPRESS ZERO TO END THE GAME");
			System.out.println("\nChoose the place you want to be in:"); 
			int selectLoc = input.nextInt();
			
			switch (selectLoc) {
			case 0:
				location = null;
				break;
			case 1:
				location = new SafeHouse(player,"Safe House ");
				break;
			case 2:
				location = new ToolStore(player, "Store");
				break;
			case 3:
				location = new Cave(player);
				break;
			case 4:
				location = new Forest(player);
				break;
			case 5:
				location = new River(player);	
				break;
			default:
				System.out.println("Invalid value! You are assigned to the Safe House ! ");
				location = new SafeHouse(player, "Safe House");
				
			}
			
			if (location == null) {
				System.out.println("You gave up so fast " + player.getName() + "... \nGoodbye!");
				break;
				}
			
			if (location.onLocation() == false) {
				System.out.println("\n\t****************");
				System.out.println("\t*              *");
				System.out.println("\t*  GAME OVER.. *");
				System.out.println("\t*              *");
				System.out.println("\t****************");
				break;
				
			}
			
		}
	}

}
