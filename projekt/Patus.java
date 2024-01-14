public class Patus extends Hobo {
    private int attackPoints;
    private String title;
    private String className;

    public Patus(String name, String gender, String title) {
        super(name, gender);
        this.title = title;
        this.className = "Patus";
        this.attackPoints = 10;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void attack(Hobo target) {
        System.out.println(getName() + " daje ci z łokcia\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    @Override
    public String toString() {
        return super.toString() + "\nAtakuje z siłą: " + getAttackPoints();
    }
}
