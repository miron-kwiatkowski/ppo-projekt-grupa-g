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

  public void specialAttack(Hobo target) {
        System.out.println(getName() + " używa specjalnego ataku!");
        target.takeHit(getAttackPoints() + 10); // Atak specjalny zwiększa obrażenia o 10
        this.manaPoints -= 10; // Odejmuje 10 punktów many po użyciu specjalnego ataku

    public void attack(Hobo target) {
        System.out.println(getName() + " grozi ci\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    @Override
    public String toString() {
        return super.toString() + "\nAtakuje z siłą: " + getAttackPoints();
    }
}
