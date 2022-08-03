package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingPageGeneratorTest {
  @Test
  void defaultGreeting() {
    PageGenerator pageGenerator = new GreetingPageGenerator();

    String html = pageGenerator.html();

    assertTrue(
        html.contains("Hello, world!"),
        "html에 기본 인사 메세지 없음\n" + html);
  }

  @Test
  void greetingToSomebody() {
    PageGenerator pageGenerator = new GreetingPageGenerator("Lazenca");

    String html = pageGenerator.html();

    assertTrue(
        html.contains("Hello, Lazenca!"),
        "html에 주어진 대상에 대한 인사 메세지 없음\n" + html);
  }

  @Test
  void empty() {
    PageGenerator pageGenerator = new GreetingPageGenerator("");

    String html = pageGenerator.html();

    assertTrue(
        html.contains("Hello, world!"),
        "html에 빈칸 입력 시 출력되는 기본 인사 메세지 없음\n" + html);
  }

  @Test
  void blank() {
    PageGenerator pageGenerator = new GreetingPageGenerator("   \t\t\t\t\t\t");

    String html = pageGenerator.html();

    assertTrue(
        html.contains("Hello, world!"),
        "html에 공백문자 입력 시 출력되는 기본 인사 메세지 없음\n" + html);
  }
}
