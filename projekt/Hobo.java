import java.util.Random;
class Hobo {
    String name;
    String gender;
    String className;
    String title;
    String item;
    int healthPoints;
    int manaPoints;
    int attackPoints;

    public Hobo(String name, String gender) {
        this.gender = gender;
        this.name = name;
        this.title = "z Podlasia";
        this.className="Żul";
        this.healthPoints = 100;
        this.manaPoints = 100;
        this.item = "Tulipan";
        this.attackPoints = generateRandomAttackPoints();
    }

    public Hobo(String name, String gender, String title) {
        this.gender = gender;
        this.name = name;
        this.title = title;
        this.className="Żul";
        this.healthPoints = 100;
        this.manaPoints = 100;
        this.item = "Tulipan";
        this.attackPoints = generateRandomAttackPoints();
    }

    private int generateRandomAttackPoints() {
        Random random = new Random();
        return random.nextInt(40) + 10;
    }

    public void specialAttack(Hobo target) {
        System.out.println(getName() + " używa specjalnego ataku!");
        target.takeHit(getAttackPoints() + 15); // Atak specjalny zwiększa obrażenia o 10
        this.manaPoints -= 10; // Odejmuje 10 punktów many po użyciu specjalnego ataku
    }
    public void applyHealing(int healingPoints) {
        this.healthPoints = Math.min(100, this.healthPoints + healingPoints); // Nie przekracza maksymalnej ilości HP
    }

    public void applyManaRestoration(int restorationPoints) {
        this.manaPoints = Math.min(100, this.manaPoints + restorationPoints); // Nie przekracza maksymalnej ilości MP
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
    public String getItemName() {
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
    }

    public void attack(Hobo player) {
    }
}
