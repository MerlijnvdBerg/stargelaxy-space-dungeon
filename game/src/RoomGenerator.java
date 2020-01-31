
import java.util.Arrays;
/**
 * @author Merlijn van den Berg & Pieter van der werff
 */
public class RoomGenerator {
	
	public String[][] room = {{"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},};
	public int[] PlayerLocation = new int[]{0, 0};
	public int[] MonsterLocation = new int[]{0, 0};
	public int[] LootLocation = new int[]{0, 0};
	
	public int[] DoorLocation1 = new int[]{0, 0};
	public int DoorRoom1;
	
	public int[] DoorLocation2 = new int[]{0, 0};
	public int DoorRoom2;
	
	public int[] ReturnDoor = new int[]{0, 0};
	public int ReturnRoom;
	
	public boolean isInRoom = false;
	public int lootTable;
	public Player player;
	public boolean ExitDoor = false;
	
	public void PrintRoom() {
		for (int i = 0; i < room.length; i++) {
			String[] row = room[i];
			StringBuilder buildRoom = new StringBuilder();
			for (int j = 0; j < row.length; j++) {
				buildRoom.append(row[j]);
			}
			System.out.println(buildRoom);
		}
	}
	
	/**
	 * @param int y
	 * @param int x
	 */
	public void SetPlayerLocation(int y, int x) {

		if (CheckPlayerLocation(y, x)) {
			if (!Arrays.equals(PlayerLocation, new int[]{0, 0})) {
				room[PlayerLocation[0]][PlayerLocation[1]] = " ";
			}
			PlayerLocation = new int[]{y, x};
			room[y][x] = "P";
		}
	}
	
	/**
	 * @param int y
	 * @param int x
	 */
	public void SetMonsterLocation(int y, int x) {
		if (y != 0 && x != 0) {
			room[MonsterLocation[0]][MonsterLocation[1]] = " ";
		}
		MonsterLocation = new int[]{y, x};
		room[y][x] = "M";
	}
	
	
	/**
	 * @param int y
	 * @param int x
	 * @return boolean
	 */
	public boolean CheckPlayerLocation(int y, int x) {
		
		if (y == DoorLocation1[0] && x == DoorLocation1[1] && ExitDoor){
			if (Player.inventory[0] > 0){
				isInRoom = false;
				player.setRooms(DoorRoom1);
			} else {
				new Functions().printText("You need the key first to exit...");
				return false;
			}
		}
		if (y == DoorLocation1[0] && x == DoorLocation1[1]) {
			room[PlayerLocation[0]][PlayerLocation[1]] = String.valueOf(' ');
			isInRoom = false;
			player.setRooms(DoorRoom1);
		}
		
		if (y == DoorLocation2[0] && x == DoorLocation2[1]) {
			room[PlayerLocation[0]][PlayerLocation[1]] = String.valueOf(' ');
			isInRoom = false;
			player.setRooms(DoorRoom2);
		}
		
		if (y == ReturnDoor[0] && x == ReturnDoor[1]) {
			room[PlayerLocation[0]][PlayerLocation[1]] = String.valueOf(' ');
			isInRoom = false;
			player.setRooms(ReturnRoom);
		}
		
		if (y == 0 || x == 0) {
			return false;
		}
		
		if (y == room.length - 1 || x == room[0].length) {
			return false;
		}
		
		if (y == LootLocation[0] && x == LootLocation[1]) {
			Player.ShowChest(lootTable);
			room[LootLocation[0]][LootLocation[1]] = String.valueOf(' ');
			LootLocation = new int[]{0, 0};
			return false;
		}
		
		return true;
	}
	
	/**
	 * @param int y
	 * @param int x
	 * @param int room
	 */
	public void setDoor1(int y, int x, int room) {
		DoorLocation1 = new int[]{y, x};
		DoorRoom1 = room;
		this.room[y][x] = "D";
	}
	
	/**
	 * @param int y
	 * @param int x
	 * @param int room
	 */
	public void setDoor2(int y, int x, int room) {
		DoorLocation2 = new int[]{y, x};
		DoorRoom2 = room;
		this.room[y][x] = "D";
	}
	
	/**
	 * @param int y
	 * @param int x
	 * @param int room
	 */
	public void setReturnDoor(int y, int x, int room) {
		ReturnDoor = new int[]{y, x};
		ReturnRoom = room;
		this.room[y][x] = "D";
	}
	
	/**
	 * @param int y
	 * @param int x
	 * @param int loot
	 */
	public void SetLoot(int y, int x, int loot) {
		room[y][x] = "☒";
		LootLocation = new int[]{y, x};
		lootTable = loot;
	}
	
	public void KillMonster(){
		room[MonsterLocation[0]][MonsterLocation[1]] = "P";
		MonsterLocation = new int[]{0,0};
	}
	
	/**
	 * @param boolean inRoom
	 */
	public void setInRoom(boolean inRoom) {
		isInRoom = inRoom;
	}
	
	/**
	 * @param Player player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/**
	 * @return int
	 */
	public int px() {
		return PlayerLocation[1];
	}
	
	/**
	 * @return int
	 */
	public int py() {
		return PlayerLocation[0];
	}
	
	
	/**
	 * @return int
	 */
	public int mx() {
		return MonsterLocation[1];
	}
	
	/**
	 * @return int
	 */
	public int my() {
		return MonsterLocation[0];
	}
	
}
	