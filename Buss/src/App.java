import java.util.Scanner;

public class App {

    static int check(Scanner tangentbord) {       
        while (true) {
            try {                         
                return Integer.valueOf(tangentbord.nextLine());
            } catch (Exception e) {
                System.out.println("Välj från alternativen genom att skriva in ett nummer");
            }
        }
    }

//2D fält för nummret på sittplatserna och tomma platser för bokning och personummer.
    static int[][] plats ={
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    
//Algoritm för att printa ut sittplatserna visuellt.
    static void sittplatser() {
        for (int i=0; i<21; i++) {
            if (plats[1][i] == 1 && plats[0][i] < 10) {
                System.out.print("b");
            }

            else if (plats[1][i] == 1 && plats[0][i] > 9) {
                if (plats[0][i]%4==2) {
                    System.out.print(" ");
                }
                System.out.print("b ");
                
            }

            else {
                System.out.print(plats[0][i]);
            }
            if (plats[0][i]%4==0 && plats[0][i]!=20) {
                System.out.println();
            }
            else if (plats[0][i]%4==2 && plats[0][i]!=18) {
                if (plats[1][i]==1 && plats[0][i]>9) {
                    System.out.print("   ");
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
//Val.
    static void val(Scanner tangentbord) {
        System.out.println("\r\n" + "\r\n" + "Vad vill du göra?");
        System.out.println("1 - Boka plats");
        System.out.println("2 - Avboka plats");
        System.out.println("3 - Avsluta");
        while(true) {
        switch (tangentbord.nextLine()) {
            case "1":
                boka(tangentbord);
                break;
            case "2":
                System.out.println("-2");
                break;
            case "3":
                System.out.println("-3");
                break;
            }
            System.out.println("Välj från alternativen");
        }
        
    }

    static void boka(Scanner tangentbord) {
        System.out.print("\033[H\033[2J"); 
        sittplatser();
        System.out.println("\r\n" + "\r\n" + "Skriv i sittplatsen du vill boka");
        while (true) {
            int test1 = check(tangentbord);
            if (test1<22 && test1>0) {
                int plats1 = test1-1;
                if (plats[1][plats1]==0) {
                    System.out.println("Platsen är leding");
                }
                else if (plats[1][plats1]==1) {
                    System.out.println("Platsen är bokad");
                }
                else {
                    System.out.println("Error");
                }
            }
            else {
                System.out.println("Välj en existerande sittplats");
            }
        }
        
    }

    public static void main(String[] args) throws Exception {
        Scanner tangentbord = new Scanner(System.in);
        System.out.print("\033[H\033[2J");  
        sittplatser();
        val(tangentbord);

    }
}
