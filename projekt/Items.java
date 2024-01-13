import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Items {

    private Map<String, Consumer<Hobo>> itemActions;
    private Map<String, Consumer<Hobo>> buffActions; // Przeniesiona deklaracja na poziom klasy

    public Items() {
        initializeItemActions();
        initializeBuffActions();
    }

    private void initializeItemActions() {
        itemActions = new HashMap<>();
        itemActions.put("Klejpała", player -> {
            System.out.println("Gracz rzuca klejpałą wygrzebaną ze śmietnika!");
            player.takeHit(5); //Dla menela
        });
        itemActions.put("Tulipan", player -> {
            System.out.println("Gracz uderza tulipanem z butelki po tanim winie!");
            player.takeHit(10); // dla żula
        });
        itemActions.put("Bombelek", player -> {
            System.out.println("Gracz rzuca bombelka! Ma ich sporą amunicję dzięki 500+");
            player.takeHit(15); // dla Karyny/Seby
        });

         itemActions.put("Kij", player -> {
            System.out.println("Gracz uderza kijem od miotły!");
            player.takeHit(10); // dla patusów
        });
         itemActions.put("Strzykawka", player -> {
            System.out.println("Gracz używa zużytej strzykawki! Zadaje większe obrażenia, ale dostał również HIV!");
            player.takeHit(10); // dla ćpuna
        });

        // Dodaj więcej akcji dla innych przedmiotów, jeśli potrzebujesz
    }

    private void initializeBuffActions() {
        buffActions = new HashMap<>();
        buffActions.put("Batonik", player -> {
            System.out.println("Gracz zjada batonika!");
            player.applyHealing(5); // Przywraca zdrowie
        });

         buffActions = new HashMap<>();
         buffActions.put("Pizza", player -> {
            System.out.println("Gracz zjadł starą pizzę!");
            player.applyHealing(20); // Przywraca zdrowie
        });
        
         buffActions = new HashMap<>();
         buffActions.put("Mortadela", player -> {
            System.out.println("Gracz zjada najtańszą mortadelę!");
            player.applyHealing(15); // Przywraca zdrowie
        });

         buffActions = new HashMap<>();
        buffActions.put("Bułka", player -> {
            System.out.println("Gracz zjada tanią i pożywną kajzerkę!");
            player.applyHealing(10); // Przywraca zdrowie
        });

        buffActions.put("Winko", player -> {
            System.out.println("Gracz wypija tanie winko");
            player.applyManaRestoration(10); // Przywraca many

        });
        buffActions.put("Amarenka", player -> {
            System.out.println("Gracz pije mirabelkową amarenkę");
            player.applyManaRestoration(10); // Przywraca many
        });

        buffActions.put("Piwko", player -> {
            System.out.println("Gracz wypija najtańsze piwko z Biedronki - Piwo VIP, za całe 1,99 za puszkę!");
            player.applyManaRestoration(10); // Przywraca many
        });

        buffActions.put("Amarenka", player -> {
            System.out.println("Gracz pije mirabelkową amarenkę");
            player.applyManaRestoration(10); // Przywraca many
        // Dodaj więcej akcji dla innych buffów, jeśli potrzebujesz
    }

    public void itemsUse(String itemName, Hobo player) {
        itemActions.getOrDefault(itemName, player1 -> System.out.println("Nieznany przedmiot: " + itemName)).accept(player);
    }

    public void itemsBuffs(String buffName, Hobo player) {
        buffActions.getOrDefault(buffName, player1 -> System.out.println("Nieznany buff: " + buffName)).accept(player);
    }
}
