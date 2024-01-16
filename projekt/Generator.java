import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Generator{
    private static final List<String> maleFirstNames = Arrays.asList("Mietek", "Ryszard", "Zdzichu", "Mścichuj", "Moczywór", "Andrzej", "Józek", "Stachu", "Bolek", "Marian", "Brajan", "Tadek", "Ferdek", "Bożydar");
    private static final List<String> femaleFirstNames = Arrays.asList("Karyna", "Nikola", "Andżelika", "Dżeskia", "Elka", "Helena", "Halina", "Bożenka", "Jebodyda", "Mścisława", "Kaśka", "Klaudia", "Żanetka", "Renata", "Mariola");
    private static final List<String> titles = Arrays.asList("spod Lidla", "spod Żabki", "spod Biedronki", "spod Monopolowego", "na zasiłku", "spod mostu", "z piwnicy", "z mlekiem", "spod kościoła", "z rowu", "z osiedla", "żebrzący o dwa złote" );
    

    private static final Random random = new Random();

    private static String getRandomElement(List<String> list){
        int id = random.nextInt(list.size());
        return list.get(id);
    }

    public static String generateRandomMale(){
        String firstName;

        firstName = getRandomElement(maleFirstNames);

        return firstName;
    }

    public static String generateRandomFemale(){
        String firstName;

        firstName = getRandomElement(femaleFirstNames);

        return firstName;
    }

    public static String generateRandomTitle(){
        String title;

        title = getRandomElement(titles);

        return title;
    }

    public static Hobo generateRandomEnemy(){
        double tester = Math.random();
        if(tester<1.0/4.0){
            if(Math.random()<0.5){
                return new Junkie(generateRandomMale(), "m", generateRandomTitle());
            }
            else {
                return new Junkie(generateRandomFemale(), "f", generateRandomTitle());
            }
        }
        else if(tester<2.0/4.0){
            if(Math.random()<0.5){
                return new StreetDweller(generateRandomMale(), "m", generateRandomTitle());
            }
            else {
                return new StreetDweller(generateRandomFemale(), "f", generateRandomTitle());
            }
        }
        else if(tester<3.0/4.0){
            if(Math.random()<0.5){
                return new Parent(generateRandomMale(), "m", generateRandomTitle());
            }
            else {
                return new Parent(generateRandomFemale(), "f", generateRandomTitle());
            }
        }
        else {
            if(Math.random()<0.5){
                return new Lowlife(generateRandomMale(), "m", generateRandomTitle());
            }
            else {
                return new Lowlife(generateRandomFemale(), "f", generateRandomTitle());
            }
        }
    }
}
