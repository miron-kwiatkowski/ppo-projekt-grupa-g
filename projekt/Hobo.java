class Hobo {
    private String name;
    private String gender;
    private String className;
    private String title;
    private String item;
    private int healthPoints;
    private int manaPoints;

    public Hobo(String name,String gender) {
        this.gender = "gender";
        this.name = name;
        this.className="Żul";
        this.healthPoints = 100;
        this.manaPoints = 100;
        this.item = "item";
    }
    @Override
    public String toString() {
        return String.format(name+" "+className+" "+title+"/nStatystyki: HP-"+getHealthPoints()+" MP-"+getManaPoints());
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
    public void takeHit(int hitPoints) {
        this.healthPoints = this.healthPoints - hitPoints;
    }
    public boolean isDead() {
        return healthPoints <= 0;
    }}
