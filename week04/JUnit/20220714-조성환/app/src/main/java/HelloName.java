import java.util.Scanner;

public class HelloName {
  private MessageProvider messageProvider;

  public static void main(String[] args) {
    HelloName application = new HelloName();
    application.run();
  }

  private void run() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("[HelloWorld]");
    System.out.println("what'your name?");

    String name = scanner.nextLine();

    messageProvider = new MessageProvider(name);

    System.out.println(messageProvider.message());
  }
}
