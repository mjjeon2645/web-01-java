package pages;

public class LoginPageGenerator extends PageGenerator {

  @Override
  public String content() {
    return "<h1>로그인</h1>\n" +
        "<form method=\"POST\">" +
        "<p>아이디</p>\n" +
        "<input type=\"text\" name=\"id\" />\n " +
        "<p>비밀번호</p>\n" +
        "<input type=\"text\" name=\"password\" />\n " +
        "<p>\n" +
        "<button type=\"submit\">로그인</button>\n" +
        "</p>\n" +
        "</form>\n";
  }
}
