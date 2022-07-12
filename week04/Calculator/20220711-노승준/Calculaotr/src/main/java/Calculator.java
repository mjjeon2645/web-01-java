import java.util.Scanner;

public class Calculator {
  private boolean keepCalculate = true;

  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    while (keepCalculate) {
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

    if (words.length != 3) {
      if (words.length == 1) {
        if (words[0].matches("-?[0-9]")) {
          return "Result: " + text;
        }
      }
      stopCalculate();
      return displayWrongExpression(text);
    }

    if (!words[0].matches("-?[0-9]")) {
      stopCalculate();
      return displayWrongExpression(text);
    }

    int x = Integer.parseInt(words[0]);

    String operator = words[1];

    if (!(operator.equals("+") ||
        operator.equals("-") ||
        operator.equals("*") ||
        operator.equals("/"))) {
      stopCalculate();
      return displayWrongExpression(text);
    }

    int y = Integer.parseInt(words[2]);

    return calculate(text, x, operator, y);
  }

  public void stopCalculate() {
    keepCalculate = false;
  }

  public String displayWrongExpression(String text) {
    return "수식 오류: " + text;
  }

  public String calculate(String text, int x, String operator, int y) {
    return switch (operator) {
      case "+" -> "Result: " + (x + y);
      case "-" -> "Result: " + (x - y);
      case "*" -> "Result: " + (x * y);
      case "/" -> "Result: " + (x / y);
      default -> displayWrongExpression(text);
    };
  }

  public void displayResult(String result) {
    System.out.println(result);
  }
}
