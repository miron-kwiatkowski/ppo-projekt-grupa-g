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
            System.out.println("Gracz rzuca klejpałą!");
            player.takeHit(5); // Przykładowa wartość obrażeń od klejpały
        });
        itemActions.put("Tulipan", player -> {
            System.out.println("Gracz uderza tulipanem!");
            player.takeHit(10); // Przykładowa wartość obrażeń od tulipana
        });
        itemActions.put("Bombelek", player -> {
            System.out.println("Gracz rzuca bombelka!");
            player.takeHit(15); // Przykładowa wartość obrażeń od bombelka
        });

         itemActions.put("Laczek", player -> {
            System.out.println("Gracz uderza laczkiem!");
            player.takeHit(10); // Przykładowa wartość obrażeń od laczka
        });
         itemActions.put("Strzykawka", player -> {
            System.out.println("Gracz używa zużytej strzykawki! Zadaje większe obrażenia, ale dostał również HIV!");
            player.takeHit(10); // Przykładowa wartość obrażeń od tulipana
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
