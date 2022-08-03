package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingPageGeneratorTest {
  @Test
  void html() {
    PageGenerator pageGenerator = new GreetingPageGenerator();

    String html = pageGenerator.html();

    assertTrue(html.contains("<h1>안녕하세요!"), "메인 타이틀 문제" + html);
    assertTrue(html.contains("로그인"), "로그인 메뉴 문제" + html);
    assertTrue(html.contains("회원가입"), "회원가입 문제" + html);
  }
}
