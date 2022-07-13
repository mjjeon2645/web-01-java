import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    // 준비, 입력
    Scanner scanner = new Scanner(System.in);

    System.out.println("Input expression: ");

    String expression = scanner.nextLine();

    // 처리
    int result = compute(expression);

    // 출력
    System.out.println("Result: " + result);
  }

  public int compute(String expression) {
    String[] words = expression.split(" ");
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
