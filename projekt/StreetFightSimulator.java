import java.util.Scanner;

public class StreetFightSimulator {
            public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                System.out.println("Witaj w symulatorze walk ulicznych! " +
                        "\nCzeka cię wielkie wyzwanie stoczenia boju z najwybitniejszymi jednostkami naszego miasta. \n" +
                        "Pora abyś powiedział nam kim jesteś.");

                System.out.println("Podaj swoje imię przybyszu:");
                String name = input.next();
                System.out.println("Podaj swoją płeć (m/k):");
                String gender = input.next();
                if ("m".equals(gender)) {
                    System.out.println("Jesteś mężczyzną!");
                } else if ("k".equals(gender)) {
                    System.out.println("Jesteś kobietą!");
                } else {
                    System.out.println("Nieprawidłowy wybór płci."); //TU BĘDZIE BŁĄD WSTAWIONY (ogólnie to zmienimy xd)
                }
                String title = Generator.generateRandomTitle();
                Hobo player = new Hobo(name, gender, title);
                System.out.println("Witaj, " + name + "! Cieszę się, że dołączyłeś do symulatora walk ulicznych.");
                System.out.println(player.toString());

                //GENERUJ PIERWSZEGO PRZECIWNIKA - tu wylosować
                System.out.println("Pora na spokojną przechadzkę po naszym pięknym wigwizdowie. " +
                        "\nAle coż to, twój pierwszy przeciwnik wyłania się z za winkla!");
                // ROZPOCZNIJ WALKĘ
                int battles = 0;
                while(!player.isDead()){
                        //if(battles%3==0){
                                    //bossfight
                        //}
                        //else {
                        Fight.fight(player);
                        //}
                        if(!player.isDead()){
                              System.out.println("Gratulacje użytkowniku, wygrałeś nowy Iphone 6S");     
                }
                            battles++;
            }
        }
