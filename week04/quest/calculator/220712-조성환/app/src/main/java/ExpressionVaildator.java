public class ExpressionVaildator {
  private String[] operators = {"+", "-", "/", "*"};

  public boolean checkExpression(String expression) {
    String[] words = expression.split(" ");

    if (words.length > 3 || words.length == 2) {
      return false;
    }

    String x = words[0];
    if (words.length == 1) {
      return isNumber(x);
    }
    String operator = words[1];
    if (!operatorCheck(operator)) {
      return false;
    }

    String y = words[2];

    return isNumber(x) && isNumber(y);
  }

  public boolean operatorCheck(String character2) {
    for (String operator : operators) {
      if (!character2.equals(operator)) {
        return false;
      }
    }
    return true;
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
}
