package pages;

public class RegisterSuccessPageGenerator extends PageGenerator{

  @Override
  public String content() {
    return "<h1>회원 가입이 완료되었습니다.</h1>\n" +
        "<a href =\"/login\">로그인하기</a>\n";
  }
}
