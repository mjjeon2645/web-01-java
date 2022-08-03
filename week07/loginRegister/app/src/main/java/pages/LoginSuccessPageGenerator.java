package pages;

public class LoginSuccessPageGenerator extends PageGenerator{

  @Override
  public String content() {
    //TODO. "메가" 영역에 account.name() 들어가야 함

    return "<h1>마카오 뱅크.</h1>\n" +
        "<p>안녕하세요, " + "메가" + "님! 행복을 적립하는 마카오뱅크입니다.\n";
  }
}
