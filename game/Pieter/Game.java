// @author: Pieter, Merlijn
//

public class Game {

	public static void main(String[] args) {
		
//		LootLogic lootLogic = new LootLogic();
		RoomGenerator RoomGenerator = new RoomGenerator();

		Monster Monster = new Monster(RoomGenerator);

		Player Player = new Player(RoomGenerator);
		Monster.setPlayer(Player);
		RoomGenerator.SetPlayerLocation(4, 7);
		RoomGenerator.SetMonsterLocation(1,10);
		RoomGenerator.PrintRoom();

		while (true) {
			Monster.MonsterMovement(RoomGenerator.mx(), RoomGenerator.my(), RoomGenerator.px(), RoomGenerator.py());
			Player.movement();
		}
		
		
		// TODO: 'back' commando die je terug stuurt.
		// TODO:
	}
	
}
