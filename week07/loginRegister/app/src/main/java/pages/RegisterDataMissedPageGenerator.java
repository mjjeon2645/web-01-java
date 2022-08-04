package pages;

public class RegisterDataMissedPageGenerator extends PageGenerator{

  @Override
  public String content() {
    return "<h1>입력되지 않은 정보가 있습니다. 다시 확인해주세요.</h1>\n" +
        "<a href =\"/registration\">되돌아가기</a>\n";
  }
}
