public class Junkie extends Hobo {
    private int attackPoints;
    private String title;
    private String className;

    public Junkie(String name, String gender, String title) {
        super(name, gender);
        this.title = title;
        this.className = "Ćpun";
        this.attackPoints = 10;
        this.item = "Strzykawka";
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void attack(Hobo target) {
        System.out.println(getName() + " grozi ci\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    @Override
    public String toString() {
        return super.toString() + "\nAtakuje z siłą: " + getAttackPoints();
    }
}
