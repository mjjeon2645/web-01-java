package pages;

public class PasswordNotConfirmedPageGenerator extends PageGenerator{

  @Override
  public String content() {
    return "<h1>입력하신 비밀번호가 서로 일치하지 않습니다. 다시 확인해주세요.</h1>\n" +
        "<a href =\"/registration\">되돌아가기</a>\n";
  }
}
