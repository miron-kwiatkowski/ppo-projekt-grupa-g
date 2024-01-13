public class Lowlife extends Hobo {
    private int attackPoints;
    private String item;

    public Lowlife(String name, String gender, String title) {
        super(name, gender);
        this.title = title;
        this.className = "Patus";
        this.attackPoints = 10;
        this.item = "Kij";
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void attack(Hobo target) {
        System.out.println(getName() + " daje ci z łokcia\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    public String getItemName(){
        return item;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAtakuje z siłą: " + getAttackPoints();
    }
}
