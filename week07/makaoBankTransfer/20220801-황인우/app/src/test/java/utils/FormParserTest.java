package utils;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FormParserTest {
  @Test
  void parse() {
    FormParser formParser = new FormParser();

    Map<String, String> formData = formParser.parse("to=179-20&amount=550000");

    assertEquals("179-20", formData.get("to"));
    assertEquals("550000", formData.get("amount"));
  }

  @Test
  void parseWithBlank() {
    FormParser formParser = new FormParser();

    Map<String, String> formData = formParser.parse("");

    assertNotNull(formData);
    assertTrue(formData.isEmpty());

    assertFalse(formData.containsKey("to"));
    assertFalse(formData.containsKey("amount"));
  }
}
