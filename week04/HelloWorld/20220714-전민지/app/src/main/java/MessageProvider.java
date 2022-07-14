public class MessageProvider {

  private final String name;

  public MessageProvider() {
    this.name = "world";
  }

  public MessageProvider(String name) {
    this.name = name;
  }

  public String message() {
    return "Hello, " + name + "!";
  }
}
