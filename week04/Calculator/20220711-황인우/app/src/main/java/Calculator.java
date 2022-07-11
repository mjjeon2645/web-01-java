import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    String expression = input();

    int result = process(expression);

    print(result);
  }

  public String input() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("식을 입력하세요: ");

    return scanner.nextLine();
  }

  public int process(String expression) {
    String[] components = expression.split(" ");

    int number1 = Integer.parseInt(components[0]);
    int number2 = Integer.parseInt(components[2]);

    return number1 + number2;
  }

  public void print(int result) {
    System.out.println("결과: " + result);
  }
}
