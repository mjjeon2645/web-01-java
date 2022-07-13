import java.util.Scanner;

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

    System.out.println("Result: " + result);
  }

  public int compute(String text) {
    String[] words = text.split(" ");

    int x = Integer.parseInt(words[0]);

    if(words.length == 1) {
      return x;
    }

    int y = Integer.parseInt(words[2]);

    String operator = words[1];

    return switch (operator) {
      case "+" -> x + y;
      case "-" -> x - y;
      case "*" -> x * y;
      case "/" -> x / y;
      default -> 0;
    };
  }
}
