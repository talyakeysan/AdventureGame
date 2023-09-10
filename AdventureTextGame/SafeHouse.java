package AdventureTextGame;


public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player, String name) {
		super(player, "Safe House");
		
	}

	
	@Override
	public boolean onLocation() {
		// TODO Auto-generated method stub
		
		System.out.println("*** You are now in the Safe House.\n Heart points have been charged to full !");
		
		if (this.getPlayer().getCharName().equals("Samurai")) {
			this.getPlayer().setHealth(21);
			System.out.println("-> Your health now: " + this.getPlayer().getHealth());
		}
		
		if ((this.getPlayer().getCharName().equals("Archer"))) {
			this.getPlayer().setHealth(18);
			System.out.println("->Your health now: " + this.getPlayer().getHealth());
		}
		
		if ((this.getPlayer().getCharName().equals("Knight"))) {
			this.getPlayer().setHealth(24);
			System.out.println("->Your health now: " + this.getPlayer().getHealth());
		}
		
		return true;
		}
}
