import org.checkerframework.checker.units.qual.*;

import java.util.*;

public class Calculator {
  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input expression: ");
    String expression = scanner.nextLine();

    int result = compute(expression);

    System.out.print("Result: " + result);
  }

  public int compute(String expression) {
    String[] expressionSpliter = expression.split(" ");
    int number1 = Integer.parseInt(expressionSpliter[0]);
    int number2 = Integer.parseInt(expressionSpliter[2]);
    String operator = expressionSpliter[1];

    return switch (operator) {
      case "+" -> number1 + number2;
      case "-" -> number1 - number2;
      case "*" -> number1 * number2;
      case "/" -> number1 / number2;
      default -> 0;
    };

  }
}
