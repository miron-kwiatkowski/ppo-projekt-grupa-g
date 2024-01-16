public class Satanist extends Hobo {

    public Satanist() {
        super();
        setName("Julek");
        setGender("m");
        setTitle("prosto z piekieł");
        setClassName("Satanista");
        setAttackPoints(30);
        setItem("odwrócony krzyż");
    }

    public void specialAttack(Hobo target) {
        System.out.println(getName() + " odprawia rytuał przywołania demona.");
        target.takeHit(getAttackPoints() + 15); // Atak specjalny zwiększa obrażenia o 10
        takeManaPoints(10);  // Odejmuje 10 punktów many po użyciu specjalnego ataku
    }

    public void attack(Hobo target) {
        System.out.println(getName() + " wzywa siły nieczyste.\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
