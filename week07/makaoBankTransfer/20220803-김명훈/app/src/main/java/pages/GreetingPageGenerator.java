package pages;

public class GreetingPageGenerator extends PageGenerator {
  private String name;

  public GreetingPageGenerator(String name) {
    if(name.isBlank()) {
      name = "world";
    }
    this.name = name;
  }

  public GreetingPageGenerator() {
    name = "world";
  }

  @Override
  public String content() {
    return "Hello " + name + "!";
  }
}
