import java.util.Scanner;
import Exceptions.*;

public class StreetFightSimulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Witaj w symulatorze walk ulicznych! " +
                    "\nCzeka cię wielkie wyzwanie stoczenia boju z najwybitniejszymi jednostkami naszego miasta. \n" +
                    "Pora abyś powiedział nam kim jesteś.");

            System.out.println("Podaj swoje imię przybyszu:");
            String name = input.next();

            System.out.println("Podaj swoją płeć (m/k):");
            String gender = input.next();

            if (!"m".equals(gender) && !"k".equals(gender)) {
                throw new GenderException();
            }

            String title = Generator.generateRandomTitle();
            Hobo player = new Hobo(name, gender, title);
            System.out.println("\n\nWitaj, " + name + "! Cieszę się, że dołączasz do symulatora walk ulicznych.\nOd dzisiaj zwiesz się:");
            System.out.println(player.toString());

            System.out.println("\nPora na spokojną przechadzkę po naszym pięknym wygwizdowie. " +
                    "\nAle coż to, twój pierwszy przeciwnik wyłania się zza winkla!");

            int battles = 0;

            while (!player.isDead()) {
                if (battles == 3) {
                    ChurchDoorkeeper churchDoorkeeper = new ChurchDoorkeeper();
                    Satanist satanist = new Satanist();
                    System.out.println("\nMijasz kościół, zastanawiasz się czy woda święcona ma w sobie procenty. Gdy już zamierzasz podpić wodę z kościelnej misy, napotykasz kogoś kto nie chce dzielić się \"procentami\".");
                    Fight.bossFight(player, churchDoorkeeper);
                    if (!player.isDead()) {
                        player.applyHealing(30);
                        player.applyManaRestoration(30);
                        System.out.println("Udało ci się przeżyć! Oto twoja nagroda: +30 HP, +30 MP");
                        System.out.println("Ale cóż to! Odźwierny zaczął przechodzić transformację! Czy to sam Szatan w niego wstąpił!");
                        Fight.bossFight(player, satanist);
                        System.out.println("\n\nGratulacje " + player.getName() + ", udało ci się przetrwać spokojny niedzielny spacer po naszym blokowisku.");
                        break;
                    }
                } else {
                    Fight.fight(player);
                }
                if (!player.isDead()) {
                    player.applyHealing(30);
                    player.applyManaRestoration(30);
                    System.out.println("Udało ci się przeżyć! Oto twoja nagroda: +30 HP, +30 MP");
                    battles++;
                } else {
                    System.out.println("\n\nNo, było blisko, ale ostatecznie nie udało ci się pokonać każdego przeciwnika na tym jakże spokojnym blokowisku.");
                    break; // Dodajemy break, aby przerwać pętlę, gdy gracz przegra walkę
                }
            }

            System.out.print("Dziękujemy, że ");
            if (player.getGender().equals("m")) {
                System.out.print("zechciałeś ");
            } else if (player.getGender().equals("k")) {
                System.out.print("zechciałaś ");
            }
            System.out.print("spróbować swoich sił w zaciekłej walce :>\n\nTwórcy gry:\nEwa Kubera\nMiron Kwiatkowski\nAmelia Wałek\nPatrycja Marucińska\n\nMamy nadzieję, że rozgrywka wywołała chociaż lekki uśmiech ;D\n");
        } catch (GenderException | InvalidCommandException | UnknownItemException e) {
            System.out.println("Błąd: " + e.getMessage());
        } finally {
            input.close();
        }
    }
}
