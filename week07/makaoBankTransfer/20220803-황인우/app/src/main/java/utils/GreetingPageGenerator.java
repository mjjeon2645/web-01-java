package utils;

public class GreetingPageGenerator extends PageGenerator {
  private String name;

  public GreetingPageGenerator() {
    name = "world";
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
