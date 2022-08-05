package utils;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FormParserTest {
  @Test
  void parse() {
    FormParser formParser = new FormParser();

    Map<String, String> formData = formParser.parse("to=179&amount=2500");

    assertEquals("179", formData.get("to"));
    assertEquals("2500", formData.get("amount"));
  }

  @Test
  void parseWithBlank() {
    FormParser formParser = new FormParser();

    Map<String, String> formData = formParser.parse("");

    assertNotNull(formData);

    assertFalse(formData.containsKey("to"));
    assertFalse(formData.containsKey("amount"));
  }
}
