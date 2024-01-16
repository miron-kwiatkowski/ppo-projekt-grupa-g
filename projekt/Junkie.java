public class Junkie extends Hobo {

    public Junkie(String name, String gender, String title) {
        super(name, gender, title);
        setClassName("Ćpun");
        setAttackPoints(10);
        setItem("strzykawka");
    }

  public void specialAttack(Hobo target) {
        System.out.println(getName() + " bierze twarde narkotyki, które zwiększyły jego moc");
        target.takeHit(getAttackPoints() + 10); // Atak specjalny zwiększa obrażenia o 10
        takeManaPoints(10);  // Odejmuje 10 punktów many po użyciu specjalnego ataku
  }

    public void attack(Hobo target) {
        System.out.println(getName() + " grozi ci\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
