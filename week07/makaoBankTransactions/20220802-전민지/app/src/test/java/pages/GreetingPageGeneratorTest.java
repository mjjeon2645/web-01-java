package pages;

import org.junit.jupiter.api.Test;
import pages.GreetingPageGenerator;
import pages.PageGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GreetingPageGeneratorTest {
  @Test
  void text() {
    PageGenerator pageGenerator = new GreetingPageGenerator();

    String html = pageGenerator.html();

    assertTrue(html.contains("Hello, world!"));
  }

  @Test
  void textWithName() {
    PageGenerator pageGenerator = new GreetingPageGenerator("Ashal");

    String html = pageGenerator.html();

    assertTrue(html.contains("Hello, Ashal!"));
  }

  @Test
  void textWithEmpty() {
    PageGenerator pageGenerator = new GreetingPageGenerator("");

    String html = pageGenerator.html();

    assertTrue(html.contains("Hello, world!"));
  }

  @Test
  void textWithBlank() {
    PageGenerator pageGenerator = new GreetingPageGenerator("    ");

    String html = pageGenerator.html();

    assertTrue(html.contains("Hello, world!"));
  }
}
