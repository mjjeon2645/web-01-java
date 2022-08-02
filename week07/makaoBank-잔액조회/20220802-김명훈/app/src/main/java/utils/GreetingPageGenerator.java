package utils;

public class GreetingPageGenerator extends PageGenerator {
  private String name;

  public GreetingPageGenerator() {

      name = "world";
  }

  public GreetingPageGenerator(String name) {
    if(name.isBlank()) {
      name = "world";
    }
    this.name = name;
  }

  @Override
  public String content() {
    return "Hello, " + name + "!";
  }
}
