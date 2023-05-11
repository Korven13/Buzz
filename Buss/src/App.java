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
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
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
            String str = String.format("%06d", plats[2][i]);
            sortera[0][i] = Integer.parseInt(str.substring(4,6));
            System.out.println(sortera[0][i]);
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










public static void sortering() {
    //Tar fram antelet plateser som är bokade
        int antalplats = 0;
        for (int i=0; i<20; i++){
            if (plats[1][i]==1){
                antalplats += 1;
            }
            else{
                continue;
            }
        }

    //Skapar två arrayer som är längden av antalet platser  
        int personummerplatserålder[]  = new int[antalplats];
        int personummerplatser[] = new int[antalplats];
        int g = 0;
        for (int i=0; i<20; i++){
            if (plats[2][i]>0){
                personummerplatserålder[g] = PersNumÅlder(Integer.toString(plats[2][i]));
                personummerplatser[g] = i;
                g = g+1;
            }
            else{
                continue;
            }
        }  
    //går igenom alla platser och ger ena arrayen värdet på personummret och andra åldern på personen som sitter på den platsen
       


        int temp = 0;          
        for (int i = 0; i <personummerplatserålder.length; i++) {  
          for (int j = i+1; j <personummerplatserålder.length; j++) {    
            //För varje element i personummerplatserålder jämförs det med varje efterföljande element i arrayen
              if(personummerplatserålder[i] >personummerplatserålder[j]) {  
                // Om det efterföljande elementet är mindre än det aktuella elementet så byter de plats i arrayen.
                // Samtidigt byter också motsvarande element i personummerplatser-arrayen plats.  
                 temp = personummerplatserålder[i];    
                 personummerplatserålder[i] = personummerplatserålder[j];    
                 personummerplatserålder[j] = temp;  
                 temp = personummerplatser[i];    
                 personummerplatser[i] =personummerplatser[j];    
                 personummerplatser[j] = temp;  
               }    
            }    
        }
        //Sorterar åldrarna från minst till störst och anger samtidigt vilken plats den åldern sitter på
       
        System.out.println("info för platser i ordninng");
        for (int i=0; i<antalplats; i++){
            System.out.println("plats "+i+" i ordningen");
            System.out.println("------------------------");
            System.out.println("sitter på plats: "+ (personummerplatser[i]));
            System.out.println("personummer: "+plats[2][personummerplatser[i]]);
            System.out.println("Namn: "+platserinfo[0][personummerplatser[i]]);
            System.out.println("Kön: "+ platserinfo[1][personummerplatser[i]]);
            System.out.println("ålder: "+ personummerplatserålder[i]);
            System.out.println("------------------------");
            // Printar ut allt i ordning baserat på tidigare alorithmer
    }
}





public static int bokningskostnaduträkning(int under18, int over18, int over69) {
        int cost = 0;
        if (under18 == 0 && over18 == 0 && over69 == 0) {
            return 0;
        }
           
            if (under18 > 0) {
                cost += 149;
                under18--;
            }
            else if (over18 > 0) {
                cost += 299;
                over18--;
               
            }
            else if (over69 > 0) {
                cost += 200;
                over69--;
            }
            return cost + bokningskostnaduträkning(under18, over18, over69);
           
}
