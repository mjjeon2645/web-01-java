package pages;

public class DuplicatedIdPageGenerator extends PageGenerator{

  @Override
  public String content() {
    return "<h1>이미 등록된 아이디입니다.</h1>\n" +
        "<a href =\"/registration\">되돌아가기</a>\n";
  }
}
