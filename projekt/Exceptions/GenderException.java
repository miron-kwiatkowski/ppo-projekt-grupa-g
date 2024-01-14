package Exceptions;
public class GenderException extends InputException {
  public GenderException() {
    super("Co to za płeć? Odmieńców nie obsługujemy, bo mogli by poczuć się urażeni resztą zawartości gry. Przykro mi :<");
  }

  @Override
  public boolean shouldBreak() {
    return true;
  }
}
