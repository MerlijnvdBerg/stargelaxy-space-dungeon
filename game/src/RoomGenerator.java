// @author: Pieter, Merlijn
//

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RoomGenerator
	{
	
	public String[][] room = {{"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, {"|", " ", "🥄", " ", "\uD83D\uDC7E", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},};
	public int[] PlayerLocation = new int[]{4, 7};
	public int[] MonsterLocation = new int[]{0, 0};
	public int[] LootLocation = new int[]{0, 0};
	public int[] DoorLocation = new int[]{0, 0};
	public boolean isInRoom = false;
	public int lootTable;
	public Player player;
	
	public RoomGenerator()
	{
	}
	
	public void PrintRoom()
	{
		for (int i = 0; i < room.length; i++) {
			String[] row = room[i];
			StringBuilder buildRoom = new StringBuilder();
			for (int j = 0; j < row.length; j++) {
				buildRoom.append(row[j]);
			}
			System.out.println(buildRoom);
		}
	}
	
	public void SetPlayerLocation(int y, int x)
	{
		if (CheckPlayerLocation(y, x)) {
			room[PlayerLocation[0]][PlayerLocation[1]] = String.valueOf(' ');
			room[y][x] = String.valueOf("\uD83D\uDC7D");
			PlayerLocation = new int[]{y, x};
		}
	}
	
	public void SetMonsterLocation(int y, int x)
	{
		if (y != 0 && x != 0) {
			room[MonsterLocation[0]][MonsterLocation[1]] = String.valueOf(' ');
		}
		room[y][x] = String.valueOf("\uD83D\uDC7D");
		MonsterLocation = new int[]{y, x};
	}
	
	public void SetLoot(int y, int x, int loot) {
		room[y][x] = String.valueOf("☒");
		LootLocation = new int[]{y,x};
		lootTable = loot;
	}
	
	public boolean CheckPlayerLocation(int y, int x){
		if (y == DoorLocation[0] && x == DoorLocation[1]){
			room[PlayerLocation[0]][PlayerLocation[1]] = String.valueOf(' ');
			isInRoom = false;
		}
		
		if (y == 0 || x == 0) {
			return false;
		}
		
		int roomX = room[0].length;
		int roomY = room.length;
		if(y == roomY-1 || x == roomX){
			return false;
		}
		
		if (y == LootLocation[0] && x == LootLocation[1]){
			Player.ShowChest(lootTable);
			room[LootLocation[0]][LootLocation[1]] = String.valueOf(' ');
			LootLocation = new int[]{0,0};
			return false;
		}
		
		return true;
	}
	
	public void setDoor(int y, int x){
		DoorLocation = new int[]{y,x};
		room[y][x] = "\uD83D\uDEAA";
	}
	
	
	public int px()
	{
		return PlayerLocation[1];
	}
	
	public int py()
	{
		return PlayerLocation[0];
	}
	
	
	public int mx()
	{
		return MonsterLocation[1];
	}
	
	public int my()
	{
		return MonsterLocation[0];
	}
	
	public void setPlayer(Player player){
		this.player = player;
	}
	
	public void setInRoom(boolean inRoom) {
		isInRoom = inRoom;
	}
	}
	