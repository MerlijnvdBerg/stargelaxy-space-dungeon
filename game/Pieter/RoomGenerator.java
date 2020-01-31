// @author: Pieter, Merlijn
//

public class RoomGenerator {
	
	//	public static String[][] room = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}, {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'}, {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'}, {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'}, {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'}, {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'}, {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'}, {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},};
	public static String[][] room = {{"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ""}, {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},};
	public int[] PlayerLocation = new int[]{4, 7};
	public String[][][] lootTable = {};
	public int[] MonsterLocation = new int[]{1, 10};
	
	public RoomGenerator() {
	}
	
	public void PrintRoom() {
		for (int i = 0; i < room.length; i++) {
			String[] row = room[i];
			StringBuilder test = new StringBuilder();
			for (int j = 0; j < row.length; j++) {
				test.append(row[j]);
			}
			System.out.println(test);
		}
	}
	
	public void SetPlayerLocation(int y, int x) {
		if (y != 0 && x != 0) {
			room[PlayerLocation[0]][PlayerLocation[1]] = String.valueOf(' ');
			room[y][x] = String.valueOf("\uD83D\uDC7D");
			PlayerLocation = new int[]{y, x};
		}
	}
	
	public void SetMonsterLocation(int y, int x) {
		if (y != 0 && x != 0) {
			room[MonsterLocation[0]][MonsterLocation[1]] = String.valueOf(' ');
		}
		room[y][x] = String.valueOf("\uD83D\uDC7E");
		MonsterLocation = new int[]{y, x};
	}
	
	public void SetLoot(int y, int x, String[][] loot) {
		room[y][x] = String.valueOf("☒");
		lootTable[y + '.' + x] = loot;
	}
	
	
	public int px() {
		return PlayerLocation[1];
	}
	
	public int py() {
		return PlayerLocation[0];
	}
	
	public int mx() {
		return MonsterLocation[1];
	}
	
	public int my() {
		return MonsterLocation[0];
	}
	
}
