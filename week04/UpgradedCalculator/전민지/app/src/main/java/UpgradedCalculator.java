import utils.ExpressionValidator;

import java.util.Scanner;

public class UpgradedCalculator {
  private final ExpressionValidator expressionValidator;

  public static void main(String[] args) {
    UpgradedCalculator application = new UpgradedCalculator();
    application.run();
  }

  public UpgradedCalculator() {
    expressionValidator = new ExpressionValidator();
  }

  public void run() {
    boolean isValid = true;

    while (isValid) {
      String expression = inputExpression();

      if (expression.equals("end")) {
        break;
      }

      isValid = expressionValidator.process(expression);

      if (!isValid) {
        displayComputeErrorMessage(expression);
        break;
      }

      String result = compute(expression);

      displayComputeResultMessage(result);
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

  public void displayComputeErrorMessage(String expression) {
    System.out.println("수식 오류: " + expression);
  }

  public void displayComputeResultMessage(String result) {
    System.out.println(result);
  }
}
