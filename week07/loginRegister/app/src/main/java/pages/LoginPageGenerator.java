package pages;

public class LoginPageGenerator extends PageGenerator {
  @Override
  public String html() {
    return "" +
        "<!DOCTYPE html>\n" +
        "<html lang=\"ko\">\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\">\n" +
        "<title>마카오 뱅크</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<h1>로그인</h1>\n" +
        "<form method=\"POST\">" +
        "<p>아이디</p>\n" +
        "<input type=\"text\" name=\"id\" />\n " +
        "<p>비밀번호</p>\n" +
        "<input type=\"text\" name=\"password\" />\n " +
        "<p>\n" +
        "<button type=\"submit\">로그인</button>\n" +
        "</p>\n" +
        "</form>\n" +
        "</body>\n" +
        "</html>";
  }
}
