package pages;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GreetingPageGeneratorTest {
  @Test
  void defaultText() {
    PageGenerator pageGenerator = new GreetingPageGenerator();
    String html = pageGenerator.html();
    assertTrue(html.contains("Hello world!"), "디폴트 텍스트 문제" + html);
  }

  @Test
  void textWithName() {
    PageGenerator pageGenerator = new GreetingPageGenerator("Ashal");
    String html = pageGenerator.html();
    assertTrue(html.contains("Hello Ashal!"), "이름있을때 문제" + html);
  }

  @Test
  void textWithBlank() {
    PageGenerator pageGenerator = new GreetingPageGenerator("  ");
    String html = pageGenerator.html();
    assertTrue(html.contains("Hello world!"), "빈칸일때 문제" + html);
  }
}
