import java.util.Scanner;

public class HelloWorld {
  public static void main(String[] args) {
    HelloWorld application = new HelloWorld();
    application.run();
  }

  public void run() {
    System.out.println("[Hello, world!]");
    System.out.println("What's your name?");

    Scanner scanner = new Scanner(System.in);

    String name = scanner.nextLine();

    MessageProvider messageProvider = new MessageProvider(name);
    System.out.println(messageProvider.message());
  }
}
