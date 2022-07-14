package utils;

public class ExpressionChecker {
  public boolean checkValidity(String expression) {
    String[] words = expression.split(" ");

    if (words.length == 1 && isLegalWord(words[0])) {
      return true;
    }

    return words.length == 3
        && isLegalWord(words[0]) && isLegalWord(words[2])
        && isLegalOperator(words[1]);
  }

  private boolean isLegalOperator(String word) {
    return word.matches("[+]|[-]|[*]|[/]");
  }

  public boolean isLegalWord(String word) {
    for (int i = 0; i < word.length(); i += 1) {
      char letter = word.charAt(i);

      if (i == 0 && !(letter == '-' || Character.isDigit(letter))) {
        return false;
      }

      if (i >= 1 && !Character.isDigit(letter)) {
        return false;
      }
    }

    return true;
  }
}
