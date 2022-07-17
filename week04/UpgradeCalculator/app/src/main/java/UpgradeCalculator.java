import utils.ExpressionValidator;

import java.util.Scanner;

public class UpgradeCalculator {
  private final ExpressionValidator expressionValidator;

  public static void main(String[] args) {
    UpgradeCalculator application = new UpgradeCalculator();
    application.run();
  }

  public UpgradeCalculator() {
    expressionValidator = new ExpressionValidator();
  }

  public void run() {
    boolean isValid = true;

    while (isValid) {
      String expression = inputExpression();

      // validator 의 process 메소드로 유효성을 검사한 뒤 그 값을 isValid 에 할당
      isValid = expressionValidator.process(expression);

      if (!isValid) {
        showResultWithInvalidExpression(expression);
        break;
      }

      String result = compute(expression);

      showResultWithValidExpression(result);
    }
  }

  public String inputExpression() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input expression: ");

    String expression = scanner.nextLine();

    return expression;
  }

  public String compute(String expression) {
    String[] words = expression.split(" ");

    int result = 0;

    int x = Integer.parseInt(words[0]);

    if (words.length == 1) {
      result = Integer.parseInt(words[0]);
      return "Result: " + result;
    }

    int y = Integer.parseInt(words[2]);

    result = switch (words[1]) {
      case "+" -> x + y;
      case "-" -> x - y;
      case "*" -> x * y;
      case "/" -> x / y;
      default -> 0;
    };

    return "Result: " + result;
  }

  public void showResultWithInvalidExpression(String expression) {
    System.out.println("수식 오류: " + expression);
  }

  public void showResultWithValidExpression(String result) {
    System.out.println(result);
  }
}
