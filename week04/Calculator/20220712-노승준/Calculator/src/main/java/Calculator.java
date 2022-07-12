import java.util.Scanner;

public class Calculator {
  private ExceptionCalculate exceptionCalculate;

  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public Calculator() {
    exceptionCalculate = new ExceptionCalculate();
  }

  public void run() {
    while (exceptionCalculate.isKeepCalculate()) {
      String expression = inputExpression();

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

    String exception = exceptionCalculate.exceptionHandling(text);

    if (exception.startsWith("수")) {
      return exception;
    }

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
