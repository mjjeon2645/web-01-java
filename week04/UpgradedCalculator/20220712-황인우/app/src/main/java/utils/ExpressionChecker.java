package utils;

public class ExpressionChecker {
  private static final String[] SUPPORTED_OPERATORS = {"+", "-", "*", "/"};

  public boolean checkValidity(String expression) {
    String[] words = expression.split(" ");

    if (words.length == 1 && isNumber(words[0])) {
      return true;
    }

    return words.length == 3
        && isNumber(words[0]) && isNumber(words[2])
        && isSupportedOperator(words[1]);
  }

  private boolean isSupportedOperator(String word) {
    for (String operator : SUPPORTED_OPERATORS) {
      if (word.equals(operator)) {
        return true;
      }
    }

    return false;
  }

  public boolean isNumber(String word) {
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
