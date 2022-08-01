package pages;

import org.junit.jupiter.api.Test;
import pages.GreetingPageGenerator;
import pages.PageGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GreetingPageGeneratorTest {
  @Test
  void defaultText() {
    PageGenerator pageGenerator = new GreetingPageGenerator();

    assertTrue(pageGenerator.html().contains("Hello, world"));
  }

  @Test
  void textWithName() {
    PageGenerator pageGenerator = new GreetingPageGenerator("sunghwan");

    assertTrue(pageGenerator.html().contains("Hello, sunghwan"));
  }

  @Test
  void textWithOut() {
    PageGenerator pageGenerator = new GreetingPageGenerator("");

    assertTrue(pageGenerator.html().contains("Hello, world"));
  }

  @Test
  void textWithBlank() {
    PageGenerator pageGenerator = new GreetingPageGenerator("     ");

    assertTrue(pageGenerator.html().contains("Hello, world"));
  }
}
