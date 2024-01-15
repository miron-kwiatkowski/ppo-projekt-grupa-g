public class Parent extends Hobo {

    public Parent(String name, String gender, String title) {
        super(name, gender);
        setTitle("z Mopsu");
        setClassName("Dysfunkcyjny rodzic");
        setAttackPoints(10);
        setItem("Bombelek");
    }

  public void specialAttack(Hobo target) {
        System.out.println(getName() + " używa specjalnego ataku!");
        target.takeHit(getAttackPoints() + 10); // Atak specjalny zwiększa obrażenia o 10
        takeManaPoints(10); // Odejmuje 10 punktów many po użyciu specjalnego ataku
  }
      
    public void attack(Hobo target) {
        System.out.println(getName() + " wyzywa cię od nierobów\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
