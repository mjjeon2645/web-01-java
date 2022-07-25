import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  private void run() {
    boolean isVaildExpression = true;

    while (isVaildExpression) {
      String expression = inputExpression();

      if (expression.equals("end")) {
        break;
      }

      ExpressionVaildator expressionVaildator = new ExpressionVaildator();

      isVaildExpression = expressionVaildator.checkExpression(expression);

      if(isVaildExpression){
        int result = compute(expression);
        System.out.println("Result: " + result);
      }
      if(!isVaildExpression){
        System.out.println("수식 오류: " + expression);
      }
    }
  }

  private String inputExpression() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Input expression: ");

    return scanner.nextLine();
  }

  public int compute(String expression) {
    String[] words = expression.split(" ");

    int x = Integer.parseInt(words[0]);

    if (words.length == 1) {
      return x;
    }

    int y = Integer.parseInt(words[2]);
    String operator = words[1];

    return switch (operator) {
      case "+" -> x + y;
      case "-" -> x - y;
      case "/" -> x / y;
      case "*" -> x * y;
      default -> 0;
    };
  }
}
