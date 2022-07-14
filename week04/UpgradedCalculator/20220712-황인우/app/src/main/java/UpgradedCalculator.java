import utils.ExpressionChecker;

import java.util.Scanner;

public class UpgradedCalculator {
  private final ExpressionChecker expressionChecker;

  public static void main(String[] args) {
    UpgradedCalculator application = new UpgradedCalculator();
    application.run();
  }

  public UpgradedCalculator() {
    expressionChecker = new ExpressionChecker();
  }

  public void run() {
    boolean isValidExpression = true;

    do {
      String expression = inputExpression();

      if (expression.equals("end")) {
        break;
      }

      isValidExpression = expressionChecker.checkValidity(expression);

      if (isValidExpression) {
        String result = compute(expression);

        displayMessage("Result: " + result);
      }
      if (!isValidExpression) {
        displayMessage("수식 오류: " + expression);
      }

    } while (isValidExpression);
  }

  public String inputExpression() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input expression: ");

    return scanner.nextLine();
  }

  public String compute(String expression) {
    String[] words = expression.split(" ");

    int x = Integer.parseInt(words[0]);

    if (words.length == 1) {
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

    return Integer.toString(result);
  }

  private void displayMessage(String message) {
    System.out.println(message);
  }
}
