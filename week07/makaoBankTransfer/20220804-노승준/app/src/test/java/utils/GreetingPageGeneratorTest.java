package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingPageGeneratorTest {
  @Test
  void defaultText() {
    PageGenerator messageGenerator = new GreetingPageGenerator();

    assertEquals("Hello, world!", messageGenerator.html());
  }

  @Test
  void textWithName() {
    PageGenerator messageGenerator = new GreetingPageGenerator("Ashal");

    assertEquals("Hello, Ashal!", messageGenerator.html());
  }

  @Test
  void textWithEmptyName() {
    PageGenerator messageGenerator = new GreetingPageGenerator("");

    assertEquals("Hello, world!", messageGenerator.html());
  }

  @Test
  void textWithBlankName() {
    PageGenerator messageGenerator = new GreetingPageGenerator("     ");

    assertEquals("Hello, world!", messageGenerator.html());
  }
}
