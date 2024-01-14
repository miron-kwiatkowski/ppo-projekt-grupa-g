package Exceptions;

public class UnknownItemException extends InputException {
    private String itemName;

    public UnknownItemException(String itemName) {
        super("Nie posiadasz takiego przedmiotu: " + itemName);
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public boolean shouldBreak() {
        return super.shouldBreak();
    }
}
