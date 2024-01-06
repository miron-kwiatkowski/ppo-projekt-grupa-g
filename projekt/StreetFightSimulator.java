import java.util.Scanner;

public class StreetFightSimulator {
            public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                System.out.println("Witaj w symulatorze walk ulicznych! " +
                        "\nCeka cię wielkie wyzwanie stoczenia boju z najwybitniejszymi jednostkami naszego miasta. \n" +
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
                Hobo player = new Hobo(name, gender);
                System.out.println("Witaj, " + name + "! Cieszę się, że dołączyłeś do symulatora walk ulicznych.");
                System.out.println(player.toString());

                //GENERUJ PIERWSZEGO PRZECIWNIKA - tu wylosować
                Hobo enemy1 = new Hobo("Grażynka","k");
                System.out.println("Pora na spokojną przechadzkę po naszym pięknym wigwizdowie. " +
                        "\nAle coż to, twój pierwszy przeciwnik wyłania się z za winkla!");
                System.out.println(enemy1.toString());
                // ROZPOCZNIJ WALKĘ
                Fight.fight(player, enemy1);
            }
        }



        //wybieranie opcji
            //wyświetl opocje
    /*private static void executeCommand(Collection collection, String command, String parameter) throws InvalidCommandException {
        try {
            switch (command) {
                case "a": //attack
                        Activietes.attack();
                    break;
                case "spa": //specjal attack
                    Activietes.specialAttack();
                    break;
                case "i": //items
                    activietes = activietes.items(parameter);
                    break;
                case "ia": //ataki z itemkow
                    collection.clear();
                    break;
                case "help": //info co można zrobić
                    collection.help(parameter);
                    break;
                default:
                    throw new InvalidCommandException();
            }
         } catch (InputException e) {
        new Handler().handle(e);}
        }*/
            //sprawdzaj żywotność gracza i przeciwnika
            //jeśli martwy gracz koniec gry.exe
            //jeśli przeciwnik martwy dodaj itemki i pogratuluj.exe
            //generuj następnego przeciwnika i powtórz akcje
            //walka z bossem po np. 3 przeciwnikach
            //koniec gry
