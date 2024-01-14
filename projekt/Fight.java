import Exceptions.InvalidCommandException;
import Exceptions.UnknownItemException;

import java.util.Scanner;
import java.util.Random;

public class Fight {

    private static final int NORMAL_ATTACK_PROBABILITY = 50;  // Prawdopodobieństwo zwykłego ataku (w procentach)
    private static final int SPECIAL_ATTACK_PROBABILITY = 20; // Prawdopodobieństwo specjalnego ataku
    private static final int ITEM_USE_PROBABILITY = 15;      // Prawdopodobieństwo użycia specjalnego przedmiotu
    private static final int BUFF_USE_PROBABILITY = 10;      // Prawdopodobieństwo użycia buffa

    public static void fight(Hobo player) throws InvalidCommandException, UnknownItemException {
        Hobo enemy = Generator.generateRandomEnemy();
        Scanner input = new Scanner(System.in);
        Items items = new Items();
        System.out.println("Pojawił się twój przeciwnik:");
        System.out.println(enemy);
        System.out.println("Rozpoczynamy walkę!");

        while (!player.isDead() && !enemy.isDead()) {

            System.out.println("Co chcesz zrobić? (Wprowadź odpowiednią komendę):");
            System.out.println("a - Atak");
            System.out.println("b - Użyj przedmiotu");
            System.out.println("c - Specjalny Atak");
            System.out.println("d - Użyj buffa");
            System.out.println("help - Informacje o dostępnych akcjach");

            String command = input.next();
            String parameter = "";

            if (command.equals("b")) {
                System.out.println("Podaj nazwę przedmiotu:");
                parameter = input.next();
            }
            else if(command.equals("d")){
                System.out.println("Podaj nazwę buffa:");
                parameter = input.next();
            }

            playerTurn(player, enemy, items, command, parameter);

            System.out.printf("Ty: %d HP %d MP\nPrzeciwnik: %d HP %d MP\n",
                    player.getHealthPoints(), player.getManaPoints(),
                    enemy.getHealthPoints(), enemy.getManaPoints());

            if (!enemy.isDead()) {
                enemyTurn(player, enemy);
                System.out.printf("Ty: %d HP %d MP\nPrzeciwnik: %d HP %d MP\n",
                        player.getHealthPoints(), player.getManaPoints(),
                        enemy.getHealthPoints(), enemy.getManaPoints());
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

    private static void playerTurn(Hobo player, Hobo enemy, Items items, String command, String parameter) throws InvalidCommandException {
        Help help = new Help();
        Scanner input = new Scanner(System.in);
        boolean validCommand = false;

        while (!validCommand) {
            try {
                switch (command) {
                    case "a": // atak
                        enemy.takeHit(player.getAttackPoints());
                        validCommand = true;
                        break;
                    case "b": // użycie przedmiotu na wrogu
                        items.itemsUse(parameter, enemy);
                        validCommand = true;
                        break;
                    case "c": // specjalny atak
                        if (player.getManaPoints() >= 10) {
                            player.specialAttack(enemy);
                            validCommand = true;
                        } else {
                            System.out.println("Nie masz wystarczająco many do użycia specjalnego ataku!");
                        }
                        break;
                    case "d": // użycie buffa
                        items.itemsBuffs(parameter, player);
                        validCommand = true;
                        break;
                    case "help": // info
                        help.help("");
                        System.out.println("Twoja tura zostanie powtórzona.");

                        System.out.println("Co chcesz zrobić? (Wprowadź odpowiednią komendę):");
                        System.out.println("a - Atak");
                        System.out.println("b - Użyj przedmiotu");
                        System.out.println("c - Specjalny Atak");
                        System.out.println("d - Użyj buffa");
                        System.out.println("help - Informacje o dostępnych akcjach");

                        command = input.next();
                        if (command.equals("b") || command.equals("d")) {
                            System.out.println("Podaj nazwę przedmiotu:");
                            parameter = input.next();
                        } else {
                            parameter = null;
                        }
                        break;
                    default:
                        throw new InvalidCommandException();
                }
            } catch (InvalidCommandException e) {
                System.out.println("Błąd: " + e.getMessage());
                System.out.println("Twoja tura zostanie powtórzona.");

                // Dodatkowe kroki, jeśli są potrzebne
                System.out.println("Co chcesz zrobić? (Wprowadź odpowiednią komendę):");
                System.out.println("a - Atak");
                System.out.println("b - Użyj przedmiotu");
                System.out.println("c - Specjalny Atak");
                System.out.println("d - Użyj buffa");
                System.out.println("help - Informacje o dostępnych akcjach");

                command = input.next();
                if (command.equals("b") || command.equals("d")) {
                    System.out.println("Podaj nazwę przedmiotu:");
                    parameter = input.next();
                } else {
                    parameter = null;
                }
            } catch (UnknownItemException e) {
                System.out.println("Błąd: Nieznany przedmiot - " + e.getItemName());
                System.out.println("Twoja tura zostanie powtórzona.");
                System.out.println("Podaj nazwę przedmiotu:");
                parameter = input.next();
            }
        }
    }

    private static int chooseEnemyAction() {
        int randomNumber = new Random().nextInt(100) + 1; // Losujemy liczbę od 1 do 100

        if (randomNumber <= NORMAL_ATTACK_PROBABILITY) {
            return 1; // Zwykły atak
        } else if (randomNumber <= NORMAL_ATTACK_PROBABILITY + SPECIAL_ATTACK_PROBABILITY) {
            return 2; // Specjalny atak
        } else if (randomNumber <= NORMAL_ATTACK_PROBABILITY + SPECIAL_ATTACK_PROBABILITY + ITEM_USE_PROBABILITY) {
            return 3; // Użycie specjalnego przedmiotu
        } else {
            return 4; // Użycie buffa
        }
    }

    private static boolean shouldUseBuff() {
        // Prawdopodobieństwo użycia buffa, gdy poziom hp spadnie poniżej lub równo 25
        return new Random().nextBoolean();
    }

    private static void enemyTurn(Hobo player, Hobo enemy) throws InvalidCommandException, UnknownItemException {
        int action = chooseEnemyAction();

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
                Items.itemsUse(enemy.getItemName(), player);
                break;
            case 4:
                if (player.getHealthPoints() <= 25 && shouldUseBuff()) {
                    String itemName = Items.randomBuff();
                    System.out.println(enemy.getName() + " regeneruje siły!");
                    Items.itemsBuffs(itemName, enemy);
                } else {
                    // Jeśli warunek na buff nie jest spełniony, wykonaj zwykły atak
                    System.out.println(enemy.getName() + " atakuje ciebie!");
                    enemy.attack(player);
                }
                break;
            default:
                System.out.println("Coś poszło nie tak przy losowaniu akcji przeciwnika!");
                break;
        }

    }
}
