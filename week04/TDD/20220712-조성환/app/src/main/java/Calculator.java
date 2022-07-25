import java.util.Scanner;

public class Calculator {
  public static void main(String[] args){
    Calculator application = new Calculator();
    application.run();
  }

  private void run() {
    String expression = inputExpression();

    int result = compute(expression);

    showResult(result);
  }

  private void showResult(int result) {
    System.out.println(result);
  }

  private String inputExpression() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input expression : ");

    return scanner.nextLine();
  }

  public int compute(String expression) {
    String[] words =expression.split(" ");

    int x = Integer.parseInt(words[0]);
    int y = Integer.parseInt(words[2]);
    String operator = words[1];

    return switch (operator){
      case "+" -> x + y;
      case "-" -> x - y;
      case "/" -> x / y;
      case "*" -> x * y;
      default -> 0;
    };
  }
}
