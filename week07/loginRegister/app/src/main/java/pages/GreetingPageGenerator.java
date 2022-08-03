package pages;

public class GreetingPageGenerator extends PageGenerator {

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
        "<h1>안녕하세요!</h1>\n" +
        "<a href =\"/login\">로그인</a>\n" +
        "<a href =\"/registration\">회원가입</a>\n" +
        "</body>\n" +
        "</html>";
  }
}
