import java.util.Random;

/**
 * @author Merlijn van den Berg & Pieter van der werff
 */
public class Monster {
	public RoomGenerator RoomGenerator;
	public Player player;
	private int hp;
	public Functions f = new Functions();
	public boolean Alive = true;
	
	/**
	 * berekend en handeld de player movement
	 * @param mx
	 * @param my
	 * @param px
	 * @param py
	 */
	public void MonsterMovement(int mx, int my, int px, int py) {
		if(!Alive) return;
		int x = mx, y = my;
		Random rand = new Random();
		int rand_int1 = rand.nextInt(2);
		
		if (rand_int1 == 1) {
			if (py <= my) {
				y--;
			}
			if (px <= mx) {
				x--;
			}
			if (py >= my) {
				y++;
			}
			if (px >= mx) {
				x++;
			}
			RoomGenerator.SetMonsterLocation(y, x);
		}
		if ((y == py) & (x == px)) {
			System.out.println("The monster has caught up with you.");
			boolean bat = player.getInventory()[1] > 0;
			if (bat) {
				f.printText("You knocked the monster out using your bat, but still took a small hit.");
				player.doDMG(1);
			} else {
				f.printText("You knocked the monster out, but still took a hit.");
				player.doDMG(2);
			}
			RoomGenerator.KillMonster();
			Alive = false;
			
		}
	}
	
	/**
	 * zet de player voor het monster
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/**
	 * zet de Roomgenerator voor het moster
	 * @param RoomGenerator
	 */
	public void setRoomGenerator(RoomGenerator RoomGenerator) {
		this.RoomGenerator = RoomGenerator;
	}
}
