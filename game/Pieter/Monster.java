import java.util.Random;

public class Monster {
    public RoomGenerator RoomGenerator;
        private int hp;
        public Player player;

        public Monster(RoomGenerator RoomGenerator){
        this.RoomGenerator = RoomGenerator;
    }

    public void MonsterMovement(int mx, int my, int px, int py) {
        int x = mx, y = my;
        Random rand = new Random();
        int rand_int1 = rand.nextInt(2);

        if ( rand_int1 == 1){
            if (py <= my) {
                y--;
            }
            if (px <= mx) {
                x--;
            }
            if (py >= my) {
                y++;
            }
            if (px >= mx) {
                x++;
            }
            RoomGenerator.SetMonsterLocation(y, x);
        }
        if((y == py) & (x == px)) {
            System.out.println("The monster has caught up with you.");
//            if(shield == true){
//                System.out.println("You have a sword, damage reduction by one.");
//                player.doDMG(2);
//            }

        }
    }
    public void setPlayer(Player player){
            this.player = player;
    }


}
