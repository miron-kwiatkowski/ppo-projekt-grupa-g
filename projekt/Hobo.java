import java.util.Random;
class Hobo {
   private String name;
    private String gender;
    private String className;
    private String title;
    private String item;
    private int healthPoints;
    private int manaPoints;
    private int attackPoints;

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
        return random.nextInt(20) + 10;
    }

    public void specialAttack(Hobo target) {
        System.out.println(getName() + " zbiera pokłady mistycznej energi i używa tajemnego ataku Wódzitsu!");
        target.takeHit(getAttackPoints() + 15); // Atak specjalny zwiększa obrażenia o 10
        takeManaPoints(10);// Odejmuje 10 punktów many po użyciu specjalnego ataku
    }
    public void applyHealing(int healingPoints) {
        this.healthPoints = Math.min(100, this.healthPoints + healingPoints); // Nie przekracza maksymalnej ilości HP
    }

    public void applyManaRestoration(int restorationPoints) {
        this.manaPoints = Math.min(100, this.manaPoints + restorationPoints); // Nie przekracza maksymalnej ilości MP
    }
    @Override
    public String toString() {
        return String.format(getClassName()+" "+getName()+" "+getTitle()+"\nStatystyki: HP-"+getHealthPoints()+" MP-"+getManaPoints())+ "\nAtakuje z siłą: " + getAttackPoints();
    }

    public String getTitle() {return title;}

    public void setItem(String item) {
        this.item = item;
    }
    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGender() {
        return gender;
    }

    public String getItem() {
        return item;
    }

    public String getClassName() {return className;}
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
    public void takeManaPoints(int manaPoints){this.manaPoints = this.manaPoints-manaPoints;}
    public void takeHit(int hitPoints) {
        this.healthPoints = this.healthPoints - hitPoints;
    }
    public boolean isDead() {
        return healthPoints <= 0;
    }

    public void attack(Hobo player) {
    }
}
