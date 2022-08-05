package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GreetingPageGeneratorTest {
  @Test
  void defaultMessage() {
    PageGenerator pageGenerator = new GreetingPageGenerator();

    assertTrue(pageGenerator.html().contains("Hello, world!"));
  }

  @Test
  void textWithName() {
    PageGenerator pageGenerator = new GreetingPageGenerator("sunghwan");

    assertTrue(pageGenerator.html().contains("Hello, sunghwan!"));
  }

  @Test
  void textWithEmpty() {
    PageGenerator pageGenerator = new GreetingPageGenerator("");

    assertTrue(pageGenerator.html().contains("Hello, world!"));
  }

  @Test
  void textWithBlank() {
    PageGenerator pageGenerator = new GreetingPageGenerator("      ");

    assertTrue(pageGenerator.html().contains("Hello, world!"));
  }
}
