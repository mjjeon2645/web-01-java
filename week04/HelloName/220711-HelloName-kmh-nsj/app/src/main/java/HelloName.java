// 사용자의 관점 - 맥북 -> 헬로 월드 -> 승준 -> 바뀜
// test -> contructor parameter contain -> ok/ not contain -> ok
// -> instance 2

//main -> instance 1 -> 2 situation ok

// method 2 overload -> for fun nono ? making



import java.util.*;

public class HelloName {
  public static void main(String[] args) {
    HelloName application = new HelloName();
    application.run();
  }

  public void run() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("[Hello, world!]");

    System.out.println("What's your name?");

    String name = scanner.nextLine();

    MessageProvider messageProvider = new MessageProvider(name);

    System.out.println(messageProvider.message());
  }
}
