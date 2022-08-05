package pages;

public class RegisterPageGenerator extends PageGenerator {

  @Override
  public String content() {
    return "<h1>회원가입</h1>\n" +
        "<form method=\"POST\" enctype=\"text/plain\">\n" +
        "<p>\n" +
        "<label for=\"name\">이름 </label>\n" +
        "<input type=\"text\" name=\"name\" id=\"name\" />\n" +
        "</p>\n" +
        "<p>\n" +
        "<label for=\"id\">아이디 </label>\n" +
        "<input type=\"text\" name=\"id\" id=\"id\" />\n" +
        "</p>\n" +
        "<p>\n" +
        "<label for=\"password\">비밀번호 </label>\n" +
        "<input type=\"password\" name=\"password\" id=\"password\" />\n" +
        "</p>\n" +
        "<p>\n" +
        "<label for=\"=check-password\">비밀번호 재확인 </label>\n" +
        "<input type=\"password\" name=\"check-password\" id=\"check-password\" />\n" +
        "</p>\n" +
        "<p>\n" +
        "<label for=\"email\">이메일 </label>\n" +
        "<input type=\"text\" name=\"email\" id=\"email\" />\n" +
        "</p>\n" +
        "<button type=\"submit\">회원가입</button>\n" +
        "</form>";
  }
}
