import java.util.*;

public class Calculator {
  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();

  }

  public void run() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input Expression: ");

    String expression = scanner.nextLine();

    compute(expression);

    System.out.println("Result: " + compute(expression));

  }

  public int compute(String expression) {
    String[] components = expression.split(" ");

    int number1 = Integer.parseInt(components[0]);
    int number2 = Integer.parseInt(components[2]);
    return switch (components[1]) {
      case "+" ->  number1 + number2;
      case "-" ->  number1 - number2;
      case "*" ->  number1 * number2;
      case "/" ->  number1 / number2;
      default -> 0;
    };
  }
}
