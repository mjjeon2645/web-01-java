package utils;

public class ExpressionValidator {
  public boolean process(String expression) {
    String[] words = expression.split(" ");

    if (words.length == 2 || words.length > 3) {
      return false;
    }

    String x = words[0];
    if (words.length == 1) {
      return isNumber(x);
    }

    String operator = words[1];
    if (!isOperator(operator)) {
      return false;
    }

    String y = words[2];
    boolean checkWords0 = isNumber(x);
    boolean checkWords2 = isNumber(y);

    return checkWords0 && checkWords2;
  }

  public boolean isNumber(String text) {
    for (int i = 0; i < text.length(); i += 1) {
      boolean isNumber = Character.isDigit(text.charAt(i));
      if (!isNumber) {
        return false;
      }
    }
    return true;
  }

  public boolean isOperator(String character) {
    String[] operators = {"+", "-", "*", "/"};
    for (String operator : operators) {
      if (operator.equals(character)) {
        return true;
      }
    }
    return false;
  }
}
