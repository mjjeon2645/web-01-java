package pages;

public class IdNotFoundPageGenerator extends PageGenerator{

  @Override
  public String content() {
    return "<h1>사용자를 찾을 수 없습니다. 다시 시도해주세요.</h1>\n" +
        "<a href =\"/login\">되돌아가기</a>\n";
  }
}
