package utils;

public class ExpressionValidator {
  public boolean process(String expression) {
    if (expression.equals("")) {
      return false;
    }

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
    return isNumber(x) && isNumber(y);
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
