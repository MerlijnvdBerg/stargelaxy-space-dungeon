// @author: Pieter, Merlijn
//

import java.util.Scanner;

public class Player {
public String[][] inventory = {};
private static int inventorySize = 5;
public int hp = 3;
public int room = 0;
private RoomGenerator RoomGenerator;

public Player(RoomGenerator RoomGenerator) {
	this.RoomGenerator = RoomGenerator;
}

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
	StringBuilder stats = new StringBuilder();
	for (int i = 0; i < inventorySize; i++){
		if(i < inventory.length){
			stats.append("☐ ");
		} else{
			stats.append("☑ ");
		}
	}
	System.out.println(stats.toString());
}
	public void doDMG(int hp) {
		this.hp = this.hp - hp;
	}
}
