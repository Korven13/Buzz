public class App {

    static int[][] plats ={
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    }
    ;
    static void sittplatser() {
        for (int i=0; i<21; i++) {
            if (plats[1][i] == 1) {
                System.out.print("b");
            }
            else {
                System.out.print(plats[0][i]);
            }
            if (plats[0][i]%4==0 && plats[0][i]!=20) {
                System.out.println();
            }
            else if (plats[0][i]%4==2 && plats[0][i]!=18) {
                System.out.print("   ");
            }
            else {
                System.out.print("  ");
            }
        }
    }


    public static void main(String[] args) throws Exception {
        System.out.print("\033[H\033[2J");  
        sittplatser();
    }
}
