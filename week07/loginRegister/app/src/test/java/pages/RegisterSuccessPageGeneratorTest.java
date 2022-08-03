package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterSuccessPageGeneratorTest {
  @Test
  void html() {
    PageGenerator pageGenerator = new RegisterSuccessPageGenerator();

    String html = pageGenerator.html();

    assertTrue(html.contains("<h1>회원 가입이 완료"), "회원 가입 완료 타이틀 문제" + html);
    assertTrue(html.contains("로그인하기"), "로그인하기 메뉴 문제" + html);
  }
}
