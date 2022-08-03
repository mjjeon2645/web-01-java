package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingPageGeneratorTest {
  @Test
  void defaultText() {
    PageGenerator pageGenerator = new GreetingPageGenerator();

    String html = pageGenerator.html();

    assertTrue(html.contains("Hello, world"), "메시지 문제" + html);
  }

  @Test
  void HelloToYou() {
    PageGenerator pageGenerator = new GreetingPageGenerator("sunghwan");

    String html = pageGenerator.html();

    assertTrue(html.contains("Hello, sunghwan"), "메시지 문제" + html);
  }

  @Test
  void textWithEmpty() {
    PageGenerator pageGenerator = new GreetingPageGenerator("");

    String html = pageGenerator.html();

    assertTrue(html.contains("Hello, world"), "메시지 문제" + html);
  }

  @Test
  void textWithBlank() {
    PageGenerator pageGenerator = new GreetingPageGenerator("       ");

    String html = pageGenerator.html();

    assertTrue(html.contains("Hello, world"), "메시지 문제" + html);
  }
}