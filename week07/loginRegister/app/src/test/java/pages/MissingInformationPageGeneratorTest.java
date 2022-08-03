package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingInformationPageGeneratorTest {
  @Test
  void html() {
    PageGenerator pageGenerator = new MissingInformationPageGenerator();

    String html = pageGenerator.html();

    assertTrue(html.contains("<h1>입력되지 않은 정보"), "타이틀 문제" + html);
    assertTrue(html.contains("되돌아가기"), "되돌아가는 메뉴 문제" + html);
  }
}
