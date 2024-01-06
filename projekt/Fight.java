import java.util.Scanner;

public class Fight {
    public static void fight(Hobo player, Hobo enemy) {
        Scanner input = new Scanner(System.in);
        System.out.println("Rozpoczynamy walkę!");

        while (!player.isDead() && !enemy.isDead()) {
            System.out.println("Co chcesz zrobić? (Wprowadź odpowiednią komendę):");
            System.out.println("a - Atak");
            System.out.println("spa - Specjalny Atak");
            System.out.println("b - Użyj przedmiotu");
            System.out.println("ia - Ataki z przedmiotów");
            System.out.println("help - Informacje o dostępnych akcjach");

            String command = input.next();
            String parameter = "";

            if (command.equals("b") || command.equals("ia")) {
                System.out.println("Podaj nazwę przedmiotu:");
                parameter = input.next();
            }

            Fight.battle(player, enemy, command, parameter);

            // Wyświetl statystyki po każdej rundzie
            System.out.println(player.toString());
            System.out.println(enemy.toString());
        }

        // Wyświetl wynik walki
        if (player.isDead()) {
            System.out.println("Przegrałeś walkę! Koniec symulacji.");
        } else {
            System.out.println("Gratulacje! Wygrałeś walkę! Koniec symulacji.");
        }
    }
    private static void battle(Hobo player, Hobo enemy, String command, String parameter) {
        Activities activietes = new Activities();
        try {
            switch (command) {
                case "a": //attack
                    activietes.attack();
                    break;
                case "spa": //specjal attack
                    activietes.specialAttack();
                    break;
                case "b": //busty
                    activietes = activietes.itemsUse(parameter);
                    break;
                case "ia": //ataki z itemkow
                    activietes = activietes.itemsBusts(parameter);
                    break;
                case "help": //info co można zrobić
                    activietes = activietes.help(parameter);
                    break;
                default:
                    System.out.println("coś nie działa");
            }
        } finally {
            
        }
        ;
    }
}