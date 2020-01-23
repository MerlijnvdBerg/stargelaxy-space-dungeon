import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



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
		JSONObject lootData = getLootData();
		
		System.out.println(getLootNames(lootData));
		
		int lootTypes = lootData.size();
		System.out.println(lootTypes);
		
		for (int i = 0; i < numberOfItems ; i++) {
			System.out.println(lootData.get(1));
		}
		
	}



	public static String[] getLootNames(JSONObject jsonObject) {
		String[] keys = {};
		int i = 0;
		for(Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			System.out.println(jsonObject.get(key));
			keys[i] = (key);
			i++;
			
		}
		return keys;
	}
	
	
	private JSONObject getLootData() {
		
		try (FileReader reader = new FileReader("game/Loot.json"))
		{
			return (JSONObject) new JSONParser().parse(reader);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
