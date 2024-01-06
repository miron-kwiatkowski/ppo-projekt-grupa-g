import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.Random;
import java.util.List;

public class Activities {
    }

    public Activities attack() {
        //atak zwykły postaci;
    }
    public Activities SpecialAttack {
            //sprawdż klase, użyj atak specjalny (np attack + dodatkowe staty);
    }

    public Activities  ItemsUse(String x) { //atakujące
        Comparator<Animal> comparator;

        switch (x) {
            case "nazwa itemu":
                //sprawdż czy posiada, jeśli tak użyj;
                break;
            case "-name":
                comparator = Comparator.comparing(Animal::getName).reversed();
                break;
            case "age":
                comparator = Comparator.comparingInt(Animal::getAge);
                break;
            case "-age":
                comparator = Comparator.comparingInt(Animal::getAge).reversed();
                break;
            case "id":
                comparator = Comparator.comparingInt(Animal::getId);
                break;
            case "-id":
                comparator = Comparator.comparingInt(Animal::getId).reversed();
                break;
            default:
                //throw new InvalidCommandException() nie ma przedmiotu błąd;
        }
        return this;
    }
    public Activities  ItemsBusts(String x) { // dodające hp i mane
        Comparator<Animal> comparator;

        switch (x) {
            case "nazwa itemu":
                //sprawdż czy posiada, jeśli tak użyj;
                break;
            case "-name":
                comparator = Comparator.comparing(Animal::getName).reversed();
                break;
            case "age":
                comparator = Comparator.comparingInt(Animal::getAge);
                break;
            case "-age":
                comparator = Comparator.comparingInt(Animal::getAge).reversed();
                break;
            case "id":
                comparator = Comparator.comparingInt(Animal::getId);
                break;
            case "-id":
                comparator = Comparator.comparingInt(Animal::getId).reversed();
                break;
            default:
                //throw new InvalidCommandException() nie ma przedmiotu błąd;
        }
        return this;

    }


