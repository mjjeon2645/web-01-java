package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdNotFoundPageGeneratorTest {
  @Test
  void html() {
    PageGenerator pageGenerator = new IdNotFoundPageGenerator();

    String html = pageGenerator.html();

    assertTrue(html.contains("<h1>사용자를 찾을 수"), "타이틀 문제" + html);
    assertTrue(html.contains("되돌아가기"), "되돌아가기 메뉴 문제" + html);
  }
}
