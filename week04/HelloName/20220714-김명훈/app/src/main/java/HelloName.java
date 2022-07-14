import java.util.*;

public class HelloName {
  public static void main(String[] args) {
    HelloName application = new HelloName();
    application.run();
  }

  public void run() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("[HelloWorld]");
    System.out.println("What is your name?");
    String name = scanner.nextLine();

    MessageProvider messageProvider = new MessageProvider(name);
    System.out.println(messageProvider.message());
  }
}

