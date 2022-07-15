import java.util.Scanner;

public class Calculator {
  private ExpressionVerifier expressionVerifier;

  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public Calculator() {
    expressionVerifier = new ExpressionVerifier();
  }

  public void run() {
    boolean isRightExpression = true;

    while (isRightExpression) {
      String expression = inputExpression();

      if (expression.equals("end")) {
        break;
      }

      isRightExpression = expressionVerifier.handleException(expression);

      if (!isRightExpression) {
        displayWrongExpression(expression);
        break;
      }

      String result = compute(expression);

      displayResult(result);
    }
  }

  public String inputExpression() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input expression: ");

    String expression = scanner.nextLine();

    return expression;
  }

  public String compute(String text) {
    String[] words = text.split(" ");

    int x = Integer.parseInt(words[0]);

    if (words.length == 1) {
      return "Result: " + x;
    }

    int y = Integer.parseInt(words[2]);

    String operator = words[1];

    return switch (operator) {
      case "+" -> "Result: " + (x + y);
      case "-" -> "Result: " + (x - y);
      case "*" -> "Result: " + (x * y);
      case "/" -> "Result: " + (x / y);
      default -> "0";
    };
  }

  public void displayWrongExpression(String result) {
    System.out.println("수식 오류: " + result);
  }

  public void displayResult(String result) {
    System.out.println(result);
  }
}
