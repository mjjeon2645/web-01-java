//    - 사용자는 하나의 숫자를 입력하면 입력한 숫자를 결과로 확인할 수 있다.
//    - 사용자는 단 한 개의 수식 연산만을 할 수 있다. ex) 1 + 1 + 1 (X)
//    - 사용자는 올바른 연산식을 입력한 경우 계속해서 계산기를 이용할 수 있다.
//    - 사용자는 올바르지 않은 수식의 경우 수식 오류 메세지를 확인할 수 있다.

public class ExpressionVaildator {

  public String exceptionExpression(String expression) {
    String[] words = expression.split(" ");


    if (words.length > 3 || words.length == 2) {
      return "수식 오류: " + expression;
    }
    if (words.length == 1) {
      if ((words[0].matches("-?[0-9]{1,5}"))) {
        return "Result: " + expression;
      }
    }
    if (!(words[0].matches("-?[0-9]{1,5}"))) {
      return "수식 오류: " + expression;
    }
    if (!(words[2].matches("-?[0-9]{1,5}"))) {
      return "수식 오류: " + expression;
    }
    String operator = words[1];

    if (!(operator.equals("+") ||
        operator.equals("-") ||
        operator.equals("*") ||
        operator.equals("/"))) {
      return "수식 오류: " + expression;
    }
    return "";
  }
}
