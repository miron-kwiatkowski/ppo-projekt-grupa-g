public class Lowlife extends Hobo {

    public Lowlife(String name, String gender, String title) {
        super(name, gender, title);
        setClassName("Patus");
        setAttackPoints(10);
        setItem("kij");
    }

  public void specialAttack(Hobo target) {
        System.out.println(getName() + " słyszy o zbiliżającej się ustawce za garażami! Czuje przypływ adrenaliny");
        target.takeHit(getAttackPoints() + 10); // Atak specjalny zwiększa obrażenia o 10
        takeManaPoints(10);  // Odejmuje 10 punktów many po użyciu specjalnego ataku
  }

    public void attack(Hobo target) {
        System.out.println(getName() + " daje ci z łokcia\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
