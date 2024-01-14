public class StreetDweller extends Hobo {
    private int attackPoints;
    private String title;
    private String className;

    public StreetDweller(String name, String gender, String title) {
        this.name = name;
        this.gender = gender;
        this.title = title;
        this.className = "Menel";
        this.attackPoints = 10;
        this.item = "Klejpała";
    }

  public void specialAttack(Hobo target) {
        System.out.println(getName() + " używa specjalnego ataku!");
        target.takeHit(getAttackPoints() + 10); // Atak specjalny zwiększa obrażenia o 10
        this.manaPoints -= 10; // Odejmuje 10 punktów many po użyciu specjalnego ataku
  }

    public void attack(Hobo target) {
        System.out.println(getName() + " hara na ciebie\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    @Override
    public String toString() {
        return className + name + "\nAtakuje z siłą: " + getAttackPoints();
    }
}
