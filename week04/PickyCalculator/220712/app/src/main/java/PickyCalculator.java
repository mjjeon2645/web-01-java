//조건1 단 한개의 수식만 가능 -> 수식문자열의 길이는 항상 3
//조건2 중간문자열이 연산자중 어느것도 해당되지 않는다면 (1 1 1 방지)
//조건3 첫째와 셋째 문자열이 숫자인지 검사

//근데 오류조건을 모두 테스트 하는것보다 맞는 조건만 골라서 그외을 처리하는게 낫지 않나??
//반드시 주어진 어진 문자열은 숫자여야함 중간것은 사칙연산자여야함 문자열길이는 3개여야함

//숫자를 그대로 출력하는 식을 어느 관심사로 분류해야할까?
// 계산기의 목적  숫자를 그대로 보낸다 는 계산 자체보다는 우리가 자주 바꾸는 조건에 지나지 않음
// -> 조건의 일부의 관심사로 취급

import java.util.*;


public class PickyCalculator {
  private String expression;
  private String[] components;

  public static void main(String[] args) {
    PickyCalculator application = new PickyCalculator();
    application.run();
  }

  public void run() {
    Scanner scanner = new Scanner(System.in);

    System.out.print(inputExpression());

    typeExpression(scanner);

    while (testExpressionError(expression)) {

      if (isOneNumber(expression)) {
        System.out.println("Result: " + components[0]);

        System.out.print(inputExpression());

        expression = scanner.nextLine();

        continue;
      }


      int result = 0;

      result = compute(expression);

      System.out.println("Result: " + result);

      System.out.print(inputExpression());

      expression = scanner.nextLine();

    }

    System.out.print("수식 오류: " + expression);

  }

  private void typeExpression(Scanner scanner) {
    expression = scanner.nextLine();
  }

  private String inputExpression() {
    return "Input expression: ";
  }

  public int compute(String expression) {
    String[] components = getComponents(expression);

    return switch (components[1]) {
      case "+" ->
          Integer.parseInt(components[0]) + Integer.parseInt(components[2]);
      case "-" ->
          Integer.parseInt(components[0]) - Integer.parseInt(components[2]);
      case "*" ->
          Integer.parseInt(components[0]) * Integer.parseInt(components[2]);
      case "/" ->
          Integer.parseInt(components[0]) / Integer.parseInt(components[2]);

      default -> 0;
    };
  }

  public boolean testExpressionError(String expression) {
    String[] components = getComponents(expression);
    if (isOneNumber(expression)) {
      return true;
    }
    if (isOneOperator(expression)) {
      if (isNumeric(components[0]) && isNumeric(components[2])
          && isOperator(components[1])) {
        return true;
      }
    }
    return false;
  }

  public boolean isOneNumber(String expression) {
    String[] components = getComponents(expression);
    if (components.length == 1 && isNumeric(components[0])) {
      return true;
    }
    return false;
  }

  public boolean isNumeric(String stringNumber) {
    return stringNumber.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
  }

  public boolean isOperator(String operator) {
    return switch (operator) {
      case "+", "-", "*", "/" -> true;
      default -> false;
    };
  }

  public boolean isOneOperator(String expression) {
    if (getComponents(expression).length == 3) {
      return true;
    }
    return false;
  }

  public String[] getComponents(String expression) {
    components = expression.split(" ");
    return components;

  }
}
