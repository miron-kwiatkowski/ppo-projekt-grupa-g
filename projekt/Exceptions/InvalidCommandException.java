package Exceptions;
public class InvalidCommandException extends Exceptions.InputException {
  public InvalidCommandException() {
    super("Nieprawidłowe polecenie. Jeśli chcesz się dowiedzieć co możesz zrobić, wpisz \"help\"");
  }

  @Override
  public boolean shouldBreak() {
    return super.shouldBreak();
  }
}
