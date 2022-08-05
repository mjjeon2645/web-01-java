package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainPageGeneratorTest {
  @Test
  void html() {
    String name = "전민지";
    PageGenerator pageGenerator = new MainPageGenerator(name);

    String html = pageGenerator.html();

    assertTrue(html.contains("<h1>마카오 뱅크"), "타이틀 문제" + html);
    assertTrue(html.contains("<p>안녕하세요, " + name), "서브타이틀" + html);
  }
}
