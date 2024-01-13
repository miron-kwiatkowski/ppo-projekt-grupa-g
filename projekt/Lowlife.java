public class Lowlife extends Hobo {
    private int attackPoints;

    public Lowlife(String name, String gender, String title) {
        super(name, gender);
        this.title = title;
        this.className = "Patus";
        this.attackPoints = 10;
        this.item = "Kij";
    }

  public void specialAttack(Hobo target) {
        System.out.println(getName() + " używa specjalnego ataku!");
        target.takeHit(getAttackPoints() + 10); // Atak specjalny zwiększa obrażenia o 10
        this.manaPoints -= 10; // Odejmuje 10 punktów many po użyciu specjalnego ataku

    public void attack(Hobo target) {
        System.out.println(getName() + " daje ci z łokcia\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    @Override
    public String toString() {
        return super.toString() + "\nAtakuje z siłą: " + getAttackPoints();
    }
}
