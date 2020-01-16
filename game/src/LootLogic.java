import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;


public class LootLogic {
	private int chestY;
	private int chestX;
	public Random rand = new Random();

	public LootLogic() {
		chestY = rand.nextInt(18);
		chestX = rand.nextInt(8);
		
		RandomLoot(rand.nextInt(2));
		
	}

	public LootLogic(int y, int x) {
		chestY = y;
		chestX = x;
	}
	
	public void RandomLoot(int numberOfItems){
		
		String content = "";
		
		try {
			content = Files.readString(Paths.get("game/Loot.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(content);
	
	}
	
}
