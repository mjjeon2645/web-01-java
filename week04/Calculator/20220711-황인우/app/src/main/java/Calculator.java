import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    String expression = input();

    String result = process(expression);

    print(result);
  }

  public String input() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("식을 입력하세요: ");

    return scanner.nextLine();
  }

  public String process(String expression) {
    return "";
  }

  public void print(String result) {
    System.out.println("결과: " + result);
  }
}
