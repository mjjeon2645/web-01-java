public class MessageProvider {
  private String name;
  MessageProvider() {
    name = "world";
  }
  MessageProvider(String name) {
    this.name = name;
  }

  public String message() {
    return "Hello, " + name + "!";
  }
}
