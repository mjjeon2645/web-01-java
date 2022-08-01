package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingPageGeneratorTest {
  @Test
  void defaultText() {
    PageGenerator pageGenerator = new GreetingPageGenerator();

    String html = pageGenerator.html();

    assertTrue(html.contains("Hello, world!"), "html에 인사말 없음\n" + html);
  }

  @Test
  void textWithName() {
    PageGenerator pageGenerator = new GreetingPageGenerator("Chikorita");

    String html = pageGenerator.html();

    assertTrue(html.contains("Hello, Chikorita!"), "html에 인사말 없음\n" + html);
  }

  @Test
  void emptyText() {
    PageGenerator pageGenerator = new GreetingPageGenerator("");

    String html = pageGenerator.html();

    assertTrue(html.contains("Hello, world!"), "html에 인사말 없음\n" + html);
  }

  @Test
  void blankText() {
    PageGenerator pageGenerator = new GreetingPageGenerator("      \t   ");

    String html = pageGenerator.html();

    assertTrue(html.contains("Hello, world!"), "html에 인사말 없음\n" + html);
  }
}
