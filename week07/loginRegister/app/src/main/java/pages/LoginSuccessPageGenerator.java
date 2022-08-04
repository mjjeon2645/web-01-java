package pages;

public class LoginSuccessPageGenerator extends PageGenerator{

  private String name;

  public LoginSuccessPageGenerator(String name) {
    super();

    this.name = name;
  }

  @Override
  public String content() {
    return "<h1>마카오 뱅크.</h1>\n" +
        "<p>안녕하세요, " + name + "님! 행복을 적립하는 마카오뱅크입니다.\n";
  }
}
