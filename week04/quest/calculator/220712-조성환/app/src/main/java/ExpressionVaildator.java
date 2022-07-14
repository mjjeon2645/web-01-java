//    - 사용자는 하나의 숫자를 입력하면 입력한 숫자를 결과로 확인할 수 있다.
//    - 사용자는 단 한 개의 수식 연산만을 할 수 있다. ex) 1 + 1 + 1 (X)
//    - 사용자는 올바른 연산식을 입력한 경우 계속해서 계산기를 이용할 수 있다.
//    - 사용자는 올바르지 않은 수식의 경우 수식 오류 메세지를 확인할 수 있다.
public class ExpressionVaildator {
  public boolean expressionCheck(String expression) {
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
    boolean checkword1 = isNumber(x);
    boolean checkword2 = isNumber(y);

    return checkword1 && checkword2;
  }

  public boolean operatorCheck(String operator) {
    return operator.equals("+") ||
        operator.equals("-") ||
        operator.equals("*") ||
        operator.equals("/");

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
