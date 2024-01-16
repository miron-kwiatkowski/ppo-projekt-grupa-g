import java.util.Scanner;
import Exceptions.*;

public class StreetFightSimulator {
            public static void main(String[] args) throws GenderException, InvalidCommandException {
                Scanner input = new Scanner(System.in);
                System.out.println("Witaj w symulatorze walk ulicznych! " +
                        "\nCzeka cię wielkie wyzwanie stoczenia boju z najwybitniejszymi jednostkami naszego miasta. \n" +
                        "Pora abyś powiedział nam kim jesteś.");
                try {
                    System.out.println("Podaj swoje imię przybyszu:");
                    String name = input.next();

                    System.out.println("Podaj swoją płeć (m/k):");
                    String gender = input.next();

                    if (!"m".equals(gender) && !"k".equals(gender)) {
                        throw new GenderException();
                    }

                    String title = Generator.generateRandomTitle();
                    Hobo player = new Hobo(name, gender, title);
                    System.out.println("Witaj, " + name + "! Cieszę się, że dołączyłeś do symulatora walk ulicznych.");
                    System.out.println(player.toString());

                    System.out.println("Pora na spokojną przechadzkę po naszym pięknym wigwizdowie. " +
                            "\nAle coż to, twój pierwszy przeciwnik wyłania się z za winkla!");
                    // ROZPOCZNIJ WALKĘ
                    int battles = 0;
                    while (!player.isDead()) {
                        if (battles == 3) {
                            break;
                        } else {
                            Fight.fight(player);
                        }
                        if (!player.isDead()) {
                            player.applyHealing(30);
                            player.applyManaRestoration(30);
                            System.out.println("Przeżyłeś! Oto twoja nagroda: +30 HP, +30 MP");
                            battles++;
                        }
                    }
                    System.out.println("Gratulacje "+player.getName()+", udało ci się przetrwać spokojny niedzielny spacer po naszym blokowisku.\n" +
                            "Dziękujemy, że zechciałeś spróbować swoich sił :>\nTwórcy gry:\nProgramiści:\nEwa Kubera\nMiron Kwiatkowski\nDyrektorzy kreatywni:\nAmelia Wałek\nPatrycja Marucińska\n" +
                            "Mamy nadzieję, że rozgrywka była przyjemna i sprawiła ci wiele zabawy.");

                } catch (GenderException | InvalidCommandException | UnknownItemException e) {
                    System.out.println("Błąd: " + e.getMessage());
                }

            }
}
