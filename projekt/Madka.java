public class Madka extends Hobo {
    private int attackPoints;

    public Patus(String name, String gender) {
        super(name, gender);
        this.className = "Madka";
        this.attackPoints = 10;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void attack(Hobo target) {
        System.out.println(getName() + " zwyzywała cię od nierobów\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    @Override
    public String toString() {
        return super.toString() + "\nAtakuje z siłą: " + getAttackPoints();
    }
}
