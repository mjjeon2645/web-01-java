package utils;

public class GreetingPageGenerator extends PageGenerator{
  private String name;

  public GreetingPageGenerator() {
    name = "world";
  }

  public GreetingPageGenerator(String name) {
    if(name.isBlank()){
      this.name = "world";
      return;
    }

    this.name = name;
  }

  public String text() {
    return "Hello, " + name + "!";
  }

  @Override
  public String content() {
    return "Hello, " + name + "!";
  }
}
