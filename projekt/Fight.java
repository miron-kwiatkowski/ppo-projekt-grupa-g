import java.util.Scanner;
import java.until.Random;

public class Fight {
    public static void fight(Hobo player, Hobo enemy) {
        Scanner input = new Scanner(System.in);
        Items items = new Items();
        System.out.println("Rozpoczynamy walkę!");

        while (!player.isDead() && !enemy.isDead()) {
            System.out.printf("Ty: %d HP %d MP\nPrzeciwnik: %d HP %d MP\n",
                    player.getHealthPoints(), player.getManaPoints(),
                    enemy.getHealthPoints(), enemy.getManaPoints());

            System.out.println("Co chcesz zrobić? (Wprowadź odpowiednią komendę):");
            System.out.println("a - Atak");
            System.out.println("b - Użyj przedmiotu");
            System.out.println("c - Specjalny Atak");
            System.out.println("d - Użyj buffa");
            System.out.println("help - Informacje o dostępnych akcjach");

            String command = input.next();
            String parameter = "";

            if (command.equals("b") || command.equals("d")) {
                System.out.println("Podaj nazwę przedmiotu/buffa:");
                parameter = input.next();
            }

            playerTurn(player, enemy, items, command, parameter);

            // Wyświetlanie statystyk po wykonaniu ruchu przez gracza
            System.out.printf("Ty: %d HP %d MP\nPrzeciwnik: %d HP %d MP\n",
                    player.getHealthPoints(), player.getManaPoints(),
                    enemy.getHealthPoints(), enemy.getManaPoints());

            if (!enemy.isDead()) {
                enemyTurn(player, enemy);
            }
        }

        // Wyświetlanie statystyk po wykonaniu ruchu przez gracza
        System.out.printf("Ty: %d HP %d MP\nPrzeciwnik: %d HP %d MP\n",
                player.getHealthPoints(), player.getManaPoints(),
                enemy.getHealthPoints(), enemy.getManaPoints());

        if (player.isDead()) {
            System.out.println("Przegrałeś walkę! Koniec symulacji.");
        } else {
            System.out.println("Gratulacje! Wygrałeś walkę! Przeciwnik pokonany.");
        }
    }

    private static void playerTurn(Hobo player, Hobo enemy, Items items, String command, String parameter) {
        Help help = new Help();
        try {
            switch (command) {
                case "a": // atak
                    enemy.takeHit(player.getAttackPoints());
                    break;
                case "b": // użycie przedmiotu na wrogu
                    items.itemsUse(parameter, enemy);
                    break;
                case "c": // specjalny atak
                    if (player.getManaPoints() >= 10) {
                        player.specialAttack(enemy);
                    } else {
                        System.out.println("Nie masz wystarczająco many do użycia specjalnego ataku!");
                    }
                    break;
                case "d": // użycie buffa
                    items.itemsBuffs(parameter, player);
                    break;
                case "help": // info
                    help.help("");
                    break;
                default:
                    System.out.println("Nieprawidłowa komenda!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

private static void enemyTurn(Hobo player, Hobo enemy) {
    int action = new Random().nextInt(4) + 1;

    switch (action) {
        case 1:
            System.out.println(enemy.getName() + " atakuje ciebie!");
            enemy.attack(player);
            break;
        case 2:
            System.out.println(enemy.getName() + " używa specjalnego ataku!");
            enemy.specialAttack(player);
            break;
        case 3:
            System.out.println(enemy.getName() + " używa specjalnego przedmiotu!");
             items.itemsUse(enemy.getItemName(), player);
            break;
        case 4:
            System.out.println(enemy.getName() + " regeneruje siły!");
            items.itemsBuffs(enemy.getBuffName(), enemy);
            break;
        default:
            // Domyślnie nie powinno się znaleźć w tym miejscu, chyba że coś poszło nie tak
            System.out.println("Coś poszło nie tak przy losowaniu akcji przeciwnika!");
            break;
    }
}
}
