package utils;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GreetingPageGeneratorTest {
  @Test
  void defaultText() {
    GreetingPageGenerator greetingPageGenerator = new GreetingPageGenerator();

    assertTrue(greetingPageGenerator.html().contains("Hello, world!"));

  }

  @Test
  void textWithName() {
    GreetingPageGenerator greetingPageGenerator = new GreetingPageGenerator("Ashal");

    assertTrue(greetingPageGenerator.html().contains("Hello, Ashal!"));
  }

  @Test
  void textWithAnotherCase() {
    GreetingPageGenerator greetingPageGenerator = new GreetingPageGenerator("Joker");

    assertTrue(greetingPageGenerator.html().contains("Hello, Joker!"));
  }

  @Test
  void textWithBlank() {
    GreetingPageGenerator greetingPageGenerator = new GreetingPageGenerator("");

    assertTrue(greetingPageGenerator.html().contains("Hello, world!"));
  }
}