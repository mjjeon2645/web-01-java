package utils;

public class ExpressionValidator {
  public boolean process(String expression) {
    String[] words = expression.split(" ");

    // 1. split 결과 words의 길이가 2, 또는 3 초과인 케이스 쳐내기
    if (words.length == 2 || words.length > 3) {
      return false;
    }

    // 2. split 결과 words의 길이가 1인 것 중에서 valid / invalid 판별하기
    String x = words[0];

    if (words.length == 1) {
      for (int i = 0; i < x.length(); i += 1) {
        if (!Character.isDigit(x.charAt(i))) {
          return false;
        }
      }
      return true;
    }

    // 3. 배열 길이가 3인 것 중에서 words[1]이 사칙연산이 아닌 것 쳐내기
    String operator = words[1];

    if (!(operator.equals("+") || operator.equals("-") ||
        operator.equals("*") || operator.equals("/"))) {
      return false;
    }

    // 4. 배열 길이가 3인 것 중에서 words[0], words[2]의 valid / invalid 판별하기
    String y = words[2];

    boolean checkWords0 = checkNumber(x);
    boolean checkWords2 = checkNumber(y);

    return checkWords0 && checkWords2;
  }

  public boolean checkNumber(String text) {
    for (int i = 0; i < text.length(); i += 1) {
      boolean isNumber = Character.isDigit(text.charAt(i));
      if (!isNumber) {
        return false;
      }
    }
    return true;
  }
}
