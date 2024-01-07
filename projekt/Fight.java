import java.util.Scanner;

public class Fight {
    public static void fight(Hobo player, Hobo enemy) {
        Scanner input = new Scanner(System.in);
        System.out.println("Rozpoczynamy walkę!");

        while (!player.isDead() && !enemy.isDead()) {

            // Gracz ma możliwość wyboru
            System.out.println("Co chcesz zrobić? (Wprowadź odpowiednią komendę):");
            System.out.println("a - Atak");
            System.out.println("b - Użyj przedmiotu");
            System.out.println("help - Informacje o dostępnych akcjach");

            String command = input.next();
            String parameter = "";

            if (command.equals("b")) {
                System.out.println("Podaj nazwę przedmiotu:");
                parameter = input.next();
            }

            playerTurn(player, enemy, command, parameter);
            if (!enemy.isDead()) {
                enemyTurn(player, enemy);
            }
                        // Wyświetl informacje o graczu i przeciwniku
            System.out.printf("Ty: %d HP %d MP\nPrzeciwnik: %d HP %d MP\n",
                    player.getHealthPoints(), player.getManaPoints(),
                    enemy.getHealthPoints(), enemy.getManaPoints());
        }

        // Wyświetl wynik walki
        if (player.isDead()) {
            System.out.println("Przegrałeś walkę! Koniec symulacji.");
        } else {
            System.out.println("Gratulacje! Wygrałeś walkę! Przeciwnik pokonany.");
            // Dodatkowe działania po pokonaniu przeciwnika, np. zdobycie przedmiotu
        }
    }

    private static void playerTurn(Hobo player, Hobo enemy, String command, String parameter) {
        Activities activities = new Activities();
        try {
            switch (command) {
                case "a": // attack
                    activities.attack();
                    enemy.takeHit(player.getAttackPoints());
                    break;
                case "b": // item use
                    activities.itemsUse(parameter);
                    break;
                case "help": // info
                    activities.help("");
                    break;
                default:
                    System.out.println("Nieprawidłowa komenda!");
            }
        } finally {

        }
    }

    private static void enemyTurn(Hobo player, Hobo enemy) {
        // Przeciwnik używa swojego ataku
        System.out.println(enemy.getName() + " atakuje ciebie!");
        player.takeHit(enemy.getAttackPoints());
    }
}
