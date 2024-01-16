public class StreetDweller extends Hobo {

    public StreetDweller(String name, String gender, String title) {
        super(name, gender, title);
        setClassName("Menel");
        setAttackPoints(10);
        setItem("klejpała");
    }

  public void specialAttack(Hobo target) {
        System.out.println(getName() + " używa tajemnej techniki Chlaj-taj!");
        target.takeHit(getAttackPoints() + 10); // Atak specjalny zwiększa obrażenia o 10
        takeManaPoints(10);  // Odejmuje 10 punktów many po użyciu specjalnego ataku
  }

    public void attack(Hobo target) {
        System.out.println(getName() + " hara na ciebie\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
