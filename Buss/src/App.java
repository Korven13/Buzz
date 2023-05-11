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
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };
    
    //2D fält för förnamn, efternamn.
    static String[][] plats_data = {
        {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
    };

    //Konstant
    static final int Konstant = 5;

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

    //Räknar ut ålder på personen som bokat plats i
    static int ålder(int i) {
            String str = String.format("%06d", plats[2][i]);
            int ålder1 = 23-Integer.parseInt(str.substring(4,6));
            if (ålder1<0) {
                ålder1 += 100;
            }
            return ålder1;
    }

    //Printar ut alternativ och tar input från användaren för att välja.
    static void val(Scanner tangentbord) {
        Task:while(true) {
        System.out.println("\r\n" + "\r\n" + "Vad vill du göra?");
        System.out.println("1 - Boka plats");
        System.out.println("2 - Avboka plats");
        System.out.println("3 - Hitta bokning");
        System.out.println("4 - Beräkna vinst");
        System.out.println("5 - Skriv ut bokningar");
        System.out.println("6 - Avsluta");
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
                åldrar();
                break;
            case "5":
                skrivut();
                break;
            case "6":
                break Task;
            }
            System.out.println("Välj från alternativen");
        }
        
    }

    //Tar input från användaren för att boka plats, checkar ifall platsen är uptagen och tar in all info.
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
                    System.out.println("Skriv in kön: 1-Kille 2-Tjej 3-Annat");
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


    //Skrivet ut lista med info om alla resenärer, sorterad efter ålder.
    public static void skrivut() {
            int antalplatser = 0;
            for (int i=0; i<20; i++){
                if (plats[1][i]==1){
                    antalplatser++;
                }
            }
    
        //Skapar två arrays med längden av antalet platser  
            int ålder[]  = new int[antalplatser];
            int personummerplatser[] = new int[antalplatser];
            int g = 0;
            for (int i=0; i<20; i++){
                if (plats[2][i]>0){
                    ålder[g] = ålder(i);
                    personummerplatser[g] = i;
                    g++;
                }
                else{
                    continue;
                }
            }  


            int temp = 0;          
            for (int i = 0; i<ålder.length; i++) {  
              for (int j = i+1; j<ålder.length; j++) {    
                //Jämför ålder med efterföljande element.
                  if(ålder[i] >ålder[j]) {  

                    //Byter plats i arraysen efter storleksordnuing

                     temp = ålder[i];    
                     ålder[i] = ålder[j];    
                     ålder[j] = temp;  
                     temp = personummerplatser[i];    
                     personummerplatser[i] =personummerplatser[j];    
                     personummerplatser[j] = temp;  
                   }    
                }    
            }
            //Printar ut plats info i sorterad ordning.
            System.out.print("\033[H\033[2J");
            for (int i=0; i<antalplatser; i++){
                System.out.println("plats "+(i+1)+" i ordningen");
                System.out.println("------------------------");
                System.out.println("sitter på plats: "+ (personummerplatser[i]));
                System.out.println("personummer: "+ String.format("%06d", plats[2][personummerplatser[i]]));
                System.out.println("Namn: "+plats_data[0][personummerplatser[i]]);
                System.out.println("Kön: "+ plats_data[1][personummerplatser[i]]);
                System.out.println("ålder: "+ ålder[i]);
                System.out.println("------------------------");
        }
    }

    //Totala kostnaden.
    static void åldrar() {
        //Räknar antalet resenärer i varje åldersgrupp
        int under18 = 0;
        int vuxen = 0;
        int över69 = 0;
        for (int i=0; i<20; i++){
            if (plats[1][i]==1) {
                if (ålder(i)<18) {
                    under18++;
                }
                else if (ålder(i)>69) {
                    över69++;
                }
                else {
                    vuxen++;
                }
            }
        }
        //Printar ut sålda biljetter för årsgrupperna och totala intäkterna.
        System.out.print("\033[H\033[2J");
        System.out.println("Sålda biljetter:");
        System.out.println("Under 18: " + under18);
        System.out.println("Vuxen: " + vuxen);
        System.out.println("Över 69: " + över69);
        System.out.println("Totala intäkter: " + String.format("%.1f", (kostnad(under18, vuxen, över69))) + "kr");
        System.out.println("\r\n");
    }

    //Räknar ut totala intäkerna.
    public static float kostnad(int under18, int vuxen, int över69) {
        float cost = 0;
        if (under18 == 0 && vuxen == 0 && över69 == 0) {
            return 0;
        }
           
            if (under18 > 0) {
                cost += 149.9;
                under18--;
            }
            else if (vuxen > 0) {
                cost += 299.9;
                vuxen--;
               
            }
            else if (över69 > 0) {
                cost += 200;
                över69--;
            }
            return cost + kostnad(under18, vuxen, över69);
           
    }

    public static void main(String[] args) throws Exception {
        Scanner tangentbord = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        sittplatser();
        val(tangentbord);
    }
}