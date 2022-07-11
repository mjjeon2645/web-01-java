import org.checkerframework.checker.units.qual.*;

import java.util.*;

public class Calculator {
  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    //get ready
    Scanner scanner = new Scanner(System.in);

    //input
    System.out.print("Input Expression: ");

    String input = scanner.nextLine();

    //process(business logic)

    int result = compute(input);

    //result
    System.out.println("Result: " + result);

  }

  public int compute(String input) {
    // 0 , 1, 2 의 스플릿 문자 배열 생성     0, 2 => 숫자  1 은 연산자
    String[] inputComponents = input.split(" ");

    int number1 = Integer.valueOf(inputComponents[0]);
    int number2 = Integer.valueOf(inputComponents[2]);
    String operator = inputComponents[1];
    int result = 0;
    //조건식 생성

    switch(operator) {
      case "+" -> result = number1 + number2;
      case "-" -> result = number1 - number2;
      case "*" -> result = number1 * number2;
      case "/" -> result = number1 / number2;

    }
    return result;
  }
}
