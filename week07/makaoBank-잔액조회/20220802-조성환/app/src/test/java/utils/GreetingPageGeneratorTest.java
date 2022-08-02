package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingPageGeneratorTest {
  @Test
  void defaultMessage() {
    PageGenerator pageGenerator = new GreetingPageGenerator();

    assertEquals("Hello, world!", pageGenerator.html());
  }

  @Test
  void textWithName() {
    PageGenerator pageGenerator = new GreetingPageGenerator("sunghwan");

    assertEquals("Hello, sunghwan!", pageGenerator.html());
  }

  @Test
  void textWithEmpty() {
    PageGenerator pageGenerator = new GreetingPageGenerator("");

    assertEquals("Hello, world!", pageGenerator.html());
  }

  @Test
  void textWithBlank() {
    PageGenerator pageGenerator = new GreetingPageGenerator("      ");

    assertEquals("Hello, world!", pageGenerator.html());
  }
}
