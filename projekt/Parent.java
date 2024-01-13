public class Parent extends Hobo {
    private int attackPoints;
    private String title;
    private String className;

    public Parent(String name, String gender, String title) {
        super(name, gender);
        this.title = title;
        this.className = "Dysfunkcjonalny rodzic";
        this.attackPoints = 10;
        this.item = "Bombelek";
    }

  public void specialAttack(Hobo target) {
        System.out.println(getName() + " używa specjalnego ataku!");
        target.takeHit(getAttackPoints() + 10); // Atak specjalny zwiększa obrażenia o 10
        this.manaPoints -= 10; // Odejmuje 10 punktów many po użyciu specjalnego ataku
  }
      
    public void attack(Hobo target) {
        System.out.println(getName() + " wyzywa cię od nierobów\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    @Override
    public String toString() {
        return className + name + "\nAtakuje z siłą: " + getAttackPoints();
    }
}
