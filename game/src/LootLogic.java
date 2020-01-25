import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class LootLogic {
	private int chestY;
	private int chestX;
	private int RandomLoot;
	public Random rand = new Random();

	public LootLogic() {
		chestY = rand.nextInt(16)+1;
		chestX = rand.nextInt(6)+1;
		RandomLoot = rand.nextInt(5)+1;
	}

	public LootLogic(int y, int x) {
		chestY = y;
		chestX = x;
		RandomLoot = rand.nextInt(6);
	}
	
	public int getChestX() {
		return chestX;
	}
	
	public int getChestY() {
		return chestY;
	}
	
	public int getRandomLoot() {
		return RandomLoot;
	}



	
	
//public Object RandomLoot(){
//
//	JSONObject lootData = new JSONObject(getLootData());
//
//	Set keySet = lootData.keySet();
//	Object[] Keys = keySet.toArray(new String[keySet.size()]);
//	int KeySize = Keys.length;
//	int rm = ThreadLocalRandom.current().nextInt(0, KeySize);
//
//
//	return lootData.get(Keys[rm]);
//}

//private JSONObject getLootData() {
//
//	try (FileReader reader = new FileReader("game/Loot.json"))
//	{
//		return (JSONObject) new JSONParser().parse(reader);
//
//	} catch (FileNotFoundException e) {
//		e.printStackTrace();
//	} catch (IOException e) {
//		e.printStackTrace();
//	} catch (ParseException e) {
//		e.printStackTrace();
//	}
//
//	return null;
//}
}
