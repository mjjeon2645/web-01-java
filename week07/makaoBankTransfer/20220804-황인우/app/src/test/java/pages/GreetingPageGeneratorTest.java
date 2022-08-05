package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GreetingPageGeneratorTest {
  @Test
  void defaultGreeting() {
    PageGenerator pageGenerator = new GreetingPageGenerator();

    String content = pageGenerator.content();

    assertTrue(
        content.contains("Hello, world!"),
        "기본 인사말 문제\n" + content);
  }

  @Test
  void greetingForSomebody() {
    PageGenerator pageGenerator = new GreetingPageGenerator("치코리타");

    String content = pageGenerator.content();

    assertTrue(
        content.contains("Hello, 치코리타!"),
        "특정인 인상 인사말 문제\n" + content);
  }

  @Test
  void blankGreeting() {
    PageGenerator pageGenerator = new GreetingPageGenerator("");

    String content = pageGenerator.content();

    assertTrue(
        content.contains("Hello, world!"),
        "빈칸 시 기본 인사말 출력 구조 오류 문제\n" + content);
  }

  @Test
  void emptyGreeting() {
    PageGenerator pageGenerator = new GreetingPageGenerator("\t    \t\t  \t \t");

    String content = pageGenerator.content();

    assertTrue(
        content.contains("Hello, world!"),
        "공백 시 기본 인사말 출력 구조 오류 문제\n" + content);
  }
}
