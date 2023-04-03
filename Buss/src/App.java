import java.util.Scanner;

public class App {

//2D fält för nummret på sittplatserna och tomma platser för bokning och personummer.
    static int[][] plats ={
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    
//Algoritm för att printa ut sittplatserna visuellt.
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
                if (plats[0][i]+1<10) {
                    System.out.print("    ");
                }
                else {
                    System.out.print("    ");
                }
            }
            else {
                if (plats[0][i]+1<11) {
                    System.out.print("  ");
                    if (plats[0][i]+1<9) {
                        System.out.print(" ");
                        
                    }
                }
                else {
                    System.out.print(" ");
                }

            }
        }
    }
//Välj sittplats.
    static void val(Scanner tangentbord) {
        System.out.println("\r\n" + "\r\n" + "Välj en ledig plats");
        int platsval=tangentbord.nextInt();
    }

    public static void main(String[] args) throws Exception {
        Scanner tangentbord = new Scanner(System.in);
        System.out.print("\033[H\033[2J");  
        sittplatser();
        val(tangentbord);

    }
}
