package Exceptions;
public class InvalidCommandException extends Exceptions.InputException {
  public InvalidCommandException() {
    super("Nie umiesz pisać xD Spróbuj jeszcze raz, może się uda.");
  }

  @Override
  public boolean shouldBreak() {
    return super.shouldBreak();
  }
}
