// @author: Pieter, Merlijn
//

import java.util.Arrays;

public class Game {

	public static void main(String[] args) {
		
		LootLogic LL = new LootLogic();
		Player Player = new Player();
		Story Story = new Story();
		
		//		Story.IntroText();
		
		// Room 1
		RoomGenerator RoomGenerator1 = new RoomGenerator();
		Player.setRoom(RoomGenerator1);
		RoomGenerator1.setPlayer(Player);
		RoomGenerator1.setInRoom(true);
		
		RoomGenerator1.SetLoot(LL.getChestX(), LL.getChestY(), LL.getRandomLoot());
		
		RoomGenerator1.SetPlayerLocation(4, 7);
		RoomGenerator1.setDoor(7, 6);
		
		RoomGenerator1.PrintRoom();
		
		while (RoomGenerator1.isInRoom) {
			System.out.println(RoomGenerator1.isInRoom);
			Player.movement();
		}
		
		System.out.println(RoomGenerator1.isInRoom);
		
		// End Room 1
		
		// Room 2
		RoomGenerator RoomGenerator2 = new RoomGenerator();
		Player.setRoom(RoomGenerator2);
		RoomGenerator2.setPlayer(Player);
		RoomGenerator2.setInRoom(true);
		
		RoomGenerator2.SetLoot(LL.getChestX(), LL.getChestY(), LL.getRandomLoot());
		
		RoomGenerator2.SetPlayerLocation(7, 3);
		RoomGenerator2.setDoor(7, 1);
		
		RoomGenerator2.PrintRoom();
		
		for (String[] roomRows : RoomGenerator2.room) {
			System.out.println(Arrays.toString(roomRows));
			
		}
		
		while (RoomGenerator2.isInRoom) {
			Player.movement();
		}
		// End Room 2
		
		
		// TODO: 'back' commando die je terug stuurt.
		// TODO:
	}
	
}
