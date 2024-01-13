public class Parent extends Hobo {
    private int attackPoints;
    private String title;
    private String className;

    public Parent(String name, String gender, String title) {
        super(name, gender);
        this.title = title;
        this.className = "Karyna";
        this.attackPoints = 10;
        this.item = "Bombelek";
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void attack(Hobo target) {
        System.out.println(getName() + " wyzywa cię od nierobów\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    @Override
    public String toString() {
        return super.toString() + "\nAtakuje z siłą: " + getAttackPoints();
    }
}
