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
    while (expressionVerifier.isKeepCalculate()) {
      String expression = inputExpression();

      if (expression.equals("end")) {
        break;
      }

      String exception = expressionVerifier.exceptionHandling(expression);
      if (exception.startsWith("수")) {
        displayResult(exception);
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

  public void displayResult(String result) {
    System.out.println(result);
  }
}
