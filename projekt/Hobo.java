class Hobo {
    private String name;
    private String gender;
    private int healthPoints;
    private int manaPoints;

    public Hobo(String name) {
        this.gender = gender;
        this.name = name;
        this.healthPoints = 100;
        this.manaPoints = 100;
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
public void takeHit(Integer hitPoints) {
        this.healthPoints = this.healthPoints - hitPoints;
        }
public boolean isDead() {
        return healthPoints <= 0;
        }}
