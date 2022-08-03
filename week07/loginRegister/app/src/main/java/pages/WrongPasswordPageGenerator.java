package pages;

public class WrongPasswordPageGenerator extends PageGenerator {

  @Override
  public String content() {
    return "<h1>비밀번호가 일치하지 않습니다. 다시 확인해주세요</h1>\n" +
        "<a href =\"/login\">되돌아가기</a>\n";
  }
}
