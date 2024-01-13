public class StreetDweller extends Hobo {
    private int attackPoints;
    private String title;
    private String className;

    public StreetDweller(String name, String gender, String title) {
        super(name, gender);
        this.title = title;
        this.className = "Menel";
        this.attackPoints = 10;
        this.item = "Klejpała";
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
