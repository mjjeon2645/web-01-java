package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SameIdPageGeneratorTest {
  @Test
  void content() {
    PageGenerator pageGenerator = new SameIdPageGenerator();

    String html = pageGenerator.html();

    assertTrue(html.contains("이미 등록된 아이디입니다"), "메시지 문제" + html);
    assertTrue(html.contains("되돌아가기"), "되돌아가기 링크 문제" + html);
  }
}
