package pages;

public class GreetingPageGenerator extends PageGenerator {

  @Override
  public String content() {
    return "<h1>안녕하세요!</h1>\n" +
        "<a href =\"/login\">로그인</a>\n" +
        "<a href =\"/registration\">회원가입</a>\n";
  }
}
