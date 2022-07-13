import utils.ExpressionValidityChecker;

import java.util.Scanner;

public class UpgradedCalculator {
  private ExpressionValidityChecker expressionValidityChecker;

  public static void main(String[] args) {
    UpgradedCalculator application = new UpgradedCalculator();
    application.run();
  }

  public void run() {
    boolean isValidExpression = true;

    do {
      String expression = input();

      if (expression.equals("end")) {
        break;
      }

      expressionValidityChecker = new ExpressionValidityChecker(expression);

      isValidExpression
          = expressionValidityChecker.checkValidity();

      if (isValidExpression) {
        compute(expression);
      }
      if (!isValidExpression) {
        makeErrorMessage(expression);
      }

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
      printResult("Result: " + x);
      return Integer.toString(x);
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

    printResult("Result: " + result);
    return Integer.toString(result);
  }

  private void makeErrorMessage(String expression) {
    printResult("수식 오류: " + expression);
  }

  public void printResult(String result) {
    System.out.println(result);
  }
}
