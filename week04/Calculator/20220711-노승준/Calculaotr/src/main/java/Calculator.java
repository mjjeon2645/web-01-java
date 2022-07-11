import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    String expression = inputExpression();

    int result = compute(expression);

    if (result == 0) {
      displayWrongResult(expression);
    }

    if (result != 0) {
      displayResult(result);
    }
  }

  public String inputExpression() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input expression: ");

    String expression = scanner.nextLine();

    return expression;
  }

  public int compute(String text) {
    String[] words = text.split(" ");

    if (words.length != 3) {
      if(words.length == 1) {
        if(words[0].matches("[0-9]")){
          return Integer.parseInt(words[0]);
        }
      }
      return 0;
    }

    if(!words[0].matches("[0-9]")){
      return 0;
    }

    int x = Integer.parseInt(words[0]);

    String operator = words[1];

    if (!(operator.equals("+") ||
        operator.equals("-") ||
        operator.equals("*") ||
        operator.equals("/"))) {
      return 0;
    }

    int y = Integer.parseInt(words[2]);

    return switch (operator) {
      case "+" -> x + y;
      case "-" -> x - y;
      case "*" -> x * y;
      case "/" -> x / y;
      default -> 0;
    };
  }

  public void displayWrongResult(String expression) {
    System.out.println("수식 오류: " + expression);
  }

  public void displayResult(int result) {
    System.out.println("Result: " + result);
  }
}
