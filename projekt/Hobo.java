class Hobo {
    private String name;
    private String gender;
     private String item;
    private int healthPoints;
    private int manaPoints;

    public Hobo(String name) {
        this.gender = gender;
        this.name = name;
        this.healthPoints = 100;
        this.manaPoints = 100;
        this.item = item;
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
        public int getItem() {
        return item;
    }
public void takeHit(int hitPoints) {
        this.healthPoints = this.healthPoints - hitPoints;
        }
public boolean isDead() {
        return healthPoints <= 0;
        }}
