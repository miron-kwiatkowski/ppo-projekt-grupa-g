public class ChurchDoorkeeper extends Hobo {

    public ChurchDoorkeeper() {
        super();
        setName("Julek");
        setGender("m");
        setTitle("spod kościoła");
        setClassName("Odźwierny");
        setAttackPoints(20);
        setItem("krzyż");
    }

    public void specialAttack(Hobo target) {
        System.out.println(getName() + " kropi cię wodą święconą");
        target.takeHit(getAttackPoints() + 10); // Atak specjalny zwiększa obrażenia o 10
        takeManaPoints(10);  // Odejmuje 10 punktów many po użyciu specjalnego ataku
    }

    public void attack(Hobo target) {
        System.out.println(getName() + " odmawia modlitwę.\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    @Override
    public String toString() {
        return super.toString();
    }

}


