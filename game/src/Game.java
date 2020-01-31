
/**
 * @author Merlijn van den Berg & Pieter van der werff
 */

public class Game {
	
	private static long time;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Story Story = new Story();
//		 Story.IntroText();
		
		LootLogic Loot = new LootLogic();
		Player Player = new Player();
		Monster Monster = new Monster();
		Monster.setPlayer(Player);
		Functions f = new Functions();
		
		
		
		boolean playing = Player.getTime() >= 0;
		boolean won = false;
		
		while (playing && !won) {
			playing = Player.getTime() >= 0;
			if(!playing) break;
			
			switch (Player.getRooms()) {
				case 1:
					// Creating the RoomGenerator
					RoomGenerator RoomGenerator1 = new RoomGenerator();
					Player.setRoom(RoomGenerator1);
					Monster.Alive = true;
					
					Story.room1();
					
					// Adding the Player to the room
					RoomGenerator1.setPlayer(Player);
					RoomGenerator1.SetPlayerLocation(1, 4);
					RoomGenerator1.setInRoom(true);
					
					// adding elements to the room
					RoomGenerator1.setDoor1(5, 17, 2);
					
					// Printing the room and making the player move in it
					RoomGenerator1.PrintRoom();
					while (RoomGenerator1.isInRoom && playing) {
						playing = Player.getTime() >= 0;
						if(!playing) break;
						Player.movement();
					}
					break;
				case 2:
					// Creating the RoomGenerator
					RoomGenerator RoomGenerator2 = new RoomGenerator();
					Player.setRoom(RoomGenerator2);
					Monster.Alive = true;
					
					Story.room2();
					
					// Creating a monster
					Monster.setRoomGenerator(RoomGenerator2);
					RoomGenerator2.SetMonsterLocation(6, 12);
					
					// Adding the Player to the room
					RoomGenerator2.setPlayer(Player);
					RoomGenerator2.SetPlayerLocation(5, 1);
					RoomGenerator2.setInRoom(true);
					
					// adding elements to the room
					RoomGenerator2.setDoor1(0, 13, 3);
					RoomGenerator2.setDoor2(7, 8, 4);
					RoomGenerator2.setReturnDoor(5, 0, 1);
					
					// Printing the room and making the player move in it
					RoomGenerator2.PrintRoom();
					while (RoomGenerator2.isInRoom && playing) {
						Monster.MonsterMovement(RoomGenerator2.mx(), RoomGenerator2.my(), RoomGenerator2.px(), RoomGenerator2.py());
						playing = Player.getTime() >= 0;
						if(!playing) break;
						Player.movement();
					}
					break;
				case 3:
					// Creating the RoomGenerator
					RoomGenerator RoomGenerator3 = new RoomGenerator();
					Player.setRoom(RoomGenerator3);
					Monster.Alive = true;
					
					Story.room3();
					
					// Adding the Player to the room
					RoomGenerator3.setPlayer(Player);
					RoomGenerator3.SetPlayerLocation(6, 13);
					RoomGenerator3.setInRoom(true);
					
					// adding elements to the room
					RoomGenerator3.SetLoot(2, 4, 2); // Spawns the key
					RoomGenerator3.setReturnDoor(7, 13, 2);
					
					// Printing the room and making the player move in it
					RoomGenerator3.PrintRoom();
					while (RoomGenerator3.isInRoom && playing) {
						playing = Player.getTime() >= 0;
						if(!playing) break;
						Player.movement();
					}
					break;
				case 4: // 7, 8,
					RoomGenerator RoomGenerator4 = new RoomGenerator();
					Player.setRoom(RoomGenerator4);
					Monster.Alive = true;
					
					Story.room4();
					
					Monster.setRoomGenerator(RoomGenerator4);
					RoomGenerator4.SetMonsterLocation(6, 8);
					
					RoomGenerator4.setPlayer(Player);
					RoomGenerator4.SetPlayerLocation(1, 8);
					
					RoomGenerator4.setInRoom(true);
					
					RoomGenerator4.setDoor1(4, 0, 9);
					RoomGenerator4.setDoor2(4, 17, 5);
					RoomGenerator4.setReturnDoor(0, 8, 2);
					
					RoomGenerator4.PrintRoom();
					
					while (RoomGenerator4.isInRoom && playing) {
						Monster.MonsterMovement(RoomGenerator4.mx(), RoomGenerator4.my(), RoomGenerator4.px(), RoomGenerator4.py());
						playing = Player.getTime() >= 0;
						if(!playing) break;
						Player.movement();
					}
					break;
				case 5:
					RoomGenerator RoomGenerator5 = new RoomGenerator();
					Player.setRoom(RoomGenerator5);
					Monster.Alive = true;
					
					Story.room5();
					
					Monster.setRoomGenerator(RoomGenerator5);
					RoomGenerator5.SetMonsterLocation(6, 7);
					
					RoomGenerator5.setPlayer(Player);
					RoomGenerator5.SetPlayerLocation(4, 1);
					
					RoomGenerator5.setInRoom(true);
					
					RoomGenerator5.setDoor1(4, 17, 6);
					RoomGenerator5.setDoor2(7, 7, 7);
					RoomGenerator5.setReturnDoor(4, 0, 4);
					
					RoomGenerator5.PrintRoom();
					
					while (RoomGenerator5.isInRoom && playing) {
						Monster.MonsterMovement(RoomGenerator5.mx(), RoomGenerator5.my(), RoomGenerator5.px(), RoomGenerator5.py());
						playing = Player.getTime() >= 0;
						if(!playing) break;
						Player.movement();
					}
					break;
				case 6:
					RoomGenerator RoomGenerator6 = new RoomGenerator();
					Player.setRoom(RoomGenerator6);
					Monster.Alive = true;
					
					Story.room6();
					
					RoomGenerator6.setPlayer(Player);
					RoomGenerator6.SetPlayerLocation(5, 1);
					
					RoomGenerator6.setInRoom(true);
					RoomGenerator6.SetLoot(6, 6, 2);
					
					RoomGenerator6.setDoor1(0, 6, 8);
					RoomGenerator6.setReturnDoor(5, 0, 5);
					
					RoomGenerator6.PrintRoom();
					
					while (RoomGenerator6.isInRoom && playing) {
						playing = Player.getTime() >= 0;
						if(!playing) break;
						Player.movement();
					}
					break;
				case 7:
					RoomGenerator RoomGenerator7 = new RoomGenerator();
					Player.setRoom(RoomGenerator7);
					Monster.Alive = true;
					
					Story.room7();
					
					Monster.setRoomGenerator(RoomGenerator7);
					RoomGenerator7.SetMonsterLocation(3, 7);
					
					RoomGenerator7.setPlayer(Player);
					RoomGenerator7.SetPlayerLocation(1, 7);
					
					RoomGenerator7.setInRoom(true);
					RoomGenerator7.SetLoot(6, 6, 0);
					RoomGenerator7.setReturnDoor(0, 7, 5);
					
					RoomGenerator7.PrintRoom();
					
					while (RoomGenerator7.isInRoom && playing) {
						Monster.MonsterMovement(RoomGenerator7.mx(), RoomGenerator7.my(), RoomGenerator7.px(), RoomGenerator7.py());
						playing = Player.getTime() >= 0;
						if(!playing) break;
						Player.movement();
					}
					break;
				case 8:
					RoomGenerator RoomGenerator8 = new RoomGenerator();
					Player.setRoom(RoomGenerator8);
					Monster.Alive = true;
					RoomGenerator8.ExitDoor = true;
					
					Story.room8();
					
					Monster.setRoomGenerator(RoomGenerator8);
					RoomGenerator8.SetMonsterLocation(1, 9);
					
					RoomGenerator8.setPlayer(Player);
					RoomGenerator8.SetPlayerLocation(6, 9);
					
					RoomGenerator8.setInRoom(true);
					RoomGenerator8.setDoor1(0, 8, 99);
					RoomGenerator8.setReturnDoor(7, 9, 6);
					
					RoomGenerator8.PrintRoom();
					
					while (RoomGenerator8.isInRoom && playing) {
						Monster.MonsterMovement(RoomGenerator8.mx(), RoomGenerator8.my(), RoomGenerator8.px(), RoomGenerator8.py());
						playing = Player.getTime() >= 0;
						if(!playing) break;
						Player.movement();
					}
					break;
				case 9:
					RoomGenerator RoomGenerator9 = new RoomGenerator();
					Player.setRoom(RoomGenerator9);
					Monster.Alive = true;
					
					RoomGenerator9.setPlayer(Player);
					RoomGenerator9.SetPlayerLocation(4, 16);
					
					RoomGenerator9.setInRoom(true);
					RoomGenerator9.SetLoot(3, 3, 1);
					RoomGenerator9.setDoor1(7, 8, 10);
					RoomGenerator9.setReturnDoor(4, 17, 4);
					
					RoomGenerator9.PrintRoom();
					
					while (RoomGenerator9.isInRoom && playing) {
						playing = Player.getTime() >= 0;
						if(!playing) break;
						Player.movement();
					}
					break;
				case 10:
					RoomGenerator RoomGenerator10 = new RoomGenerator();
					Player.setRoom(RoomGenerator10);
					Monster.Alive = true;
					
					RoomGenerator10.setPlayer(Player);
					RoomGenerator10.SetPlayerLocation(1, 4);
					
					RoomGenerator10.setInRoom(true);
					RoomGenerator10.SetLoot(6, 7, 2);
					RoomGenerator10.setReturnDoor(0, 4, 9);
					
					RoomGenerator10.PrintRoom();
					
					while (RoomGenerator10.isInRoom && playing) {
						playing = Player.getTime() >= 0;
						if(!playing) break;
						Player.movement();
					}
					break;
				case 99:
					won = true;
					break;
			}
		}
		
		if (won){
			Story.exit();
		} else {
			f.printText("You died");
			f.printText("Restart to try again!");
		}
	}
	
}
