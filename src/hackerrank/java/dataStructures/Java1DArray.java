package hackerrank.java.dataStructures;


import java.util.Scanner;

public class Java1DArray {
    public static boolean canWin(int leap, int[] game) {
        VirtualPlayer v = new VirtualPlayer(leap, game);
        v.tick();
        return v.winnable;
    }

    static class VirtualPlayer {

        private int position = 0;
        private int leap;
        private int[] map;
        boolean winnable = false;

        public VirtualPlayer(int leap, int[] game) {
            this.leap = leap; //gets the values from the canWin function
            this.map = game;
        }

        private void moveup() {
            if (map[position + 1] == 0) {
                position++;
                tick();
            }
        }

        private void movedown() {
            if ((position - 1) >= 0 && map[position - 1] == 0) {
                map[position] = 1;
                position--;
                tick();
            }
        }

        private void jump() {
            if ((position + leap) < map.length) {
                if (map[position + leap] == 0) {
                    int posold = position;
                    position = position + leap;
                    tick();
                    position = posold;
                }
            }
        }

        void tick() {
            //System.out.println("im at:"+pos);
            if (position == (map.length - 1) || ((position + leap) >= map.length)) {
                winnable = true;
            }
            else {
                this.moveup();
                if (leap != 0) {
                    this.jump();
                } //cant jump 0 steps!
                this.movedown();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}

/*    STDIN

        4
        5 3
        0 0 0 0 0
        6 5
        0 0 0 1 1 1
        6 3
        0 0 1 1 1 0
        3 1
        0 1 0
        */
