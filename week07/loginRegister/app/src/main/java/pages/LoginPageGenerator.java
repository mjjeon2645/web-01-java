package pages;

public class LoginPageGenerator extends PageGenerator {

  @Override
  public String content() {
    return "<h1>로그인</h1>\n" +
        "<form method=\"POST\" enctype=\"test/plain\">" +
        "<p>" +
        "<label for=\"id\">아이디</label>\n" +
        "<input type=\"text\" name=\"id\" id=\"id\"/>\n " +
        "</p>" +
        "<p>" +
        "<label for=\"password\">비밀번호</label>\n" +
        "<input type=\"password\" name=\"password\" id=\"password\"/>\n " +
        "</p>\n" +
        "<button type=\"submit\">로그인</button>\n" +
        "</p>\n" +
        "</form>\n";
  }
}
