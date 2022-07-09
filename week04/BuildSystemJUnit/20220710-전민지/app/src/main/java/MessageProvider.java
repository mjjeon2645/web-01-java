public class MessageProvider {
  private String name;
  public MessageProvider(String name) {
    this.name = name;
  }

  public MessageProvider() {
    this.name = "world";
  }

  public String message() {
    return "Hello, " + name + "!";
  }
}
