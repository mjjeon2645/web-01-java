package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingPageGeneratorTest {
  @Test
  void defaultMessage() {
    PageGenerator pageGenerator = new GreetingPageGenerator();

    String html = pageGenerator.html();

    assertTrue(html.contains("Hello, world!"), "html의 이름 출력 잘못됨\n" + html);
  }

  @Test
  void messageWithName() {
    PageGenerator pageGenerator = new GreetingPageGenerator(
        "King God General Emperor Chungmugong Majesty Maestro Innu Sama");

    String html = pageGenerator.html();

    assertTrue(
        html.contains("Hello, King God General Emperor Chungmugong Majesty Maestro Innu Sama!")
        , "html의 이름 출력 잘못됨\n" + html);
  }

  @Test
  void messageWithEmpty() {
    PageGenerator pageGenerator = new GreetingPageGenerator("");

    String html = pageGenerator.html();

    assertTrue(html.contains("Hello, world!"), "html의 이름 출력 잘못됨\n" + html);
  }

  @Test
  void messageWithBlank() {
    PageGenerator pageGenerator = new GreetingPageGenerator(
        "    \t              \t\t  \t    ");

    String html = pageGenerator.html();

    assertTrue(html.contains("Hello, world!"), "html의 이름 출력 잘못됨\n" + html);
  }
}
