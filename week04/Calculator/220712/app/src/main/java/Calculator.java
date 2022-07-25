import java.util.*;

public class Calculator {
  private String[] expressionComponents;
  int result;
  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    //ready
    Scanner scanner = new Scanner(System.in);

    System.out.print("Input Expression: ");

    String expression = scanner.nextLine();

    divideExpression(expression);

    compute();

    System.out.println("Result: " + result);



  }

  public void divideExpression(String expression) {
    expressionComponents = expression.split(" ");
  }

  public String expressionComponent(int componentNumber) {
    return expressionComponents[componentNumber];
  }

  public int compute() {
    result = 0;

    if (expressionComponent(1).equals("+")) {
      result = Integer.parseInt(expressionComponent(0)) +
          Integer.parseInt(expressionComponent(2));
    }

    if (expressionComponent(1).equals("-")) {
      result = Integer.parseInt(expressionComponent(0)) -
          Integer.parseInt(expressionComponent(2));
    }

    if (expressionComponent(1).equals("*")) {
      result = Integer.parseInt(expressionComponent(0)) *
          Integer.parseInt(expressionComponent(2));
    }

    if (expressionComponent(1).equals("/")) {
      result = Integer.parseInt(expressionComponent(0)) /
          Integer.parseInt(expressionComponent(2));
    }
  return result;}
}


