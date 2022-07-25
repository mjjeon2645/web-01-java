import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    // 준비, 입력
    String expression = inputExpression();

    // 처리
    String result = compute(expression);

    // 결과
    showResult(result);
  }

  public String inputExpression() {
    Scanner scanner = new Scanner(System.in);

    showResult("Input expression: ");

    String expression = scanner.nextLine();

    return expression;
  }

  public String compute(String expression) {
    String[] words = expression.split(" ");

    // 수식 오류 1차 필터링(배열의 길이가 1, 또는 3이 아닌 모든 배열 제외)
    if (words.length > 3 || words.length == 2) {
      return "수식 오류: " + expression;
    }

    // 배열 길이가 1인 것 중에서 숫자인 것만 정상 처리, 나머지는 오류
    boolean isNumber = true;

    if (words.length == 1) {
      for (int i = 0; i < words[0].length(); i += 1) {
        isNumber = Character.isDigit(words[0].charAt(i));

        if (isNumber == false) {
          return "수식 오류: " + expression;
        }
      }
      return "Result: " + expression;
    }

    // 배열 길이가 3인 것 중에서 words[1]이 사칙연산이 아닌것 먼저 쳐내기
    if (!words[1].equals("+")
        && !words[1].equals("-")
        && !words[1].equals("*")
        && !words[1].equals("/")) {
      return "수식 오류: " + expression;
    }

    // 배열 길이가 3인 것 중에서 words[0], words[2]가 숫자가 아닌 것 쳐내기
    isNumber = true;

    for (int i = 0; i < words[0].length(); i += 1) {
      isNumber = Character.isDigit(words[0].charAt(i));

      if (isNumber == false) {
        return "수식 오류: " + expression;
      }
    }

    isNumber = true;
    for (int i = 0; i < words[2].length(); i += 1) {
      isNumber = Character.isDigit(words[2].charAt(i));

      if(isNumber == false) {
        return "수식 오류: " + expression;
      }
    }

    int x = Integer.parseInt(words[0]);
    int y = Integer.parseInt(words[2]);

    int result = switch (words[1]) {
      case "+" -> x + y;
      case "-" -> x - y;
      case "*" -> x * y;
      case "/" -> x / y;
      default -> 0;
    };

    return "Result: " + result;
  }

  public void showResult(String result) {
    System.out.println(result);
  }
}
