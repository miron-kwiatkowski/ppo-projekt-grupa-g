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
            System.out.println("Gracz używa batonika!");
            player.applyHealing(15); // Przywraca zdrowie
        });
        buffActions.put("Amarenka", player -> {
            System.out.println("Gracz używa amarenki");
            player.applyManaRestoration(10); // Przywraca many
        });
        // Dodaj więcej akcji dla innych buffów, jeśli potrzebujesz
    }

    public void itemsUse(String itemName, Hobo player) {
        itemActions.getOrDefault(itemName, player1 -> System.out.println("Nieznany przedmiot: " + itemName)).accept(player);
    }

    public void itemsBuffs(String buffName, Hobo player) {
        buffActions.getOrDefault(buffName, player1 -> System.out.println("Nieznany buff: " + buffName)).accept(player);
    }
}
