package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WrongPasswordPageGeneratorTest {
  @Test
  void html() {
    PageGenerator pageGenerator = new WrongPasswordPageGenerator();

    String html = pageGenerator.html();

    assertTrue(html.contains("<h1>비밀번호가 일치"), "타이틀 문제" + html);
    assertTrue(html.contains("되돌아가기"), "되돌아가는 메뉴 문제" + html);
  }
}
