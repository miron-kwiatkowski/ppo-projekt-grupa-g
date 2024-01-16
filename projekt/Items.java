import Exceptions.InvalidCommandException;
import Exceptions.UnknownItemException;

import java.util.*;
import java.util.function.Consumer;

public class Items {

    private static Map<String, Consumer<Hobo>> itemActions;
    private static Map<String, Consumer<Hobo>> buffActions;

    public Items() {
        initializeItemActions();
        initializeBuffActions();
    }

    private void initializeItemActions() {
        itemActions = new HashMap<>();
        itemActions.put("klejpała", player -> {
            System.out.println("Gracz rzuca klejpałą wygrzebaną ze śmietnika!");
            player.takeHit(5);
        });
        itemActions.put("tulipan", player -> {
            System.out.println("Gracz uderza tulipanem z butelki po tanim winie!");
            player.takeHit(10);
        });
        itemActions.put("bombelek", player -> {
            System.out.println("Gracz rzuca bombelka! Ma ich sporą amunicję dzięki 500+");
            player.takeHit(15);
        });

        itemActions.put("kij", player -> {
            System.out.println("Gracz uderza kijem od miotły!");
            player.takeHit(10);
        });
        itemActions.put("strzykawka", player -> {
            System.out.println("Gracz używa zużytej strzykawki! Zadajesz większe obrażenia, ale dostajesz również HIV!");
            player.takeHit(15);
        });
        itemActions.put("krzyż", player -> {
            System.out.println("Gracz wymachuje krzyżem i zaczyna odprawiać egzorcyzmy.");
            player.takeHit(20);
        });
        itemActions.put("odwrócony krzyż", player -> {
            System.out.println("Gracz wymachuje odwróconym krzyżem i zaczyna mówić po aramejsku.");
            player.takeHit(30);
        });

        // Dodaj więcej akcji dla innych przedmiotów, jeśli potrzebujesz
    }

    private void initializeBuffActions() {
        buffActions = new HashMap<>();
        buffActions.put("batonik", player -> {
            System.out.println("Gracz zjada batonika!");
            player.applyHealing(5);
        });

        buffActions.put("pizza", player -> {
            System.out.println("Gracz zjada starą pizzę!");
            player.applyHealing(20);
        });

        buffActions.put("mortadela", player -> {
            System.out.println("Gracz zjada najtańszą mortadelę!");
            player.applyHealing(15);
        });

        buffActions.put("bułka", player -> {
            System.out.println("Gracz zjada tanią i pożywną kajzerkę!");
            player.applyHealing(10);
        });

        buffActions.put("winko", player -> {
            System.out.println("Gracz pije tanie winko");
            player.applyManaRestoration(5);
        });
        buffActions.put("amarenka", player -> {
            System.out.println("Gracz pije mirabelkową amarenkę");
            player.applyManaRestoration(15);
        });

        buffActions.put("piwko", player -> {
            System.out.println("Gracz pije najtańsze piwko z Biedronki - Piwo VIP, za całe 1,99 za puszkę!");
            player.applyManaRestoration(10);
        });

        buffActions.put("wódeczka", player -> {
            System.out.println("Gracz pije napój bogów - wodę ognistą!");
            player.applyManaRestoration(20);
        });
    }

    public static String randomBuff() {
        List<String> buffNames = new ArrayList<>(buffActions.keySet());
        int randomIndex = new Random().nextInt(buffNames.size());
        return buffNames.get(randomIndex);
    }

    public static void itemsUse(String itemName, Hobo player) throws UnknownItemException {
        Consumer<Hobo> action = itemActions.get(itemName);
        if (action != null) {
            action.accept(player);
        } else {
            throw new UnknownItemException(itemName);
        }
    }

    public static void itemsBuffs(String buffName, Hobo player) throws UnknownItemException {
        Consumer<Hobo> action = buffActions.get(buffName);
        if (action != null) {
            action.accept(player);
        } else {
            throw new UnknownItemException(buffName);
        }
    }
}
