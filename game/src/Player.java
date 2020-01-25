// @author: Pieter, Merlijn
//

import org.json.simple.JSONObject;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Player {
public static int[] inventory = {0,0,0,0,0,0};
public static String[] inventoryItems = {"\uD83D\uDD11","\uD83D\uDDE1","\uD83E\uDE93","\uD83E\uDDE6","\uD83C\uDFCF", "\uD83C\uDF4E"};
public int hp = 3;
public int room = 0;
private RoomGenerator RoomGenerator;

private static Functions f = new Functions();

public void setRoom(RoomGenerator RoomGenerator) {this.RoomGenerator = RoomGenerator;}

public void movement() {
	PrintHp();
	PrintInv();
	
	Scanner sc = new Scanner(System.in);
	String i = sc.nextLine();
	
	switch (i) {
		case "w":
			RoomGenerator.SetPlayerLocation(RoomGenerator.py() - 1,
					RoomGenerator.px());
			break;
		case "s":
			RoomGenerator.SetPlayerLocation(RoomGenerator.py() + 1,
					RoomGenerator.px());
			break;
		case "a":
			RoomGenerator.SetPlayerLocation(RoomGenerator.py(),
					RoomGenerator.px() - 1);
			break;
		case "d":
			RoomGenerator.SetPlayerLocation(RoomGenerator.py(),
					RoomGenerator.px() + 1);
			break;
	}
	
	RoomGenerator.PrintRoom();
}

public void PrintHp() {
	StringBuilder stats = new StringBuilder();
	for (int i = 1; i < 4; i++){
		if(i <= hp){
			stats.append("♥ ");
		} else{
			stats.append("♡ ");
		}
	}
	System.out.println(stats.toString());
}

public void PrintInv() {
	System.out.println(Arrays.toString(inventory));
	StringBuilder stats = new StringBuilder();
	for (int i = 0; i < inventory.length; i++){
		if(inventory[i] == 0){
			stats.append("☐ ");
		} else{
			stats.append(inventoryItems[i] + " ");
		}
	}
	System.out.println(stats.toString());
}


public static void ShowChest(int lootTable){
	f.printText("You found a chest!");
	f.Pause(2);
	System.out.println("You found a " + String.valueOf(inventoryItems[lootTable]));
	System.out.println("Do you want to grab it?");
	System.out.println("Type pickup or no");
	
	Scanner sc = new Scanner(System.in);
	
	boolean Continue = false;
	while (!Continue) {
		String i = sc.nextLine();
		if (i.equals("pickup")) {
			System.out.println(lootTable);
			inventory[lootTable]++;
			System.out.println(inventory[lootTable]);
			Continue = true;
		} else if (i.equals("no")) {
			Continue = true;
		}
	}
}

public void UseKey(){
	if(inventory[0] > 0){
	
	}
}
public void useSword() {
	if (inventory[1] > 0){
	
	}
}

}
