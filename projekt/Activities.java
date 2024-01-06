import java.util.function.Predicate;

public class Activities {

    public void attack() {
        System.out.println("Atak");
        // Atak zwykły postaci;
    }

    public void specialAttack() {
        System.out.println("Specjalny Atak");
        // Sprawdź klasę, użyj ataku specjalnego (np attack + dodatkowe staty);
    }

    public Activities itemsUse(String x) {
        // Atakujące przedmioty
        Predicate<String> useItemCondition = word -> {
            switch (word) {
                case "klejpała":
                    // Sprawdź czy posiada, jeśli tak użyj;
                    System.out.println("Gracz używa klejpały!");
                    // Info o obrażeniach
                    return true;
                case "tulipan":
                    // Sprawdź czy posiada, jeśli tak użyj;
                    System.out.println("Gracz używa tulipana");
                    // Info o obrażeniach
                    return true;
                case "bombelek":
                    // Sprawdź czy posiada, jeśli tak użyj;
                    System.out.println("Gracz używa bombelka");
                    // Info o obrażeniach
                    return true;
                default:
                    System.out.println("Nie dla psa!");
                    // Nie ma przedmiotu - błąd;
                    return false;
            }
        };

        if (useItemCondition.test(x)) {
            // Execute additional actions if the condition is met
        }

        return this;
    }

    public Activities itemsBusts(String x) {
        // Dodające HP i manę
        Predicate<String> bustsCondition = word -> {
            switch (word) {
                case "Batonik":
                    // Sprawdź czy posiada, jeśli tak użyj;
                    System.out.println("Dobry mars byku");
                    // Info o dodanych statach
                    return true;
                case "Amarenka":
                    // Sprawdź czy posiada, jeśli tak użyj;
                    System.out.println("MMM dobry rocznik");
                    // Info o dodanych statach
                    return true;
                default:
                    System.out.println("Nie dla psa!");
                    // Nie ma przedmiotu - błąd;
                    return false;
            }
        };

        if (bustsCondition.test(x)) {
            // Execute additional actions if the condition is met
        }

        return this;
    }

    public Activities help(String x) {
        // Informacje o dostępnych akcjach
        Predicate<String> helpCondition = word -> {
            switch (word) {
                case "":
                    System.out.println("Oto co możesz począć:" +
                            "\n- zaatakować z kopa lub bara (a)" +
                            "\n- użyć ataku specjalnego (spa), ale czy masz na to siłę?" +
                            "\n- użyj broni, nie bądź pizda! (ia)" +
                            "\n- zregeneruj siły (b)");
                    System.out.println("Chcesz dowiedzieć się więcej? Wpisz help ia/b (broń/przedmiot)");
                    break;
                case "b":
                    System.out.println("Tu jest lista buffów do użytku xd");
                    break;
                case "ia":
                    System.out.println("Tu jest lista broni do użytku");
                    break;
                default:
                    System.out.println("Błąd xd");
            }
            return true;
        };

        if (helpCondition.test(x)) {
            // Execute additional actions if the condition is met
        }

        return this;
    }
}
