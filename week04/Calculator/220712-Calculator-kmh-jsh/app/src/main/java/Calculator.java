import java.util.*;

public class Calculator {
  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    //ready
    String expression = inputExpression();

    //process
    int result = compute(expression);

    //output
    showResult(result);
  }

  public void showResult(int result) {
    System.out.println("Result: " + result);
  }

  public String inputExpression() {
    Scanner scanner = new Scanner(System.in);

    //input
    System.out.print("Input Expression: ");

    String expression = scanner.nextLine();
    return expression;
  }

  public int compute(String expression) {
    String[] words = expression.split(" ");
    int x = Integer.parseInt(words[0]);
    int y = Integer.parseInt(words[2]);
    String operator = words[1];

    return switch(operator) {
      case "+" -> x + y;
      case "-" -> x - y;
      case "*" -> x * y;
      case "/" -> x / y;
      default -> 0;
    };

//    if(operator.equals("+")) {
//      return x + y;
//    }
//    if(operator.equals("-")) {
//      return x - y;
//    }
//    if(operator.equals("*")) {
//      return x * y;
//    }
//    if(operator.equals("/")) {
//      return x / y;
//    }
//      return 0;
  }
}
