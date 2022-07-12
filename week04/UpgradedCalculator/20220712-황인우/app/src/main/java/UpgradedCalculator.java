import utils.ExpressionValidityChecker;

import java.util.Scanner;

public class UpgradedCalculator {
  private final ExpressionValidityChecker expressionValidityChecker;

  public static void main(String[] args) {
    UpgradedCalculator application = new UpgradedCalculator();
    application.run();
  }

  public UpgradedCalculator() {
    this.expressionValidityChecker = new ExpressionValidityChecker();
  }

  public void run() {
    boolean isValidExpression = true;

    do {
      String expression = input();

      isValidExpression
          = expressionValidityChecker.checkValidity(expression);

      String result = "";

      if (isValidExpression) {
        result = compute(expression);
      } else {
        result = makeErrorMessage(expression);
      }

      print(result);

    } while (isValidExpression);
  }

  public String input() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input expression: ");

    return scanner.nextLine();
  }

  public String compute(String expression) {
    String[] words = expression.split(" ");

    int x = Integer.parseInt(words[0]);

    if (words.length == 1) {
      return makeResultMessage(x);
    }

    int y = Integer.parseInt(words[2]);
    String operator = words[1];

    int result = switch (operator) {
      case "+" -> x + y;
      case "-" -> x - y;
      case "*" -> x * y;
      case "/" -> x / y;
      default -> 0;
    };

    return makeResultMessage(result);
  }

  private String makeResultMessage(int result) {
    return "Result: " + result;
  }

  private String makeErrorMessage(String expression) {
    return "수식 오류: " + expression;
  }

  public void print(String result) {
    System.out.println(result);
  }
}
