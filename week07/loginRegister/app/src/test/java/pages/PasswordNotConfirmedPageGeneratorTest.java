package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordNotConfirmedPageGeneratorTest {
  @Test
  void html() {
    PageGenerator pageGenerator = new PasswordNotConfirmedPageGenerator();

    String html = pageGenerator.html();

    assertTrue(html.contains("<h1>입력하신 비밀번호"), "타이틀 문제" + html);
    assertTrue(html.contains("되돌아가기"), "되돌아가기 메뉴 문제" + html);
  }
}
