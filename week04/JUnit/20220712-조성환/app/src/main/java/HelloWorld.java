

import java.util.Scanner;

public class HelloWorld {
  private MessageProvider messageProvider;

  public static void main(String[] args) {
    HelloWorld application = new HelloWorld();
    application.run();
  }

  private void run() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("[HelloWorld]");
    System.out.println("what's your name");

    String name = scanner.nextLine();

    messageProvider = new MessageProvider(name);

    System.out.println(messageProvider.message());
  }
}
