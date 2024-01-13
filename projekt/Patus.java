public class Patus extends Hobo {
    private int attackPoints;
    private String item;
    private String buff;

    public Patus(String name, String gender) {
        super(name, gender);
        this.className = "Patus";
        this.attackPoints = 10;
        this.item = "nazwa itemu";
        this.buff = "nazwa buffa";
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void attack(Hobo target) {
        System.out.println(getName() + " daje ci z łokcia\n-" + getAttackPoints() + " HP.");
        target.takeHit(getAttackPoints());
    }

    public String getItemName(){
        return item;
    }

        public String getBuffName(){
        return item;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAtakuje z siłą: " + getAttackPoints();
    }
}
