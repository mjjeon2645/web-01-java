package pages;

public class RegisterPageGenerator extends PageGenerator {
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
        "<h1>회원가입</h1>\n" +
        "<form method=\"POST\">" +
        "<p>이름</p>\n" +
        "<input type=\"text\" name=\"name\" />\n " +
        "<p>아이디</p>\n" +
        "<input type=\"text\" name=\"id\" />\n " +
        "<p>비밀번호</p>\n" +
        "<input type=\"text\" name=\"password\" />\n " +
        "<p>비밀번호 재확인</p>\n" +
        "<input type=\"text\" name=\"password-again\" />\n " +
        "<p>이메일</p>\n" +
        "<input type=\"text\" name=\"email\" />\n " +
        "<p>\n" +
        "<button type=\"submit\">회원가입</button>\n" +
        "</p>\n" +
        "</form>\n" +
        "</body>\n" +
        "</html>";
  }
}
