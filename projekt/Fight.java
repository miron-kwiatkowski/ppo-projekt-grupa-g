import Exceptions.InvalidCommandException;
import Exceptions.UnknownItemException;

import java.util.Scanner;
import java.util.Random;

public class Fight {

    private static final int NORMAL_ATTACK_PROBABILITY = 50;  // Prawdopodobieństwo zwykłego ataku (w procentach)
    private static final int SPECIAL_ATTACK_PROBABILITY = 20; // Prawdopodobieństwo specjalnego ataku
    private static final int ITEM_USE_PROBABILITY = 15;      // Prawdopodobieństwo użycia specjalnego przedmiotu
    private static final int BUFF_USE_PROBABILITY = 10;      // Prawdopodobieństwo użycia buffa

    private static void printMenu(){
        System.out.println();
        System.out.println("Co chcesz zrobić? (Wprowadź odpowiednią komendę):");
        System.out.println("a - Atak");
        System.out.println("b - Użyj przedmiotu");
        System.out.println("c - Specjalny Atak");
        System.out.println("d - Użyj buffa");
        System.out.println("q - Zakończ grę");
    }
    private static void printItems(){
        System.out.println();
        System.out.println("Tu jest lista broni do użytku, uwaga, jesteś lekko wstawiony i brakuje ci koordynacji, więc zadajesz obrażenia również sobie:");
        System.out.println("Klejpała - Wyjęta ze śmietnika, potężna laska kleju na gorąco. Idealna do pałowania przeciwników. Zadaje 20 obrażeń przeciwnikowi.");
        System.out.println("Tulipan - Rozbita o krawężnik pusta butelka po Amarence. Broń krucha, ale jakże skuteczna. Zadaje 25 obrażeń przeciwnikowi.");
        System.out.println("Bombelek - Amunicja wielokrotnego użytku - rzucasz, a po trafieniu w przeciwnika bachorek wraca. Zadaje 20 obrażeń przeciwnikowi.");
        System.out.println("Kij - Nie stać cię na prawdziwy kij baseballowy? Nic straconego! Kij od miotły zadziała równie skutecznie. Zadaje 25 obrażeń przeciwnikowi.");
        System.out.println("Strzykawka - Lepiej na nią uważać. Nie wiadomo ile osób korzystało z niej wcześniej. Zadaje 30 obrażeń przeciwnikowi.");

    }
    private static void printBuffs(){
        System.out.println();
        System.out.println("Lista przedmiotów:");
        System.out.println("Batonik - Tani i w miarę pożywny. Podnosi poziom cukru. + 20 hp");
        System.out.println("Pizza - Kawałek starej pizzy znaleziony przy śmietniku. Szkoda, że hawajska... + 40 hp -20 mp");
        System.out.println("Mortadela - Ulubiona szynka, która nie widziała mięsa w składzie. + 30 hp - 5 mp");
        System.out.println("Bułka - Kajzerka z ulubionego dyskontu. 33 grosze, a tyle smaku. Idealna do mortadeli. + 20 hp");
        System.out.println("Amarenka - Mirabelkowa Amarenka. Nic dodać, nic ująć. Pyszny smak, a jak sponiewiera! + 15 mp");
        System.out.println("Winko - Najtańszy winiacz jaki tylko można było znaleźć. Nie dość mocny, aby upić się po butelce. + 5 mp");
        System.out.println("Piwko - Jedyne słuszne - Mocny VIP za całe 1,99! Można się nayebać za dobre pieniądze. + 20 mp");
        System.out.println("Wódeczka - Królowa wśród tanich alkoholi. Nie ważne czy to małpeczka czy półlitrówka, jej cudowna moc zawsze zostanie doceniona. + 30 mp -15 hp");
    }
    private static void printStats(Hobo player,Hobo enemy){
        System.out.println();
        System.out.printf("Ty: %d HP %d MP\nPrzeciwnik: %d HP %d MP\n",
            player.getHealthPoints(), player.getManaPoints(),
            enemy.getHealthPoints(), enemy.getManaPoints());}

        private static void printQuit(){
        System.out.println("Postanowiłeś opuścić to blokowisko, rozpocząć nowe życie i wreszczie wyjść z marginesu społecznego. Trochę szkoda, bo szykowała się niezła jatka...");

        System.out.print("\nTwórcy gry:\nEwa Kubera\nMiron Kwiatkowski\nAmelia Wałek\nPatrycja Marucińska\n\nMamy nadzieję, że rozgrywka wywołała chociaż lekki uśmiech ;D\n");}

    public static void fight(Hobo player) throws InvalidCommandException, UnknownItemException {
        Hobo enemy = Generator.generateRandomEnemy();
        Scanner input = new Scanner(System.in);
        Items items = new Items();
        System.out.println();
        System.out.println("Pojawił się twój przeciwnik:");
        System.out.println(enemy);
        System.out.println("Rozpoczynamy walkę!");

        while (!player.isDead() && !enemy.isDead()) {

            printMenu();

            String command = input.next();

            if (command.equals("q")) {
                printQuit();
                System.exit(0);
            }


            String parameter = "";

            if (command.equals("b")) {
                printItems();
                System.out.println("Podaj nazwę przedmiotu:");
                parameter = input.next();
            }
            else if(command.equals("d")){
                printBuffs();
                System.out.println("Podaj nazwę przedmiotu:");
                parameter = input.next();
            }

            playerTurn(player, enemy, items, command, parameter);

            printStats(player,enemy);

            if (!enemy.isDead()) {
                enemyTurn(player, enemy);
                printStats(player,enemy);
            }
        }

        printStats(player,enemy);

        if (player.isDead()) {
            System.out.println("Przegrałeś walkę! Koniec symulacji.");
        } else {
            System.out.println("Gratulacje! Wygrałeś walkę! Przeciwnik pokonany.");
        }
    }
    public static void bossFight(Hobo player,Hobo enemy) throws InvalidCommandException, UnknownItemException {
        Scanner input = new Scanner(System.in);
        Items items = new Items();
        System.out.println("Strzeż się go!:");
        System.out.println(enemy);
        System.out.println("Rozpoczynamy walkę!");

        while (!player.isDead() && !enemy.isDead()) {

            printMenu();

            String command = input.next();

            if (command.equals("q")) {
                printQuit();
                System.exit(0); // Zakończ cały program
            }


            String parameter = "";

            if (command.equals("b")) {
                printItems();
                System.out.println("Podaj nazwę przedmiotu:");
                parameter = input.next();
            }
            else if(command.equals("d")){
                printBuffs();
                System.out.println("Podaj nazwę przedmiotu:");
                parameter = input.next();
            }

            playerTurn(player, enemy, items, command, parameter);

            printStats(player,enemy);

            if (!enemy.isDead()) {
                enemyTurn(player, enemy);
                printStats(player,enemy);
            }
        }

        printStats(player,enemy);

        if (player.isDead()) {
            System.out.println("Poniosłeś sromotną klęskę, teraz spłoniesz w piekle.");
        } else {
            System.out.println("Udało ci się, zwycięstwo!");
        }
    }
    private static void playerTurn(Hobo player, Hobo enemy, Items items, String command, String parameter) {
        Scanner input = new Scanner(System.in);
        boolean validCommand = false;

        while (!validCommand) {
            try {
                switch (command.toLowerCase()) {
                    case "a":
                        enemy.takeHit(player.getAttackPoints());
                        validCommand = true;
                        break;
                    case "b":
                        items.itemsUse(parameter.toLowerCase(), enemy);
                        validCommand = true;
                        break;
                    case "c":
                        if (player.getManaPoints() >= 10) {
                            player.specialAttack(enemy);
                            validCommand = true;
                        } else {
                            System.out.println("Nie masz wystarczająco many do użycia specjalnego ataku!");
                        }
                        break;
                    case "d":
                        Items.itemsBuffs(parameter.toLowerCase(), player);
                        validCommand = true;
                        break;
                    case "q":
                        printQuit();
                        System.exit(0); // Kończy działanie programu
                        break;
                    default:
                        throw new InvalidCommandException();
                }
            } catch (InvalidCommandException e) {
                System.out.println("Błąd: " + e.getMessage());
                System.out.println("Twoja tura zostanie powtórzona.");
            } catch (UnknownItemException e) {
                System.out.println("Błąd: Nieznany przedmiot - " + e.getItemName());
                System.out.println("Twoja tura zostanie powtórzona.");
            }

            if (!validCommand) {
                printMenu();
                command = input.next().toLowerCase();
                input.nextLine();

                if (command.equals("b") || command.equals("d")) {
                    if (command.equals("b")) {
                        printItems();
                        System.out.println("Podaj nazwę przedmiotu:");
                    } else {
                        printBuffs();
                        System.out.println("Podaj nazwę przedmiotu:");
                    }
                    parameter = input.next().toLowerCase();
                    input.nextLine();
                } else {
                    parameter = null;
                }
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
