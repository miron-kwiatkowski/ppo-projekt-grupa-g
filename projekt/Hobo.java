import java.util.Random;
class Hobo {
    private String name;
    private String gender;
    String className;
    private String title;
    private String item;
    private int healthPoints;
    private int manaPoints;
    private int attackPoints;

    public Hobo(String name,String gender) {
        this.gender = "gender";
        this.name = name;
        this.className="Żul";
        this.healthPoints = 100;
        this.manaPoints = 100;
        this.item = "item";
        this.attackPoints = generateRandomAttackPoints();
    }

    private int generateRandomAttackPoints() {
        Random random = new Random();
        return random.nextInt(26) + 5; // Generates a random number between 5 and 30
    }

    @Override
    public String toString() {
        return String.format(name+" "+className+" "+title+"\nStatystyki: HP-"+getHealthPoints()+" MP-"+getManaPoints());
    }

    public String getName() {
        return name;
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public int getManaPoints() {
        return manaPoints;
    }
    public String getItem() {
        return item;
    }

    public int getAttackPoints() {
        return attackPoints;
    }
    public void takeHit(int hitPoints) {
        this.healthPoints = this.healthPoints - hitPoints;
    }
    public boolean isDead() {
        return healthPoints <= 0;
    }}
