
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Merlijn van den Berg & Pieter van der werff
 */
public class Player {
	public static int[] inventory = {0, 0, 0};
	public static String[] inventoryItems = {"K", "B", "A"};
	private static Functions f = new Functions();
	private long endTime;
	public int hp = 4;
	public int maxhp = 4;
	public ArrayList<Integer> rooms = new ArrayList<Integer>();
	private RoomGenerator RoomGenerator;
	
	/**
	 * De constructor van de player
	 */
	public Player() {
		Date date = new Date();
		endTime = date.getTime() + 300000;
		rooms.add(1);
	}
	
	/**
	 * toont de inhoud van de loot chests
	 * @param lootTable
	 */
	public static void ShowChest(int lootTable) {
		f.printText("You found a chest!");
		f.Pause(2);
		System.out.println("You found a " + inventoryItems[lootTable]);
		System.out.println("Do you want to grab it?");
		System.out.println("Type pickup or no");
		
		Scanner sc = new Scanner(System.in);
		
		boolean Continue = false;
		while (!Continue) {
			String i = sc.nextLine();
			if (i.equals("pickup")) {
				if(inventory[2] > 1){
					f.printText("Your inventory is to full!");
					Continue = true;
					break;
				}
				System.out.println(lootTable);
				inventory[lootTable]++;
				System.out.println(inventory[lootTable]);
				Continue = true;
			} else if (i.equals("no")) {
				Continue = true;
			}
		}
	}
	
	/**
	 * Handeld de player input en movement
	 */
	public void movement() {
		PrintHp();
		PrintInv();
		
		Scanner sc = new Scanner(System.in);
		String i = sc.nextLine();
		
		switch (i.toLowerCase()) {
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
			case "o":
			case "oxygen":
				checkOxygen();
				break;
			case "b":
			case "back":
				goBack();
				break;
			case "2":
			case "use apple":
				UseApple();
				break;
			case "/heal":
				hp = 10;
				maxhp = 10;
				System.out.println(hp);
				break;
			case "/showroomhistory":
				System.out.println(rooms.toString());
				break;
		}
		
		RoomGenerator.PrintRoom();
	}
	
	/**
	 * Toont de hp die de player heeft
	 */
	public void PrintHp() {
		StringBuilder stats = new StringBuilder();
		for (int i = 1; i <= maxhp; i++) {
			if (i <= hp) {
				stats.append("H ");
			} else {
				stats.append(" ");
			}
		}
		System.out.println(stats.toString());
	}
	
	/**
	 * Toont de inv die de player heeft
	 */
	public void PrintInv() {
		StringBuilder stats = new StringBuilder();
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] == 0) {
				stats.append("o ");
			} else {
				stats.append(inventoryItems[i] + " ");
			}
		}
		System.out.println(stats);
		
	}
	
	/**
	 * Toont de oxygen die de player heeft
	 */
	public void checkOxygen() {
		long time = endTime - new Date().getTime();
		System.out.println("You have " + time + "ml of oxygen left");
	}
	
	/**
	 * Handeld de back commado
	 */
	public void goBack() {
		if (rooms.size() > 1) {
			System.out.println("Going back to te previous room");
			rooms.remove(rooms.size() - 1);
			RoomGenerator.setInRoom(false);
		} else System.out.println("There is no previous room");
	}
	
	/**
	 * stuurd de current room door
	 * @return int
	 */
	public int getRooms() {
		if (rooms.size() > 0) return rooms.get(rooms.size() - 1);
		else return 1;
	}
	
	/**
	 * voegt een kamer toe aan de history
	 * @param room
	 */
	public void setRooms(int room) {
		rooms.add(room);
	}
	
	/**
	 * haalt de tijd op die de player nog heeft
	 * @return long
	 */
	public long getTime() {
		return endTime - new Date().getTime();
	}
	
	
	/**
	 * handeld de damges die de player kan nemen
	 * @param hp
	 */
	public void doDMG(int hp){
		this.hp = this.hp - hp;
		if(this.hp <= 0){
			endTime = new Date().getTime();
		}
	}
	
	/**
	 * set de room waar de player zich in bevind
	 * @param RoomGenerator
	 */
	public void setRoom(RoomGenerator RoomGenerator) {
		this.RoomGenerator = RoomGenerator;
	}
	
	/**
	 * check of een player een apple kan gebruiken en gebruikt hem dan
	 */
	public void UseApple() {
		if (inventory[2] > 0) {
			f.printText("You used an apple and feel much better!");
			hp = hp + 2;
			inventory[2] = inventory[2] - 1;
		} else {
			f.printText("You dont have a apple");
		}
	}
	
	
	/**
	 * Haalt de inv op van de player
	 * @return int[]
	 */
	public static int[] getInventory() {
		return inventory;
	}
}
