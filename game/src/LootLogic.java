import java.util.Random;

/**
 * @author Merlijn van den Berg & Pieter van der werff
 */
public class LootLogic {
	public Random rand = new Random();
	
	/**
	 * Maakt een random cordinaar voor de x as
	 * @return
	 */
	public int getRChestX() {
		return rand.nextInt(16) + 1;
	}
	
	/**
	 * Maakt een random cordinaar voor de y as
	 * @return
	 */
	public int getRChestY() {
		return rand.nextInt(6) + 1;
	}
	
	/**
	 * kiest een random item van de loot items
	 * @return
	 */
	public int getRLoot() {
		return rand.nextInt(5) + 1;
	}
}
	