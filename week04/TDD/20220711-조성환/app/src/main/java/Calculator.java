import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    calculator.run();
  }

  private void run() {
    //준비
    String expression = inputExpression();
    //처리
    int result = compute(expression);
    //출력
    print(result);
  }

  public void print(int result) {
    System.out.println("Result " + result);
  }

  public String inputExpression() {
    Scanner scanner = new Scanner(System.in);

    //입력
    System.out.print("Input expression: ");

    String expression = scanner.nextLine();
    return expression;
  }

  public int compute(String expression) {
    String[] words = expression.split(" ");

    int x = Integer.parseInt(words[0]);
    int y =Integer.parseInt(words[2]);
    String operator = words[1];

    return switch(operator) {
      case "+" -> x + y;
      case "-" -> x - y;
      case "*" -> x * y;
      case "/" -> x / y;
      default -> 0;
    };
  }
}
