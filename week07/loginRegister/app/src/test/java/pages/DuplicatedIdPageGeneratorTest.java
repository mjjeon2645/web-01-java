package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicatedIdPageGeneratorTest {
  @Test
  void html() {
    PageGenerator pageGenerator = new DuplicatedIdPageGenerator();

    String html = pageGenerator.html();

    assertTrue(html.contains("<h1>이미 등록된 아이디"), "타이틀 문제" + html);
    assertTrue(html.contains("되돌아가기"), "되돌아가기 메뉴 문제" + html);
  }
}
