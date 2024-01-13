public class Menel extends Hobo {
    private int attackPoints;

    public Patus(String name, String gender) {
        super(name, gender);
        this.className = "Menel";
        this.attackPoints = 10;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void attack(Hobo target) {
        System.out.println(getName() + " hara na ciebie\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    @Override
    public String toString() {
        return super.toString() + "\nAtakuje z siłą: " + getAttackPoints();
    }
}
