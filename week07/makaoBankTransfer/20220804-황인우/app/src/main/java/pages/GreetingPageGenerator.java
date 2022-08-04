package pages;

public class GreetingPageGenerator extends PageGenerator {
  private String name;

  public GreetingPageGenerator() {
    this.name = "world";
  }

  public GreetingPageGenerator(String name) {
    super();

    if (name.isBlank()) {
      this.name = "world";
      return;
    }

    this.name = name;
  }

  @Override
  public String content() {
    return "<p>Hello, " + name + "!</p>\n";
  }
}
