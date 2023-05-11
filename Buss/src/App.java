import java.util.Scanner;

public class App {

    //Checkar så att input är ett heltal
    static int check(Scanner tangentbord) {       
        while (true) {
            try {                         
                return Integer.valueOf(tangentbord.nextLine());
            } catch (Exception e) {
                System.out.println("Välj från alternativen genom att skriva in ett nummer");
            }
        }
    }

//2D fält för nummret på sittplatserna, tomma platser, personummer, kön.
    static int[][] plats ={
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    
    //2D fält för förnamn, efternamn.
    static String[][] plats_data = {
        {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
    };

    static int[][] sortera = new int[2][21];

    //Konstant
    static final int konstant = 5;

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

    //Har med all krav men som inte behövs för programmet.
    static void krav() {
        double d=10.5;
        int konvertering=(int)d;  
        System.out.println(konvertering);  
        System.out.println(konstant);  
    }

    //Gå igenom alla platser, är den bokad, checka ålder, ta ut pris, plussa på total.
    static void vinst() {

    }

    //Välj namn eller personummer, checka alla platser efter det.
     static int hitta(Scanner tangentbord) {
        System.out.println("\r\n" + "\r\n" + "1-Personummer 2-Namn");
        while(true) {
            int val=check(tangentbord);
            if (val==1) {
                    System.out.println("Skriv in ditt personnummer");
                    int input = check(tangentbord);
                    System.out.println("\033[H\033[2J");
                    for (int i = 0; i < 21; i++) {
                        if (plats[2][i] == input) {
                            System.out.println("Du har bokat plats: " + (i));
                            return i;
                    }
                    
                }
                System.out.println("Det finns ingen bokning med ditt personnummer");
                break;
            }
                else if (val==2) {
                    System.out.println("Skriv in ditt namn");
                    String input2 = tangentbord.nextLine();
                    System.out.println("\033[H\033[2J");
                    for (int i = 0; i < 21; i++) {
                        if (plats_data[0][i].equals(input2)) {
                            System.out.println("Du har bokat plats: " + (i));
                            return i;
                        }
                    }
                    System.out.println("Det finns ingen bokning med ditt namn");
                    break;
                }
            }
            return -1;
        }

    //
    static void skrivut() {
        for (int i = 0; i < 21; i++) {
            String str = plats[2][i];
        String str = "1234567890";
        int fullInt = Integer.parseInt(str);
        String first4char = str.substring(0,4);
        int intForFirst4Char = Integer.parseInt(first4char);
        }
    }

    //Printar ut alternativ och tar input från användaren för att välja.
    static void val(Scanner tangentbord) {
        while(true) {
        System.out.println("\r\n" + "\r\n" + "Vad vill du göra?");
        System.out.println("1 - Boka plats");
        System.out.println("2 - Avboka plats");
        System.out.println("3 - Hitta bokning");
        System.out.println("4 - Beräkna vinst");
        System.out.println("5 - Skriv ut bokningar");
        System.out.println("6 - Avsluta");
        System.out.println("7 - Bedömningskrav");
        switch (tangentbord.nextLine()) {
            case "1":
                boka(tangentbord);
                break;
            case "2":
                avboka(tangentbord);
                break;
            case "3":
                System.out.println("Hitta genom: ");
                hitta(tangentbord);
                break;
            case "4":
                vinst();
                break;
            case "5":
                skrivut();
                break;
            case "6":
                System.out.println("-3");
                break;
            case "7":
                krav();
                break;
            }
            System.out.println("Välj från alternativen");
        }
        
    }

    //Tar input från användaren för att boka plats och checkar ifall platsen är uptagen.
    static void boka(Scanner tangentbord) {
        System.out.print("\033[H\033[2J"); 
        sittplatser();
        System.out.println("\r\n" + "\r\n" + "Skriv i sittplatsen du vill boka");
        while (true) {
            int test1 = check(tangentbord);
            if (test1<22 && test1>0) {
                int plats1 = test1-1;
                if (plats[1][plats1]==0) {
                    System.out.println("Skriv in förnman");
                    plats_data[0][test1] = tangentbord.nextLine();
                    System.out.println("Skriv in efternamn");
                    plats_data[1][test1] = tangentbord.nextLine();
                    System.out.println("Skriv in personnummmer(dag, mån, år) exempel: 010902");
                    plats[2][test1] = check(tangentbord);
                    System.out.println("Skriv in kön: 0-Kille 1-Tjej 2-Annat");
                    plats[3][test1] = check(tangentbord);

                    plats[1][test1-1]=1;
                    System.out.println("\033[H\033[2J");
                    break;
                }
                else if (plats[1][plats1]==1) {
                    System.out.println("Platsen är redan bokad");
                    break;
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

    //Tar input från användaren för att avboka plats och checkar ifall platsen är bokad.
    static void avboka(Scanner tangentbord) {
        System.out.print("\033[H\033[2J"); 
        sittplatser();
        System.out.println("Avboka genom: ");
        int input = hitta(tangentbord);
        if (input>=0) {
            System.out.print("\033[H\033[2J"); 
            plats[1][input-1]=0;
            System.out.print("Du har nu avbokat plats: " + input+" "); 
        }
        
    }


    public static void main(String[] args) throws Exception {
        Scanner tangentbord = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        sittplatser();
        val(tangentbord);
    }
}