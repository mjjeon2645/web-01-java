package pages;

public class RegisterPageGenerator extends PageGenerator {

  @Override
  public String content() {
    return "<h1>회원가입</h1>\n" +
        "<form method=\"POST\" enctype=\"text/plain\">\n" +
        "<p>\n" +
        "<label>이름 </label>\n" +
        "<input type=\"text\" name=\"name\" />\n" +
        "</p>\n" +
        "<p>\n" +
        "<label>아이디 </label>\n" +
        "<input type=\"text\" name=\"id\" />\n" +
        "</p>\n" +
        "<p>\n" +
        "<label>비밀번호 </label>\n" +
        "<input type=\"password\" name=\"password\" />\n" +
        "</p>\n" +
        "<p>\n" +
        "<label>비밀번호 재확인 </label>\n" +
        "<input type=\"password\" name=\"password-check\" />\n" +
        "</p>\n" +
        "<p>\n" +
        "<label>이메일 </label>\n" +
        "<input type=\"text\" name=\"email\" />\n" +
        "</p>\n" +
        "<button type=\"submit\">회원가입</button>\n" +
        "</form>";
  }
}
